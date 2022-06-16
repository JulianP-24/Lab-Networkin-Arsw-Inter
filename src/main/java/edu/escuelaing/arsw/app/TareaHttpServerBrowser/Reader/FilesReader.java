package edu.escuelaing.arsw.app.TareaHttpServerBrowser.Reader;

import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;

/*
 * Clase que devuelve el archivo correspondiente segun la extension
 */
public class FilesReader {
    public FilesReader() {
    }
    
    /*
     * Metodo que devuelve una imagen
     * 
     * @param El elemento que es la ruta de la imagen y la respuesta que es un OutputStream
     */
    public void img(String element, OutputStream clientOutput) throws IOException {
        try {
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + element));
            ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
            DataOutputStream writeimg = new DataOutputStream(clientOutput);
            ImageIO.write(image, "PNG", ArrBytes);
            writeimg.writeBytes("HTTP/1.1 200 OK \r\n");
            writeimg.writeBytes("Content-Type: image/png \r\n");
            writeimg.writeBytes("\r\n");
            writeimg.write(ArrBytes.toByteArray());
        } catch (IOException e) {

        }
    }

    /*
     * Metodo que devuelve un archivo html
     * 
     * @param El elemento que es la ruta del archivo html y la respuesta que es un
     * OutputStream
     */
    public void html(String element, OutputStream outputStream) throws IOException {
        try {
            BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir") + element));
            String cont = "";
            String line;
            while ((line = read.readLine()) != null) {
                cont = cont + line;
            }
            outputStream.write(("HTTP/1.1 404 Not Found \r\n"
                    + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                    + "\r\n"
                    + cont).getBytes());
        } catch (IOException e) {
        }
    }

    /*
     * Metodo que devuelve un archivo javascript
     * 
     * @param El elemento que es la ruta del archivo javascript y la respuesta que es un
     * OutputStream
     */
    public void js(String element, OutputStream outputStream) throws IOException {
        try {
            BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir") + element));
            String cont = "";
            String line;
            while ((line = read.readLine()) != null) {
                cont = cont + line;
            }
            outputStream.write(("HTTP/1.1 404 Not Found \r\n"
                    + "Content-Type: text/javascript; charset=\"utf-8\" \r\n"
                    + "\r\n"
                    + cont).getBytes());
        } catch (IOException e) {
        }
    }
    
    /*
     * Metodo que devuelve un archivo de estilos css
     * 
     * @param El elemento que es la ruta del archivo de estilos css y la respuesta que es un
     * OutputStream
     */
    public void css(String element, OutputStream outputStream) throws IOException {
        try {
            BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir") + element));
            String cont = "";
            String line;
            while ((line = read.readLine()) != null) {
                cont = cont + line;
            }
            outputStream.write(("HTTP/1.1 404 Not Found \r\n"
                    + "Content-Type: text/css; charset=\"utf-8\" \r\n"
                    + "\r\n"
                    + cont).getBytes());
        } catch (IOException e) {
        }
    }
}
