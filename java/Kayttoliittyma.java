/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

import gui.InfoGUI;
import gui.TaulukkoGUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lauri Koivula
 */
public class Kayttoliittyma {

    private Taulukko ekaAskel;
    private Taulukko tokaAskel;
    private Logiikka logiikka;
    private TaulukkoGUI gui;
    private InfoGUI info;
    private int riveja;
    private int kolumneja;
    private double tiheys;
    private int askel;
    private int maara;

    /**
     * Alustaa käyttöliittymän annettujen parametrien mukaan.
     *
     * @param rivit - Taulukon korkeus
     * @param kolumnit - Taulukon leveys
     * @param tiheys - Solujen suhteellinen tiheys välillä 0.0-1.0.
     */
    public Kayttoliittyma(int rivit, int kolumnit, double tiheys, int maara) {
        // Pelin alustus
        this.riveja = rivit;
        this.kolumneja = kolumnit;
        this.tiheys = tiheys;
        this.maara = maara;

        // taulukon alustus
        this.ekaAskel = new Taulukko(this.riveja, this.kolumneja, this.tiheys);

        // simulointi looppi
        //  this.maara = 200;
        this.askel = 0;
        // kuinka monta askelta simuloidaan
        tarkistaaOnkoEkaKierros();
        while (this.askel < maara) {
            this.askel++;
            // kun paussi painettu odotetaan
            while (this.info.getPause().equals("Simuloi") || this.info.getPause().equals("Uudestaan?")) {
                lyhytViivytys();
                if (this.info.getYksiAskel().equals("Seuraava") && this.info.getPause().equals("Simuloi")) {
                    askeleenPaivitys();
                    this.info.setYksiAskel("Yksi askel");
                    this.askel++;
                    tarkistaaOnkoVikaKierros();
                }
            }
            viivytys();
            askeleenPaivitys();
            tarkistaaOnkoVikaKierros();
        }
    }

    /**
     * Metodi asettaa päivitystaajuuden graafisen käyttöliittymän simulaatiolle
     *
     */
    public void viivytys() {

        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodi asettaa lyhyen viiveen, jonka jälkeen ohjlema tarkistaa onko
     * Pause-nappia painettu
     *
     */
    public void lyhytViivytys() {

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Tarkistaa onko ensimmäinen kierros. Jos on niin luo uudet graafiset
     * ikkunat pelille.
     *
     */
    public void tarkistaaOnkoEkaKierros() {
        if (this.askel == 0) {
            this.gui = new TaulukkoGUI(this.ekaAskel);
            SwingUtilities.invokeLater(gui);
            this.info = new InfoGUI(this.ekaAskel);
            this.info.piirra(this.askel, this.maara);
            SwingUtilities.invokeLater(info);
        }

    }

    /**
     * Tarkistaa onko simulaatio päättynyt. Jos on niin asettaa laskurin alkuun
     * uusintakierrosta varten.
     *
     */
    public void tarkistaaOnkoVikaKierros() {
        if (this.askel == this.maara) {
            this.ekaAskel = new Taulukko(this.riveja, this.kolumneja, this.tiheys);
            this.askel = 1;
            while (this.info.getPause().equals("Pause") || this.info.getPause().equals("Uudestaan?")) {
                lyhytViivytys();
            }
            this.gui.paivitaTaulukko(ekaAskel);
        }
    }

    /**
     * Päivittää graafiset ikkunat ja asettaa taulukon arvot seuraavaa askelta
     * varten.
     *
     */
    public void askeleenPaivitys() {
        this.info.paivitaInfo(this.askel);
        this.logiikka = new Logiikka(this.ekaAskel);
        this.tokaAskel = this.logiikka.kasitteleTaulukko(this.ekaAskel);
        this.gui.paivitaTaulukko(this.tokaAskel);
        this.ekaAskel = this.tokaAskel;
    }
}
