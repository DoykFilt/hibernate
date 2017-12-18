package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tpfinal.controler.ControlerInsertion;
import tpfinal.model.Adresse;
import tpfinal.model.Personne;

public class PanneauInsertionsCompteur extends JPanel {
	private JFormattedTextField  dateField = new JFormattedTextField(DateFormat.getDateInstance());
	private JComboBox comboAdresse = new JComboBox();
	private JComboBox comboPersonne = new JComboBox();
	private JButton b = new JButton("Créer la personne");

	private ControlerInsertion cInsertion;
	public PanneauInsertionsCompteur(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
		for(Adresse adresse : cInsertion.getAdresses())
			comboAdresse.addItem(adresse.getId());
		for(Personne personne : cInsertion.getPersonnes())
			comboPersonne.addItem(personne.getNumero_securite_social());
	}
	public void paintComponent(Graphics g){
		g.drawString("Ajouter une personne", 0, 0);
		g.drawString("Date activation", 0, 10);
		this.add(dateField);
		this.add(comboAdresse);
		this.add(comboPersonne);
		this.b.addActionListener(new BouttonListenerCompteur());
		this.add(b);
		
		this.validate();
	}
	class BouttonListenerCompteur implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(dateField.getValue() != null && comboAdresse.getSelectedItem() != null && comboPersonne.getSelectedItem() != null)
				cInsertion.insertCompteur((Date)dateField.getValue(), (int)comboAdresse.getSelectedItem(), (String)comboPersonne.getSelectedItem());
			else
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
		}
	}
}

