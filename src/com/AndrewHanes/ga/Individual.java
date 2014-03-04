package com.AndrewHanes.ga;

/**
 * Created with IntelliJ IDEA. User: Andrew Hanes Date: 6/18/13 Time: 6:41 PM To
 * change this template use File | Settings | File Templates.
 */
public class Individual {
	public static final int GENELENGTH = 64;
	private int fitness = -1;
	private byte[] genes = new byte[GENELENGTH];

	public Individual() {
		for (int i = 0; i < GENELENGTH; ++i) {
			this.genes[i] = (byte) Math.round(Math.random());
		}
	}

	public byte getGene(int i) {
		return this.genes[i];
	}

	public int getFitness() {
		if (fitness == -1) {
			fitness = FitnessCalculator.getFitness(this);
		}
		return fitness;
	}

	public void setGene(int i, byte b) {
		this.genes[i] = b;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < GENELENGTH; ++i) {
			str += this.genes[i] + "";
		}
		return str;
	}

	public int size() {
		return GENELENGTH;
	}

	public Individual mutate(double mutationRate) {
		for (int i = 0; i < this.size(); ++i) {
			if (Math.random() <= mutationRate) {
				byte rand = (byte) Math.round(Math.random());
				this.setGene(i, rand);
			}
		}
		return this;
	}
}
