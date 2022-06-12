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
		this.brojClanskeKarte = brojClanskeKarte;
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
//		return "ClanBiblioteke [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa="
//				+ adresa + ", pol=" + pol + ", brojClanskeKarte=" + brojClanskeKarte + ", datumPoslednjeUplate=" + datumPoslednjeUplate
//				+ ", unapredUplacenoMeseci=" + unapredUplacenoMeseci + ", jeAktivan=" + jeAktivan + ", tipClanarine="
//				+ tipClanarine + ", obrisan=" + obrisan + "]";
		return ime + prezime + " - ID=" + id;
	}
	
}