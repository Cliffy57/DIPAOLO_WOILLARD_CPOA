package javafx;

import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
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

        Iterator<RevueMetier> iteratorR = HelloApplication.factory.getRevueDAO().findAll().iterator();
        while (iteratorC.hasNext()) {
            cboxClient.getItems().add(iteratorC.next());
        }

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
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) throws IOException {
        String erreur = "";
        if (this.cboxClient.getSelectionModel().getSelectedIndex() == -1 || this.cboxClient.getValue() == null){
            erreur+="Le client n'est pas saisie\n";
        }
        if (this.cboxRevue.getSelectionModel().getSelectedIndex() == -1 || this.cboxClient.getValue() == null){
            erreur+="Le client n'est pas saisie\n";
        }
        if(this.dateDebut.getValue() == null){
            erreur +="La date de debut n'est pas saisie\n";
        }
        if(this.dateFin.getValue() == null){
            erreur +="La date de fin n'est pas saisie\n";
        }
        try {
            int val = this.dateDebut.getValue().compareTo(this.dateFin.getValue());
            if(val>0) {
                erreur +="La date de fin doit etre superieur a la date de debut\n";
            };
        } catch (NullPointerException nullPointerException){

        }



        if(erreur =="") {
            if (MenuController.choix == "ajout") {
                HelloApplication.factory.getAbonnementDAO().create(new AbonnementMetier(dateDebut.getValue(), dateFin.getValue(), cboxClient.getSelectionModel().getSelectedItem().getId(), cboxRevue.getSelectionModel().getSelectedItem().getId()));
            } else if (MenuController.choix == "modif") {
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
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur lors de la saisie");
            alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
            alert.setContentText(erreur);
            alert.showAndWait();
        }
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
