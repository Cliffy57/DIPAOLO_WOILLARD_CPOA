package tp2;
import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {
    public static void main(String argv[]) throws IOException {
        ServerSocket ecoute = new ServerSocket(Integer.parseInt(argv[0]));
        System.out.println("Le serveur recoit sur le port: " + ecoute.getLocalPort());
        while (true)
            new Application(ecoute.accept()).start();
    }
}//Fin de la classe serveur


