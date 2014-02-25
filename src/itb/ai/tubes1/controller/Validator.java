package itb.ai.tubes1.controller;

import itb.ai.tubes1.entity.ListOfCewek;

import java.util.ArrayList;
import java.util.Random;

public class Validator {

    public static ListOfCewek loc = null;

    public static Input input = null;

    public static boolean isValid(String jadwal) {
    	boolean valid = true;
    	//list jumlah pembelian setiap barang
    	//list jumlah jam bertemu dgn setiap kandidat

    	for (int i = 0; i < jadwal.length(); i++) {
    		act = jadwal.charAt(i);

    		if (i % 12 == 0) { 		//nanto baru saja tidur
    			//set energi nanto seperti default 
    		}

    		//cek energi nanto
			if (input.getNanto().getCurrentEnergi() <= 0) {
				return false;
			}

    		if (act != '0') { 		//nanto beraktivitas
    			if (Character.isDigit(act)) { 		//bertemu cewek

    			} 
    			else if (Character.isLowerCase(act)) { 		//pergi ke suatu tempat
    				switch (act) {
    					case 'u' :	//cek dijadwal buka atau ga
    								//jika buka, pergi ke tempat itu

    					case 'g' : 
    					case 'c' : 
    					case 'm' : 
    					default : 
    				}
    			} 
    			else if (Character.isUpperCase(act)) { 		//membeli barang

    			}  

    			
    		}
    		
    	}

    }

    public static int funcEnlightment(String stringValid) {
	int en = 0;
	char tempchar;
	for (int i = 0; i < stringValid.length(); i++) {
	    tempchar = stringValid.charAt(i);
	    if (tempchar == '1') {
		en += loc.getListOfCewek().get(1 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '2') {
		en += loc.getListOfCewek().get(2 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '3') {
		en += loc.getListOfCewek().get(3 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '4') {
		en += loc.getListOfCewek().get(4 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '5') {
		en += loc.getListOfCewek().get(5 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '6') {
		en += loc.getListOfCewek().get(6 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '7') {
		en += loc.getListOfCewek().get(7 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '8') {
		en += loc.getListOfCewek().get(8 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '9') {
		en += loc.getListOfCewek().get(9 - 1).getEnlightmentPerJam();
	    }

	}

	return en;
    }

    public static int bestEnlightment(ArrayList<Integer> ai) {
	int max = 0;
	max = ai.get(0);
	for (int i = 1; i < ai.size(); i++) {
	    if (max <= ai.get(i)) {
		max = ai.get(i);
	    }
	}
	return max;
    }

    public static String funcRandom(int jmlHari, int jmlW, int jmlB) {// JmlW =
								      // Jumlah
								      // Wanita
	Random r = new Random();
	int totalJam = jmlHari * 12;
	StringBuilder s = new StringBuilder(5 + jmlW + jmlB);
	String alphabet = "gmcu0"; // String Default
	for (int i = 1; i < jmlW + 1; i++) {
	    alphabet = alphabet + i; // String Default + Jumlah wanita
	}
	for (int j = 1; j < jmlB + 1; j++) {
	    alphabet = alphabet + (char) (64 + j);

	}
	for (int i = 0; i < (totalJam); i++) {
	    char tempChar = alphabet.charAt(r.nextInt(alphabet.length()));
	    s.append(tempChar);
	}

	return s.toString(); // return String Random
    }
}