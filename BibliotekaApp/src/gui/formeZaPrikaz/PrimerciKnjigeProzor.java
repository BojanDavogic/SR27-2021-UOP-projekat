package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import app.BibliotekaApp;
import app.BibliotekaMain;
import gui.formeZaDodavanjeIzmenu.PrimerciKnjigeForma;
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
			if(primerakKnjige.isJeIznajmljena()) {
				sadrzaj[red][3] = "Da";
			} else {
				sadrzaj[red][3] = "Ne";
			}
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
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerciKnjigeForma pkf = new PrimerciKnjigeForma(biblioteka, null, tableModel, primerciKnjigeTabela);
				pkf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerciKnjigeTabela.getSelectedRow();
				if(red == -1) {
					
					JOptionPane.showMessageDialog(null, "Molimo odaberite red u tabeli koji zelite da izmenite.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int primerakKnjigeID = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					PrimerakKnjige primerakKnjige = biblioteka.pronadjiPrimerak(primerakKnjigeID);
					

					PrimerciKnjigeForma pkf = new PrimerciKnjigeForma(biblioteka, primerakKnjige,tableModel, primerciKnjigeTabela);
					pkf.setVisible(true);
					
				}
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = primerciKnjigeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Molimo odaberite red u tabeli koji zelite da obrisete.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int primerakKnjigeID = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					PrimerakKnjige primerakKnjige = biblioteka.pronadjiPrimerak(primerakKnjigeID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete primerak knjige?", 
							primerakKnjigeID + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						primerakKnjige.setObrisana(true);
						tableModel.removeRow(red);
						biblioteka.snimiPrimerkeKnjige(BibliotekaMain.PRIMERCI_KNJIGE_FAJL);
					}
				}
				
			}
		});
	}
}
