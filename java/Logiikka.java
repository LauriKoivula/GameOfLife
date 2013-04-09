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

    public Taulukko käsitteleTaulukko(Taulukko taulukko) {

        // pitäisi luoda uusi taulukko, johon uudet arvot sijoitetaan
        // -> metodin lopussa palautetaan uusi taulukko

        // luodaan uusi taulukko - sama koko kuin vanha, tideydellä ei väliä koska sinne 
        // sijoitetaan uudet arvot
        Taulukko uusiTaulukko = new Taulukko(taulukko.getRivit(), taulukko.getKolumnit(), 0);

        int rivit = taulukko.getRivit();
        int kolumnit = taulukko.getKolumnit();

//        System.out.println(Integer.toString(rivit) + "riviä");
//        System.out.println(Integer.toString(kolumnit) + "kolumnia");

        for (int rivi = 0; rivi <= rivit - 1; rivi++) {
            //    System.out.println("tarkistuspiste 3");
            for (int sarake = 0; sarake <= kolumnit - 1; sarake++) {

//                if (taulukko.getSolu(rivi, sarake).getElossa() == true
//                        && taulukko.getSolunNaapurit(rivi, sarake) < 4
//                        && taulukko.getSolunNaapurit(rivi, sarake) > 1) {
//                    uusiTaulukko.getSolu(rivi, sarake).setHerätä();
//                    System.out.println("jää eloon");
//                    laskukerrat++;
//                    // jää eloon - ei tehdä mitään
//                }
                //  System.out.println("tarkistuspiste 5");
                
                // if -lauseet täytyi yhdistää, muuten ei toimi
                
                if (taulukko.getSolu(rivi, sarake).getElossa() == false
                        && taulukko.getSolunNaapurit(rivi, sarake) == 3 ||
                        taulukko.getSolu(rivi, sarake).getElossa() == true
                        && taulukko.getSolunNaapurit(rivi, sarake) < 4
                        && taulukko.getSolunNaapurit(rivi, sarake) > 1) {
                    // jos kuollut ja kolme naapuria - herätä
                    //      System.out.println("tarkistuspiste 6");
                    // taulukko.getSolu(rivi, sarake).setHerätä(); - vanha tapa
                    uusiTaulukko.getSolu(rivi, sarake).setHerätä();
                  //  System.out.println("herätys");
                } else {
                    // muissa tapauksissa solu kuolee
                    // taulukko.getSolu(rivi, sarake).setNukuta(); - vanha tapa
                    uusiTaulukko.getSolu(rivi, sarake).setNukuta();
                 //   System.out.println("nukuta");
                }

            }
        }
        return uusiTaulukko;


//        if (taulukko.getElossa() && this.solu.getNaapurit()<4 && this.solu.getNaapurit()>1) {
//            // jää eloon
//        }
//        if (this.solu.getElossa() == false && this.solu.getNaapurit() == 3) {
//            // jos koullut ja kolme naapuria - herätä
//            this.solu.setHerätä();
//        }
//        else {
//            // muissa tapauksissa solu koulee
//            this.solu.setNukuta();
//        }


    }

    
}
