package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.BibliotekaApp;
import gui.formeZaPrikaz.AdministratoriProzor;
import gui.formeZaPrikaz.BibliotekariProzor;
import gui.formeZaPrikaz.ClanoviBibliotekeProzor;
import gui.formeZaPrikaz.IznajmljivanjaProzor;
import gui.formeZaPrikaz.KnjigeProzor;
import gui.formeZaPrikaz.PrimerciKnjigeProzor;
import gui.formeZaPrikaz.TipClanarineProzor;
import gui.formeZaPrikaz.ZanroviProzor;
import model.Zaposleni;

public class GlavniProzor extends JFrame {
	private static final long serialVersionUID = -5457898115685474680L;

	private JMenuBar mainMenu = new JMenuBar();
	
	private JMenu katalogMenu = new JMenu("Katalog");
	private JMenuItem knjigeItem = new JMenuItem("Knjige");
	private JMenuItem primerciKnjigeItem = new JMenuItem("Primerci knjige");
	private JMenuItem zanrItem = new JMenuItem("Zanrovi");
	private JMenuItem tipClanarineItem = new JMenuItem("Tipovi clanarine");
	private JMenuItem iznajmljivanjaItem = new JMenuItem("Iznajmljivanja");
	
	private JMenu zaposleniMenu = new JMenu("Zaposleni");
	private JMenuItem administratoriItem = new JMenuItem("Administratori");
	private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
	
	private JMenu clanoviMenu = new JMenu("Clanovi");
	private JMenuItem clanoviBibliotekeItem = new JMenuItem("Clanovi biblioteke");
	
	private BibliotekaApp biblioteka;
	private Zaposleni prijavljeniKorisnik;
	
	public GlavniProzor(BibliotekaApp biblioteka, Zaposleni prijavljeniKorisnik) {
		this.biblioteka = biblioteka;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		
		setTitle("Zaposleni: " + prijavljeniKorisnik.getKorisnickoIme());
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		ImageIcon LoginImage = new ImageIcon("src/slike/login-logo.png");
		setIconImage(LoginImage.getImage());
		getContentPane().setBackground(new Color(142,104,104));
		initMenu();
		initActions();
	}
	
	public void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(katalogMenu);
		katalogMenu.add(knjigeItem);
		katalogMenu.add(primerciKnjigeItem);
		katalogMenu.add(zanrItem);
		katalogMenu.add(tipClanarineItem);
		katalogMenu.add(iznajmljivanjaItem);
		
		mainMenu.add(zaposleniMenu);
		zaposleniMenu.add(administratoriItem);
		zaposleniMenu.add(bibliotekariItem);
		
		mainMenu.add(clanoviMenu);
		clanoviMenu.add(clanoviBibliotekeItem);
	}
	
	public void initActions() {
		knjigeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeProzor kp = new KnjigeProzor(biblioteka);
				kp.setVisible(true);		
			}
		});
		
		zanrItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanroviProzor zp = new ZanroviProzor(biblioteka);
				zp.setVisible(true);			
			}
		});
		
		administratoriItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriProzor ap = new AdministratoriProzor(biblioteka);
				ap.setVisible(true);				
			}
		});
		
		bibliotekariItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekariProzor bp = new BibliotekariProzor(biblioteka);
				bp.setVisible(true);			
			}
		});
		
		primerciKnjigeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerciKnjigeProzor pkp = new PrimerciKnjigeProzor(biblioteka);
				pkp.setVisible(true);
			}
		});
			
		clanoviBibliotekeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanoviBibliotekeProzor cbp = new ClanoviBibliotekeProzor(biblioteka);
				cbp.setVisible(true);
				
			}
		});
		
		iznajmljivanjaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjaProzor ip = new IznajmljivanjaProzor(biblioteka);
				ip.setVisible(true);
				
			}
		});
		
		tipClanarineItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TipClanarineProzor tcp = new TipClanarineProzor(biblioteka);
				tcp.setVisible(true);
				
			}
		});
		
	}
	
}
