package model;

import java.util.*;

/**
 * 
 */
public class Knjiga {

    /**
     * Default constructor
     */
    public Knjiga() {
    }

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    protected String naslov;

    /**
     * 
     */
    protected String originalniNaslov;

    /**
     * 
     */
    protected String pisac;

    /**
     * 
     */
    protected int godinaObjavljivanja;

    /**
     * 
     */
    protected String opis;

    /**
     * 
     */
    protected Zanr zanr;

    /**
     * 
     */
    protected List<PrimerakKnjige> sviPrimerci;

    /**
     * 
     */
    protected Jezik jezikOriginala;

}