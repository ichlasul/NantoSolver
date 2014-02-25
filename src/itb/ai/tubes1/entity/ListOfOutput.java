package itb.ai.tubes1.entity;

import java.util.ArrayList;

public class ListOfOutput {
	
	public ArrayList<String> los;
	
	public ListOfOutput()
	{
		los = new ArrayList<String>();
	}
	
	public ArrayList<String> getListOfOutput(){
		return this.los;
	}
	
	public void printInfo(){
		int n = los.size();
		for(int i=0;i<n;i++){
			System.out.println(los.get(i));
		}
	}
	
	public void AddListOfOutput(String loss){
		los.add(loss);
	}

}
