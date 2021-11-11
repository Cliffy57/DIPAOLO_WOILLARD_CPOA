package javafx;

import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Iterator;

public class RevueController {
    @FXML
    Button btnValider;
    @FXML
    Button btnAnnuler;
    @FXML
    Button btnAjoutImage;
    @FXML
    TextField TextTitre;
    @FXML
    TextArea TextDescri;
    @FXML
    TextField TextTarif;
    @FXML
    ComboBox<PeriodiciteMetier> CbBoxPeriodicite;
    @FXML
    ImageView image;
    @FXML
    ComboBox<String> CbBoxImages;

    private RevueMetier revueNew;

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @FXML
    public void initialize() {
        Iterator<PeriodiciteMetier> iteratorC = Application.factory.getPeriodiciteDAO().findAll().iterator();
        while (iteratorC.hasNext()) {
            CbBoxPeriodicite.getItems().add(iteratorC.next());
        }
        CbBoxImages.setItems(Application.imageList);
        if (MenuController.choix == "modif") {
            TextTitre.setText(MenuController.revue.getTitre());
            TextDescri.setText(MenuController.revue.getDescription());
            TextTarif.setText(String.valueOf(MenuController.revue.getTarifNumero()));
            image.setImage(Application.imageController.findUrl(MenuController.revue.getVisuel()));
            CbBoxImages.getSelectionModel().select(MenuController.revue.getVisuel());
            CbBoxPeriodicite.getSelectionModel().select(Application.factory.getPeriodiciteDAO().getById(MenuController.revue.getIdPeriodicite()));
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) throws IOException {
        String erreur = "";
        boolean ok = true;
        if (this.TextTitre.getText() == "" || this.TextTitre.getText() == null) {
            erreur += "Le titre n'est pas saisie\n";
            ok = false;
        }
        if (this.TextDescri.getText() == "" || this.TextDescri.getText() == null) {
            erreur += "La description n'est pas saisie\n";
            ok = false;
        }
        if (this.TextTarif.getText() == "" || this.TextTarif.getText() == null) {
            erreur += "Le tarif n'est pas saisie\n";
            ok = false;
        }
        if (this.CbBoxImages.getSelectionModel().getSelectedIndex() == -1 || this.CbBoxImages.getValue() == null) {
            erreur += "Le visuel n'est pas saisie\n";
            ok = false;
        }
        if (this.CbBoxPeriodicite.getSelectionModel().getSelectedIndex() == -1 || this.CbBoxPeriodicite.getValue() == null) {
            erreur += "La périodicité n'est pas saisie\n";
            ok = false;
        }
        if (!isNumeric(this.TextTarif.getText())) {
            erreur += "le numéro de voie doit être une valeur numérique\n";
            ok = false;
        }
        if (this.TextDescri.getLength() > 400) {
            erreur += "La description ne doit pas dépasser les 400 caractères";
            ok = false;
        }
        if (ok) {
            if (MenuController.choix == "ajout") {
                revueNew = new RevueMetier(TextDescri.getText(),TextTitre.getText(),Float.parseFloat(TextTarif.getText()),CbBoxImages.getSelectionModel().getSelectedItem(),CbBoxPeriodicite.getSelectionModel().getSelectedItem().getId());
               if(!Application.factory.getRevueDAO().ifExist(revueNew))
               { Application.factory.getRevueDAO().create(revueNew);}
               else {
                   ok = false;
                   erreur = "Un doublon existe dans la base !";
               }
            }
            else if(MenuController.choix == "modif") {
                revueNew = new RevueMetier(MenuController.revue.getId(),MenuController.revue.getDescription(),MenuController.revue.getTitre(),MenuController.revue.getTarifNumero(),MenuController.revue.getVisuel(),MenuController.revue.getIdPeriodicite());
                revueNew.setTitre(TextTitre.getText());
                revueNew.setDescription(TextDescri.getText());
                revueNew.setTarifNumero(Float.parseFloat(TextTarif.getText()));
                revueNew.setVisuel(CbBoxImages.getSelectionModel().getSelectedItem());
                if (!Application.factory.getRevueDAO().ifExist(revueNew)) {
                    Application.factory.getRevueDAO().update(revueNew);
                } else {
                    ok = false;
                    erreur = "Un doublon existe dans la base !";
                }
            }
            if(ok){
                Iterator<RevueMetier> iterator = Application.factory.getRevueDAO().findAll().iterator();
                while (iterator.hasNext()) {
                    Application.listObservable.add(iterator.next());
                }
                Application.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
                Application.screenController.activate("menu");
                Application.screenController.removeScreen("revue");

            }

        }
        if (!ok) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur lors de la saisie");
            alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
            alert.setContentText(erreur);
            alert.showAndWait();
        }
    }

    public void btnAnnulerClick(ActionEvent actionEvent) throws IOException {

        Iterator<RevueMetier> iterator = Application.factory.getRevueDAO().findAll().iterator();
        while (iterator.hasNext()) {
            Application.listObservable.add(iterator.next());
        }
        Application.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
        Application.screenController.activate("menu");
        Application.screenController.removeScreen("revue");

    }

    public void ActionCbBoxImages(ActionEvent actionEvent) {
        if (CbBoxImages.getSelectionModel().getSelectedIndex() != -1) {
            image.setImage(Application.imageController.findUrl(CbBoxImages.getSelectionModel().getSelectedItem()));
        }
    }

    public void btnAjoutImageClick(ActionEvent actionEvent) {
    }
}
