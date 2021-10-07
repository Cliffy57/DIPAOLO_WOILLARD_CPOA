package dao.launch;

import java.util.Iterator;
import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.RevueMetier;

public class LaunchRevue {

	public static void revueLaunchSQL() {
		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.MYSQL);
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n"
				+ "(4) Tout afficher\n" + "(5) Retour\n" + "(6) Choix SGBD\n" + "(7) Quitter\n");
		Scanner scannerStr = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			System.out.print("Saisissez la valeur de l'ID\n");
			int ID = scanner.nextInt();
			System.out.print("Saisissez la valeur du titre\n");
			String titre = scannerStr.next();
			System.out.print("Saisissez la valeur de la description\n");
			String description = scannerStr.next();
			System.out.print("Saisissez la valeur du tarif\n");
			float tarif_numero = scanner.nextFloat();
			System.out.print("Saisissez la valeur du visuel\n");
			String visuel = scannerStr.next();
			System.out.print("Saisissez la valeur de l'ID_Periodicite\n");
			int IDPeriodicite = scanner.nextInt();
			factory.getRevueDAO().create(new RevueMetier(ID, description, titre, tarif_numero, visuel, IDPeriodicite));
			revueLaunchSQL();
			break;
		case 2:

			System.out.print("Saisissez la valeur de l'ID a modifier\n");
			int IDnew = scanner.nextInt();
			System.out.print("Saisissez la valeur du titre\n");
			String Newtitre = scannerStr.next();
			System.out.print("Saisissez la valeur de la description\n");
			String Newdescription = scannerStr.next();
			System.out.print("Saisissez la valeur du tarif\n");
			float Newtarif_numero = scanner.nextFloat();
			System.out.print("Saisissez la valeur du visuel\n");
			String Newvisuel = scannerStr.next();
			System.out.print("Saisissez la valeur de l'ID_Periodicite\n");
			int NewIDPeriodicite = scanner.nextInt();
			factory.getRevueDAO().update(
					new RevueMetier(IDnew, Newdescription, Newtitre, Newtarif_numero, Newvisuel, NewIDPeriodicite));
			revueLaunchSQL();
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID a supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getRevueDAO().delete(factory.getRevueDAO().getById(IDsuppr));
			revueLaunchSQL();
			break;

		case 4:
			Iterator<RevueMetier> iterator = factory.getRevueDAO().findAll().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			revueLaunchSQL();
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
			revueLaunchSQL();
			break;
		}

	}

	public static void revueListeMemoire() {
		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n"
				+ "(4) Tout afficher\n" + "(5) Retour\n" + "(6) Choix SGBD\n" + "(7) Quitter\n");
		Scanner scannerStr = new Scanner(System.in).useDelimiter("\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			System.out.print("Saisissez la valeur de l'ID\n");
			int ID = scanner.nextInt();
			System.out.print("Saisissez la valeur du titre\n");
			String titre = scannerStr.next();
			System.out.print("Saisissez la valeur de la description\n");
			String description = scannerStr.next();
			System.out.print("Saisissez la valeur du tarif\n");
			float tarif_numero = scanner.nextFloat();
			System.out.print("Saisissez la valeur du visuel\n");
			String visuel = scannerStr.next();
			System.out.print("Saisissez la valeur de l'ID_Periodicite\n");
			int IDPeriodicite = scanner.nextInt();
			factory.getRevueDAO().create(new RevueMetier(ID, description, titre, tarif_numero, visuel, IDPeriodicite));
			revueListeMemoire();
			break;
		case 2:

			System.out.print("Saisissez la valeur de l'ID a modifier\n");
			int IDnew = scanner.nextInt();
			System.out.print("Saisissez la valeur du titre\n");
			String Newtitre = scannerStr.next();
			System.out.print("Saisissez la valeur de la description\n");
			String Newdescription = scannerStr.next();
			System.out.print("Saisissez la valeur du tarif\n");
			float Newtarif_numero = scanner.nextFloat();
			System.out.print("Saisissez la valeur du visuel\n");
			String Newvisuel = scannerStr.next();
			System.out.print("Saisissez la valeur de l'ID_Periodicite\n");
			int NewIDPeriodicite = scanner.nextInt();
			factory.getRevueDAO().update(
					new RevueMetier(IDnew, Newdescription, Newtitre, Newtarif_numero, Newvisuel, NewIDPeriodicite));
			revueListeMemoire();
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID a supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getRevueDAO().delete(factory.getRevueDAO().getById(IDsuppr));
			revueListeMemoire();
			break;

		case 4:
			Iterator<RevueMetier> iterator = factory.getRevueDAO().findAll().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			revueListeMemoire();
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
			revueListeMemoire();
			break;
		}

	}
}
