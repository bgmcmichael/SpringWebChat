package tiy.webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by fenji on 9/13/2016.
 */
public class WebChatClient {

    static final String HOST_ADDRESS = "localhost";
    //    static final String HOST_ADDRESS = "10.0.0.129";
    static final int PORT_NUMBER = 8005;
    PrintWriter out = null;
    BufferedReader in = null;


    public String sendMessage(String message){
        String serverResponse = null;
        try {
        Socket clientSocket = new Socket(HOST_ADDRESS, PORT_NUMBER);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println(message);
            serverResponse = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(serverResponse);
        return serverResponse;
    }
}
