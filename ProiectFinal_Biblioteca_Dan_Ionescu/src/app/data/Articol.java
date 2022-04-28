package app.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Articol extends Publicatie {
	
	public static int TERMEN_IMPRUMUT = 2; // saptamani
	public static double PENALIZARE = 0.1; // pe zi
	protected String publicatie;
	protected LocalDate dataPublicatiei;
	
	//date formater pt dataPublicatiei
	DateTimeFormatter formatDataPublicatie = DateTimeFormatter.ofPattern("dd.MM.uuuu");
	
	public Articol(String autor, String titlu, String categorie, String publicatie, LocalDate dataPublicatiei) {
		this.autor = autor;
		this.titlu = titlu;
		this.categorie = categorie;
		this.publicatie = publicatie;
		this.dataPublicatiei = dataPublicatiei;
	}
	
	@Override
	public String toString() {
		
		return this.getId() +". " + autor + "    " + titlu + " " + publicatie +" " + categorie + " " + " " + dataPublicatiei.format(formatDataPublicatie);
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
