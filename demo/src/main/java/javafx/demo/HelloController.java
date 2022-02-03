package javafx.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Label LblResultat;
    private TextField TextTitre;

    @FXML
    public String toString() {
        welcomeText.setText("Welcome to JavaFX Application!");
        LblResultat.setText(TextTitre.getText());
        return null;
    }

}