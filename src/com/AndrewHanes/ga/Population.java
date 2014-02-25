package com.AndrewHanes.ga;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Hanes
 * Date: 6/18/13
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Population {
    private Individual [] individuals;
    public Population(int popSize) {
        this.individuals = new Individual[popSize];
        for(int i = 0; i < this.individuals.length; ++i) {
            this.individuals[i] = new Individual();
        }
    }
   public Individual getIndividual(int i) {
       return this.individuals[i];
   }

    public Individual getFittest() {
        if(individuals.length == 0) {
            return null;
        }
        Individual fittest = individuals[0];
        for(int i = 1; i < individuals.length; ++i) {
            if(individuals[i].getFitness() > fittest.getFitness()) {
                fittest = individuals[i];
            }
        }
        return fittest;
    }

    public int size() {
        return individuals.length;
    }

    public void updateIndividual(int i, Individual a) {
        this.individuals[i] = a;
    }
}
