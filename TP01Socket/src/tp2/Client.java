package tp2;
import java.io.*;
import java.net.*;
import java.sql.SQLOutput;
import java.util.*;
public class Client {
    public static  void main(String argv[]){
        try{
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

            out.writeObject((new Carre(2)));
            out.flush();

            //Resultat de carre
            System.out.println("Resultat du carre");
            System.out.flush();

            System.out.println(in.readObject());

            emission.close();
            out.flush();
        } catch (UnknownHostException e) {
            System.out.println("Erreur d'entree sortie"+e);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
