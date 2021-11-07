package javafx;

import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Iterator;

public class RevueController {
    @FXML Button btnValider;
    @FXML Button btnAnnuler;
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
        if (MenuController.choix == "ajout") {
            HelloApplication.factory.getRevueDAO().create(new RevueMetier(TextDescri.getText(),TextTitre.getText(),Float.parseFloat(TextTarif.getText()),CbBoxImages.getSelectionModel().getSelectedItem(),CbBoxPeriodicite.getSelectionModel().getSelectedItem().getId() ));
        }
        else if(MenuController.choix == "modif") {
            revueNew = MenuController.revue;
            revueNew.setTitre(TextTitre.getText());
            revueNew.setDescription(TextDescri.getText());
            revueNew.setTarifNumero(Float.parseFloat(TextTarif.getText()));
            revueNew.setVisuel(CbBoxImages.getSelectionModel().getSelectedItem());
            HelloApplication.factory.getRevueDAO().update(revueNew);
        }

        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("revue");

        Iterator<RevueMetier> iterator = HelloApplication.factory.getRevueDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
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
}
