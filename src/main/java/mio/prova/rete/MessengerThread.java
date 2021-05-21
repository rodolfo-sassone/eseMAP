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
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class MessengerThread extends Thread {

    private final Socket socket;

    private boolean run = true;

    private PrintWriter out;

    private final ManagerClients mc;

    private String username;

    public MessengerThread(Socket socket, String name, ManagerClients mc) {
        super(name);
        this.socket = socket;
        this.mc = mc;
    }
    
    public void sendMessage(String message)throws Exception{
        if(out!=null) 
            out.println(message);
        else
            throw new Exception("Errore nello stream. Impossibile ricevere messaggi.");
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Connessione stabilita");
            while (run) {
                try {
                    String str = in.readLine().trim();
                    Pattern p = Pattern.compile("\\S+");
                    Matcher m = p.matcher(str);
                    boolean findcmd = m.find();
                    if (findcmd && m.group().equalsIgnoreCase("#name")) {
                        if (m.find()) {
                            String name = m.group();
                            mc.addClient(name, this);
                            out.println("#ok");
                            username = name;
                        } else {
                            throw new Exception("Nessuna stringa presente dopo il comando #name");
                        }
                    } else if (findcmd && m.group().equalsIgnoreCase("#exit")) {
                        mc.removeClient(username);
                        out.println("#ok");
                        run = false;
                    } else if (findcmd && m.group().equalsIgnoreCase("#send")) {
                        String receiver = null;
                        String msg = null;
                        if (m.find()) {
                            receiver = m.group();
                            if (!str.substring(m.end()).trim().isEmpty()) {
                                msg = str.substring(m.end()).trim();
                                mc.sendMessage(username, receiver, msg);
                                out.println("#ok");
                            } else {
                                throw new Exception("Nessun messaggio");
                            }
                        } else {
                            throw new Exception("Nessun destinatario e nessun messaggio");
                        }
                    }
                    else 
                    {
                        out.println("Comando non valido");
                    }
                } catch (Exception ex) {
                    out.println("#error " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("***Error\nIOException Occurred: " + ex.getMessage());
        }

    }

}
