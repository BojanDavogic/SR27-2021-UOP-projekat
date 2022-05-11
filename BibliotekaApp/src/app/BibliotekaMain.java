package app;

import model.Administrator;
import model.Bibliotekar;
import model.Knjiga;
import model.PrimerakKnjige;
import model.Zanr;

public class BibliotekaMain {

	public static void main(String[] args) {
		BibliotekaApp biblioteka = new BibliotekaApp();
		
//		biblioteka.ucitajZanrove();
		biblioteka.ucitajKnjige(); //Ucitava zanrove iz ucitajKnjige()
		biblioteka.ucitajAdministratore();
		biblioteka.ucitajBibliotekare();
		biblioteka.ucitajPrimerkeKnjige();
		System.out.println("PODACI UCITANI IZ DATOTEKA: ");
		System.out.println("------------------------------------------------");
		ispisiSvePodatke(biblioteka);

	}
	
	public static void ispisiSvePodatke(BibliotekaApp biblioteka) {
		for(Zanr zanr: biblioteka.getZanrovi()) {
			System.out.println(zanr + "\n");
		}
		
		for(Knjiga knjiga: biblioteka.getKnjige()) {
			System.out.println(knjiga + "\n");
		}
		
		for(Administrator admin: biblioteka.getAdministratori()) {
			System.out.println(admin + "\n");
		}
		
		for(Bibliotekar bibliotekar: biblioteka.getBibliotekari()) {
			System.out.println(bibliotekar + "\n");
		}
		
		for(PrimerakKnjige primerak: biblioteka.getPrimerci()) {
			System.out.println(primerak + "\n");
		}
		
		
	}

}
