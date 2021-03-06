/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

import java.util.Random;

/**
 *
 * @author Riki Sorsan veli
 */
public class Taulukko {

    private int riveja;
    private int kolumneja;
    private Solu[][] taulukko;
    private double solutiheys;

    /**
     * Luo taulukon halutulle koolle ja solutiheydelle.
     * 
     * @param rivejä käyttäjän antama rivimäärä
     * @param kolumneja käyttäjän antama sarakemäärä
     * @param tiheys käyttäjän antama solutiheys välillä 0.0-1.0
     */
    public Taulukko(int riveja, int kolumneja, double tiheys) {

        this.riveja = riveja;
        this.kolumneja = kolumneja;
        this.solutiheys = tiheys;

        Random random = new Random();

        // Matriisi, joka on täytetty Soluilla
        // todennäköisyys asetetaan vielä käsin

        taulukko = new Solu[riveja][kolumneja];

        for (int rivi = 0; rivi < taulukko.length; rivi++) {
            for (int sarake = 0; sarake < taulukko[0].length; sarake++) {
                double testi = random.nextDouble();
                if (testi < this.solutiheys) {
                    taulukko[rivi][sarake] = new Solu(rivi, sarake, true);
                } else {
                    taulukko[rivi][sarake] = new Solu(rivi, sarake, false);
                }
            }
        }
    }


    /**
     * Tulostaa taulukon käyttäen Solun toString ominaisuuksia. 
     */
    public void tulostaTaulukko() {
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < kolumneja; sarake++) {
                if (sarake < kolumneja - 1) {
                    System.out.print(taulukko[rivi][sarake].toString());
                } else {
                    System.out.println(taulukko[rivi][sarake].toString());
                }
            }
        }
    }

    public int getRivit() {
        return this.riveja;
    }

    public int getKolumnit() {
        return this.kolumneja;
    }

    public Solu getSolu(int rivi, int kolumni) {
        return taulukko[rivi][kolumni];
    }
 
    /**
     * Metodi laskee yksittäisen solun ympärillä olevien elossa olevien solujen määrän.
     * 
     * @param rivi millä rivillä tarkasteltava solu sijaitsee
     * @param kolumni missä sarakkeessa tarkasteltava solu sijaitsee
     * @return Elossa olevien naapurien määrä
     */
    public int getSolunNaapurit(int rivi, int kolumni) {
        int naapurit = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                naapurit = onkoSolunNaapuriTaulukossa(rivi, i, kolumni, j, naapurit);
            }
        }
        return naapurit;
    }

    @Override
    public String toString() {
        return "Taulukossa on " + Integer.toString(this.riveja) + " riviä ja "
                + Integer.toString(this.kolumneja) + " kolumnia";
    }

    /**
     * Metodi laskee naapurit ja vähentää naapureista yhden kun lasketaan 
     * kyseinen Solu naapureihin
     * 
     * @param rivi - rivi, jolla Solu sijaitsee
     * @param i - Solun lähimmät naapurit rivillä
     * @param kolumni - Kolumni, jolla Solu sijaitsee
     * @param j - Solun lähimmät naapurit sarakkeessa
     * @param naapurit - Solun naapurit
     * @return 
     */
    public int onkoSoluElossaJaEiItsensa(int rivi, int i, int kolumni, int j, int naapurit) {
        if (taulukko[rivi + i][kolumni + j].getElossa() == true) {
            if (taulukko[rivi + i][kolumni + j].getElossa() == true && i == 0 && j == 0) {
                naapurit--;
            }
            naapurit++;
        }
        return naapurit;
    }

    /**
     * Metodi tarkistaa onko kyseinen Solu Taulukon sisällä
     * 
     * @param rivi - rivi, jolla Solu sijaitsee
     * @param i - Solun lähimmät naapurit rivillä
     * @param kolumni - Kolumni, jolla Solu sijaitsee
     * @param j - Solun lähimmät naapurit sarakkeessa
     * @param naapurit - Solun naapurit
     * @return 
     */
    public int onkoSolunNaapuriTaulukossa(int rivi, int i, int kolumni, int j, int naapurit) {
        if (rivi + i >= 0 && rivi + i <= taulukko.length - 1) {
            if (kolumni + j >= 0 && kolumni + j <= taulukko[0].length - 1) {
                naapurit = onkoSoluElossaJaEiItsensa(rivi, i, kolumni, j, naapurit);
            }
        }
        return naapurit;
    }
}
