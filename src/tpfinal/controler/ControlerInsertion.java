package tpfinal.controler;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tpfinal.model.*;

public class ControlerInsertion {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ControlerInsertion(){
		emf = Persistence.createEntityManagerFactory("persistence");
		em = emf.createEntityManager();
		this.em.getTransaction().begin();
	}
	
	public void insertAdresse(String pays, String ville, String rue, String cp, int numero){
		Adresse adresse = new Adresse(pays, ville, rue, numero, cp);
		em.persist(adresse);
		em.getTransaction().commit();
	}
	public void insertPersonne(String tel, String secu, int idAdresse){
		Adresse adresse = getAdresse(idAdresse);
		Personne personne = new Personne(secu, tel, adresse);
		em.persist(personne);
		em.getTransaction().commit();
	}
	public void insertCompteur(Date date, int idAdresse, String secuPersonne){
		Adresse adresse = getAdresse(idAdresse);
		Personne personne = getPersonne(secuPersonne);
		Compteur compteur = new Compteur(date, adresse, personne);
		em.persist(compteur);
		em.getTransaction().commit();
	}
	public void insertTarif(java.time.LocalTime debut, java.time.LocalTime fin, float prix, float reduction){
		Tarif tarif = new Tarif(debut, fin, prix, reduction);
		em.persist(tarif);
		em.getTransaction().commit();
	}
	public void insertPlageHoraire(Date date, java.time.LocalTime debut, java.time.LocalTime fin, float puissance){
		PlageHoraire plage = new PlageHoraire(date, debut, fin, puissance);
		em.persist(plage);
		em.getTransaction().commit();
	}
	public void insertRelationTarifPlageHoraire(int tarifCode, int plageId){
		Tarif tarif= getTarif(tarifCode);
		PlageHoraire plage = getPlageHoraire(plageId);
	}
	public void insertRelationCompteurPlageHoraire(int numeroCompteur, int idPlage){
		
	}
	
	public List<Personne> getPersonnes(){
		String queryString = "SELECT numero_securite_social, numero_telephone, adresse_id From Person";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		List<Personne> personnes = new ArrayList<>();
		for(int i =0; i < results.size(); i++){
			Object[] actualResult = (Object[])results.get(i);
			Personne personne = new Personne((String)actualResult[0], (String)actualResult[1], (Adresse)actualResult[2]);
			personnes.add(personne);
		}
		return personnes;
	}
	public List<Adresse> getAdresses(){
		String queryString = "SELECT id, pays, ville, rue, numero, code_postal From Adresse;";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		List<Adresse> adresses = new ArrayList<>();
		for(int i =0; i < results.size(); i++){
			Object[] actualResult = (Object[])results.get(i);
			Adresse adresse = new Adresse((String)actualResult[1], (String)actualResult[2], (String)actualResult[3],
					(int)actualResult[4], (String)actualResult[5]);
			adresse.setId((int)actualResult[0]);
			adresses.add(adresse);
		}
		return adresses;
	}
	public Adresse getAdresse(int id){
		String queryString = "SELECT id, pays, ville, rue, numero, code_postal From Adresse WHERE id = " + id + ";";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		Object[] actualResult = (Object[])results.get(0);
		Adresse adresse = new Adresse((String)actualResult[1], (String)actualResult[2], (String)actualResult[3],
				(int)actualResult[4], (String)actualResult[5]);
		adresse.setId((int)actualResult[0]);
			
		return adresse;
	}
	public Personne getPersonne(String secu){
		String queryString = "SELECT numero_securite_social, numero_telephone, adresse_id From Person WHERE numero_securite_social = " + secu + ";";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		Object[] actualResult = (Object[])results.get(0);
		Personne personne = new Personne((String)actualResult[0], (String)actualResult[1], getAdresse((int)actualResult[2]));
		
		return personne;
	}
	public Tarif getTarif(int code){
		String queryString = "SELECT code, heure_debut, heure_fin, prix_kwh, reduction From Tarif WHERE code = " + code + ";";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		Object[] actualResult = (Object[])results.get(0);
		Tarif tarif = new Tarif((java.time.LocalTime)actualResult[1], (java.time.LocalTime)actualResult[2], (float)actualResult[3],
				(float)actualResult[5]);
		tarif.setCode((int)actualResult[0]);
		return tarif;
	}
	public List<Tarif> getTarifs(){
		String queryString = "SELECT code, heure_debut, heure_fin, prix_kwh, reduction From Tarif;";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		List<Tarif> tarifs = new ArrayList<>();
		for(int i =0; i < results.size(); i++){
			Object[] actualResult = (Object[])results.get(i);
			Tarif tarif = new Tarif((java.time.LocalTime)actualResult[1], (java.time.LocalTime)actualResult[2], (float)actualResult[3],
					(float)actualResult[5]);
			tarif.setCode((int)actualResult[0]);
			tarifs.add(tarif);
		}
		return tarifs;
	}
	public List<PlageHoraire> getPlagesHoraires(){
		String queryString = "SELECT id, heure_debut, heure_fin, puissance_consommee, date From PlageHoraire;";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		List<PlageHoraire> plages = new ArrayList<>();
		for(int i =0; i < results.size(); i++){
			Object[] actualResult = (Object[])results.get(i);
			PlageHoraire plage = new PlageHoraire((Date)actualResult[4], (java.time.LocalTime)actualResult[1], (java.time.LocalTime)actualResult[2], (float)actualResult[3]);
			plage.setId((int)actualResult[0]);
			plages.add(plage);
		}
		return plages;
	}
	public PlageHoraire getPlageHoraire(int id){
		String queryString = "SELECT id, heure_debut, heure_fin, puissance_consommee, date From PlageHoraire WHERE ID = " + id +";";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		Object[] actualResult = (Object[])results.get(0);
		PlageHoraire plage = new PlageHoraire((Date)actualResult[4], (java.time.LocalTime)actualResult[1], (java.time.LocalTime)actualResult[2], (float)actualResult[3]);
		plage.setId((int)actualResult[0]);
			
		return plage;
	}
	public List<Compteur> getCompteurs(){
		String queryString = "SELECT numero, date_activation, adresse_id, personne_numero_securite_social From Compteur;";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		List<Compteur> compteurs = new ArrayList<>();
		for(int i =0; i < results.size(); i++){
			Object[] actualResult = (Object[])results.get(i);
			Compteur compteur = new Compteur((Date)actualResult[1], getAdresse((int)actualResult[2]), getPersonne((String)actualResult[3]));
			compteur.setNumero((int)actualResult[0]);
			compteurs.add(compteur);
		}
		return compteurs;
	}
	public Compteur getCompteur(int numero){
		String queryString = "SELECT numero, date_activation, adresse_id, personne_numero_securite_social From Compteur WHERE numero = " + numero +";";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		Object[] actualResult = (Object[])results.get(0);
		Compteur compteur = new Compteur((Date)actualResult[1], getAdresse((int)actualResult[2]), getPersonne((String)actualResult[3]));
		compteur.setNumero((int)actualResult[0]);
		
		return compteur;
	}
	public List<Tarif> getTarifsCreux(){
		String queryString = "SELECT code, heure_debut, heure_fin, prix_kwh, reduction From Tarif WHERE reduction <> NULL";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		List<Tarif> tarifs = new ArrayList<>();
		for(int i =0; i < results.size(); i++){
			Object[] actualResult = (Object[])results.get(i);
			Tarif tarif = new Tarif((java.time.LocalTime)actualResult[1], (java.time.LocalTime)actualResult[2], (float)actualResult[3],
					(float)actualResult[5]);
			tarif.setCode((int)actualResult[0]);
			tarifs.add(tarif);
		}
		return tarifs;
	}
	
	public int countPlages(int tarifCode){
		String queryString = "SELECT * From inclus WHERE Tarif_Code = " + tarifCode + " GROUP BY Plage_Id;";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		return results.size();
	}
	
	public float calculerCoutTotal(Date date, int numeroCompteur){
		//Selection du compteur
		Compteur compteur = getCompteur(numeroCompteur);
		if(compteur.getDate_activation().before(date))
			return 0.0f;
		
		//Selection des plages horaires concernées
		String queryString = "SELECT id, heure_debut, heure_fin, puissance_consommee, date From PlageHoraire WHERE date LIKE " + new SimpleDateFormat("yyyy-MM-dd").format(date) + ";";
		Query query = em.createQuery(queryString);
		List results = query.getResultList();
		
		List<PlageHoraire> plages = new ArrayList<>();
		for(int i =0; i < results.size(); i++){
			Object[] actualResult = (Object[])results.get(i);
			PlageHoraire plage = new PlageHoraire((Date)actualResult[4], (java.time.LocalTime)actualResult[1], (java.time.LocalTime)actualResult[2], (float)actualResult[3]);
			plage.setId((int)actualResult[0]);
			plages.add(plage);
		}

		//Selection des tarifs associés
		List<Tarif> tarifs = new ArrayList<>();
		for(int j=0; j < plages.size(); j++){
			queryString = "SELECT code, heure_debut, heure_fin, prix_kwh, reduction From Tarif WHERE code IN (SELECT tarif_code FROM inclus WHERE plage_id = " + plages.get(j).getId() + ");";
			query = em.createQuery(queryString);
			results = query.getResultList();
			
			for(int i =0; i < results.size(); i++){
				Object[] actualResult = (Object[])results.get(i);
				Tarif tarif = new Tarif((java.time.LocalTime)actualResult[1], (java.time.LocalTime)actualResult[2], (float)actualResult[3],
						(float)actualResult[5]);
				tarif.setCode((int)actualResult[0]);
				if(!tarifs.contains(tarif))
					tarifs.add(tarif);
			}
		}
	}
}
