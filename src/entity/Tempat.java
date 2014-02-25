package entity;

public class Tempat {
	//atribut
	private String nama;
	private int jumlahAtribut;
	private int jumlahEnergi;
	
	//ctor
	public Tempat(){
		nama = "";
		jumlahAtribut = 0;
		jumlahEnergi = 0;
	}
	
	public Tempat(String _nama, int _jumlahAtribut, int _jumlahEnergi){
		nama = _nama;
		jumlahAtribut = _jumlahAtribut;
		jumlahEnergi = _jumlahEnergi;
	}
	
	// getter
	public String getNama(){
		return nama;
	}
	
	public int getJumlahAtribut(){
		return jumlahAtribut;
	}
	
	public int getJumlahEnergi(){
		return jumlahEnergi;
	}
	
	//setter
	public void setNama(String _nama){
		nama = _nama;
	}
	
	public void setJumlahAtribut(int _jumlahAtribut){
		jumlahAtribut = _jumlahAtribut;
	}
	
	public void setJumlahEnergi(int _jumlahEnergi){
		jumlahEnergi = _jumlahEnergi;
	}	
	
}
