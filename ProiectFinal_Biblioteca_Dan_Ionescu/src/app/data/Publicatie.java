package app.data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import app.data.Exceptii.NuImprumutatException;

public abstract class Publicatie extends Item implements Imprumutabil {
	
	protected String autor;
	protected String titlu;
	protected String categorie;
	
	
	protected LocalDate dataImprumut;
	
	public boolean isDisponibil() {
		
		return disponibil;
	}
	
	public void setDisponibil(boolean disponibil) {
		this.disponibil = disponibil;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getCategorie() {
		return categorie;
	}
	
//	public int getTermen(Object o) { //TERMEN_IMPRUMUT
//		 if( o instanceof Carte) {
//			 return Carte.TERMEN_IMPRUMUT;
//		 } else
//			 return Articol.TERMEN_IMPRUMUT;		 
//	}
	abstract public int getTermen();
	
	abstract public double getPenalizare(); // PENALIZARE
		
	
	
	
	

	@Override
	public void imprumuta(LocalDate dataImprumut) throws Exception {		
		
		if(isDisponibil()) {			
			
			this.dataImprumut = dataImprumut;
			this.setDisponibil(false);
		} else {
			throw new Exception("Publicatia " + getId() + " este indisponibila!");
		}			

	}

	@Override
	public void returneaza(LocalDate dataRetur) throws NuImprumutatException {		
		
		if(!isDisponibil()) {
			
//			dataImprumut.plusWeeks(Carte.TERMEN_IMPRUMUT).isBefore(dataRetur)
			
			if(dataImprumut.plusWeeks(getTermen()).isBefore(dataRetur)) {
				setDisponibil(false);
				System.out.println("Termen depasit pentru publicatia " + this.getId() + "!"); 
				//calculPenalizare(dataRetur);
				//System.out.println("zile: " + calculPenalizare(dataRetur)); //test zile
				System.out.println("Penalizare: " + calculPenalizare(dataRetur) + " lei.");
//				System.out.println(dataImprumut.plusWeeks(getTermen()));
//				System.out.println(dataRetur);
				} else 
				this.setDisponibil(true);
			
			} else {
			
				throw new NuImprumutatException("Publicatia " + this.getId() + " nu poate fi returnata (nu a fost imprumutata)!");
			
		    }

	}

	@Override
	public double calculPenalizare(LocalDate dataRetur) {
		//numărul de zile după termenul de împrumut * PENALIZARE
		//LocalDate dataImprumutTermen = this.dataImprumut.plusWeeks(getTermen());
		double zile =  ChronoUnit.DAYS.between(dataImprumut.plusWeeks(getTermen()), dataRetur);
		return zile * getPenalizare();	
		//double zileDupa =  ChronoUnit.DAYS.between(dataImprumutTermen, dataRetur);
		//return zileDupa * getPenalizare();
	}

}
