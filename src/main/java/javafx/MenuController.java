package javafx;


import dao.Persistance;
import dao.factory.DAOFactory;
import dao.metier.AbonnementMetier;
import dao.metier.ClientMetier;
import dao.metier.PeriodiciteMetier;
import dao.metier.RevueMetier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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

    @FXML public ListView<String> list;
    private String table;



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
        list.setVisible(false);

        list.getItems().clear();
    }

    public void btnAjouterClick(ActionEvent actionEvent) {
        HelloApplication.screenController.activate("periodicite");
        list.getItems().clear();
    }
}
