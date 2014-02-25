package com.AndrewHanes.ga;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Hanes
 * Date: 6/18/13
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Evolver {

    private static final double uniformRate = .5;
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    public static Population evolvePopulation(Population p) {
        Population n = new Population(p.size());
        if(elitism) {
            n.updateIndividual(0, p.getFittest());
        }

        int elitismOffset;
        if(elitism) {
            elitismOffset = 1;
        }
        else {
            elitismOffset = 0;
        }

        for(int i = 0; i < p.size(); ++i) {
            Individual one = tournamentSelection(p);
            Individual two = tournamentSelection(p);
            Individual ni = crossover(one, two);
        }

        for(int i = 0; i < elitismOffset; ++i) {
           n.getIndividual(i).mutate(mutationRate);
        }

        return n;
    }

    private static Individual crossover(Individual one, Individual two) {
        Individual n = new Individual();
        for(int i = 0; i < n.size(); ++i) {
            if(Math.random() <= uniformRate) {
                n.setGene(i, one.getGene(i));
            }
            else {
                n.setGene(i, two.getGene(i));
            }
        }
        return n;
    }

    private static Individual tournamentSelection(Population p) {
        Population t = new Population(tournamentSize);
        for(int i = 0; i < tournamentSize; ++i) {
            int rand = (int) Math.random() * p.size();
            t.updateIndividual(i, p.getIndividual(rand));
        }
        Individual firrest = t.getFittest();
        return firrest;
    }


}
