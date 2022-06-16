package edu.escuelaing.arsw.app.EjerciciosClase;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * Hello world!
 *
 */
public class AppURL 
{

    public static void main( String[] args )
    {
        try {
            URL facebookURL = new URL("https://www.escuelaing.edu.co:443/es/campus/recreacion-y-deporte/");
            System.out.println("Authority: " + facebookURL.getAuthority()+"\n");
            System.out.println("Host: " + facebookURL.getHost()+"\n");
            System.out.println("Port: " + facebookURL.getPort()+"\n");
            System.out.println("Path: " + facebookURL.getPath()+"\n");
            System.out.println("Query: " + facebookURL.getQuery()+"\n");
            System.out.println("File: " + facebookURL.getFile()+"\n");
            System.out.println("Ref: " + facebookURL.getRef()+"\n");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
