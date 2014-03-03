package itb.ai.tubes1.controller;

import itb.ai.tubes1.controller.ga.Chromosome;
import itb.ai.tubes1.entity.Jadwal;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Solusi, berupa string dengan panjang tergantung jumlah jam
 * Solusi merepresentasikan jadwal
 */
public class Solution implements Chromosome<Solution> {
    	
    private static final Random random = new Random();
    private static String randomDict = null;

    public char[] data = new char[Jadwal.JUMLAH_MINGGU * Jadwal.JUMLAH_HARI *Jadwal.JUMLAH_JAM];

    @Override
    protected Solution clone() {
	Solution clone = new Solution();
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
    
    public static String random(int jmlHari, int jmlW, int jmlB) {
        int totalJam = jmlHari * 12;
        StringBuilder s = new StringBuilder();
        
        if (randomDict == null) {
            randomDict = "gmcu0"; // String Default
            
            for (int i = 1; i < jmlW + 1; i++) {
        	randomDict = randomDict + i; // String Default + Jumlah wanita
            }
            
            for (int j = 1; j < jmlB + 1; j++) {
        	randomDict = randomDict + (char) (64 + j); 
            }
        }
        
        for (int i = 0; i < (totalJam); i++) {
            s.append(randomChar());
        }
        
        return s.toString(); // return String Random
    }

    private static char randomChar() {
        Random r = new Random();
	return randomDict.charAt(r.nextInt(randomDict.length()));
    }

}
