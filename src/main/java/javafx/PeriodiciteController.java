package javafx;

import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Iterator;

public class PeriodiciteController {

    @FXML Button btnValider;
    @FXML TextField libelle;

    public void btnAbonnementClick(ActionEvent actionEvent) {
        HelloApplication.factory.getPeriodiciteDAO().create(new PeriodiciteMetier(0,libelle.getText()));
        HelloApplication.screenController.activate("menu");

        Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }
}
