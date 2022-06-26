package model;


public class Biblioteka {
    
    protected int id;
    protected String naziv;
    protected String adresa;
    protected String telefon;
    protected String radnoVreme;
    
    public Biblioteka() {
    }
    
	public Biblioteka(int id, String naziv, String adresa, String telefon, String radnoVreme) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
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

	@Override
	public String toString() {
		return "Biblioteka [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", telefon=" + telefon
				+ ", radnoVreme=" + radnoVreme + "]";
	}
	
}