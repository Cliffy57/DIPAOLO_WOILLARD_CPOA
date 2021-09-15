package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Revue {
	
		public class AjouterRevue {
			
			public void insertRevue(int id,String titre,String description,int tarif_numero,String visuel,int id_periodicite) {
				try {
					Connection laConnexion = creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Revue` (`id_revue`, `titre`, `description`, `tarif_numero`, `visuel`, `id_periodicite`) VALUES (?, ?, ?, ?, ? , ?);");
					requete.setInt(1, id);
					requete.setString(2,titre);
					requete.setString(3, description);
					requete.setInt(4, tarif_numero);
					requete.setString(5, visuel);
					requete.setInt(6, id_periodicite);
		
					
					int res = requete.executeUpdate();
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
			}
		}
		public class ModifierRevue {
			
			public void modifieRevue(int IDnew,String nom_revue,String description,Integer tarif_numero,String visuel,int id_periodicite,int IDold) {
				try {
					Connection laConnexion = creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Revue` SET `id_revue` = ?, `titre` = ? WHERE `Revue`.`id_revue` = ?;");
					requete.setInt(1,IDnew);
					requete.setString(2,nom_revue);
					requete.setString(3, description);
					requete.setInt(4, tarif_numero);
					requete.setString(5, visuel);
					requete.setInt(6, id_periodicite);
					requete.setInt(9, IDold);
					int res = requete.executeUpdate();
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
			}

		}
		public class SupprimerRevue {
			
			public void deleteRevue(int id) {
				try {
					Connection laConnexion = creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("delete from Revue where id_revue=" + id);
					int res = requete.executeUpdate();
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
			}

		}



}
