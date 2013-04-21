package Tests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import golpeli.Logiikka;
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
public class LogiikkaTest {
    
    private Taulukko taulukko;
    private Taulukko uusitaulukko;
    private Solu solu;
    
    public LogiikkaTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void kasitteleSoluOsaaKasitella() {      
         Logiikka logiikka = new Logiikka(this.taulukko);
         logiikka.kasitteleSolu(this.taulukko, 1, 1, taulukko);
     assertTrue("Ei osaa käsitellä sääntöjen mukaan.", taulukko.getSolu(1, 1).getElossa()==false);
     }
     
     @Test
     public void kasitteleSoluOsaaKasitella2() {      
         Logiikka logiikka = new Logiikka(this.taulukko);
         logiikka.kasitteleSolu(this.taulukko, 0, 0, taulukko);
     assertTrue("Ei osaa käsitellä sääntöjen mukaan.", taulukko.getSolu(0, 0).getElossa()==true);
     }
     
     @Test
     public void kasitteleTaulukkoOsaaKasitella() {
         Logiikka logiikka = new Logiikka(this.taulukko);
         Taulukko kasiteltyTaulukko = logiikka.kasitteleTaulukko(taulukko);
         assertTrue("Ei osaa käsitellä sääntöjen mukaan.", kasiteltyTaulukko.getSolu(1, 1).getElossa()==false);
         assertTrue("Ei osaa käsitellä sääntöjen mukaan.", kasiteltyTaulukko.getSolu(0, 0).getElossa()==true);
     }
     
    
}