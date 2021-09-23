package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;
import dao.metier.AbonnementMetier;
import net.cpoa.Connexion;

public class MySQLAbonnementDAO implements DAO<AbonnementMetier> {

	private static MySQLAbonnementDAO instance;

	private MySQLAbonnementDAO() {
	}

	public static MySQLAbonnementDAO getInstance() {
		if (instance == null) {
			instance = new MySQLAbonnementDAO();
		}
		return instance;
	}

	@Override
	public AbonnementMetier getById(int id) {
		AbonnementMetier periodicite = null;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from Abonnement where id_abonnement=?");
			requete.setInt(1, id);
			ResultSet res = requete.executeQuery();
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
	public boolean create(AbonnementMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"INSERT INTO `dipaolo6u_cpoatdun`.`Abonnement` (`id_abonnement`, `date_debut`, `date_fin`, `id_client`, `id_revue`) "
							+ "													VALUES (?, ?, ?, ?, ?);");
			requete.setInt(1, objet.getId());
			requete.setDate(2, java.sql.Date.valueOf(objet.getDateDebut()));
			requete.setDate(3, java.sql.Date.valueOf(objet.getDateFin()));
			requete.setInt(4, objet.getIDClient());
			requete.setInt(5, objet.getIDRevue());
			nbLignes = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb create " + sqle.getMessage());
		}
		return nbLignes == 1;
	}

	@Override
	public boolean update(AbonnementMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"UPDATE `dipaolo6u_cpoatdun`.`Abonnement` SET `id_abonnement` = ?, `date_debut` = ?, `date_fin` = ?, `id_client` = ?, `id_revue` = ? WHERE `Abonnement`.`id_abonnement` = ?;");
			requete.setInt(1, objet.getId());
			requete.setDate(2, java.sql.Date.valueOf(objet.getDateDebut()));
			requete.setDate(3, java.sql.Date.valueOf(objet.getDateFin()));
			requete.setInt(4, objet.getIDClient());
			requete.setInt(5, objet.getIDRevue());
			requete.setInt(6, objet.getId());
			nbLignes = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb update " + sqle.getMessage());
		}
		return nbLignes == 1;
	}

	@Override
	public boolean delete(AbonnementMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("delete from Abonnement where id_abonnement=" + objet.getId());
			nbLignes = requete.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Pb delete " + sqle.getMessage());
		}

		return nbLignes == 1;
	}

}