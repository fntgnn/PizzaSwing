/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpizza;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author giovanni
 */
public class Menu {
    ArrayList<Pizza> pizze;
    
    Menu(){
        pizze=new ArrayList<Pizza>();

        try (BufferedReader in = new BufferedReader(new FileReader("menu.txt"))) {
         String inLine;
         while ((inLine = in.readLine()) != null) {  
            String[] elementi=inLine.split(",");
            Pizza p;
            p=new Pizza(elementi[0], Double.parseDouble(elementi[1]));
            for(int i=2; i<elementi.length; i++){
                p.addIngrediente(elementi[i]);
            }
            pizze.add(p);
         }
         in.close();
      } catch (IOException ex) {
         ex.printStackTrace();
      }
    }
    
    public String[] prendiArrayNomiPizze(){
        String[] array = new String[this.pizze.size()];
        for(int i=0; i<pizze.size(); i++){
            array[i]=pizze.get(i).nome;
        }
        return array;
    }
    
   
}
