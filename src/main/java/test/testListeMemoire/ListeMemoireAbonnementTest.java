package test.testListeMemoire;

import dao.AbonnementDAO;
import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.AbonnementMetier;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ListeMemoireAbonnementTest {
    private DAOFactory daofactory;
    private AbonnementDAO AbonnementDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        AbonnementDAO = daofactory.getAbonnementDAO();
    }

    @Test
    public void testCreate() throws SQLException {
        AbonnementMetier AbonnementUnVerified = new AbonnementMetier(4, LocalDate.of(1990, 9, 9), LocalDate.of(2001, 6, 19), 3, 5);

        AbonnementDAO.create(AbonnementUnVerified);

        AbonnementMetier AbonnementTemp = AbonnementDAO.getById(AbonnementUnVerified.getId());

        assertEquals(AbonnementUnVerified, AbonnementTemp);

//      assertTrue(AbonnementDAO.create(AbonnementUnVerified));
    }

    @Test
    public void testUpdate() throws SQLException {
        AbonnementMetier AbonnementUnVerified = new AbonnementMetier(4, LocalDate.of(1990, 9, 9), LocalDate.of(2001, 6, 19), 3, 5);

        AbonnementDAO.create(AbonnementUnVerified);

        AbonnementMetier AbonnementTemp = AbonnementDAO.getById(AbonnementUnVerified.getId());

        AbonnementMetier AbonnementUpdate = new AbonnementMetier(4, LocalDate.of(1990, 9, 9), LocalDate.of(2001, 6, 19), 3, 5);

        AbonnementDAO.update(AbonnementUpdate);

        AbonnementTemp = AbonnementDAO.getById(AbonnementUpdate.getId());

        assertEquals(AbonnementUpdate, AbonnementTemp);

    }

    @Test
    public void testDelete() throws SQLException {
        AbonnementMetier AbonnementUnVerified = new AbonnementMetier(4, LocalDate.of(1990, 9, 9), LocalDate.of(2001, 6, 19), 3, 5);

        AbonnementDAO.create(AbonnementUnVerified);

        AbonnementDAO.delete(AbonnementUnVerified);

        assertFalse(AbonnementDAO.findAll().contains(AbonnementUnVerified));
    }

}
