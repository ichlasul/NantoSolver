import java.util.ArrayList;

import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.entity.Barang;
import itb.ai.tubes1.entity.Cafe;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.Gymnasium;
import itb.ai.tubes1.entity.Mall;
import itb.ai.tubes1.entity.Nanto;
import itb.ai.tubes1.entity.University;

public class Main {

    private static Input input;
    private static Nanto nanto;
    private static ArrayList<Barang> listBarang;
    private static ArrayList<Cewek> listCewek;
    private static Mall mall;
    private static Gymnasium gym;
    private static Cafe cafe;
    private static University univ;

    public static void main(String[] args) {
	//Mendapatkan input
	input = new Input("txt/umum.txt", "txt/kandidat.txt", "txt/tempat.txt");
	input.readFile();
	nanto = input.getNanto();
	listBarang = input.getListBarang();
	listCewek = input.getListCewek();
	mall = input.getMall();
	gym = input.getGymnasium();
	cafe = input.getCafe();
	univ = input.getUniversity();
	
	//test print
	System.out.println(nanto);
	for (Barang barang: listBarang) {
	    System.out.println(barang);
	}
	for (Cewek cewek: listCewek) {
	    System.out.println(cewek);
	}
	System.out.println(mall);
	System.out.println(gym);
	System.out.println(cafe);
	System.out.println(univ);
    }
}
