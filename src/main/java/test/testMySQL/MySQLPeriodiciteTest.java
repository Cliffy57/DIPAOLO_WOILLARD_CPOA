package test.testMySQL;

import dao.PeriodiciteDAO;
import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.PeriodiciteMetier;
import dao.mysql.MySQLPeriodiciteDAO;
import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MySQLPeriodiciteTest {
    private DAOFactory daofactory;
    private PeriodiciteDAO periodiciteDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.MYSQL);
        periodiciteDAO = daofactory.getPeriodiciteDAO();

    }

    //  Fonctionne
    @Test
    public void testCreate() throws SQLException {
        // Create Periodicite Unverified
        PeriodiciteMetier PeriodiciteUnVerified = new PeriodiciteMetier(4, "Mensuel");
        periodiciteDAO.create(PeriodiciteUnVerified);


    }


    @Test
    public void testUpdate() throws SQLException {
        PeriodiciteMetier periodiciteUnVerified = new PeriodiciteMetier(4, "Mensuel");

        // Create Periodicite Unverified
        periodiciteDAO.create(periodiciteUnVerified);

        // Create Periodicite to UPDATE
        PeriodiciteMetier periodiciteUpdate = new PeriodiciteMetier(4, "Annuel");

        // Verif equals
        PeriodiciteMetier periodiciteTemp = periodiciteDAO.getById(periodiciteUnVerified.getId());

        // Define var id Temp -> Update
        periodiciteUpdate.setId(periodiciteTemp.getId());

        // Change old var -> new var
        periodiciteDAO.update(periodiciteUpdate);

        // GetPeriodicitebyID
        periodiciteTemp = periodiciteDAO.getById(periodiciteUpdate.getId());

        // Verif if periodiciteUpdate == periodiciteTemp
        assertTrue(periodiciteUpdate.equals(periodiciteTemp));

        // Delete After
        periodiciteDAO.delete(periodiciteTemp);
    }


    @Test
    public void testDelete() throws SQLException
    {
        // Create Periodicite
        PeriodiciteMetier periodiciteDelete = new PeriodiciteMetier(4, "Mensuel");

        // Insert In DB
        periodiciteDAO.create(periodiciteDelete);
        // Delete In DB
        assertTrue(periodiciteDAO.delete(periodiciteDelete));

    }
}
