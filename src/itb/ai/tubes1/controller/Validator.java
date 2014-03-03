package itb.ai.tubes1.controller;

import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.entity.ListOfCewek;
import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.Nanto;

import java.util.ArrayList;
import java.util.Random;

public class Validator {

    public static ListOfCewek loc = null;

    public static Input input = null;

	private static char act;

    public static boolean isValid(String jadwal) {
        Nanto nanto = new Nanto();
        nanto.setBrain(input.getNanto().getBrain());
        nanto.setCharm(input.getNanto().getCharm());
        nanto.setCurrentEnergi(input.getNanto().getCurrentEnergi());
        nanto.setEnergiPerHari(input.getNanto().getEnergiPerHari());
    	nanto.setStrength(input.getNanto().getStrength());
        boolean valid = true;
    	
    	System.out.println(jadwal);
        ArrayList<Integer> pembelianBarang = new ArrayList<>(); //list jumlah pembelian setiap barang
        //inisialisasi list jumlah pembelian barang
        for (int j=0; j < input.getListBarang().size(); j++) {
            pembelianBarang.add(j, 0);
        }
        
        ArrayList<Integer> pertemuanCewek = new ArrayList<>(); //list jumlah jam bertemu setiap cewek
        //inisialisasi list jumlah jam bertemu dgn setiap kandidat
        for (int j=0; j < input.getListCewek().size(); j++) {
            pertemuanCewek.add(j, 0);
        }
        

    	for (int i = 0; i < jadwal.length(); i++) {
    		char act;
                act = jadwal.charAt(i);

    		if (i % 12 == 0) { 		//ganti hari
    			nanto.resetEnergi();  //mengembalikan energi nanto
                        for (int j=0; j < input.getListBarang().size(); j++) { // mengembalikan jumlah pembelian barang jadi 0
                            pembelianBarang.add(j, 0);
                        }
                        for (int j = 0; j < input.getListCewek().size(); j++) { //mengembalikan seperti semula
                            pertemuanCewek.add(j, 0);
                        }
    		}

    		//cek energi nanto
			if (nanto.getCurrentEnergi() <= 0) {
				return false;
			}

    		if (act != '0') { 		//nanto beraktivitas
    			if (Character.isDigit(act)) { 		//bertemu cewek
                            System.out.println("lewat");
                            int idxcewek = 0;
                            for (int j = 0; j < input.getListCewek().size(); j++) {
                                if (input.getListCewek().get(j).getNomor() == Character.getNumericValue(act)) {
                                    idxcewek = j;
                                }
                            }
                            
                            Cewek cewek = input.getListCewek().get(idxcewek);
                            
                            int nbKetemu = pertemuanCewek.get(idxcewek);
                            int maxKetemu = cewek.getMaksimalJamPerHari();
                            if (nanto.isPrerequisiteLengkap(cewek) && nanto.isEnoughBrain(cewek) && nanto.isEnoughCharm(cewek) && nanto.isEnoughEnergi(cewek) && nanto.isEnoughStrength(cewek) && (nbKetemu < maxKetemu)) {
                                nanto.subCurrentEnergi(cewek.getEnergiPerJam());
                                pertemuanCewek.add(idxcewek, pertemuanCewek.get(idxcewek)+1);
                            } else {return false; }
                            
    			} 
    			else if (Character.isLowerCase(act)) { 		//pergi ke suatu tempat
    				System.out.println("lewat2");
    				switch (act) {
    					case 'u' :  if (input.getUniversity().getJadwal().getList().get(i)) {	//cek dijadwal buka atau ga
    								nanto.addBrain(input.getUniversity().getBrain());
                                                                nanto.subCurrentEnergi(input.getUniversity().getEnergi());
                                                    } else { return false; }
    					case 'g' : if (input.getGymnasium().getJadwal().getList().get(i)) {	//cek dijadwal buka atau ga
    								nanto.addStrength(input.getGymnasium().getStrength());
                                                                nanto.subCurrentEnergi(input.getGymnasium().getEnergi());
                                                    } else { return false; }
    					case 'c' : if (input.getCafe().getJadwal().getList().get(i)) {	//cek dijadwal buka atau ga
    								nanto.addCharm(input.getCafe().getCharm());
                                                                nanto.subCurrentEnergi(input.getCafe().getEnergi());
                                                    } else { return false; }
    					case 'm' : if (input.getMall().getJadwal().getList().get(i)) {	//cek dijadwal buka atau ga
    								nanto.addUang(input.getMall().getMoney());
                                                                nanto.subCurrentEnergi(input.getMall().getEnergi());
                                                    } else { return false; }
    					default : 
    				}
    			} 
    			else if (Character.isUpperCase(act)) { 		//membeli barang
    				       System.out.println("lewat3");
                           int idx = 0; 
                           for (int j=0; j < input.getListBarang().size(); j++) {
                                if (input.getListBarang().get(j).getKode() == act) {
                                    idx = j;
                                }
                            } 
                           
                           int uangNanto = nanto.getUang();
                           int maxPembelian = input.getListBarang().get(idx).getRestockPerHari();
                           int harga = input.getListBarang().get(idx).getHarga();
                           int nbPembelian = pembelianBarang.get(idx);
                           if ((uangNanto >= harga) && (nbPembelian < maxPembelian)) {
                               nanto.beliBarang(input.getListBarang().get(idx));
                               pembelianBarang.add(idx, pembelianBarang.get(idx)+1);
                           } else { return false;}
    			}  

    			
    		}
    		
    	}
        
        //cek apakah setiap kandidat minimal pernah dikunjungi
        for (int j=0; j < pertemuanCewek.size(); j++) {
            if (pertemuanCewek.get(j) == 0) return false;
        }

		return valid;


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
    
    public static void main (String[] argv) {
	for (int i = 0; i < 10; i++)
	    System.out.println(Validator.funcRandom(14,4,4));
    }
}
