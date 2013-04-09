/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

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
        Taulukko peli = new Taulukko(8, 8, 0.2);

        // tulostetaan taulukko
        //    System.out.println(peli.toString());

        Solu tarkastelusolu = peli.getSolu(1, 1);

//        System.out.println("tarkastelusolu rivillä " + 
//                tarkastelusolu.getRivi() + " ja kolumnissa " + 
//                tarkastelusolu.getKolumni());
//        
//        System.out.println("Onko solu elossa? " + tarkastelusolu.getElossa());
//      
        peli.tulostaTaulukko();
        
        System.out.println("naapureita " + peli.getSolunNaapurit(0, 0) + " pisteessä 0,0 - vasen yläkulma, pitäisi olla 3");
        System.out.println("naapureita " + peli.getSolunNaapurit(0, 2) + " pisteessä 0,2 - yläreuna, pitäisi olla 5");
        System.out.println("naapureita " + peli.getSolunNaapurit(0, 7) + " pisteessä 0,7 - oikea yläkulma, pitäisi olla 3");
        System.out.println("naapureita " + peli.getSolunNaapurit(2, 7) + " pisteessä 2,7 - oikea reuna, pitäisi olla 5");
        System.out.println("naapureita " + peli.getSolunNaapurit(2, 0) + " pisteessä 2,0 - vasen reuna, pitäisi olla 5");
        System.out.println("naapureita " + peli.getSolunNaapurit(7, 0) + " pisteessä 7,0 - vasen alakulma, pitäisi olla 3");
        System.out.println("naapureita " + peli.getSolunNaapurit(2, 2) + " pisteessä 2,2 - keskellä, pitäisi olla 8");
        System.out.println("naapureita " + peli.getSolunNaapurit(7, 7) + " pisteessä 7,7 - oikea alakulma, pitäisi olla 3");
        System.out.println("naapureita " + peli.getSolunNaapurit(7, 2) + " pisteessä 7,2 - alareuna, pitäisi olla 5");
        
        System.out.println(""); // tyhjä rivi

        Logiikka logiikka = new Logiikka(peli);

        // System.out.println("tarkistuspiste 1");

        // käsitellään alkuperäinen taulukko
        Taulukko seuraavaAskel = logiikka.käsitteleTaulukko(peli);

        //   System.out.println("tarkistuspiste 2");

        // tulostetaan uusi taulukko
        seuraavaAskel.tulostaTaulukko();

        Solu tarkastelusolukaksi = seuraavaAskel.getSolu(1, 1);

//        System.out.println("tarkastelusolu 2 on rivillä " +
//                tarkastelusolukaksi.getRivi() + " ja kolumnissa " + 
//                tarkastelusolukaksi.getKolumni());
//        
//        System.out.println("naapureita " + seuraavaAskel.getSolunNaapurit(0, 0) + " pisteessä 0,0");
//        System.out.println("naapureita " + seuraavaAskel.getSolunNaapurit(0, 7) + " pisteessä 0,7");
//        System.out.println("naapureita " + seuraavaAskel.getSolunNaapurit(4, 0) + " pisteessä 4,0");
//        System.out.println("naapureita " + seuraavaAskel.getSolunNaapurit(2, 2) + " pisteessä 2,2");
//        System.out.println("naapureita " + seuraavaAskel.getSolunNaapurit(4, 7) + " pisteessä 4,7");
//        
        System.out.println("");
        Taulukko kolmasAskel = logiikka.käsitteleTaulukko(seuraavaAskel);
        
        kolmasAskel.tulostaTaulukko();
    }
}
