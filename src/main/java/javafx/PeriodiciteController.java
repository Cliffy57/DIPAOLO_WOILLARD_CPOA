package javafx;

import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Iterator;

public class PeriodiciteController {


    @FXML Button btnValider;
    @FXML Button btnAnnuler;
    @FXML TextField libelle;
    private PeriodiciteMetier periodiciteNew;
    @FXML
    public void initialize() {
        if (MenuController.choix == "modif") {
            libelle.setText(MenuController.periodicite.getLibelle());
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) throws IOException {
        if (MenuController.choix == "ajout") {
            HelloApplication.factory.getPeriodiciteDAO().create(new PeriodiciteMetier(libelle.getText()));
        }
        else if(MenuController.choix == "modif") {
            periodiciteNew = MenuController.periodicite;
            periodiciteNew.setLibelle(libelle.getText());
            HelloApplication.factory.getPeriodiciteDAO().update(periodiciteNew);
        }

        Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
        }
        HelloApplication.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("periodicite");


    }

    public void btnAnnulerClick(ActionEvent actionEvent) throws IOException {
       // libelle.setText("");
        HelloApplication.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("periodicite");

        Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
        }
    }
}
