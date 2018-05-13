package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Modell.EdzesDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author darrnel
 */
public class SablonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextFlow hetfoTipus, keddTipus, szerdaTipus, csutortokTipus, pentekTipus;
    @FXML
    private TextArea hetfoGyak, keddGyak, szerdaGyak, csutortokGyak, pentekGyak;

    //EdzesDAO EdzesDAO;
    @FXML
    private void handleVisszaButtonAction(ActionEvent event) {
        Stage stage_vissza = (Stage) hetfoTipus.getScene().getWindow();
        stage_vissza.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        hetfoGyak.setEditable(false);
        keddGyak.setEditable(false);
        szerdaGyak.setEditable(false);
        csutortokGyak.setEditable(false);
        pentekGyak.setEditable(false);

        keddGyak.setText("PIHENŐ NAP");
        csutortokGyak.setText("PIHENŐ NAP");

        String sablonTipus;

        try {
            if (EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getTtindex() < 27) {
                sablonTipus = "tomegXML.xml";
            } else {
                sablonTipus = "fogyasXML.xml";
            }

            hetfoTipus.getChildren().add(new Text(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getTipus()));

            for (int i = 0; i < EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().size(); i++) {
                hetfoGyak.appendText(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().get(i).getNev());
                hetfoGyak.appendText("\n    - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().get(i).getSuly()) + "kg");
                hetfoGyak.appendText("\n    - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().get(i).getSorozat()) + "x");
                hetfoGyak.appendText(String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(0).getEdzes().getGyakorlatok().get(i).getIsmetles()) + "\n");

            }

            szerdaTipus.getChildren().add(new Text(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getTipus()));

            for (int i = 0; i < EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().size(); i++) {
                szerdaGyak.appendText(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().get(i).getNev());
                szerdaGyak.appendText("\n   - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().get(i).getSuly()) + "kg");
                szerdaGyak.appendText("\n   - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().get(i).getSorozat()) + "x");
                szerdaGyak.appendText(String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(1).getEdzes().getGyakorlatok().get(i).getIsmetles()) + "\n");
            }

            pentekTipus.getChildren().add(new Text(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getTipus()));

            for (int i = 0; i < EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().size(); i++) {
                pentekGyak.appendText(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().get(i).getNev());
                pentekGyak.appendText("\n   - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().get(i).getSuly()) + "kg");
                pentekGyak.appendText("\n   - " + String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().get(i).getSorozat()) + "x");
                pentekGyak.appendText(String.valueOf(EdzesDAO.getSablonEdzesterv(sablonTipus).getNapok().get(2).getEdzes().getGyakorlatok().get(i).getIsmetles()) + "\n");
            }

        } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(SablonController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
