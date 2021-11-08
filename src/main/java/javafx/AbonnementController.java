package javafx;

import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        Iterator<ClientMetier> iteratorC = HelloApplication.factory.getClientDAO().findAll().iterator();
        while (iteratorC.hasNext()) {
            cboxClient.getItems().add(iteratorC.next());
        }
        ObservableList<ClientMetier> listC = (ObservableList<ClientMetier>) HelloApplication.factory.getClientDAO().findAll();
        cboxClient.setItems(listC);

        Iterator<RevueMetier> iteratorR = HelloApplication.factory.getRevueDAO().findAll().iterator();
        while (iteratorC.hasNext()) {
            cboxClient.getItems().add(iteratorC.next());
        }
        ObservableList<RevueMetier> listR = (ObservableList<RevueMetier>) HelloApplication.factory.getRevueDAO().findAll();
        cboxRevue.setItems(listR);

        while (iteratorC.hasNext()) {
            cboxClient.getItems().add(iteratorC.next());
        }
        while (iteratorR.hasNext()) {
            cboxRevue.getItems().add(iteratorR.next());
        }
        if (MenuController.choix == "modif") {
            cboxClient.getSelectionModel().select(HelloApplication.factory.getClientDAO().getById(MenuController.abonnement.getIdClient()));
            cboxRevue.getSelectionModel().select(HelloApplication.factory.getRevueDAO().getById(MenuController.abonnement.getIdRevue()));
            dateDebut.setValue(MenuController.abonnement.getDateDebut());
            dateFin.setValue(MenuController.abonnement.getDateFin());
            System.out.println(MenuController.abonnement.getIdClient());
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) throws IOException {
        if (MenuController.choix == "ajout") {
            HelloApplication.factory.getAbonnementDAO().create(new AbonnementMetier(dateDebut.getValue(),dateFin.getValue(),cboxClient.getSelectionModel().getSelectedItem().getId(),cboxRevue.getSelectionModel().getSelectedItem().getId()));
        }
        else if(MenuController.choix == "modif") {
            abonnementNew = MenuController.abonnement;
            abonnementNew.setDateDebut(dateDebut.getValue());
            abonnementNew.setDateFin(dateFin.getValue());
            abonnementNew.setIdClient(cboxClient.getSelectionModel().getSelectedItem().getId());
            abonnementNew.setIdRevue(cboxRevue.getSelectionModel().getSelectedItem().getId());
            HelloApplication.factory.getAbonnementDAO().update(abonnementNew);
        }

        Iterator<AbonnementMetier> iterator = HelloApplication.factory.getAbonnementDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
        }
        HelloApplication.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("abonnement");
    }

    public void btnAnnulerClick(ActionEvent actionEvent) throws IOException {
        Iterator<AbonnementMetier> iterator = HelloApplication.factory.getAbonnementDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
        }
        HelloApplication.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("abonnement");
    }
}
