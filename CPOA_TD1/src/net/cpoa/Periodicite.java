package net.cpoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;



public class Periodicite {
	
		public static class AjouterPeriodicite {
			
			public static void insertPeriodicite(int ID,String libelle) {
				try {
					Connection laConnexion = Connexion.creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Periodicite` (`id_periodicite`, `libelle`) VALUES (?, ?);");
					requete.setInt(1, ID);
					requete.setString(2, libelle);
					int res = requete.executeUpdate();
					
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
			}
	
		}
		public static class SupprimerPeriodicite {
			
			public static void deletePeriodicite(int ID) {
				try {
					Connection laConnexion = Connexion.creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=" + ID);
					int res = requete.executeUpdate();
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
			}

		}
		public static class ModifierPeriodicite {
			
			public static void modifiePeriodicite(int IDnew,String libelle,int IDold) {
				try {
					Connection laConnexion = Connexion.creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Periodicite` SET `id_periodicite` = ?, `libelle` = ? WHERE `Periodicite`.`id_periodicite` = ?;");
					requete.setInt(1,IDnew);
					requete.setString(2, libelle);
					requete.setInt(3, IDold);
					int res = requete.executeUpdate();
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
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
					System.out.print("Saisissez la valeur du libellé\n");
					String label= scanner.next();
					AjouterPeriodicite.insertPeriodicite(ID, label);
				break;
			case 2:
				
				System.out.print("Saisissez la valeur de l'ID à modifier\n");
				int IDold = scanner.nextInt();
				System.out.print("Saisissez la valeur du nouveau ID\n");
				int IDnew = scanner.nextInt();
				System.out.print("Saisissez la valeur du nouveau libellé\n");
				String newLabel= scanner.next();
				ModifierPeriodicite.modifiePeriodicite(IDnew, newLabel, IDold);
				break;
			case 3:
				
				System.out.print("Saisissez la valeur de l'ID à supprimer\n");
				int IDsuppr = scanner.nextInt();
				SupprimerPeriodicite.deletePeriodicite(IDsuppr);
				break;
				

			default:
				
				break;
			}
		
		
	}
	
}
