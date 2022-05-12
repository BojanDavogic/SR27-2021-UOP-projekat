package app;

import java.time.LocalDate;
import java.util.ArrayList;

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
		
		System.out.println("PODACI UCITANI IZ DATOTEKA: ");
		System.out.println("------------------------------------------------");
		ispisiSvePodatke(biblioteka);
		
		System.out.println("-------------------------------------------------");
		
		System.out.println("Dodavanje test podataka...");
		
		Zanr testZanr = new Zanr(5, "Bajka Test", "Test opis");
		biblioteka.dodajZanr(testZanr);
		
		Knjiga testKnjiga = new Knjiga(4567, "Test", "Test", "Test Test", 1953, "Test opis knjige Test",testZanr,Jezik.SPANSKI);
		biblioteka.dodajKnjigu(testKnjiga);
		
		PrimerakKnjige testPrimerakKnjige = new PrimerakKnjige(75, 326, 2018, true, testKnjiga, TipPoveza.MEKI, Jezik.PORTUGALSKI);
		biblioteka.dodajPrimerak(testPrimerakKnjige);
		
		PrimerakKnjige testPrimerakKnjige2 = new PrimerakKnjige(122, 315, 2003, true, testKnjiga, TipPoveza.MEKI, Jezik.ENGLESKI);
		biblioteka.dodajPrimerak(testPrimerakKnjige2);
		
		Administrator testAdministrator = new Administrator(989,"Marija", "Ivanovic", "1234467891555", "Test Test 21", Pol.ZENSKI, 72000.00, "MarijaIvanovic", "marija12331");
		biblioteka.dodajAdministratora(testAdministrator);
		
		Bibliotekar testBibliotekar = new Bibliotekar(999, "Tanja", "Tankosic", "1234567894333", "Test Test 35", Pol.ZENSKI, 62000.00, "TanjaTankosic", "tanja123");
		biblioteka.dodajBibliotekara(testBibliotekar);
		
		TipClanarine testTipClanarine = new TipClanarine(6,"Standardna", 150);
		biblioteka.dodajTipClanarine(testTipClanarine);
		
		ClanBiblioteke testClanBiblioteke = new ClanBiblioteke(902, "Ivan", "Ivanovic", "4321557891234", "Test Test 19", Pol.MUSKI, "17d", LocalDate.of(2022, 03, 15), 1, true, testTipClanarine);
		biblioteka.dodajClanaBiblioteke(testClanBiblioteke);
		
		Iznajmljivanje testIznajmljivanje = new Iznajmljivanje(225, LocalDate.of(2022, 04, 12), LocalDate.of(2022, 05, 12), 
				testBibliotekar, testClanBiblioteke);		
		testIznajmljivanje.getPrimerci().add(testPrimerakKnjige);
		testIznajmljivanje.getPrimerci().add(testPrimerakKnjige2);		
		biblioteka.dodajIznajmljivanje(testIznajmljivanje);		
		
		
		System.out.println("Snimanje dodatih podataka...");
		biblioteka.snimiZanrove(ZANROVI_FAJL);
		biblioteka.snimiKnjige(KNJIGE_FAJL);
		biblioteka.snimiPrimerkeKnjige(PRIMERCI_KNJIGE_FAJL);
		biblioteka.snimiAdministratore(ADMINISTRATORI_FAJL);
		biblioteka.snimiBibliotekare(BIBLIOTEKARI_FAJL);
		biblioteka.snimiTipClanarine(TIPOVI_CLANARINE_FAJL);
		biblioteka.snimiClanoveBiblioteke(CLANOVI_BIBLIOTEKE_FAJL);
		biblioteka.snimiIznajmljivanja(IZNAJMLJIVANJE_FAJL);

	}
	
	public static void ispisiSvePodatke(BibliotekaApp biblioteka) {
		for(Zanr zanr: biblioteka.getZanrovi().values()) {
			System.out.println(zanr);
		}
		System.out.println();
		
		for(Knjiga knjiga: biblioteka.getKnjige().values()) {
			System.out.println(knjiga);
		}
		System.out.println();
		
		for(PrimerakKnjige primerak: biblioteka.getPrimerci().values()) {
			System.out.println(primerak);
		}
		System.out.println();
		
		for(Administrator admin: biblioteka.getAdministratori().values()) {
			System.out.println(admin);
		}
		System.out.println();
		
		for(Bibliotekar bibliotekar: biblioteka.getBibliotekari().values()) {
			System.out.println(bibliotekar);
		}
		System.out.println();
		
		for(ClanBiblioteke clan: biblioteka.getClanoviBiblioteke().values()) {
			System.out.println(clan);
		}
		System.out.println();
		
		for(Iznajmljivanje iznajmljivanje: biblioteka.getIznajmljivanje().values()) {
			System.out.println(iznajmljivanje);
		}
		System.out.println();
		
		for(TipClanarine tipClanarine: biblioteka.getTipClanarine().values()) {
			System.out.println(tipClanarine);
		}
		System.out.println();

	}

}
