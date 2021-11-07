package javafx;

import dao.metier.ClientMetier;

import dao.metier.PeriodiciteMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

import java.util.Iterator;

public class ClientController {

    @FXML Button btnValider;
    @FXML Button btnAnnuler;
    @FXML TextField textNom;
    @FXML TextField textPrenom;
    @FXML TextField textNumVoie;
    @FXML TextField textCodePostal;
    @FXML TextField textPays;
    @FXML TextField textRue;
    @FXML TextField textVille;

    private ClientMetier clientNew;
    @FXML
    public void initialize() {
        if (MenuController.choix == "modif") {
            textNom.setText(MenuController.client.getNom());
            textPrenom.setText(MenuController.client.getPrenom());
            textNumVoie.setText(String.valueOf(MenuController.client.getNoRue()));
            textCodePostal.setText(String.valueOf(MenuController.client.getCodePost()));
            textPays.setText(MenuController.client.getPays());
            textRue.setText(MenuController.client.getVoie());
            textVille.setText(MenuController.client.getVille());
        }

    }

    public void btnValiderClick(ActionEvent actionEvent) {
        if (MenuController.choix == "ajout") {
            HelloApplication.factory.getClientDAO().create(new ClientMetier(textNom.getText(),textPrenom.getText(),Integer.parseInt(textNumVoie.getText()),textRue.getText(),Integer.parseInt(textCodePostal.getText()),textVille.getText(),textPays.getText()));
        }
        else if(MenuController.choix == "modif") {
            clientNew = MenuController.client;
            clientNew.setNom(textNom.getText());
            clientNew.setPrenom(textPrenom.getText());
            clientNew.setNoRue(Integer.parseInt(textNumVoie.getText()));
            clientNew.setCodePost(Integer.parseInt(textCodePostal.getText()));
            clientNew.setPays(textPays.getText());
            clientNew.setVoie(textRue.getText());
            clientNew.setVille(textVille.getText());
            HelloApplication.factory.getClientDAO().update(clientNew);
        }

        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("client");

        Iterator<ClientMetier> iterator = HelloApplication.factory.getClientDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
        }
    }

    public void btnAnnulerClick(ActionEvent actionEvent) {

        HelloApplication.screenController.activate("menu");
        HelloApplication.screenController.removeScreen("client");

        Iterator<ClientMetier> iterator = HelloApplication.factory.getClientDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next());
        }
    }
}
