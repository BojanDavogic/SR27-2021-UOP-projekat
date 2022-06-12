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
import gui.formeZaDodavanjeIzmenu.ZanroviForma;
import model.Zanr;

public class ZanroviProzor extends JFrame {
	private static final long serialVersionUID = 3015539186943753010L;
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable zanroviTabela;
	
	private BibliotekaApp biblioteka;
	
	public ZanroviProzor(BibliotekaApp biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Zanrovi");
		setSize(600, 400);
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
		
		HashMap<Integer, Zanr> neobrisaniZanrovi = biblioteka.sviNeobrisaniZanrovi();
		
		String[] zaglavlja = new String [] {"ID", "Oznaka", "Opis"};
		Object [][] sadrzaj = new Object[neobrisaniZanrovi.size()][zaglavlja.length];
		
		int red = 0;
		for(Zanr zanr : neobrisaniZanrovi.values()) {
			sadrzaj[red][0] = zanr.getId();
			sadrzaj[red][1] = zanr.getOznaka();
			sadrzaj[red][2] = zanr.getOpis();
			
			red++;
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		zanroviTabela = new JTable(tableModel);
		
		zanroviTabela.setRowSelectionAllowed(true);
		zanroviTabela.setColumnSelectionAllowed(false);
		zanroviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zanroviTabela.setDefaultEditor(Object.class, null);
		zanroviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(zanroviTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanroviForma zf = new ZanroviForma(biblioteka, null, tableModel, zanroviTabela);
				zf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanroviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Molimo odaberite red u tabeli koji zelite da izmenite.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int zanrID = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					Zanr zanr = biblioteka.pronadjiZanr(zanrID);

					
					ZanroviForma zf = new ZanroviForma(biblioteka, zanr, tableModel, zanroviTabela);
					zf.setVisible(true);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanroviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Molimo odaberite red u tabeli koji zelite da obrisete.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int zanrID = Integer.parseInt(tableModel.getValueAt(red, 0).toString());
					Zanr zanr = biblioteka.pronadjiZanr(zanrID);
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete zanr?", 
							zanrID + " - Potvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						zanr.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiZanrove(BibliotekaMain.ZANROVI_FAJL);
					}
				}
				
			}
		});
	}
}
