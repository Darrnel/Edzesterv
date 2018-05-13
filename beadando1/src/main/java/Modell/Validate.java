/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

import java.io.InputStream;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 *
 * @author darrnel
 */
public class Validate {

    public Validate() {
    }

    /* public boolean isUresBemenet(String bemenet, String elem){ 
        
        if(bemenet.isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
            alert.setContentText("Hibásan adtad meg a következő mezőt: "+ elem);

            alert.showAndWait();
            return true;
        }  
        
        return false;
    }
     */
    public boolean isKarakterBemenet(String bemenet, String elem) {

        if ((Pattern.matches("[\\p{L}]+[ ][\\p{L}]+[ ]?[\\p{L}]*", bemenet) && bemenet.length() <= 30) || Pattern.matches("[\\p{L}]+", bemenet)) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
            alert.setContentText("Egész szöveget adj meg a következő mezőbe: " + elem);

            alert.showAndWait();
            return false;
        }
    }

    public boolean isSzamBemenet(String bemenet, String elem) {

        if (Pattern.matches("[0-9]+", bemenet) && bemenet.length() <= 3) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
            alert.setContentText("Egész számot adj meg a következő mezőbe: " + elem);

            alert.showAndWait();
            return false;
        }
    }

    public boolean isNotNullValue(String bemenet, String elem) {

        if (!Pattern.matches("[0][0-9]*", bemenet)) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText(null);
            alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
            alert.setContentText("Nem adható meg 0 érték a következő helyen: " + elem);

            alert.showAndWait();

            return false;
        }
    }

    public void szamaolasSzukseges() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba");
        alert.setHeaderText(null);
        alert.setGraphic(new ImageView(this.getClass().getResource("/images/error.png").toString()));
        alert.setContentText("Elsőnek add meg az adataid és számold ki a testtömegindexedet!");

        alert.showAndWait();
    }

}
