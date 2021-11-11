package javafx;

import connexion.Connexion;
import dao.factory.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class
Application extends javafx.application.Application {

    public static ScreenController screenController;
    public static DAOFactory factory;
    public static ObservableList<Object> listObservable = FXCollections.observableArrayList();
    public static ObservableList<String> imageList = FXCollections.observableArrayList();
    public static ImageController imageController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Connexion.creeConnexion();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        screenController = new ScreenController(scene);
        imageController = new ImageController();
        imageController.addImage("rick", "src/main/resources/images/rick.jpg");
        imageController.addImage("salsifie", "src/main/resources/images/salsifieMoney.png");
        imageController.createObservableList(imageList);
        Application.screenController.addScreen("menu", FXMLLoader.load(getClass().getResource("Menu.fxml")));
        Application.screenController.activate("menu");

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}