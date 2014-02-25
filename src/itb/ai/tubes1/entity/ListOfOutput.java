package itb.ai.tubes1.entity;

import java.util.ArrayList;

public class ListOfOutput {

  public ArrayList<String> los;

  public ListOfOutput() {
    this.los = new ArrayList<String>();
  }

  public ArrayList<String> getListOfOutput() {
    return this.los;
  }

  public void printInfo() {
    final int n = this.los.size();
    for (int i = 0; i < n; i++) {
      System.out.println(this.los.get(i));
    }
  }

  public void AddListOfOutput(final String loss) {
    this.los.add(loss);
  }

}
