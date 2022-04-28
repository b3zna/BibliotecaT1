package app.data;

public class Carte extends Publicatie {
	
	public static int TERMEN_IMPRUMUT = 4; //saptamani
	public static double PENALIZARE = 0.5; // pe zi
	protected int anPublicatie;
	
	public Carte(String autor, String titlu, int anPublicatie, String categorie) {
		
		this.autor = autor;
		this.titlu = titlu;
		this.anPublicatie = anPublicatie;
		this.categorie = categorie;
	}
	
	
	
	@Override
	public String toString() {
		
		return this.getId() +". " + autor + "    " + titlu + " " + anPublicatie +" " + categorie;
	}
	
	@Override
	public double getPenalizare() {
		return PENALIZARE;
	}

	@Override
	public int getTermen() {
		return TERMEN_IMPRUMUT;
	}	

}
