package app;

import java.time.LocalDate;

import app.data.AlbumMuzica;
import app.data.Articol;
import app.data.Biblioteca;
import app.data.Carte;
import app.data.CategorieFilm;
import app.data.CategorieMuzica;
import app.data.CategoriePublicatie;
import app.data.Film;

public class BibliotecaApp {
	
	private static Biblioteca getBibliotecaPopulata() {
		Biblioteca biblioteca = new Biblioteca();
		
		biblioteca.adaugaPublicatie(new Carte("Jonathan Coe", "Casa somnului", 1997, CategoriePublicatie.FICTIUNE));
		biblioteca.adaugaPublicatie(new Carte("Anna Gavalda", "Impreuna", 2004, CategoriePublicatie.FICTIUNE));
		biblioteca.adaugaPublicatie(new Articol("Pavel Carol", "Scurta istorie a macaroanelor", CategoriePublicatie.STIINTA, "Good Food", LocalDate.of(2011, 10, 3)));
		biblioteca.adaugaPublicatie(new Articol("John Meyer", "Internetul in mileniul 3", CategoriePublicatie.STIINTA, "The Scientist", LocalDate.of(1999, 12, 1)));
		biblioteca.adaugaPublicatie(new Carte("Neagu Djuvara", "O scurta istorie ilustrata a romanilor", 2013, CategoriePublicatie.ISTORIE));
		biblioteca.adaugaPublicatie(new Carte("Frank Herbert", "Dune", 1965, CategoriePublicatie.SF));
		biblioteca.adaugaPublicatie(new Articol("Francois Auteuil", "Limba franceza a evului mediu", CategoriePublicatie.ISTORIE, "Journal de l'Academie Francaise", LocalDate.of(1867, 6, 17)));
		biblioteca.adaugaPublicatie(new Articol("Ygor Swozkowicz", "Plante farmaceutice", CategoriePublicatie.STIINTA, "British Journal of Natural History", LocalDate.of(1960, 10, 9)));
		biblioteca.adaugaPublicatie(new Carte("Franz Kafka", "Procesul", 1925, CategoriePublicatie.FICTIUNE));
		
		biblioteca.adaugaMedia(new Film("DVD", "Inglorious Basterds", 2009, CategorieFilm.ACTIUNE, "Quentin Tarantino"));
		biblioteca.adaugaMedia(new Film("Blu-Ray", "Casablanca", 1941, CategorieFilm.DRAMA, "Michael Curtiz"));
		biblioteca.adaugaMedia(new Film("Blu-Ray", "Superbad", 2007, CategorieFilm.COMEDIE, "Greg Mottola"));
		biblioteca.adaugaMedia(new Film("HDDVD", "BD la munte si la mare", 1971, CategorieFilm.COMEDIE, "Mircea Dragan"));
		biblioteca.adaugaMedia(new AlbumMuzica("CD", "Pink Floyd", "The Wall", CategorieMuzica.ROCK));
		biblioteca.adaugaMedia(new AlbumMuzica("Vinil", "Orchestra Filarmonica Viena", "Beethoven - Simfonia nr. 5", CategorieMuzica.CLASICA));
		biblioteca.adaugaMedia(new AlbumMuzica("CD", "Stromae", "Racine Carree", CategorieMuzica.POP));
		biblioteca.adaugaMedia(new AlbumMuzica("CD", "Satyricon", "The Age of Nero", CategorieMuzica.ROCK));	
		
		return biblioteca;		
	}

	
	public static void main(String[] args) throws Exception {
		
		Biblioteca biblioteca = getBibliotecaPopulata();
		
		
		
		//Cazul 1
		biblioteca.catalogPublicatii();
		biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 20));
		biblioteca.returneazaPublicatie(3, LocalDate.of(2018, 1, 3));
		
		//Cazul 2
//		biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 20));
//		biblioteca.publicatiiImprumutate();
//		biblioteca.returneazaPublicatie(4, LocalDate.of(2018, 1, 3));
		
		//Cazul 3
//		LocalDate data = LocalDate.of(2017, 11, 1);
//		biblioteca.imprumutaPublicatie(1, data);
//		biblioteca.imprumutaPublicatie(2, data);
//		biblioteca.imprumutaPublicatie(3, data);
//		biblioteca.imprumutaPublicatie(4, data);
//		biblioteca.imprumutaPublicatie(5, data);
//		biblioteca.publicatiiDisponibile();
		
		//Cazul 4
//		biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 1));
//		biblioteca.publicatiiImprumutate();
//		biblioteca.returneazaPublicatie(3, LocalDate.of(2018, 2, 2));
		
		//Cazul 5
//		biblioteca.consultarePublicatieDupaCategorie(CategoriePublicatie.FICTIUNE);
//		biblioteca.imprumutaPublicatie(2, LocalDate.now());
//		biblioteca.imprumutaPublicatie(2, LocalDate.now());
		
		//Cazul 6
//		biblioteca.consultarePublicatieDupaAutor("Neagu Djuvara");
//		biblioteca.imprumutaPublicatie(10, LocalDate.now());
//		biblioteca.returneazaPublicatie(11, LocalDate.now());
		
		//Cazul 7
//		biblioteca.imprumutaPublicatie(1, LocalDate.of(2017, 12, 10));
//		biblioteca.returneazaPublicatie(1, LocalDate.of(2017, 1, 3));
//		biblioteca.imprumutaPublicatie(2, LocalDate.of(2018, 1, 1));
//		biblioteca.returneazaPublicatie(2, LocalDate.of(2018, 3, 1));
//		
		//Cazul 8
//		biblioteca.catalogMedia();
//		biblioteca.consultaMedia(10);
//		biblioteca.elibereazaMedia(10);
		
		//Cazul 9
//		biblioteca.consultaMedia(20);
//		biblioteca.elibereazaMedia(21);
		
		//Cazul 10
//		biblioteca.consultaMedia(14);
//		biblioteca.elibereazaMedia(15);
//		biblioteca.consultaMedia(16);
//		biblioteca.elibereazaMedia(16);
		
		
		
		
	}
	
	
	
	
	

}
