/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package golpeli;

import gui.TaulukkoGUI;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        Scanner lukija = new Scanner(System.in);

        System.out.println("Syötä taulukon leveys: ");
        while (!lukija.hasNextInt()) {
            System.out.println("Syötä kokonaisluku.");
            lukija.nextLine();
        }
        int leveys = lukija.nextInt();

        System.out.println("Syötä taulukon korkeus: ");
        while (!lukija.hasNextInt()) {
            System.out.println("Syötä kokonaisluku.");
            lukija.nextLine();
        }
        int korkeus = lukija.nextInt();

        System.out.println("Syötä haluttu solutiheys välillä 0,0-1,0: ");
        while (!lukija.hasNextDouble()) {
            System.out.println("Syötä luku väliltä 0,0-0,1.");
            lukija.nextLine();
        }
        double tiheys = lukija.nextDouble();

        System.out.println("Syötä simulaation maksimiaika askelissa: ");
        while (!lukija.hasNextInt()) {
            System.out.println("Syötä kokonaisluku.");
            lukija.nextLine();
        }
        int maara = lukija.nextInt();

        Kayttoliittyma peli = new Kayttoliittyma(korkeus, leveys, tiheys, maara);

    }
}
