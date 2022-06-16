package edu.escuelaing.arsw.app.EjerciciosClase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {
    private static String actualFunction = "fun:cos";
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
            System.out.println("Mensaje: " + inputLine);
            Double numero = validateInput(inputLine);
            outputLine = "Respuesta: " + numero;
            out.println(outputLine);
            if (outputLine.equals("Respuesta: Bye.")) {
                break;
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    private static Double validateInput(String inputLine) {
        Double number;
        String[] nuevo = inputLine.split(" ");
        String function = actualFunction;
        if (nuevo.length > 1) {
            function = nuevo[0];
            number = Double.parseDouble(nuevo[1]);
        } else {
            number = Double.parseDouble(nuevo[0]);
        }
        return validateFunction(function, number);
    }
    
    private static Double validateFunction(String function, Double numero) {
        Double res = 0.0;
        if (function.equals("fun:sin")) {
            res = Math.sin(numero);
        } else if (function.equals("fun:tan")) {
            res = Math.tan(numero);
        } else if (function.equals("fun:cos")){
            res = Math.cos(numero);
        }
        actualFunction = function;
        return res;
    }
}