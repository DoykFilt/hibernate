package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tpfinal.controler.ControlerInsertion;

public class PanneauInsertionTarif extends JPanel {
	private JFormattedTextField  debutField = new JFormattedTextField(DateFormat.getTimeInstance());
	private JFormattedTextField  finField = new JFormattedTextField(DateFormat.getTimeInstance());
	private JFormattedTextField  prixField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField  reductionField = new JFormattedTextField(NumberFormat.getPercentInstance());
	private JButton b = new JButton("Créer le tarif");

	private ControlerInsertion cInsertion;
	public PanneauInsertionTarif(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
	}
	public void paintComponent(Graphics g){
		g.drawString("Ajouter un tarif", 0, 0);
		g.drawString("Heure de début", 0, 10);
		this.add(debutField);
		g.drawString("Heure de fin", 0, 30);
		this.add(finField);
		g.drawString("Prix", 0, 50);
		this.add(prixField);
		g.drawString("Reduction (null = heure pleine)", 0, 70);
		this.add(reductionField);
		this.b.addActionListener(new BouttonListenerTarif());
		this.add(b);
		
		this.validate();
	}
	class BouttonListenerTarif implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			float reduction;
			if(reductionField.getValue() == null)
				reduction = 0.0f;
			else
				reduction = (float)reductionField.getValue();
			
			if(debutField.getValue() != null && finField.getValue() != null 
					&& prixField.getValue() != null)
				cInsertion.insertTarif((java.time.LocalTime)debutField.getValue(), (java.time.LocalTime)finField.getValue(), (float)prixField.getValue(), reduction);
			else
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
			
		}
	}
}

