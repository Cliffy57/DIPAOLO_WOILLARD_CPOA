package test;

import dao.metier.PeriodiciteMetier;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class TestPeriodicite {

    @Test
    public void testSetterLengthOK() {

        PeriodiciteMetier tested = new PeriodiciteMetier();
        try {
            tested.setLibelle("Jacob");
        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que la periodicite est bonne !");
        }

    }

    @Test
    public void testSetterLengthNotOK() {
        PeriodiciteMetier tested = new PeriodiciteMetier();
        try {
            tested.setLibelle("010978");
            fail("Le test n'échoue pas alors que la periodicite est incorrecte !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }

    }

    @Test
    public void testSetterLengthNotOKNull() {
        PeriodiciteMetier tested = new PeriodiciteMetier();
        try {
            tested.setLibelle(null);
            fail("Le test n'échoue pas alors que la periodicite est incorrecte puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }

    }

}
