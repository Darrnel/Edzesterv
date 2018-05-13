/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modell.EdzesDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Modell.Felhasznalo;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import Modell.Validate;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * FXML Controller class
 *
 * @author darrnel
 */
public class AdatokController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField nev_TF, testsuly_TF, magassag_TF;
    @FXML
    private Label label1, ttindexLabel, kcalLabel, ajanlottLabel;

    boolean kiSzamolte = false;
    Validate v = new Validate();

    @FXML
    public void handleVisszaButtonAction(ActionEvent event) {
        try {
            Stage stage = (Stage) label1.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Kezdolap.fxml"));

            Scene scene = new Scene(root);

            stage.setResizable(false);
            stage.setTitle("Kezdőlap");
            stage.setScene(scene);

            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

            stage.show();
        } catch (Exception e) {
        }
    }

    @FXML
    public void handleEgyeniButtonAction(ActionEvent event) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        if (kiSzamolte) {
            Stage stage = (Stage) label1.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Egyeni.fxml"));

            Scene scene = new Scene(root);

            stage.setResizable(false);
            stage.setTitle("Egyéni edzésterv összeállítása");
            stage.setScene(scene);

            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

            stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
            stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

            stage.show();
        } else {
            v.szamaolasSzukseges();
        }
    }

    @FXML
    public void handleSablonButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, TransformerException, TransformerException, IOException {

        if (kiSzamolte) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Sablon.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Ajánlott edzésterv");
            stage.setScene(new Scene(root));

            stage.show();
        } else {
            v.szamaolasSzukseges();
        }

    }

    @FXML
    public void handleEtrendButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {

        if (kiSzamolte) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Etrend.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Ajánlott étrendek");
            stage.setScene(new Scene(root));

            stage.show();
        } else {
            v.szamaolasSzukseges();
        }

    }

    @FXML
    public void handleSzamolButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        Validate v = new Validate();

        if (v.isKarakterBemenet(nev_TF.getText(), "Név") && v.isSzamBemenet(magassag_TF.getText(), "Magasság")
                && v.isSzamBemenet(testsuly_TF.getText(), "Súly") && v.isNotNullValue(magassag_TF.getText(), "Magasság")
                && v.isNotNullValue(testsuly_TF.getText(), "Súly")) {
            EdzesDAO.createFelhasznalo(nev_TF.getText(), magassag_TF.getText(), testsuly_TF.getText());

            Felhasznalo f = new Felhasznalo(nev_TF.getText(), parseInt(magassag_TF.getText()), parseInt(testsuly_TF.getText()));

            ttindexLabel.setText(String.valueOf(f.getTtindex()));
            ajanlottLabel.setText(f.getAjanlott());
            kcalLabel.setText(String.valueOf(f.getKcal()));

            kiSzamolte = true;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
