package itb.ai.tubes1.entity;

import java.util.ArrayList;

/**
 * Class Nanto
 */
public class Nanto extends Orang {

    /**
     * Uang yang sekarang dimiliki
     */
    private int uang;

    /**
     * Naksimal energi yang bisa dimiliki Nanto. Nilainya tetap
     */
    private int energiPerHari;

    /**
     * Nilai energi yang SEDANG dimiliki Nanto.
     */
    private int currentEnergi;

    /**
     * Barang sekarang yang sedang dimiliki Nanto
     */
    private ArrayList<Barang> listBarang;

    // Konstruktor
    public Nanto() {
	this.uang = 0;
	this.energiPerHari = 0;
	this.strength = 0;
	this.charm = 0;
	this.brain = 0;
	this.currentEnergi = this.energiPerHari;
    }

    // Override
    public Nanto(int uang, int waktu, int energiPerHari, int strength,
	    int charm, int brain) {
	super(strength, charm, brain);
	this.uang = uang;
	this.energiPerHari = energiPerHari;
	this.currentEnergi = this.energiPerHari;
    }

    // Override versi 2
    public Nanto(int uang, int waktu, int energiPerHari, int strength,
	    int charm, int brain, int jumlahKandidat) {
	super(strength, charm, brain);
	this.uang = uang;
	this.energiPerHari = energiPerHari;
	this.currentEnergi = this.energiPerHari;
    }

    // Getter dan setter
    public int getUang() {
	return uang;
    }

    public void setUang(int uang) {
	this.uang = uang;
    }

    public int getEnergiPerHari() {
	return energiPerHari;
    }

    public void setEnergiPerHari(int energiPerHari) {
	this.energiPerHari = energiPerHari;
    }

    public int getCurrentEnergi() {
	return currentEnergi;
    }

    public void setCurrentEnergi(int currentEnergi) {
	this.currentEnergi = currentEnergi;
    }
    
    // Operasi terhadap nilai atribut
    public void addUang(int uang) {
	this.uang += uang;
    }

    public void addStrength(int strength) {
	this.strength += strength;
    }

    public void addCharm(int charm) {
	this.charm += charm;
    }

    public void addBrain(int brain) {
	this.brain += brain;
    }

    public void addCurrentEnergi(int currentEnergi) {
	this.currentEnergi += currentEnergi;
    }

    public void subUang(int uang) {
	this.uang -= uang;
    }

    public void subStrength(int strength) {
	this.strength -= strength;
    }

    public void subCharm(int charm) {
	this.charm -= charm;
    }

    public void subBrain(int brain) {
	this.brain -= brain;
    }

    public void subCurrentEnergi(int currentEnergi) {
	this.currentEnergi -= currentEnergi;
    }

    /**
     * Mengembalikan energi ke nilai maksimum
     */
    public void resetEnergi() {
	this.currentEnergi = this.energiPerHari;
    }

    public boolean isPrerequisiteLengkap(Cewek cewek) {
	ArrayList<Barang> prereq = cewek.getPrerequisite();

	for (Barang barang : prereq) {
	    if (!listBarang.contains(barang)) {
		return false;
	    }
	}

	return true;
    }

    public boolean isEnoughCharm(Cewek cewek) {
	return this.charm >= cewek.charm;
    }

    public boolean isEnoughStrength(Cewek cewek) {
	return this.strength >= cewek.strength;
    }

    public boolean isEnoughBrain(Cewek cewek) {
	return this.brain >= cewek.brain;
    }

    public boolean isEnoughEnergi(Cewek cewek) {
	return this.currentEnergi <= cewek.getEnergiPerJam();
    }
    
    public void addBarang(Barang barang) {
	listBarang.add(barang);
    }
    
    public boolean isPunyaBarang(Barang barang) {
	return listBarang.contains(barang);
    }
    
    public void hapusBarang(Barang barang) {
	listBarang.remove(barang);
    }
    
    public void beliBarang(Barang barang) {
        addBarang(barang);
        subUang(barang.getHarga());
    }
    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Nanto [Uang=" + uang + ", EnergiPerHari=" + energiPerHari
		+ ",CurrentEnergi=" + currentEnergi + ", ListBarang="
		+ listBarang + ", Strength=" + strength + ", Charm=" + charm
		+ ", Brain=" + brain + "]";
    }
}
