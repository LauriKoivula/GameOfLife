/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import golpeli.Solu;
import golpeli.Taulukko;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author Riki Sorsan veli
 */
public class TaulukkoGUI implements Runnable {

    private JFrame frame;
    private int x;
    private int y;
    private JButton[][] grid;
    private Taulukko taulukko;
    private JButton nappula;
    private int paikka;

    public TaulukkoGUI(Taulukko taulukko) {

        this.taulukko = taulukko;
        this.x = taulukko.getRivit();
        this.y = taulukko.getKolumnit();
    }

    /**
     * Metodi päivittää graafisen Taulukon uusien Solujen arvojen perusteella.
     *
     * @param taulukko
     */
    public void paivitaTaulukko(Taulukko taulukko) {
        this.taulukko = taulukko;
        this.x = taulukko.getRivit();
        this.y = taulukko.getKolumnit();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                asetaTaustaVari(i, j);
            }
        }
        frame.setVisible(true);
    }

    // ei toimi.. 
    public Taulukko TarkistaMuutokset(Taulukko taulukko) {

        this.taulukko = taulukko;
        this.x = taulukko.getRivit();
        this.y = taulukko.getKolumnit();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (this.taulukko.getSolu(i, j).getElossa() == false
                        && grid[i][j].getBackground() == Color.BLACK) {
                    this.taulukko.getSolu(i, j).setHerata();
                } else if (this.taulukko.getSolu(i, j).getElossa() == true
                        && grid[i][j].getBackground() == Color.WHITE) {
                    this.taulukko.getSolu(i, j).setNukuta();
                }
            }
        }
        frame.setVisible(true);
        return this.taulukko;
    }

    /**
     * Metodi alustaa Graafisen ympäristön Taulukolle.
     *
     */
    @Override
    public void run() {

        this.grid = new JButton[x][y];
        paikka = y*15;
        frame = new JFrame("Game of Life");
        frame.setLayout(new GridLayout(x, y));
        frame.setPreferredSize(new Dimension(y*15, x*15));
        frame.setAlwaysOnTop(true);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = new JButton();
                asetaTaustaVari(i, j);

                solunKuuntelija kuuntelija = new solunKuuntelija(this.grid[i][j]);
                this.grid[i][j].addActionListener(kuuntelija);

                Border reuna = BorderFactory.createLineBorder(Color.WHITE, 1);
                grid[i][j].setBorder(reuna);

                frame.add(grid[i][j]);
            }
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }
    
    public JButton getButton(JButton[][] grid, int i, int j) {
        nappula = grid[i][j];
        return nappula;
    }
    
    public JButton[][] getGrid() {
        return this.grid;
    }
    
    public int getPaikka() {
        return paikka;
    }

    public void asetaTaustaVari(int i, int j) {
        if (taulukko.getSolu(i, j).getElossa() == true) {
            grid[i][j].setBackground(Color.BLACK);
        } else {
            grid[i][j].setBackground(Color.WHITE);
        }
    }
}
