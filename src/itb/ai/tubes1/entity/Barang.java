package itb.ai.tubes1.entity;

public class Barang {

    private String nama;
    private char kode;
    private int harga;
    private int restockPerHari;


    public Barang() {
	kode = 'A';
	harga = 0;
	restockPerHari = 0;
	nama = "Cokelat";
    }

    public Barang(char _kode, int _harga, int _restockPerHari) {
	kode = _kode;
	harga = _harga;
	restockPerHari = _restockPerHari;
	
	if (kode == 'A') {
	    nama = "Cokelat";
	} else if (kode == 'B') {
	    nama = "Bunga";
	} else if (kode == 'C') {
	    nama = "Martabak Manis";
	} else if (kode == 'D') {
	    nama = "Permen";
	}
    }

    public Barang(char c) {
	kode = c;
	harga = 0;
	restockPerHari = 0;
    }

    // getter
    public char getKode() {
	return kode;
    }

    public int getHarga() {
	return harga;
    }

    public int getRestockPerHari() {
	return restockPerHari;
    }

    // setter
    public void setKode(char _kode) {
	kode = _kode;
    }

    public void setHarga(int _harga) {
	harga = _harga;
    }

    public void setRestockPerHari(int _restockPerHari) {
	restockPerHari = _restockPerHari;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + kode;
	return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Barang other = (Barang) obj;
	if (kode != other.kode) {
	    return false;
	}
	return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Barang [Nama=" + nama + ", Kode=" + kode + ", Harga=" + harga
		+ ", RestockPerHari=" + restockPerHari + "]";
    }
}
