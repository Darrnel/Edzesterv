package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Modell.EdzesDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author darrnel
 */
public class EtrendController implements Initializable {

    @FXML
    Label reggeliLabel;
    @FXML
    TextFlow reggeliA, reggeliB, reggeliC, reggeliD, tizoraiA, tizoraiB, tizoraiC, tizoraiD, ebedA, ebedB,
            ebedC, ebedD, uzsonnaA, uzsonnaB, uzsonnaC, uzsonnaD, vacsoraA, vacsoraB, vacsoraC, vacsoraD;

    @FXML
    public void handleVisszaButtonAction(ActionEvent event) {
        try {
            Stage stage_vissza = (Stage) reggeliLabel.getScene().getWindow();
            stage_vissza.hide();
        } catch (Exception e) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String etrendTipus;

        try {
            if (EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getTtindex() < 27) {
                etrendTipus = "tomegEtrendXML.xml";
            } else {
                etrendTipus = "fogyasEtrendXML.xml";
            }

            reggeliA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getReggeli()));
            reggeliB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getReggeli()));
            reggeliC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getReggeli()));
            reggeliD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getReggeli()));

            tizoraiA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getTizorai()));
            tizoraiB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getTizorai()));
            tizoraiC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getTizorai()));
            tizoraiD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getTizorai()));

            ebedA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getEbed()));
            ebedB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getEbed()));
            ebedC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getEbed()));
            ebedD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getEbed()));

            uzsonnaA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getUzsonna()));
            uzsonnaB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getUzsonna()));
            uzsonnaC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getUzsonna()));
            uzsonnaD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getUzsonna()));

            vacsoraA.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(0).getVacsora()));
            vacsoraB.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(1).getVacsora()));
            vacsoraC.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(2).getVacsora()));
            vacsoraD.getChildren().add(new Text(EdzesDAO.getEtrend(etrendTipus).get(3).getVacsora()));

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            Logger.getLogger(EtrendController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
