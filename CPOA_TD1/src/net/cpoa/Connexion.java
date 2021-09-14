package net.cpoa;

import java.sql.*;

public class Connexion {

	public static Connection creeConnexion() {
		String url = 
		"jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/dipaolo6u_cpoatdun";
		url += "?serverTimezone=Europe/Paris";
		String login = "dipaolo6u_appli";
		String pwd = ""; 
		Connection maConnexion = null;
		try { 
		maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
		System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
		  }
	
	public void uneRequete() {
		  try {
		   Connection laConnexion = creeConnexion();
		Statement requete = (laConnexion).createStatement();
		ResultSet res = requete.executeQuery("select id_client from Client");
		System.out.println("Fonctionne");
				} catch (SQLException sqle) {
		System.out.println("Pb select" + sqle.getMessage());
		  } 
		}
	
	public void insertPeriodicite(String I,String string) {
		try {
			Connection laConnexion = creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Periodicite` (`id_periodicite`, `libelle`) VALUES (?, ?);");
			requete.setString(1, I);
			requete.setString(2, string);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
	public void deletePeriodicite(String I) {
		try {
			Connection laConnexion = creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=" + I);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
	public void modifiePeriodicite(int IDnew,String libelle,int IDold) {
		try {
			Connection laConnexion = creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Periodicite` SET `id_periodicite` = ?, `libelle` = ? WHERE `Periodicite`.`id_periodicite` = ?;");
			requete.setInt(1,IDnew);
			requete.setString(2, libelle);
			requete.setInt(3, IDold);
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		Connexion laConnexion=new Connexion();
		Connexion.creeConnexion();
		laConnexion.uneRequete();
		//laConnexion.insertPeriodicite("1", "TestTechnique");
		//laConnexion.insertPeriodicite("2", "Javanais");
		//laConnexion.deletePeriodicite("2");
		//laConnexion.modifiePeriodicite(2, "Jacob", 1);

	}
	

	}

	
