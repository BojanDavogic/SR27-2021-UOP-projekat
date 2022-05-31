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
import model.Iznajmljivanje;

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
		
		String[] zaglavlja = new String [] {"ID", "Datum iznajmljivanja", "Datum vracanja", "Zaposleni", "Clan"};
		Object [][] sadrzaj = new Object[neobrisanaIznajmljivanja.size()][zaglavlja.length];
		
		int red = 0;
		for(Iznajmljivanje iznajmljivanje : neobrisanaIznajmljivanja.values()) {
			sadrzaj[red][0] = iznajmljivanje.getId();
			sadrzaj[red][1] = iznajmljivanje.getDatumIznajmljivanja();
			sadrzaj[red][2] = iznajmljivanje.getDatumVracanja();
			sadrzaj[red][3] = iznajmljivanje.getZaposleni().getIme() + " " + iznajmljivanje.getZaposleni().getPrezime();
			sadrzaj[red][4] = iznajmljivanje.getClan().getIme() + " " + iznajmljivanje.getClan().getPrezime();
			
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
		
	}
}
