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

  public Input(final String umum, final String kandidat, final String tempat) {
    this.fileUmum = umum;
    this.fileKandidat = kandidat;
    this.fileTempat = tempat;

    this.nKandidat = 0;
    this.nBarang = 0;

    this.nanto = new Nanto();
    this.listCewek = new ListOfCewek();
    this.listBarang = new ListOfBarang();
  }

  public Nanto getNanto() {
    return this.nanto;
  }

  public ListOfCewek getListCewek() {
    return this.listCewek;
  }

  public ListOfBarang getListBarang() {
    return this.listBarang;
  }

  public void readFile() {
    this.readUmum();
    this.readKandidat();
    this.readTempat();
  }

  private void readUmum() {
    Scanner s = null;
    Cewek c = null;
    Barang b = null;

    try {
      s = new Scanner(new BufferedReader(new FileReader(this.fileUmum)));

      this.nanto.setUang(s.nextInt());
      this.nanto.setEnergiPerHari(s.nextInt());
      this.nanto.setStrength(s.nextInt());
      this.nanto.setCharm(s.nextInt());
      this.nanto.setBrain(s.nextInt());
      this.nanto.resetEnergi();

      this.nKandidat = s.nextInt();

      for (int i = 0; i < this.nKandidat; i++) {
        c = new Cewek();

        c.setEnlightmentPerJam(s.nextInt());
        c.setEnergiPerJam(s.nextInt());
        c.setMaksimalJamPerHari(s.nextInt());
        // c.setPrerequisite(s.next());
        c.setStrength(s.nextInt());
        c.setCharm(s.nextInt());
        c.setBrain(s.nextInt());

        this.listCewek.addCewek(c);
      }

      this.nBarang = s.nextInt();

      for (int i = 0; i < this.nBarang; i++) {
        b = new Barang();

        b.setKode(s.next().charAt(0));
        b.setHarga(s.nextInt());
        b.setRestockPerHari(s.nextInt());

        this.listBarang.addBarang(b);
      }

    } catch (final FileNotFoundException e) {
      System.out.println("File " + this.fileUmum + " tidak ditemukan");
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
      s = new Scanner(new BufferedReader(new FileReader(this.fileKandidat)));

      for (int i = 0; i < this.nKandidat; i++) {
        buf = s.nextLine();

        j = 0;
        c = this.listCewek.listOfCewek.remove(i);
        while (buf.isEmpty()) {
          c.addJadwal(buf.charAt(j) == '1');
        }
        this.listCewek.listOfCewek.add(i, c);
      }

    } catch (final FileNotFoundException e) {
      System.out.println("File " + this.fileKandidat + " tidak ditemukan");
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
      s = new Scanner(new BufferedReader(new FileReader(this.fileTempat)));

      for (int i = 0; i < this.listBarang.listOfBarang.size(); i++) {
        buf = s.nextLine();

        j = 0;
        b = this.listBarang.listOfBarang.remove(i);
        while (buf.isEmpty()) {
          b.addJadwal(buf.charAt(j) == '1');
        }
        this.listBarang.listOfBarang.add(i, b);
      }

    } catch (final FileNotFoundException e) {
      System.out.println("File " + this.fileTempat + " tidak ditemukan");
    } finally {
      if (s != null) {
        s.close();
      }
    }
  }

}
