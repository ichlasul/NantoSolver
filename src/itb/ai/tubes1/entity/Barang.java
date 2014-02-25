package itb.ai.tubes1.entity;

import java.util.ArrayList;

public class Barang {
  // atribut
  private String nama;
  private char kode;
  private int harga;
  private int restockPerHari;

  private final ArrayList<Boolean> jadwal;

  // ctor
  public Barang() {
    this.nama = "";
    this.kode = 'A';
    this.harga = 0;
    this.restockPerHari = 0;
    this.jadwal = new ArrayList<>();
  }

  public Barang(final String _nama, final char _kode, final int _harga,
      final int _restockPerHari) {
    this.nama = _nama;
    this.kode = _kode;
    this.harga = _harga;
    this.restockPerHari = _restockPerHari;
    this.jadwal = new ArrayList<>();
  }

  // getter
  public String getNama() {
    return this.nama;
  }

  public char getKode() {
    return this.kode;
  }

  public int getHarga() {
    return this.harga;
  }

  public int getRestockPerHari() {
    return this.restockPerHari;
  }

  // setter
  public void setNama(final String _nama) {
    this.nama = _nama;
  }

  public void setKode(final char _kode) {
    this.kode = _kode;
  }

  public void setHarga(final int _harga) {
    this.harga = _harga;
  }

  public void setRestockPerHari(final int _restockPerHari) {
    this.restockPerHari = _restockPerHari;
  }

  public void addJadwal(final boolean open) {
    this.jadwal.add(open);
  }

}
