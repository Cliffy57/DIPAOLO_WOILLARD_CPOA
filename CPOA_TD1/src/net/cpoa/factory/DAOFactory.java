package net.cpoa.factory;

import net.cpoa.DAO.ClientDAO;
import net.cpoa.DAO.Persistance;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daoF = null;
		switch (cible) {
		case MYSQL:
		daoF = new MySQLDAOFactory();
		break;
		case LISTE_MEMOIRE:
		daoF = new ListeMemoireDAOFactory();
		break;
		}
		return daoF;
		
		}
	public abstract ClientDAO getClientDAO();
	}
		



