package connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Revue {

	public static void insertRevue(int id, String titre, String description, float tarif_numero, String visuel,
			int id_periodicite) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"INSERT INTO `dipaolo6u_cpoatdun`.`Revue` (`id_revue`, `titre`, `description`, `tarif_numero`, `visuel`, `id_periodicite`) VALUES (?, ?, ?, ?, ? , ?);");
			requete.setInt(1, id);
			requete.setString(2, titre);
			requete.setString(3, description);
			requete.setFloat(4, tarif_numero);
			requete.setString(5, visuel);
			requete.setInt(6, id_periodicite);

			int res = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

	public static void modifieRevue(int IDnew, String titre, String description, float tarif_numero, String visuel,
			int id_periodicite, int IDold) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"UPDATE `dipaolo6u_cpoatdun`.`Revue` SET `id_revue` = ?, `titre` = ? WHERE `Revue`.`id_revue` = ?;");
			requete.setInt(1, IDnew);
			requete.setString(2, titre);
			requete.setString(3, description);
			requete.setFloat(4, tarif_numero);
			requete.setString(5, visuel);
			requete.setInt(6, id_periodicite);
			requete.setInt(9, IDold);
			int res = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

	public static void deleteRevue(int id) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Revue where id_id_revue=" + id);
			int res = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

	public static void launch() {
		System.out.print("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
			System.out.print("Saisissez la valeur de l'ID\n");
			int ID = scanner.nextInt();
			System.out.print("Saisissez la valeur du titre\n");
			String titre = scanner.next();
			System.out.print("Saisissez la valeur de la description\n");
			String description = scanner.next();
			System.out.print("Saisissez la valeur du tarif\n");
			float tarif_numero = scanner.nextFloat();
			System.out.print("Saisissez la valeur du visuel\n");
			String visuel = scanner.next();
			System.out.print("Saisissez la valeur de l'ID_Periodicite\n");
			int IDPeriodicite = scanner.nextInt();

			insertRevue(ID, titre, description, tarif_numero, visuel, IDPeriodicite);
			break;
		case 2:

			System.out.print("Saisissez la valeur de l'ID à modifier\n");
			int IDold = scanner.nextInt();
			System.out.print("Saisissez la valeur du nouveau ID\n");
			int IDnew = scanner.nextInt();
			System.out.print("Saisissez la valeur du titre\n");
			String Newtitre = scanner.next();
			System.out.print("Saisissez la valeur de la description\n");
			String Newdescription = scanner.next();
			System.out.print("Saisissez la valeur du tarif\n");
			float Newtarif_numero = scanner.nextFloat();
			System.out.print("Saisissez la valeur du visuel\n");
			String Newvisuel = scanner.next();
			System.out.print("Saisissez la valeur de l'ID_Periodicite\n");
			int NewIDPeriodicite = scanner.nextInt();
			modifieRevue(IDnew, Newtitre, Newdescription, Newtarif_numero, Newvisuel, NewIDPeriodicite, IDold);
			break;
		case 3:

			System.out.print("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			deleteRevue(IDsuppr);
			break;

		default:

			break;
		}
		scanner.close();

	}
}
