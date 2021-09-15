package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;



public class Client {
	
	public static void insertClient(int id,String nom,String prenom,int no_rue,String voie,int codepost,String ville,String pays) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `woillard2u_CPOA1`.`Client` (`id_client`, `nom`, `prenom`, `no_rue`, `voie`, `code_postal`, `ville`, `pays`) VALUES (?,?,?,?,?,?,?,?);");
			requete.setInt(1, id);
			requete.setString(2,nom);
			requete.setString(3, prenom);
			requete.setInt(4, no_rue);
			requete.setString(5, voie);
			requete.setInt(6, codepost);
			requete.setString(7, ville);
			requete.setString(8, pays);
			
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
	public static void modifieClient(int IDnew,String nom,String prenom,int no_rue,String voie,int codepost,String ville,String pays,int IDold) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `woillard2u_CPOA1`.`Client` SET `id_client` = ?, `nom` = ?, `prenom` = ?, `no_rue` = ?, `voie` = ?, `code_postal` = ?, `ville` = ?, `pays` = ? WHERE `Client`.`id_client` = ?;");
			requete.setInt(1,IDnew);
			requete.setString(2,nom);
			requete.setString(3, prenom);
			requete.setInt(4, no_rue);
			requete.setString(5, voie);
			requete.setInt(6, codepost);
			requete.setString(7, ville);
			requete.setString(8, pays);
			requete.setInt(9, IDold);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
	public static void deleteClient(Integer id) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Client where id_client=" + id);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
	public static void launch() {
		System.out.print("Voulez-vous :\n"
				+ "(1) Ajouter\n"
				+ "(2) Modifier\n"
				+ "(3) Supprimer\n");
		Scanner scanner = new Scanner(System.in);
		int res = scanner.nextInt();
		switch (res) {
		case 1:
				System.out.print("Saisissez la valeur de l'ID\n");
				int ID = scanner.nextInt();
				System.out.print("Saisissez la valeur du nom\n");
				String nom  = scanner.next();
				System.out.print("Saisissez la valeur du prenom\n");
				String prenom  = scanner.next();
				System.out.print("Saisissez la valeur du numéro de rue\n");
				int no_rue  = scanner.nextInt();
				System.out.print("Saisissez la valeur de la voie\n");
				String voie  = scanner.next();
				System.out.print("Saisissez la valeur du code postal\n");
				int codepost  = scanner.nextInt();
				System.out.print("Saisissez la valeur de la ville\n");
				String ville  = scanner.next();
				System.out.print("Saisissez la valeur du pays\n");
				String pays  = scanner.next();
				insertClient(ID, nom, prenom, no_rue, voie, codepost, ville, pays);
			break;
		case 2:
			
			System.out.print("Saisissez la valeur de l'ID à modifier\n");
			int IDold = scanner.nextInt();
			System.out.print("Saisissez la valeur du nouveau ID\n");
			int IDnew = scanner.nextInt();
			System.out.print("Saisissez la valeur du nom\n");
			String Newnom  = scanner.next();
			System.out.print("Saisissez la valeur du prenom\n");
			String Newprenom  = scanner.next();
			System.out.print("Saisissez la valeur du numéro de rue\n");
			int Newno_rue  = scanner.nextInt();
			System.out.print("Saisissez la valeur de la voie\n");
			String Newvoie  = scanner.next();
			System.out.print("Saisissez la valeur du code postal\n");
			int Newcodepost  = scanner.nextInt();
			System.out.print("Saisissez la valeur de la ville\n");
			String Newville  = scanner.next();
			System.out.print("Saisissez la valeur du pays\n");
			String Newpays  = scanner.next();
			modifieClient(IDnew, Newnom, Newprenom, Newno_rue, Newvoie, Newcodepost, Newville, Newpays, IDold);
			break;
		case 3:
			
			System.out.print("Saisissez la valeur de l'ID à supprimer\n");
			int IDsuppr = scanner.nextInt();
			deleteClient(IDsuppr);
			break;
			

		default:
			
			break;
		}
	
	
}
	
}