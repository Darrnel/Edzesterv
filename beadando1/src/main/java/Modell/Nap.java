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
public class Nap {

    private String nap;
    private Edzes edzes;

    public Nap(String nap, Edzes edzes) {
        this.nap = nap;
        this.edzes = edzes;
    }

    public String getNap() {
        return nap;
    }

    public void setNap(String nap) {
        this.nap = nap;
    }

    public Edzes getEdzes() {
        return edzes;
    }

    public void setEdzes(Edzes edzes) {
        this.edzes = edzes;
    }

    @Override
    public String toString() {
        return "    \nNap{" + "nap=" + nap + ", edzes=" + edzes + "}\n";
    }
}
