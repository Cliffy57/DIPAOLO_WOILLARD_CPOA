package javafx;

import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.util.Iterator;

public class AbonnementController {

    @FXML ComboBox<ClientMetier> cboxClient;
    @FXML ComboBox<RevueMetier> cboxRevue;
    @FXML DatePicker dateDebut;
    @FXML DatePicker dateFin;
    @FXML Button btnValider;
    @FXML Button btnAnnuler;
    private AbonnementMetier abonnementNew;

    @FXML
    public void initialize() {
        //ObservableList<ClientMetier> listC = (ObservableList<ClientMetier>) HelloApplication.factory.getClientDAO().findAll();
        //cboxClient.setItems(listC);
        Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
        ObservableList<RevueMetier> listR = (ObservableList<RevueMetier>) HelloApplication.factory.getRevueDAO().findAll();
        cboxRevue.setItems(listR);
        if (MenuController.choix == "modif") {
            cboxClient.getSelectionModel().select(HelloApplication.factory.getClientDAO().getById(MenuController.abonnement.getIdClient()));
            cboxRevue.getSelectionModel().select(HelloApplication.factory.getRevueDAO().getById(MenuController.abonnement.getIdRevue()));
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) {
        if (MenuController.choix == "ajout") {
            HelloApplication.factory.getAbonnementDAO().create(new AbonnementMetier());
        }
        else if(MenuController.choix == "modif") {
            abonnementNew = MenuController.abonnement;

            HelloApplication.factory.getAbonnementDAO().update(abonnementNew);
        }

        HelloApplication.screenController.activate("menu");

        Iterator<AbonnementMetier> iterator = HelloApplication.factory.getAbonnementDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }

    public void btnAnnulerClick(ActionEvent actionEvent) {
        // libelle.setText("");
        HelloApplication.screenController.activate("menu");
        Iterator<AbonnementMetier> iterator = HelloApplication.factory.getAbonnementDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }
}
