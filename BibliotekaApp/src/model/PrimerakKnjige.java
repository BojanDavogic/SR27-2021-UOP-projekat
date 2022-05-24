package model;

public class PrimerakKnjige {
    
    protected int id;
    protected int brojStrana;
    protected int godinaStampanja;
    protected boolean jeIznajmljena;
    protected Knjiga knjiga;
    protected TipPoveza tipPoveza;
    protected Jezik jezikStampanja;
    
    public PrimerakKnjige() {
    }
    
	public PrimerakKnjige(int id, int brojStrana, int godinaStampanja, boolean jeIznajmljena, Knjiga knjiga,
			TipPoveza tipPoveza, Jezik jezikStampanja) {
		super();
		this.id = id;
		this.brojStrana = brojStrana;
		this.godinaStampanja = godinaStampanja;
		this.jeIznajmljena = jeIznajmljena;
		this.knjiga = knjiga;
		this.tipPoveza = tipPoveza;
		this.jezikStampanja = jezikStampanja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public int getGodinaStampanja() {
		return godinaStampanja;
	}

	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}

	public boolean isJeIznajmljena() {
		return jeIznajmljena;
	}

	public void setJeIznajmljena(boolean jeIznajmljena) {
		this.jeIznajmljena = jeIznajmljena;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public TipPoveza getTipPoveza() {
		return tipPoveza;
	}

	public void setTipPoveza(TipPoveza tipPoveza) {
		this.tipPoveza = tipPoveza;
	}

	public Jezik getJezikStampanja() {
		return jezikStampanja;
	}

	public void setJezikStampanja(Jezik jezikStampanja) {
		this.jezikStampanja = jezikStampanja;
	}

	@Override
	public String toString() {
		return "PrimerakKnjige [id=" + id + ", brojStrana=" + brojStrana + ", godinaStampanja=" + godinaStampanja
				+ ", jeIznajmljena=" + jeIznajmljena + ", knjiga=" + knjiga + ", tipPoveza=" + tipPoveza
				+ ", jezikStampanja=" + jezikStampanja + "]";
	}
    
	
    

}