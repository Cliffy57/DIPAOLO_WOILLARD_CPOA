
package net.cpoa.metier;

public class Periodicite 
{
	private int ID;
	private String libelle;
	
	public Periodicite(int id, String libelle)
	{
		this.setID(id);
		this.setLibelle(libelle);
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Periodicite [ID=" + ID + ", libelle=" + libelle + "]";
	}
	
	
	
}

