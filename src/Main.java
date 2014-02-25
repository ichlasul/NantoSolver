import java.util.ArrayList;

import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.controller.Validator;
import itb.ai.tubes1.entity.ListOfBarang;
import itb.ai.tubes1.entity.ListOfCewek;
import itb.ai.tubes1.entity.ListOfOutput;
import itb.ai.tubes1.entity.Nanto;

public class Main {
	
	static Nanto nanto =null;
	static ListOfBarang lob = null;
	static ListOfCewek loc = null;
	static ListOfOutput loo = new ListOfOutput();
	static ArrayList<Integer> ai = new ArrayList<Integer>();
	static int waktu = 2;
	
	public static void main(String[] args)
	{
		String output = "";
		Validator.loc = loc;
		//testcase1();
		testcaseinput();
		for(int i=0;i<100;i++){
			output = Validator.funcRandom((waktu*7),lob.getJumlahBarang(),loc.getJumlahCewek());
			loo.AddListOfOutput(output);
			int en = Validator.funcEnlightment(output);
			ai.add(en);
		}
		loo.printInfo();
		System.out.println(output);
		for (int i=0;i<loc.getListOfCewek().size();i++){
			System.out.println(loc.getListOfCewek().get(i).getEnlightmentPerJam());
		}
		loc.listOfCewek.get(0).printJadwal();
		System.out.println(Validator.bestEnlightment(ai));
	}

	private static void testcaseinput() {
		Nanto nanto = null;
		ListOfCewek loc = null;
		ListOfBarang lob = null;
		
		Input input = new Input("txt/umum.txt", "txt/kandidat.txt", "txt/tempat.txt");
		
		input.readFile();
		
		nanto = input.getNanto();
		nanto.printInfo();
		
		loc = input.getListCewek();
		loc.printInfo();
		
		lob = input.getListBarang();
		lob.printInfo();
		
	}
}
