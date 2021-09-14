package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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


