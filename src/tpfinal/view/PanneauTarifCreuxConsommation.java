package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tpfinal.controler.ControlerInsertion;
import tpfinal.model.Tarif;
import tpfinal.view.PanneauInsertionPlageHoraire.BouttonListenerPlageHoraire;

public class PanneauTarifCreuxConsommation  extends JPanel{
	private JComboBox tarifsBox = new JComboBox();
	private JButton b = new JButton("Compter les plages de consommations associés");
	
	private ControlerInsertion cInsertion;
	public PanneauTarifCreuxConsommation(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
		for(Tarif tarif : cInsertion.getTarifsCreux())
			tarifsBox.addItem(tarif.getCode());
	}
	
	public void paintComponent(Graphics g){
		this.add(tarifsBox);
		this.b.addActionListener(new BouttonListener());
		this.add(b);
		
		this.validate();
	}
	class BouttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(tarifsBox.getSelectedItem() != null)
				JOptionPane.showMessageDialog(null, cInsertion.countPlages((int)tarifsBox.getSelectedItem()) + " plages de consommations associés à ce tarif creux.");
			else
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
		}
	}
}
