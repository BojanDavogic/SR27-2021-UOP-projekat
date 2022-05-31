package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import app.BibliotekaApp;
import model.Bibliotekar;

public class BibliotekariProzor extends JFrame {
	private static final long serialVersionUID = -6222963392369878326L;
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable bibliotekariTabela;
	
	private BibliotekaApp biblioteka;
	
	public BibliotekariProzor(BibliotekaApp biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Bibliotekari");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		ImageIcon LibraryImage = new ImageIcon("src/slike/library-logo.png");
		setIconImage(LibraryImage.getImage());
		getContentPane().setBackground(new Color(142,104,104));
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		ImageIcon addImage = new ImageIcon("src/slike/add.gif");
		btnAdd.setIcon(addImage);
		ImageIcon editImage = new ImageIcon("src/slike/edit.gif");
		btnEdit.setIcon(editImage);
		ImageIcon deleteImage = new ImageIcon("src/slike/delete.gif");
		btnDelete.setIcon(deleteImage);
		
		mainToolBar.add(btnAdd);
		mainToolBar.add(btnEdit);
		mainToolBar.add(btnDelete);
		
		add(mainToolBar, BorderLayout.NORTH);
		
		HashMap<Integer, Bibliotekar> neobrisaniBibliotekari = biblioteka.sviNeobrisaniBibliotekari();
		
		String[] zaglavlja = new String [] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Plata", "Korisnicko ime", "Lozinka"};
		Object [][] sadrzaj = new Object[neobrisaniBibliotekari.size()][zaglavlja.length];
		
		int red = 0;
		for(Bibliotekar bibliotekar : neobrisaniBibliotekari.values()) {
			sadrzaj[red][0] = bibliotekar.getId();
			sadrzaj[red][1] = bibliotekar.getIme();
			sadrzaj[red][2] = bibliotekar.getPrezime();
			sadrzaj[red][3] = bibliotekar.getJMBG();
			sadrzaj[red][4] = bibliotekar.getAdresa();
			sadrzaj[red][5] = bibliotekar.getPol();
			sadrzaj[red][6] = bibliotekar.getPlata();
			sadrzaj[red][7] = bibliotekar.getKorisnickoIme();
			sadrzaj[red][8] = bibliotekar.getLozinka();
			
			red++;
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		bibliotekariTabela = new JTable(tableModel);
		
		bibliotekariTabela.setRowSelectionAllowed(true);
		bibliotekariTabela.setColumnSelectionAllowed(false);
		bibliotekariTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bibliotekariTabela.setDefaultEditor(Object.class, null);
		bibliotekariTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(bibliotekariTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
	}
}
