package net.cpoa.factory;

import net.cpoa.dao.ClientDAO;
import net.cpoa.dao.mysql.MySQLClientDAO;

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