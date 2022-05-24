package app;

import java.time.LocalDate;

import gui.Login;
import model.Administrator;
import model.Bibliotekar;
import model.ClanBiblioteke;
import model.Iznajmljivanje;
import model.Jezik;
import model.Knjiga;
import model.Pol;
import model.PrimerakKnjige;
import model.TipClanarine;
import model.TipPoveza;
import model.Zanr;

public class BibliotekaMain {
	protected static String KNJIGE_FAJL = "Knjige.txt";
	protected static String ZANROVI_FAJL = "Zanrovi.txt";
	protected static String ADMINISTRATORI_FAJL = "Administratori.txt";
	protected static String BIBLIOTEKARI_FAJL = "Bibliotekari.txt";
	protected static String PRIMERCI_KNJIGE_FAJL = "PrimerciKnjige.txt";
	protected static String CLANOVI_BIBLIOTEKE_FAJL = "ClanoviBiblioteke.txt";
	protected static String IZNAJMLJIVANJE_FAJL = "Iznajmljivanje.txt";
	protected static String TIPOVI_CLANARINE_FAJL = "TipClanarine.txt";

	public static void main(String[] args) {
		BibliotekaApp biblioteka = new BibliotekaApp();
		
		biblioteka.ucitajZanrove();
		biblioteka.ucitajKnjige();
		biblioteka.ucitajPrimerkeKnjige();
		biblioteka.ucitajAdministratore();
		biblioteka.ucitajBibliotekare();
		biblioteka.ucitajTipClanarine();
		biblioteka.ucitajClanoveBiblioteke();
		biblioteka.ucitajIznajmljivanje();
		
		Login login = new Login(biblioteka);
		login.setVisible(true);
	}

}
