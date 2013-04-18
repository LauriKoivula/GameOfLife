/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
public class TaulukkoGUI implements Runnable, MouseListener {

    private JFrame frame;
    private int x;
    private int y;
    private JButton[][] grid;
    private Taulukko taulukko;

    public TaulukkoGUI(Taulukko taulukko) {

        this.taulukko = taulukko;
        this.x = taulukko.getRivit();
        this.y = taulukko.getKolumnit();
        
        
        
    }

    public void paivitaTaulukko(Taulukko taulukko) {
        this.taulukko = taulukko;
        this.x = taulukko.getRivit();
        this.y = taulukko.getKolumnit();

        
        
        for (int i = 0; i < x; i++) {
            //    System.out.println("i: " + i);
            for (int j = 0; j < y; j++) {
                //        System.out.println("j: " + j);
                if (this.taulukko.getSolu(i, j).getElossa() == true) {
                    grid[i][j].setBackground(Color.BLACK);
                } else {
                    grid[i][j].setBackground(Color.WHITE);
                }
                //  grid[i][j].addMouseListener(new hiirenKuuntelija());
            }
        }
        frame.setVisible(true);
    }

    @Override
    public void run() {
        
        this.grid = new JButton[x][y];
        
        frame = new JFrame("Game of Life");
        frame.setLayout(new GridLayout(x, y));
        frame.setPreferredSize(new Dimension(700, 700));

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // jos halutaan indeksit näkymään, "("+i+","+j+")"
                grid[i][j] = new JButton();
                if (taulukko.getSolu(i, j).getElossa() == true) {
                    grid[i][j].setBackground(Color.BLACK);
                } else {
                    grid[i][j].setBackground(Color.WHITE);
                }

//                hiirenKuuntelija kuuntelija = new hiirenKuuntelija();
//                grid[i][j].addMouseListener(kuuntelija);
//                kuuntelija.klikkaus(null);

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

    @Override
    public void mouseClicked(MouseEvent me) {
        //  grid[i][j].setBackground(Color.yellow);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
