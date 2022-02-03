package HelloWorld;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Application implements Runnable{
    Socket sock_com;
    Application (Socket sock_com) throws SocketException{
        this.sock_com = sock_com;
    }

    @Override
    public void run() {
        try{
            System.out.println("Adresse socket" + sock_com.getInetAddress());
            System.out.println("Connexion venant de"+ sock_com.getInetAddress().getHostName());

            BufferedReader in = new BufferedReader(new InputStreamReader(sock_com.getInputStream()));
            PrintWriter put = new PrintWriter(new BufferedWriter((new OutputStreamWriter(sock_com.getOutputStream()))));
        }catch (IOException e){
            System.out.println("Erreur E/S");
        }
    }
}
