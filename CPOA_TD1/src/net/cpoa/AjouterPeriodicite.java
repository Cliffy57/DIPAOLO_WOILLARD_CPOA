package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class AjouterPeriodicite {
	
	public static void insertPeriodicite(int ID,String libelle) {
		try {
			Connection laConnexion = Connexion.creerConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Periodicite` (`id_periodicite`, `libelle`) VALUES (?, ?);");
			requete.setInt(1, ID);
			requete.setString(2, libelle);
			int res = requete.executeUpdate();
			
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

}
