/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

import static java.lang.Integer.parseInt;

/**
 *
 * @author darrnel
 */
public class Felhasznalo {

    private String nev;
    private int magassag;
    private int suly;
    private long ttindex;
    private long kcal;
    private String ajanlott;
    private Edzesterv edzesterv;

    public Felhasznalo() {
    }

    public Felhasznalo(String nev, Edzesterv edzesterv, int magassag, int suly) {
        this.nev = nev;
        this.magassag = magassag;
        this.suly = suly;
        this.ttindex = ttindexSzamol(suly, magassag);
        this.edzesterv = edzesterv;
        this.ajanlott = ajanlottSzamol(ttindex);
        this.kcal = kcalSzamol(ttindex, suly);
    }

    public Felhasznalo(String nev, Edzesterv edzesterv, long ttindex, long kcal) {
        this.nev = nev;
        this.ttindex = ttindex;
        this.edzesterv = edzesterv;
        this.kcal = kcal;
    }

    public Felhasznalo(String nev, long ttindex, long kcal) {
        this.nev = nev;
        this.ttindex = ttindex;
        this.kcal = kcal;
    }

    public Felhasznalo(String nev, int magassag, int suly) {
        this.nev = nev;
        this.magassag = magassag;
        this.suly = suly;
        this.ttindex = ttindexSzamol(suly, magassag);
        this.ajanlott = ajanlottSzamol(ttindex);
        this.kcal = kcalSzamol(ttindex, suly);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }

    public String getAjanlott() {
        return ajanlott;
    }

    public void setAjanlott(String ajanlott) {
        this.ajanlott = ajanlott;
    }

    public long getTtindex() {
        return ttindex;
    }

    public void setTtindex(long ttindex) {
        this.ttindex = ttindex;
    }

    public Edzesterv getEdzesterv() {
        return edzesterv;
    }

    public void setEdzesterv(Edzesterv edzesterv) {
        this.edzesterv = edzesterv;
    }

    public void setKcal(long kcal) {
        this.kcal = kcal;
    }

    public long getKcal() {
        return kcal;
    }

    @Override
    public String toString() {
        return "Felhasznalo{" + "nev=" + nev + ", ttindex=" + ttindex + ", kcal=" + ", edzesterv=" + edzesterv + "}\n";
    }

    public long ttindexSzamol(int testsuly, int magassag) {
        return Math.round(1.3 * testsuly / Math.pow((double) magassag / 100, 2.5));
    }

    public String ajanlottSzamol(long ttindex) {

        if (ttindex >= 20 && ttindex <= 26) {
            return "Normál edzés";
        } else if (ttindex < 20) {
            return "Tömegnövelő edzés";
        } else {
            return "Zsírégető edzés";
        }

    }

    public long kcalSzamol(long ttindex, int suly) {

        if (ttindex >= 20 && ttindex <= 26) {
            return suly * 35;
        } else if (ttindex < 20) {
            return suly * 45;
        } else {
            return suly * 20;
        }

    }

}
