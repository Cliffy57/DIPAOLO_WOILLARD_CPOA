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
    public static ObservableList<String> listObservable = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        Connexion.creeConnexion();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        screenController = new ScreenController(scene);
        HelloApplication.screenController.addScreen("menu",FXMLLoader.load(getClass().getResource("Menu.fxml")));
        HelloApplication.screenController.addScreen("periodicite",FXMLLoader.load(getClass().getResource("AjoutPeriodicite.fxml")));
        HelloApplication.screenController.activate("menu");

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}