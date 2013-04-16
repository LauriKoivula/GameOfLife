/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import golpeli.Solu;
import golpeli.Taulukko;
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
public class GOLpeliTest {

    private Taulukko taulukko;
    private Solu solu;

    public GOLpeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        taulukko = new Taulukko(6, 12, 1);
        
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //


    @Test
    public void rivejäOlemassa() {
        assertTrue("Rivejä ei ole olemassa", taulukko.getRivit() > 0);
    }

    @Test
    public void kolumnejaOlemassa() {
        assertTrue("Kolumneja ei ole olemassa", taulukko.getKolumnit() > 0);
    }

    @Test
    public void onkoEläväSoluElossa() {
        assertTrue("Solu ei ole jostain syystä elossa.", taulukko.getSolu(1, 1).getElossa());
    }

    @Test
    public void onnistuukoSolunNukuttaminen() {
        taulukko.getSolu(1,1).setNukuta();
        assertFalse("Solun nukuttaminen ei onnistu", taulukko.getSolu(1,1).getElossa());
    }

    @Test
    public void onnistuukoSolunHerättäminen() {
        taulukko.getSolu(1,1).setNukuta();
        taulukko.getSolu(1,1).setHerätä();
        assertTrue("Solun herättäminen ei onnistu", taulukko.getSolu(1,1).getElossa());
    }

    @Test
    public void toimiikoToString() {
        assertEquals("Tulostus ei toimi.", "X ", (taulukko.getSolu(1, 1).toString()));

    }
}