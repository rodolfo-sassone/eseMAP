/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mio.prova.Thread;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class TestPariDispari {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        Thread pari=new Thread(new Pari(),"Pari");
        Thread dispari = new Thread(new Dispari(),"Dispari");
        
        pari.start();
        dispari.start();
        Thread.sleep(50);
        if(pari.isAlive()) { 
            System.out.println("Vivo");
        }else{
            System.out.println("Morto");
        }
    }
    
}
