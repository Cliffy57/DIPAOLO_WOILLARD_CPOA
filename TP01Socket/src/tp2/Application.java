package tp2;

import java.io.*;
import java.net.*;
import java.util.*;

class Application extends Thread {
    Socket client;

    Application(Socket client) throws SocketException {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in =
                    new ObjectInputStream(client.getInputStream());
            ObjectOutputStream out =
                    new ObjectOutputStream(client.getOutputStream());
            while (true) {
                out.writeObject(traiteRequete(in.readObject()));
                out.flush();
            }
        } catch (EOFException e3) {
            try {
                client.close();
            } catch (IOException e) {
                e3.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Object traiteRequete(Object requete) {
        if (requete instanceof Date) return new java.util.Date();
        else if (requete instanceof Carre) return ((Carre) requete).execute();
        else if (requete instanceof Somme) return ((Somme) requete).execute();
        else return null;

    }
}
