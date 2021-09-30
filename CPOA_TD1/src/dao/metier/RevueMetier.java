package dao.metier;

import java.util.Iterator;
import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;

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
	public String toString() {
		return "Client [id=" + id + ", titre=" + titre + ", description=" + description + ", tarif_numero="
				+ tarifNumero + ", visuel=" + visuel + ", id_periodicite=" + idPeriodicite + "]";
	}

	public static void revueLaunchSQL() {
		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.MYSQL);
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n");
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
			break;
		case 2:

			System.out.print("Saisissez la valeur de l'ID ï¿½ modifier\n");
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
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID ï¿½ supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getRevueDAO().delete(factory.getRevueDAO().getById(IDsuppr));
			break;

		case 4:
			Iterator<RevueMetier> iterator = factory.getRevueDAO().findAll().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			break;
		default:

			break;
		}

		scannerStr.close();
		scanner.close();
	}

	public static void revueListeMemoire() {
		DAOFactory factory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n");
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
			break;
		case 2:

			System.out.print("Saisissez la valeur de l'ID à modifier\n");
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
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			factory.getRevueDAO().delete(factory.getRevueDAO().getById(IDsuppr));
			break;

		case 4:
			Iterator<RevueMetier> iterator = factory.getRevueDAO().findAll().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			break;
		default:

			break;
		}

		scannerStr.close();
		scanner.close();
	}
}
