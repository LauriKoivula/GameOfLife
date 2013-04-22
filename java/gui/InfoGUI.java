/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import golpeli.Kayttoliittyma;
import golpeli.Taulukko;
import gui.TaulukkoGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    private JButton yksiAskel;
    private int loppu;
    private int paikka;
    private int askel;

    public InfoGUI(Taulukko taulukko) {
        paikka = taulukko.getKolumnit()*15+60;
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
        ikkuna.setLayout(new GridLayout(4, 1));
        ikkuna.setPreferredSize(new Dimension(250, 300));
        ikkuna.setAlwaysOnTop(true);
        ikkuna.setLocation(paikka, 0);
        simulaatiot = new JTextField("Simulointi askel: " + simu);
        Font font = new Font("Verdana", Font.BOLD, 14);
        simulaatiot.setFont(font);
        ikkuna.add(simulaatiot);
        maara = new JTextField("Askelia maksimissaan: " + paljonko);
        maara.setFont(font);
        ikkuna.add(maara);
        paussi = new JButton("Simuloi");
        Font nappulaFont = new Font("Verdana", Font.BOLD, 30);
        paussi.setFont(nappulaFont);
        paussi.setForeground(Color.WHITE);
        // nappulan kuuntelija..
        napinKuuntelija kuuntelija = new napinKuuntelija(this.paussi);
        paussi.addActionListener(kuuntelija);
        paussi.setBackground(Color.RED);
        ikkuna.add(paussi);
        yksiAskel = new JButton("Yksi askel");
        yksiAskel.setFont(nappulaFont);
        yksiAskel.setForeground(Color.WHITE);
        napinKuuntelija toinenKuuntelija = new napinKuuntelija(this.yksiAskel);
        yksiAskel.addActionListener(toinenKuuntelija);
        yksiAskel.setBackground(Color.GREEN);
        ikkuna.add(yksiAskel);
    }

    /**
     * Päivittää Infoikkunan simulaatioaskeleen
     * 
     * @param simu - monennessa askeleessa mennään
     */
    public void paivitaInfo(int simu) {
        this.askel = simu;
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
    
    public String getYksiAskel() {
        return this.yksiAskel.getText();
    }
    
    public void setYksiAskel(String a) {
        this.yksiAskel.setText(a);
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
    
    public int getAskel() {
        return this.askel;
    }
}
