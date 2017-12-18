package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tpfinal.controler.ControlerInsertion;
import tpfinal.model.Adresse;

public class PanneauInsertionsPersonne extends JPanel{
	private JTextField telField = new JTextField("Numero de téléphone");
	private JTextField secuField = new JTextField("Numéro de sécurité social");
	private JComboBox combo = new JComboBox();
	private JButton b = new JButton("Créer la personne");

	private ControlerInsertion cInsertion;
	public PanneauInsertionsPersonne(ControlerInsertion cInsertion){
		this.cInsertion = cInsertion;
		for(Adresse adresse : cInsertion.getAdresses())
			combo.addItem(adresse.getId());
	}
	public void paintComponent(Graphics g){
		g.drawString("Ajouter une personne", 0, 0);
		this.add(telField);
		this.add(secuField);
		this.add(combo);
		this.b.addActionListener(new BoutonListenerPersonne());
		this.add(b);
		
		this.validate();
	}
	
  class BoutonListenerPersonne implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if(telField.getText() != null && secuField.getText() != null && combo.getSelectedItem() != null)
			cInsertion.insertPersonne(telField.getText(), secuField.getText(), (int)combo.getSelectedItem());
		else
			JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champs du formulaire");
	}
  }
}

