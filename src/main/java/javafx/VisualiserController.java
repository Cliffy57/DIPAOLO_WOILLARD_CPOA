package javafx;

import dao.metier.AbonnementMetier;
import dao.metier.PeriodiciteMetier;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Iterator;

public class VisualiserController {

    @FXML TableView table;
    @FXML Label lbl_table;

    @FXML
    public void initialize() {
        lbl_table.setText(MenuController.table);
        if (MenuController.table == "abonnement")
        {
            TableColumn<AbonnementMetier,Integer> column1 = new TableColumn<>("id");
            TableColumn<AbonnementMetier,String> column2 = new TableColumn<>("datedebut");
            TableColumn<AbonnementMetier,String> column3 = new TableColumn<>("datefin");
            TableColumn<AbonnementMetier,Integer> column4 = new TableColumn<>("idclient");
            TableColumn<AbonnementMetier,Integer> column5 = new TableColumn<>("idrevue");
            table.getColumns().add(column1);
            table.getColumns().add(column2);
            table.getColumns().add(column3);
            table.getColumns().add(column4);
            table.getColumns().add(column5);


            Iterator<AbonnementMetier> iterator = HelloApplication.factory.getAbonnementDAO().findAll().iterator();
            while (iterator.hasNext()) {
                table.getItems().add(iterator.next());
            }

        }
        else if (MenuController.table == "abonnement")
        {

        }
        else if (MenuController.table == "periodicite")
        {
            TableColumn<PeriodiciteMetier,Integer> column1 = new TableColumn<>("id");
            TableColumn<PeriodiciteMetier,String> column2 = new TableColumn<>("libelle");
            table.getColumns().add(column1);
            table.getColumns().add(column2);


            Iterator<PeriodiciteMetier> iterator = HelloApplication.factory.getPeriodiciteDAO().findAll().iterator();
            while (iterator.hasNext()) {
                table.getItems().add(iterator.next());
            }
            table.getItems().add(new PeriodiciteMetier(97,"zea"));
        }
        else if (MenuController.table == "abonnement")
        {

        }
    }
}
