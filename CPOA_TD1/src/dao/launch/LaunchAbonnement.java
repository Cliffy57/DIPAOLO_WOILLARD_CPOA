package dao.launch;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.AbonnementMetier;

public class LaunchAbonnement {

	public static void abonnementLaunchSQL() {

		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.MYSQL);
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n"
				+ "(4) Tout afficher\n" + "(5) Retour\n" + "(6) Choix SGBD\n" + "(7) Quitter\n");
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
			abonnementLaunchSQL();
			break;
		case 2:

			System.out.print("Saisissez la valeur de l'ID a modifier\n");
			int IDold = scanner.nextInt();
			System.out.print("Saisissez la valeur de la date de debut (sous la forme dd/MM/yyyy)\n");
			LocalDate dateDebutNew = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de la date de fin (sous la forme dd/MM/yyyy)\n");
			LocalDate dateFinNew = LocalDate.parse(scanner.next(), formatage);
			System.out.print("Saisissez la valeur de l'ID du Client\n");
			int IDclientNew = scanner.nextInt();
			System.out.print("Saisissez la valeur de l'ID de la revue\n");
			int IDrevueNew = scanner.nextInt();
			factory.getAbonnementDAO()
					.update(new AbonnementMetier(IDold, dateDebutNew, dateFinNew, IDclientNew, IDrevueNew));
			abonnementLaunchSQL();
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID a supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getAbonnementDAO().delete(factory.getAbonnementDAO().getById(IDsuppr));
			abonnementLaunchSQL();
			break;

		case 4:

			Iterator<AbonnementMetier> iterator = factory.getAbonnementDAO().findAll().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			abonnementLaunchSQL();
			break;
		case 5:
			LaunchMain.LaunchSQL();
			break;
		case 6:
			LaunchMain.ChoixSGBD();
			break;
		case 7:
			break;
		default:
			abonnementLaunchSQL();
			break;
		}

	}

	public static void abonnementLaunchListeMemoire() {

		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n"
				+ "(4) Tout afficher\n" + "(5) Retour\n" + "(6) Choix SGBD\n" + "(7) Quitter\n");
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
			abonnementLaunchListeMemoire();
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
			abonnementLaunchListeMemoire();
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID a supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getAbonnementDAO().delete(factory.getAbonnementDAO().getById(IDsuppr));
			abonnementLaunchListeMemoire();
			break;

		case 4:

			Iterator<AbonnementMetier> iterator = factory.getAbonnementDAO().findAll().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			abonnementLaunchListeMemoire();
			break;
		case 5:
			LaunchMain.LaunchListeMemoire();
			break;
		case 6:
			LaunchMain.ChoixSGBD();
			break;
		case 7:
			break;
		default:
			abonnementLaunchSQL();
			break;
		}
	}
}
