/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

import gui.TaulukkoGUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Riki Sorsan veli
 */
public class Kayttoliittyma {

    private Taulukko ekaAskel;
    private Taulukko tokaAskel;
    private Logiikka logiikka;
    private TaulukkoGUI gui;
    private int riveja;
    private int kolumneja;
    private double tiheys;
    private boolean pause;

    // Konstruktori
    public Kayttoliittyma(int rivit, int kolumnit, double tiheys) {
        // Pelin alustus
        this.riveja = rivit;
        this.kolumneja = kolumnit;
        this.tiheys = tiheys;

        // taulukon alustus
        this.ekaAskel = new Taulukko(this.riveja, this.kolumneja, this.tiheys);

        // simulointi looppi
        int numero = 0;
        // kuinka monta askelta simuloidaan
        while (numero < 100) {

            if (numero == 0) {
                this.gui = new TaulukkoGUI(this.ekaAskel);
                SwingUtilities.invokeLater(gui);
            }
            
            viivytys();

            this.logiikka = new Logiikka(this.ekaAskel);
            this.tokaAskel = this.logiikka.kasitteleTaulukko(this.ekaAskel);
            this.gui.paivitaTaulukko(this.tokaAskel);
            // paivitaTaulukko-metodi vie aikaa n.150ms, mikä on paljon.
            // SwingUtilities.invokeLater(gui);
            this.ekaAskel = this.tokaAskel;
            numero++;

        }
    }

    private void viivytys() {
        // viivytys
        long present = System.currentTimeMillis();
        System.out.println(present);
        long delay = 200;
        long katkaisu = present + delay;
        while (present < katkaisu) {
            present = System.currentTimeMillis();
            // antaa ajan kulua delayn osoittaman millisekuntia.
        }
    }
}
