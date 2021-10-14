package dao.launch;

import java.util.Iterator;
import java.util.Scanner;

import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.ClientMetier;

public class LaunchClient {

    public static void clientLaunchSQL() {
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
                System.out.println("Saisissez la valeur du nom\n");
                String nom = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du prenom\n");
                String prenom = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du numero de rue\n");
                int no_rue = scanner.nextInt();
                System.out.println("Saisissez la valeur de la voie\n");
                String voie = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du code postal\n");
                int codepost = scanner.nextInt();
                System.out.println("Saisissez la valeur de la ville\n");
                String ville = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du pays\n");
                String pays = scannerStr.next().trim();
                factory.getClientDAO().create(new ClientMetier(id, nom, prenom, no_rue, voie, codepost, ville, pays));
                clientLaunchSQL();
                break;
            case 2:

                System.out.println("Saisissez la valeur de l'ID a modifier\n");
                int newID = scanner.nextInt();
                System.out.println("Saisissez la valeur du nom\n");
                String Newnom = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du prenom\n");
                String Newprenom = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du numero de rue\n");
                int Newno_rue = scanner.nextInt();
                System.out.println("Saisissez la valeur de la voie\n");
                String Newvoie = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du code postal\n");
                int Newcodepost = scanner.nextInt();
                System.out.println("Saisissez la valeur de la ville\n");
                String Newville = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du pays\n");
                String Newpays = scannerStr.next().trim();
                factory.getClientDAO().update(
                        new ClientMetier(newID, Newnom, Newprenom, Newno_rue, Newvoie, Newcodepost, Newville, Newpays));
                clientLaunchSQL();
                break;
            case 3:

                System.out.println("Saisissez la valeur de l'ID a supprimer\n");
                int IDsuppr = scanner.nextInt();
                factory.getClientDAO().delete(factory.getClientDAO().getById(IDsuppr));
                clientLaunchSQL();
                break;

            case 4:
                Iterator<ClientMetier> iterator = factory.getClientDAO().findAll().iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                clientLaunchSQL();
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
                clientLaunchSQL();
                break;
        }
    }

    public static void clientLaunchListeMemoire() {

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
                System.out.println("Saisissez la valeur du nom\n");
                String nom = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du prenom\n");
                String prenom = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du numero de rue\n");
                int no_rue = scanner.nextInt();
                System.out.println("Saisissez la valeur de la voie\n");
                String voie = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du code postal\n");
                int codepost = scanner.nextInt();
                System.out.println("Saisissez la valeur de la ville\n");
                String ville = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du pays\n");
                String pays = scannerStr.next().trim();
                factory.getClientDAO().create(new ClientMetier(id, nom, prenom, no_rue, voie, codepost, ville, pays));
                clientLaunchListeMemoire();
                break;
            case 2:

                System.out.println("Saisissez la valeur de l'ID a modifier\n");
                int newID = scanner.nextInt();
                System.out.println("Saisissez la valeur du nom\n");
                String Newnom = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du prenom\n");
                String Newprenom = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du numero de rue\n");
                int Newno_rue = scanner.nextInt();
                System.out.println("Saisissez la valeur de la voie\n");
                String Newvoie = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du code postal\n");
                int Newcodepost = scanner.nextInt();
                System.out.println("Saisissez la valeur de la ville\n");
                String Newville = scannerStr.next().trim();
                System.out.println("Saisissez la valeur du pays\n");
                String Newpays = scannerStr.next().trim();
                factory.getClientDAO().update(
                        new ClientMetier(newID, Newnom, Newprenom, Newno_rue, Newvoie, Newcodepost, Newville, Newpays));
                clientLaunchListeMemoire();
                break;
            case 3:

                System.out.println("Saisissez la valeur de l'ID a supprimer\n");
                int IDsuppr = scanner.nextInt();
                factory.getClientDAO().delete(factory.getClientDAO().getById(IDsuppr));
                clientLaunchListeMemoire();
                break;

            case 4:
                Iterator<ClientMetier> iterator = factory.getClientDAO().findAll().iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                clientLaunchListeMemoire();
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
                clientLaunchListeMemoire();
                break;
        }
    }
}