package net.cpoa;

import java.sql.*;

public class Connexion {

	@SuppressWarnings("exports")
	public static Connection creeConnexion() {
		String url = 
		"jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/dipaolo6u_cpoatdun";
		url += "?serverTimezone=Europe/Paris";
		String login = "dipaolo6u_appli";
		String pwd = " "; 
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

	
