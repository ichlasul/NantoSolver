package itb.ai.tubes1.entity;

public class Tempat {
  // atribut
  private String nama;
  private int jumlahAtribut;
  private int jumlahEnergi;

  // ctor
  public Tempat() {
    this.nama = "";
    this.jumlahAtribut = 0;
    this.jumlahEnergi = 0;
  }

  public Tempat(final String _nama, final int _jumlahAtribut,
      final int _jumlahEnergi) {
    this.nama = _nama;
    this.jumlahAtribut = _jumlahAtribut;
    this.jumlahEnergi = _jumlahEnergi;
  }

  // getter
  public String getNama() {
    return this.nama;
  }

  public int getJumlahAtribut() {
    return this.jumlahAtribut;
  }

  public int getJumlahEnergi() {
    return this.jumlahEnergi;
  }

  // setter
  public void setNama(final String _nama) {
    this.nama = _nama;
  }

  public void setJumlahAtribut(final int _jumlahAtribut) {
    this.jumlahAtribut = _jumlahAtribut;
  }

  public void setJumlahEnergi(final int _jumlahEnergi) {
    this.jumlahEnergi = _jumlahEnergi;
  }

}
