package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tpfinal.controler.ControlerInsertion;
import tpfinal.model.PlageHoraire;
import tpfinal.model.Tarif;

public class PanneauRelationTarifPlage extends JPanel{
	private JComboBox tarifBox = new JComboBox();
	private JComboBox plageBox = new JComboBox();
	private JButton b = new JButton("Créer l'association");

	private ControlerInsertion cInsertion;
	public PanneauRelationTarifPlage(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
		for(Tarif tarif : cInsertion.getTarifs())
			tarifBox.addItem(tarif.getCode());
		for(PlageHoraire plage : cInsertion.getPlagesHoraires())
			plageBox.addItem(plage.getId());
	}
	public void paintComponent(Graphics g){
		g.drawString("Associer une plage horaire à un tarif", 0, 0);
		g.drawString("Plage horaire", 0, 10);
		this.add(tarifBox);
		g.drawString("Tarif", 0, 30);
		this.add(plageBox);
		this.b.addActionListener(new BouttonListenerInsertAssociation1());
		this.add(b);
		
		this.validate();
	}
	class BouttonListenerInsertAssociation1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(tarifBox.getSelectedItem() != null && plageBox.getSelectedItem() != null)
				cInsertion.insertRelationTarifPlageHoraire((int)tarifBox.getSelectedItem(), (int)plageBox.getSelectedItem());
			else
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
		}
	}
}
