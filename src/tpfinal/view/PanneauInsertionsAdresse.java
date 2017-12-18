package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tpfinal.controler.ControlerInsertion;

public class PanneauInsertionsAdresse extends JPanel{
	private JTextField paysField = new JTextField("Pays");
	private JTextField villeField = new JTextField("Ville");
	private JTextField rueField = new JTextField("Rue");
	private JTextField codePField = new JTextField("CodePostal");
	private JFormattedTextField  numeroField = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JButton b = new JButton("Créer l'adresse");

	private ControlerInsertion cInsertion;
	public PanneauInsertionsAdresse(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
	}
	
	public void paintComponent(Graphics g){
		g.drawString("Ajouter une adresse", 0, 0);
		this.add(paysField);
		this.add(villeField);
		numeroField.setSize(20, 20);
		this.add(numeroField);
		this.add(rueField);
		this.add(codePField);
		this.b.addActionListener(new BoutonListenerAdresse());
		this.add(b);
		
		this.validate();
	}
	  class BoutonListenerAdresse implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(paysField.getText() != null && villeField.getText() != null && rueField.getText() != null
					&& codePField.getText() != null && numeroField.getValue() != null)
				cInsertion.insertAdresse(paysField.getText(),villeField.getText(),rueField.getText(),codePField.getText(),((Long)numeroField.getValue()).intValue());
			else
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
		}
	  }
	
}

