package itb.ai.tubes1.controller;

import java.util.List;

import com.lagodiuk.ga.Chromosome;

/**
 * Solusi, berupa string dengan panjang tergantung jumlah jam
 * Solusi merepresentasikan jadwal
 */
public class Solution implements Chromosome<Solution> {

	public String data = new String();

	/**
	 * Returns clone of current chromosome, which is mutated a bit
	 */
	@Override
	public Solution mutate() {
	    Solution result = this;
	    
	    //result.data
	    
	    return result;
	}

	/**
	 * Returns list of siblings <br/>
	 * Siblings are actually new chromosomes, <br/>
	 * created using any of crossover strategy
	 */
	@Override
	public List<Solution> crossover(Solution anotherChromosome) {
	
		// TODO Auto-generated method stub
		return null;
	}

}
