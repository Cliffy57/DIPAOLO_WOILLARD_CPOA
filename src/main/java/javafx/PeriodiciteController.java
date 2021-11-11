package javafx;

import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
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
        String erreur = "";
        boolean ok = true;
        if (libelle.getText() != null && libelle.getText() != "") {
          if (MenuController.choix == "ajout") {
              periodiciteNew= new PeriodiciteMetier(libelle.getText());
              if(!HelloApplication.factory.getPeriodiciteDAO().ifExist(periodiciteNew))
              {HelloApplication.factory.getPeriodiciteDAO().create(periodiciteNew);}
              else {
                  ok = false;
                  erreur ="Un doublon existe dans la base !";
              }

          } else if (MenuController.choix == "modif") {
              periodiciteNew = MenuController.periodicite;
              periodiciteNew.setLibelle(libelle.getText());
              if(!HelloApplication.factory.getPeriodiciteDAO().ifExist(periodiciteNew))
              {HelloApplication.factory.getPeriodiciteDAO().update(periodiciteNew);}
              else {
                  ok = false;
                  erreur ="Un doublon existe dans la base !";
              }

          }
            if(ok){
                Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
                while (iterator.hasNext()) {
                    HelloApplication.listObservable.add(iterator.next());
                }
                HelloApplication.screenController.activate("menu");
                HelloApplication.screenController.removeScreen("periodicite");
            }

      }
      else {
          ok =false;
          erreur +="Le libelle n'est pas saisie !";
      }
      if(!ok){

          Alert alert=new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Erreur lors de la saisie");
          alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
          alert.setContentText(erreur);
          alert.showAndWait();
      }

    }

    public void btnAnnulerClick(ActionEvent actionEvent) throws IOException {
        Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
        }
        HelloApplication.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("periodicite");
    }
}
