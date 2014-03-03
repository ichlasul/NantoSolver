package itb.ai.tubes1.controller;

import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.controller.ga.Fitness;
import itb.ai.tubes1.entity.Barang;
import itb.ai.tubes1.entity.Cafe;
import itb.ai.tubes1.entity.Gymnasium;
import itb.ai.tubes1.entity.ListOfCewek;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.Mall;
import itb.ai.tubes1.entity.Nanto;
import itb.ai.tubes1.entity.University;

import java.util.ArrayList;
import java.util.Arrays;

public class Validator implements Fitness<Solution, Integer> {

    public boolean isValid(Solution sol, Nanto nanto,
    		ArrayList<Barang> listBarang,  ArrayList<Cewek> listCewek,
    		Mall mall, Gymnasium gym, Cafe cafe, University univ) {
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
    					case 'u' :  if (univ.getJadwal().getList().get(i)) {	//cek dijadwal buka atau ga
    								nanto.addBrain(univ.getBrain());
                                                                nanto.subCurrentEnergi(univ.getEnergi());
                                                    } else { return false; }
    					case 'g' : if (gym.getJadwal().getList().get(i)) {	//cek dijadwal buka atau ga
    								nanto.addStrength(gym.getStrength());
                                                                nanto.subCurrentEnergi(gym.getEnergi());
                                                    } else { return false; }
    					case 'c' : if (cafe.getJadwal().getList().get(i)) {	//cek dijadwal buka atau ga
    								nanto.addCharm(cafe.getCharm());
                                                                nanto.subCurrentEnergi(cafe.getEnergi());
                                                    } else { return false; }
    					case 'm' : if (mall.getJadwal().getList().get(i)) {	//cek dijadwal buka atau ga
    								nanto.addUang(mall.getMoney());
                                                                nanto.subCurrentEnergi(mall.getEnergi());
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

    public int funcEnlightment(String stringValid) {
    ArrayList<Cewek> loc = new ArrayList<Cewek>();
	int en = 0;
	char tempchar;
	for (int i = 0; i < stringValid.length(); i++) {
	    tempchar = stringValid.charAt(i);
	    if (tempchar == '1') {
		en += loc.get(1 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '2') {
		en += loc.get(2 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '3') {
		en += loc.get(3 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '4') {
		en += loc.get(4 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '5') {
		en += loc.get(5 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '6') {
		en += loc.get(6 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '7') {
		en += loc.get(7 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '8') {
		en += loc.get(8 - 1).getEnlightmentPerJam();
	    }
	    if (tempchar == '9') {
		en += loc.get(9 - 1).getEnlightmentPerJam();
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

	@Override
	public Integer calculate(Solution chromosome) {
		// TODO Auto-generated method stub
		return null;
	}
}
