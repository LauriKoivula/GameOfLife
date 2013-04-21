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
 * @author Lauri Koivula
 */
public class InfoGUI implements Runnable {

    private JFrame ikkuna;
    private JTextField simulaatiot;
    private JTextField maara;
    private JButton paussi;
    private int loppu;

    public InfoGUI() {
        
    }

    /**
     * Metodi luo uuden graafisen ympäristön Infoikkunalle ja 
     * sijoittaa tarvittavat kentät ja nappulat siihen. 
     * 
     * @param simu - Simulaation askel
     * @param paljonko  - Simulaatioaskelten maksimimäärä
     */
    public void piirra(int simu, int paljonko) {
        loppu = paljonko;
        ikkuna = new JFrame("Info");
        ikkuna.setLayout(new GridLayout(3, 1));
        ikkuna.setPreferredSize(new Dimension(200, 200));
        ikkuna.setAlwaysOnTop(true);
        ikkuna.setLocation(1000, 0);
        simulaatiot = new JTextField("Simulointi askel: " + simu);
        ikkuna.add(simulaatiot);
        maara = new JTextField("Askelia maksimissaan: " + paljonko);
        ikkuna.add(maara);
        paussi = new JButton("Simuloi");
        // nappulan kuuntelija..
        napinKuuntelija kuuntelija = new napinKuuntelija(this.paussi);
        paussi.addActionListener(kuuntelija);
        
        paussi.setBackground(Color.RED);
        ikkuna.add(paussi);
        
    }

    /**
     * Päivittää Infoikkunan simulaatioaskeleen
     * 
     * @param simu - monennessa askeleessa mennään
     */
    public void paivitaInfo(int simu) {
        simulaatiot.setText("Simulointiaskel: " + simu);
        if (simu == loppu) {
            paussi.setText("Uudestaan?");
        }
    }
    
    /**
     * Palauttaa nappulassa kyseisellä hetkellä olevan tekstin, 
     * jota käytetään paussin luomisessa. 
     * 
     * @return 
     */
    public String getPause() {
        return this.paussi.getText();
    }

    /**
     * Ensimmäisellä ajokerralla asetetaan ikkunan parametrit. 
     * 
     */
    @Override
    public void run() {
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();
        ikkuna.setVisible(true);
        
    }
}
