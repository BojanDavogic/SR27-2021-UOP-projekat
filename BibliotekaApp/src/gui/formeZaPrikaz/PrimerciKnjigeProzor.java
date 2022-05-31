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
import model.PrimerakKnjige;

public class PrimerciKnjigeProzor extends JFrame {
	private static final long serialVersionUID = -3263489409228951306L;

	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable primerciKnjigeTabela;
	
	private BibliotekaApp biblioteka;
	
	public PrimerciKnjigeProzor(BibliotekaApp biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Primerci knjige");
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
		
		HashMap<Integer, PrimerakKnjige> neobrisaniPrimerciKnjige = biblioteka.sviNeobrisaniPrimerciKnjige();
		
		String[] zaglavlja = new String [] {"ID", "Broj strana", "Godina stampanja", "Iznajmljena", "Knjiga", "Tip poveza", "Jezik stampanja"};
		Object [][] sadrzaj = new Object[neobrisaniPrimerciKnjige.size()][zaglavlja.length];
		
		int red = 0;
		for(PrimerakKnjige primerakKnjige : neobrisaniPrimerciKnjige.values()) {
			sadrzaj[red][0] = primerakKnjige.getId();
			sadrzaj[red][1] = primerakKnjige.getBrojStrana();
			sadrzaj[red][2] = primerakKnjige.getGodinaStampanja();
			sadrzaj[red][3] = primerakKnjige.isJeIznajmljena();
			sadrzaj[red][4] = primerakKnjige.getKnjiga().getNaslov();
			sadrzaj[red][5] = primerakKnjige.getTipPoveza();
			sadrzaj[red][6] = primerakKnjige.getJezikStampanja();
			
			red++;
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primerciKnjigeTabela = new JTable(tableModel);
		
		primerciKnjigeTabela.setRowSelectionAllowed(true);
		primerciKnjigeTabela.setColumnSelectionAllowed(false);
		primerciKnjigeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciKnjigeTabela.setDefaultEditor(Object.class, null);
		primerciKnjigeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciKnjigeTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
	}
}
