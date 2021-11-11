package dao.launch;

import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.PeriodiciteMetier;

import java.util.Iterator;
import java.util.Scanner;

public class LaunchPeriodicite {

    public static void periodiciteLaunchSQL() {
        DAOFactory factory = DAOFactory.getDAOFactory(Persistance.MYSQL);
        System.out.println("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n"
                + "(4) Tout afficher\n" + "(5) Retour\n" + "(6) Choix SGBD\n" + "(7) Quitter\n");
        Scanner scannerStr = new Scanner(System.in).useDelimiter("\n");
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        switch (res) {
            case 1:
                System.out.println("Saisissez la valeur de l'ID\n");
                int id = scanner.nextInt();
                System.out.println("Saisissez la valeur du libelle\n");
                String libelle = scannerStr.next();
                factory.getPeriodiciteDAO().create(new PeriodiciteMetier(id, libelle));
                periodiciteLaunchSQL();
                break;
            case 2:

                System.out.println("Saisissez la valeur de l'ID a modifier\n");
                int newId = scanner.nextInt();
                System.out.println("Saisissez la valeur du libelle ID\n");
                String newLibelle = scannerStr.next();
                factory.getPeriodiciteDAO().update(new PeriodiciteMetier(newId, newLibelle));
                periodiciteLaunchSQL();
                break;
            case 3:

                System.out.println("Saisissez la valeur de l'ID a supprimer\n");
                int IDsuppr = scanner.nextInt();
                factory.getPeriodiciteDAO().delete(factory.getPeriodiciteDAO().getById(IDsuppr));
                periodiciteLaunchSQL();
                break;
            case 4:
                Iterator<PeriodiciteMetier> iterator = factory.getPeriodiciteDAO().findAll().iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                periodiciteLaunchSQL();
                break;
            case 5:
                LaunchMain.LaunchSQL();
                break;
            case 6:
                LaunchMain.ChoixSGBD();
                break;
            case 7:
                break;
            default:
                periodiciteLaunchSQL();
                break;
        }

    }

    public static void periodiciteLaunchListeMemoire() {

        DAOFactory factory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
        System.out.println("Voulez-vous :\n" + "(1) Ajouter\n" + "(2) Modifier\n" + "(3) Supprimer\n"
                + "(4) Tout afficher\n" + "(5) Retour\n" + "(6) Choix SGBD\n" + "(7) Quitter\n");
        Scanner scannerStr = new Scanner(System.in).useDelimiter("\n");
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        switch (res) {
            case 1:
                System.out.println("Saisissez la valeur de l'ID\n");
                int id = scanner.nextInt();
                System.out.println("Saisissez la valeur du libelle\n");
                String libelle = scannerStr.next();
                factory.getPeriodiciteDAO().create(new PeriodiciteMetier(id, libelle));
                periodiciteLaunchListeMemoire();
                break;
            case 2:

                System.out.println("Saisissez la valeur de l'ID a modifier\n");
                int newId = scanner.nextInt();
                System.out.println("Saisissez la valeur du libelle\n");
                String newLibelle = scannerStr.next();
                factory.getPeriodiciteDAO().update(new PeriodiciteMetier(newId, newLibelle));
                periodiciteLaunchListeMemoire();
                break;
            case 3:

                System.out.println("Saisissez la valeur de l'ID a supprimer\n");
                int IDsuppr = scanner.nextInt();
                factory.getPeriodiciteDAO().delete(factory.getPeriodiciteDAO().getById(IDsuppr));
                periodiciteLaunchListeMemoire();
                break;

            case 4:

                Iterator<PeriodiciteMetier> iterator = factory.getPeriodiciteDAO().findAll().iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                periodiciteLaunchListeMemoire();
                break;
            case 5:
                LaunchMain.LaunchListeMemoire();
                break;
            case 6:
                LaunchMain.ChoixSGBD();
                break;
            case 7:
                break;
            default:
                periodiciteLaunchListeMemoire();
                break;
        }
    }
}
