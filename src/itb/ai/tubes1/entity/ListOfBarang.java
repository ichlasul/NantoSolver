package itb.ai.tubes1.entity;

import java.util.ArrayList;

public class ListOfBarang {

    // Atribut
    public ArrayList<Barang> listOfBarang;
    int jumlahBarang;

    // Konstruktor
    public ListOfBarang() {
	listOfBarang = new ArrayList<Barang>();
	this.jumlahBarang = 0;
    }

    // Getter dan Setter
    public ArrayList<Barang> getListOfbarang() {
	return this.listOfBarang;
    }

    public void setListOfBarang(ArrayList<Barang> listOfBarang) {
	this.listOfBarang = listOfBarang;
    }

    // Add cewek ke list
    public void addBarang(Barang barang) {
	listOfBarang.add(barang);
	jumlahBarang++;
    }

    public int getJumlahBarang() {
	return this.jumlahBarang;
    }

    // DEBUG
    public void printInfo() {
	System.out.println("Jumlah barang: " + this.jumlahBarang);
    }
}
