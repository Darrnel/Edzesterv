/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modell.Validate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author darrnel
 */
public class KezdolapController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label_kiegeszito;
    Validate v = new Validate();

    @FXML
    public void handleKezdesButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) label_kiegeszito.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Adatok.fxml"));

            Scene scene = new Scene(root);

            stage.setTitle("Adatok megadása");
            stage.setScene(scene);

            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    public void handleKiegeszitokButtonAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kiegeszitok.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();

        stage.setResizable(false);
        stage.setTitle("Kiegeszitok");
        stage.setScene(new Scene(root));

        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
