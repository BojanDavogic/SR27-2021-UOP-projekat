package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

public class BibliotekaApp {
	
	private ArrayList<Knjiga> knjige;
	private ArrayList<PrimerakKnjige> primerci;
	private ArrayList<Administrator> administratori;
	private ArrayList<Bibliotekar> bibliotekari;
	private ArrayList<ClanBiblioteke> clanoviBiblioteke;
	private ArrayList<Zanr> zanrovi;
	private ArrayList<Iznajmljivanje> iznajmljivanje;
	private ArrayList<TipClanarine> tipClanarine;
	
	public BibliotekaApp() {
		this.knjige = new ArrayList<Knjiga>();
		this.primerci = new ArrayList<PrimerakKnjige>();
		this.administratori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanoviBiblioteke = new ArrayList<ClanBiblioteke>();
		this.zanrovi = new ArrayList<Zanr>();
		this.iznajmljivanje = new ArrayList<Iznajmljivanje>();
		this.tipClanarine = new ArrayList<TipClanarine>();
	}

	public BibliotekaApp(ArrayList<Knjiga> knjige, ArrayList<PrimerakKnjige> primerci,
			ArrayList<Administrator> administratori, ArrayList<Bibliotekar> bibliotekari,
			ArrayList<ClanBiblioteke> clanoviBiblioteke, ArrayList<Zanr> zanrovi, ArrayList<Iznajmljivanje> iznajmljivanje, ArrayList<TipClanarine> tipClanarine) {
		super();
		this.knjige = knjige;
		this.primerci = primerci;
		this.administratori = administratori;
		this.bibliotekari = bibliotekari;
		this.clanoviBiblioteke = clanoviBiblioteke;
		this.zanrovi = zanrovi;
		this.iznajmljivanje = iznajmljivanje;
		this.tipClanarine = tipClanarine;
	}

	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}

	public ArrayList<PrimerakKnjige> getPrimerci() {
		return primerci;
	}

	public ArrayList<Administrator> getAdministratori() {
		return administratori;
	}

	public ArrayList<Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}

	public ArrayList<ClanBiblioteke> getClanoviBiblioteke() {
		return clanoviBiblioteke;
	}
	
	public ArrayList<Zanr> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(ArrayList<Zanr> zanrovi) {
		this.zanrovi = zanrovi;
	}
	
//	public Zanr pronadjiZanr(String id) {
//		for(Zanr zanr:zanrovi) {
//			if(Integer.valueOf(zanr.getId()).equals(id)) {
//				return zanr;
//			}
//		}
//		return null;
//	}

	public void ucitajKnjige() {
		try {
			File knjigeFile = new File ("src/fajlovi/Knjige.txt");
			BufferedReader reader = new BufferedReader (new FileReader(knjigeFile));
			ucitajZanrove();
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String naslov = lineSplit[1];
				String originalniNaslov = lineSplit[2];
				String pisac = lineSplit[3];
				int godinaObjavljivanja = Integer.parseInt(lineSplit[4]);
				String opis = lineSplit[5];
				String zanrId = lineSplit[6];
				Zanr zanr = null;
				ArrayList<PrimerakKnjige> primerak = new ArrayList<PrimerakKnjige>();
				int jezikInt = Integer.parseInt(lineSplit[8]);
				Jezik jezik = Jezik.values()[jezikInt];
				for(Zanr zanrs : this.zanrovi) {
					if(Integer.valueOf(zanrs.getId()).equals(zanrId)) {
						zanr = zanrs;
					}
				}
			
				
				Knjiga knjiga = new Knjiga(id, naslov, originalniNaslov, pisac, godinaObjavljivanja, opis, zanr, primerak, jezik);
				
				knjige.add(knjiga);
				}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void ucitajZanrove() {
		try {
			File zanroviFile = new File ("src/fajlovi/Zanrovi.txt");
			BufferedReader reader = new BufferedReader (new FileReader(zanroviFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String oznaka = lineSplit[1];
				String opis = lineSplit[2];
				
				Zanr zanr = new Zanr(id, oznaka, opis);
				
				zanrovi.add(zanr);
				}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void ucitajAdministratore() {
		try {
			File administratoriFile = new File ("src/fajlovi/Administratori.txt");
			BufferedReader reader = new BufferedReader (new FileReader(administratoriFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String jmbg = lineSplit[3];
				String adresa = lineSplit[4];
				int polInt = Integer.parseInt(lineSplit[5]);
				Pol pol = Pol.values()[polInt];
				double plata = Double.parseDouble(lineSplit[6]);
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				
				Administrator admin = new Administrator(id, ime, prezime, jmbg, adresa, pol, plata, korisnickoIme, lozinka);
				
				administratori.add(admin);
				}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void ucitajBibliotekare() {
		try {
			File bibliotekariFile = new File ("src/fajlovi/Bibliotekari.txt");
			BufferedReader reader = new BufferedReader (new FileReader(bibliotekariFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String jmbg = lineSplit[3];
				String adresa = lineSplit[4];
				int polInt = Integer.parseInt(lineSplit[5]);
				Pol pol = Pol.values()[polInt];
				double plata = Double.parseDouble(lineSplit[6]);
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				
				Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jmbg, adresa, pol, plata, korisnickoIme, lozinka);
				
				bibliotekari.add(bibliotekar);
				}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void ucitajPrimerkeKnjige() {
		try {
			File primerciKnjigeFile = new File ("src/fajlovi/PrimerciKnjige.txt");
			BufferedReader reader = new BufferedReader (new FileReader(primerciKnjigeFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				int brojStrana = Integer.parseInt(lineSplit[1]);
				int godinaStampanja = Integer.parseInt(lineSplit[2]);
				boolean jeIznajmljena = Boolean.parseBoolean(lineSplit[3]);
				Knjiga knjiga = null;
				int tipPovezaInt = Integer.parseInt(lineSplit[5]);
				TipPoveza tip = TipPoveza.values()[tipPovezaInt];
				int jezikStampanjaInt = Integer.parseInt(lineSplit[6]);
				Jezik jezikStampanja = Jezik.values()[jezikStampanjaInt];
				for(Knjiga k : this.knjige) {
					if(Integer.valueOf(k.getId()).equals(id)) {
						knjiga = k;
					}
				}
			
				
				PrimerakKnjige primerak = new PrimerakKnjige(id, brojStrana, godinaStampanja, jeIznajmljena, knjiga, tip, jezikStampanja);
				
				primerci.add(primerak);
				}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}

}
