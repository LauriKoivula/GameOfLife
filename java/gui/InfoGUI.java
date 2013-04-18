/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import golpeli.Kayttoliittyma;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Riki Sorsan veli
 */
public class InfoGUI implements Runnable {

    private JFrame ikkuna;
    private JTextField simulaatiot;
    private JTextField maara;
    private JButton paussi;
    private boolean pause;

    public InfoGUI() {
    }

//    public InfoGUI(Kayttoliittyma a) {
//        ikkuna = new JFrame("Info");
//        ikkuna.setLayout(new GridLayout(1,2));
//        ikkuna.setPreferredSize(new Dimension(100,200));
//    }
    public void piirra(int simu, int paljonko) {
        ikkuna = new JFrame("Info");
        ikkuna.setLayout(new GridLayout(3, 1));
        ikkuna.setPreferredSize(new Dimension(150, 200));
        ikkuna.setAlwaysOnTop(true);
        ikkuna.setLocation(700, 0);
        simulaatiot = new JTextField("Simulointi askel: " + simu);
        ikkuna.add(simulaatiot);
        maara = new JTextField("Simulointien määrä: " + paljonko);
        ikkuna.add(maara);
        paussi = new JButton("Simuloi");
        // nappulan kuuntelija..
        // pause = false;
        napinKuuntelija kuuntelija = new napinKuuntelija(this.paussi);
        
        paussi.addActionListener(kuuntelija);
        paussi.setBackground(Color.RED);
        ikkuna.add(paussi);
        
    }

    public void paivitaInfo(int simu) {
        simulaatiot.setText("Simulointiaskel: " + simu);
    }
    
    public String getPause() {
        return this.paussi.getText();
    }
    
//    public void asetaPause() {
//        this.pause = true;
//    }
//    
//    public void poistaPause() {
//        this.pause = false;
//    }

    @Override
    public void run() {
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();
        ikkuna.setVisible(true);
    }
}
