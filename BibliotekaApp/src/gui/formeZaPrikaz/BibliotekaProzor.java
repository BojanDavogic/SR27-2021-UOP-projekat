package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import app.BibliotekaApp;
import app.BibliotekaMain;
import gui.formeZaDodavanjeIzmenu.BibliotekaForma;
import gui.formeZaDodavanjeIzmenu.ClanoviBibliotekeForma;
import gui.formeZaDodavanjeIzmenu.UplataClanarineForma;
import model.Biblioteka;
import model.ClanBiblioteke;
import model.Knjiga;
import model.Osoba;
import model.PrimerakKnjige;
import net.miginfocom.swing.MigLayout;

public class BibliotekaProzor extends JFrame {
	private static final long serialVersionUID = -2878897165972703518L;
	private JLabel lblID = new JLabel("ID : ");
	private JLabel txtID = new JLabel();
	private JLabel lblNaziv = new JLabel("Naziv : ");
	private JLabel txtNaziv = new JLabel();
	private JLabel lblAdresa = new JLabel("Adresa : ");
	private JLabel txtAdresa = new JLabel();
	private JLabel lblTelefon = new JLabel("Telefon : ");
	private JLabel txtTelefon = new JLabel();
	private JLabel lblRadnoVreme = new JLabel("Radno vreme : ");
	private JLabel txtRadnoVreme = new JLabel();
	private JButton btnEdit = new JButton("Izmeni podatke");
	
	private BibliotekaApp biblioteka;
	Biblioteka biblioteka2;
	
	public BibliotekaProzor(BibliotekaApp biblioteka, Biblioteka biblioteka2) {
		this.biblioteka = biblioteka;
		this.biblioteka2 = biblioteka2;
		setTitle("Podaci o biblioteci");
		setSize(250, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		ImageIcon LibraryImage = new ImageIcon("src/slike/library-logo.png");
		setIconImage(LibraryImage.getImage());
		getContentPane().setBackground(new Color(142,104,104));
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		popuniPolja();
		add(lblID);
		add(txtID);
		add(lblNaziv);
		add(txtNaziv);
		add(lblAdresa);
		add(txtAdresa);
		add(lblTelefon);
		add(txtTelefon);
		add(lblRadnoVreme);
		add(txtRadnoVreme);
		add(new JLabel());
		add(btnEdit);
		
	}
	
	private void initActions() {
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//					int bibliotekaID = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
//					Biblioteka biblioteka2 = biblioteka.pronadjiBiblioteku(bibliotekaID);
				Biblioteka biblioteka2 = biblioteka.pronadjiBiblioteku(1);

				BibliotekaForma bf = new BibliotekaForma(biblioteka, biblioteka2);
				bf.setVisible(true);
				
			}
		});
	}
	private void popuniPolja() {
		txtID.setText(String.valueOf(biblioteka2.getId()));
		txtNaziv.setText(biblioteka2.getNaziv());
		txtAdresa.setText(biblioteka2.getAdresa());
		txtTelefon.setText(biblioteka2.getTelefon());
		txtRadnoVreme.setText(biblioteka2.getRadnoVreme());
		
	}
}
