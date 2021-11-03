package javafx;


import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Iterator;

public class MenuController {
    @FXML Button btnAbonnement;
    @FXML Button btnRevue;
    @FXML Button btnPeriodicite;
    @FXML Button btnClient;
    @FXML Button btnImporter;
    @FXML Button btnSql;
    @FXML Button btnListeM;

    @FXML Button btnAjouter;
    @FXML Button btnModifier;
    @FXML Button btnSupprimer;
    @FXML Button btnVisualiser;
    @FXML Button btnRetour;

    @FXML ListView<String> list;
    public static String table;
    public static String choix;
    public static PeriodiciteMetier periodicite = new PeriodiciteMetier();
    public static AbonnementMetier abonnement = new AbonnementMetier();
    public static ClientMetier client = new ClientMetier();
    public static RevueMetier revue = new RevueMetier();



    public void btnListeMClick(ActionEvent actionEvent) throws IOException {
        btnAbonnement.setDisable(false);
        btnRevue.setDisable(false);
        btnPeriodicite.setDisable(false);
        btnClient.setDisable(false);
        btnImporter.setDisable(false);
        btnListeM.setDisable(true);
        btnSql.setDisable(false);
        HelloApplication.factory= DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
    }

    public void btnSqlClick(ActionEvent actionEvent) {
        btnAbonnement.setDisable(false);
        btnRevue.setDisable(false);
        btnPeriodicite.setDisable(false);
        btnClient.setDisable(false);
        btnImporter.setDisable(false);
        btnSql.setDisable(true);
        btnListeM.setDisable(false);
        HelloApplication.factory= DAOFactory.getDAOFactory(Persistance.MYSQL);

    }

    public void btnAbonnementClick(ActionEvent actionEvent) {
        btnAbonnement.setVisible(false);
        btnRevue.setVisible(false);
        btnPeriodicite.setVisible(false);
        btnClient.setVisible(false);
        btnImporter.setVisible(false);
        btnSql.setVisible(false);
        btnListeM.setVisible(false);
        btnAjouter.setVisible(true);
        btnModifier.setVisible(true);
        btnSupprimer.setVisible(true);
        btnVisualiser.setVisible(true);
        btnRetour.setVisible(true);
        list.setVisible(true);

        Iterator<AbonnementMetier> iterator = HelloApplication.factory.getAbonnementDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
        list.setItems(HelloApplication.listObservable);
        table = "abonnement";

    }

    public void btnRevueClick(ActionEvent actionEvent) {
        btnAbonnement.setVisible(false);
        btnRevue.setVisible(false);
        btnPeriodicite.setVisible(false);
        btnClient.setVisible(false);
        btnImporter.setVisible(false);
        btnSql.setVisible(false);
        btnListeM.setVisible(false);
        btnAjouter.setVisible(true);
        btnModifier.setVisible(true);
        btnSupprimer.setVisible(true);
        btnVisualiser.setVisible(true);
        btnRetour.setVisible(true);
        list.setVisible(true);

        Iterator<RevueMetier> iterator = HelloApplication.factory.getRevueDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
        list.setItems(HelloApplication.listObservable);
        table = "revue";
    }

    public void btnPeriodiciteClick(ActionEvent actionEvent) {
        btnAbonnement.setVisible(false);
        btnRevue.setVisible(false);
        btnPeriodicite.setVisible(false);
        btnClient.setVisible(false);
        btnImporter.setVisible(false);
        btnSql.setVisible(false);
        btnListeM.setVisible(false);
        btnAjouter.setVisible(true);
        btnModifier.setVisible(true);
        btnSupprimer.setVisible(true);
        btnVisualiser.setVisible(true);
        btnRetour.setVisible(true);
        list.setVisible(true);

        Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
        list.setItems(HelloApplication.listObservable);
        table = "periodicite";

    }

    public void btnClientClick(ActionEvent actionEvent) {
        btnAbonnement.setVisible(false);
        btnRevue.setVisible(false);
        btnPeriodicite.setVisible(false);
        btnClient.setVisible(false);
        btnImporter.setVisible(false);
        btnSql.setVisible(false);
        btnListeM.setVisible(false);
        btnAjouter.setVisible(true);
        btnModifier.setVisible(true);
        btnSupprimer.setVisible(true);
        btnVisualiser.setVisible(true);
        btnRetour.setVisible(true);
        list.setVisible(true);

        Iterator<ClientMetier> iterator = HelloApplication.factory.getClientDAO().findAll().iterator();
        while (iterator.hasNext()) {
            HelloApplication.listObservable.add(iterator.next().toString());
        }
        list.setItems(HelloApplication.listObservable);
        table = "client";
    }

    public void btnRetourClick(ActionEvent actionEvent) {
        btnAbonnement.setVisible(true);
        btnRevue.setVisible(true);
        btnPeriodicite.setVisible(true);
        btnClient.setVisible(true);
        btnImporter.setVisible(true);
        btnSql.setVisible(true);
        btnListeM.setVisible(true);
        btnAjouter.setVisible(false);
        btnModifier.setVisible(false);
        btnSupprimer.setVisible(false);
        btnVisualiser.setVisible(false);
        btnRetour.setVisible(false);
        btnModifier.setDisable(true);
        btnSupprimer.setDisable(true);
        btnVisualiser.setDisable(true);
        list.setVisible(false);

        list.getItems().clear();
    }

    public void btnAjouterClick(ActionEvent actionEvent) throws IOException {
        choix = "ajout";
        list.getItems().clear();
        btnModifier.setDisable(true);
        btnSupprimer.setDisable(true);
        btnVisualiser.setDisable(true);
        if (table == "periodicite") {
            HelloApplication.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutPeriodicite.fxml")));
            HelloApplication.screenController.activate(table);
        }
        else if (table == "abonnement") {
            HelloApplication.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutAbonnement.fxml")));
            HelloApplication.screenController.activate(table);
        }
        else if (table == "client") {
            HelloApplication.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutClient.fxml")));
            HelloApplication.screenController.activate(table);
        }
        else if (table == "revue") {
            HelloApplication.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutRevue.fxml")));
            HelloApplication.screenController.activate(table);
        }

    }

    public void listClick(MouseEvent mouseEvent) {
         if (list.getSelectionModel().getSelectedIndex() != -1) {
           btnModifier.setDisable(false);
           btnSupprimer.setDisable(false);
           btnVisualiser.setDisable(false);
         }
    }

    public void btnSupprimerClick(ActionEvent actionEvent) {
        String idString = list.getSelectionModel().getSelectedItem().toLowerCase();
        char idChar = idString.charAt(idString.indexOf("id") + 3);
        int id = Character.getNumericValue(idChar);

        if (table == "periodicite") {
            HelloApplication.factory.getPeriodiciteDAO().delete(HelloApplication.factory.getPeriodiciteDAO().getById(id));
            list.getItems().clear();
            Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
            while (iterator.hasNext()) {
                HelloApplication.listObservable.add(iterator.next().toString());
            }
        }
        if (table == "abonnement") {
            HelloApplication.factory.getAbonnementDAO().delete(HelloApplication.factory.getAbonnementDAO().getById(id));
            list.getItems().clear();
            Iterator<AbonnementMetier> iterator = HelloApplication.factory.getAbonnementDAO().findAll().iterator();
            while (iterator.hasNext()) {
                HelloApplication.listObservable.add(iterator.next().toString());
            }
        }
        if (table == "client") {
            HelloApplication.factory.getClientDAO().delete(HelloApplication.factory.getClientDAO().getById(id));
            list.getItems().clear();
            Iterator<ClientMetier> iterator = HelloApplication.factory.getClientDAO().findAll().iterator();
            while (iterator.hasNext()) {
                HelloApplication.listObservable.add(iterator.next().toString());
            }
        }
        if (table == "revue") {
            HelloApplication.factory.getRevueDAO().delete(HelloApplication.factory.getRevueDAO().getById(id));
            list.getItems().clear();
            Iterator<RevueMetier> iterator = HelloApplication.factory.getRevueDAO().findAll().iterator();
            while (iterator.hasNext()) {
                HelloApplication.listObservable.add(iterator.next().toString());
            }
        }
    }

    public void btnModifierClick(ActionEvent actionEvent) throws IOException {
        choix = "modif";
        String idString = list.getSelectionModel().getSelectedItem().toLowerCase();
        String ID = idString.substring(idString.indexOf("id=")+3,idString.indexOf(","));
        int id = Integer.parseInt(ID);
        System.out.println(id);

        if(table == "periodicite"){
            periodicite = HelloApplication.factory.getPeriodiciteDAO().getById(id);
            HelloApplication.screenController.addScreen(table,FXMLLoader.load(getClass().getResource("AjoutPeriodicite.fxml")));
            list.getItems().clear();
            btnModifier.setDisable(true);
            btnSupprimer.setDisable(true);
            btnVisualiser.setDisable(true);
            HelloApplication.screenController.activate(table);
        }
        else if(table == "abonnement"){
            abonnement = HelloApplication.factory.getAbonnementDAO().getById(id);
            System.out.println(HelloApplication.factory.getAbonnementDAO().getById(id));
            HelloApplication.screenController.addScreen(table,FXMLLoader.load(getClass().getResource("AjoutAbonnement.fxml")));
            list.getItems().clear();
            btnModifier.setDisable(true);
            btnSupprimer.setDisable(true);
            btnVisualiser.setDisable(true);
            HelloApplication.screenController.activate(table);
        }
        else if(table == "client"){
            client = HelloApplication.factory.getClientDAO().getById(id);
            HelloApplication.screenController.addScreen(table,FXMLLoader.load(getClass().getResource("AjoutClient.fxml")));
            list.getItems().clear();
            btnModifier.setDisable(true);
            btnSupprimer.setDisable(true);
            btnVisualiser.setDisable(true);
            HelloApplication.screenController.activate(table);
        }
        else if(table == "revue"){
            revue = HelloApplication.factory.getRevueDAO().getById(id);
            HelloApplication.screenController.addScreen(table,FXMLLoader.load(getClass().getResource("AjoutRevue.fxml")));
            list.getItems().clear();
            btnModifier.setDisable(true);
            btnSupprimer.setDisable(true);
            btnVisualiser.setDisable(true);
            HelloApplication.screenController.activate(table);
        }
    }

    public void btnVisualiserClick(ActionEvent actionEvent) throws IOException {
        HelloApplication.screenController.addScreen("visualiser",FXMLLoader.load(getClass().getResource("Visualiser.fxml")));
        HelloApplication.screenController.activate("visualiser");
    }
}
