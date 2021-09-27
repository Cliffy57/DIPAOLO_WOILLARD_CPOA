package dao.metier;

import java.time.LocalDate;

public class AbonnementMetier {

	private int id;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int idClient;
	private int idRevue;

	public AbonnementMetier(int id, LocalDate dateDebut, LocalDate dateFin, int IDClient, int IDRevue) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idClient = IDClient;
		this.idRevue = IDRevue;
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

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int iDClient) {
		idClient = iDClient;
	}

	public int getIdRevue() {
		return idRevue;
	}

	public void setIdRevue(int iDRevue) {
		idRevue = iDRevue;
	}

	@Override
	public String toString() {
		return "AbonnementMetier [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", IDClient="
				+ idClient + ", IDRevue=" + idRevue + "]";
	}

}