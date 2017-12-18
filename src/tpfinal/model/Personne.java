package tpfinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Personne {
	@Id
	private String numero_securite_social;
	private String numero_telephone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
	private List<Compteur> compteurs;
	@ManyToOne
	private Adresse adresse;
	
	public Personne(String numero_securite_social, String numero_telephone, Adresse adresse) {
		this.numero_securite_social = numero_securite_social;
		this.numero_telephone = numero_telephone;
		this.compteurs = new ArrayList<>();
		this.adresse = adresse;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getNumero_securite_social() {
		return numero_securite_social;
	}
	
	public void addCompteur(Compteur compteur){
		this.compteurs.add(compteur);
	}	
	public List<Compteur> getCompteurs() {
		return compteurs;
	}
	public void setCompteurs(ArrayList<Compteur> compteurs) {
		this.compteurs.clear();
		this.compteurs.addAll(compteurs);
	}
	public void setNumero_securite_social(String numero_securite_social) {
		this.numero_securite_social = numero_securite_social;
	}
	public String getNumero_telephone() {
		return numero_telephone;
	}
	public void setNumero_telephone(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}
	@Override
	public String toString() {
		return "Personne [numero_securite_social=" + numero_securite_social + ", numero_telephone=" + numero_telephone
				+ "]";
	}
}
