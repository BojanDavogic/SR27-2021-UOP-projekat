package model;

import java.util.*;

/**
 * 
 */
public class Knjiga {
    
    protected int id;
    protected String naslov;
    protected String originalniNaslov;
    protected String pisac;
    protected int godinaObjavljivanja;
    protected String opis;
    protected Zanr zanr;
    protected ArrayList<PrimerakKnjige> sviPrimerci;
    protected Jezik jezikOriginala;
    
    public Knjiga() {
    }
    
	public Knjiga(int id, String naslov, String originalniNaslov, String pisac, int godinaObjavljivanja, String opis,
			Zanr zanr, ArrayList<PrimerakKnjige> sviPrimerci, Jezik jezikOriginala) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.pisac = pisac;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opis = opis;
		this.zanr = zanr;
		this.sviPrimerci = sviPrimerci;
		this.jezikOriginala = jezikOriginala;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOriginalniNaslov() {
		return originalniNaslov;
	}

	public void setOriginalniNaslov(String originalniNaslov) {
		this.originalniNaslov = originalniNaslov;
	}

	public String getPisac() {
		return pisac;
	}

	public void setPisac(String pisac) {
		this.pisac = pisac;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	public ArrayList<PrimerakKnjige> getSviPrimerci() {
		return sviPrimerci;
	}

	public void setSviPrimerci(ArrayList<PrimerakKnjige> sviPrimerci) {
		this.sviPrimerci = sviPrimerci;
	}

	public Jezik getJezikOriginala() {
		return jezikOriginala;
	}

	public void setJezikOriginala(Jezik jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}

	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naslov=" + naslov + ", originalniNaslov=" + originalniNaslov + ", pisac=" + pisac
				+ ", godinaObjavljivanja=" + godinaObjavljivanja + ", opis=" + opis + ", zanr=" + zanr
				+ ", sviPrimerci=" + sviPrimerci + ", jezikOriginala=" + jezikOriginala + "]";
	}
	
	
    
    

}