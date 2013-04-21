package Tests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class TaulukkoTest {
    
    private Taulukko taulukko;
    
    public TaulukkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         this.taulukko = new Taulukko(6, 12, 1);
    }
    
    @After
    public void tearDown() {
    }
    
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
        taulukko.getSolu(1,1).setHerata();
        assertTrue("Solun herättäminen ei onnistu", taulukko.getSolu(1,1).getElossa());
    }
   
    @Test
    public void toimiikoOnkoSolunNaapuriTaulukossa1() {
        int naapurit = 0;
        naapurit = this.taulukko.onkoSolunNaapuriTaulukossa(3, 1, 3, 1, naapurit);
        assertEquals("Taulukon sisäisen naapurien laskeminen ei toimi", 1,naapurit);
    }
    
    @Test 
    public void toimiikoOnkoSolunNaapuriTaulukossa2() {
        // testataan taulukon ulkopuolinen solu (koordinaatit -1,-1)
        int naapurit = 0;
        naapurit = this.taulukko.onkoSolunNaapuriTaulukossa(0, -1, 0, -1, naapurit);
        assertEquals("Taulukon sisäisen naapurien laskeminen ei toimi", 0,naapurit);
    }
    
     @Test
    public void toimiikoToString() {
        assertEquals("Tulostus ei toimi.", "X ", (taulukko.getSolu(1,1).toString()));
    }
     
     @Test
     public void toimiikoGetSolunNaapuritKeskellaTaulukkoa() {
         assertEquals("Naapurien laskeminen ei toimi.", 8, this.taulukko.getSolunNaapurit(1, 1));
     }
     
     @Test
     public void toimiikoGetSolunNaapuritTaulukonReunassa() {
         assertEquals("Naapurien laskeminen ei toimi.", 5, this.taulukko.getSolunNaapurit(2, 0));
     }
     
     @Test
     public void toimiikoGetSolunNaapuritTaulukonKulmassa() {
         assertEquals("Naapurien laskeminen ei toimi.", 3, this.taulukko.getSolunNaapurit(0, 0));
     }
}