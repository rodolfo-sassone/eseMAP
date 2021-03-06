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
public class Magazzino {
    
    private final Map<Articolo,Integer> map;

    public Magazzino() {
        map = new HashMap<>();
    }
    
    public void add(Articolo articolo, int quantita) {
        Integer q=map.get(articolo);
        
        if(q==null) 
            map.put(articolo, quantita);
        else
           map.put(articolo,q+quantita);
    }
    
    public void remove(Articolo articolo, int quantita) throws NegozioException{
        Integer q=map.get(articolo);
        if(q==null || q<quantita)
            throw new NegozioException("Quantità non disponibile");
        else
            map.put(articolo, q-quantita);
        
    }
    
    public boolean disponibile(Articolo articolo, int quantita) throws NegozioException{
                Integer q=map.get(articolo);
        if(q==null || q<quantita)
        {
            throw new NegozioException("Quantità non disponibile");
        }
        else
            return true;
    }
    
    public Set<Articolo> cerca(String key) {
        Set<Articolo> risultati= new HashSet<>();
        for (Articolo articolo:map.keySet())  {
            if(articolo.getDesc().equals(key))
                risultati.add(articolo);
        }
        return risultati;
    }
}
