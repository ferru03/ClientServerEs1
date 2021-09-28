package com.example;
import java.io.*;
import java.net.*;
public class Client {
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket connetti(){
        try{
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket = new Socket(nomeServer, portaServer);
            System.err.println("Host sconosciuto");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return mioSocket;
    }
}

