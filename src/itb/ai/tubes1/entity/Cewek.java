package itb.ai.tubes1.entity;

import java.util.ArrayList;

/**
 * Kelas Cewek
 */
public class Cewek extends Orang {

	private int nomor;

	private int enlightmentPerJam;

	private int energiPerJam;

	private int maksimalJamPerHari;

	private ArrayList<Barang> prerequisite;

	private Jadwal jadwal;

	// Konstruktor
	public Cewek() {
		super();
		this.enlightmentPerJam = 0;
		this.energiPerJam = 0;
		this.maksimalJamPerHari = 0;
		this.prerequisite = new ArrayList<>();
		jadwal = new Jadwal();
	}

	// Override
	public Cewek(int enlightmentPerJam, int energiPerJam,
			int maksimalJamPerHari, String prerequisite, int strength,
			int charm, int brain) {
		super(strength, charm, brain);
		this.enlightmentPerJam = enlightmentPerJam;
		this.energiPerJam = energiPerJam;
		this.maksimalJamPerHari = maksimalJamPerHari;
		this.prerequisite = new ArrayList<>();
		jadwal = new Jadwal();
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

	/**
	 * @return the nomor
	 */
	public int getNomor() {
		return nomor;
	}

	/**
	 * @param nomor
	 *            the nomor to set
	 */
	public void setNomor(int nomor) {
		this.nomor = nomor;
	}

	/**
	 * @return the jadwal
	 */
	public Jadwal getJadwal() {
		return jadwal;
	}

	/**
	 * @param jadwal
	 *            the jadwal to set
	 */
	public void setJadwal(Jadwal jadwal) {
		this.jadwal = jadwal;
	}

	// DEBUG
	public void printInfo() {
		System.out.println("Enlightment per jam = " + this.enlightmentPerJam
				+ "\nEnergi per jam = " + this.energiPerJam + "\nStrength = "
				+ this.strength + "\nCharm = " + this.charm + "\nBrain = "
				+ this.brain + "\nMaksimal jam per hari = "
				+ this.maksimalJamPerHari + "\nPrerequisite = "
				+ this.prerequisite);
	}

	public void printJadwal() {
		for (Boolean available : jadwal.getList()) {
			if (available) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
	}

	/**
	 * Memeriksa apakah object cewek sama atau tidak dengan object lainnya
	 * Digeneerate otomatis oleh eclipse
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nomor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cewek other = (Cewek) obj;
		if (nomor != other.nomor)
			return false;
		return true;
	}

	public void addPrerequisite(Barang barang) {
		prerequisite.add(barang);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cewek [Nomor=" + nomor + ", EnlightmentPerJam="
				+ enlightmentPerJam + ", EnergiPerJam=" + energiPerJam
				+ ", MaksimalJamPerHari=" + maksimalJamPerHari
				+ ", Prerequisite=" + prerequisite + ", Jadwal=" + jadwal
				+ ", Strength=" + strength + ", Charm=" + charm + ", Brain="
				+ brain + "]";
	}
}
