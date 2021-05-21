/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mio.prova.rete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class Client {

    public static void main(String[] args) {
        Socket s = null;
        String resp = null;
        try {
            InetAddress addr = InetAddress.getByName("localhost");
            s = new Socket(addr, 890);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())));
            Scanner input = new Scanner(System.in);
            do {
                System.out.println("Inserisci il tuo username per continuare.");
                String str = input.nextLine();
                out.println("#name " + str);
                resp = in.readLine();
                System.out.println(resp);
                if (!resp.equals("#ok")) {
                    System.out.println("Riprova");
                }
            } while (resp.equals("#ok"));
            Thread t = new ClientThread(in);
            t.start();
            while(true) {
                String cmd = input.nextLine();
                out.println(cmd);
                if(cmd.equals("#exit")) {
                    s.close();
                    System.exit(0);
                }
            }
        } catch (IOException ex) {
            System.err.println("***Error\nIOException occurred: " + ex.getMessage());
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException ex) {
                    System.err.println("***Error\nIOException occurred: " + ex.getMessage());
                }
            }
        }
    }
}
