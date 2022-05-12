package model;

public class Zanr {
    
    protected int id;
    protected String oznaka;
    protected String opis;	
	
    public Zanr() {
    }
    
	public Zanr(int id, String oznaka, String opis) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.opis = opis;
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

	@Override
	public String toString() {
		return "Zanr [id=" + id + ", oznaka=" + oznaka + ", opis=" + opis + "]";
	}

    
}