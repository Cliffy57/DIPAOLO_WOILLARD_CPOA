package dao.factory;

import dao.ClientDAO;
import dao.PeriodiciteDAO;
import dao.listememoire.ListeMemoirePeriodiciteDAO;

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