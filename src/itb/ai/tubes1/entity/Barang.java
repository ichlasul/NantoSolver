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
	kode = 'A';
	harga = 0;
	restockPerHari = 0;
    }

    public Barang(char _kode, int _harga, int _restockPerHari) {
	kode = _kode;
	harga = _harga;
	restockPerHari = _restockPerHari;
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
}
