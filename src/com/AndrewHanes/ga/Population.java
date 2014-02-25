package com.AndrewHanes.ga;

/**
 * Created with IntelliJ IDEA. User: Andrew Hanes Date: 6/18/13 Time: 6:49 PM To
 * change this template use File | Settings | File Templates.
 */
public class Population {
  private final Individual[] individuals;

  public Population(final int popSize) {
    this.individuals = new Individual[popSize];
    for (int i = 0; i < this.individuals.length; ++i) {
      this.individuals[i] = new Individual();
    }
  }

  public Individual getIndividual(final int i) {
    return this.individuals[i];
  }

  public Individual getFittest() {
    if (this.individuals.length == 0) {
      return null;
    }
    Individual fittest = this.individuals[0];
    for (int i = 1; i < this.individuals.length; ++i) {
      if (this.individuals[i].getFitness() > fittest.getFitness()) {
        fittest = this.individuals[i];
      }
    }
    return fittest;
  }

  public int size() {
    return this.individuals.length;
  }

  public void updateIndividual(final int i, final Individual a) {
    this.individuals[i] = a;
  }
}
