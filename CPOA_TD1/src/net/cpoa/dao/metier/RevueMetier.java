package net.cpoa.dao.metier;

public class RevueMetier {
	
	private int id;
	private String titre;
	private String description;
	private float tarif_numero;
	private String visuel;
	private int id_periodicite;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getTarif_numero() {
		return tarif_numero;
	}
	public void setTarif_numero(float tarif_numero) {
		this.tarif_numero = tarif_numero;
	}
	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	public int getId_periodicite() {
		return id_periodicite;
	}
	public void setId_periodicite(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}
	public RevueMetier(int id , String description, String titre , int tarif_numero,String visuel,int id_periodicite) {
		this.id=id;
		this.description=description;
		this.titre=titre;
		this.visuel=visuel;
		this.tarif_numero=tarif_numero;
		this.id_periodicite=id_periodicite;
	}
	@Override 
	public String toString() {
		return "Client [id=" + id + ", titre=" + titre + ", description=" + description + ", tarif_numero=" + tarif_numero + ", visuel=" + visuel
				+ ", id_periodicite=" + id_periodicite +"]";
	}
	
	
}
