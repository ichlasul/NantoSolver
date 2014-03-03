package itb.ai.tubes1.controller;

import itb.ai.tubes1.controller.ga.Chromosome;
import itb.ai.tubes1.controller.ga.Population;
import itb.ai.tubes1.entity.Jadwal;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Solusi, berupa string dengan panjang tergantung jumlah jam Solusi
 * merepresentasikan jadwal
 */
public class Solution implements Chromosome<Solution>, Cloneable {
	private static final Random random = new Random();
	private String randomDict;
	
	private int jumlahCewek;
	private int jumlahBarang;

	public char[] data;
	
	/**
	 * @param jUMLAH_CEWEK
	 * @param jUMLAH_BARANG
	 */
	public Solution(int jUMLAH_CEWEK, int jUMLAH_BARANG) {
		jumlahCewek = jUMLAH_CEWEK;
		jumlahBarang = jUMLAH_BARANG;
		data = new char[Jadwal.JUMLAH_MINGGU * Jadwal.JUMLAH_HARI
		      			* Jadwal.JUMLAH_JAM];
		
		if (randomDict == null ||
				randomDict.length() < 5 + jumlahCewek + jumlahBarang) {
			randomDict = "gmcu0"; // String Default
	
			for (int i = 1; i < jumlahCewek + 1; i++) {
				randomDict = randomDict + i; // String Default + Jumlah wanita
			}
	
			for (int j = 1; j < jumlahBarang + 1; j++) {
				randomDict = randomDict + (char) (64 + j);
			}
		}
	}

	@Override
	protected Solution clone() {
		Solution clone = new Solution(jumlahCewek, jumlahBarang);
		System.arraycopy(this.data, 0, clone.data, 0, this.data.length);
		return clone;
	}

	/**
	 * Returns clone of current chromosome, which is mutated a bit
	 */
	@Override
	public Solution mutate() {
		Solution result = this.clone();

		int index = random.nextInt(result.data.length);
		result.data[index] = '0';

		return result;
	}

	/**
	 * Returns list of siblings <br/>
	 * Siblings are actually new chromosomes, <br/>
	 * created using any of crossover strategy
	 */
	@Override
	public List<Solution> crossover(Solution other) {
		Solution thisClone = this.clone();
		Solution otherClone = other.clone();

		int index = random.nextInt(this.data.length - 1);
		for (int i = index; i < this.data.length; i++) {
			char tmp = thisClone.data[i];
			thisClone.data[i] = otherClone.data[i];
			otherClone.data[i] = tmp;
		}

		return Arrays.asList(thisClone, otherClone);
	}
	
	public Population<Solution> randomPopulation() {
		// TODO Auto-generated method stub
		return null;
	}

	public void randomSolution() {
		for (int i = 0; i < data.length; i++) {
			data[i] = randomChar();
		}
	}

	private char randomChar() {
		return randomDict.charAt(random.nextInt(randomDict.length()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Solution [data=" + Arrays.toString(data) + "]";
	}

}
