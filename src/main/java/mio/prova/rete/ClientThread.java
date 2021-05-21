/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mio.prova.rete;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class ClientThread extends Thread{
            private final BufferedReader in;

        public ClientThread(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(in.readLine());
                } catch (IOException ex) {
                    System.err.println("***Error\nIOException occurred: " + ex.getMessage());
                }
            }
        }
}
