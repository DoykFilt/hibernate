package tpfinal.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Tarif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
    private java.time.LocalTime heure_debut;
    private java.time.LocalTime heure_fin;
    private float prix_kwh;
    private float reduction;
	@ManyToMany(mappedBy = "tarifs")
	private List<PlageHoraire> plagesHoraires;
	
	
	public Tarif(java.time.LocalTime heure_debut, java.time.LocalTime heure_fin, float prix_kwh, float reduction) {
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
		this.prix_kwh = prix_kwh;
		this.reduction = reduction;
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
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	public float getPrix_kwh() {
		return prix_kwh;
	}
	public void setPrix_kwh(float prix_kwh) {
		this.prix_kwh = prix_kwh;
	}
	public float getReduction() {
		return reduction;
	}
	public void setReduction(float reduction) {
		this.reduction = reduction;
	}
	@Override
	public String toString() {
		return "Tarif [code=" + code + ", heure_debut=" + heure_debut + ", heure_fin=" + heure_fin + ", prix_kwh="
				+ prix_kwh + ", reduction=" + reduction + "]";
	}
}
