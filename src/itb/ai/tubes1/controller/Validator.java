package itb.ai.tubes1.controller;

import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.entity.Barang;
import itb.ai.tubes1.entity.ListOfCewek;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.Nanto;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator {

    public static ListOfCewek loc = null;

    public static Input input = null;

    private static char act;

    public static boolean isValid(Solution sol, Nanto nanto, ArrayList<Barang> listBarang,  ArrayList<Cewek> listCewek) {
	String jadwal = Arrays.toString(sol.data);
        boolean valid = true;
    	
    	System.out.println(jadwal);
        ArrayList<Integer> pembelianBarang = new ArrayList<>(); //list jumlah pembelian setiap barang
        //inisialisasi list jumlah pembelian barang
        for (int j=0; j < listBarang.size(); j++) {
            pembelianBarang.add(j, 0);
        }
        
        ArrayList<Integer> pertemuanCewek = new ArrayList<>(); //list jumlah jam bertemu setiap cewek
        //inisialisasi list jumlah jam bertemu dgn setiap kandidat
        for (int j=0; j < listCewek.size(); j++) {
            pertemuanCewek.add(j, 0);
        }
        

    	for (int i = 0; i < jadwal.length(); i++) {
    		char act;
                act = jadwal.charAt(i);

    		if (i % 12 == 0) { 		//ganti hari
    			nanto.resetEnergi();  //mengembalikan energi nanto
                        for (int j=0; j < listBarang.size(); j++) { // mengembalikan jumlah pembelian barang jadi 0
                            pembelianBarang.add(j, 0);
                        }
                        for (int j = 0; j < listCewek.size(); j++) { //mengembalikan seperti semula
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
                            for (int j = 0; j < listCewek.size(); j++) {
                                if (listCewek.get(j).getNomor() == Character.getNumericValue(act)) {
                                    idxcewek = j;
                                }
                            }
                            
                            Cewek cewek = listCewek.get(idxcewek);
                            
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
                           for (int j=0; j < listBarang.size(); j++) {
                                if (listBarang.get(j).getKode() == act) {
                                    idx = j;
                                }
                            } 
                           
                           int uangNanto = nanto.getUang();
                           int maxPembelian = listBarang.get(idx).getRestockPerHari();
                           int harga = listBarang.get(idx).getHarga();
                           int nbPembelian = pembelianBarang.get(idx);
                           if ((uangNanto >= harga) && (nbPembelian < maxPembelian)) {
                               nanto.beliBarang(listBarang.get(idx));
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
}
