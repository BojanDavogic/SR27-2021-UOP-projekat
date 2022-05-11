package model;

import java.util.*;

public class Administrator extends Zaposleni {
	
    public Administrator() {
    }

	public Administrator(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, double plata,
			String korisnickoIme, String lozinka) {
		super(id, ime, prezime, jMBG, adresa, pol, plata, korisnickoIme, lozinka);
	}

	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol="
				+ pol + "]";
	}   

}