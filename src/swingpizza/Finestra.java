/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpizza;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author giovanni
 */
public class Finestra extends JFrame{
    
    private Tavoli tavoli;
    
    Finestra(){
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        JLabel titolo;
        titolo=new JLabel("PizzaSwing", JLabel.CENTER);
        titolo.setFont(new Font("Arial", Font.PLAIN, 20));
        add(titolo);
        add(new JLabel("Tavoli"));       
        tavoli=new Tavoli();
        System.out.println("Versione 1?");
        add(tavoli);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
    }
    
}
