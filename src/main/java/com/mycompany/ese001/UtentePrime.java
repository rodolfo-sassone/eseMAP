/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ese001;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class UtentePrime extends Utente{

    public UtentePrime(int id, String username) {
        super(id, username);
    }
    
    @Override
    public void calcolaOrdine(Ordine ordine) {
        ordine.calcolaCostoMerce();
        ordine.setCostoSpedizione(1);
    }
}
