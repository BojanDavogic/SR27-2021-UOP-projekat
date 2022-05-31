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
import model.TipClanarine;

public class TipClanarineProzor extends JFrame {
	private static final long serialVersionUID = -9193876548221924945L;

	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable tipClanarineTabela;
	
	private BibliotekaApp biblioteka;
	
	public TipClanarineProzor(BibliotekaApp biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Tipovi clanarine");
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
		
		HashMap<Integer, TipClanarine> neobrisaniTipoviClanarine = biblioteka.sviNeobrisaniTipoviClanarine();
		
		String[] zaglavlja = new String [] {"ID", "Naziv", "Cena"};
		Object [][] sadrzaj = new Object[neobrisaniTipoviClanarine.size()][zaglavlja.length];
		
		int red = 0;
		for(TipClanarine tipClanarine : neobrisaniTipoviClanarine.values()) {
			sadrzaj[red][0] = tipClanarine.getId();
			sadrzaj[red][1] = tipClanarine.getNaziv();
			sadrzaj[red][2] = tipClanarine.getCena();
			
			red++;
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		tipClanarineTabela = new JTable(tableModel);
		
		tipClanarineTabela.setRowSelectionAllowed(true);
		tipClanarineTabela.setColumnSelectionAllowed(false);
		tipClanarineTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tipClanarineTabela.setDefaultEditor(Object.class, null);
		tipClanarineTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(tipClanarineTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void initActions() {
		
	}
}
