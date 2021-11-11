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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import normalisation.normalisationCodePost;
import normalisation.normalisationVille;
import normalisation.normalisationVoie;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;

public class MenuController {
    private static final FileChooser fileChooser = new FileChooser();
    public static String table;
    public static String choix;
    public static PeriodiciteMetier periodicite = new PeriodiciteMetier();
    public static AbonnementMetier abonnement = new AbonnementMetier();
    public static ClientMetier client = new ClientMetier();
    public static RevueMetier revue = new RevueMetier();
    public static HashMap<String, TableColumn> PeriodiciteColonne = new HashMap<>();
    public static HashMap<String, TableColumn> AbonnementColonne = new HashMap<>();
    public static HashMap<String, TableColumn> ClientColonne = new HashMap<>();
    public static HashMap<String, TableColumn> RevueColonne = new HashMap<>();
    public static String persistance;
    private static String instance;
    @FXML
    TableColumn columnId;
    @FXML
    Button btnAbonnement;
    @FXML
    Button btnRevue;
    @FXML
    Button btnPeriodicite;
    @FXML
    Button btnClient;
    @FXML
    Button btnImporter;
    @FXML
    Button btnSql;
    @FXML
    Button btnListeM;
    @FXML
    Button btnAjouter;
    @FXML
    Button btnModifier;
    @FXML
    Button btnSupprimer;
    @FXML
    Button btnVisualiser;
    @FXML
    Button btnRetour;
    @FXML
    TableView tableVue;

    @FXML
    public void initialize() throws IOException {

        if (instance == "LM") {
            btnListeMClick();
        } else if (instance == "SQL") {
            btnSqlClick();
        }
        if (table != null) {
            columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            moveToAction();
            if (table == "periodicite") {
                tableVue.getColumns().addAll(PeriodiciteColonne.values());
            } else if (table == "client") {
                tableVue.getColumns().addAll(ClientColonne.values());
            } else if (table == "abonnement") {
                tableVue.getColumns().addAll(AbonnementColonne.values());
            } else if (table == "revue") {
                tableVue.getColumns().addAll(RevueColonne.values());
            }
        }
        tableVue.getItems().addAll(Application.listObservable);

    }

    public void moveToAction() {
        btnAbonnement.setVisible(false);
        btnRevue.setVisible(false);
        btnPeriodicite.setVisible(false);
        btnClient.setVisible(false);
        btnImporter.setVisible(true);
        btnSql.setVisible(false);
        btnListeM.setVisible(false);
        btnAjouter.setVisible(true);
        btnModifier.setVisible(true);
        btnSupprimer.setVisible(true);
        btnVisualiser.setVisible(true);
        btnRetour.setVisible(true);
        tableVue.setVisible(true);
    }

    public void moveToChoixTable() {
        btnAbonnement.setVisible(true);
        btnRevue.setVisible(true);
        btnPeriodicite.setVisible(true);
        btnClient.setVisible(true);
        btnImporter.setVisible(false);
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
        tableVue.setVisible(false);
    }

    public void btnListeMClick() throws IOException {
        btnAbonnement.setDisable(false);
        btnRevue.setDisable(false);
        btnPeriodicite.setDisable(false);
        btnClient.setDisable(false);
        btnListeM.setDisable(true);
        btnSql.setDisable(false);
        instance = "LM";
        Application.factory = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
    }

    public void btnSqlClick() {
        btnAbonnement.setDisable(false);
        btnRevue.setDisable(false);
        btnPeriodicite.setDisable(false);
        btnClient.setDisable(false);
        btnImporter.setDisable(false);
        btnSql.setDisable(true);
        btnListeM.setDisable(false);
        instance = "SQL";
        Application.factory = DAOFactory.getDAOFactory(Persistance.MYSQL);

    }

    public void btnAbonnementClick(ActionEvent actionEvent) {

        moveToAction();
        TableColumn<PeriodiciteMetier, LocalDate> column2 = new TableColumn<>("DateDebut");
        TableColumn<PeriodiciteMetier, LocalDate> column3 = new TableColumn<>("DateFin");
        TableColumn<PeriodiciteMetier, Integer> column4 = new TableColumn<>("IDClient");
        TableColumn<PeriodiciteMetier, Integer> column5 = new TableColumn<>("IDRevue");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        column3.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        column4.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        column5.setCellValueFactory(new PropertyValueFactory<>("idRevue"));
        AbonnementColonne.put("2", column2);
        AbonnementColonne.put("3", column3);
        AbonnementColonne.put("4", column4);
        AbonnementColonne.put("5", column5);
        tableVue.getColumns().addAll(AbonnementColonne.values());
        Iterator<AbonnementMetier> iterator = Application.factory.getAbonnementDAO().findAll().iterator();
        while (iterator.hasNext()) {
            Application.listObservable.add(iterator.next());
        }

        this.tableVue.getItems().addAll(Application.listObservable);
        table = "abonnement";

    }

    public void btnRevueClick(ActionEvent actionEvent) {
        moveToAction();

        TableColumn<RevueMetier, String> column2 = new TableColumn<>("titre");
        TableColumn<RevueMetier, String> column3 = new TableColumn<>("description");
        TableColumn<RevueMetier, Float> column4 = new TableColumn<>("tarifNumero");
        TableColumn<RevueMetier, String> column5 = new TableColumn<>("visuel");
        TableColumn<RevueMetier, Integer> column6 = new TableColumn<>("idPeriodicite");

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("titre"));
        column3.setCellValueFactory(new PropertyValueFactory<>("description"));
        column4.setCellValueFactory(new PropertyValueFactory<>("tarifNumero"));
        column5.setCellValueFactory(new PropertyValueFactory<>("visuel"));
        column6.setCellValueFactory(new PropertyValueFactory<>("idPeriodicite"));
        RevueColonne.put("2", column2);
        RevueColonne.put("3", column3);
        RevueColonne.put("4", column4);
        RevueColonne.put("5", column5);
        RevueColonne.put("6", column6);
        tableVue.getColumns().addAll(RevueColonne.values());
        Iterator<RevueMetier> iterator = Application.factory.getRevueDAO().findAll().iterator();
        while (iterator.hasNext()) {
            Application.listObservable.add(iterator.next());
        }

        this.tableVue.getItems().addAll(Application.listObservable);
        table = "revue";
    }

    public void btnPeriodiciteClick(ActionEvent actionEvent) {
        moveToAction();

        TableColumn<PeriodiciteMetier, String> column2 = new TableColumn<>("Libelle");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        PeriodiciteColonne.put("2", column2);
        tableVue.getColumns().addAll(PeriodiciteColonne.values());

        Iterator<PeriodiciteMetier> iterator = Application.factory.getPeriodiciteDAO().findAll().iterator();
        while (iterator.hasNext()) {
            Application.listObservable.add(iterator.next());
        }

        this.tableVue.getItems().addAll(Application.listObservable);
        table = "periodicite";

    }

    public void btnClientClick(ActionEvent actionEvent) {
        moveToAction();

        TableColumn<RevueMetier, String> column2 = new TableColumn<>("nom");
        TableColumn<RevueMetier, String> column3 = new TableColumn<>("prenom");
        TableColumn<RevueMetier, Integer> column4 = new TableColumn<>("noRue");
        TableColumn<RevueMetier, String> column5 = new TableColumn<>("voie");
        TableColumn<RevueMetier, Integer> column6 = new TableColumn<>("codePost");
        TableColumn<RevueMetier, String> column7 = new TableColumn<>("ville");
        TableColumn<RevueMetier, String> column8 = new TableColumn<>("pays");

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        column3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        column4.setCellValueFactory(new PropertyValueFactory<>("noRue"));
        column5.setCellValueFactory(new PropertyValueFactory<>("voie"));
        column6.setCellValueFactory(new PropertyValueFactory<>("codePost"));
        column7.setCellValueFactory(new PropertyValueFactory<>("ville"));
        column8.setCellValueFactory(new PropertyValueFactory<>("pays"));
        ClientColonne.put("2", column2);
        ClientColonne.put("3", column3);
        ClientColonne.put("4", column4);
        ClientColonne.put("5", column5);
        ClientColonne.put("6", column6);
        ClientColonne.put("7", column7);
        ClientColonne.put("8", column8);
        tableVue.getColumns().addAll(ClientColonne.values());
        Iterator<ClientMetier> iterator = Application.factory.getClientDAO().findAll().iterator();
        while (iterator.hasNext()) {
            Application.listObservable.add(iterator.next());
        }

        this.tableVue.getItems().addAll(Application.listObservable);
        table = "client";
    }

    public void btnRetourClick(ActionEvent actionEvent) {
        moveToChoixTable();

        Application.listObservable.clear();
        tableVue.getItems().clear();
        if (table == "periodicite") {
            tableVue.getColumns().removeAll(PeriodiciteColonne.values());
        } else if (table == "client") {
            tableVue.getColumns().removeAll(ClientColonne.values());
        } else if (table == "abonnement") {
            tableVue.getColumns().removeAll(AbonnementColonne.values());
        } else if (table == "revue") {
            tableVue.getColumns().removeAll(RevueColonne.values());
        }


    }

    public void btnAjouterClick(ActionEvent actionEvent) throws IOException {
        choix = "ajout";
        tableVue.getItems().clear();
        btnModifier.setDisable(true);
        btnSupprimer.setDisable(true);
        btnVisualiser.setDisable(true);
        Application.listObservable.clear();
        if (table == "periodicite") {
            Application.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutPeriodicite.fxml")));
            Application.screenController.activate(table);
        } else if (table == "abonnement") {
            Application.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutAbonnement.fxml")));
            Application.screenController.activate(table);
        } else if (table == "client") {
            Application.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutClient.fxml")));
            Application.screenController.activate(table);
        } else if (table == "revue") {
            Application.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutRevue.fxml")));
            Application.screenController.activate(table);
        }

    }

    public void tableClick(MouseEvent mouseEvent) {
        if (tableVue.getSelectionModel().getSelectedIndex() != -1) {
            btnModifier.setDisable(false);
            btnSupprimer.setDisable(false);
            btnVisualiser.setDisable(false);

        }
    }

    public void btnInsertionClick() throws IOException {
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(btnImporter.getScene().getWindow());
        insertCSV(file.getPath());
        tableVue.getItems().clear();
        Application.listObservable.clear();

        if (table == "periodicite") {
            Iterator<PeriodiciteMetier> iterator = Application.factory.getPeriodiciteDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }
        } else if (table == "abonnement") {
            Iterator<AbonnementMetier> iterator = Application.factory.getAbonnementDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }
        } else if (table == "client") {
            Iterator<ClientMetier> iterator = Application.factory.getClientDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }
        } else if (table == "revue") {
            Iterator<RevueMetier> iterator = Application.factory.getRevueDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }
        }
        this.tableVue.getItems().addAll(Application.listObservable);
    }

    public void insertCSV(String path) {

        String CsvFile = path;
        String FieldDelimiter = ";";
        BufferedReader br;
        if (table == "periodicite") {
            try {
                br = new BufferedReader(new FileReader(CsvFile));

                String line;


                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(FieldDelimiter, -1);
                    PeriodiciteMetier periodiciteNew = new PeriodiciteMetier(fields[0]); //1
                    if (!Application.factory.getPeriodiciteDAO().ifExist(periodiciteNew)) {
                        Application.factory.getPeriodiciteDAO().create(periodiciteNew);
                    }

                }

            } catch (FileNotFoundException ex) {
                System.out.println("erreur csv");
            } catch (IOException ex) {
                System.out.println("erreur csv");
            }
        } else if (table == "abonnement") {
            try {
                br = new BufferedReader(new FileReader(CsvFile));

                String line;
                DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(FieldDelimiter, -1);
                    AbonnementMetier abonnementNew = new AbonnementMetier(LocalDate.parse(fields[0], formatage), LocalDate.parse(fields[1], formatage), Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
                    if (!Application.factory.getAbonnementDAO().ifExist(abonnementNew)) {
                        Application.factory.getAbonnementDAO().create(abonnementNew);
                    }
                }

            } catch (FileNotFoundException ex) {
                System.out.println("erreur csv");
            } catch (IOException ex) {
                System.out.println("erreur csv");
            }
        } else if (table == "client") {
            try {
                br = new BufferedReader(new FileReader(CsvFile));

                String line;

                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(FieldDelimiter, -1);
                    ClientMetier clientNew = new ClientMetier(fields[0], fields[1], Integer.parseInt(fields[2]), normalisationVoie.normalisation(fields[3]), Integer.parseInt(normalisationCodePost.normalisation(fields[4])), normalisationVille.normalisation(fields[5]), normalisationVille.normalisation(fields[6]));
                    if (!Application.factory.getClientDAO().ifExist(clientNew)) {
                        Application.factory.getClientDAO().create(clientNew);
                    }
                }

            } catch (FileNotFoundException ex) {
                System.out.println("erreur csv");
            } catch (IOException ex) {
                System.out.println("erreur csv");
            }
        } else if (table == "revue") {
            try {
                br = new BufferedReader(new FileReader(CsvFile));

                String line;

                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(FieldDelimiter, -1);
                    RevueMetier revueNew = new RevueMetier(fields[0], fields[1], Float.parseFloat(fields[2]), fields[3], Integer.parseInt(fields[4]));
                    if (!Application.factory.getRevueDAO().ifExist(revueNew)) {
                        Application.factory.getRevueDAO().create(revueNew);
                    }
                }

            } catch (FileNotFoundException ex) {
                System.out.println("erreur csv");
            } catch (IOException ex) {
                System.out.println("erreur csv");
            }
        }


    }

    public void btnSupprimerClick(ActionEvent actionEvent) {
        TablePosition pos = (TablePosition) tableVue.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        int id = (Integer) columnId.getCellObservableValue(tableVue.getItems().get(row)).getValue();
        Application.listObservable.clear();
        if (table == "periodicite") {
            Application.factory.getPeriodiciteDAO().delete(Application.factory.getPeriodiciteDAO().getById(id));
            tableVue.getItems().clear();
            Iterator<PeriodiciteMetier> iterator = Application.factory.getPeriodiciteDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }

        }
        if (table == "abonnement") {
            Application.factory.getAbonnementDAO().delete(Application.factory.getAbonnementDAO().getById(id));
            tableVue.getItems().clear();
            Iterator<AbonnementMetier> iterator = Application.factory.getAbonnementDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }

        }
        if (table == "client") {
            Application.factory.getClientDAO().delete(Application.factory.getClientDAO().getById(id));
            tableVue.getItems().clear();
            Iterator<ClientMetier> iterator = Application.factory.getClientDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }
        }
        if (table == "revue") {
            Application.factory.getRevueDAO().delete(Application.factory.getRevueDAO().getById(id));
            tableVue.getItems().clear();
            Iterator<RevueMetier> iterator = Application.factory.getRevueDAO().findAll().iterator();
            while (iterator.hasNext()) {
                Application.listObservable.add(iterator.next());
            }
        }
        tableVue.getItems().addAll(Application.listObservable);
    }

    public void btnModifierClick(ActionEvent actionEvent) throws IOException {
        choix = "modif";
        TablePosition pos = (TablePosition) tableVue.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        int id = (Integer) columnId.getCellObservableValue(tableVue.getItems().get(row)).getValue();
        Application.listObservable.clear();

        if (table == "periodicite") {
            periodicite = Application.factory.getPeriodiciteDAO().getById(id);
            Application.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutPeriodicite.fxml")));
            tableVue.getItems().clear();
            btnModifier.setDisable(true);
            btnSupprimer.setDisable(true);
            btnVisualiser.setDisable(true);
            Application.screenController.activate(table);
        } else if (table == "abonnement") {
            abonnement = Application.factory.getAbonnementDAO().getById(id);
            Application.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutAbonnement.fxml")));
            tableVue.getItems().clear();
            btnModifier.setDisable(true);
            btnSupprimer.setDisable(true);
            btnVisualiser.setDisable(true);
            Application.screenController.activate(table);
        } else if (table == "client") {
            client = Application.factory.getClientDAO().getById(id);
            Application.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutClient.fxml")));
            tableVue.getItems().clear();
            btnModifier.setDisable(true);
            btnSupprimer.setDisable(true);
            btnVisualiser.setDisable(true);
            Application.screenController.activate(table);
        } else if (table == "revue") {
            revue = Application.factory.getRevueDAO().getById(id);
            Application.screenController.addScreen(table, FXMLLoader.load(getClass().getResource("AjoutRevue.fxml")));
            tableVue.getItems().clear();
            btnModifier.setDisable(true);
            btnSupprimer.setDisable(true);
            btnVisualiser.setDisable(true);
            Application.screenController.activate(table);
        }
    }

    public void btnVisualiserClick(ActionEvent actionEvent) throws IOException {
        Application.screenController.addScreen("visualiser", FXMLLoader.load(getClass().getResource("Visualiser.fxml")));
        Application.screenController.activate("visualiser");
    }
}
