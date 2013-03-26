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

    private int rivejä;
    private int kolumneja;
    private Solu[][] taulukko;

    public Taulukko(int rivejä, int kolumneja) {

        this.rivejä = rivejä;
        this.kolumneja = kolumneja;

        Random random = new Random();

        // Matriisi, joka on täytetty Soluilla
        // todennäköisyys asetetaan vielä käsin

        taulukko = new Solu[rivejä][kolumneja];

        for (int rivi = 0; rivi < rivejä; rivi++) {
            for (int sarake = 0; sarake < kolumneja; sarake++) {
                double testi = random.nextDouble();
                if (testi < 0.6) {
                    taulukko[rivi][sarake] = new Solu(rivi, sarake, true);
                } else {
                    taulukko[rivi][sarake] = new Solu(rivi, sarake, false);
                }
            }
        }

        // Solumatriisin tulostustesti

        for (int rivi = 0; rivi < this.rivejä; rivi++) {
            for (int sarake = 0; sarake < kolumneja; sarake++) {
                if (sarake < kolumneja - 1) {
                    System.out.print(taulukko[rivi][sarake].toString());
                } else {
                    System.out.println(taulukko[rivi][sarake].toString());
                }
            }
        }

    }

    public void luoTaulukko() {
        // taulukon luonti pitäisi toimia taulukko luokan sisällä. 
        // Sen metodeja voidaan kutsua vain ylempää. 
    }

    public void tulostaTaulukko() {
    }

    public int getRivit() {
        return this.rivejä;
    }

    public int getKolumnit() {
        return this.kolumneja;
    }

    @Override
    public String toString() {
        return "Taulukossa on " + Integer.toString(this.rivejä) + " riviä ja "
                + Integer.toString(this.kolumneja) + " kolumnia";
    }
}
