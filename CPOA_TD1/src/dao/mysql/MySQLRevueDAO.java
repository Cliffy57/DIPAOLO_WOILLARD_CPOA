package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connexion.Connexion;
import dao.RevueDAO;
import dao.metier.RevueMetier;

public class MySQLRevueDAO implements RevueDAO {

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
		RevueMetier revue =null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where id_revue=?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
			
			if(res.next())
			{
				revue = new RevueMetier();
				revue.setId(res.getInt("id_revue"));
                revue.setDescription(res.getString("description"));
                revue.setTitre(res.getString("titre"));
                revue.setVisuel(res.getString("visuel"));
                revue.setTarifNumero(res.getInt("tarif_numero"));
                revue.setIdPeriodicite(res.getInt("id_periodicite")); 
			}
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();
			} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return revue;
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
			requete.setFloat(4, objet.getTarifNumero());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6, objet.getIdPeriodicite());
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return nbLignes ==1;
	 }

	@Override
	public boolean update(RevueMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Revue` SET `id_revue` = ?, `titre` = ?,`description` = ?,`tarif_numero`=?,`visuel` =?,`id_periodicite` = ? WHERE `Revue`.`id_revue` = ?;");
			requete.setInt(1, objet.getId());
			requete.setString(2,objet.getTitre());
			requete.setString(3, objet.getDescription());
			requete.setFloat(4, objet.getTarifNumero());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6, objet.getIdPeriodicite());
			requete.setInt(7, objet.getId());
			nbLignes = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}		return nbLignes ==1;
	}

	@Override
	public boolean delete(RevueMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Revue where id_revue=" + objet.getId());
			nbLignes = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
	
		return nbLignes ==1;
	}

	@Override
	public ArrayList<RevueMetier> findAll() {
		ArrayList<RevueMetier> list = new ArrayList<RevueMetier>();
		RevueMetier revue =null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue ");
			ResultSet res = requete.executeQuery();
			
			while(res.next())
			{
				revue = new RevueMetier();
				revue.setId(res.getInt("id_revue"));
				revue.setTitre(res.getString("titre"));
				revue.setDescription(res.getString("description"));
				revue.setTarifNumero(res.getFloat("tarif_numero"));
				revue.setVisuel(res.getString("visuel"));
				revue.setIdPeriodicite(res.getInt("id_periodicite"));
				list.add(revue);
				
				
			}
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if(laConnexion != null)
				laConnexion.close();
			} catch (SQLException sqle) {
				System.out.println("Pb dans select " + sqle.getMessage());
			}
		
		return list;
	}

}