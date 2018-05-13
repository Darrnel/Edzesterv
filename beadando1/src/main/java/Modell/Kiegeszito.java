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
public class Kiegeszito {

    private String nev;
    private String url;

    public Kiegeszito(String nev, String url) {
        this.nev = nev;
        this.url = url;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
