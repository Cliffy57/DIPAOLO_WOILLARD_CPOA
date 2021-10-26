package test.testListeMemoire;

import dao.*;
import dao.factory.DAOFactory;
import dao.metier.AbonnementMetier;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ListeMemoireAbonnementTest {
    private DAOFactory daofactory;
    private AbonnementDAO AbonnementDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        AbonnementDAO = daofactory.getAbonnementDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        AbonnementMetier AbonnementUnVerified = new AbonnementMetier(4,1990-09-09,2001-06-19,3,5);

        AbonnementDAO.create(AbonnementUnVerified);

        assertTrue(AbonnementDAO.create(AbonnementUnVerified));
    }

    @Test
    public void testUpdate() throws SQLException
    {
        AbonnementMetier AbonnementUnVerified = new AbonnementMetier(4,1990-09-09,2001-06-19,3,5);

        AbonnementDAO.create(AbonnementUnVerified);

        AbonnementMetier AbonnementTemp = AbonnementDAO.getById(AbonnementUnVerified.getId());

        AbonnementMetier AbonnementUpdate = new AbonnementMetier(4,1990-09-09,2001-06-19,3,5);

        AbonnementDAO.update(AbonnementUpdate);

        AbonnementTemp = AbonnementDAO.getById(AbonnementUpdate.getId());

        assertEquals(AbonnementUpdate, AbonnementTemp);

    }

    @Test
    public void testDelete() throws SQLException
    {
        AbonnementMetier AbonnementUnVerified = new AbonnementMetier(4,1990-09-09,2001-06-19,3,5);

        AbonnementDAO.create(AbonnementUnVerified);

        AbonnementDAO.delete(AbonnementUnVerified);

        assertFalse(AbonnementDAO.findAll().contains(AbonnementUnVerified));
    }

}
