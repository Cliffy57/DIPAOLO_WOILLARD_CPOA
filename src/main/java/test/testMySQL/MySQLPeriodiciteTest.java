package test.testMySQL;

import dao.PeriodiciteDAO;
import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.PeriodiciteMetier;
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
    public void setUp()
    {
        daofactory = DAOFactory.getDAOFactory(Persistance.MYSQL);
        periodiciteDAO = daofactory.getPeriodiciteDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        // Create Periodicite Unverified
        PeriodiciteMetier periodiciteUnVerified = new PeriodiciteMetier("Test2Fou");

        // ADD avec DAO
        periodiciteDAO.create(periodiciteUnVerified);

        PeriodiciteMetier periodiciteTemp = periodiciteDAO.getByLibelle(periodiciteUnVerified.getLibelle()).get(0);

        // periodiciteUnVerified -> ID in BD
        periodiciteUnVerified.setId(periodiciteTemp.getId());

        // Verif if periodiciteUnVerified == periodiciteTemp
        assertTrue(periodiciteUnVerified.equals(periodiciteTemp));

        // Delete
        periodiciteDAO.delete(periodiciteTemp);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        PeriodiciteMetier periodiciteUnVerified = new PeriodiciteMetier("Test2Fou");

        // Create Periodicite Unverified
        periodiciteDAO.create(periodiciteUnVerified);

        // Create Periodicite to UPDATE
        PeriodiciteMetier periodiciteUpdate = new PeriodiciteMetier("Test2Dingue");

        // Verif equals
        PeriodiciteMetier periodiciteTemp = periodiciteDAO.getByLibelle(periodiciteUnVerified.getLibelle()).get(0);

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
        PeriodiciteMetier periodiciteDelete = new PeriodiciteMetier("Test2Fou");

        // Insert In DB
        periodiciteDAO.create(periodiciteDelete);

        PeriodiciteMetier periodiciteTemp = periodiciteDAO.getByLibelle(periodiciteDelete.getLibelle()).get(0);

        periodiciteDelete.setId(periodiciteTemp.getId());

        periodiciteDAO.delete(periodiciteTemp);

        List<PeriodiciteMetier> liste = new ArrayList<>();
        liste = periodiciteDAO.getByLibelle("Test2Fou");

        assertEquals(0, liste.size());
    }
}