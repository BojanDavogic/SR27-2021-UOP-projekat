package model;

public abstract class Zaposleni extends Osoba {
    
    protected double plata;
    protected String korisnickoIme;
    protected String lozinka;
    
    public Zaposleni() {
    }
    
	public Zaposleni(int id, String ime, String prezime, String jMBG, String adresa, Pol pol, double plata,
			String korisnickoIme, String lozinka, boolean obrisan) {
		super(id, ime, prezime, jMBG, adresa, pol, obrisan);
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
//		return "Zaposleni [id=" + id
//				+ ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol=" + pol
//				+ ", plata=" + plata + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", obrisan=" + obrisan + "]";
		return ime + prezime + " - ID=" + id;
	}

}