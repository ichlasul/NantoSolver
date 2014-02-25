import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.entity.BarangnyaNanto;
import itb.ai.tubes1.entity.Cewek;
import itb.ai.tubes1.entity.ListOfBarang;
import itb.ai.tubes1.entity.ListOfCewek;
import itb.ai.tubes1.entity.Nanto;



public class Main {
	public static void main(String[] args)
	{
		//testcase1();
		testcaseinput();
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

	private static void testcase1() {
		Nanto nanto1 = new Nanto();
		Nanto nanto2 = new Nanto(12, 13, 14, 15, 16, 17, 18);
		nanto1.printInfo(); System.out.println();
		nanto2.printInfo(); System.out.println();
		nanto2.addBrain(40); nanto2.addCharm(50); nanto2.addCurrentEnergi(40); nanto2.addStrength(40); nanto2.addUang(10000);
		System.out.println(); System.out.println();
		
		Cewek cewek1 = new Cewek();
		Cewek cewek2 = new Cewek(20, 21, 22, "ABC", 23, 24, 25);
		cewek1.printInfo(); System.out.println();
		cewek2.printInfo(); System.out.println(); System.out.println();
		
		ListOfCewek loc = new ListOfCewek();
		loc.addCewek(cewek1); loc.addCewek(cewek2);
		loc.printInfo(); System.out.println(); System.out.println();
		
		BarangnyaNanto bn1 = new BarangnyaNanto();
		BarangnyaNanto bn2 = new BarangnyaNanto(15, 20, 30, 40);
		bn1.printInfo(); System.out.println();
		bn2.printInfo(); System.out.println();
		bn2.subCokelat(10); bn2.subBunga(10); bn2.subMartabakManis(10); bn2.subPermen(10);
		bn2.printInfo(); System.out.println(); System.out.println();
		
		//nanto1.setBarangnyaNanto(bn2);
		//nanto2.setBarangnyaNanto(bn1);
		System.out.println(nanto1.isPrerequisiteLengkap(cewek2.getPrerequisite()) + "");
		System.out.println(nanto2.isPrerequisiteLengkap(cewek2.getPrerequisite()) + "");
	}
}
