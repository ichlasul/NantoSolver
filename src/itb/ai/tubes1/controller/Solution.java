package itb.ai.tubes1.controller;

import java.util.List;
import java.util.Random;

import com.lagodiuk.ga.Chromosome;

/**
 * Solusi, berupa string dengan panjang tergantung jumlah jam
 * Solusi merepresentasikan jadwal
 */
public class Solution implements Chromosome<Solution> {
    	
    private static final Random random = new Random();

    public String data = new String();

    @Override
    protected Solution clone() {
	Solution clone = new Solution();
	clone.data = this.data;
	return clone;
    }
	
    /**
     * Returns clone of current chromosome, which is mutated a bit
     */
    @Override
    public Solution mutate() {
	Solution result = this.clone();
	    
	int index = random.nextInt(result.data.length());
	char[] data = result.data.toCharArray();
	data[index] = '0';
	result.data = new String(data);
	    
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
