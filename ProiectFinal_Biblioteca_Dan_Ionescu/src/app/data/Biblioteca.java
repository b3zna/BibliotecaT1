package app.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import app.data.Exceptii.NuImprumutatException;

public class Biblioteca {
	
	private List<Publicatie> publicatii = new ArrayList<>();
	private List<Media> media = new ArrayList<>();
	
	//Publicatii
	public void adaugaPublicatie(Publicatie publicatie) {
		
		publicatii.add(publicatie);
		publicatie.setId(publicatii.size());
		publicatie.setDisponibil(true);
	}	
	
	public void catalogPublicatii() {
		System.out.println("Catalog publicatii:");
		for(Publicatie p : publicatii ) {
			System.out.println(p);
		}
	}
	
	public void publicatiiDisponibile() {
		System.out.println("Publicatii disponibile:");
		for(Publicatie p : publicatii) {
			if(p.isDisponibil()) {
				System.out.println(p);
			}
		}
	}
	
	public void publicatiiImprumutate() {
		System.out.println("Publicatii imprumutate:");
		
		for(Publicatie p : publicatii) {			
			if(!p.isDisponibil()) {
				System.out.println(p);
			}
			
		}
	}
	
	
	public void consultarePublicatieDupaCategorie(String categorie) {
		System.out.println("Publicatii in categoria " + categorie + ":");
		for(Publicatie p : publicatii) {
			if(p.getCategorie().equals(categorie)){
				System.out.println(p);
			}
		}
	}
	
	public void consultarePublicatieDupaAutor(String autor) {
		System.out.println("Publicatii scrise de " + autor + ":");
		for(Publicatie p : publicatii) {
			if(p.getAutor().equals(autor)){
				System.out.println(p);
			}
		}
	}
	
	public void imprumutaPublicatie(int id, LocalDate dataImprumut) throws Exception {
		
		
		try {
			publicatii.get(id - 1).imprumuta(dataImprumut);
			
			System.out.println("Publicatia " + id + " a fost imprumutata.");
		} catch (Exception e) {
			//e.printStackTrace();
			//System.out.println("lol e deja data");
			System.out.println("Publicatia " + id + " nu a fost gasita!");			
		}
		
	}
	
	public void returneazaPublicatie(int id, LocalDate dataRetur) {
		
		try {
			
			publicatii.get(id - 1).returneaza(dataRetur);
			if(this.publicatii.get(id - 1).isDisponibil()) {
			System.out.println("publicatia " + id + " a fost returnata.");
			}
			
		} catch(IndexOutOfBoundsException i) {
			System.out.println("Publicatia " + id + " nu a fost gasita!");
		} catch(NuImprumutatException n) {
			System.out.println(n.getMessage());
		}		
	}
	
	
	//Media
	public void adaugaMedia(Media media) {			
		
		this.media.add(media);
		//media.setId(this.media.size());
		media.setId(this.media.size() + publicatii.size());
		media.disponibil = true;
		
	}
	
	public void catalogMedia() {
		System.out.println("Catalog media:");		
		
		for(Media m :media) {
			System.out.println(m);
		}			
	}
	
	public int getMediaId(int id) {
		return id - publicatii.size();
	}
	
	public void consultaMedia(int id) {		
		
		try {
			
		this.media.get(getMediaId(id)).consulta();
		//this.mediaList.get(id - 1).disponibil = false;
		//System.out.println("Media " + this.media.get(id - 1) + " este in consultare.");
		System.out.println("Media " + id + " este in consultare.");
		
		} catch(IndexOutOfBoundsException i) {
			System.out.println("Media " + id + " nu a fost gasita!");
		} 				
	}
	
	public void elibereazaMedia(int id) {
		
		try {
			this.media.get(getMediaId(id)).disponibil = true;
			System.out.println("Media " + id + " este libera.");
			
		}catch(IndexOutOfBoundsException i) {
			System.out.println("Media " + id + " nu a fost gasita!");
		} 				
	}
	
	
	
	
	
	

}
