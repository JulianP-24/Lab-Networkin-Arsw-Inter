package edu.escuelaing.arsw.app.TareaHttpServerBrowser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import edu.escuelaing.arsw.app.TareaHttpServerBrowser.Reader.FilesReader;

public class httpServerBrowser {
    public static FilesReader fileReader = new FilesReader();
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35001);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains("GET")) {
                String[] listaURL = inputLine.split("/");
                String[] get = listaURL[1].split(" ");
                if (get[0].contains(".jpg")) {
                    fileReader.img("/src/main/resources/" + get[0], clientSocket.getOutputStream());
                } else if (get[0].contains(".html")) {
                    fileReader.html("/src/main/resources/" + get[0], clientSocket.getOutputStream());
                } else if (get[0].contains(".js")) {
                    fileReader.js("/src/main/resources/" + get[0], clientSocket.getOutputStream());
                }
                
            }
            
        }
        
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
