package javafx;

import connexion.Connexion;
import dao.factory.DAOFactory;
import dao.metier.PeriodiciteMetier;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;

public class HelloApplication extends Application {

    public static ScreenController screenController;
    public static DAOFactory factory;
    public static ObservableList<Object> listObservable = FXCollections.observableArrayList();
    public static ObservableList<String> imageList = FXCollections.observableArrayList();
    public static ImageController imageController;

    @Override
    public void start(Stage stage) throws IOException {
        Connexion.creeConnexion();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        screenController = new ScreenController(scene);
        imageController = new ImageController();
        imageController.addImage("rick","src/main/resources/images/rick.jpg");
        imageController.addImage("salsifie","src/main/resources/images/salsifieMoney.png");
        imageController.createObservableList(imageList);
        HelloApplication.screenController.addScreen("menu",FXMLLoader.load(getClass().getResource("Menu.fxml")));
       //HelloApplication.screenController.addScreen("abonnement",FXMLLoader.load(getClass().getResource("AjoutAbonnement.fxml")));
        //HelloApplication.screenController.addScreen("client",FXMLLoader.load(getClass().getResource("AjoutClient.fxml")));
        //HelloApplication.screenController.addScreen("periodicite",FXMLLoader.load(getClass().getResource("AjoutPeriodicite.fxml")));
       // HelloApplication.screenController.addScreen("revue",FXMLLoader.load(getClass().getResource("AjoutRevue.fxml")));
        HelloApplication.screenController.activate("menu");

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}