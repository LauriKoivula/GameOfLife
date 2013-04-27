/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Riki Sorsan veli
 */
public class solunKuuntelija implements ActionListener{
    
    private JButton solunappi;
    
    public solunKuuntelija(JButton nappula) {
        this.solunappi = nappula;
    }

    // Toimii mutta asettaa vain graafisen ympäristön muuttujat, 
    // pitää saadaa muutettua itse SOLU eläväksi tai kuolleeksi = 
    // itse taulukko pitää saada vedettyä TaulukkoGIUsta tänne
    // Solun muuttaminen käytännössä ei vielä toimi tällä.. 
    @Override
    public void actionPerformed(ActionEvent e) {
       if( this.solunappi.getBackground()==Color.BLACK) {
           this.solunappi.setBackground(Color.WHITE);
       } else {
           this.solunappi.setBackground(Color.BLACK);
       }
    }
}
