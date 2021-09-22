package net.cpoa.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import net.cpoa.Connexion;
import net.cpoa.dao.DAO;
import net.cpoa.dao.metier.AbonnementMetier;

public class MySQLAbonnementDAO implements DAO<AbonnementMetier> {

	private static MySQLAbonnementDAO instance;
	
	private MySQLAbonnementDAO() {}
	
	public static MySQLAbonnementDAO getInstance() {
		if (instance==null) {
		instance = new MySQLAbonnementDAO();
		}
		return instance;
		}
	
	
	@Override
	public AbonnementMetier getById(int id) {
		AbonnementMetier periodicite =null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where id_abonnement=?");
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
	public boolean create(AbonnementMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Abonnement` (`id_abonnement`, `voie`) VALUES (?, ?);");
			requete.setInt(1, objet.getId());
			requete.setInt(2, objet.getIDClient());
			nbLignes = requete.executeUpdate();
			
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return nbLignes ==1;
	 }

	@Override
	public boolean update(AbonnementMetier objet) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Abonnement` SET `id_abonnement` = ?, `voie` = ? WHERE `Abonnement`.`id_abonnement` = ?;");
			requete.setInt(1,objet.getId());
			requete.setInt(2, objet.getIDClient());
			requete.setInt(3, objet.getId());
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}		return false;
	}

	@Override
	public boolean delete(AbonnementMetier objet) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Abonnement where id_abonnement=" + objet.getId());
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	
		return false;
	}

	
}