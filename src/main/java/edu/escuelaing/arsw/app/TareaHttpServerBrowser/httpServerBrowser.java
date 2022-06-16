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
        String inputLine;
        String path = "";
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains("GET")) {
                path = inputLine.split("/")[1];
                path = path.split(" ")[0];
                if (path.contains(".jpg")) {
                    fileReader.img("/src/main/resources/" + path, clientSocket.getOutputStream());
                } else if (path.contains(".html")) {
                    fileReader.html("/src/main/resources/" + path, clientSocket.getOutputStream());
                } else if (path.contains(".js")) {
                    fileReader.js("/src/main/resources/" + path, clientSocket.getOutputStream());
                } else if (path.contains(".css")) {
                    fileReader.css("/src/main/resources/" + path, clientSocket.getOutputStream());
                }
                
            }
            
        }
        
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
