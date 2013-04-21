/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Riki Sorsan veli
 */
public class napinKuuntelija implements ActionListener {

    private JButton asettaja;

    public napinKuuntelija(JButton nappi) {
       this.asettaja = nappi;
    }

    /**
     * Metodi vaihtaa simulointinappulan tekstin, 
     * mahdollistaen Käyttöliittymän toiminnon pauselle.
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (this.asettaja.getText().equals("Simuloi")) {
        this.asettaja.setText("Pause");
        } else {
            this.asettaja.setText("Simuloi");
        }
    }
}
