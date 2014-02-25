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
	public Nanto(int uang, int waktu, int energiPerHari, int strength, int charm, int brain)
	{
		super(strength, charm, brain);
		this.uang = uang;
		this.energiPerHari = energiPerHari;			
		this.currentEnergi = this.energiPerHari;
	}
	
	// Override versi 2
	public Nanto(int uang, int waktu, int energiPerHari, int strength, int charm, int brain, int jumlahKandidat)
	{
		super(strength, charm, brain);
		this.uang = uang;
		this.energiPerHari = energiPerHari;			
		this.currentEnergi = this.energiPerHari;
	}
	
	// Override versi 3
	public Nanto(int uang, int waktu, int energiPerHari, int strength, int charm, int brain, int jumlahKandidat, BarangnyaNanto barangNanto)
	{
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
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getCharm() {
		return charm;
	}
	public void setCharm(int charm) {
		this.charm = charm;
	}
	
	public int getBrain() {
		return brain;
	}
	public void setBrain(int brain) {
		this.brain = brain;
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
	
	/**
	 * Cek apakah Nanto punya barang yang diinginkan cewek (prerequisite)
	 * Prerequisite cewek bentuknya String
	 * String tsb dikonversi ke array of String
	 * Misal ABC --> ["A", "B", "C"]
	 * Lalu cek apakah barang A/B/C ada atau tidak dengan mengakses atribut BarangnyaNanto
	 */
	public boolean isPrerequisiteLengkap(String prerequisite)
	{
		String[] enumeratedPrerequisite = prerequisite.split("(?!^)");		
		for (String kodeBarang : enumeratedPrerequisite) {
			//if (!barangNanto.isPunyaBarangX(kodeBarang))
		//		return false;
		}
		return true;
	}
	public boolean isPrerequisiteLengkap(Cewek cewek)
	{
		ArrayList<Barang> prereq = cewek.getPrerequisite();
		
		for (Barang barang : prereq) {
			if (!listBarang.contains(barang)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isEnoughCharm(int c){
		return this.charm >= c;
	}
	
	public boolean isEnoughStrent(int s){
		return this.strength >= s;
	}
	
	public boolean isEnoughBrain(int b){
		return this.brain >= b;
	}
	
	public boolean isEnoughEnergi(int e){
		return this.currentEnergi <= e;
	}
	
	// DEBUG
	public void printInfo()
	{
		System.out.println("Uang = " + this.uang +
							"\nStrength = " + this.strength + "\nCharm = " + this.charm +
							"\nBrain = " + this.brain + "\nEnergi per hari = " + this.energiPerHari +
							"\nCurrent energi = " + this.currentEnergi
				);
	}
}
