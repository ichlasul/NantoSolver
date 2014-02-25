package entity;
// 19 Februari 2014

public class BarangnyaNanto {

	// Atribut barang
	//final String Cokelat = "A";
	//final String Bunga = "B";
	//final String martabakManis = "C";
	//final String Permen = "D";
	int kuantitasCokelat;
	int kuantitasBunga;
	int kuantitasMartabakManis;
	int kuantitasPermen;
	
	// Konstruktor
	public BarangnyaNanto()
	{
		this.kuantitasCokelat = 0;
		this.kuantitasBunga = 0;		
		this.kuantitasMartabakManis = 0;
		this.kuantitasPermen = 0;
	}
	
	// Override
	public BarangnyaNanto(int kuantitasCokelat, int kuantitasBunga, int kuantitasMartabakManis, int kuantitasPermen)
	{
		this.kuantitasCokelat = kuantitasCokelat;
		this.kuantitasBunga = kuantitasBunga;		
		this.kuantitasMartabakManis = kuantitasMartabakManis;
		this.kuantitasPermen = kuantitasPermen;
	}
	
	// Getter dan Setter
	public int getKuantitasCokelat() { return kuantitasCokelat; }
	public void setKuantitasCokelat(int kuantitasCokelat) { this.kuantitasCokelat = kuantitasCokelat; }
	public int getKuantitasBunga() { return kuantitasBunga; }
	public void setKuantitasBunga(int kuantitasBunga) { this.kuantitasBunga = kuantitasBunga; }
	public int getKuantitasMartabakManis() { return kuantitasMartabakManis; }
	public void setKuantitasMartabakManis(int kuantitasMartabakManis) { this.kuantitasMartabakManis = kuantitasMartabakManis; }
	public int getKuantitasPermen() { return kuantitasPermen; }
	public void setKuantitasPermen(int kuantitasPermen) { this.kuantitasPermen = kuantitasPermen; }
	
	// Operasi terhadap value atribut
	public void addCokelat(int cokelat) { this.kuantitasCokelat += cokelat; }
	public void addBunga(int bunga) { this.kuantitasBunga += bunga; }
	public void addMartabakManis(int martabakManis) { this.kuantitasMartabakManis += martabakManis; }
	public void addPermen(int permen) { this.kuantitasPermen += permen; }
	
	public void subCokelat(int cokelat) { this.kuantitasCokelat -= cokelat; }
	public void subBunga(int bunga) { this.kuantitasBunga -= bunga; }
	public void subMartabakManis(int martabakManis) { this.kuantitasMartabakManis -= martabakManis; }
	public void subPermen(int permen) { this.kuantitasPermen -= permen; }
	
	public boolean isPunyaCokelat() { return this.kuantitasCokelat > 0; }
	public boolean isPunyaBunga() { return this.kuantitasBunga > 0; }
	public boolean isPunyaMartabakManis() { return this.kuantitasMartabakManis > 0; }
	public boolean isPunyaPermen() { return this.kuantitasPermen > 0; }
	
	public boolean isPunyaBarangX(String X)
	{
		switch (X) {
			case "A" : return isPunyaCokelat();				
			case "B" : return isPunyaBunga();
			case "C" : return isPunyaMartabakManis();
			case "D" : return isPunyaPermen();
			case "-" : return true;
			default  : return false;			
		}	
	}
	
	//DEBUG
	public void printInfo()
	{
		System.out.println("Kuantitas cokelat = " + this.kuantitasCokelat +
						   "\nKuantitas bunga = " + this.kuantitasBunga +
						   "\nKuantitas martabak manis = " + this.kuantitasMartabakManis +
						   "\nKuantitas permen = " + this.kuantitasPermen
				);	
	}	
}
