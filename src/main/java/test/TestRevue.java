package test;


import dao.metier.RevueMetier;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class TestRevue {
    @Test
    public void testSetterLengthOK() {

        RevueMetier tested = new RevueMetier();
        try {
            tested.setVisuel("Visuel");


        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que la Revue est bonne !");
        }
        try {
            tested.setIdPeriodicite(2);

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que la Revue est bonne !");
        }
        try {

            tested.setTarifNumero(1);

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que la Revue est bonne !");
        }
        try {

            tested.setTitre("Titre");

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que la Revue est bonne !");
        }
        try {

            tested.setDescription("Description");

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que la Revue est bonne !");
        }

    }

    @Test
    public void testSetterLengthNotOK() {
        RevueMetier tested = new RevueMetier();
        try {
            tested.setVisuel("010978");
            fail("Le test n'échoue pas alors que la Revue est incorrecte !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setTitre("01092");
            fail("Le test n'échoue pas alors que la Revue est incorrecte !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }

    }

    @Test
    public void testSetterLengthNotOKNull() {
        RevueMetier tested = new RevueMetier();
        try {
            tested.setVisuel(null);
            fail("Le test n'échoue pas alors que la Revue est incorrecte puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setId(0);
            fail("Le test n'échoue pas alors que la Revue est incorrecte puisque 0 !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setDescription(null);
            fail("Le test n'échoue pas alors que la Revue est incorrecte puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setIdPeriodicite(0);
            fail("Le test n'échoue pas alors que la Revue est incorrecte puisque 0 !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setTarifNumero(0);
            fail("Le test n'échoue pas alors que la Revue est incorrecte puisque 0 !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setTitre(null);
            fail("Le test n'échoue pas alors que la Revue est incorrecte puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }

    }
}
