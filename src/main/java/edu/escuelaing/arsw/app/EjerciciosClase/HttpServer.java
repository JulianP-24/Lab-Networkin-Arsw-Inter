package edu.escuelaing.arsw.app.EjerciciosClase;

import java.net.*;
import java.io.*;

public class HttpServer {

    private static HttpServer _instance = new HttpServer();

    private HttpServer(){}

    public static HttpServer getInstance(){
        return _instance;
    }

    public void start(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while(running) {
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        String path = "";
        boolean firstLine = true; 
        while ((inputLine = in.readLine()) != null) {
            if(firstLine){
                path = inputLine.split(" ")[0];
                System.out.println(path);
                firstLine = false;
            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
    
        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title of the document</title>\n" + "</head>"
                + "<body>"
                + "My Web Site </br>"
                + "<img src='https://th.bing.com/th/id/R.d9c2773b1c241854571d1bdad23af4a5?rik=Au1AINhvAWZmRg&riu=http%3a%2f%2f4.bp.blogspot.com%2f-QMGOoEe7ORo%2fUictQ1DRsJI%2fAAAAAAAB4ow%2fQ3F1jbR67fo%2fs1600%2fcerca-del-cielo-y-los-planetas-im%c3%a1genes-de-fantas%c3%ada-close-to-sky-landscape-1920x1200-wallpaper-.jpg&ehk=7N3VXXUF7ESxVu%2fJqYAG2lwflwMsjAwn7hdRxBGsJms%3d&risl=&pid=ImgRaw&r=0'>"
                + "</body>"
                + "</html>" + inputLine;

        out.println(outputLine);
    

        out.close();

        in.close();

        clientSocket.close();
    }
        serverSocket.close();
    }
}
