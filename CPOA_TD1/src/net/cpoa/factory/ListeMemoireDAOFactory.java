package net.cpoa.factory;

import net.cpoa.DAO.ClientDAO;

public class ListeMemoireDAOFactory extends
DAOFactory {
@Override
public ClientDAO getClientDAO() {
return ListeMemoireClientDAO.getInstance();
}
@Override
public PromoDAO getPromoDAO() {
return ListeMemoirePromoDAO.getInstance();
}
}