package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import app.BibliotekaApp;
import net.miginfocom.swing.MigLayout;

import model.Biblioteka;
import model.Zaposleni;

public class Login extends JFrame {
	private JLabel lblGreeting = new JLabel("Dobrodosli, molimo Vas da se prijavite.");
	private JLabel lblUsername = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblPassword = new JLabel("Lozinka");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private BibliotekaApp biblioteka;
	
	public Login(BibliotekaApp biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Prijava");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		ImageIcon LibraryImage = new ImageIcon("library-logo.png");
		setIconImage(LibraryImage.getImage());
		getContentPane().setBackground(new Color(142,104,104));
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblGreeting, "span 2");
		add(lblUsername);
		add(txtKorisnickoIme);
		add(lblPassword);
		add(pfPassword);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		lblGreeting.setForeground(new Color(255,255,255));
		lblGreeting.setFont(new Font("Helvetica", Font.BOLD, 16));
		lblUsername.setForeground(new Color(255,255,255));
		lblUsername.setFont(new Font("Sans Serif", Font.BOLD, 13));
		lblPassword.setForeground(new Color(255,255,255));
		lblPassword.setFont(new Font("Sans Serif", Font.BOLD, 13));
		
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		
		lblGreeting.setBorder(BorderFactory.createCompoundBorder(
		        lblGreeting.getBorder(), 
		        BorderFactory.createEmptyBorder(0, 0, 10, 0)));
		
	}
	
	public void initActions() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String lozinka = new String(pfPassword.getPassword()).trim();
				
				if (korisnickoIme.equals("") || lozinka.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Zaposleni prijavljeni = biblioteka.login(korisnickoIme, lozinka);
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogresni podaci za prijavu", "Greska", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Login.this.dispose();
						Login.this.setVisible(false);
						
						GlavniProzor glavniProzor = new GlavniProzor(biblioteka, prijavljeni);
						glavniProzor.setVisible(true);
					}
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Login.this.dispose();
				Login.this.setVisible(false);
				
			}
		});
	}
	
	
}
