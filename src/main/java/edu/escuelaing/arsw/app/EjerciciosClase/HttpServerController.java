package edu.escuelaing.arsw.app.EjerciciosClase;

import java.io.IOException;

public class HttpServerController {
    public static void main(String[] args){
        HttpServer sv = HttpServer.getInstance();
        try {
            sv.start(args);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
}
