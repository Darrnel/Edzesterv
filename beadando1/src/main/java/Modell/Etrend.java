/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

/**
 *
 * @author darrnel
 */
public class Etrend {

    String reggeli;
    String tizorai;
    String ebed;
    String uzsonna;
    String vacsora;

    public Etrend(String reggeli, String tizorai, String ebed, String uzsonna, String vacsora) {
        this.reggeli = reggeli;
        this.tizorai = tizorai;
        this.ebed = ebed;
        this.uzsonna = uzsonna;
        this.vacsora = vacsora;
    }

    @Override
    public String toString() {
        return "Etrend{" + "reggeli=" + reggeli + ", tizorai=" + tizorai + ", ebed=" + ebed + ", uzsonna=" + uzsonna + ", vacsora=" + vacsora + '}';
    }

    public String getReggeli() {
        return reggeli;
    }

    public void setReggeli(String reggeli) {
        this.reggeli = reggeli;
    }

    public String getTizorai() {
        return tizorai;
    }

    public void setTizorai(String tizorai) {
        this.tizorai = tizorai;
    }

    public String getEbed() {
        return ebed;
    }

    public void setEbed(String ebed) {
        this.ebed = ebed;
    }

    public String getUzsonna() {
        return uzsonna;
    }

    public void setUzsonna(String uzsonna) {
        this.uzsonna = uzsonna;
    }

    public String getVacsora() {
        return vacsora;
    }

    public void setVacsora(String vacsora) {
        this.vacsora = vacsora;
    }

}
