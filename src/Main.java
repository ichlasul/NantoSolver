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
	input = new Input("txt/umum.txt", "txt/kandidat.txt", "txt/tempat.txt");
	input.readFile();
	nanto = input.getNanto();
	listBarang = input.getListBarang();
	listCewek = input.getListCewek();
	mall = input.getMall();
	gym = input.getGymnasium();
	input.getCafe();
	input.getUniversity();
    }
}
