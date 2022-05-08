package model;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class ClanBiblioteke extends Osoba {

    /**
     * Default constructor
     */
    public ClanBiblioteke() {
    }

    /**
     * 
     */
    protected String brojClanskeKarte;

    /**
     * 
     */
    protected LocalDate datumPoslednjeUplate;

    /**
     * 
     */
    protected int unapredUplacenoMeseci;

    /**
     * 
     */
    protected boolean jeAktivan;

    /**
     * 
     */
    protected TipClanarine tipClanarine;

}