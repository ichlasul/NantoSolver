package com.AndrewHanes.ga;

/**
 * Created with IntelliJ IDEA. User: Andrew Hanes Date: 6/18/13 Time: 6:41 PM To
 * change this template use File | Settings | File Templates.
 */
public class Individual {
  public static final int GENELENGTH = 64;
  private int fitness = -1;
  private final byte[] genes = new byte[Individual.GENELENGTH];

  public Individual() {
    for (int i = 0; i < Individual.GENELENGTH; ++i) {
      this.genes[i] = (byte) Math.round(Math.random());
    }
  }

  public byte getGene(final int i) {
    return this.genes[i];
  }

  public int getFitness() {
    if (this.fitness == -1) {
      this.fitness = FitnessCalculator.getFitness(this);
    }
    return this.fitness;
  }

  public void setGene(final int i, final byte b) {
    this.genes[i] = b;
  }

  @Override
  public String toString() {
    String str = "";
    for (int i = 0; i < Individual.GENELENGTH; ++i) {
      str += this.genes[i] + "";
    }
    return str;
  }

  public int size() {
    return Individual.GENELENGTH;
  }

  public Individual mutate(final double mutationRate) {
    for (int i = 0; i < this.size(); ++i) {
      if (Math.random() <= mutationRate) {
        final byte rand = (byte) Math.round(Math.random());
        this.setGene(i, rand);
      }
    }
    return this;
  }
}
