package test.testMySQL;

import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class MySQLRevueTest {
    private DAOFactory daofactory;
    private dao.RevueDAO RevueDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.MYSQL);
        RevueDAO = daofactory.getRevueDAO();

    }
    @Test
    public void testCreate() throws SQLException {

        RevueMetier MetierUnverified = new RevueMetier(2,"Tintin","Une BD",2,"Sport",2);
        RevueDAO.create(MetierUnverified);


    }
    @Test
    public void testDelete() throws SQLException
    {
        // Create Revue
        RevueMetier RevueDelete = new RevueMetier(2,"Tintin","Une BD",2,"Sport",2);

        // Insert In DB
        RevueDAO.create(RevueDelete);
        // Delete In DB
        assertTrue(RevueDAO.delete(RevueDelete));

    }
    @Test
    public void testUpdate() throws SQLException {
        RevueMetier RevueUnVerified = new RevueMetier(2,"Tintin","Une BD",2,"Sport",2);
        RevueDAO.create(RevueUnVerified);
        RevueMetier RevueUpdate = new RevueMetier(2,"Tintin","Une BD",2,"Animation",2);
        RevueMetier RevueTemp = RevueDAO.getById(RevueUnVerified.getId());
        RevueUpdate.setId(RevueTemp.getId());
        RevueDAO.update(RevueUpdate);
        RevueTemp = RevueDAO.getById(RevueUpdate.getId());
        assertTrue(RevueUpdate.equals(RevueTemp));
        RevueDAO.delete(RevueTemp);
    }
}
