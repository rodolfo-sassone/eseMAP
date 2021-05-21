/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mio.prova.rete;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rodolfo Pio Sassone
 */
public class ManagerClients {
    private final Map<String,MessengerThread> clients = new HashMap<>();
    
    public synchronized void addClient(String username, MessengerThread t) throws Exception {
        if(clients.containsKey(username))
            throw new Exception("Utente già esistente");
        else
            clients.put(username, t);
    }
    
    public synchronized void removeClient(String username) throws Exception {
        if(!clients.containsKey(username))
            throw new Exception("Utente inesistente");
        else
            clients.remove(username);
    }
    
    public synchronized void sendMessage(String sender, String receiver, String message) throws Exception{
        if(clients.containsKey(receiver))
        {
            MessengerThread t = clients.get(receiver);
            t.sendMessage(sender + ": " + message);
        }
        else
            throw new Exception("Destinario inesistente");
    }
}
