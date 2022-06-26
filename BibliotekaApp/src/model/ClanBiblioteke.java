package model;

import java.time.LocalDate;

public class ClanBiblioteke extends Osoba {
    
    protected String brojClanskeKarte;
    protected LocalDate datumPoslednjeUplate;
    protected int unapredUplacenoMeseci;
    protected boolean jeAktivan;
    protected TipClanarine tipClanarine;
    
    public ClanBiblioteke() {
    }
    
	public ClanBiblioteke(int id, String ime, String prezime, String jMBG, String adresa, Pol pol,
			String brojClanskeKarte, LocalDate datumPoslednjeUplate, int unapredUplacenoMeseci, boolean jeAktivan,
			TipClanarine tipClanarine, boolean obrisan) {
		super(id, ime, prezime, jMBG, adresa, pol, obrisan);
		this.brojClanskeKarte = clanskaKarta(ime, jMBG);
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.unapredUplacenoMeseci = unapredUplacenoMeseci;
		this.jeAktivan = jeAktivan;
		this.tipClanarine = tipClanarine;
	}

	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}

	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}

	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public int getUnapredUplacenoMeseci() {
		return unapredUplacenoMeseci;
	}

	public void setUnapredUplacenoMeseci(int unapredUplacenoMeseci) {
		this.unapredUplacenoMeseci = unapredUplacenoMeseci;
	}

	public boolean isJeAktivan() {
		return jeAktivan;
	}

	public void setJeAktivan(boolean jeAktivan) {
		this.jeAktivan = jeAktivan;
	}

	public TipClanarine getTipClanarine() {
		return tipClanarine;
	}

	public void setTipClanarine(TipClanarine tipClanarine) {
		this.tipClanarine = tipClanarine;
	}

	@Override
	public String toString() {
		return ime + " " + prezime + " - ID=" + id;
	}
	
	public static String clanskaKarta(String ime, String JMBG) {
		String slovo = ime.substring(0, 1);
		String broj =JMBG.substring(9, 13);
		
		return slovo + broj;
	}
}