package gui.formeZaDodavanjeIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import app.BibliotekaApp;
import app.BibliotekaMain;
import gui.formeZaPrikaz.BibliotekariProzor;
import model.Administrator;
import model.Bibliotekar;
import model.ClanBiblioteke;
import model.Iznajmljivanje;
import model.Knjiga;
import model.PrimerakKnjige;
import model.TipClanarine;
import model.Zanr;
import model.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class IznajmljivanjaForma extends JFrame {
	private static final long serialVersionUID = -1130640948699485928L;
	
	private JLabel lblID = new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	private JLabel lblDatumIznajmljivanja = new JLabel("Datum iznajmljivanja");
	private JTextField txtDatumIznajmljivanja = new JTextField(20);
	private JLabel lblDatumVracanja = new JLabel("Datum vracanja");
	private JTextField txtDatumVracanja = new JTextField(20);
	private JLabel lblPrimerci = new JLabel("Primerci");
	private JList<PrimerakKnjige> listaPrimeraka;
	private JLabel lblZaposleni = new JLabel("Zaposleni");
	private JComboBox<Zaposleni> comboBoxZaposleni;
	private JLabel lblClan = new JLabel("Clan");
	private JComboBox<ClanBiblioteke> comboBoxClanBiblioteke;
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Iznajmljivanje iznajmljivanje;
	private BibliotekaApp biblioteka;
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjeTabela;
	private HashMap<Integer, PrimerakKnjige> primerci;
	
	
	public IznajmljivanjaForma(BibliotekaApp biblioteka, Iznajmljivanje iznajmljivanje, DefaultTableModel tableModel, JTable iznajmljivanjeTabela) {
		this.biblioteka = biblioteka;
		this.iznajmljivanje = iznajmljivanje;
		this.tableModel = tableModel;
		this.iznajmljivanjeTabela = iznajmljivanjeTabela;
		
		Collection<PrimerakKnjige> primerci = biblioteka.sviNeobrisaniPrimerciKnjige().values();
		this.listaPrimeraka = new JList<PrimerakKnjige>(primerci.toArray(new PrimerakKnjige[0]));
		listaPrimeraka.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		Collection<Zaposleni> zaposleni = biblioteka.sviNeobrisaniZaposleni().values();
		this.comboBoxZaposleni = new JComboBox<Zaposleni>(zaposleni.toArray(new Zaposleni[0]));
		
		Collection<ClanBiblioteke> clanovi = biblioteka.sviNeobrisaniClanoviBiblioteke().values();
		this.comboBoxClanBiblioteke = new JComboBox<ClanBiblioteke>(clanovi.toArray(new ClanBiblioteke[0]));
		
		if(iznajmljivanje == null) {
			setTitle("Dodavanje iznajmljivanja");
		} else {
			setTitle("Izmena podataka - " + iznajmljivanje.getId());
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(iznajmljivanje != null) {
			txtID.setEnabled(false);
			popuniPolja();
		}
		
		add(lblID);
		add(txtID);
		add(lblDatumIznajmljivanja);
		add(txtDatumIznajmljivanja);
		add(lblDatumVracanja);
		add(txtDatumVracanja);
		add(lblPrimerci);
		add(listaPrimeraka);
		add(lblZaposleni);
		add(comboBoxZaposleni);
		add(lblClan);
		add(comboBoxClanBiblioteke);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
		
	}
	
	private void initActions() {
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = Integer.parseInt(txtID.getText().trim());
					LocalDate datumIznajmljivanja = LocalDate.parse(txtDatumIznajmljivanja.getText().trim());
					LocalDate datumVracanja = LocalDate.parse(txtDatumVracanja.getText().trim());
					
					String stringPrimerci = "";
					List<PrimerakKnjige> selectedPrimerci = listaPrimeraka.getSelectedValuesList();
					for(PrimerakKnjige primerak: selectedPrimerci) {
						stringPrimerci += primerak + "; ";
					}
					System.out.println(stringPrimerci);
					
					
//					ArrayList<Integer> strPrimerci = new ArrayList<>();
//					
////					String listaPrimeraka = "";
//					
//					List<PrimerakKnjige> selectedPrimerci = listaPrimeraka.getSelectedValuesList();
//					for(PrimerakKnjige primerak: selectedPrimerci) {
//						strPrimerci.add(primerak.getId());
//						
//					}
//					for(int sviPrimerci: strPrimerci) {
//						PrimerakKnjige pk = primerci.get(sviPrimerci);
//						iznajmljivanje.getPrimerci().add(pk);
//					}
					
					
					HashMap<Integer, Zaposleni> sviZaposleni = biblioteka.sviNeobrisaniZaposleni();
					Zaposleni zaposleni = (Zaposleni)comboBoxZaposleni.getSelectedItem();
					zaposleni = sviZaposleni.get(zaposleni.getId());
					
					HashMap<Integer, ClanBiblioteke> clanovi = biblioteka.sviNeobrisaniClanoviBiblioteke();
					ClanBiblioteke clan = (ClanBiblioteke)comboBoxClanBiblioteke.getSelectedItem();
					clan = clanovi.get(clan.getId());
					
					if(iznajmljivanje == null) {
						iznajmljivanje = new Iznajmljivanje(id, datumIznajmljivanja, datumVracanja, zaposleni, clan, false);
						
						biblioteka.dodajIznajmljivanje(iznajmljivanje);
						Object[] red = kreirajRedTabele(iznajmljivanje);
						tableModel.addRow(red);
					} else {
						iznajmljivanje.setDatumIznajmljivanja(datumIznajmljivanja);
						iznajmljivanje.setDatumVracanja(datumVracanja);
//						iznajmljivanje.setPrimerci(primerci);
						iznajmljivanje.setZaposleni(zaposleni);
						iznajmljivanje.setClan(clan);
						
						int red = iznajmljivanjeTabela.getSelectedRow();
						refresh(red, iznajmljivanje);
					}
					
					biblioteka.snimiIznajmljivanja(BibliotekaMain.IZNAJMLJIVANJE_FAJL);
					iznajmljivanjeTabela.clearSelection();
					IznajmljivanjaForma.this.dispose();
					IznajmljivanjaForma.this.setVisible(false);
					
				}
				
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjaForma.this.dispose();
				IznajmljivanjaForma.this.setVisible(false);
				
			}
		});
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite greske u unosu:\n";
		
		if(txtID.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ok = false;
		} else if(iznajmljivanje == null) {
			int id = Integer.parseInt(txtID.getText().trim());
			Iznajmljivanje pronadjen = biblioteka.pronadjiIznajmljivanje(id);
			if(pronadjen != null) {
				poruka += "- Iznajmljivanje sa unetim ID vec postoji\n";
				ok = false;
			}
		}
		
		if(txtDatumIznajmljivanja.getText().trim().equals("")) {
			poruka += "- Morate uneti datum iznajmljivanja\n";
			ok = false;
		}
		
		if(txtDatumVracanja.getText().trim().equals("")) {
			poruka += "- Morate uneti datum vracanja\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
	
	
	private void popuniPolja() {
		txtID.setText(String.valueOf(iznajmljivanje.getId()));
		txtDatumIznajmljivanja.setText(String.valueOf(iznajmljivanje.getDatumIznajmljivanja()));
		txtDatumVracanja.setText(String.valueOf(iznajmljivanje.getDatumVracanja()));
	}
	
	private Object[] kreirajRedTabele(Iznajmljivanje iznajmljivanje) {
		Object[] red = new Object[6];
		
		red[0] = iznajmljivanje.getId();
		red[1] = iznajmljivanje.getDatumIznajmljivanja();
		red[2] = iznajmljivanje.getDatumVracanja();
		String strPrimerci = "";
		List<PrimerakKnjige> selectedPrimerci = listaPrimeraka.getSelectedValuesList();
		for(PrimerakKnjige primerak: selectedPrimerci) {
			strPrimerci += primerak + "; ";
		}
		red[3] = strPrimerci;
		red[4] = iznajmljivanje.getZaposleni().getIme() + " " + iznajmljivanje.getZaposleni().getPrezime();
		red[5] = iznajmljivanje.getClan().getIme() + " " + iznajmljivanje.getClan().getPrezime();
		
		return red;
	}
	
	private void refresh(int red, Iznajmljivanje iznajmljivanje) {
			if(red >= 0) {
				tableModel.setValueAt(iznajmljivanje.getId(), red, 0);
				tableModel.setValueAt(iznajmljivanje.getDatumIznajmljivanja(), red, 1);
				tableModel.setValueAt(iznajmljivanje.getDatumVracanja(), red, 2);
				tableModel.setValueAt(iznajmljivanje.getPrimerci(), red, 3);
				tableModel.setValueAt(iznajmljivanje.getZaposleni().getIme() + " " + iznajmljivanje.getZaposleni().getPrezime(), red, 4);	
				tableModel.setValueAt(iznajmljivanje.getClan().getIme() + " " + iznajmljivanje.getClan().getPrezime(), red, 5);
				
			}
	}
}
