package HelloWorld;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String argv[]) throws Exception{
        ServerSocket ecoute = new ServerSocket(Integer.parseInt(argv[0]));;
        Socket socket = ecoute.accept();
        System.out.println("\n Le serveur recoit sur le port : "+ ecoute.getLocalPort());

        System.out.println(">>> Serveur pret !");
        while (true) {

            Socket soc_com = ecoute.accept();
            System.out.println("" + soc_com.getInetAddress());

            InetAddress origin = soc_com.getInetAddress();
            System.out.println("Connexion venant de :"+ origin.getHostName());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(soc_com.getInputStream())
            );
            PrintWriter out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc_com.getOutputStream())),true);

            String str = in.readLine();

            System.out.println("Message recu :" + str);
            out.println(str);
            in.close();
            out.close();
            soc_com.close();


        }


    }
}
