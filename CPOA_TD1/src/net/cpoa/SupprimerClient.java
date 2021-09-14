package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class SupprimerClient {
	
	public void deleteClient(Integer id) {
		try {
			Connection laConnexion = creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Client where id_client=" + id);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

}
