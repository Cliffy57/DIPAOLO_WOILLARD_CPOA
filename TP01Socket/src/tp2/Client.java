package tp2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] argv) {
        try {
            Socket emission = new Socket(argv[0], Integer.parseInt(argv[1]));
            //Sys out flush
            ObjectOutputStream out =
                    new ObjectOutputStream(emission.getOutputStream());
            ObjectInputStream in =
                    new ObjectInputStream(emission.getInputStream());

            System.out.println("Connexion etablie");

            //Demande date
            System.out.println("Demande de la date");
            out.writeObject(new Date());
            out.flush();
            System.out.println(in.readObject());
            System.out.flush();

            //Calcul du carre
            System.out.println("Calcul du carre");
            System.out.flush();

            out.writeObject((new Carre(3)));
            out.flush();

            //Resultat de carre
            System.out.println("Resultat du carre");
            System.out.flush();

            System.out.println(in.readObject());

            //Calcul de la somme
            System.out.println("Calcul de la somme");
            System.out.flush();

            out.writeObject((new Somme(32)));
            out.flush();

            //Resultat de la somme
            System.out.println("Resultat de la somme");
            System.out.flush();


            System.out.println(in.readObject());

            //Calcul de la factorielle
            System.out.println("Calcul de la factoriel");
            System.out.flush();

            out.writeObject((new Factoriel(5)));
            out.flush();

            //Resultat de la factorielle
            System.out.println("Resultat de la factoriel");
            System.out.flush();


            System.out.println(in.readObject());

            emission.close();
            out.flush();
        } catch (UnknownHostException e) {
            System.out.println("Erreur d'entree sortie" + e);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
