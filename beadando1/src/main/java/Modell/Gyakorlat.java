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
public class Gyakorlat {

    private String nev;
    private int suly;
    private int sorozat;
    private int ismetles;
    //Time perc;

    public Gyakorlat() {
    }

    public Gyakorlat(String nev, int sorozat) {
        this.nev = nev;
        this.sorozat = sorozat;
    }

    public Gyakorlat(String nev, int sorozat, int ismetles) {
        this.nev = nev;
        this.sorozat = sorozat;
        this.ismetles = ismetles;
    }

    public Gyakorlat(String nev, int suly, int sorozat, int ismetles) {
        this.nev = nev;
        this.suly = suly;
        this.sorozat = sorozat;
        this.ismetles = ismetles;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }

    public int getSorozat() {
        return sorozat;
    }

    public void setSorozat(int sorozat) {
        this.sorozat = sorozat;
    }

    public int getIsmetles() {
        return ismetles;
    }

    public void setIsmetles(int ismetles) {
        this.ismetles = ismetles;
    }

    public String toString() {
        return "            \nGyakorlat{" + "nev=" + nev + ", suly=" + suly + ", sorozat=" + sorozat + ", ismetles=" + ismetles + "}\n";
    }
}
