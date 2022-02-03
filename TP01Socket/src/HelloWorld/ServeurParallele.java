package HelloWorld;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurParallele {
    public static void main(String[] argv) throws IOException{
        ServerSocket ecoute = null;
        try{
            ecoute= new ServerSocket(Integer.parseInt(argv[0]));
        }catch (IOException e){
            System.err.println("Impossible d'ecouter sur le port indique");
            System.exit(1);
        }
        Socket client = null;
        while(true){
            try{
                client = ecoute.accept();
                Thread fils = new Thread(new Application(client));

                System.out.println("Thread"+fils.getName()+"cree");
                fils.start();
            }
            catch (IOException e){
                System.err.println("Erreur de creation de fils");
                System.exit(1);
            }
        }
    }

}
