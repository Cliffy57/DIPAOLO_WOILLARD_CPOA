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
    @FXML Button btnAnnuler;
    @FXML TextField libelle;

    @FXML
    public void initialize() {
        libelle.setText(MenuController.periodicite.getLibelle());
    }

    public void btnAbonnementClick(ActionEvent actionEvent) {
        HelloApplication.factory.getPeriodiciteDAO().create(new PeriodiciteMetier(libelle.getText()));
        HelloApplication.screenController.activate("menu");

        Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }

    public void btnAnnulerClick(ActionEvent actionEvent) {
       // libelle.setText("");
        HelloApplication.screenController.activate("menu");
        Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }
}
