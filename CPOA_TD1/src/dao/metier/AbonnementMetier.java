package dao.metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;

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

	public AbonnementMetier() {

	}
	
	@Override
	public boolean equals(Object o) {
		
		AbonnementMetier m = (AbonnementMetier) o;
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

	public static void abonnementLaunchSQL() {

		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.MYSQL);
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n"+ "(4) Tout afficher");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			System.out.print("Saisissez la valeur de l'ID\n");
			int ID = scanner.nextInt();
			System.out.print("Saisissez la valeur de la date de dï¿½but (sous la forme dd/MM/yyyy)\n");
			LocalDate dateDebut = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de la date de fin (sous la forme dd/MM/yyyy)\n");
			LocalDate dateFin = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de l'ID du Client\n");
			int IDclient = scanner.nextInt();
			System.out.print("Saisissez la valeur de l'ID de la revue\n");
			int IDrevue = scanner.nextInt();
			factory.getAbonnementDAO().create(new AbonnementMetier(ID, dateDebut, dateFin, IDclient, IDrevue));
			break;
		case 2:

			System.out.print("Saisissez la valeur de l'ID ï¿½ modifier\n");
			int IDold = scanner.nextInt();
			System.out.print("Saisissez la valeur de la date de dï¿½but (sous la forme dd/MM/yyyy)\n");
			LocalDate dateDebutNew = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de la date de fin (sous la forme dd/MM/yyyy)\n");
			LocalDate dateFinNew = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de l'ID du Client\n");
			int IDclientNew = scanner.nextInt();
			System.out.print("Saisissez la valeur de l'ID de la revue\n");
			int IDrevueNew = scanner.nextInt();
			factory.getAbonnementDAO()
					.update(new AbonnementMetier(IDold, dateDebutNew, dateFinNew, IDclientNew, IDrevueNew));
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID ï¿½ supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getAbonnementDAO().delete(factory.getAbonnementDAO().getById(IDsuppr));
			break;

		case 4:

			Iterator<AbonnementMetier> iterator = factory.getAbonnementDAO().findAll().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			break;
		default:
			abonnementLaunchSQL();
			break;
		}
		

	}

	public static void abonnementLaunchListeMemoire() {

		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n"+ "(4) Tout afficher");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			System.out.print("Saisissez la valeur de l'ID\n");
			int ID = scanner.nextInt();
			System.out.print("Saisissez la valeur de la date de début (sous la forme dd/MM/yyyy)\n");
			LocalDate dateDebut = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de la date de fin (sous la forme dd/MM/yyyy)\n");
			LocalDate dateFin = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de l'ID du Client\n");
			int IDclient = scanner.nextInt();
			System.out.print("Saisissez la valeur de l'ID de la revue\n");
			int IDrevue = scanner.nextInt();
			factory.getAbonnementDAO().create(new AbonnementMetier(ID, dateDebut, dateFin, IDclient, IDrevue));
			break;
		case 2:

			System.out.print("Saisissez la valeur de l'ID de l'abonnement à modifier\n");	
			int IDold = scanner.nextInt();
			System.out.print("Saisissez la valeur de la date de début (sous la forme dd/MM/yyyy)\n");
			LocalDate dateDebutNew = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de la date de fin (sous la forme dd/MM/yyyy)\n");
			LocalDate dateFinNew = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de l'ID du Client\n");
			int IDclientNew = scanner.nextInt();
			System.out.print("Saisissez la valeur de l'ID de la revue\n");
			int IDrevueNew = scanner.nextInt();
			factory.getAbonnementDAO()
					.update(new AbonnementMetier(IDold, dateDebutNew, dateFinNew, IDclientNew, IDrevueNew));
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getAbonnementDAO().delete(factory.getAbonnementDAO().getById(IDsuppr));
			break;

		case 4:

			Iterator<AbonnementMetier> iterator = factory.getAbonnementDAO().findAll().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			break;
		default:
			abonnementLaunchSQL();
			break;
		}
	}

}