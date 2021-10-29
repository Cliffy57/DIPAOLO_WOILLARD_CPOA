package javafx;

import dao.metier.ClientMetier;

import dao.metier.PeriodiciteMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Iterator;

public class ClientController {

    @FXML Button btnValider;
    @FXML Button btnAnnuler;

    private PeriodiciteMetier periodiciteNew;
    @FXML
    public void initialize() {
        if (MenuController.choix == "modif") {

        }

    }

    public void btnValiderClick(ActionEvent actionEvent) {
        if (MenuController.choix == "ajout") {
            HelloApplication.factory.getClientDAO().create(new ClientMetier(.getText()));
        }
        else if(MenuController.choix == "modif") {
            clientNew = MenuController.client;
            clientNew.set(.getText());
            HelloApplication.factory.getClientDAO().update(clientNew);
        }

        HelloApplication.screenController.activate("menu");

        Iterator<ClientMetier> iterator = HelloApplication.factory.getClientDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }

    public void btnAnnulerClick(ActionEvent actionEvent) {

        HelloApplication.screenController.activate("menu");
        Iterator<ClientMetier> iterator = HelloApplication.factory.getClientDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }
}
