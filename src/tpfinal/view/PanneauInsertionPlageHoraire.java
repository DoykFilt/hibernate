package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tpfinal.controler.ControlerInsertion;

public class PanneauInsertionPlageHoraire extends JPanel{
	private JFormattedTextField  dateField = new JFormattedTextField(DateFormat.getDateInstance());
	private JFormattedTextField  debutField = new JFormattedTextField(DateFormat.getTimeInstance());
	private JFormattedTextField  finField = new JFormattedTextField(DateFormat.getTimeInstance());
	private JFormattedTextField  puissance_consommeeField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JButton b = new JButton("Créer la consommation");
	
	private ControlerInsertion cInsertion;
	public PanneauInsertionPlageHoraire(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
	}
	
	public void paintComponent(Graphics g){
		g.drawString("Ajouter une plage horaire de consommation", 0, 0);
		this.add(dateField);
		g.drawString("Heure de début", 0, 10);
		this.add(debutField);
		g.drawString("Heure de fin", 0, 30);
		this.add(finField);
		g.drawString("Consommation (kwh)", 0, 50);
		this.add(puissance_consommeeField);
		this.b.addActionListener(new BouttonListenerPlageHoraire());
		this.add(b);
		
		this.validate();
	}
	class BouttonListenerPlageHoraire implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(dateField.getValue() != null && debutField.getValue() != null && finField.getValue() != null && puissance_consommeeField.getValue() != null)
				cInsertion.insertPlageHoraire((Date) dateField.getValue(), (java.time.LocalTime)debutField.getValue(), (java.time.LocalTime)finField.getValue(), (float)puissance_consommeeField.getValue());
			else
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
		}
	}
}

