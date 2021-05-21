/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ese001;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class TestNegozio {

    /**
     * @param args the command line arguments
     * @throws com.mycompany.ese001.NegozioException
     */
    public static void main(String[] args) throws NegozioException {
        Utente u1=new Utente(1, "pippo");
        Utente u2=new UtentePrime(2, "topolino");
        
        Set<Utente> utenti = new HashSet<>();
        utenti.add(u1);
        utenti.add(u2);
        
        Magazzino magazzino=new Magazzino();
        
        Articolo a1 = new Articolo(1,"computer", 900, 2500);
        Articolo a2 = new Articolo(2, "mouse", 20, 400);
        Articolo a3 = new Articolo(3, "tastiera", 30, 500);
        
        magazzino.add(a1,10);
        magazzino.add(a2,20);
        magazzino.add(a3, 15);
        
        Negozio negozio = new Negozio(magazzino, utenti);
        Map<Articolo,Integer> carrello1 = new HashMap<>();
        Map<Articolo,Integer> carrello2 = new HashMap<>();
        
        carrello1.put(a1,1);
        carrello1.put(a2,1);
        carrello1.put(a3,1);
        
        try{
            double c=negozio.acquista(u1,carrello1);
            System.out.println("Grazie " + u1.getUsername()+ "," + c);
            c=negozio.acquista(u2,carrello1);
            System.out.println("Grazie " + u2.getUsername()+ "," + c);
        } catch(NegozioException ex) {
            System.err.println(ex);
        }
        
         Set<Articolo> trovati=negozio.getMagazzino().cerca("tastiera");
         
         for(Articolo articolo:trovati) {
             System.out.println("Trovato: " + articolo);
         }
    }
    
    
   
    
}
