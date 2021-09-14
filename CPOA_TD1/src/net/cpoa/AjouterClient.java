package net.cpoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class AjouterClient{

public void InsertClient(Integer id,String nom,String prenom,Integer no_rue,String voie,Integer code_postal,String ville,String pays) {
		try {
			Connection laConnexion = creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Client` (`id_client`, `nom`, `prenom`, `no_rue`, `voie`, `code_postal`, `ville`, `pays`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			requete.setInt(1, id);
			requete.setString(2,nom);
			requete.setString(3, prenom);
			requete.setInt(4, no_rue);
			requete.setString(5, voie);
			requete.setInt(6, code_postal);
			requete.setString(7, ville);
			requete.setString(8, pays);
			
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		
	}
}
		
