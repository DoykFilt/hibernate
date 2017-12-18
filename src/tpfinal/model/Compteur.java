package tpfinal.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
    @Temporal(TemporalType.DATE)
    private java.util.Date date_activation;
	@ManyToOne
	private Personne personne;
	@ManyToOne
	private Adresse adresse;
	@ManyToMany(mappedBy = "compteurs")
	private List<PlageHoraire> plagesHoraires;
    
	public Compteur(Date date_activation, Adresse adresse, Personne personne) {
		this.date_activation = date_activation;
		this.personne = personne;
		this.adresse = adresse;
		this.plagesHoraires = new ArrayList<>();
	}
	public List<PlageHoraire> getPlagesHoraires(){
		return this.plagesHoraires;
	}
	public void addPlageHoraire(PlageHoraire plagehoraire){
		this.plagesHoraires.add(plagehoraire);
	}
	public void setPlagesHoraires(ArrayList<PlageHoraire> plagesHoraires){
		this.plagesHoraires.clear();
		this.plagesHoraires.addAll(plagesHoraires);
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public java.util.Date getDate_activation() {
		return date_activation;
	}
	public void setDate_activation(java.util.Date date_activation) {
		this.date_activation = date_activation;
	}
	@Override
	public String toString() {
		return "Compteur [numero=" + numero + ", date_activation=" + date_activation + "]";
	}
    
    
}
