/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import golpeli.Logiikka;
import golpeli.Taulukko;
import gui.TaulukkoGUI;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Riki Sorsan veli
 */
public class TaulukkoGUITest {

    private TaulukkoGUI taulukkoGui;
    private Logiikka logiikka;
    private Taulukko ekaAskel;
    private Taulukko tokaAskel;

    public TaulukkoGUITest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        Taulukko taulukko = new Taulukko(10, 10, 1.0);
        taulukkoGui = new TaulukkoGUI(taulukko);
        taulukkoGui.run();
        this.logiikka = new Logiikka(taulukko);
        this.tokaAskel = this.logiikka.kasitteleTaulukko(taulukko);
        this.taulukkoGui.paivitaTaulukko(this.tokaAskel);


    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoAsetaTaustavari() {
        taulukkoGui.asetaTaustaVari(1, 1);
        assertEquals("Taustavärin asettaminen ei onnistu.",
                taulukkoGui.getButton(taulukkoGui.getGrid(), 1, 1).getBackground(), Color.WHITE);
    }

    @Test
    public void toimiikoPaivitaTaulukko() {

        assertEquals("Taulukon nappien päivittäminen ei onnistu.",
                taulukkoGui.getButton(taulukkoGui.getGrid(), 1, 1).getBackground(), Color.WHITE);
    }
}