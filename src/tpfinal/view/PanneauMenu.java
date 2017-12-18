package tpfinal.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import tpfinal.controler.ControlerFenetre;

public class PanneauMenu extends JPanel{
	
	private ControlerFenetre cFenetre;
	
	public static final int BADRESSE = 1;
	public static final int BPERSONNE = 2;
	public static final int BCOMPTEUR = 3;
	public static final int BTARIF = 4;
	public static final int BPLAGEHORAIRE = 5;
	public static final int BASSOCIATIONPLAGETARIF = 6;
	public static final int BASSOCIATIONPLAGECOMPTEUR = 7;

	private JButton bAdresse = new JButton("Inserer une adresse");
	private JButton bPersonne = new JButton("Inserer une personne");
	private JButton bCompteur = new JButton("Inserer un compteur");
	private JButton bTarif = new JButton("Inserer un tarif");
	private JButton bPlageHoraire = new JButton("Inserer une consommation");
	private JButton bAssociationPlageTarif = new JButton("Associer une plage horaire à un tarif");
	private JButton bAssociationPlageCompteur = new JButton("Associer une plage horaire à un compteur");
	
	public PanneauMenu(ControlerFenetre cFenetre){
		this.cFenetre = cFenetre;
	}
	
	public void paintComponent(Graphics g){
		bAdresse.addActionListener(new BouttonListenerMenu(this.BADRESSE));
		this.add(bAdresse);
		bPersonne.addActionListener(new BouttonListenerMenu(this.BPERSONNE));
		this.add(bPersonne);
		bCompteur.addActionListener(new BouttonListenerMenu(this.BCOMPTEUR));
		this.add(bCompteur);
		bTarif.addActionListener(new BouttonListenerMenu(this.BTARIF));
		this.add(bTarif);
		bPlageHoraire.addActionListener(new BouttonListenerMenu(this.BPLAGEHORAIRE));
		this.add(bPlageHoraire);
		bAssociationPlageTarif.addActionListener(new BouttonListenerMenu(this.BASSOCIATIONPLAGETARIF));
		this.add(bAssociationPlageTarif);
		bAssociationPlageCompteur.addActionListener(new BouttonListenerMenu(this.BASSOCIATIONPLAGECOMPTEUR));
		this.add(bAssociationPlageCompteur);
		
		this.validate();
	}
	
class BouttonListenerMenu implements ActionListener{
	private int button;
	public BouttonListenerMenu(int button){
		this.button = button;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cFenetre.openFenetre(button);
	}
}
}

