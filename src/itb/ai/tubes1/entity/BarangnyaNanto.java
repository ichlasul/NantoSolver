package itb.ai.tubes1.entity;

// 19 Februari 2014

public class BarangnyaNanto {

  // Atribut barang
  // final String Cokelat = "A";
  // final String Bunga = "B";
  // final String martabakManis = "C";
  // final String Permen = "D";
  int kuantitasCokelat;
  int kuantitasBunga;
  int kuantitasMartabakManis;
  int kuantitasPermen;

  // Konstruktor
  public BarangnyaNanto() {
    this.kuantitasCokelat = 0;
    this.kuantitasBunga = 0;
    this.kuantitasMartabakManis = 0;
    this.kuantitasPermen = 0;
  }

  // Override
  public BarangnyaNanto(final int kuantitasCokelat, final int kuantitasBunga,
      final int kuantitasMartabakManis, final int kuantitasPermen) {
    this.kuantitasCokelat = kuantitasCokelat;
    this.kuantitasBunga = kuantitasBunga;
    this.kuantitasMartabakManis = kuantitasMartabakManis;
    this.kuantitasPermen = kuantitasPermen;
  }

  // Getter dan Setter
  public int getKuantitasCokelat() {
    return this.kuantitasCokelat;
  }

  public void setKuantitasCokelat(final int kuantitasCokelat) {
    this.kuantitasCokelat = kuantitasCokelat;
  }

  public int getKuantitasBunga() {
    return this.kuantitasBunga;
  }

  public void setKuantitasBunga(final int kuantitasBunga) {
    this.kuantitasBunga = kuantitasBunga;
  }

  public int getKuantitasMartabakManis() {
    return this.kuantitasMartabakManis;
  }

  public void setKuantitasMartabakManis(final int kuantitasMartabakManis) {
    this.kuantitasMartabakManis = kuantitasMartabakManis;
  }

  public int getKuantitasPermen() {
    return this.kuantitasPermen;
  }

  public void setKuantitasPermen(final int kuantitasPermen) {
    this.kuantitasPermen = kuantitasPermen;
  }

  // Operasi terhadap value atribut
  public void addCokelat(final int cokelat) {
    this.kuantitasCokelat += cokelat;
  }

  public void addBunga(final int bunga) {
    this.kuantitasBunga += bunga;
  }

  public void addMartabakManis(final int martabakManis) {
    this.kuantitasMartabakManis += martabakManis;
  }

  public void addPermen(final int permen) {
    this.kuantitasPermen += permen;
  }

  public void subCokelat(final int cokelat) {
    this.kuantitasCokelat -= cokelat;
  }

  public void subBunga(final int bunga) {
    this.kuantitasBunga -= bunga;
  }

  public void subMartabakManis(final int martabakManis) {
    this.kuantitasMartabakManis -= martabakManis;
  }

  public void subPermen(final int permen) {
    this.kuantitasPermen -= permen;
  }

  public boolean isPunyaCokelat() {
    return this.kuantitasCokelat > 0;
  }

  public boolean isPunyaBunga() {
    return this.kuantitasBunga > 0;
  }

  public boolean isPunyaMartabakManis() {
    return this.kuantitasMartabakManis > 0;
  }

  public boolean isPunyaPermen() {
    return this.kuantitasPermen > 0;
  }

  public boolean isPunyaBarangX(final String X) {
    switch (X) {
      case "A":
        return this.isPunyaCokelat();
      case "B":
        return this.isPunyaBunga();
      case "C":
        return this.isPunyaMartabakManis();
      case "D":
        return this.isPunyaPermen();
      case "-":
        return true;
      default:
        return false;
    }
  }

  // DEBUG
  public void printInfo() {
    System.out.println("Kuantitas cokelat = " + this.kuantitasCokelat
        + "\nKuantitas bunga = " + this.kuantitasBunga
        + "\nKuantitas martabak manis = " + this.kuantitasMartabakManis
        + "\nKuantitas permen = " + this.kuantitasPermen);
  }
}
