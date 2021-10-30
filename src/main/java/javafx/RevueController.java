package javafx;

import dao.metier.RevueMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Iterator;

public class RevueController {
    @FXML Button btnValider;
    @FXML Button btnAnnuler;
    @FXML TextField TextTitre;
    @FXML TextField TextDescri;
    @FXML TextField TextTarif;

    private RevueMetier revueNew;
    @FXML
    public void initialize() {
        if (MenuController.choix == "modif") {
            TextTitre.setText(MenuController.revue.getTitre());
            TextDescri.setText(MenuController.revue.getDescription());
            TextTarif.setText(String.valueOf(MenuController.revue.getTarifNumero()));
            //TextVisuel.setText(MenuController.revue.getVisuel());
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) {
        if (MenuController.choix == "ajout") {
         //   HelloApplication.factory.getRevueDAO().create(new RevueMetier(TextTitre.getText(),TextDescri.getText(),TextTarif.getText()));
        }
        else if(MenuController.choix == "modif") {
            revueNew = MenuController.revue;
            revueNew.setTitre(TextTitre.getText());
            revueNew.setDescription(TextDescri.getText());
            revueNew.setTarifNumero(Float.parseFloat(TextTarif.getText()));
            //revueNew.setVisuel(TextVisuel.getText());
            HelloApplication.factory.getRevueDAO().update(revueNew);
        }

        HelloApplication.screenController.activate("menu");

        Iterator<RevueMetier> iterator = HelloApplication.factory.getRevueDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }

    public void btnAnnulerClick(ActionEvent actionEvent) {

        HelloApplication.screenController.activate("menu");
        Iterator<RevueMetier> iterator = HelloApplication.factory.getRevueDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
    }
}
