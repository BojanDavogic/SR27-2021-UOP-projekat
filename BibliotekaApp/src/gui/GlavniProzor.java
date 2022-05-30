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
import gui.formeZaPrikaz.KnjigeProzor;
import model.Zaposleni;

public class GlavniProzor extends JFrame {
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
	}
	
}
