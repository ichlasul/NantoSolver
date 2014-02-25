package com.AndrewHanes.ga;

/**
 * Created with IntelliJ IDEA. User: Andrew Hanes Date: 6/18/13 Time: 6:49 PM To
 * change this template use File | Settings | File Templates.
 */
public class Evolver {

  private static final double uniformRate = .5;
  private static final double mutationRate = 0.015;
  private static final int tournamentSize = 5;
  private static final boolean elitism = true;

  public static Population evolvePopulation(final Population p) {
    final Population n = new Population(p.size());
    if (Evolver.elitism) {
      n.updateIndividual(0, p.getFittest());
    }

    int elitismOffset;
    if (Evolver.elitism) {
      elitismOffset = 1;
    } else {
      elitismOffset = 0;
    }

    for (int i = 0; i < p.size(); ++i) {
      final Individual one = Evolver.tournamentSelection(p);
      final Individual two = Evolver.tournamentSelection(p);
      Evolver.crossover(one, two);
    }

    for (int i = 0; i < elitismOffset; ++i) {
      n.getIndividual(i).mutate(Evolver.mutationRate);
    }

    return n;
  }

  private static Individual crossover(final Individual one, final Individual two) {
    final Individual n = new Individual();
    for (int i = 0; i < n.size(); ++i) {
      if (Math.random() <= Evolver.uniformRate) {
        n.setGene(i, one.getGene(i));
      } else {
        n.setGene(i, two.getGene(i));
      }
    }
    return n;
  }

  private static Individual tournamentSelection(final Population p) {
    final Population t = new Population(Evolver.tournamentSize);
    for (int i = 0; i < Evolver.tournamentSize; ++i) {
      final int rand = (int) Math.random() * p.size();
      t.updateIndividual(i, p.getIndividual(rand));
    }
    final Individual firrest = t.getFittest();
    return firrest;
  }

}
