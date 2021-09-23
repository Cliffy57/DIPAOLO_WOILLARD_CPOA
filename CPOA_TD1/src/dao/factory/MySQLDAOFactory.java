package dao.factory;

import dao.ClientDAO;
import dao.mysql.MySQLClientDAO;

public class MySQLDAOFactory extends DAOFactory {
	
	@Override
	public ClientDAO getClientDAO() {
		return MySQLClientDAO.getInstance();
	}
	
	@Override
	public PromoDAO getPromoDAO() {
		return MySQLPromoDAO.getInstance();
	}
}