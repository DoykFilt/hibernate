package tpfinal.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
public class PlageHoraire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
    private java.time.LocalTime heure_debut;
    private java.time.LocalTime heure_fin;
    private float puissance_consommee;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="ASSOCIE", 
    	joinColumns={@JoinColumn(name="PLAGE_ID",referencedColumnName="id")},
    	inverseJoinColumns={@JoinColumn(name="COMPTEUR_NUMERO", referencedColumnName="numero")})
    private List<Compteur> compteurs;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="INCLUS", 
    	joinColumns={@JoinColumn(name="PLAGE_ID",referencedColumnName="id")},
    	inverseJoinColumns={@JoinColumn(name="TARIF_CODE", referencedColumnName="code")})
    private List<Tarif> tarifs;
    
	public PlageHoraire(Date date, java.time.LocalTime heure_debut, java.time.LocalTime heure_fin, float puissance_consommee) {
		this.date = date;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
		this.puissance_consommee = puissance_consommee;
		this.compteurs = new ArrayList<>();
		this.tarifs = new ArrayList<>();
	}
	public void setTarifs(List<Tarif> tarifs){
		this.tarifs.clear();
		this.tarifs.addAll(tarifs);
	}
	public List<Tarif> getTarifs(){
		return this.tarifs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate(){
		return date;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public java.time.LocalTime getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(java.time.LocalTime heure_debut) {
		this.heure_debut = heure_debut;
	}
	public java.time.LocalTime getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(java.time.LocalTime heure_fin) {
		this.heure_fin = heure_fin;
	}
	public float getPuissance_consommee() {
		return puissance_consommee;
	}
	public void setPuissance_consommee(float puissance_consommee) {
		this.puissance_consommee = puissance_consommee;
	}
	
	@Override
	public String toString() {
		return "PlageHoraire [id=" + id + ", heure_debut=" + heure_debut + ", heure_fin=" + heure_fin
				+ ", puissance_consommee=" + puissance_consommee + "]";
	}
}
