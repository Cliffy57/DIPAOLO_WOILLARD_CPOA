package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class ModifierPeriodicite {
	
	public static void modifiePeriodicite(int IDnew,String libelle,int IDold) {
		try {
			Connection laConnexion = Connexion.creerConnexion();
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
