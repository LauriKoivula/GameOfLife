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
    private Taulukko kolmasAskel;
    private Logiikka logiikka;
    private TaulukkoGUI gui;
    private InfoGUI info;
    private int riveja;
    private int kolumneja;
    private double tiheys;
    private int simu;
    private int maara;

    /**
     * Alustaa käyttöliittymän annettujen parametrien mukaan.
     *
     * @param rivit - Taulukon korkeus
     * @param kolumnit - Taulukon leveys
     * @param tiheys - Solujen suhteellinen tiheys välillä 0.0-1.0.
     */
    public Kayttoliittyma(int rivit, int kolumnit, double tiheys) {
        // Pelin alustus
        this.riveja = rivit;
        this.kolumneja = kolumnit;
        this.tiheys = tiheys;

        // taulukon alustus
        this.ekaAskel = new Taulukko(this.riveja, this.kolumneja, this.tiheys);

        // simulointi looppi
        this.maara = 200;
        this.simu = 0;
        // kuinka monta askelta simuloidaan
        while (this.simu < maara) {
            tarkistaaOnkoEkaKierros();
            this.simu++;

            // kun paussi painettu odotetaan
            while (this.info.getPause().equals("Simuloi") || this.info.getPause().equals("Uudestaan?")) {
                lyhytViivytys();
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
        // viivytys
        long present = System.currentTimeMillis();
        long delay = 150;
        long katkaisu = present + delay;
        while (present < katkaisu) {
            present = System.currentTimeMillis();
            // antaa ajan kulua delayn osoittaman millisekuntia.
        }
    }

    /**
     * Metodi asettaa lyhyen viiveen, jonka jälkeen ohjlema tarkistaa onko
     * Pause-nappia painettu
     *
     */
    public void lyhytViivytys() {
        // lyhyt viive napin painamisen odottamista varten
        long present = System.currentTimeMillis();
        long delay = 10;
        long katkaisu = present + delay;
        while (present < katkaisu) {
            present = System.currentTimeMillis();
            // antaa ajan kulua delayn osoittaman millisekuntia.
        }
    }

    /**
     * Tarkistaa onko ensimmäinen kierros. Jos on niin luo uudet graafiset
     * ikkunat pelille.
     *
     */
    public void tarkistaaOnkoEkaKierros() {
        if (this.simu == 0) {
            this.gui = new TaulukkoGUI(this.ekaAskel);
            SwingUtilities.invokeLater(gui);
            this.info = new InfoGUI();
            this.info.piirra(this.simu, this.maara);
            SwingUtilities.invokeLater(info);
        }

    }

    /**
     * Tarkistaa onko simulaatio päättynyt. Jos on niin asettaa laskurin alkuun
     * uusintakierrosta varten.
     *
     */
    public void tarkistaaOnkoVikaKierros() {
        if (this.simu == this.maara) {
            this.ekaAskel = new Taulukko(this.riveja, this.kolumneja, this.tiheys);
            this.simu = 1;
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
        this.info.paivitaInfo(this.simu);
        this.logiikka = new Logiikka(this.ekaAskel);
        this.tokaAskel = this.logiikka.kasitteleTaulukko(this.ekaAskel);
        this.gui.paivitaTaulukko(this.tokaAskel);
        // this.kolmasAskel = this.gui.TarkistaMuutokset(this.tokaAskel);
        // TarkistaMuutokset-metodi ei toimi..
        // this.gui.paivitaTaulukko(this.kolmasAskel);

        // paivitaTaulukko-metodi vie aikaa n.150ms, mikä on paljon.
        // ei vie enää niin paljoa...
        // SwingUtilities.invokeLater(gui);
        this.ekaAskel = this.tokaAskel;
    }
}
