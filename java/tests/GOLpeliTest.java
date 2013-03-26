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
        taulukko = new Taulukko(6, 12);
        solu = new Solu(1, 1, true);
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
        assertTrue("Solu ei ole jostain syystä elossa.", solu.getElossa());
    }

    @Test
    public void onnistuukoNaapurienAsettaminen() {
        String naapuritennen = Integer.toString(solu.getNaapurit());
        solu.setNaapurit(5);
        assertEquals("Naapurit väärin.", naapuritennen, Integer.toString(solu.getNaapurit() - 5));
    }

    @Test
    public void onnistuukoNaapurinLisäys() {
        String naapuritennen = Integer.toString(solu.getNaapurit());
        solu.addNaapuri();
        assertEquals("Naapurien lisäys ei onnistu.", naapuritennen, Integer.toString(solu.getNaapurit() - 1));
    }

    @Test
    public void onnistuukoNaapurienNollaus() {
        String naapuritennen = Integer.toString(solu.getNaapurit());
        solu.addNaapuri();
        solu.nollaaNaapurit();
        assertEquals("Naapurien nollaus ei onnistu.", naapuritennen, Integer.toString(solu.getNaapurit()));
    }

    @Test
    public void onnistuukoSolunNukuttaminen() {
        solu.setNukuta();
        assertFalse("Solun nukuttaminen ei onnistu", solu.getElossa());
    }

    @Test
    public void onnistuukoSolunHerättäminen() {
        solu.setNukuta();
        solu.setHerätä();
        assertTrue("Solun herättäminen ei onnistu", solu.getElossa());
    }

    @Test
    public void toimiikoToString() {
        assertEquals("Tulostus ei toimi.", "X", solu.toString());

    }
}