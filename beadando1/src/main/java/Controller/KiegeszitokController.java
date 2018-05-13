package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Modell.Kiegeszito;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author darrnel
 */
public class KiegeszitokController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label_kieg;
    @FXML
    private TextFlow kieg_TF;
    @FXML
    private TextFlow kiegUrl_TF;
    @FXML
    private TextFlow felsz_TF;
    @FXML
    private TextFlow felszUrl_TF;
    @FXML
    private Text cipoText;
    @FXML
    private Hyperlink cipoLink;

    Kiegeszito cipo = new Kiegeszito("Cipő", "https://www.fitbuilder.hu/termekek/Cipo.html");
    Kiegeszito nadrag = new Kiegeszito("Nadrág", "https://www.fitbuilder.hu/termekek/Edzo-nadrag.html");
    Kiegeszito polo = new Kiegeszito("Póló", "https://www.fitbuilder.hu/termekek/Polo.html");

    Kiegeszito feherje = new Kiegeszito("Fehérje", "https://www.fitbuilder.hu/termekek/Feherje.html");
    Kiegeszito tomegnovelo = new Kiegeszito("Tömegnövelő", "https://www.fitbuilder.hu/termekek/Tomegnovelo-Szenhidrat.html");
    Kiegeszito zsiregeto = new Kiegeszito("Zsírégető", "https://www.fitbuilder.hu/termekek/Dieta-Zsiregeto.html");

    @FXML
    private void handleVisszaButtonAction(ActionEvent event) {
        Stage stage_vissza = (Stage) label_kieg.getScene().getWindow();
        stage_vissza.hide();
    }

    @FXML
    private void cipoLinkAction(ActionEvent event) {
        try {

            java.awt.Desktop.getDesktop().browse(java.net.URI.create(cipo.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void nadragLinkAction(ActionEvent event) {
        try {

            java.awt.Desktop.getDesktop().browse(java.net.URI.create(nadrag.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void poloLinkAction(ActionEvent event) {
        try {

            java.awt.Desktop.getDesktop().browse(java.net.URI.create(polo.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void feherjeLinkAction(ActionEvent event) {
        try {

            java.awt.Desktop.getDesktop().browse(java.net.URI.create(feherje.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void tomegnoveloLinkAction(ActionEvent event) {
        try {

            java.awt.Desktop.getDesktop().browse(java.net.URI.create(tomegnovelo.getUrl()));

        } catch (IOException e) {
        }
    }

    @FXML
    private void zsiregetoLinkAction(ActionEvent event) {
        try {

            java.awt.Desktop.getDesktop().browse(java.net.URI.create(zsiregeto.getUrl()));

        } catch (IOException e) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
