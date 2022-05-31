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
import model.ClanBiblioteke;

public class ClanoviBibliotekeProzor extends JFrame {
	private static final long serialVersionUID = -4448137632791694198L;
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable clanoviBibliotekeTabela;
	
	private BibliotekaApp biblioteka;
	
	public ClanoviBibliotekeProzor(BibliotekaApp biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Clanovi biblioteke");
		setSize(1100, 300);
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
		
		HashMap<Integer, ClanBiblioteke> neobrisaniClanoviBiblioteke = biblioteka.sviNeobrisaniClanoviBiblioteke();
		
		String[] zaglavlja = new String [] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Broj clanske karte", "Datum poslednje uplate", "Unapred uplaceno meseci", "Aktivan", "Tip clanarine"};
		Object [][] sadrzaj = new Object[neobrisaniClanoviBiblioteke.size()][zaglavlja.length];
		
		int red = 0;
		for(ClanBiblioteke clanBiblioteke : neobrisaniClanoviBiblioteke.values()) {
			sadrzaj[red][0] = clanBiblioteke.getId();
			sadrzaj[red][1] = clanBiblioteke.getIme();
			sadrzaj[red][2] = clanBiblioteke.getPrezime();
			sadrzaj[red][3] = clanBiblioteke.getJMBG();
			sadrzaj[red][4] = clanBiblioteke.getAdresa();
			sadrzaj[red][5] = clanBiblioteke.getPol();
			sadrzaj[red][6] = clanBiblioteke.getBrojClanskeKarte();
			sadrzaj[red][7] = clanBiblioteke.getDatumPoslednjeUplate();
			sadrzaj[red][8] = clanBiblioteke.getUnapredUplacenoMeseci();
			sadrzaj[red][9] = clanBiblioteke.isJeAktivan();
			sadrzaj[red][10] = clanBiblioteke.getTipClanarine().getNaziv();
			
			red++;
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanoviBibliotekeTabela = new JTable(tableModel);
		
		clanoviBibliotekeTabela.getColumnModel().getColumn(0).setPreferredWidth(5);
		clanoviBibliotekeTabela.getColumnModel().getColumn(1).setPreferredWidth(20);
		clanoviBibliotekeTabela.getColumnModel().getColumn(2).setPreferredWidth(30);
		clanoviBibliotekeTabela.getColumnModel().getColumn(3).setPreferredWidth(60);
		clanoviBibliotekeTabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		clanoviBibliotekeTabela.getColumnModel().getColumn(5).setPreferredWidth(15);
		clanoviBibliotekeTabela.getColumnModel().getColumn(7).setPreferredWidth(100);
		clanoviBibliotekeTabela.getColumnModel().getColumn(8).setPreferredWidth(110);
		clanoviBibliotekeTabela.getColumnModel().getColumn(9).setPreferredWidth(15);
		clanoviBibliotekeTabela.getColumnModel().getColumn(10).setPreferredWidth(130);
		
		clanoviBibliotekeTabela.setRowSelectionAllowed(true);
		clanoviBibliotekeTabela.setColumnSelectionAllowed(false);
		clanoviBibliotekeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanoviBibliotekeTabela.setDefaultEditor(Object.class, null);
		clanoviBibliotekeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanoviBibliotekeTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
	}
}
