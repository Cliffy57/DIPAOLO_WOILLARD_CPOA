package dao.metier;


public class RevueMetier {

	private int id;
	private String titre;
	private String description;
	private float tarifNumero;
	private String visuel;
	private int idPeriodicite;

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

	public float getTarifNumero() {
		return tarifNumero;
	}

	public void setTarifNumero(float tarifNumero) {
		this.tarifNumero = tarifNumero;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	public int getIdPeriodicite() {
		return idPeriodicite;
	}

	public void setIdPeriodicite(int idPeriodicite) {
		this.idPeriodicite = idPeriodicite;
	}

	public RevueMetier(int id, String description, String titre, float tarifNumero, String visuel, int idPeriodicite) {
		this.id = id;
		this.description = description;
		this.titre = titre;
		this.visuel = visuel;
		this.tarifNumero = tarifNumero;
		this.idPeriodicite = idPeriodicite;
	}

	public RevueMetier() {

	}

	@Override
	public boolean equals(Object o) {
		
		RevueMetier m = (RevueMetier) o;
		if(o == null) {
			return false;
		}
		if(this.getClass()==m.getClass()) {
			if(m.getId() == this.getId()) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Revue [id=" + id + ", titre=" + titre + ", description=" + description + ", tarif_numero="
				+ tarifNumero + ", visuel=" + visuel + ", id_periodicite=" + idPeriodicite + "]";
	}

	
}
