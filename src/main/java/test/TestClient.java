package test;

import dao.metier.ClientMetier;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class TestClient {
    public void testSetterLengthOK() {

        ClientMetier tested = new ClientMetier();
        try {
            tested.setNom("Gabriel");


        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que le Client est bon !");
        }
        try {
            tested.setPrenom("Delavaud");

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que le Client est bon !");
        }
        try {

            tested.setNoRue(12);

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que le Client est bon !");
        }
        try {

            tested.setVoie("rue du Square");

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que le Client est bon !");
        }
        try {

            tested.setCodePost(54720);

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que le Client est bon !");
        }
        try {

            tested.setVille("Lexy");

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que le Client est bon !");
        }
        try {

            tested.setPays("France");

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que le Client est bon !");
        }

    }

    @Test
    public void testSetterLengthNotOK() {
        ClientMetier tested = new ClientMetier();
        try {
            tested.setNom("010978");
            fail("Le test n'échoue pas alors que le Nom est incorrect !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setPrenom("01092");
            fail("Le test n'échoue pas alors que le prenom est incorrect !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setVille("01092");
            fail("Le test n'échoue pas alors que la ville est incorrecte !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setPays("01092");
            fail("Le test n'échoue pas alors que le pays est incorrect !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setVoie("01092");
            fail("Le test n'échoue pas alors que la voie est incorrecte !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }

    }

    @Test
    public void testSetterLengthNotOKNull() {
        ClientMetier tested = new ClientMetier();
        try {
            tested.setNom(null);
            fail("Le test n'échoue pas alors que le Client est incorrect puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setPrenom(null);
            fail("Le test n'échoue pas alors que le Client est incorrect puisque chaine nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setNoRue(0);
            fail("Le test n'échoue pas alors que le Client est incorrect puisque 0 !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setVoie(null);
            fail("Le test n'échoue pas alors que le Client est incorrect puisque chaime nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setCodePost(0);
            fail("Le test n'échoue pas alors que le Client est incorrect puisque 0 !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setVille(null);
            fail("Le test n'échoue pas alors que le Client est incorrect puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setPays(null);
            fail("Le test n'échoue pas alors que lle Client est incorrect puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }

    }
}
