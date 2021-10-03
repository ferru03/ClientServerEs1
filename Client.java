/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author andre
 */
public class Client {
    
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaServer;
    DataOutputStream scrittura;
    DataInputStream lettura;
    
    public Socket connetti(){
        System.out.println("Client in esecuzione");
        try{
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket = new Socket(nomeServer, portaServer);
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione");
        }
        return mioSocket;
    }
    
    @SuppressWarnings("deprecation")
    public void comunica(){
        try{
            System.out.println("Inserisci la stringa da trasmettere al server: ");
            stringaUtente = tastiera.readLine();
            scrittura.writeBytes(stringaUtente);
            stringaServer = lettura.readLine();
            System.out.println("risposta dal server: " + stringaServer);
            System.out.println("Chiudo comunicazione");
            mioSocket.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione del server!");
        }
    }
}
