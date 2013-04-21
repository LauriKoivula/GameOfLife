/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

/**
 *
 * @author Riki Sorsan veli
 */
public class Logiikka {

    private Taulukko taulukko;

    public Logiikka(Taulukko taulukko) {
        this.taulukko = taulukko;
    }

    /**
     * Käsittelee metodille annetun Taulukon pelin sääntöjen mukaisesti: S23/B3
     *
     * @param taulukko
     * @return Paulautetaan uusi Taulukko, jossa uudet arvot
     */
    public Taulukko kasitteleTaulukko(Taulukko taulukko) {

        Taulukko uusiTaulukko = new Taulukko(taulukko.getRivit(), taulukko.getKolumnit(), 0);

        int rivit = taulukko.getRivit();
        int kolumnit = taulukko.getKolumnit();

        for (int rivi = 0; rivi <= rivit - 1; rivi++) {
            for (int sarake = 0; sarake <= kolumnit - 1; sarake++) {
                kasitteleSolu(taulukko, rivi, sarake, uusiTaulukko);
            }
        }
        return uusiTaulukko;
    }

    /**
     * Käsittelee yksittäisen Solun Taulukon sisältä. 
     * 
     * @param taulukko - Taulukko, jota käydään läpi
     * @param rivi - rivi, jolla Solu sijaitsee
     * @param sarake - sarake, jolla Solu sijaitsee
     * @param uusiTaulukko - Käsitelty taulukko, jossa on uudet arvot
     */
    public void kasitteleSolu(Taulukko taulukko, int rivi, int sarake, Taulukko uusiTaulukko) {
        if (taulukko.getSolu(rivi, sarake).getElossa() == false
                && taulukko.getSolunNaapurit(rivi, sarake) == 3
                || taulukko.getSolu(rivi, sarake).getElossa() == true
                && taulukko.getSolunNaapurit(rivi, sarake) <= 3
                && taulukko.getSolunNaapurit(rivi, sarake) >= 2) {
            // jos kuollut ja kolme naapuria - herätä
            // tai elossa ja 2-3 naapuria - jätä eloon
            uusiTaulukko.getSolu(rivi, sarake).setHerata();
        } else {
            // muissa tapauksissa solu kuolee
            uusiTaulukko.getSolu(rivi, sarake).setNukuta();
        }
    }
}
