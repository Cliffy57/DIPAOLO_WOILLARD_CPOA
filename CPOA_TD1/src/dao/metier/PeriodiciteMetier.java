package dao.metier;

import java.util.Iterator;
import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;

public class PeriodiciteMetier {
	private int id;
	private String libelle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public PeriodiciteMetier(int id, String libelle) {
		this.setId(id);
		this.setLibelle(libelle);
	}

	public PeriodiciteMetier() {

	}
	

	@Override
	public boolean equals(Object o) {
		
		PeriodiciteMetier m = (PeriodiciteMetier) o;
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
		return "Periodicite [ID=" + id + ", libelle=" + libelle + "]";
	}



}