package net.cpoa.factory;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daoF = null;
		switch (cible) {
		case MYSQL:
		daoF = new MySQLDAOFactory();
		break;
		case ListeMemoire:
		daoF = new ListeMemoireDAOFactory();
		break;
		}
		return daoF ;


}
