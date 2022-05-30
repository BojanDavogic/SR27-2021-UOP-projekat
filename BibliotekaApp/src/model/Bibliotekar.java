package model;

public class Bibliotekar extends Zaposleni {
	
    public Bibliotekar() {
    }

	public Bibliotekar(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, double plata,
			String korisnickoIme, String lozinka, boolean obrisan) {
		super(id, ime, prezime, jMBG, adresa, pol, plata, korisnickoIme, lozinka, obrisan);
	}

	@Override
	public String toString() {
		return "Bibliotekar [id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol="
				+ pol + ", plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", obrisan=" + obrisan + "]";
	}
	
}