/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import Modell.Felhasznalo;
import Modell.Validate;

/**
 *
 * @author Dikkeman
 */
public class FelhasznaloTest {

    Felhasznalo fSovany = new Felhasznalo("Test Sovany", (int) 182, (int) 50);
    Felhasznalo fNormal = new Felhasznalo("Test Normal", (int) 182, (int) 70);
    Felhasznalo fTulsuly = new Felhasznalo("Test Tulsuly", (int) 182, (int) 150);

    Validate v = new Validate();

    @Test
    public void ttindexTest() {

        assertEquals(15, fSovany.ttindexSzamol(fSovany.getSuly(), fSovany.getMagassag()));
        assertEquals(20, fNormal.ttindexSzamol(fNormal.getSuly(), fNormal.getMagassag()));
        assertEquals(44, fTulsuly.ttindexSzamol(fTulsuly.getSuly(), fTulsuly.getMagassag()));
    }

    @Test
    public void kcalTest() {

        assertEquals(2250, fSovany.kcalSzamol(fSovany.getTtindex(), fSovany.getSuly()));
        assertEquals(2450, fNormal.kcalSzamol(fNormal.getTtindex(), fNormal.getSuly()));
        assertEquals(3000, fTulsuly.kcalSzamol(fTulsuly.getTtindex(), fTulsuly.getSuly()));
    }

    @Test
    public void ajanlottTest() {

        assertEquals("Tömegnövelő edzés", fSovany.ajanlottSzamol(fSovany.getTtindex()));
        assertEquals("Normál edzés", fNormal.ajanlottSzamol(fNormal.getTtindex()));
        assertEquals("Zsírégető edzés", fTulsuly.ajanlottSzamol(fTulsuly.getTtindex()));
    }

    @Test
    public void isSzamBemenetTest() {

        assertEquals(true, v.isSzamBemenet("3", "hibás elem"));
        assertEquals(true, v.isSzamBemenet("123", "hibás elem"));
    }

    @Test
    public void isKarakterBemenet() {

        assertEquals(true, v.isKarakterBemenet("Teszt", "hibás elem"));
        assertEquals(true, v.isKarakterBemenet("Teszt szöveg", "hibás elem"));
        assertEquals(true, v.isKarakterBemenet("Teszt szöveg három", "hibás elem"));
    }

    @Test
    public void isNotNullValueTest() {

        assertEquals(true, v.isSzamBemenet("123", "hibás elem"));
        assertEquals(true, v.isSzamBemenet("300", "hibás elem"));
    }
}
