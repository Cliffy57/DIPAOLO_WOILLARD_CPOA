package dao.factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
import dao.listememoire.ListeMemoireAbonnementDAO;
import dao.listememoire.ListeMemoireClientDAO;
import dao.listememoire.ListeMemoirePeriodiciteDAO;
import dao.listememoire.ListeMemoireRevueDAO;

public class ListeMemoireDAOFactory extends DAOFactory {
    @Override
    public ClientDAO getClientDAO() {
        return ListeMemoireClientDAO.getInstance();
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO() {
        return ListeMemoirePeriodiciteDAO.getInstance();
    }

    @Override
    public AbonnementDAO getAbonnementDAO() {
        return ListeMemoireAbonnementDAO.getInstance();
    }

    @Override
    public RevueDAO getRevueDAO() {
        return ListeMemoireRevueDAO.getInstance();
    }
}