package app.data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import app.data.Exceptii.IndisponibilException;
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
	
	abstract public int getTermen();
	
	abstract public double getPenalizare(); // PENALIZARE	

	@Override
	public void imprumuta(LocalDate dataImprumut) throws IndisponibilException {		
		
		if(isDisponibil()) {			
			
			this.dataImprumut = dataImprumut;
			this.setDisponibil(false);
		} else {
			throw new IndisponibilException("Publicatia " + getId() + " este indisponibila!");
		}			

	}

	@Override
	public void returneaza(LocalDate dataRetur) throws NuImprumutatException {		
		
		if(!isDisponibil()) {			
			
			if(dataImprumut.plusWeeks(getTermen()).isBefore(dataRetur)) {
				setDisponibil(false);
				System.out.println("Termen depasit pentru publicatia " + this.getId() + "!"); 
				System.out.println("Penalizare: " + calculPenalizare(dataRetur) + " lei.");
				} else 
				this.setDisponibil(true);
			
			} else {			
				throw new NuImprumutatException("Publicatia " + this.getId() + " nu poate fi returnata (nu a fost imprumutata)!");			
		    }
	}

	@Override
	public double calculPenalizare(LocalDate dataRetur) {
		//numărul de zile după termenul de împrumut * PENALIZARE
		double zile =  ChronoUnit.DAYS.between(dataImprumut.plusWeeks(getTermen()), dataRetur);
		return zile * getPenalizare();	
	}

}
