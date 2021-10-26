package test.testListeMemoire;

import dao.*;
import dao.factory.DAOFactory;
import dao.metier.AbonnementMetier;
import dao.metier.PeriodiciteMetier;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ListeMemoirePeriodiciteTest {
    private DAOFactory daofactory;
    private PeriodiciteDAO PeriodiciteDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        PeriodiciteDAO = daofactory.getPeriodiciteDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        PeriodiciteMetier PeriodiciteUnVerified = new PeriodiciteMetier(3,"Mensuel");

        PeriodiciteDAO.create(PeriodiciteUnVerified);

        PeriodiciteMetier PeriodiciteTemp = PeriodiciteDAO.getById(PeriodiciteUnVerified.getId());

        assertEquals(PeriodiciteUnVerified,PeriodiciteTemp);


//        assertTrue(periodiciteDAO.create(periodiciteUnVerified));
    }

    @Test
    public void testUpdate() throws SQLException
    {
        PeriodiciteMetier periodiciteUnVerified = new PeriodiciteMetier(3,"Update");

        PeriodiciteDAO.create(periodiciteUnVerified);

        PeriodiciteMetier periodiciteTemp = PeriodiciteDAO.getById(periodiciteUnVerified.getId());

        PeriodiciteMetier periodiciteUpdate = new PeriodiciteMetier(3,"Update");

        PeriodiciteDAO.update(periodiciteUpdate);

        periodiciteTemp = PeriodiciteDAO.getById(periodiciteUpdate.getId());

        assertEquals(periodiciteUpdate, periodiciteTemp);

    }

    @Test
    public void testDelete() throws SQLException
    {
        PeriodiciteMetier periodiciteUnVerified = new PeriodiciteMetier(3,"Update");

        PeriodiciteDAO.create(periodiciteUnVerified);

        PeriodiciteDAO.delete(periodiciteUnVerified);

        assertFalse(PeriodiciteDAO.findAll().contains(periodiciteUnVerified));
    }

}
