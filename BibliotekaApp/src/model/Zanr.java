package model;

public class Zanr {
    
    protected int id;
    protected String oznaka;
    protected String opis;	
    protected boolean obrisan;
	
    public Zanr() {
    }
    
	public Zanr(int id, String oznaka, String opis, boolean obrisan) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.opis = opis;
		this.obrisan = obrisan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Zanr [id=" + id + ", oznaka=" + oznaka + ", opis=" + opis + ", obrisan=" + obrisan + "]";
	}
    
}