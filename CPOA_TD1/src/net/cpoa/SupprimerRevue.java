package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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
