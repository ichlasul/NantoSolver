package itb.ai.tubes1;

import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.controller.Solution;
import itb.ai.tubes1.controller.Validator;
import itb.ai.tubes1.controller.ga.Fitness;
import itb.ai.tubes1.controller.ga.GeneticAlgorithm;
import itb.ai.tubes1.controller.ga.IterationListener;
import itb.ai.tubes1.controller.ga.Population;
import itb.ai.tubes1.entity.Barang;
import itb.ai.tubes1.entity.Cafe;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.Gymnasium;
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
		Validator val = new Validator(nanto, listBarang, listCewek, mall, gym,
				cafe, univ);
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
				listBarang.size()).randomPopulation(8);
		
		for (Solution crs : population) {
			System.out.println(crs);
		}

		Fitness<Solution, Integer> fitness = new Validator(nanto, listBarang,
				listCewek, mall, gym, cafe, univ);

		GeneticAlgorithm<Solution, Integer> ga =
				new GeneticAlgorithm<Solution,Integer>(population, fitness);

		addListener(ga);
		
		//System.out.println("DEBUG1");

		ga.evolve(500);
		
		//System.out.println("DEBUG2");
		
	}

	private static void addListener(GeneticAlgorithm<Solution, Integer> ga) {
		System.out.println(String.format("%s\t%s\t%s", "iter", "fit",
				"chromosome"));

		// Lets add listener, which prints best chromosome after each iteration
		ga.addIterationListener(new IterationListener<Solution, Integer>() {

			private final double threshold = 1;

			@Override
			public void update(GeneticAlgorithm<Solution, Integer> ga) {

				Solution best = ga.getBest();
				int bestFit = ga.fitness(best);
				int iteration = ga.getIteration();

				// Listener prints best achieved solution
				System.out.println(String.format("%s\t%s\t%s", iteration,
						bestFit, best));

				// If fitness is satisfying - we can stop Genetic algorithm
				if (bestFit < this.threshold) {
					ga.terminate();
				}
			}
		});
	}
	
	
}
