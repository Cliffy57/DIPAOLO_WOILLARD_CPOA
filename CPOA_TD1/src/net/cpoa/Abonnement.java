package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Abonnement {
		
			public static void insertAbonnement(int id,Date date_debut,Date date_fin,int id_client,int id_revue) {
				try {
					Connection laConnexion = Connexion.creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Revue` (`id_abonnement`, `date_debut`, `date_fin`, `id_client`, `id_revue`) VALUES (?, ?, ?, ?, ? , ?);");
					requete.setInt(1, id);
					requete.setDate(2,date_debut);
					requete.setDate(3, date_fin);
					requete.setInt(4, id_client);
					requete.setInt(5, id_revue);
		
					
					int res = requete.executeUpdate();
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
			
			}
			
			public static void modifieAbonnement(int IDnew,date date_debut,date date_fin,int id_client,int id_revue,int IDold) {
				try {
					Connection laConnexion = Connexion.creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Abonnement` SET `id_revue` = ?, `id_client` = ? WHERE `Abonnement`.`id_revue` = ?;");
					requete.setInt(1,IDnew);
					requete.setDate(2,date_debut);
					requete.setDate(3, date_fin);
					requete.setInt(4, id_client);
					requete.setInt(5, id_revue);
					requete.setInt(9, IDold);
					int res = requete.executeUpdate();
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
			}

			public static void deleteAbonnement(int id) {
				try {
					Connection laConnexion = Connexion.creeConnexion();
					PreparedStatement requete = laConnexion.prepareStatement("delete from Abonnement where id_abonnement=" + id);
					int res = requete.executeUpdate();
					
				} catch (SQLException sqle) {
					System.out.println("Pb select" + sqle.getMessage());
				}
			}
			
		}


}
