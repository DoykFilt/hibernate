package tpfinal.controler;

import tpfinal.view.*;

public class ControlerFenetre {
	
	ControlerInsertion cInsertion;
	FenetreInsertion fenetreInsertion = new FenetreInsertion();
	FenetreMenu fenetreMenu = new FenetreMenu();
	PanneauMenu panneauMenu = new PanneauMenu(this);
	PanneauInsertionPlageHoraire panneauInsertionPlageHoraire;
	PanneauInsertionsAdresse panneauInsertionsAdresse;
	PanneauInsertionsCompteur panneauInsertionsCompteur;
	PanneauInsertionsPersonne panneauInsertionsPersonne;
	PanneauInsertionTarif panneauInsertionTarif;
	PanneauRelationCompteurPlageHoraire panneauRelationCompteurPlageHoraire;
	PanneauRelationTarifPlage panneauRelationtarifPlage;
	
	public ControlerFenetre(ControlerInsertion cInsertion){
		this.fenetreMenu.setContentPane(panneauMenu);
		fenetreInsertion.setVisible(false);
		this.cInsertion = cInsertion;

		panneauInsertionPlageHoraire = new PanneauInsertionPlageHoraire(this.cInsertion);
		panneauInsertionsAdresse = new PanneauInsertionsAdresse(this.cInsertion);
		panneauInsertionsCompteur = new PanneauInsertionsCompteur(this.cInsertion);
		panneauInsertionsPersonne = new PanneauInsertionsPersonne(this.cInsertion);
		panneauInsertionTarif = new PanneauInsertionTarif(this.cInsertion);
		panneauRelationCompteurPlageHoraire = new PanneauRelationCompteurPlageHoraire(this.cInsertion);
		panneauRelationtarifPlage = new PanneauRelationTarifPlage(this.cInsertion);
	}
	
	public void openFenetre(int type){
		switch(type){
		case PanneauMenu.BADRESSE:
			this.fenetreInsertion.setContentPane(panneauInsertionsAdresse);
			break;
		case PanneauMenu.BASSOCIATIONPLAGECOMPTEUR:
			this.fenetreInsertion.setContentPane(panneauRelationCompteurPlageHoraire);
			break;
		case PanneauMenu.BASSOCIATIONPLAGETARIF:
			this.fenetreInsertion.setContentPane(panneauRelationtarifPlage);
			break;
		case PanneauMenu.BCOMPTEUR:
			this.fenetreInsertion.setContentPane(panneauInsertionsCompteur);
			break;
		case PanneauMenu.BPERSONNE:
			this.fenetreInsertion.setContentPane(panneauInsertionsPersonne);
			break;
		case PanneauMenu.BPLAGEHORAIRE:
			this.fenetreInsertion.setContentPane(panneauInsertionPlageHoraire);
			break;
		case PanneauMenu.BTARIF:
			this.fenetreInsertion.setContentPane(panneauInsertionTarif);
			break;
		}
		fenetreInsertion.setVisible(true);
	}
}
