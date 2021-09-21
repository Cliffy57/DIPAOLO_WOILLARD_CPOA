package net.cpoa.factory;

import net.cpoa.DAO.MySQLClientDAO;

public class MySQLDAOFactory extends DAOFactory {
@Override
public ClientDAO getClientDAO() {
return MySQLClientDAO.getId();
}
@Override
public PromoDAO getPromoDAO() {
return MySQLPromoDAO.getInstance();
}
}