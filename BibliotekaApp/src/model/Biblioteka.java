package model;

import java.util.*;
public class Biblioteka {
    public Biblioteka() {
    }
    protected int id;
    protected String naziv;
    protected String adresa;
    protected String telefon;
    protected String radnoVreme;
    protected List<Knjiga> knjige;
    protected List<Osoba> osobe;
    
	public Biblioteka(int id, String naziv, String adresa, String telefon, String radnoVreme, List<Knjiga> knjige,
			List<Osoba> osobe) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.knjige = knjige;
		this.osobe = osobe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	public List<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}

	public List<Osoba> getOsobe() {
		return osobe;
	}

	public void setOsobe(List<Osoba> osobe) {
		this.osobe = osobe;
	}

	@Override
	public String toString() {
		return "Biblioteka [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", telefon=" + telefon
				+ ", radnoVreme=" + radnoVreme + ", knjige=" + knjige + ", osobe=" + osobe + "]";
	}
    
	
    

}