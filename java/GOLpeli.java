/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

import gui.TaulukkoGUI;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lauri Koivula
 */
public class GOLpeli {

    /**
     * Alustaa pelin. Syöttöarvoina Taulukon leveys, korkeus ja tiheys. 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Kayttoliittyma peli = new Kayttoliittyma(50,50,0.2);
        
    }
}
