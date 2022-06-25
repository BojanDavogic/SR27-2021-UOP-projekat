package app;

import gui.Login;
import gui.PocetniProzor;


public class BibliotekaMain {
	public static String KNJIGE_FAJL = "Knjige.txt";
	public static String ZANROVI_FAJL = "Zanrovi.txt";
	public static String ADMINISTRATORI_FAJL = "Administratori.txt";
	public static String BIBLIOTEKARI_FAJL = "Bibliotekari.txt";
	public static String PRIMERCI_KNJIGE_FAJL = "PrimerciKnjige.txt";
	public static String CLANOVI_BIBLIOTEKE_FAJL = "ClanoviBiblioteke.txt";
	public static String IZNAJMLJIVANJE_FAJL = "Iznajmljivanje.txt";
	public static String TIPOVI_CLANARINE_FAJL = "TipClanarine.txt";
	public static String BIBLIOTEKA_FAJL = "Biblioteka.txt";

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
		biblioteka.ucitajBiblioteku();
		
		PocetniProzor pp = new PocetniProzor(biblioteka);
		pp.setVisible(true);
	}

}
