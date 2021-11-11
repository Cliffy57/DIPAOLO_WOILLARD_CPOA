package test;

import dao.metier.AbonnementMetier;
import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.fail;

public class TestAbonnement {
    public void testSetterLengthOK() {

        AbonnementMetier tested = new AbonnementMetier();
        try {
            tested.setId(1);


        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que l' Abonnement est bon !");
        }
        try {
            tested.setDateDebut(LocalDate.ofEpochDay(12-12-2021));

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que l' Abonnement est bon !");
        }
        try {

            tested.setDateFin(LocalDate.ofEpochDay(12-12-2021));

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que l' Abonnement est bon !");
        }
        try {

            tested.setIdClient(1);

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que l' Abonnement est bon !");
        }
        try {

            tested.setIdRevue(1);

        } catch (IllegalArgumentException iae) {
            fail("Le test échoue alors que l' Abonnement est bon !");
        }

    }

    @Test
    public void testSetterLengthNotOK() {
        AbonnementMetier tested = new AbonnementMetier();
        try {
            tested.setIdClient(0);
            fail("Le test n'échoue pas alors que l'Abonnement est incorrect !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setIdRevue(0);
            fail("Le test n'échoue pas alors que l'Abonnement est incorrect !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }

    }

    @Test
    public void testSetterLengthNotOKNull() {
        AbonnementMetier tested = new AbonnementMetier();
        try {
            tested.setDateFin(null);
            fail("Le test n'échoue pas alors que l'Abonnement est incorrect puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setId(0);
            fail("Le test n'échoue pas alors que l'Abonnement est incorrect puisque 0 !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setDateDebut(null);
            fail("Le test n'échoue pas alors que l'Abonnement' est incorrect puisque chaîne nulle !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setIdRevue(0);
            fail("Le test n'échoue pas alors que l'Abonnement est incorrect puisque 0 !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }
        try {
            tested.setIdClient(0);
            fail("Le test n'échoue pas alors que l'Abonnement est incorrect puisque 0 !");
        } catch (IllegalArgumentException iae) {
            // Nothing to say, JVM should be here !
        }


    }
}
