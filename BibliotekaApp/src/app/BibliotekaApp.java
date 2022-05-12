package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

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
import model.Zaposleni;

public class BibliotekaApp {
	
	private static String FOLDER = "src/fajlovi/";
	
	private HashMap<Integer, Zanr> zanrovi;
	private HashMap<Integer, Knjiga> knjige;
	private HashMap<Integer, PrimerakKnjige> primerci;
	private HashMap<Integer, Administrator> administratori;
	private HashMap<Integer, Bibliotekar> bibliotekari;
	private HashMap<Integer, ClanBiblioteke> clanoviBiblioteke;
	private HashMap<Integer, Iznajmljivanje> iznajmljivanja;
	private HashMap<Integer, TipClanarine> tipoviClanarine;
	
	public BibliotekaApp() {
		this.zanrovi = new HashMap<Integer, Zanr>();
		this.knjige = new HashMap<Integer, Knjiga>();
		this.primerci = new HashMap<Integer, PrimerakKnjige>();
		this.administratori = new HashMap<Integer, Administrator>();
		this.bibliotekari = new HashMap<Integer, Bibliotekar>();
		this.clanoviBiblioteke = new HashMap<Integer, ClanBiblioteke>();
		this.iznajmljivanja = new HashMap<Integer, Iznajmljivanje>();
		this.tipoviClanarine = new HashMap<Integer, TipClanarine>();
	}

	public void ucitajKnjige() {
		try {
			File knjigeFile = new File ("src/fajlovi/Knjige.txt");
			BufferedReader reader = new BufferedReader (new FileReader(knjigeFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String naslov = lineSplit[1];
				String originalniNaslov = lineSplit[2];
				String pisac = lineSplit[3];
				int godinaObjavljivanja = Integer.parseInt(lineSplit[4]);
				String opis = lineSplit[5];
				int zanrId = Integer.parseInt(lineSplit[6]);
				Zanr zanr = this.zanrovi.get(zanrId);			
				Jezik jezikOriginala = Jezik.valueOf(lineSplit[7]);				
				
				Knjiga knjiga = new Knjiga(id, naslov, originalniNaslov, pisac, godinaObjavljivanja, opis, zanr, jezikOriginala);
				this.knjige.put(knjiga.getId(), knjiga);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiKnjige(String imeFajla) {
		String sadrzaj = "";
		for (Knjiga knjiga: this.knjige.values()) {
			sadrzaj += knjiga.getId() + "|" + knjiga.getNaslov() + "|" + knjiga.getOriginalniNaslov() + "|" + knjiga.getPisac() + "|"
					+ knjiga.getGodinaObjavljivanja() + "|" + knjiga.getOpis() + "|" + knjiga.getZanr().getId() + "|" + knjiga.getJezikOriginala() + "\n";		
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja knjiga.");
		}
	}
	
//	public void snimiKnjigu(String imeFajla, Knjiga knjiga) {		
//		String sadrzaj = knjiga.getId() + "|" + knjiga.getNaslov() + "|" + knjiga.getOriginalniNaslov() + "|" + knjiga.getPisac() + "|"
//			+ knjiga.getGodinaObjavljivanja() + "|" + knjiga.getOpis() + "|" + knjiga.getZanr().getId() + "|" + knjiga.getJezikOriginala() + "\n";		
//
//		try {
//			File file = new File("src/fajlovi/Knjige.txt");
//			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
//			writer.append(sadrzaj);
//			writer.close();
//		} catch (IOException e) {
//			System.out.println("Greska prilikom snimanja knjiga.");
//		}
//	}
	
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
				this.zanrovi.put(zanr.getId(), zanr);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiZanrove(String imeFajla) {
		String sadrzaj = "";
		for (Zanr zanr: this.zanrovi.values()) {
			sadrzaj += zanr.getId() + "|" + zanr.getOznaka() + "|" + zanr.getOpis() + "\n";
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja zanrova.");
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
//				int polInt = Integer.parseInt(lineSplit[5]);
//				Pol pol = Pol.values()[polInt];
				Pol pol = Pol.valueOf(lineSplit[5]);
				double plata = Double.parseDouble(lineSplit[6]);
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				
				Administrator administrator = new Administrator(id, ime, prezime, jmbg, adresa, pol, plata, korisnickoIme, lozinka);				
				this.administratori.put(administrator.getId(), administrator);
				}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiAdministratore(String imeFajla) {
		String sadrzaj = "";
		for (Administrator administrator: this.administratori.values()) {
			sadrzaj += administrator.getId() + "|" + administrator.getIme() + "|" + administrator.getPrezime() + "|" + administrator.getJMBG() + "|" + 
					administrator.getAdresa() + "|" + administrator.getPol() + "|" + administrator.getPlata() + "|" + administrator.getKorisnickoIme() + "|" + administrator.getLozinka() + "\n";
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja administratora.");
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
//				int polInt = Integer.parseInt(lineSplit[5]);
//				Pol pol = Pol.values()[polInt];
				Pol pol = Pol.valueOf(lineSplit[5]);
				double plata = Double.parseDouble(lineSplit[6]);
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				
				Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jmbg, adresa, pol, plata, korisnickoIme, lozinka);				
				bibliotekari.put(bibliotekar.getId(), bibliotekar);
				}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiBibliotekare(String imeFajla) {
		String sadrzaj = "";
		for (Bibliotekar bibliotekar: this.bibliotekari.values()) {
			sadrzaj += bibliotekar.getId() + "|" + bibliotekar.getIme() + "|" + bibliotekar.getPrezime() + "|" + bibliotekar.getJMBG() + "|" + 
					bibliotekar.getAdresa() + "|" + bibliotekar.getPol() + "|" + bibliotekar.getPlata() + "|" + bibliotekar.getKorisnickoIme() + "|" + bibliotekar.getLozinka() + "\n";
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja bibliotekara.");
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
				TipPoveza tipPoveza = TipPoveza.valueOf(lineSplit[4]);
				Jezik jezikStampanja = Jezik.valueOf(lineSplit[5]);
				int knjigaId = Integer.parseInt(lineSplit[6]);
				Knjiga knjiga = this.knjige.get(knjigaId);
				
				PrimerakKnjige primerak = new PrimerakKnjige(id, brojStrana, godinaStampanja, jeIznajmljena, knjiga, tipPoveza, jezikStampanja);				
				this.primerci.put(primerak.getId(),primerak);
				knjiga.getSviPrimerci().add(primerak);	// dodajemo primerak u knjigu
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiPrimerkeKnjige(String imeFajla) {
		String sadrzaj = "";
		for (PrimerakKnjige primerakKnjige: this.primerci.values()) {
			sadrzaj += primerakKnjige.getId() + "|" + primerakKnjige.getBrojStrana() + "|" + primerakKnjige.getGodinaStampanja() + "|" + primerakKnjige.isJeIznajmljena()
			+ "|" + primerakKnjige.getTipPoveza() + "|" + primerakKnjige.getJezikStampanja() + "|" + primerakKnjige.getKnjiga().getId() + "\n";
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja primerka knjige.");
		}
	}
	
	public void ucitajClanoveBiblioteke() {
		try {
			File clanoviBibliotekeFile = new File ("src/fajlovi/ClanoviBiblioteke.txt");
			BufferedReader reader = new BufferedReader (new FileReader(clanoviBibliotekeFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String jmbg = lineSplit[3];
				String adresa = lineSplit[4];
				Pol pol = Pol.valueOf(lineSplit[5]);
				String brojClanskeKarte = lineSplit[6];
				LocalDate datumPoslednjeUplate = LocalDate.parse(lineSplit[7]);
				int unapredUplacenoMeseci = Integer.parseInt(lineSplit[8]);
				boolean jeAktivan = Boolean.parseBoolean(lineSplit[9]);
				int tipClanarineId = Integer.valueOf(lineSplit[10]);
				TipClanarine tipClanarine = this.tipoviClanarine.get(tipClanarineId);
				
				ClanBiblioteke clan = new ClanBiblioteke(id, ime, prezime, jmbg, adresa, pol, brojClanskeKarte, datumPoslednjeUplate,unapredUplacenoMeseci, jeAktivan, tipClanarine);
				this.clanoviBiblioteke.put(clan.getId(), clan);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiClanoveBiblioteke(String imeFajla) {
		String sadrzaj = "";
		for (ClanBiblioteke clan: this.clanoviBiblioteke.values()) {
			sadrzaj += clan.getId() + "|" + clan.getIme() + "|" + clan.getPrezime() + "|" + clan.getJMBG() + "|" + clan.getAdresa() + "|" + clan.getPol()
			 	+ "|" + clan.getBrojClanskeKarte() + "|" + clan.getDatumPoslednjeUplate() + "|" + clan.getUnapredUplacenoMeseci() + "|" + clan.isJeAktivan()
			 	+ "|" + clan.getTipClanarine().getId() + "\n";
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja clana biblioteke.");
		}
	}
	
	public void ucitajIznajmljivanje() {
		try {
			File iznajmljivanjeFile = new File ("src/fajlovi/Iznajmljivanje.txt");
			BufferedReader reader = new BufferedReader (new FileReader(iznajmljivanjeFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				LocalDate datumIznajmljivanja = LocalDate.parse(lineSplit[1]);
				LocalDate datumVracanja = LocalDate.parse(lineSplit[2]);
				int zaposleniId = Integer.parseInt(lineSplit[3]);
				Zaposleni zaposleni = this.bibliotekari.get(zaposleniId);
				if (zaposleni == null) {
					zaposleni = this.administratori.get(zaposleniId);
				}
				int clanId = Integer.parseInt(lineSplit[4]);
				ClanBiblioteke clan = this.clanoviBiblioteke.get(clanId);
				String idPrimerakaStr = lineSplit[5];
				String[] idPrimeraka = idPrimerakaStr.substring(1, idPrimerakaStr.length() - 1).split(", ");
				System.out.println(idPrimeraka);
				
				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, datumIznajmljivanja, datumVracanja, zaposleni, clan);				
				iznajmljivanja.put(iznajmljivanje.getId(), iznajmljivanje);
				
				for(String idP : idPrimeraka) {
					int intId = Integer.parseInt(idP);
					PrimerakKnjige pk = this.getPrimerci().get(intId);
					iznajmljivanje.getPrimerci().add(pk);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiIznajmljivanja(String imeFajla) {
		String sadrzaj = "";
		for (Iznajmljivanje iznajmljivanja : this.iznajmljivanja.values()) {
			ArrayList<Integer> idPrimeraka = new ArrayList<>();
			for (PrimerakKnjige primerak : iznajmljivanja.getPrimerci()) {
				idPrimeraka.add(primerak.getId());
			}
			
			sadrzaj += iznajmljivanja.getId() + "|" +iznajmljivanja.getDatumIznajmljivanja() + "|" + iznajmljivanja.getDatumVracanja()
			+ "|" + iznajmljivanja.getZaposleni().getId() + "|" + iznajmljivanja.getClan().getId() + "|" + idPrimeraka + "\n";
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja iznajmljivanja knjige.");
		}
	}
	
	public void ucitajTipClanarine() {
		try {
			File tipClanarineFile = new File ("src/fajlovi/TipClanarine.txt");
			BufferedReader reader = new BufferedReader (new FileReader(tipClanarineFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String naziv = lineSplit[1];
				double cena = Double.parseDouble(lineSplit[2]);
				
				
				TipClanarine tipClanarine = new TipClanarine(id, naziv, cena);
				
				tipoviClanarine.put(tipClanarine.getId(), tipClanarine);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiTipClanarine(String imeFajla) {
		String sadrzaj = "";
		for (TipClanarine tipoviClanarine: this.tipoviClanarine.values()) {
			sadrzaj += tipoviClanarine.getId() + "|" + tipoviClanarine.getNaziv() + "|" + tipoviClanarine.getCena() + "\n";
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja tipa clanarine.");
		}
	}
	
	public HashMap<Integer, Zanr> getZanrovi() {
		return zanrovi;
	}

	public void dodajZanr(Zanr zanr) {
		this.zanrovi.put(zanr.getId(), zanr);
	}
	
	public HashMap<Integer, Knjiga> getKnjige() {
		return knjige;
	}
	
	public void dodajKnjigu(Knjiga knjiga) {
		this.knjige.put(knjiga.getId(), knjiga);
	}

	public HashMap<Integer, PrimerakKnjige> getPrimerci() {
		return primerci;
	}
	
	public void dodajPrimerak(PrimerakKnjige primerak) {
		this.primerci.put(primerak.getId(), primerak);
	}

	public HashMap<Integer, Administrator> getAdministratori() {
		return administratori;
	}
	
	public void dodajAdministratora(Administrator administrator) {
		this.administratori.put(administrator.getId(), administrator);
	}

	public HashMap<Integer, Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}
	
	public void dodajBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.put(bibliotekar.getId(), bibliotekar);
	}

	public HashMap<Integer, ClanBiblioteke> getClanoviBiblioteke() {
		return clanoviBiblioteke;
	}
	
	public void dodajClanaBiblioteke(ClanBiblioteke clanBiblioteke) {
		this.clanoviBiblioteke.put(clanBiblioteke.getId(), clanBiblioteke);
	}
	
	public HashMap<Integer, Iznajmljivanje> getIznajmljivanje() {
		return iznajmljivanja;
	}
	
	public void dodajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanja.put(iznajmljivanje.getId(), iznajmljivanje);
	}

	public HashMap<Integer, TipClanarine> getTipClanarine() {
		return tipoviClanarine;
	}
	
	public void dodajTipClanarine(TipClanarine tipClanarine) {
		this.tipoviClanarine.put(tipClanarine.getId(), tipClanarine);
	}

}
