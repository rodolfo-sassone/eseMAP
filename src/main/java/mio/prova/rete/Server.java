/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mio.prova.rete;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Rodolfo Pio Sassone
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket s = null;
        int countRequest = 0;
        try {
            ManagerClients mc = new ManagerClients();
            s = new ServerSocket(890);
            while (true) {
                Socket socket = s.accept();
                Thread t = new MessengerThread(socket, "request " + countRequest++, mc);
                t.start();
            }
        } catch (IOException ex) {
            System.err.println("***Error***\n IOException occurred: " + ex.getMessage());
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException ex) {
                    System.err.println("***Error***\n IOException occurred: " + ex.getMessage());
                }
            }
        }

    }
}
