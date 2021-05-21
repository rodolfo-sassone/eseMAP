/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ese001;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class Negozio {
    
    //x sempl uno solo
    public final Magazzino magazzino;
    
    public final Set<Utente> utenti;

    public Negozio(Magazzino magazzino, Set<Utente> utenti) {
        this.magazzino = magazzino;
        this.utenti = utenti;
    }
    
    public double acquista(Utente utente, Map<Articolo,Integer> carrello) throws NegozioException {
        for(Articolo articolo:carrello.keySet()) {
           if (!magazzino.disponibile(articolo, carrello.get(articolo))) {
            throw new NegozioException("Articolo: "+ articolo.getId() + " non disponibile");
        }
        }
        for(Articolo articolo:carrello.keySet()) {
            magazzino.remove(articolo, carrello.get(articolo));
        }
        
        Ordine ordine=new Ordine(utente, carrello);
        utente.calcolaOrdine(ordine);
        utente.getStoricoOrdini().add(ordine);
        
        return ordine.getCostoMerce()+ordine.getCostoSpedizione();
    }

    public Magazzino getMagazzino() {
        return magazzino;
    }

    public Set<Utente> getUtenti() {
        return utenti;
    }
    
    
}
