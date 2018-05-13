package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Modell.EdzesDAO;
import Modell.Felhasznalo;
import Modell.Validate;
import java.io.IOException;
import static java.lang.Integer.parseInt;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author darrnel
 */
public class EgyeniController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextArea hetfoGyak, keddGyak, szerdaGyak, csutortokGyak, pentekGyak, szombatGyak, vasarnapGyak;
    @FXML
    TextField hetfoTipusTF, keddTipusTF, szerdaTipusTF, csutortokTipusTF, pentekTipusTF, szombatTipusTF, vasarnapTipusTF, gyakTF, sulyTF, sorozatTF, ismetlesTF, nevTF, kcalTF;
    @FXML
    Label label1;

    public void gyakClear() {
        gyakTF.clear();
        sulyTF.clear();
        sorozatTF.clear();
        ismetlesTF.clear();
    }

    int hetfoCounter = 0, keddCounter = 0, szerdaCounter = 0, csutortokCounter = 0, pentekCounter = 0, szombatCounter = 0, vasarnapCounter = 0;

    @FXML
    private void handleVisszaButtonAction(ActionEvent event) {
        try {
            Stage stage_vissza = (Stage) label1.getScene().getWindow();

            Parent root_vissza = FXMLLoader.load(getClass().getResource("/fxml/Adatok.fxml"));

            Scene scene_vissza = new Scene(root_vissza);

            stage_vissza.setTitle("Adatok megadása");
            stage_vissza.setScene(scene_vissza);
            stage_vissza.setResizable(false);
            stage_vissza.show();
        } catch (IOException e) {
        }
    }

    @FXML
    private void handleHetfoAddButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {

        String felhNev = EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getNev();
        String felhKcal = String.valueOf(EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getKcal());

        String gyakNev = gyakTF.getText();
        String gyakSuly = sulyTF.getText();
        String gyakSorozat = sorozatTF.getText();
        String gyakIsmetles = ismetlesTF.getText();

        Validate v = new Validate();
        if (v.isKarakterBemenet(hetfoTipusTF.getText(), "Edzés típusa")
                && v.isKarakterBemenet(gyakNev, "Gyakorlat neve") && v.isSzamBemenet(gyakSuly, "Súly")
                && v.isSzamBemenet(gyakSorozat, "Sorozat") && v.isSzamBemenet(gyakIsmetles, "Ismétlés")) {
            if (hetfoCounter == 0) {
                EdzesDAO.createNap(felhNev, felhKcal, "Hétfő", hetfoTipusTF.getText());
                hetfoCounter++;
                hetfoTipusTF.setEditable(false);
            }

            hetfoGyak.appendText(gyakNev + "\n   - " + gyakSuly + "kg\n   - " + gyakSorozat + "x" + gyakIsmetles + "\n");

            EdzesDAO.createGyakorlat(felhNev, felhKcal, "Hétfő", gyakNev, gyakSuly, gyakSorozat, gyakIsmetles);

            gyakClear();
        }

    }

    @FXML
    private void handleKeddAddButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        String felhNev = EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getNev();
        String felhKcal = String.valueOf(EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getKcal());
        String gyakNev = gyakTF.getText();
        String gyakSuly = sulyTF.getText();
        String gyakSorozat = sorozatTF.getText();
        String gyakIsmetles = ismetlesTF.getText();

        Validate v = new Validate();

        if (v.isKarakterBemenet(keddTipusTF.getText(), "Edzés típusa")
                && v.isKarakterBemenet(gyakNev, "Gyakorlat neve") && v.isSzamBemenet(gyakSuly, "Súly")
                && v.isSzamBemenet(gyakSorozat, "Sorozat") && v.isSzamBemenet(gyakIsmetles, "Ismétlés")) {
            if (keddCounter == 0) {
                EdzesDAO.createNap(felhNev, felhKcal, "Kedd", keddTipusTF.getText());
                keddCounter++;
                keddTipusTF.setEditable(false);
            }

            keddGyak.appendText(gyakNev + "\n   - " + gyakSuly + "kg\n   - " + gyakSorozat + "x" + gyakIsmetles + "\n");

            EdzesDAO.createGyakorlat(felhNev, felhKcal, "Kedd", gyakNev, gyakSuly, gyakSorozat, gyakIsmetles);

            gyakClear();
        }
    }

    @FXML
    private void handleSzerdaAddButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        String felhNev = EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getNev();
        String felhKcal = String.valueOf(EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getKcal());
        String gyakNev = gyakTF.getText();
        String gyakSuly = sulyTF.getText();
        String gyakSorozat = sorozatTF.getText();
        String gyakIsmetles = ismetlesTF.getText();

        Validate v = new Validate();

        if (v.isKarakterBemenet(szerdaTipusTF.getText(), "Edzés típusa")
                && v.isKarakterBemenet(gyakNev, "Gyakorlat neve") && v.isSzamBemenet(gyakSuly, "Súly")
                && v.isSzamBemenet(gyakSorozat, "Sorozat") && v.isSzamBemenet(gyakIsmetles, "Ismétlés")) {
            if (szerdaCounter == 0) {
                EdzesDAO.createNap(felhNev, felhKcal, "Szerda", szerdaTipusTF.getText());
                szerdaCounter++;
                szerdaTipusTF.setEditable(false);
            }

            szerdaGyak.appendText(gyakNev + "\n   - " + gyakSuly + "kg\n   - " + gyakSorozat + "x" + gyakIsmetles + "\n");

            EdzesDAO.createGyakorlat(felhNev, felhKcal, "Szerda", gyakNev, gyakSuly, gyakSorozat, gyakIsmetles);

            gyakClear();
        }
    }

    @FXML
    private void handleCsutortokAddButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        String felhNev = EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getNev();
        String felhKcal = String.valueOf(EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getKcal());
        String gyakNev = gyakTF.getText();
        String gyakSuly = sulyTF.getText();
        String gyakSorozat = sorozatTF.getText();
        String gyakIsmetles = ismetlesTF.getText();

        Validate v = new Validate();

        if (v.isKarakterBemenet(csutortokTipusTF.getText(), "Edzés típusa")
                && v.isKarakterBemenet(gyakNev, "Gyakorlat neve") && v.isSzamBemenet(gyakSuly, "Súly")
                && v.isSzamBemenet(gyakSorozat, "Sorozat") && v.isSzamBemenet(gyakIsmetles, "Ismétlés")) {

            if (csutortokCounter == 0) {
                EdzesDAO.createNap(felhNev, felhKcal, "Csütörtök", csutortokTipusTF.getText());
                csutortokCounter++;
                csutortokTipusTF.setEditable(false);
            }

            csutortokGyak.appendText(gyakNev + "\n   - " + gyakSuly + "kg\n   - " + gyakSorozat + "x" + gyakIsmetles + "\n");

            EdzesDAO.createGyakorlat(felhNev, felhKcal, "Csütörtök", gyakNev, gyakSuly, gyakSorozat, gyakIsmetles);

            gyakClear();
        }
    }

    @FXML
    private void handlePentekAddButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        String felhNev = EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getNev();
        String felhKcal = String.valueOf(EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getKcal());
        String gyakNev = gyakTF.getText();
        String gyakSuly = sulyTF.getText();
        String gyakSorozat = sorozatTF.getText();
        String gyakIsmetles = ismetlesTF.getText();

        Validate v = new Validate();

        if (v.isKarakterBemenet(pentekTipusTF.getText(), "Edzés típusa")
                && v.isKarakterBemenet(gyakNev, "Gyakorlat neve") && v.isSzamBemenet(gyakSuly, "Súly")
                && v.isSzamBemenet(gyakSorozat, "Sorozat") && v.isSzamBemenet(gyakIsmetles, "Ismétlés")) {
            if (pentekCounter == 0) {
                EdzesDAO.createNap(felhNev, felhKcal, "Péntek", pentekTipusTF.getText());
                pentekCounter++;
                pentekTipusTF.setEditable(false);
            }

            pentekGyak.appendText(gyakNev + "\n   - " + gyakSuly + "kg\n   - " + gyakSorozat + "x" + gyakIsmetles + "\n");

            EdzesDAO.createGyakorlat(felhNev, felhKcal, "Péntek", gyakNev, gyakSuly, gyakSorozat, gyakIsmetles);

            gyakClear();
        }
    }

    @FXML
    private void handleSzombatAddButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        String felhNev = EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getNev();
        String felhKcal = String.valueOf(EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getKcal());
        String gyakNev = gyakTF.getText();
        String gyakSuly = sulyTF.getText();
        String gyakSorozat = sorozatTF.getText();
        String gyakIsmetles = ismetlesTF.getText();

        Validate v = new Validate();

        if (v.isKarakterBemenet(szombatTipusTF.getText(), "Edzés típusa")
                && v.isKarakterBemenet(gyakNev, "Gyakorlat neve") && v.isSzamBemenet(gyakSuly, "Súly")
                && v.isSzamBemenet(gyakSorozat, "Sorozat") && v.isSzamBemenet(gyakIsmetles, "Ismétlés")) {
            if (szombatCounter == 0) {
                EdzesDAO.createNap(felhNev, felhKcal, "Szombat", szombatTipusTF.getText());
                szombatCounter++;
                szombatTipusTF.setEditable(false);
            }

            szombatGyak.appendText(gyakNev + "\n   - " + gyakSuly + "kg\n   - " + gyakSorozat + "x" + gyakIsmetles + "\n");

            EdzesDAO.createGyakorlat(felhNev, felhKcal, "Szombat", gyakNev, gyakSuly, gyakSorozat, gyakIsmetles);

            gyakClear();
        }
    }

    @FXML
    private void handleVasarnapAddButtonAction(ActionEvent event) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        String felhNev = EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getNev();
        String felhKcal = String.valueOf(EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getKcal());
        String gyakNev = gyakTF.getText();
        String gyakSuly = sulyTF.getText();
        String gyakSorozat = sorozatTF.getText();
        String gyakIsmetles = ismetlesTF.getText();

        Validate v = new Validate();

        if (v.isKarakterBemenet(vasarnapTipusTF.getText(), "Edzés típusa")
                && v.isKarakterBemenet(gyakNev, "Gyakorlat neve") && v.isSzamBemenet(gyakSuly, "Súly")
                && v.isSzamBemenet(gyakSorozat, "Sorozat") && v.isSzamBemenet(gyakIsmetles, "Ismétlés")) {
            if (vasarnapCounter == 0) {
                EdzesDAO.createNap(felhNev, felhKcal, "Vasárnap", vasarnapTipusTF.getText());
                vasarnapCounter++;
                vasarnapTipusTF.setEditable(false);
            }

            vasarnapGyak.appendText(gyakNev + "\n   - " + gyakSuly + "kg\n   - " + gyakSorozat + "x" + gyakIsmetles + "\n");

            EdzesDAO.createGyakorlat(felhNev, felhKcal, "Vasárnap", gyakNev, gyakSuly, gyakSorozat, gyakIsmetles);

            gyakClear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            String felhNev = EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getNev();
            String felhKcal = String.valueOf(EdzesDAO.getFelhasznalok().get(EdzesDAO.getFelhasznalok().size() - 1).getKcal());

            hetfoGyak.setEditable(false);
            keddGyak.setEditable(false);
            szerdaGyak.setEditable(false);
            csutortokGyak.setEditable(false);
            pentekGyak.setEditable(false);
            szombatGyak.setEditable(false);
            vasarnapGyak.setEditable(false);

            nevTF.setText(felhNev);
            kcalTF.setText(felhKcal);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            Logger.getLogger(EgyeniController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
