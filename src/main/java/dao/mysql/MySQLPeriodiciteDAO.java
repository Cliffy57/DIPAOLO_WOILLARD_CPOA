package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connexion.Connexion;
import dao.PeriodiciteDAO;
import dao.metier.PeriodiciteMetier;

public class MySQLPeriodiciteDAO implements PeriodiciteDAO {

	private static MySQLPeriodiciteDAO instance;

	private MySQLPeriodiciteDAO() {
	}

	public static MySQLPeriodiciteDAO getInstance() {
		if (instance == null) {
			instance = new MySQLPeriodiciteDAO();
		}
		return instance;
	}

	@Override
	public PeriodiciteMetier getById(int id) {
		PeriodiciteMetier periodicite = null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("select * from Periodicite where id_periodicite=?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
			if(res.next()) {
				periodicite = new PeriodiciteMetier();
                periodicite.setId(res.getInt("id_periodicite"));
                periodicite.setLibelle(res.getString("libelle"));
			}
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}

		return periodicite;
	}

	@Override
	public boolean create(PeriodiciteMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"INSERT INTO `dipaolo6u_cpoatdun`.`Periodicite` (`id_periodicite`, `libelle`) VALUES (?, ?);");
			requete.setInt(1, objet.getId());
			requete.setString(2, objet.getLibelle());
			nbLignes = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb create" + sqle.getMessage());
		}
		return nbLignes == 1;
	}

	@Override
	public boolean update(PeriodiciteMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"UPDATE `dipaolo6u_cpoatdun`.`Periodicite` SET `id_periodicite` = ?, `libelle` = ? WHERE `Periodicite`.`id_periodicite` = ?;");
			requete.setInt(1, objet.getId());
			requete.setString(2, objet.getLibelle());
			requete.setInt(3, objet.getId());
			nbLignes = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb update" + sqle.getMessage());
		}
		return nbLignes == 1;
	}

	@Override
	public boolean delete(PeriodiciteMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("delete from Periodicite where id_periodicite=" + objet.getId());
			nbLignes = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb delete" + sqle.getMessage());
		}

		return nbLignes == 1;
	}

	@Override
	public ArrayList<PeriodiciteMetier> findAll() {
		ArrayList<PeriodiciteMetier> list = new ArrayList<PeriodiciteMetier>();
		PeriodiciteMetier periodicite = null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Periodicite");
			ResultSet res = requete.executeQuery();

			while (res.next()) {
				periodicite = new PeriodiciteMetier();
				periodicite.setId(res.getInt("id_periodicite"));
				periodicite.setLibelle(res.getString("libelle"));
				list.add(periodicite);

			}
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
		} catch (SQLException sqle) {
			System.out.println("Pb dans select " + sqle.getMessage());
		}

		return list;
	}

	@Override
	public boolean ifExist(PeriodiciteMetier objet) {

		ResultSet rs;
		int nbLignes =0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT * FROM Periodicite WHERE Periodicite.libelle = ?;");
			requete.setString(1, objet.getLibelle());
			rs = requete.executeQuery();
			if (rs.next()) {
				do {
					nbLignes+=1;
				} while (rs.next());
			}
		} catch (SQLException sqle) {
			System.out.println("Pb dans ifExist " + sqle.getMessage());
		}
		return nbLignes >= 1;
	}

}