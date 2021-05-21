/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mio.prova.ioFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Rodolfo Pio Sassone
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*File sorgente = new File(args[0]);
        File destinazione = new File(args[1]);
        BufferedInputStream in = null;
        BufferedOutputStream out = null;*/

        Person p1 = new Person("Mario", "Rossi", 32);

        ObjectOutputStream outObject = null;
        ObjectInputStream inObject = null;

        try {
            /*destinazione.createNewFile();
            in = new BufferedInputStream( new FileInputStream(sorgente));
            out = new BufferedOutputStream( new FileOutputStream(destinazione));
            
            int c = in.read();
            if (c == -1) {
                System.out.println("Il file sorgente è vuoto!");
            } else {
                while (c!= -1) {
                    out.write(c);
                    c = in.read();
                }
                if (c == -1) {
                    System.out.println("Copia effettuata con successo");
                }*/

            outObject = new ObjectOutputStream(new FileOutputStream("resources/destinazione.txt"));
            inObject = new ObjectInputStream(new FileInputStream("resources/destinazione.txt"));
            
            outObject.writeObject(p1);      //come ci si sposta alla fine del file?????
            
            System.out.println((Person)inObject.readObject());
            
        } catch (FileNotFoundException ex) {
            System.err.println("***Error FileNotFoundException occurred: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("***Error IOException occurred: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("***Error ClassNotFoundException occurred: " + ex.getMessage());
        } finally {
            /*if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.err.println("***Error IOException occurred: " + ex.getMessage());
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.err.println("***Error IOException occurred: " + ex.getMessage());
                }
            }*/

            if (inObject != null) {
                try {
                    inObject.close();
                } catch (IOException ex) {
                    System.err.println("***Error IOException occurred: " + ex.getMessage());
                }
            }
            if (outObject != null) {
                try {
                    outObject.close();
                } catch (IOException ex) {
                    System.err.println("***Error IOException occurred: " + ex.getMessage());
                }
            }
        }
    }
}
