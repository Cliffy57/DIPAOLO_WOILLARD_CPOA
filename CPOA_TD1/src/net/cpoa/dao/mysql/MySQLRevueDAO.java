package net.cpoa.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import net.cpoa.Connexion;
import net.cpoa.dao.DAO;
import net.cpoa.dao.metier.RevueMetier;

public class MySQLRevueDAO implements DAO<RevueMetier> {

	private static MySQLRevueDAO instance;
	
	private MySQLRevueDAO() {}
	
	public static MySQLRevueDAO getInstance() {
		if (instance==null) {
		instance = new MySQLRevueDAO();
		}
		return instance;
		}
	
	
	@Override
	public RevueMetier getById(int id) {
		RevueMetier periodicite =null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where id_revue=?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();
			} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return periodicite;
	}

	@Override
	public boolean create(RevueMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Revue` (`id_revue`, `titre`, `description`, `tarif_numero`, `visuel`, `id_periodicite`) VALUES (?, ?, ?, ?, ? , ?);");
			requete.setInt(1, objet.getId());
			requete.setString(2,objet.getTitre());
			requete.setString(3, objet.getDescription());
			requete.setFloat(4, objet.getTarif_numero());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6, objet.getId_periodicite());
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return nbLignes ==1;
	 }

	@Override
	public boolean update(RevueMetier objet) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Revue` SET `id_revue` = ?, `titre` = ? WHERE `Revue`.`id_revue` = ?;");
			requete.setInt(1, objet.getId());
			requete.setString(2,objet.getTitre());
			requete.setString(3, objet.getDescription());
			requete.setFloat(4, objet.getTarif_numero());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6, objet.getId_periodicite());
			requete.setInt(7, objet.getId());
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}		return false;
	}

	@Override
	public boolean delete(RevueMetier objet) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Revue where id_revue=" + objet.getId());
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	
		return false;
	}

	
}