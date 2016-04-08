/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpizza;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author giovanni
 */
public class Prenotazione extends JButton{
    private int n_tavolo;
    private int n_persone;
    private JButton bottone;
    private boolean occupato=false;
    private String[] pizzePossibili;    //per inserire ordine
    
    private ArrayList<String> ordini;
    
    Prenotazione(int n_tavolo, int n_persone){
        super(Integer.toString(n_tavolo+1));
        System.out.println("creo prenotazione");
        this.n_tavolo=n_tavolo;
        ordini = new ArrayList(n_persone);
        Menu m = new Menu();
        pizzePossibili=m.prendiArrayNomiPizze();
        System.out.println("PIZZE POSSIBILI");
        for(int i=0; i<pizzePossibili.length; i++)
            System.out.println(pizzePossibili[i]);
        
        
    }
    
    public void inserisciOrdine(String pizza){
        ordini.add(pizza);
    }

    
    public int getNPersone(){
        return n_persone;
    }
    
    public void vediPrenotazione(){
        if(isOccupato()){
            visualizzaOrdini();
        }
        else{
            inserisciOrdini();
        }
    }
    
    public void visualizzaOrdini(){
        //Crea frame
        JFrame finestra = new JFrame();
        finestra.setTitle("Prenotazione tavolo "+n_tavolo);
        finestra.setLayout(new GridLayout(ordini.size(),1));
       for(int i=0; i<ordini.size(); i++){
           finestra.getContentPane().add(new JLabel(Integer.toString(i+1)+". "+ordini.get(i)));
       }
       finestra.setSize(300,200);
       finestra.setVisible(true);
    }
    
    public void inserisciOrdini(){
        int n = Integer.parseInt(JOptionPane.showInputDialog(this,"Quante persone?"));
        for(int i=0; i<n; i++){
            String s=(String)JOptionPane.showInputDialog(this,"Inserisci pizza", "Pizze disponibili", JOptionPane.QUESTION_MESSAGE, null, pizzePossibili, pizzePossibili[0]);
            ordini.add(s);
        }
            
        occupato=true;
    }
    
    public boolean isOccupato(){
        return occupato;
    }
    
    public void cancella(){
        occupato=false;
        n_persone=0;
        ordini.clear();
    }
    
    @Override public String toString(){
       return ordini.toString();
    }
}
