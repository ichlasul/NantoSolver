package itb.ai.tubes1.boundary;

import itb.ai.tubes1.entity.Barang;
import itb.ai.tubes1.entity.Cafe;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.Gymnasium;
import itb.ai.tubes1.entity.Jadwal;
import itb.ai.tubes1.entity.Mall;
import itb.ai.tubes1.entity.Nanto;
import itb.ai.tubes1.entity.University;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private String fileUmum;
    private String fileKandidat;
    private String fileTempat;

    private int nKandidat;
    private int nBarang;

    private Nanto nanto;
    private ArrayList<Cewek> listCewek;
    private ArrayList<Barang> listBarang;
    
    private Mall mall;
    private Gymnasium gymnasium;
    private Cafe cafe;
    private University university;

    public Input(String umum, String kandidat, String tempat) {
	fileUmum = umum;
	fileKandidat = kandidat;
	fileTempat = tempat;

	nKandidat = 0;
	nBarang = 0;

	nanto = new Nanto();
	listCewek = new ArrayList<Cewek>();
	listBarang = new ArrayList<Barang>();
	
	mall = new Mall();
	gymnasium = new Gymnasium();
	cafe = new Cafe();
	university = new University();
    }

    public Nanto getNanto() {
	return nanto;
    }

    public ArrayList<Cewek> getListCewek() {
	return listCewek;
    }

    public ArrayList<Barang> getListBarang() {
	return listBarang;
    }

    /**
     * @return the nKandidat
     */
    public int getnKandidat() {
        return nKandidat;
    }

    /**
     * @return the nBarang
     */
    public int getnBarang() {
        return nBarang;
    }

    /**
     * @return the mall
     */
    public Mall getMall() {
        return mall;
    }

    /**
     * @return the gymnasium
     */
    public Gymnasium getGymnasium() {
        return gymnasium;
    }

    /**
     * @return the cafe
     */
    public Cafe getCafe() {
        return cafe;
    }

    /**
     * @return the university
     */
    public University getUniversity() {
        return university;
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
		
		c.setNomor(i + 1);

		listCewek.add(c);
	    }

	    nBarang = s.nextInt();

	    for (int i = 0; i < nBarang; i++) {
		b = new Barang();

		b.setKode(s.next().charAt(0));
		b.setHarga(s.nextInt());
		b.setRestockPerHari(s.nextInt());

		listBarang.add(b);
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

		c = listCewek.get(i);
		Jadwal j = new Jadwal();
		for (char avail: buf.toCharArray()) {
		    j.add(avail == '1');
		}
		c.setJadwal(j);
		listCewek.set(i, c);
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
