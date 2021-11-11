package test.testListeMemoire;

import dao.Persistance;
import dao.RevueDAO;
import dao.factory.DAOFactory;
import dao.metier.RevueMetier;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ListeMemoireRevueTest {
    private DAOFactory daofactory;
    private RevueDAO RevueDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        RevueDAO = daofactory.getRevueDAO();
    }

    @Test
    public void testCreate() throws SQLException {
        RevueMetier RevueUnVerified = new RevueMetier(2, "Tintin", "Une BD", 2, "Sport", 2);

        RevueDAO.create(RevueUnVerified);

        RevueMetier RevueTemp = RevueDAO.getById(RevueUnVerified.getId());

        assertEquals(RevueUnVerified, RevueTemp);

//        assertTrue(RevueDAO.create(RevueUnVerified));
    }

    @Test
    public void testUpdate() throws SQLException {
        RevueMetier RevueUnVerified = new RevueMetier(2, "Tintin", "Une BD", 2, "Sport", 2);

        RevueDAO.create(RevueUnVerified);

        RevueMetier RevueTemp = RevueDAO.getById(RevueUnVerified.getId());

        RevueMetier RevueUpdate = new RevueMetier(2, "Tintin", "Une BD", 2, "Sport", 2);

        RevueDAO.update(RevueUpdate);

        RevueTemp = RevueDAO.getById(RevueUpdate.getId());

        assertEquals(RevueUpdate, RevueTemp);

    }

    @Test
    public void testDelete() throws SQLException {
        RevueMetier RevueUnVerified = new RevueMetier(2, "Tintin", "Une BD", 2, "Sport", 2);

        RevueDAO.create(RevueUnVerified);

        RevueDAO.delete(RevueUnVerified);

        assertFalse(RevueDAO.findAll().contains(RevueUnVerified));
    }

}
