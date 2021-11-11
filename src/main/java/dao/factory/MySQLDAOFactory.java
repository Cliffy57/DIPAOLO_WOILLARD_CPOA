package dao.factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
import dao.mysql.MySQLAbonnementDAO;
import dao.mysql.MySQLClientDAO;
import dao.mysql.MySQLPeriodiciteDAO;
import dao.mysql.MySQLRevueDAO;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public AbonnementDAO getAbonnementDAO() {

        return MySQLAbonnementDAO.getInstance();
    }

    @Override
    public ClientDAO getClientDAO() {

        return MySQLClientDAO.getInstance();
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO() {

        return MySQLPeriodiciteDAO.getInstance();
    }

    @Override
    public RevueDAO getRevueDAO() {

        return MySQLRevueDAO.getInstance();
    }

}