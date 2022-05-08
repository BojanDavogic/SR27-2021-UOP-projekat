package model;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Iznajmljivanje {

    /**
     * Default constructor
     */
    public Iznajmljivanje() {
    }

    /**
     * 
     */
    protected int id;

    /**
     * 
     */
    protected LocalDate datumIznajmljivanja;

    /**
     * 
     */
    protected LocalDate datumVracanja;

    /**
     * 
     */
    protected Zaposleni zaposleni;

    /**
     * 
     */
    protected ClanBiblioteke clan;

    /**
     * 
     */
    protected Set<PrimerakKnjige> primerak;

}