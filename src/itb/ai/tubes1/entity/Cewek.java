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

  private final ArrayList<Boolean> jadwal;

  // Konstruktor
  public Cewek() {
    super();
    this.enlightmentPerJam = 0;
    this.energiPerJam = 0;
    this.maksimalJamPerHari = 0;
    this.prerequisite = new ArrayList<>();
    this.jadwal = new ArrayList<>();
  }

  // Override
  public Cewek(final int enlightmentPerJam, final int energiPerJam,
      final int maksimalJamPerHari, final String prerequisite,
      final int strength, final int charm, final int brain) {
    super(strength, charm, brain);
    this.enlightmentPerJam = enlightmentPerJam;
    this.energiPerJam = energiPerJam;
    this.maksimalJamPerHari = maksimalJamPerHari;
    this.prerequisite = new ArrayList<>();
    this.jadwal = new ArrayList<>();
  }

  // Getter dan setter
  public int getEnlightmentPerJam() {
    return this.enlightmentPerJam;
  }

  public void setEnlightmentPerJam(final int enlightmentPerJam) {
    this.enlightmentPerJam = enlightmentPerJam;
  }

  public int getEnergiPerJam() {
    return this.energiPerJam;
  }

  public void setEnergiPerJam(final int energiPerJam) {
    this.energiPerJam = energiPerJam;
  }

  public int getMaksimalJamPerHari() {
    return this.maksimalJamPerHari;
  }

  public void setMaksimalJamPerHari(final int maksimalJamPerHari) {
    this.maksimalJamPerHari = maksimalJamPerHari;
  }

  public ArrayList<Barang> getPrerequisite() {
    return this.prerequisite;
  }

  public void setPrerequisite(final ArrayList<Barang> prerequisite) {
    this.prerequisite = prerequisite;
  }

  public int getStrength() {
    return this.strength;
  }

  public void setStrength(final int strength) {
    this.strength = strength;
  }

  public int getCharm() {
    return this.charm;
  }

  public void setCharm(final int charm) {
    this.charm = charm;
  }

  public int getBrain() {
    return this.brain;
  }

  public void setBrain(final int brain) {
    this.brain = brain;
  }

  /**
   * Menambahkan jadwal
   */
  public void addJadwal(final boolean avalaible) {
    this.jadwal.add(avalaible);
  }

  // DEBUG
  public void printInfo() {
    System.out.println("Enlightment per jam = " + this.enlightmentPerJam
        + "\nEnergi per jam = " + this.energiPerJam + "\nStrength = "
        + this.strength + "\nCharm = " + this.charm + "\nBrain = " + this.brain
        + "\nMaksimal jam per hari = " + this.maksimalJamPerHari
        + "\nPrerequisite = " + this.prerequisite);
  }

  public void printJadwal() {
    for (final Boolean available : this.jadwal) {
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
    result = (prime * result) + this.nomor;
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final Cewek other = (Cewek) obj;
    if (this.nomor != other.nomor) {
      return false;
    }
    return true;
  }
}
