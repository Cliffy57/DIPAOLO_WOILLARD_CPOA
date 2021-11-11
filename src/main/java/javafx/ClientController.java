package javafx;

import dao.metier.ClientMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Iterator;

public class ClientController {

    @FXML
    Button btnValider;
    @FXML
    Button btnAnnuler;
    @FXML
    TextField textNom;
    @FXML
    TextField textPrenom;
    @FXML
    TextField textNumVoie;
    @FXML
    TextField textCodePostal;
    @FXML
    TextField textPays;
    @FXML
    TextField textRue;
    @FXML
    TextField textVille;
    private ClientMetier clientNew;

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

    public void btnValiderClick(ActionEvent actionEvent) throws IOException {
        String erreur = "";
        if (this.textNom.getText() == null || this.textNom.getText() == "") {
            erreur += "Le nom n'est pas saisie\n";
        }
        if (this.textPrenom.getText() == null || this.textPrenom.getText() == "") {
            erreur += "Le prenom n'est pas saisie\n";
        }
        if (this.textNumVoie.getText() == null || this.textNumVoie.getText() == "") {
            erreur += "Le numéro de voie n'est pas saisie\n";
        }
        if (this.textCodePostal.getText() == null || this.textCodePostal.getText() == "") {
            erreur += "Le code postal n'est pas saisie\n";
        }
        if (this.textPays.getText() == null || this.textPrenom.getText() == "") {
            erreur += "Le pays n'est pas saisie\n";
        }
        if (this.textRue.getText() == null || this.textRue.getText() == "") {
            erreur += "La voie n'est pas saisie\n";
        }
        if (this.textVille.getText() == null || this.textVille.getText() == "") {
            erreur += "La ville n'est pas saisie\n";
        }
        if (!isNumeric(this.textNumVoie.getText())) {
            erreur += "le numéro de voie doit être une valeur numérique\n";
        }
        if (!isNumeric(this.textCodePostal.getText())) {
            erreur += "le code postal doit être une valeur numérique\n";
        }
        if (erreur == "") {
            if (MenuController.choix == "ajout") {
                HelloApplication.factory.getClientDAO().create(new ClientMetier(textNom.getText(), textPrenom.getText(), Integer.parseInt(textNumVoie.getText()), textRue.getText(), Integer.parseInt(textCodePostal.getText()), textVille.getText(), textPays.getText()));
            } else if (MenuController.choix == "modif") {
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

            Iterator<ClientMetier> iterator = HelloApplication.factory.getClientDAO().findAll().iterator();
            while (iterator.hasNext()) {
                HelloApplication.listObservable.add(iterator.next());
            }

            HelloApplication.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
            HelloApplication.screenController.activate("menu");
            HelloApplication.screenController.removeScreen("client");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur lors de la saisie");
            alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
            alert.setContentText(erreur);
            alert.showAndWait();
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
