package itb.ai.tubes1.boundary;

import itb.ai.tubes1.entity.Barang;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.ListOfBarang;
import itb.ai.tubes1.entity.ListOfCewek;
import itb.ai.tubes1.entity.Nanto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Input {
	
	String fileUmum;
	String fileKandidat;
	String fileTempat;
	
	int nKandidat;
	int nBarang;
	
	Nanto nanto;
	ListOfCewek listCewek;
	ListOfBarang listBarang;

	public Input(String umum, String kandidat, String tempat) {
		fileUmum = umum;
		fileKandidat = kandidat;
		fileTempat = tempat;
		
		nKandidat = 0;
		nBarang = 0;
		
		nanto = new Nanto();
		listCewek = new ListOfCewek();
		listBarang = new ListOfBarang();
	}
	
	public Nanto getNanto() {
		return nanto;
	}

	public ListOfCewek getListCewek() {
		return listCewek;
	}

	public ListOfBarang getListBarang() {
		return listBarang;
	}

	public void readFile() {
		readUmum();
		readKandidat();
		readTempat();
	}

	private void readUmum() {
		Scanner s = null;
		Cewek c = null;
		Barang b = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader(fileUmum)));
            
            nanto.setUang(s.nextInt());
            nanto.setWaktu(s.nextInt());
            nanto.setEnergiPerHari(s.nextInt());
            nanto.setStrength(s.nextInt());
            nanto.setCharm(s.nextInt());
            nanto.setBrain(s.nextInt());
            nanto.resetEnergi();
            
            nKandidat = s.nextInt();
            
            for (int i = 0; i < nKandidat; i++) {
            	c = new Cewek();
            	
            	c.setEnlightmentPerJam(s.nextInt());
            	c.setEnergiPerJam(s.nextInt());
            	c.setMaksimalJamPerHari(s.nextInt());
            	c.setPrerequisite(s.next());
            	c.setStrength(s.nextInt());
            	c.setCharm(s.nextInt());
            	c.setBrain(s.nextInt());
            	
            	listCewek.addCewek(c);
            }
            
            nBarang = s.nextInt();
            
            for (int i = 0; i < nBarang; i++) {
            	b = new Barang();
            	
            	b.setKode(s.next().charAt(0));
            	b.setHarga(s.nextInt());
            	b.setRestockPerHari(s.nextInt());
            	
            	listBarang.addBarang(b);
            }
            
        } catch (FileNotFoundException e) {
			System.out.println("File " + fileUmum + " tidak ditemukan");
		} finally {
            if (s != null) {
                s.close();
            }
        }
	}
	
	private void readKandidat() {
		Scanner s = null;
		String buf = null;
		int j;
		Cewek c;
		
        try {
            s = new Scanner(new BufferedReader(new FileReader(fileKandidat)));

            for (int i = 0; i < nKandidat; i++) {
            	buf = s.nextLine();
            	
            	j = 0;
            	c = listCewek.listOfCewek.remove(i);
            	while (buf.isEmpty()) {
            		c.addJadwal(buf.charAt(j) == '1');
            	}
            	listCewek.listOfCewek.add(i, c);
            }
            
        } catch (FileNotFoundException e) {
			System.out.println("File " + fileKandidat + " tidak ditemukan");
		} finally {
            if (s != null) {
                s.close();
            }
        }
	}
	
	private void readTempat() {
		Scanner s = null;
		String buf = null;
		int j;
		Barang b;

        try {
            s = new Scanner(new BufferedReader(new FileReader(fileTempat)));

            for (int i = 0; i < listBarang.listOfBarang.size(); i++) {
            	buf = s.nextLine();
            	
            	j = 0;
            	b = listBarang.listOfBarang.remove(i);
            	while (buf.isEmpty()) {
            		b.addJadwal(buf.charAt(j) == '1');
            	}
            	listBarang.listOfBarang.add(i, b);
            }
            
        } catch (FileNotFoundException e) {
			System.out.println("File " + fileTempat + " tidak ditemukan");
		} finally {
            if (s != null) {
                s.close();
            }
        }
	}
	
}
