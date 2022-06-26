package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.BibliotekaApp;
import net.miginfocom.swing.MigLayout;

public class PocetniProzor extends JFrame {
	private static final long serialVersionUID = 1770843135344365238L;
	private JLabel lblGreeting = new JLabel("Dobrodosli na sistem biblioteke");
	private JButton btnZaposleni = new JButton("Za zaposlene");
	private JButton btnClanovi = new JButton("Za clanove biblioteke");
	
	private BibliotekaApp biblioteka;
	
	public PocetniProzor(BibliotekaApp biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Sistem biblioteke");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		ImageIcon LibraryImage = new ImageIcon("src/slike/library-logo.png");
		setIconImage(LibraryImage.getImage());
		getContentPane().setBackground(new Color(142,104,104));
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("center, wrap, gapy 5");
		setLayout(mig);
		add(lblGreeting);
		lblGreeting.setPreferredSize(new Dimension(200,40));
//		add(new JLabel());
		add(btnZaposleni);
		btnZaposleni.setPreferredSize(new Dimension(300,40));
		add(Box.createVerticalGlue());
		add(btnClanovi);
		btnClanovi.setPreferredSize(new Dimension(300,40));
		
		lblGreeting.setForeground(new Color(255,255,255));
		lblGreeting.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		lblGreeting.setBorder(BorderFactory.createCompoundBorder(
		        lblGreeting.getBorder(), 
		        BorderFactory.createEmptyBorder(0, 30, 10, 0)));
		
		
	}
	
	public void initActions() {
		btnZaposleni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(biblioteka);
				login.setVisible(true);
				
			}
		});
		btnClanovi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Registracija registacija = new Registracija(biblioteka, null);
				registacija.setVisible(true);
				
			}
		});
	}
}
