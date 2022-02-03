package HelloWorld;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String argv[]) throws Exception{
        Socket emission = new Socket(argv[0],Integer.parseInt(argv[1]));

        System.out.println("Socket ="+emission);
        System.out.println("Socket de connexion:"+ emission.getLocalPort());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(emission.getInputStream())
        );

        PrintWriter out = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(emission.getOutputStream())
        ),true);

        String str = "Hello-World";
        out.println(str);

        str = in.readLine();
        System.out.println(str);

        out.close();
        in.close();
        emission.close();

    }
}
