package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tpfinal.controler.ControlerInsertion;
import tpfinal.model.Compteur;
import tpfinal.model.PlageHoraire;

public class PanneauRelationCompteurPlageHoraire extends JPanel{
	private JComboBox compteurBox = new JComboBox<>();
	private JComboBox plageBox = new JComboBox<>();
	private JButton b = new JButton("Créer l'association");

	private ControlerInsertion cInsertion;
	public PanneauRelationCompteurPlageHoraire(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
		for(Compteur compteur : cInsertion.getCompteurs())
			compteurBox.addItem(compteur.getNumero());
		for(PlageHoraire plage : cInsertion.getPlagesHoraires())
			plageBox.addItem(plage.getId());
	}
	public void paintComponent(Graphics g){
		g.drawString("Associer un compteur à une consommation", 0, 0);
		g.drawString("Compteur", 0, 10);
		this.add(compteurBox);
		g.drawString("Plage Horaire", 0, 30);
		this.add(plageBox);
		this.b.addActionListener(new BouttonListenerInsertAssociation2());
		this.add(b);
		
		this.validate();
	}
	class BouttonListenerInsertAssociation2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(compteurBox.getSelectedItem() != null && plageBox.getSelectedItem() != null)
				cInsertion.insertRelationCompteurPlageHoraire((int)compteurBox.getSelectedItem(), (int)plageBox.getSelectedItem());
			else
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
		}
	}
}

