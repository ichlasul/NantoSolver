/*
 * The MIT License
 * 
 * Copyright (c) 2011 John Svazic
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.auxesia;

import java.util.Arrays;
import java.util.Random;

/**
 * Class representing a population for a genetic algorithm simulation.
 * 
 * A population is simply a sorted collection of <code>Chromosome</code>s
 * (sorted by fitness) that has a convenience method for evolution. This
 * implementation of a population uses a tournament selection algorithm for
 * selecting parents for crossover during each generation's evolution.
 * 
 * Note that this object is mutable, and calls to the <code>evolve()</code>
 * method will change the collection of <code>Chromosome</code>s.
 * 
 * @author John Svazic
 * @version 1.0
 */
public class Population {

  /** The size of the tournament. */
  private static final int TOURNAMENT_SIZE = 3;

  /** Convenience randomizer. */
  private static final Random rand = new Random(System.currentTimeMillis());

  private final float elitism;
  private final float mutation;
  private final float crossover;
  private Chromosome[] popArr;

  /**
   * Default constructor.
   * 
   * @param size
   *          The size of the population, where size > 0.
   * @param crossoverRatio
   *          The crossover ratio for the population during evolution, where 0.0
   *          <= crossoverRatio <= 1.0.
   * @param elitismRatio
   *          The elitism ratio for the population during evolution, where 0.0
   *          <= elitismRatio < 1.0.
   * @param mutationRatio
   *          The mutation ratio for the population during evolution, where 0.0
   *          <= mutationRatio <= 1.0.
   * 
   * @throws IllegalArgumentException
   *           Thrown if an invalid ratio is given.
   */
  public Population(final int size, final float crossoverRatio,
      final float elitismRatio, final float mutationRatio) {

    this.crossover = crossoverRatio;
    this.elitism = elitismRatio;
    this.mutation = mutationRatio;

    // Generate an initial population
    this.popArr = new Chromosome[size];
    for (int i = 0; i < size; i++) {
      this.popArr[i] = Chromosome.generateRandom();
    }

    Arrays.sort(this.popArr);
  }

  /**
   * Method used to evolve the population.
   */
  public void evolve() {
    // Create a buffer for the new generation
    final Chromosome[] buffer = new Chromosome[this.popArr.length];

    // Copy over a portion of the population unchanged, based on
    // the elitism ratio.
    int idx = Math.round(this.popArr.length * this.elitism);
    System.arraycopy(this.popArr, 0, buffer, 0, idx);

    // Iterate over the remainder of the population and evolve as
    // appropriate.
    while (idx < buffer.length) {
      // Check to see if we should perform a crossover.
      if (Population.rand.nextFloat() <= this.crossover) {

        // Select the parents and mate to get their children
        final Chromosome[] parents = this.selectParents();
        final Chromosome[] children = parents[0].mate(parents[1]);

        // Check to see if the first child should be mutated.
        if (Population.rand.nextFloat() <= this.mutation) {
          buffer[idx++] = children[0].mutate();
        } else {
          buffer[idx++] = children[0];
        }

        // Repeat for the second child, if there is room.
        if (idx < buffer.length) {
          if (Population.rand.nextFloat() <= this.mutation) {
            buffer[idx] = children[1].mutate();
          } else {
            buffer[idx] = children[1];
          }
        }
      } else { // No crossover, so copy verbatium.
        // Determine if mutation should occur.
        if (Population.rand.nextFloat() <= this.mutation) {
          buffer[idx] = this.popArr[idx].mutate();
        } else {
          buffer[idx] = this.popArr[idx];
        }
      }

      // Increase our counter
      ++idx;
    }

    // Sort the buffer based on fitness.
    Arrays.sort(buffer);

    // Reset the population
    this.popArr = buffer;
  }

  /**
   * Method used to retrieve a copy of the current population. This method
   * returns a copy of the population at the time the method was called.
   * 
   * @return A copy of the population.
   */
  public Chromosome[] getPopulation() {
    final Chromosome[] arr = new Chromosome[this.popArr.length];
    System.arraycopy(this.popArr, 0, arr, 0, this.popArr.length);

    return arr;
  }

  /**
   * Method to retrieve the elitism ratio for the population.
   * 
   * @return The elitism ratio.
   */
  public float getElitism() {
    return this.elitism;
  }

  /**
   * Method to retrieve the crossover ratio for the population.
   * 
   * @return The crossover ratio.
   */
  public float getCrossover() {
    return this.crossover;
  }

  /**
   * Method to retrieve the mutation ratio for the population.
   * 
   * @return The mutation ratio.
   */
  public float getMutation() {
    return this.mutation;
  }

  /**
   * A helper method that can be used to select two random parents from the
   * population to use in crossover during evolution.
   * 
   * @return Two randomly selected <code>Chromsomes</code> for crossover.
   */
  private Chromosome[] selectParents() {
    final Chromosome[] parents = new Chromosome[2];

    // Randomly select two parents via tournament selection.
    for (int i = 0; i < 2; i++) {
      parents[i] = this.popArr[Population.rand.nextInt(this.popArr.length)];
      for (int j = 0; j < Population.TOURNAMENT_SIZE; j++) {
        final int idx = Population.rand.nextInt(this.popArr.length);
        if (this.popArr[idx].compareTo(parents[i]) < 0) {
          parents[i] = this.popArr[idx];
        }
      }
    }

    return parents;
  }
}