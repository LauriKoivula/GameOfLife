/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import golpeli.Solu;
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
public class SoluTest {

    private Solu solu;

    public SoluTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        solu = new Solu(1, 1, true);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoRivinHakeminen() {
        assertEquals("Rivin hakeminen ei onnistu.", 1, solu.getRivi());
    }
    
    @Test 
    public void onnistuukoSolunNukuttaminen() {
        solu.setNukuta();
        assertTrue("Nukuttaminen ei onnistu.",solu.getElossa()==false);
    }
    
    @Test
    public void onnistuukoSolunHerättäminen() {
        solu.setNukuta();
        solu.setHerata();
        assertTrue("Solun herättäminen ei onnistu", solu.getElossa()==true);
    }
}