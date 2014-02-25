package itb.ai.tubes1.entity;

public class Nanto {
	
	private int uang;
	
	private ListOfBarang listBarang; // Pake ini aja gitu?
	
	private int strength;
	
	private int charm;
	
	private int brain;
	
	private int energiPerHari; // Naksimal energi yang bisa dimiliki Nanto. Nilainya tetap
	
	private int currentEnergi; // Nilai energi yang SEDANG dimiliki Nanto.
	
	// Konstruktor
	public Nanto() {
		this.uang = 0;
		this.energiPerHari = 0;			
		this.strength = 0;
		this.charm = 0;
		this.brain = 0;

		this.currentEnergi = this.energiPerHari;
	}	
	
	// Override
	public Nanto(int uang, int waktu, int energiPerHari, int strength, int charm, int brain)
	{
		this.uang = uang;
		this.energiPerHari = energiPerHari;			
		this.strength = strength;
		this.charm = charm;
		this.brain = brain;	
		
		this.currentEnergi = this.energiPerHari;
	}
	
	// Override versi 2
	public Nanto(int uang, int waktu, int energiPerHari, int strength, int charm, int brain, int jumlahKandidat)
	{
		this.uang = uang;
		this.energiPerHari = energiPerHari;			
		this.strength = strength;
		this.charm = charm;
		this.brain = brain;	
		
		this.currentEnergi = this.energiPerHari;
	}
	
	// Override versi 3
	public Nanto(int uang, int waktu, int energiPerHari, int strength, int charm, int brain, int jumlahKandidat, BarangnyaNanto barangNanto)
	{
		this.uang = uang;
		this.energiPerHari = energiPerHari;			
		this.strength = strength;
		this.charm = charm;
		this.brain = brain;	
			
		this.currentEnergi = this.energiPerHari;
	}	
	
	// Getter dan setter
	public int getUang() { return uang; }
	public void setUang(int uang) { this.uang = uang; }
	
	public int getEnergiPerHari() { return energiPerHari; }
	public void setEnergiPerHari(int energiPerHari) { this.energiPerHari = energiPerHari; }
	
	public int getCurrentEnergi() { return currentEnergi; }
	public void setCurrentEnergi(int currentEnergi) { this.currentEnergi = currentEnergi; }
	
	public int getStrength() { return strength; }
	public void setStrength(int strength) { this.strength = strength; }
	
	public int getCharm() { return charm; }
	public void setCharm(int charm) { this.charm = charm; }
	
	public int getBrain() { return brain; }
	public void setBrain(int brain) { this.brain = brain; }
	
	// Operasi terhadap nilai atribut
	public void addUang(int uang) { this.uang += uang; }	
	public void addStrength(int strength) { this.strength += strength; }
	public void addCharm(int charm) { this.charm += charm; }
	public void addBrain(int brain) { this.brain += brain; }
	public void addCurrentEnergi(int currentEnergi) { this.currentEnergi += currentEnergi; }
	
	public void subUang(int uang) { this.uang -= uang; }	
	public void subStrength(int strength) { this.strength -= strength; }
	public void subCharm(int charm) { this.charm -= charm; }
	public void subBrain(int brain) { this.brain -= brain; }
	public void subCurrentEnergi(int currentEnergi) { this.currentEnergi -= currentEnergi; }
	
	//Mengembalikan energi ke nilai maksimum
	public void resetEnergi() { this.currentEnergi = this.energiPerHari; }
	
	//Cek apakah Nanto punya barang yang diinginkan cewek (prerequisite)
	//Prerequisite cewek bentuknya String
	//String tsb dikonversi ke array of String
	//Misal ABC --> ["A", "B", "C"]
	//Lalu cek apakah barang A/B/C ada atau tidak dengan mengakses atribut BarangnyaNanto
	public boolean isPrerequisiteLengkap(String prerequisite)
	{
		String[] enumeratedPrerequisite = prerequisite.split("(?!^)");		
		for (String kodeBarang : enumeratedPrerequisite) {
			//if (!barangNanto.isPunyaBarangX(kodeBarang))
		//		return false;
		}
		return true;
	}
	
	// DEBUG
	public void printInfo()
	{
		System.out.println("Uang = " + this.uang +
							"\nStrength = " + this.strength + "\nCharm = " + this.charm +
							"\nBrain = " + this.brain + "\nEnergi per hari = " + this.energiPerHari +
							"\nCurrent energi = " + this.currentEnergi
				);
	}
}
