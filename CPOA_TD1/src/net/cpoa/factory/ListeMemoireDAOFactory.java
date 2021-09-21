package net.cpoa.factory;

public class ListeMemoireDAOFactory extends
DAOFactory {
@Override
public ClientDAO getClientDAO() {
return ListeMemoireClientDAO.getInstance();
}
@Override
public PromoDAO getPromoDAO() {
return ListeMemoireAbonnementDAO.getInstance();
}
}