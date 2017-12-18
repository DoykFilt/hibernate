package tpfinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pays;
	private String ville;
	private String rue;
	private int numero;
	private String code_postal;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adresse")
	private List<Personne> personnes;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "adresse")
	private List<Compteur> compteurs;
	
	public Adresse(String pays, String ville, String rue, int numero, String code_postal) {
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
		this.code_postal = code_postal;
		this.personnes = new ArrayList<>();
		this.compteurs = new ArrayList<>();
	}
	public void addPersonne(Personne personne){
		this.personnes.add(personne);
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(ArrayList<Personne> personnes) {
		this.personnes.clear();
		this.personnes.addAll(personnes);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", pays=" + pays + ", ville=" + ville + ", rue=" + rue + ", numero=" + numero
				+ ", code_postal=" + code_postal + "]";
	}
	
}
