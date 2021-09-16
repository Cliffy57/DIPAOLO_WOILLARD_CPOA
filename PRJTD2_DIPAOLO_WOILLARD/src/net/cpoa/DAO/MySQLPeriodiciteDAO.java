package net.cpoa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import net.cpoa.Connexion;
import net.cpoa.DAO.metier.PeriodiciteMetier;

public class MySQLPeriodiciteDAO implements DAO<PeriodiciteMetier> {

	@Override
	public PeriodiciteMetier getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(PeriodiciteMetier objet) {
		int nbLignes = 0;
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO `dipaolo6u_cpoatdun`.`Periodicite` (`id_periodicite`, `libelle`) VALUES (?, ?);");
			requete.setInt(1, objet.getID());
			requete.setString(2, objet.getLibelle());
			nbLignes = requete.executeUpdate();
			
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return nbLignes ==1;
	 }

	@Override
	public boolean update(PeriodiciteMetier objet) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE `dipaolo6u_cpoatdun`.`Periodicite` SET `id_periodicite` = ?, `libelle` = ? WHERE `Periodicite`.`id_periodicite` = ?;");
			requete.setInt(1,objet.getID());
			requete.setString(2, objet.getLibelle());
			requete.setInt(3, objet.getID());
			int res = requete.executeUpdate();
			
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}		return false;
	}

	@Override
	public boolean delete(PeriodiciteMetier objet) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
