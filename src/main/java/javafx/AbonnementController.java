package javafx;

import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.RevueMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.util.Iterator;

public class AbonnementController {

    @FXML
    ComboBox<ClientMetier> cboxClient;
    @FXML
    ComboBox<RevueMetier> cboxRevue;
    @FXML
    DatePicker dateDebut;
    @FXML
    DatePicker dateFin;
    @FXML
    Button btnValider;
    @FXML
    Button btnAnnuler;
    private AbonnementMetier abonnementNew;

    @FXML
    public void initialize() {
        Iterator<ClientMetier> iteratorC = Application.factory.getClientDAO().findAll().iterator();
        while (iteratorC.hasNext()) {
            cboxClient.getItems().add(iteratorC.next());
        }

        Iterator<RevueMetier> iteratorR = Application.factory.getRevueDAO().findAll().iterator();
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
            cboxClient.getSelectionModel().select(Application.factory.getClientDAO().getById(MenuController.abonnement.getIdClient()));
            cboxRevue.getSelectionModel().select(Application.factory.getRevueDAO().getById(MenuController.abonnement.getIdRevue()));
            dateDebut.setValue(MenuController.abonnement.getDateDebut());
            dateFin.setValue(MenuController.abonnement.getDateFin());
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) throws IOException {
        String erreur = "";
        boolean ok = true;
        if (this.cboxClient.getSelectionModel().getSelectedIndex() == -1 || this.cboxClient.getValue() == null){
            erreur+="Le client n'est pas saisie\n"; ok = false;
        }
        if (this.cboxRevue.getSelectionModel().getSelectedIndex() == -1 || this.cboxClient.getValue() == null){
            erreur+="Le client n'est pas saisie\n"; ok = false;
        }
        if(this.dateDebut.getValue() == null){
            erreur +="La date de debut n'est pas saisie\n"; ok = false;
        }
        if(this.dateFin.getValue() == null){
            erreur +="La date de fin n'est pas saisie\n"; ok = false;
        }
        try {
            int val = this.dateDebut.getValue().compareTo(this.dateFin.getValue());
            if(val>0) {
                erreur +="La date de fin doit etre superieur a la date de debut\n";
                ok = false;
            };

        } catch (NullPointerException nullPointerException){

        }

        if(ok) {
            if (MenuController.choix == "ajout") {
                abonnementNew = new AbonnementMetier(dateDebut.getValue(), dateFin.getValue(), cboxClient.getSelectionModel().getSelectedItem().getId(), cboxRevue.getSelectionModel().getSelectedItem().getId());
                if(!Application.factory.getAbonnementDAO().ifExist(abonnementNew)){
                    Application.factory.getAbonnementDAO().create(abonnementNew);
                }
                else {
                    ok = false;
                    erreur = "Un doublon existe dans la base !";
                }

            } else if (MenuController.choix == "modif") {
                abonnementNew = new AbonnementMetier(MenuController.abonnement.getId(),MenuController.abonnement.getDateDebut(),MenuController.abonnement.getDateFin(),MenuController.abonnement.getIdClient(),MenuController.abonnement.getIdRevue());
                abonnementNew.setDateDebut(dateDebut.getValue());
                abonnementNew.setDateFin(dateFin.getValue());
                abonnementNew.setIdClient(cboxClient.getSelectionModel().getSelectedItem().getId());
                abonnementNew.setIdRevue(cboxRevue.getSelectionModel().getSelectedItem().getId());
                if(!Application.factory.getAbonnementDAO().ifExist(abonnementNew)){
                    Application.factory.getAbonnementDAO().update(abonnementNew);
                }
                else {
                    ok = false;
                    erreur = "Un doublon existe dans la base !";
                }

            }
            if (ok){
            Iterator<AbonnementMetier> iterator = Application.factory.getAbonnementDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }
            Application.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
            Application.screenController.activate("menu");
            Application.screenController.removeScreen("abonnement");
        }
    }
        if(!ok) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur lors de la saisie");
            alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
            alert.setContentText(erreur);
            alert.showAndWait();
        }
    }

    public void btnAnnulerClick(ActionEvent actionEvent) throws IOException {
        Iterator<AbonnementMetier> iterator = Application.factory.getAbonnementDAO().findAll().iterator();
        while (iterator.hasNext()) {
            Application.listObservable.add(iterator.next());
        }
        Application.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
        Application.screenController.activate("menu");
        Application.screenController.removeScreen("abonnement");
    }
}
