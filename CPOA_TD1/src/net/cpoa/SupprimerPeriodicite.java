package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class SupprimerPeriodicite {
	
	public static void deletePeriodicite(int ID) {
		try {
			Connection laConnexion = Connexion.creerConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=" + ID);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

}
