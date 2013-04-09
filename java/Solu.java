/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

/**
 *
 * @author Riki Sorsan veli
 */
public class Solu {

    private int rivi;
    private int kolumni;
    private int naapureita;
    private boolean elossa;

    public Solu(int rivi, int kolumni, boolean elossa) {

        this.rivi = rivi;
        this.kolumni = kolumni;
        this.elossa = elossa;
        this.naapureita = 0;

    }

    // Toteutetaan Taulukko-luokassa, koska siellä tiedetään kaikki matriisin solut
//    public int getNaapurit() {
//        // käydään naapurit läpi
//        int naapurit = 0;
//        for (int i = this.rivi - 1; i < this.rivi + 1; i++) {
//            for (int j = this.kolumni - 1; j < this.kolumni + 1; j++) {
//                if (this.elossa == true) {
//                    // ei toimi näin, tarkastaa vain kyseisen solun
//                    if (this.elossa == true && i == this.rivi && j == this.kolumni) {
//                    }
//                    naapurit++;
//                }
//            }
//        }
//
//        return naapurit;
//        //  return this.naapureita;
//    }

    // Turha metodi - ei järkeä asettaa numeromäärää naapureille
//    public void setNaapurit(int naapurit) {
//        if (naapurit < 0) {
//            this.naapureita = 0;
//        } else {
//            this.naapureita = naapurit;
//        }
//    }

    // turha metodi - ei järkeä asettaa numeromäärää naapureille
//    public void addNaapuri() {
//        ++this.naapureita;
//    }

    public void nollaaNaapurit() {
        this.naapureita = 0;
    }

    public int getRivi() {
        return this.rivi;
    }

    public void setRivi(int rivi) {
        this.rivi = rivi;
    }

    public int getKolumni() {
        return this.kolumni;
    }

    public void setKolumni(int kolumni) {
        this.kolumni = kolumni;
    }

    public boolean getElossa() {
        return this.elossa;
    }

    public void setHerätä() {
        this.elossa = true;
    }

    public void setNukuta() {
        this.elossa = false;
    }

    @Override
    public String toString() {
        String palautus;
        if (this.elossa) {
            palautus = "X ";
        } else {
            palautus = "- ";
        }
        return palautus;
    }
}
