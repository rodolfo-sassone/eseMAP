/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mio.prova.Thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class Pari implements Runnable{
    
    @Override
    public synchronized void run(){
        int i=0;
        while(i<=100) {
            System.out.println(i);
            i+=2;
        }
    }
    
}
