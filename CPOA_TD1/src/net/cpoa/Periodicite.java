package net.cpoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;



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
}
