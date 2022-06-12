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
import gui.formeZaDodavanjeIzmenu.IznajmljivanjaForma;
import model.Iznajmljivanje;
import model.PrimerakKnjige;

public class IznajmljivanjaProzor extends JFrame {
	private static final long serialVersionUID = -5429257510767410274L;

	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjaTabela;
	
	private BibliotekaApp biblioteka;
	
	public IznajmljivanjaProzor(BibliotekaApp biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Iznajmljivanja");
		setSize(600, 300);
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
		
		HashMap<Integer, Iznajmljivanje> neobrisanaIznajmljivanja = biblioteka.svaNeobrisanaIznajmljivanja();
		
		String[] zaglavlja = new String [] {"ID", "Datum iznajmljivanja", "Datum vracanja", "Primerci", "Zaposleni", "Clan"};
		Object [][] sadrzaj = new Object[neobrisanaIznajmljivanja.size()][zaglavlja.length];
		
		int red = 0;
		for(Iznajmljivanje iznajmljivanje : neobrisanaIznajmljivanja.values()) {
			String txtPrimerci = "";
			for (PrimerakKnjige primerak : iznajmljivanje.getPrimerci()) {
				txtPrimerci += primerak.getKnjiga().getNaslov() + "; ";
			}
			
			sadrzaj[red][0] = iznajmljivanje.getId();
			sadrzaj[red][1] = iznajmljivanje.getDatumIznajmljivanja();
			sadrzaj[red][2] = iznajmljivanje.getDatumVracanja();
			sadrzaj[red][3] = txtPrimerci;
			sadrzaj[red][4] = iznajmljivanje.getZaposleni().getIme() + " " + iznajmljivanje.getZaposleni().getPrezime();
			sadrzaj[red][5] = iznajmljivanje.getClan().getIme() + " " + iznajmljivanje.getClan().getPrezime();
			
			red++;
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		iznajmljivanjaTabela = new JTable(tableModel);
		
		iznajmljivanjaTabela.setRowSelectionAllowed(true);
		iznajmljivanjaTabela.setColumnSelectionAllowed(false);
		iznajmljivanjaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iznajmljivanjaTabela.setDefaultEditor(Object.class, null);
		iznajmljivanjaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(iznajmljivanjaTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjaForma izf = new IznajmljivanjaForma(biblioteka, null, tableModel, iznajmljivanjaTabela);
				izf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjaTabela.getSelectedRow();
				if(red == -1) {
					
					JOptionPane.showMessageDialog(null, "Molimo odaberite red u tabeli koji zelite da izmenite.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int iznajmljivanjeID = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					Iznajmljivanje iznajmljivanje = biblioteka.pronadjiIznajmljivanje(iznajmljivanjeID);
					

					IznajmljivanjaForma tcf = new IznajmljivanjaForma(biblioteka, iznajmljivanje, tableModel, iznajmljivanjaTabela);
					tcf.setVisible(true);
					
				}
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjaTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Molimo odaberite red u tabeli koji zelite da obrisete.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int iznajmljivanjeID = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					Iznajmljivanje iznajmljivanje = biblioteka.pronadjiIznajmljivanje(iznajmljivanjeID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete iznajmljivanje?", 
							iznajmljivanjeID + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						iznajmljivanje.setObrisano(true);
						tableModel.removeRow(red);
						biblioteka.snimiIznajmljivanja(BibliotekaMain.IZNAJMLJIVANJE_FAJL);
					}
				}
				
			}
		});
	}
}
