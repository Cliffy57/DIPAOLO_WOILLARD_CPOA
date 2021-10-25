package test.testListeMemoire;

import dao.*;
import dao.factory.DAOFactory;
import dao.metier.PeriodiciteMetier;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ListeMemoirePeriodiciteTest {
    private DAOFactory daofactory;
    private PeriodiciteDAO periodiciteDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        periodiciteDAO = daofactory.getPeriodiciteDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        PeriodiciteMetier periodiciteUnVerified = new PeriodiciteMetier(3,"Mensuel");

        periodiciteDAO.create(periodiciteUnVerified);

        assertTrue(periodiciteDAO.create(periodiciteUnVerified));
    }

    @Test
    public void testUpdate() throws SQLException
    {
        PeriodiciteMetier periodiciteUnVerified = new PeriodiciteMetier(3,"Update");

        periodiciteDAO.create(periodiciteUnVerified);

        PeriodiciteMetier periodiciteTemp = periodiciteDAO.getById(periodiciteUnVerified.getId());

        PeriodiciteMetier periodiciteUpdate = new PeriodiciteMetier(3,"Update");

        periodiciteDAO.update(periodiciteUpdate);

        periodiciteTemp = periodiciteDAO.getById(periodiciteUpdate.getId());

        assertEquals(periodiciteUpdate, periodiciteTemp);

    }

    @Test
    public void testDelete() throws SQLException
    {
        PeriodiciteMetier periodiciteUnVerified = new PeriodiciteMetier(3,"Update");

        periodiciteDAO.create(periodiciteUnVerified);

        periodiciteDAO.delete(periodiciteUnVerified);

        assertFalse(periodiciteDAO.findAll().contains(periodiciteUnVerified));
    }

}
