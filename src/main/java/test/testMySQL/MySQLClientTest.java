package test.testMySQL;


import dao.Persistance;
import dao.factory.DAOFactory;

import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.RevueMetier;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;


public class MySQLClientTest {
    private DAOFactory daofactory;
    private dao.ClientDAO ClientDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.MYSQL);
        ClientDAO = daofactory.getClientDAO();

    }
    @Test
    public void testCreate() throws SQLException {

        ClientMetier ClientUnverified = new ClientMetier(5,"Cobin","Jacque",14,"rue de la saucisse",21041,"SaucisseTown","SaucisseLand");
        ClientDAO.create(ClientUnverified);


    }
    @Test
    public void testDelete() throws SQLException
    {
        // Create Revue
        ClientMetier ClientDelete = new ClientMetier(5,"Cobin","Jacque",14,"rue de la saucisse",21041,"SaucisseTown","SaucisseLand");

        // Insert In DB
        ClientDAO.create(ClientDelete);
        // Delete In DB
        assertTrue(ClientDAO.delete(ClientDelete));

    }
    @Test
    public void testUpdate() throws SQLException {
        ClientMetier ClientUnVerified = new ClientMetier(5,"Cobin","Jacque",14,"rue de la saucisse",21041,"SaucisseTown","SaucisseLand");
        ClientDAO.create(ClientUnVerified);
        ClientMetier ClientUpdate = new ClientMetier(5,"Cobin","Jack",24,"rue de la saucisse",21041,"SaucisseTown","SaucisseLand");
        ClientMetier ClientTemp = ClientDAO.getById(ClientUnVerified.getId());
        ClientUpdate.setId(ClientTemp.getId());
        ClientDAO.update(ClientUpdate);
        ClientTemp = ClientDAO.getById(ClientUpdate.getId());
        assertTrue(ClientUpdate.equals(ClientTemp));
        ClientDAO.delete(ClientTemp);
    }
}
