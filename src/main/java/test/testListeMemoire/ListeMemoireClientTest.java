package test.testListeMemoire;

import dao.*;
import dao.factory.DAOFactory;
import dao.metier.ClientMetier;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.*;
public class ListeMemoireClientTest {
    private DAOFactory daofactory;
    private ClientDAO ClientDAO;

    @Before
    public void setUp() {
        daofactory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        ClientDAO = daofactory.getClientDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        ClientMetier ClientUnVerified = new ClientMetier(5,"Cobin","Jacque",14,"rue du square",54720,"Lexy","France");

        ClientDAO.create(ClientUnVerified);

        assertTrue(ClientDAO.create(ClientUnVerified));
    }

    @Test
    public void testUpdate() throws SQLException
    {
        ClientMetier ClientUnVerified = new ClientMetier(5,"Cobin","Jacque",14,"rue du square",54720,"Lexy","France");

        ClientDAO.create(ClientUnVerified);

        ClientMetier ClientTemp = ClientDAO.getById(ClientUnVerified.getId());

        ClientMetier ClientUpdate = new ClientMetier(5,"Cobin","Jack",14,"rue du square",54720,"Lexy","France");

        ClientDAO.update(ClientUpdate);

        ClientTemp = ClientDAO.getById(ClientUpdate.getId());

        assertEquals(ClientUpdate, ClientTemp);

    }

    @Test
    public void testDelete() throws SQLException
    {
        ClientMetier ClientUnVerified = new ClientMetier(5,"Cobin","Jacque",14,"rue du square",54720,"Lexy","France");

        ClientDAO.create(ClientUnVerified);

        ClientDAO.delete(ClientUnVerified);

        assertFalse(ClientDAO.findAll().contains(ClientUnVerified));
    }

}
