package com.AndrewHanes.ga;

/**
 * Created with IntelliJ IDEA. User: Andrew Hanes Date: 6/18/13 Time: 6:46 PM To
 * change this template use File | Settings | File Templates.
 */
public class FitnessCalculator {
    private static byte[] solution;

    public void setSolution(byte[] b) {
	this.solution = b;
    }

    static public void setSolution(String str) {
	solution = new byte[str.length()];
	for (int i = 0; i < str.length(); ++i) {
	    char c = str.charAt(i);
	    if (c == '0' || c == '1') {
		solution[i] = Byte.parseByte(c + "");
	    } else {
		solution[i] = 0;
	    }
	}
    }

    public static int getFitness(Individual i) {
	int fitness = 0;
	for (int n = 0; n < solution.length; ++n) {
	    if (i.getGene(n) == solution[n]) {
		++fitness;
	    }
	}
	return fitness;
    }

    public static int getMaxFitness() {
	return solution.length;
    }

    public static byte[] getSolution() {
	return solution;
    }

    public static void main(String[] args) {
	FitnessCalculator c = new FitnessCalculator();
	c.setSolution("1");
	Population p = new Population(50);

	int genCount = 0;
	while (p.getFittest().getFitness() < c.getMaxFitness()) {
	    genCount++;
	    System.out.printf("Generation: %d\tFitness: %d\n", genCount, p
		    .getFittest().getFitness());
	    p = Evolver.evolvePopulation(p);
	}
	System.out.printf("Solution Found\nGeneration: %d\nGenes: %d\n",
		genCount, p.getFittest().getFitness());
    }
}
