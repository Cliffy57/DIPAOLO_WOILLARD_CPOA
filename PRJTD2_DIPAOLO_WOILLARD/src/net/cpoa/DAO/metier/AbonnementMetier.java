package net.cpoa.DAO.metier;

import java.time.LocalDate;

public class AbonnementMetier {

	private int id;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int IDClient;
	private int IDRevue;
	
	public AbonnementMetier(int id, LocalDate dateDebut, LocalDate dateFin, int IDClient,int IDRevue) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.IDClient = IDClient;
		this.IDRevue =IDRevue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public int getIDClient() {
		return IDClient;
	}
	public void setIDClient(int iDClient) {
		IDClient = iDClient;
	}
	public int getIDRevue() {
		return IDRevue;
	}
	public void setIDRevue(int iDRevue) {
		IDRevue = iDRevue;
	}
	
	
}