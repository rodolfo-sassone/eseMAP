/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ese001;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class Utente {
    
    private int id;
    
    private String username;
    
    private final List<Ordine> storicoOrdini;
    
    public Utente(int id, String username){
        this.id=id;
        this.username=username;
         this.storicoOrdini=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Ordine> getStoricoOrdini() {
        return storicoOrdini;
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public void calcolaOrdine(Ordine ordine){
        ordine.calcolaCostoMerce();
        double peso=ordine.getPeso();
        int kg=(int) Math.round(peso/1000);
        if(kg<1)
            ordine.setCostoSpedizione(2);
        else
            ordine.setCostoSpedizione(2*kg);
    }
}
