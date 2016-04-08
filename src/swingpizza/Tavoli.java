/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpizza;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author giovanni
 */
public class Tavoli extends JPanel implements ActionListener{
    static final int N_TAVOLI=9;
    private Prenotazione[] prenotazioni;
    private JPanel vediTavoli;
    private JButton rimuoviTavolo;
    private JTextField tf_elimina;
    
    Tavoli(){
        setLayout(new GridLayout(2,1));
        System.out.println("creo tavolo");
        vediTavoli=new JPanel();
        vediTavoli.setLayout(new GridLayout(3,3));
        prenotazioni=new Prenotazione[N_TAVOLI];
        
        rimuoviTavolo=new JButton("Rimuovi");
        rimuoviTavolo.addActionListener(this);
        rimuoviTavolo.setActionCommand("del");
        
        for(int i=0; i<N_TAVOLI; i++){
            prenotazioni[i]=new Prenotazione(i,2);
            prenotazioni[i].addActionListener(this);
            prenotazioni[i].setActionCommand(Integer.toString(i));
            //prenotazioni[i].riempi(i);  //fatta solo x velocizzare
            vediTavoli.add(prenotazioni[i]);
        }
        add(vediTavoli);
        add(rimuoviTavolo);
        aggiornaTavoli();
    }
    
    public void eliminaTavolo(){
        int n = Integer.parseInt(JOptionPane.showInputDialog(this,"Tavolo da eliminare","Elimina tavolo"))-1;      
        if(prenotazioni[n].isOccupato()){
                   prenotazioni[n].cancella();
                   JOptionPane.showMessageDialog(this,"Tavolo "+Integer.toString(n+1)+" eliminato","Elimina tavolo",JOptionPane.INFORMATION_MESSAGE);
           }
           else{
               JOptionPane.showMessageDialog(this,"già libero!","Elimina tavolo",JOptionPane.ERROR_MESSAGE);
           }
        aggiornaTavoli();
        /*
            JFrame f=new JFrame("Eliminazione Tavolo");
            JTextField tf=new JTextField(10);
            /*JPanel eliminaTavoli = new JPanel();
            eliminaTavoli.setLayout(new BoxLayout(eliminaTavoli,BoxLayout.Y_AXIS));
            eliminaTavoli.setBorder(BorderFactory.createTitledBorder("Tavoli da eliminare"));
            for(int i=0; i<N_TAVOLI; i++){
                if(prenotazioni[i].getBackground()==Color.red){
                    tf_elimina = new JRadioButton(Integer.toString(i+1));
                    n.setActionCommand("e"+i);
                    bg.add(n);
                    eliminaTavoli.add(n);
                }
            }
        */
            /*tf_elimina=new JTextField(10);
            f.add(tf_elimina);
            
            JButton ok = new JButton("Conferma");
            ok.setActionCommand("elimina");
            f.getContentPane().setLayout(new GridLayout(3,1));
            f.add(new JLabel("Quale prenotazione vuoi eliminare?"));
            //f.getContentPane().add(eliminaTavoli);
            ok.addActionListener(this);
            f.getContentPane().add(ok);

            
            f.setVisible(true);
            f.pack();
            */
    }
    
    public void aggiornaTavoli(){
        for(int i=0; i<N_TAVOLI; i++){
            if(prenotazioni[i].isOccupato()){
                prenotazioni[i].setBackground(Color.red);
            }
            else
              prenotazioni[i].setBackground(Color.green);  
            
        }
    }
    
    @Override public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("del")){
            eliminaTavolo();
           
        }
        /*else if(e.getActionCommand().equals("elimina")){
           System.out.println(tf_elimina.getText());
           int n=Integer.parseInt(tf_elimina.getText())-1;
           if(prenotazioni[n].isOccupato()){
                   prenotazioni[n].cancella();
                   JOptionPane.showMessageDialog(this,"Tavolo "+Integer.toString(n+1)+" eliminato","Elimina tavolo",JOptionPane.INFORMATION_MESSAGE);
           }
           else{
               JOptionPane.showMessageDialog(this,"già libero!","Elimina tavolo",JOptionPane.ERROR_MESSAGE);
           }
          // int n=Integer.parseInt(e.getActionCommand().substring(1));
           //prenotazioni[n]=null; 
           //JOptionPane.showMessageDialog(this,"Prenotazione tavolo"+n+" eliminata ");
           aggiornaTavoli();
           
        }*/
        else{
            int n=Integer.parseInt(e.getActionCommand());
            System.out.println(prenotazioni[n]);
            prenotazioni[n].vediPrenotazione();
            aggiornaTavoli();
        }
    }
}
