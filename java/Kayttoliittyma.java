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
 * @author Riki Sorsan veli
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
    private int simu;
    private int maara;

    // Konstruktori
    public Kayttoliittyma(int rivit, int kolumnit, double tiheys) {
        // Pelin alustus
        this.riveja = rivit;
        this.kolumneja = kolumnit;
        this.tiheys = tiheys;

        // taulukon alustus
        this.ekaAskel = new Taulukko(this.riveja, this.kolumneja, this.tiheys);

        // simulointi looppi
        this.maara = 100;
        this.simu = 0;
        // kuinka monta askelta simuloidaan
        while (this.simu < maara) {

            if (this.simu == 0) {
                this.gui = new TaulukkoGUI(this.ekaAskel);
                SwingUtilities.invokeLater(gui);
                this.info = new InfoGUI();
                this.info.piirra(this.simu, this.maara);
                SwingUtilities.invokeLater(info);
            }
            this.simu++;

            // kun paussi painettu odotetaan
            while (this.info.getPause().equals("Simuloi")) {
                lyhytViivytys();
            }

            viivytys();

            this.info.paivitaInfo(this.simu);
            this.logiikka = new Logiikka(this.ekaAskel);
            this.tokaAskel = this.logiikka.kasitteleTaulukko(this.ekaAskel);
            this.gui.paivitaTaulukko(this.tokaAskel);

            // paivitaTaulukko-metodi vie aikaa n.150ms, mikä on paljon.
            // SwingUtilities.invokeLater(gui);
            this.ekaAskel = this.tokaAskel;
        }
    }

    private void viivytys() {
        // viivytys
        long present = System.currentTimeMillis();
        long delay = 150;
        long katkaisu = present + delay;
        while (present < katkaisu) {
            present = System.currentTimeMillis();
            // antaa ajan kulua delayn osoittaman millisekuntia.
        }
    }

    private void lyhytViivytys() {
        // lyhyt viive napin painamisen odottamista varten
        long present = System.currentTimeMillis();
        long delay = 10;
        long katkaisu = present + delay;
        while (present < katkaisu) {
            present = System.currentTimeMillis();
            // antaa ajan kulua delayn osoittaman millisekuntia.
        }
    }
}
