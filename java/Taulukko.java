/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

import java.util.Random;

/**
 *
 * @author Riki Sorsan veli
 */
public class Taulukko {

    private int rivejä;
    private int kolumneja;
    private Solu[][] taulukko;
    private double solutiheys;

    public Taulukko(int rivejä, int kolumneja, double tiheys) {

        this.rivejä = rivejä;
        this.kolumneja = kolumneja;
        this.solutiheys = tiheys;

        Random random = new Random();

        // Matriisi, joka on täytetty Soluilla
        // todennäköisyys asetetaan vielä käsin

        taulukko = new Solu[rivejä][kolumneja];

        for (int rivi = 0; rivi < taulukko.length; rivi++) {
            for (int sarake = 0; sarake < taulukko[0].length; sarake++) {
                double testi = random.nextDouble();
                if (testi < this.solutiheys) {
                    taulukko[rivi][sarake] = new Solu(rivi, sarake, true);
                } else {
                    taulukko[rivi][sarake] = new Solu(rivi, sarake, false);
                }
            }
        }

        // Solumatriisin tulostustesti

//        for (int rivi = 0; rivi < this.rivejä; rivi++) {
//            for (int sarake = 0; sarake < kolumneja; sarake++) {
//                if (sarake < kolumneja - 1) {
//                    System.out.print(taulukko[rivi][sarake].toString());
//                } else {
//                    System.out.println(taulukko[rivi][sarake].toString());
//                }
//            }
//        }
    }

    public void luoTaulukko() {
        // taulukon luonti pitäisi toimia taulukko luokan sisällä. 
        // Sen metodeja voidaan kutsua vain ylempää. 
    }

    public void tulostaTaulukko() {
        for (int rivi = 0; rivi < this.rivejä; rivi++) {
            for (int sarake = 0; sarake < kolumneja; sarake++) {
                if (sarake < kolumneja - 1) {
                    System.out.print(taulukko[rivi][sarake].toString());
                } else {
                    System.out.println(taulukko[rivi][sarake].toString());
                }
            }
        }
    }

    public int getRivit() {
        return this.rivejä;
    }

    public int getKolumnit() {
        return this.kolumneja;
    }

    public Solu getSolu(int rivi, int kolumni) {
        return taulukko[rivi][kolumni];
    }
 
    public int getSolunNaapurit(int rivi, int kolumni) {
        int naapurit = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (rivi + i >= 0 && rivi + i <= taulukko.length - 1) {
                    if (kolumni + j >= 0 && kolumni + j <= taulukko[0].length - 1) {
                        if (taulukko[rivi + i][kolumni + j].getElossa() == true) {
                            if (taulukko[rivi + i][kolumni + j].getElossa() == true && i == 0 && j == 0) {
                                naapurit--;
                            }
                            naapurit++;
                        }
                    }
                }
            }
        }

//        for (int i = rivi - 1; i <= rivi + 1; i++) {
//            for (int j = kolumni - 1; j <= kolumni + 1; j++) {
//                // reunoilla sijaitsevat solut - indeksi ei voi olla negatiivinen
//
//                if (i < 0) {
//                    i = 0;
//                }
//                if (j < 0) {
//                    j = 0;
//                }
//
//                    if (i > this.getRivit() - 1) {
//                        i = this.getRivit() - 1;
//                    }
//                    if (j > this.getKolumnit() - 1) {
//                        j = this.getKolumnit() - 1;
//                    }
//                    // positiiviset ylitykset pitää myös hoitaa jotenkin
//                    // - indeksi ei voi olla suurempi kuin rivien tai kolumnien määrä
//                    // tässä käsitellään taulukkoa indeksien avulla
//                    // -> ne ovat yhtä pienemmät kuin kyseinen rivi tai kolumni
//
//                    if (taulukko[i][j].getElossa() == true) {
////                    System.out.println(naapurit);
////                    System.out.println("välissä");
//                        if (taulukko[i][j].getElossa() == true && i == rivi && j == kolumni) {
////                        System.out.println("osui");
//                            naapurit--;
//                        }
//                        naapurit++;
//                    }
//                
////                System.out.println(i + " " + j);
//            }
//        }
        return naapurit;
    }

    @Override
    public String toString() {
        return "Taulukossa on " + Integer.toString(this.rivejä) + " riviä ja "
                + Integer.toString(this.kolumneja) + " kolumnia";
    }
}
