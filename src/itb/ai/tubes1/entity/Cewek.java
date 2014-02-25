package itb.ai.tubes1.entity;

import java.util.ArrayList;


public class Cewek extends Orang {
	
	// Atribut cewek
	private int nomor;
	
	private int enlightmentPerJam;
	
	private int energiPerJam;
	
	private int maksimalJamPerHari;
	
	private ArrayList<Barang> prerequisite;
	
	private ArrayList<Boolean> jadwal;
	

	// Konstruktor
	public Cewek()
	{
		this.enlightmentPerJam = 0;
		this.energiPerJam = 0;
		this.maksimalJamPerHari = 0;
		this.prerequisite = new ArrayList<>();
		this.strength = 0;
		this.charm = 0;
		this.brain = 0;
		jadwal = new ArrayList<>();
	}
	
	// Override
	public Cewek(int enlightmentPerJam, int energiPerJam, int maksimalJamPerHari,
			String prerequisite, int strength, int charm, int brain)
	{
		this.enlightmentPerJam = enlightmentPerJam;
		this.energiPerJam = energiPerJam;
		this.maksimalJamPerHari = maksimalJamPerHari;
		this.prerequisite = new ArrayList<>();
		this.strength = strength;
		this.charm = charm;
		this.brain = brain;
		jadwal = new ArrayList<>();
	}
	
	// Getter dan setter	
	public int getEnlightmentPerJam() {
		return enlightmentPerJam;
	}
	public void setEnlightmentPerJam(int enlightmentPerJam) {
		this.enlightmentPerJam = enlightmentPerJam;
	}
	
	public int getEnergiPerJam() {
		return energiPerJam;
	}
	public void setEnergiPerJam(int energiPerJam) {
		this.energiPerJam = energiPerJam;
	}
	
	public int getMaksimalJamPerHari() {
		return maksimalJamPerHari;
	}
	public void setMaksimalJamPerHari(int maksimalJamPerHari) {
		this.maksimalJamPerHari = maksimalJamPerHari;
	}
	
	public ArrayList<Barang> getPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(ArrayList<Barang> prerequisite) {
		this.prerequisite = prerequisite;
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
	
	public void addJadwal(boolean avalaible) {
		jadwal.add(avalaible);
	}
	
	
	// DEBUG
	public void printInfo() {
		System.out.println("Enlightment per jam = " + this.enlightmentPerJam + "\nEnergi per jam = " + this.energiPerJam +
				"\nStrength = " + this.strength + "\nCharm = " + this.charm +
				"\nBrain = " + this.brain + "\nMaksimal jam per hari = " + this.maksimalJamPerHari +
				"\nPrerequisite = " + this.prerequisite );		
	}
	
	public void printJadwal(){
		for(int i =0;i<this.jadwal.size();i++){
			System.out.println(this.jadwal.get(i));
		}
	}
}
