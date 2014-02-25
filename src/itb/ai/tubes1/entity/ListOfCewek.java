package itb.ai.tubes1.entity;

// 19 Februari 2014
import java.util.ArrayList;

public class ListOfCewek {

    // Atribut
    public ArrayList<Cewek> listOfCewek;
    int jumlahCewek;

    // Konstruktor
    public ListOfCewek() {
	listOfCewek = new ArrayList<Cewek>();
	this.jumlahCewek = 0;
    }

    // Getter dan Setter
    public ArrayList<Cewek> getListOfCewek() {
	return this.listOfCewek;
    }

    public void setListOfCewek(ArrayList<Cewek> listOfCewek) {
	this.listOfCewek = listOfCewek;
    }

    // Add cewek ke list
    public void addCewek(Cewek cewek) {
	listOfCewek.add(cewek);
	jumlahCewek++;
    }

    public int getJumlahCewek() {
	return this.jumlahCewek;
    }

    // DEBUG
    public void printInfo() {
	System.out.println("Jumlah cewek: " + this.jumlahCewek);
    }
}
