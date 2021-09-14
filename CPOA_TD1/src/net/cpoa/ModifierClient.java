package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ModifierClient {
	
	public void modifieClient(int IDnew,String nom,String prenom,Integer no_rue,String voie,Integer code_postal,String ville,String pays,int IDold) {
		try {
			Connection laConnexion = creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Client` SET `id_client` = ?, `libelle` = ? WHERE `Client`.`id_client` = ?;");
			requete.setInt(1,IDnew);
			requete.setString(2,nom);
			requete.setString(3, prenom);
			requete.setInt(4, no_rue);
			requete.setString(5, voie);
			requete.setInt(6, code_postal);
			requete.setString(7, ville);
			requete.setString(8, pays);
			requete.setInt(9, IDold);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}

}
