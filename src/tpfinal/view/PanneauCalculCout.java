package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tpfinal.controler.ControlerInsertion;
import tpfinal.model.Adresse;
import tpfinal.model.Compteur;
import tpfinal.model.Personne;
import tpfinal.view.PanneauInsertionsCompteur.BouttonListenerCompteur;

public class PanneauCalculCout extends JPanel{

	private JFormattedTextField  dateField = new JFormattedTextField(DateFormat.getDateInstance());
	private JComboBox comboCompteur = new JComboBox();
	private JButton b = new JButton("Calculer le coût total de la consommation");

	private ControlerInsertion cInsertion;
	public PanneauCalculCout(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
		for(Compteur compteur : cInsertion.getCompteurs())
			comboCompteur.addItem(compteur.getNumero());
	}
	public void paintComponent(Graphics g){
		g.drawString("Ajouter une personne", 0, 0);
		g.drawString("Date activation", 0, 10);
		this.add(dateField);
		this.add(comboCompteur);
		this.b.addActionListener(new BouttonListenerCompteur());
		this.add(b);
		
		this.validate();
	}
	class BouttonListenerCompteur implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(dateField.getValue() != null && comboCompteur.getSelectedItem() != null)
				JOptionPane.showMessageDialog(null,cInsertion.calculerCoutTotal((Date)dateField.getValue(), (int)comboCompteur.getSelectedItem()));
			else
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
		}
	}
}
