package itb.ai.tubes1.controller;
import java.util.Random;

public class Validator {
		
   public static String funcRandom(int jmlHari, int jmlW,int jmlB){//JmlW = Jumlah Wanita
	   Random r = new Random();
	   int totalJam = jmlHari*12;
	   StringBuilder s = new StringBuilder(5+jmlW+jmlB);
	   String alphabet = "gmcu0"; // String Default
	   for (int i=1;i<jmlW+1;i++){
		   alphabet = alphabet+i;	// String Default + Jumlah wanita
	   }
	   for(int j = 1;j<jmlB+1;j++){
		   alphabet = alphabet+(char)(64+j);
		   
	   }
	   for (int i = 0; i < (totalJam); i++) {
	    	char tempChar = alphabet.charAt(r.nextInt(alphabet.length()));
	    	s.append(tempChar);
	   }
	   
	   return s.toString();  // return String Random
   }
   
   public int funcEnlightment(String stringValid){
	   int en=0;
	   char tempchar;
	   for(int i=0;i<stringValid.length();i++){
		   tempchar = stringValid.charAt(i);
		   if(tempchar == '1'){
			   en += 12; // misal 12 enlightmeny dari wanita 1
		   }
		   if(tempchar == '2'){}
		   if(tempchar == '3'){}
		   if(tempchar == '4'){}
		   if(tempchar == '5'){}
		   if(tempchar == '6'){}
		   if(tempchar == '7'){}
		   if(tempchar == '8'){}
		   if(tempchar == '9'){}
		   // lakukan untuk n wanita
	   }
	   
	   return en;
   }
	
   public static void main (String args[]) {
	   
	   
	int[][] jadwal = {{1,1,0,0,0,0,0,1,1,0,0,1},
					  {0,0,1,1,1,0,0,0,0,1,1,0},
					  {1,1,1,1,1,0,0,1,1,0,0,0},// jadwal ? ini jadwal dengan 1 wanita aja ya ? hhe
					  {0,0,0,0,0,1,1,1,1,0,0,0},
					 };
	int[][] tempat = {{1,1,1,1,1,1,1,1,1,1,1,1},
					  {0,0,1,1,1,1,1,1,1,0,0,0},
					  {0,0,0,0,0,0,0,1,1,1,1,1}, // tempat merepresentasikan apa ? 1 ini menandakan 1 tempat aja ?
					  {1,1,1,1,1,1,1,1,1,0,0,0},
					};
	// Dummy wanitanya dimana bis ? biar bisa diitung enlightmentnya wanita punya enligtment tertentu
	String num;
	int tempint,j;
	char tempchar;
	try {
		System.out.print("Masukkan cek:");
		String stringRandom = funcRandom(1,2,4);
		System.out.println(stringRandom);
		num = stringRandom;
		for(int i=0;i<num.length();i++){
			tempchar = num.charAt(i);
			tempint = Character.getNumericValue(num.charAt(i));
			if (tempchar=='m' || tempchar=='g' || tempchar=='c' || tempchar=='u'){
				if(tempchar=='m'){j=0;}
				else if(tempchar=='g'){j=1;}
				else if(tempchar=='c'){j=2;}
				else j=3;
				if(tempat[j][i]!=1) throw new Exception();
			}
			else if (tempint<=4&& tempint>=1){
				j=tempint-1;
				if(jadwal[j][i]!=1) throw new Exception();			
			}
			else if (tempchar>='A' && tempchar<='D'){
			}
			else if (tempchar=='0'){
			
			}
			else throw new Exception();
		}
		System.out.println("Benar");
	} catch (Exception s) {
		System.out.println( "Masukan Salah");
	}
		System.out.println( "---------------");
	}
}