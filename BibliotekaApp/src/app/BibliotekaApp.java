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
import model.Biblioteka;
import model.Bibliotekar;
import model.ClanBiblioteke;
import model.Iznajmljivanje;
import model.Jezik;
import model.Knjiga;
import model.Osoba;
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
	private HashMap<Integer, Biblioteka> biblioteka;
	private HashMap<Integer, Osoba> osobe;
	
	public BibliotekaApp() {
		this.zanrovi = new HashMap<Integer, Zanr>();
		this.knjige = new HashMap<Integer, Knjiga>();
		this.primerci = new HashMap<Integer, PrimerakKnjige>();
		this.administratori = new HashMap<Integer, Administrator>();
		this.bibliotekari = new HashMap<Integer, Bibliotekar>();
		this.clanoviBiblioteke = new HashMap<Integer, ClanBiblioteke>();
		this.iznajmljivanja = new HashMap<Integer, Iznajmljivanje>();
		this.tipoviClanarine = new HashMap<Integer, TipClanarine>();
		this.biblioteka = new HashMap<Integer, Biblioteka>();
		this.osobe = new HashMap<Integer, Osoba>();
	}
	
	public Zaposleni login(String korisnickoIme, String lozinka) {
		for(Administrator administrator: this.administratori.values()) {
			if(administrator.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && administrator.getLozinka().equals(lozinka) && !administrator.isObrisan()) {
				return administrator;
			}
		}
		for(Bibliotekar bibliotekar: this.bibliotekari.values()) {
			if(bibliotekar.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && bibliotekar.getLozinka().equals(lozinka) && !bibliotekar.isObrisan()) {
				return bibliotekar;
			}
		}
		return null;
	}
	
	public HashMap<Integer, Knjiga> sveNeobrisaneKnjige() {
		HashMap<Integer, Knjiga> neobrisaneKnjige = new HashMap<Integer, Knjiga>();
		for(Knjiga knjiga : knjige.values()) {
			if(!knjiga.isObrisana()) {
				neobrisaneKnjige.put(knjiga.getId(), knjiga);
			}
		}
		return neobrisaneKnjige;
	}
	
	public HashMap<Integer, Biblioteka> sveBiblioteka() {
		HashMap<Integer, Biblioteka> biblioteka2 = new HashMap<Integer, Biblioteka>();
		for(Biblioteka bibl : biblioteka.values()) {
			biblioteka2.put(bibl.getId(), bibl);
		}
		return biblioteka2;
	}
	
	public HashMap<Integer, Osoba> osobe() {
		HashMap<Integer, Osoba> sveOsobe = new HashMap<Integer, Osoba>();
		for(Osoba osoba : osobe.values()) {
			sveOsobe.put(osoba.getId(), osoba);
		}
		return sveOsobe;
	}
	
	public HashMap<Integer, Zanr> sviNeobrisaniZanrovi() {
		HashMap<Integer, Zanr> neobrisaniZanrovi = new HashMap<Integer, Zanr>();
		for(Zanr zanr : zanrovi.values()) {
			if(!zanr.isObrisan()) {
				neobrisaniZanrovi.put(zanr.getId(), zanr);
			}
		}
		return neobrisaniZanrovi;
	}
	
	public HashMap<Integer, Zaposleni> sviNeobrisaniZaposleni() {
		HashMap<Integer, Zaposleni> neobrisaniZaposleni = new HashMap<Integer, Zaposleni>();
		for(Administrator administrator : administratori.values()) {
			if(!administrator.isObrisan()) {
				neobrisaniZaposleni.put(administrator.getId(), administrator);
			}
		}
		for(Bibliotekar bibliotekar : bibliotekari.values()) {
			if(!bibliotekar.isObrisan()) {
				neobrisaniZaposleni.put(bibliotekar.getId(), bibliotekar);
			}
		}
		return neobrisaniZaposleni;
	}
	
	public HashMap<Integer, Administrator> sviNeobrisaniAdministratori() {
		HashMap<Integer, Administrator> neobrisaniAdministratori = new HashMap<Integer, Administrator>();
		for(Administrator administrator : administratori.values()) {
			if(!administrator.isObrisan()) {
				neobrisaniAdministratori.put(administrator.getId(), administrator);
			}
		}
		return neobrisaniAdministratori;
	}
	
	public HashMap<Integer, Bibliotekar> sviNeobrisaniBibliotekari() {
		HashMap<Integer, Bibliotekar> neobrisaniBibliotekari = new HashMap<Integer, Bibliotekar>();
		for(Bibliotekar bibliotekar : bibliotekari.values()) {
			if(!bibliotekar.isObrisan()) {
				neobrisaniBibliotekari.put(bibliotekar.getId(), bibliotekar);
			}
		}
		return neobrisaniBibliotekari;
	}
	
	public HashMap<Integer, PrimerakKnjige> sviNeobrisaniPrimerciKnjige() {
		HashMap<Integer, PrimerakKnjige> neobrisaniPrimerciKnjige = new HashMap<Integer, PrimerakKnjige>();
		for(PrimerakKnjige primerak : primerci.values()) {
			if(!primerak.isObrisana()) {
				neobrisaniPrimerciKnjige.put(primerak.getId(), primerak);
			}
		}
		return neobrisaniPrimerciKnjige;
	}
	
	public HashMap<Integer, PrimerakKnjige> sviNeiznajmljeniPrimerciKnjige() {
		HashMap<Integer, PrimerakKnjige> neiznajmljeniPrimerciKnjige = new HashMap<Integer, PrimerakKnjige>();
		for(PrimerakKnjige primerak : primerci.values()) {
			if(!primerak.isObrisana() && !primerak.isJeIznajmljena()) {
				neiznajmljeniPrimerciKnjige.put(primerak.getId(), primerak);
			}
		}
		return neiznajmljeniPrimerciKnjige;
	}
	
	public HashMap<Integer, PrimerakKnjige> sviIznajmljeniPrimerciKnjige() {
		HashMap<Integer, PrimerakKnjige> iznajmljeniPrimerciKnjige = new HashMap<Integer, PrimerakKnjige>();
		for(PrimerakKnjige primerak : primerci.values()) {
			if(!primerak.isObrisana() && primerak.isJeIznajmljena()) {
				iznajmljeniPrimerciKnjige.put(primerak.getId(), primerak);
			}
		}
		return iznajmljeniPrimerciKnjige;
	}
	
	public HashMap<Integer, ClanBiblioteke> sviNeobrisaniClanoviBiblioteke() {
		HashMap<Integer, ClanBiblioteke> neobrisaniClanoviBiblioteke = new HashMap<Integer, ClanBiblioteke>();
		for(ClanBiblioteke clan : clanoviBiblioteke.values()) {
			if(!clan.isObrisan()) {
				neobrisaniClanoviBiblioteke.put(clan.getId(), clan);
			}
		}
		return neobrisaniClanoviBiblioteke;
	}
	
	public HashMap<Integer, ClanBiblioteke> sviAktivniClanoviBiblioteke() {
		HashMap<Integer, ClanBiblioteke> aktivniClanoviBiblioteke = new HashMap<Integer, ClanBiblioteke>();
		for(ClanBiblioteke clan : sviNeobrisaniClanoviBiblioteke().values()) {
			if(clan.isJeAktivan()) {
				aktivniClanoviBiblioteke.put(clan.getId(), clan);
			}
		}
		return aktivniClanoviBiblioteke;
	}
	
	public HashMap<Integer, Iznajmljivanje> svaNeobrisanaIznajmljivanja() {
		HashMap<Integer, Iznajmljivanje> neobrisanaIznajmljivanja = new HashMap<Integer, Iznajmljivanje>();
		for(Iznajmljivanje iznajmljivanje : iznajmljivanja.values()) {
			if(!iznajmljivanje.isObrisano()) {
				neobrisanaIznajmljivanja.put(iznajmljivanje.getId(), iznajmljivanje);
			}
		}
		return neobrisanaIznajmljivanja;
	}
	
	public HashMap<Integer, TipClanarine> sviNeobrisaniTipoviClanarine() {
		HashMap<Integer, TipClanarine> neobrisaniTipoviClanarine = new HashMap<Integer, TipClanarine>();
		for(TipClanarine tipClanarine : tipoviClanarine.values()) {
			if(!tipClanarine.isObrisan()) {
				neobrisaniTipoviClanarine.put(tipClanarine.getId(), tipClanarine);
			}
		}
		return neobrisaniTipoviClanarine;
	}
	
	public Knjiga pronadjiKnjigu(int id) {
		for (Knjiga knjiga : sveNeobrisaneKnjige().values()) {
			if(knjiga.getId() == id) {
				return knjiga;
			}
		}
		return null;
	}
	
	public Zanr pronadjiZanr(int id) {
		for (Zanr zanr : sviNeobrisaniZanrovi().values()) {
			if(zanr.getId() == id) {
				return zanr;
			}
		}
		return null;
	}
	
	public TipClanarine pronadjiTipClanarine(int id) {
		for (TipClanarine tipClanarine : sviNeobrisaniTipoviClanarine().values()) {
			if(tipClanarine.getId() == id) {
				return tipClanarine;
			}
		}
		return null;
	}
	
	public Administrator pronadjiAdministratora(int id) {
		for (Administrator administrator : sviNeobrisaniAdministratori().values()) {
			if(administrator.getId() == id) {
				return administrator;
			}
		}
		return null;
	}
	
	public Bibliotekar pronadjiBibliotekara(int id) {
		for (Bibliotekar bibliotekar : sviNeobrisaniBibliotekari().values()) {
			if(bibliotekar.getId() == id) {
				return bibliotekar;
			}
		}
		return null;
	}
	
	public PrimerakKnjige pronadjiPrimerak(int id) {
		for (PrimerakKnjige primerakKnjige : sviNeobrisaniPrimerciKnjige().values()) {
			if(primerakKnjige.getId() == id) {
				return primerakKnjige;
			}
		}
		return null;
	}
	
	public ClanBiblioteke pronadjiClanaBiblioteke(int id) {
		for (ClanBiblioteke clanBiblioteke : sviNeobrisaniClanoviBiblioteke().values()) {
			if(clanBiblioteke.getId() == id) {
				return clanBiblioteke;
			}
		}
		return null;
	}
	
	public Iznajmljivanje pronadjiIznajmljivanje(int id) {
		for (Iznajmljivanje iznajmljivanje : svaNeobrisanaIznajmljivanja().values()) {
			if(iznajmljivanje.getId() == id) {
				return iznajmljivanje;
			}
		}
		return null;
	}
	
	public Biblioteka pronadjiBiblioteku(int id) {
		for (Biblioteka biblioteka : biblioteka.values()) {
			if(biblioteka.getId() == id) {
				return biblioteka;
			}
		}
		return null;
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
				boolean obrisana = Boolean.parseBoolean(lineSplit[8]);				
				
				Knjiga knjiga = new Knjiga(id, naslov, originalniNaslov, pisac, godinaObjavljivanja, opis, zanr, jezikOriginala, obrisana);
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
					+ knjiga.getGodinaObjavljivanja() + "|" + knjiga.getOpis() + "|" + knjiga.getZanr().getId() + "|" + knjiga.getJezikOriginala() + "|" + knjiga.isObrisana() + "\n";		
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
				boolean obrisan = Boolean.parseBoolean(lineSplit[3]);
				
				Zanr zanr = new Zanr(id, oznaka, opis, obrisan);				
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
			sadrzaj += zanr.getId() + "|" + zanr.getOznaka() + "|" + zanr.getOpis() + "|" + zanr.isObrisan() + "\n";
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
				Pol pol = Pol.valueOf(lineSplit[5]);
				double plata = Double.parseDouble(lineSplit[6]);
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				boolean obrisan = Boolean.parseBoolean(lineSplit[9]);
				
				Administrator administrator = new Administrator(id, ime, prezime, jmbg, adresa, pol, plata, korisnickoIme, lozinka, obrisan);				
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
					administrator.getAdresa() + "|" + administrator.getPol() + "|" + administrator.getPlata() + "|" + administrator.getKorisnickoIme() + "|" + administrator.getLozinka() + "|" + administrator.isObrisan() + "\n";
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
				Pol pol = Pol.valueOf(lineSplit[5]);
				double plata = Double.parseDouble(lineSplit[6]);
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				boolean obrisan = Boolean.parseBoolean(lineSplit[9]);
				
				Bibliotekar bibliotekar = new Bibliotekar(id, ime, prezime, jmbg, adresa, pol, plata, korisnickoIme, lozinka, obrisan);				
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
					bibliotekar.getAdresa() + "|" + bibliotekar.getPol() + "|" + bibliotekar.getPlata() + "|" + bibliotekar.getKorisnickoIme() + "|" + bibliotekar.getLozinka() + "|" + bibliotekar.isObrisan() + "\n";
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
				boolean obrisana = Boolean.parseBoolean(lineSplit[7]);
				
				PrimerakKnjige primerak = new PrimerakKnjige(id, brojStrana, godinaStampanja, jeIznajmljena, knjiga, tipPoveza, jezikStampanja, obrisana);				
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
			+ "|" + primerakKnjige.getTipPoveza() + "|" + primerakKnjige.getJezikStampanja() + "|" + primerakKnjige.getKnjiga().getId() + "|" + primerakKnjige.isObrisana() + "\n";
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
				if(datumPoslednjeUplate.plusMonths(unapredUplacenoMeseci).isBefore(LocalDate.now())) {
					jeAktivan = false;
				}
				int tipClanarineId = Integer.valueOf(lineSplit[10]);
				TipClanarine tipClanarine = this.tipoviClanarine.get(tipClanarineId);
				boolean obrisan = Boolean.parseBoolean(lineSplit[11]);
				
				ClanBiblioteke clan = new ClanBiblioteke(id, ime, prezime, jmbg, adresa, pol, brojClanskeKarte, datumPoslednjeUplate,unapredUplacenoMeseci, jeAktivan, tipClanarine, obrisan);
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
			 	+ "|" + clan.getTipClanarine().getId() + "|" + clan.isObrisan() + "\n";
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
				boolean obrisano = Boolean.parseBoolean(lineSplit[6]);
				
				Iznajmljivanje iznajmljivanje = new Iznajmljivanje(id, datumIznajmljivanja, datumVracanja, zaposleni, clan, obrisano);				
				iznajmljivanja.put(iznajmljivanje.getId(), iznajmljivanje);
				
				for(String idP : idPrimeraka) {
					int intId = Integer.parseInt(idP);
					PrimerakKnjige pk = this.primerci.get(intId);
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
			+ "|" + iznajmljivanja.getZaposleni().getId() + "|" + iznajmljivanja.getClan().getId() + "|" + idPrimeraka + "|" + iznajmljivanja.isObrisano() + "\n";
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
				boolean obrisan = Boolean.parseBoolean(lineSplit[3]);
				
				
				TipClanarine tipClanarine = new TipClanarine(id, naziv, cena, obrisan);
				
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
			sadrzaj += tipoviClanarine.getId() + "|" + tipoviClanarine.getNaziv() + "|" + tipoviClanarine.getCena() + "|" + tipoviClanarine.isObrisan() + "\n";
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
	
	public void ucitajBiblioteku() {
		try {
			File bibliotekaFile = new File ("src/fajlovi/Biblioteka.txt");
			BufferedReader reader = new BufferedReader (new FileReader(bibliotekaFile));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String naziv = lineSplit[1];
				String adresa = lineSplit[2];
				String telefon = lineSplit[3];
				String radnoVreme = lineSplit[4];
				
				Biblioteka biblioteka = new Biblioteka(id, naziv, adresa, telefon, radnoVreme);
				this.biblioteka.put(biblioteka.getId(), biblioteka);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
		}
	}
	
	public void snimiBiblioteku(String imeFajla) {
		String sadrzaj = "";
		for (Biblioteka biblioteka : this.biblioteka.values()) {
			
			sadrzaj += biblioteka.getId() + "|" +biblioteka.getNaziv() + "|" + biblioteka.getAdresa()
			+ "|" + biblioteka.getTelefon() + "|" + biblioteka.getRadnoVreme() + "\n";
		}
		try {
			File file = new File(FOLDER + imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(sadrzaj);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja biblioteke.");
		}
	}
	
	public HashMap<Integer, Zanr> getZanrovi() {
		return zanrovi;
	}

	public void dodajZanr(Zanr zanr) {
		this.zanrovi.put(zanr.getId(), zanr);
	}
	
	public void obrisiZanr(Zanr zanr) {
		this.zanrovi.remove(zanr.getId(), zanr);
	}
	
	public HashMap<Integer, Knjiga> getKnjige() {
		return knjige;
	}
	
	public void dodajKnjigu(Knjiga knjiga) {
		this.knjige.put(knjiga.getId(), knjiga);
	}
	
	public void obrisiKnjigu(Knjiga knjiga) {
		this.knjige.remove(knjiga.getId(), knjiga);
		}

	public HashMap<Integer, PrimerakKnjige> getPrimerci() {
		return primerci;
	}
	
	public void dodajPrimerak(PrimerakKnjige primerak) {
		this.primerci.put(primerak.getId(), primerak);
	}
	
	public void obrisiPrimerak(PrimerakKnjige primerak) {
		this.primerci.remove(primerak.getId(), primerak);
	}

	public HashMap<Integer, Administrator> getAdministratori() {
		return administratori;
	}
	
	public void dodajAdministratora(Administrator administrator) {
		this.administratori.put(administrator.getId(), administrator);
	}
	
	public void obrisiAdministratora(Administrator administrator) {
		this.administratori.remove(administrator.getId(), administrator);
	}

	public HashMap<Integer, Bibliotekar> getBibliotekari() {
		return bibliotekari;
	}
	
	public void dodajBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.put(bibliotekar.getId(), bibliotekar);
	}
	
	public void obrisiBibliotekara(Bibliotekar bibliotekar) {
		this.bibliotekari.remove(bibliotekar.getId(), bibliotekar);
	}

	public HashMap<Integer, ClanBiblioteke> getClanoviBiblioteke() {
		return clanoviBiblioteke;
	}
	
	public void dodajClanaBiblioteke(ClanBiblioteke clanBiblioteke) {
		this.clanoviBiblioteke.put(clanBiblioteke.getId(), clanBiblioteke);
	}
	
	public void obrisiClanaBiblioteke(ClanBiblioteke clanBiblioteke) {
		this.clanoviBiblioteke.remove(clanBiblioteke.getId(), clanBiblioteke);
	}
	
	public HashMap<Integer, Iznajmljivanje> getIznajmljivanje() {
		return iznajmljivanja;
	}
	
	public void dodajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanja.put(iznajmljivanje.getId(), iznajmljivanje);
	}
	
	public void obrisiIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanja.remove(iznajmljivanje.getId(), iznajmljivanje);
	}

	public HashMap<Integer, TipClanarine> getTipClanarine() {
		return tipoviClanarine;
	}
	
	public void dodajTipClanarine(TipClanarine tipClanarine) {
		this.tipoviClanarine.put(tipClanarine.getId(), tipClanarine);
	}
	
	public void obrisiTipClanarine(TipClanarine tipClanarine) {
		this.tipoviClanarine.remove(tipClanarine.getId(), tipClanarine);
	}
	
	public HashMap<Integer, Biblioteka> getBiblioteka() {
		return biblioteka;
	}

}
