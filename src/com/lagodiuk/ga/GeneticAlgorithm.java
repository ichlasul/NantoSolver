/*******************************************************************************
 * Copyright 2012 Yuriy Lagodiuk
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.lagodiuk.ga;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class GeneticAlgorithm<C extends Chromosome<C>, T extends Comparable<T>> {

  private static final int ALL_PARENTAL_CHROMOSOMES = Integer.MAX_VALUE;

  private class ChromosomesComparator implements Comparator<C> {

    private final Map<C, T> cache = new WeakHashMap<C, T>();

    @Override
    public int compare(final C chr1, final C chr2) {
      final T fit1 = this.fit(chr1);
      final T fit2 = this.fit(chr2);
      final int ret = fit1.compareTo(fit2);
      return ret;
    }

    public T fit(final C chr) {
      T fit = this.cache.get(chr);
      if (fit == null) {
        fit = GeneticAlgorithm.this.fitnessFunc.calculate(chr);
        this.cache.put(chr, fit);
      }
      return fit;
    };

    public void clearCache() {
      this.cache.clear();
    }
  }

  private final ChromosomesComparator chromosomesComparator;

  private final Fitness<C, T> fitnessFunc;

  private Population<C> population;

  // listeners of genetic algorithm iterations (handle callback afterwards)
  private final List<IterartionListener<C, T>> iterationListeners = new LinkedList<IterartionListener<C, T>>();

  private boolean terminate = false;

  // number of parental chromosomes, which survive (and move to new
  // population)
  private int parentChromosomesSurviveCount = GeneticAlgorithm.ALL_PARENTAL_CHROMOSOMES;

  private int iteration = 0;

  public GeneticAlgorithm(final Population<C> population,
      final Fitness<C, T> fitnessFunc) {
    this.population = population;
    this.fitnessFunc = fitnessFunc;
    this.chromosomesComparator = new ChromosomesComparator();
    this.population.sortPopulationByFitness(this.chromosomesComparator);
  }

  public void evolve() {
    final int parentPopulationSize = this.population.getSize();

    final Population<C> newPopulation = new Population<C>();

    for (int i = 0; (i < parentPopulationSize)
        && (i < this.parentChromosomesSurviveCount); i++) {
      newPopulation.addChromosome(this.population.getChromosomeByIndex(i));
    }

    for (int i = 0; i < parentPopulationSize; i++) {
      final C chromosome = this.population.getChromosomeByIndex(i);
      final C mutated = chromosome.mutate();

      final C otherChromosome = this.population.getRandomChromosome();
      final List<C> crossovered = chromosome.crossover(otherChromosome);

      newPopulation.addChromosome(mutated);
      for (final C c : crossovered) {
        newPopulation.addChromosome(c);
      }
    }

    newPopulation.sortPopulationByFitness(this.chromosomesComparator);
    newPopulation.trim(parentPopulationSize);
    this.population = newPopulation;
  }

  public void evolve(final int count) {
    this.terminate = false;

    for (int i = 0; i < count; i++) {
      if (this.terminate) {
        break;
      }
      this.evolve();
      this.iteration = i;
      for (final IterartionListener<C, T> l : this.iterationListeners) {
        l.update(this);
      }
    }
  }

  public int getIteration() {
    return this.iteration;
  }

  public void terminate() {
    this.terminate = true;
  }

  public Population<C> getPopulation() {
    return this.population;
  }

  public C getBest() {
    return this.population.getChromosomeByIndex(0);
  }

  public C getWorst() {
    return this.population.getChromosomeByIndex(this.population.getSize() - 1);
  }

  public void setParentChromosomesSurviveCount(final int parentChromosomesCount) {
    this.parentChromosomesSurviveCount = parentChromosomesCount;
  }

  public int getParentChromosomesSurviveCount() {
    return this.parentChromosomesSurviveCount;
  }

  public void addIterationListener(final IterartionListener<C, T> listener) {
    this.iterationListeners.add(listener);
  }

  public void removeIterationListener(final IterartionListener<C, T> listener) {
    this.iterationListeners.remove(listener);
  }

  public T fitness(final C chromosome) {
    return this.chromosomesComparator.fit(chromosome);
  }

  public void clearCache() {
    this.chromosomesComparator.clearCache();
  }
}
