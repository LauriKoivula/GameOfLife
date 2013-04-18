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
     * Käsittelee metodille annetun Taulukon pelin sääntöjen mukaisesti:
     * S23/B3
     * 
     * @param taulukko
     * @return 
     */
    public Taulukko kasitteleTaulukko(Taulukko taulukko) {

        // pitäisi luoda uusi taulukko, johon uudet arvot sijoitetaan
        // -> metodin lopussa palautetaan uusi taulukko

        // luodaan uusi taulukko - sama koko kuin vanha, tideydellä ei väliä koska sinne 
        // sijoitetaan uudet arvot
        
        long aika = System.currentTimeMillis();
        
     //   System.out.println("a " + aika);
        
        Taulukko uusiTaulukko = new Taulukko(taulukko.getRivit(), taulukko.getKolumnit(), 0);

     //   System.out.println("b " + aika);
        
        int rivit = taulukko.getRivit();
        int kolumnit = taulukko.getKolumnit();

    //    System.out.println("c " + aika);
        
        for (int rivi = 0; rivi <= rivit - 1; rivi++) {
            
       //     System.out.println("d " + aika);
            
            for (int sarake = 0; sarake <= kolumnit - 1; sarake++) {
                
         //       System.out.println("e " + aika);
                
                kasitteleSolu(taulukko, rivi, sarake, uusiTaulukko);
                // voisiko tehdä näin? 
                //  taulukko.getSolu(rivi, kolumnit)
            }
        }
        return uusiTaulukko;
    }

    public void kasitteleSolu(Taulukko taulukko, int rivi, int sarake, Taulukko uusiTaulukko) {
        if (taulukko.getSolu(rivi, sarake).getElossa() == false
                && taulukko.getSolunNaapurit(rivi, sarake) == 3
                || taulukko.getSolu(rivi, sarake).getElossa() == true
                && taulukko.getSolunNaapurit(rivi, sarake) <= 3
                && taulukko.getSolunNaapurit(rivi, sarake) >= 2) {
            // jos kuollut ja kolme naapuria - herätä
            // tai elossa ja 2-3 naapuria - jätä eloon
            uusiTaulukko.getSolu(rivi, sarake).setHerätä();
        } else {
            // muissa tapauksissa solu kuolee
            uusiTaulukko.getSolu(rivi, sarake).setNukuta();
        }
    }
    
    
}
