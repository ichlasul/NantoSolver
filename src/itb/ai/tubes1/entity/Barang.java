package itb.ai.tubes1.entity;

import java.util.ArrayList;

public class Barang {
    // atribut
    private String nama;
    private char kode;
    private int harga;
    private int restockPerHari;

    private ArrayList<Boolean> jadwal;

    // ctor
    public Barang() {
	nama = "";
	kode = 'A';
	harga = 0;
	restockPerHari = 0;
	jadwal = new ArrayList<>();
    }

    public Barang(String _nama, char _kode, int _harga, int _restockPerHari) {
	nama = _nama;
	kode = _kode;
	harga = _harga;
	restockPerHari = _restockPerHari;
	jadwal = new ArrayList<>();
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

    public void addJadwal(boolean open) {
	jadwal.add(open);
    }

}
