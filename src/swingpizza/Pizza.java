/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpizza;

import java.util.ArrayList;

/**
 *
 * @author giovanni
 */
public class Pizza {
    String nome;
    Double prezzo;
    ArrayList<String> ingredienti;
    
    Pizza(String nome, Double prezzo){
        this.nome=nome;
        this.prezzo=prezzo;
        ingredienti = new ArrayList<String>();
    }
    
    public void addIngrediente(String ingrediente){
        ingredienti.add(ingrediente);
    }
    
    public String toString(){
        String s=nome+"\t"+prezzo+"€\tIngredienti: ";
        for(int i=0; i<ingredienti.size()-1; i++){
            s+=ingredienti.get(i)+", ";
        }
        s+=ingredienti.get(ingredienti.size()-1)+".\n";    //no virgola alla fine
        return s;
    }
    
    
            
}
