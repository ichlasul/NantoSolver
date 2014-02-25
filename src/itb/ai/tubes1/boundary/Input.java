package itb.ai.tubes1.boundary;

import itb.ai.tubes1.entity.Barang;
import itb.ai.tubes1.entity.Cafe;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.Gymnasium;
import itb.ai.tubes1.entity.Jadwal;
import itb.ai.tubes1.entity.ListOfBarang;
import itb.ai.tubes1.entity.ListOfCewek;
import itb.ai.tubes1.entity.Mall;
import itb.ai.tubes1.entity.Nanto;
import itb.ai.tubes1.entity.University;

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
    
    Mall mall;
    Gymnasium gymnasium;
    Cafe cafe;
    University university;

    public Input(String umum, String kandidat, String tempat) {
	fileUmum = umum;
	fileKandidat = kandidat;
	fileTempat = tempat;

	nKandidat = 0;
	nBarang = 0;

	nanto = new Nanto();
	listCewek = new ListOfCewek();
	listBarang = new ListOfBarang();
	
	mall = new Mall();
	gymnasium = new Gymnasium();
	cafe = new Cafe();
	university = new University();
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
	String buf = null;

	try {
	    s = new Scanner(new BufferedReader(new FileReader(fileUmum)));

	    nanto.setUang(s.nextInt());
	    Jadwal.JUMLAH_MINGGU = s.nextInt();
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
		// c.setPrerequisite(s.next());
		buf = s.next();
		for (char kode: buf.toCharArray()) {
		    if (kode != '-') {
			c.addPrerequisite(new Barang(kode));
		    }
		}
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
	Cewek c;

	try {
	    s = new Scanner(new BufferedReader(new FileReader(fileKandidat)));

	    for (int i = 0; i < nKandidat; i++) {
		buf = s.nextLine();

		c = listCewek.listOfCewek.get(i);
		Jadwal j = new Jadwal();
		for (char avail: buf.toCharArray()) {
		    j.add(avail == '1');
		}
		c.setJadwal(j);
		listCewek.listOfCewek.set(i, c);
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
	Jadwal j;

	try {
	    s = new Scanner(new BufferedReader(new FileReader(fileTempat)));

	    buf = s.nextLine();
	    j = new Jadwal();
	    for (char avail: buf.toCharArray()) {
        	j.add(avail == '1');
	    }
	    mall.setJadwal(j);
	    
	    buf = s.nextLine();
	    j = new Jadwal();
	    for (char avail: buf.toCharArray()) {
        	j.add(avail == '1');
	    }
	    gymnasium.setJadwal(j);
	    
	    buf = s.nextLine();
	    j = new Jadwal();
	    for (char avail: buf.toCharArray()) {
        	j.add(avail == '1');
	    }
	    cafe.setJadwal(j);
	    
	    buf = s.nextLine();
	    j = new Jadwal();
	    for (char avail: buf.toCharArray()) {
        	j.add(avail == '1');
	    }
	    university.setJadwal(j);
 
	} catch (FileNotFoundException e) {
	    System.out.println("File " + fileTempat + " tidak ditemukan");
	} finally {
	    if (s != null) {
		s.close();
	    }
	}
    }

}
