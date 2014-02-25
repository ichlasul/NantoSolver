import itb.ai.tubes1.boundary.Input;
import itb.ai.tubes1.controller.Validator;
import itb.ai.tubes1.entity.ListOfBarang;
import itb.ai.tubes1.entity.ListOfCewek;
import itb.ai.tubes1.entity.ListOfOutput;
import itb.ai.tubes1.entity.Nanto;

import java.util.ArrayList;

public class Main {

  static Nanto nanto = null;
  static ListOfBarang lob = null;
  static ListOfCewek loc = null;
  static ListOfOutput loo = new ListOfOutput();
  static ArrayList<Integer> ai = new ArrayList<Integer>();
  static int waktu = 2;

  public static void main(final String[] args) {
    String output = "";
    Validator.loc = Main.loc;
    // testcase1();
    Main.testcaseinput();
    for (int i = 0; i < 100; i++) {
      output = Validator.funcRandom((Main.waktu * 7),
          Main.lob.getJumlahBarang(), Main.loc.getJumlahCewek());
      Main.loo.AddListOfOutput(output);
      final int en = Validator.funcEnlightment(output);
      Main.ai.add(en);
    }
    Main.loo.printInfo();
    System.out.println(output);
    for (int i = 0; i < Main.loc.getListOfCewek().size(); i++) {
      System.out.println(Main.loc.getListOfCewek().get(i)
          .getEnlightmentPerJam());
    }
    Main.loc.listOfCewek.get(0).printJadwal();
    System.out.println(Validator.bestEnlightment(Main.ai));
  }

  private static void testcaseinput() {
    Nanto nanto = null;
    ListOfCewek loc = null;
    ListOfBarang lob = null;

    final Input input = new Input("txt/umum.txt", "txt/kandidat.txt",
        "txt/tempat.txt");

    input.readFile();

    nanto = input.getNanto();
    nanto.printInfo();

    loc = input.getListCewek();
    loc.printInfo();

    lob = input.getListBarang();
    lob.printInfo();

  }
}
