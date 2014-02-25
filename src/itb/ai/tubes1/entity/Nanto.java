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
  public Nanto(final int uang, final int waktu, final int energiPerHari,
      final int strength, final int charm, final int brain) {
    super(strength, charm, brain);
    this.uang = uang;
    this.energiPerHari = energiPerHari;
    this.currentEnergi = this.energiPerHari;
  }

  // Override versi 2
  public Nanto(final int uang, final int waktu, final int energiPerHari,
      final int strength, final int charm, final int brain,
      final int jumlahKandidat) {
    super(strength, charm, brain);
    this.uang = uang;
    this.energiPerHari = energiPerHari;
    this.currentEnergi = this.energiPerHari;
  }

  // Override versi 3
  public Nanto(final int uang, final int waktu, final int energiPerHari,
      final int strength, final int charm, final int brain,
      final int jumlahKandidat, final BarangnyaNanto barangNanto) {
    super(strength, charm, brain);
    this.uang = uang;
    this.energiPerHari = energiPerHari;
    this.currentEnergi = this.energiPerHari;
  }

  // Getter dan setter
  public int getUang() {
    return this.uang;
  }

  public void setUang(final int uang) {
    this.uang = uang;
  }

  public int getEnergiPerHari() {
    return this.energiPerHari;
  }

  public void setEnergiPerHari(final int energiPerHari) {
    this.energiPerHari = energiPerHari;
  }

  public int getCurrentEnergi() {
    return this.currentEnergi;
  }

  public void setCurrentEnergi(final int currentEnergi) {
    this.currentEnergi = currentEnergi;
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

  // Operasi terhadap nilai atribut
  public void addUang(final int uang) {
    this.uang += uang;
  }

  public void addStrength(final int strength) {
    this.strength += strength;
  }

  public void addCharm(final int charm) {
    this.charm += charm;
  }

  public void addBrain(final int brain) {
    this.brain += brain;
  }

  public void addCurrentEnergi(final int currentEnergi) {
    this.currentEnergi += currentEnergi;
  }

  public void subUang(final int uang) {
    this.uang -= uang;
  }

  public void subStrength(final int strength) {
    this.strength -= strength;
  }

  public void subCharm(final int charm) {
    this.charm -= charm;
  }

  public void subBrain(final int brain) {
    this.brain -= brain;
  }

  public void subCurrentEnergi(final int currentEnergi) {
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
   * Prerequisite cewek bentuknya String String tsb dikonversi ke array of
   * String Misal ABC --> ["A", "B", "C"] Lalu cek apakah barang A/B/C ada atau
   * tidak dengan mengakses atribut BarangnyaNanto
   */
  public boolean isPrerequisiteLengkap(final String prerequisite) {
    final String[] enumeratedPrerequisite = prerequisite.split("(?!^)");
    for (final String kodeBarang : enumeratedPrerequisite) {
      // if (!barangNanto.isPunyaBarangX(kodeBarang))
      // return false;
    }
    return true;
  }

  public boolean isPrerequisiteLengkap(final Cewek cewek) {
    final ArrayList<Barang> prereq = cewek.getPrerequisite();

    for (final Barang barang : prereq) {
      if (!this.listBarang.contains(barang)) {
        return false;
      }
    }

    return true;
  }

  public boolean isEnoughCharm(final int c) {
    return this.charm >= c;
  }

  public boolean isEnoughStrent(final int s) {
    return this.strength >= s;
  }

  public boolean isEnoughBrain(final int b) {
    return this.brain >= b;
  }

  public boolean isEnoughEnergi(final int e) {
    return this.currentEnergi <= e;
  }

  // DEBUG
  public void printInfo() {
    System.out.println("Uang = " + this.uang + "\nStrength = " + this.strength
        + "\nCharm = " + this.charm + "\nBrain = " + this.brain
        + "\nEnergi per hari = " + this.energiPerHari + "\nCurrent energi = "
        + this.currentEnergi);
  }
}
