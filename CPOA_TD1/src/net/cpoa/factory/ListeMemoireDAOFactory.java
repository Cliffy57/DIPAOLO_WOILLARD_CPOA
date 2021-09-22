package net.cpoa.factory;

import net.cpoa.dao.PeriodiciteDAO;
import net.cpoa.dao.listememoire.ListeMemoirePeriodiciteDAO;
import net.cpoa.dao.ClientDAO;

public class ListeMemoireDAOFactory extends
DAOFactory {
@Override
public ClientDAO getClientDAO() {
return ListeMemoireClientDAO.getInstance();
}
@Override
public PeriodiciteDAO getPeriodiciteDAO() {
return ListeMemoirePeriodiciteDAO.getInstance();
}
}