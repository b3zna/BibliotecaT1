package app.data;

import java.time.LocalDate;

import app.data.Exceptii.NuImprumutatException;

public interface Imprumutabil {
	
	void imprumuta(LocalDate dataImprumut) throws Exception;
	void returneaza(LocalDate dataRetur) throws NuImprumutatException;
	double calculPenalizare(LocalDate dataRetur);


}
