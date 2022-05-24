package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.BibliotekaApp;
import model.Zaposleni;

public class GlavniProzor extends JFrame {
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu ArtikMenu = new JMenu("Knjige");
	private JMenuItem diskoviItem = new JMenuItem("Diskovi");
	private JMenuItem knjigeItem = new JMenuItem("Knjige");
	private JMenuItem kompozicijeItem = new JMenuItem("Kompozicije");
	private JMenu prodavciMenu = new JMenu("Prodavci");
	private JMenuItem prodavciItem = new JMenuItem("Prodavci");
	
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
		ImageIcon LoginImage = new ImageIcon("login-logo.png");
		setIconImage(LoginImage.getImage());
		getContentPane().setBackground(new Color(142,104,104));
		initMenu();
		initActions();
	}
	
	public void initMenu() {
		
	}
	
	public void initActions() {
	}
	
}
