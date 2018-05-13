/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

import java.util.List;

/**
 *
 * @author darrnel
 */
public class Edzesterv {

    private List<Nap> napok;

    public Edzesterv() {
    }

    public Edzesterv(List<Nap> napok) {
        this.napok = napok;
    }

    public List<Nap> getNapok() {
        return napok;
    }

    public void setNapok(List<Nap> napok) {
        this.napok = napok;
    }

    @Override
    public String toString() {
        return "Edzesterv{" + "napok=" + napok + "}\n";
    }

}
