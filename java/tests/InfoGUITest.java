/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import golpeli.Taulukko;
import gui.InfoGUI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
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
public class InfoGUITest {

    private JFrame ikkuna;
    private JTextField simulaatiot;
    private JTextField maara;
    private JButton paussi;
    private boolean pause;
    private InfoGUI info;

    public InfoGUITest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        info = new InfoGUI(new Taulukko(10, 10, 0.2));
        info.piirra(1, 100);
        info.paivitaInfo(2);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoTekstinHakuNappulasta() {
        String teksti = info.getPause();
        boolean toimii = false;
        if (teksti.equals("Pause") || teksti.equals("Simuloi") || teksti.equals("Uudestaan?")) {
            toimii = true;
        }
        assertTrue("Tekstin haku nappulasta ei toimi.", toimii == true);
    }

    @Test
    public void toimiikoPaivitaInfo() {
        info.paivitaInfo(10);
        String teksti = "Simulointiaskel: " + Integer.toString(info.getAskel());
        assertEquals("Askeleen päivitys ei onnistu.", "Simulointiaskel: 10", teksti);
    }
}