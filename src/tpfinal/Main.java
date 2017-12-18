package tpfinal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tpfinal.controler.ControlerFenetre;
import tpfinal.controler.ControlerInsertion;

public class Main {

	public static void main(String[] args) {
		
		ControlerInsertion cInsertion = new ControlerInsertion();
		ControlerFenetre cFenetre = new ControlerFenetre(cInsertion);
	}

}
