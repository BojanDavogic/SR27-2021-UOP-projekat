package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Iznajmljivanje {
       
    protected int id;
    protected LocalDate datumIznajmljivanja;
    protected LocalDate datumVracanja;
    protected Zaposleni zaposleni;
    protected ClanBiblioteke clan;
    protected ArrayList<PrimerakKnjige> primerci;
    
    public Iznajmljivanje() {
    }
    
	public Iznajmljivanje(int id, LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
			ClanBiblioteke clan) {
		super();
		this.id = id;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerci = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}

	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}

	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public ClanBiblioteke getClan() {
		return clan;
	}

	public void setClan(ClanBiblioteke clan) {
		this.clan = clan;
	}

	public ArrayList<PrimerakKnjige> getPrimerci() {
		return primerci;
	}

	public void setPrimerci(ArrayList<PrimerakKnjige> primerci) {
		this.primerci = primerci;
	}

	@Override
	public String toString() {
		return "Iznajmljivanje [id=" + id + ", datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja="
				+ datumVracanja + ", zaposleni=" + zaposleni + ", clan=" + clan + "]";
	}
    
    

}