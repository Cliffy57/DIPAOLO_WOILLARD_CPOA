package test.testMySQL;

import dao.AbonnementDAO;
import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class MySQLAbonnementTest {
    private DAOFactory daofactory;
    private AbonnementDAO AbonnementDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.MYSQL);
        AbonnementDAO = daofactory.getAbonnementDAO();

    }
     @Test
    public void testCreate() throws SQLException {

        AbonnementMetier AbonnementUnverified = new AbonnementMetier(4,LocalDate.of(1990,9,9),LocalDate.of(2001,6,19),3,5);
        AbonnementDAO.create(AbonnementUnverified);


    }
    @Test
    public void testDelete() throws SQLException
    {
        // Create Revue
        AbonnementMetier AbonnementDelete = new AbonnementMetier(4,LocalDate.of(1990,9,9),LocalDate.of(2001,6,19),3,5);

        // Insert In DB
        AbonnementDAO.create(AbonnementDelete);
        // Delete In DB
        assertTrue(AbonnementDAO.delete(AbonnementDelete));

    }
    @Test
    public void testUpdate() throws SQLException {
        AbonnementMetier AbonnementUnVerified = new AbonnementMetier(4,LocalDate.of(1990,9,9),LocalDate.of(2001,6,19),3,5);
        AbonnementDAO.create(AbonnementUnVerified);
        AbonnementMetier AbonnementUpdate = new AbonnementMetier(4,LocalDate.of(1990,9,9),LocalDate.of(2002,3,9),3,5);
        AbonnementMetier AbonnementTemp = AbonnementDAO.getById(AbonnementUnVerified.getId());
        AbonnementUpdate.setId(AbonnementTemp.getId());
        AbonnementDAO.update(AbonnementUpdate);
        AbonnementTemp = AbonnementDAO.getById(AbonnementUpdate.getId());
        assertTrue(AbonnementUpdate.equals(AbonnementTemp));
        AbonnementDAO.delete(AbonnementTemp);
    }
}
