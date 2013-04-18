/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

import gui.TaulukkoGUI;
import javax.swing.SwingUtilities;

/**
 *
 * @author Riki Sorsan veli
 */
public class GOLpeli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Taulukko peli = new Taulukko(8, 8, 0.2);
//        
//        Solu tarkastelusolu = peli.getSolu(1, 1);
//
//        peli.tulostaTaulukko();
//        
//        System.out.println("naapureita " + peli.getSolunNaapurit(0, 0) + " pisteessä 0,0 - vasen yläkulma, pitäisi olla 3");
//        System.out.println("naapureita " + peli.getSolunNaapurit(0, 2) + " pisteessä 0,2 - yläreuna, pitäisi olla 5");
//        System.out.println("naapureita " + peli.getSolunNaapurit(0, 7) + " pisteessä 0,7 - oikea yläkulma, pitäisi olla 3");
//        System.out.println("naapureita " + peli.getSolunNaapurit(2, 7) + " pisteessä 2,7 - oikea reuna, pitäisi olla 5");
//        System.out.println("naapureita " + peli.getSolunNaapurit(2, 0) + " pisteessä 2,0 - vasen reuna, pitäisi olla 5");
//        System.out.println("naapureita " + peli.getSolunNaapurit(7, 0) + " pisteessä 7,0 - vasen alakulma, pitäisi olla 3");
//        System.out.println("naapureita " + peli.getSolunNaapurit(2, 2) + " pisteessä 2,2 - keskellä, pitäisi olla 8");
//        System.out.println("naapureita " + peli.getSolunNaapurit(7, 7) + " pisteessä 7,7 - oikea alakulma, pitäisi olla 3");
//        System.out.println("naapureita " + peli.getSolunNaapurit(7, 2) + " pisteessä 7,2 - alareuna, pitäisi olla 5");
//        
//        System.out.println(""); // tyhjä rivi
//
//        Logiikka logiikka = new Logiikka(peli);
//
//    
//        // käsitellään alkuperäinen taulukko
//        Taulukko toinenAskel = logiikka.kasitteleTaulukko(peli);
//
//        // tulostetaan uusi taulukko
//        toinenAskel.tulostaTaulukko();
//
//        System.out.println("");
//        Taulukko kolmasAskel = logiikka.kasitteleTaulukko(toinenAskel);
//        
//        kolmasAskel.tulostaTaulukko();
//        
//        TaulukkoGUI gui = new TaulukkoGUI(kolmasAskel);
//        SwingUtilities.invokeLater(gui);
        
        Kayttoliittyma peli = new Kayttoliittyma(30,30,0.2);
    }
}
