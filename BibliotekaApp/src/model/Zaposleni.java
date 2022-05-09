package model;

import java.util.*;
public abstract class Zaposleni extends Osoba {
    public Zaposleni() {
    }

    protected double plata;
    protected String korisnickoIme;
    protected String lozinka;
    
	public Zaposleni(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, double plata,
			String korisnickoIme, String lozinka) {
		super(id, ime, prezime, jMBG, adresa, pol);
		this.plata = plata;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Zaposleni [plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id=" + id
				+ ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol=" + pol
				+ "]";
	}

	
    
}