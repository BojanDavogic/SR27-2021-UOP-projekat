package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Iznajmljivanje {
       
    protected int id;
    protected LocalDate datumIznajmljivanja;
    protected LocalDate datumVracanja;
    protected Zaposleni zaposleni;
    protected ClanBiblioteke clan;
    protected List<PrimerakKnjige> primerci;
    protected boolean obrisano;
    
    public Iznajmljivanje() {
    }
    
	public Iznajmljivanje(int id, LocalDate datumIznajmljivanja, LocalDate datumVracanja, Zaposleni zaposleni,
			ClanBiblioteke clan, boolean obrisano) {
		super();
		this.id = id;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerci = new ArrayList<>();
		this.obrisano = obrisano;
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

	public List<PrimerakKnjige> getPrimerci() {
		return primerci;
	}

	public void setPrimerci(List<PrimerakKnjige> primerci) {
		this.primerci = primerci;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

	@Override
	public String toString() {
		return "Iznajmljivanje [id=" + id + ", datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja="
				+ datumVracanja + ", zaposleni=" + zaposleni + ", clan=" + clan.getIme() + " " + clan.getPrezime() + ", obrisano=" + obrisano + "]";
	}

}