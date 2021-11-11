package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    @SuppressWarnings("exports")
    public static Connection creeConnexion() {
        String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/dipaolo6u_cpoatdun";
        url += "?serverTimezone=Europe/Paris";
        String login = "dipaolo6u_appli";
        String pwd = "MmVay9SPfJ";
        Connection maConnexion = null;
        try {
            maConnexion = DriverManager.getConnection(url, login, pwd);
        } catch (SQLException sqle) {
            System.out.println("Erreur connexion" + sqle.getMessage());
        }
        return maConnexion;
    }

}
