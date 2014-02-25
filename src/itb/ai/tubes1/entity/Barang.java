package itb.ai.tubes1.entity;

import java.util.ArrayList;

public class Barang {
    // atribut
    private String nama;
    private char kode;
    private int harga;
    private int restockPerHari;

    // ctor
    public Barang() {
	nama = "";
	kode = 'A';
	harga = 0;
	restockPerHari = 0;
    }

    public Barang(String _nama, char _kode, int _harga, int _restockPerHari) {
	nama = _nama;
	kode = _kode;
	harga = _harga;
	restockPerHari = _restockPerHari;
    }

    // getter
    public String getNama() {
	return nama;
    }

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
    public void setNama(String _nama) {
	nama = _nama;
    }

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
}
