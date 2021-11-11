package javafx;

import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Iterator;

public class RevueController {
    @FXML Button btnValider;
    @FXML Button btnAnnuler;
    @FXML Button btnAjoutImage;
    @FXML TextField TextTitre;
    @FXML TextArea TextDescri;
    @FXML TextField TextTarif;
    @FXML ComboBox<PeriodiciteMetier> CbBoxPeriodicite;
    @FXML ImageView image;
    @FXML ComboBox<String> CbBoxImages;

    private RevueMetier revueNew;
    @FXML
    public void initialize() {
        Iterator<PeriodiciteMetier> iteratorC = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iteratorC.hasNext()) {
            CbBoxPeriodicite.getItems().add(iteratorC.next());
        }
        CbBoxImages.setItems(HelloApplication.imageList);
        if (MenuController.choix == "modif") {
            TextTitre.setText(MenuController.revue.getTitre());
            TextDescri.setText(MenuController.revue.getDescription());
            TextTarif.setText(String.valueOf(MenuController.revue.getTarifNumero()));
            image.setImage(HelloApplication.imageController.findUrl(MenuController.revue.getVisuel()));
            CbBoxImages.getSelectionModel().select(MenuController.revue.getVisuel());
            CbBoxPeriodicite.getSelectionModel().select(HelloApplication.factory.getPeriodiciteDAO().getById(MenuController.revue.getIdPeriodicite()));
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) {
        String erreur = "";
        boolean ok = true;
        if(this.TextTitre.getText() =="" || this.TextTitre.getText() == null)
        {
            erreur+="Le titre n'est pas saisie\n"; ok = false;
        }
        if(this.TextDescri.getText() =="" || this.TextDescri.getText() == null)
        {
            erreur+="La description n'est pas saisie\n"; ok = false;
        }
        if(this.TextTarif.getText() =="" || this.TextTarif.getText() == null)
        {
            erreur+="Le tarif n'est pas saisie\n"; ok = false;
        }
        if(this.CbBoxImages.getSelectionModel().getSelectedIndex() == -1 || this.CbBoxImages.getValue() == null)
        {
            erreur+="Le visuel n'est pas saisie\n"; ok = false;
        }
        if(this.CbBoxPeriodicite.getSelectionModel().getSelectedIndex() == -1 || this.CbBoxPeriodicite.getValue() == null)
        {
            erreur+="La périodicité n'est pas saisie\n"; ok = false;
        }
        if (!isNumeric(this.TextTarif.getText()))
        {
            erreur+= "le numéro de voie doit être une valeur numérique\n"; ok = false;
        }
        if (this.TextDescri.getLength() > 400){
            erreur+="La description ne doit pas dépasser les 400 caractères"; ok = false;
        }
        if(ok){
            if (MenuController.choix == "ajout") {
                revueNew = new RevueMetier(TextDescri.getText(),TextTitre.getText(),Float.parseFloat(TextTarif.getText()),CbBoxImages.getSelectionModel().getSelectedItem(),CbBoxPeriodicite.getSelectionModel().getSelectedItem().getId());
               if(!HelloApplication.factory.getRevueDAO().ifExist(revueNew))
               { HelloApplication.factory.getRevueDAO().create(revueNew);}
               else {
                   System.out.println("4");
                   ok = false;
                   erreur = "Un doublon existe dans la base !";
               }
            }
            else if(MenuController.choix == "modif") {
                revueNew = MenuController.revue;
                revueNew.setTitre(TextTitre.getText());
                revueNew.setDescription(TextDescri.getText());
                revueNew.setTarifNumero(Float.parseFloat(TextTarif.getText()));
                revueNew.setVisuel(CbBoxImages.getSelectionModel().getSelectedItem());
                if(!HelloApplication.factory.getRevueDAO().ifExist(revueNew)){
                HelloApplication.factory.getRevueDAO().update(revueNew);}
                else {
                    ok = false;
                    erreur = "Un doublon existe dans la base !";
                }
            }
            if(ok){
                HelloApplication.screenController.activate("menu");
                HelloApplication.screenController.removeScreen("revue");
                Iterator<RevueMetier> iterator = HelloApplication.factory.getRevueDAO().findAll().iterator();
                while (iterator.hasNext()) {
                    HelloApplication.listObservable.add(iterator.next());
                }
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

    public void btnAnnulerClick(ActionEvent actionEvent) {

        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("revue");
        Iterator<RevueMetier> iterator = HelloApplication.factory.getRevueDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
        }
    }

    public void ActionCbBoxImages(ActionEvent actionEvent) {
        if(CbBoxImages.getSelectionModel().getSelectedIndex() != -1)
        {
            image.setImage(HelloApplication.imageController.findUrl(CbBoxImages.getSelectionModel().getSelectedItem()));
        }
    }

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

    public void btnAjoutImageClick(ActionEvent actionEvent) {
    }
}
