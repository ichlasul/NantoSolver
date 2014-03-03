package itb.ai.tubes1;

import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.controller.Solution;
import itb.ai.tubes1.controller.Validator;
import itb.ai.tubes1.controller.ga.Fitness;
import itb.ai.tubes1.controller.ga.GeneticAlgorithm;
import itb.ai.tubes1.controller.ga.Population;
import itb.ai.tubes1.entity.Barang;
import itb.ai.tubes1.entity.Cafe;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.Gymnasium;
import itb.ai.tubes1.entity.Jadwal;
import itb.ai.tubes1.entity.Mall;
import itb.ai.tubes1.entity.Nanto;
import itb.ai.tubes1.entity.University;

import java.util.ArrayList;

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
		initialize();
		//main1();
		main2();
	}

	private static void initialize() {
		// Mendapatkan input
		input = new Input("txt/umum.txt", "txt/kandidat.txt", "txt/tempat.txt");
		input.readFile();
		nanto = input.getNanto();
		listBarang = input.getListBarang();
		listCewek = input.getListCewek();
		mall = input.getMall();
		gym = input.getGymnasium();
		cafe = input.getCafe();
		univ = input.getUniversity();
	}
	
	private static void main1() {
		Validator val = new Validator();
		Solution sol = new Solution(listCewek.size(),
				listBarang.size());
		for (int i = 0; i < 10; i++) {
			sol.randomSolution();
			if (val.isValid(sol, nanto, listBarang, listCewek, mall, gym, cafe,
					univ)) {
				System.out.println("OKE");
				System.out.println(sol.toString());
			}
		}
		// test print
		System.out.println(nanto);
		for (Barang barang : listBarang) {
			System.out.println(barang);
		}
		for (Cewek cewek : listCewek) {
			System.out.println(cewek);
		}
		System.out.println(mall);
		System.out.println(gym);
		System.out.println(cafe);
		System.out.println(univ);
	}
	
	private static void main2() {
		Population<Solution> population = new Solution(listCewek.size(),
				listBarang.size()).randomPopulation();

		Fitness<Solution, Integer> fitness = new Validator();

		GeneticAlgorithm<Solution, Integer> ga =
				new GeneticAlgorithm<Solution,Integer>(population, fitness);

		//addListener(ga);

		ga.evolve(500);
		
	}
}
