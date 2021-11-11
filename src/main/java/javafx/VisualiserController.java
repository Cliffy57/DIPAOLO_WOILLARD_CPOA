package javafx;

import dao.metier.AbonnementMetier;
import dao.metier.PeriodiciteMetier;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Iterator;

public class VisualiserController {

    @FXML
    TableView table;
    @FXML
    Label lbl_table;

    @FXML
    public void initialize() {
        lbl_table.setText(MenuController.table);
        if (MenuController.table == "abonnement") {
            TableColumn<AbonnementMetier, Integer> column1 = new TableColumn<>("id");
            TableColumn<AbonnementMetier, String> column2 = new TableColumn<>("datedebut");
            TableColumn<AbonnementMetier, String> column3 = new TableColumn<>("datefin");
            TableColumn<AbonnementMetier, Integer> column4 = new TableColumn<>("idclient");
            TableColumn<AbonnementMetier, Integer> column5 = new TableColumn<>("idrevue");
            table.getColumns().add(column1);
            table.getColumns().add(column2);
            table.getColumns().add(column3);
            table.getColumns().add(column4);
            table.getColumns().add(column5);


            Iterator<AbonnementMetier> iterator = Application.factory.getAbonnementDAO().findAll().iterator();
            while (iterator.hasNext()) {
                table.getItems().add(iterator.next());
            }

        } else if (MenuController.table == "client") {

        } else if (MenuController.table == "periodicite") {
            TableColumn<PeriodiciteMetier, Integer> column1 = new TableColumn<>("id");
            TableColumn<PeriodiciteMetier, String> column2 = new TableColumn<>("Libelle");
            column1.setCellValueFactory(new PropertyValueFactory<>("id"));
            column2.setCellValueFactory(new PropertyValueFactory<>("libelle"));
            table.getColumns().add(column1);
            table.getColumns().add(column2);
            this.table.getItems().addAll(Application.factory.getPeriodiciteDAO().findAll());
        } else if (MenuController.table == "revue") {

        }
    }
}
