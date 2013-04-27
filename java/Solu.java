/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

/**
 *
 * @author Lauri Koivula
 */
public class Solu {

    private int rivi;
    private int kolumni;
    private boolean elossa;

    public Solu(int rivi, int kolumni, boolean elossa) {

        this.rivi = rivi;
        this.kolumni = kolumni;
        this.elossa = elossa;
    }

    /**
     * Metodi palauttaa rivin, jolla solu on. 
     * 
     * @return Rivi, jolla solu sijaitsee. 
     */
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

    /**
     * Asettaa kyseisen solun eloon.
     * 
     */
    public void setHerata() {
        this.elossa = true;
    }

    /**
     * Asettaa kyseisen solun nukkumaan. 
     * 
     */
    public void setNukuta() {
        this.elossa = false;
    }
    
    /**
     * Tulostaa Solun elossa olemisen perusteella, jotta 
     * voidaan käyttää ilman graafista alustaa. 
     * 
     * @return X jos solu on elossa ja o jos solu on nukkumassa. 
     */
    @Override
    public String toString() {
        String tuloste; 
        if (this.elossa==true) {
            tuloste ="X ";
        } else {
            tuloste = "o ";
        }
        return tuloste;
    }

}
