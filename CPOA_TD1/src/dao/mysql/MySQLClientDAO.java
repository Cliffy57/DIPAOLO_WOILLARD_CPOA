package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ClientDAO;
import dao.DAO;
import dao.metier.ClientMetier;
import net.cpoa.Connexion;

public class MySQLClientDAO implements ClientDAO {

	private static MySQLClientDAO instance;
	
	private MySQLClientDAO() {}
	
	public static MySQLClientDAO getInstance() {
		if (instance==null) {
		instance = new MySQLClientDAO();
		}
		return instance;
		}
	
	@Override
	public ClientMetier getById(int id) {
		ClientMetier periodicite =null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client=?");
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
	public boolean create(ClientMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Client` (`id_client`, `nom`, `prenom`, `no_rue`, `voie`, `code_postal`, `ville`, `pays`) VALUES (?,?,?,?,?,?,?,?);");
			requete.setInt(1, objet.getId());
			requete.setString(2,objet.getNom());
			requete.setString(3, objet.getPrenom());
			requete.setInt(4, objet.getNo_rue());
			requete.setString(5, objet.getVoie());
			requete.setInt(6, objet.getCodepost());
			requete.setString(7, objet.getVille());
			requete.setString(8, objet.getPays());
			
			nbLignes = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb create" + sqle.getMessage());
		}
		return nbLignes ==1;
	 }

	@Override
	public boolean update(ClientMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Client` SET `id_client` = ?, `nom` = ?, `prenom` = ?, `no_rue` = ?, `voie` = ?, `code_postal` = ?, `ville` = ?, `pays` = ? WHERE `Client`.`id_client` = ?;");
			requete.setInt(1,objet.getId());
			requete.setString(2,objet.getNom());
			requete.setString(3, objet.getPrenom());
			requete.setInt(4, objet.getNo_rue());
			requete.setString(5, objet.getVoie());
			requete.setInt(6, objet.getCodepost());
			requete.setString(7, objet.getVille());
			requete.setString(8, objet.getPays());
			requete.setInt(9, objet.getId());
			nbLignes = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb update" + sqle.getMessage());
		}		
		return nbLignes == 1;
	}

	@Override
	public boolean delete(ClientMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Client where id_client=" + objet.getId());
			nbLignes = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb delete" + sqle.getMessage());
		}
	
		return nbLignes == 1;
	}

	
}