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
    
    public Solu (int rivi, int kolumni, boolean elossa) {
        
        this.rivi = rivi;
        this.kolumni = kolumni;
        this.elossa = elossa;
        this.naapureita = 0;
        
    }
    
    public int getNaapurit() {
        return this.naapureita;
    }
    
    public void setNaapurit(int naapurit) {
        if (naapurit<0) {
            this.naapureita = 0;
        } else {
        this.naapureita = naapurit;
        }
    }
    
    public void addNaapuri() {
        ++this.naapureita;
    }
    
    public void nollaaNaapurit() {
        this.naapureita=0;
    }
    
    public int getRivi() {
        return this.rivi;
    }
    
    public void setRivi(int rivi) {
        this.rivi=rivi;
    }
    
    public int getKolumni() {
        return this.kolumni;
    }
    
    public void setKolumni(int kolumni) {
        this.kolumni=kolumni;
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
            palautus = "X";
        } else {
            palautus = "-";
        }
        return palautus;
    }
     
}
