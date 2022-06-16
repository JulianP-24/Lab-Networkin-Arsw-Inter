package edu.escuelaing.arsw.app.TareaHttpServerBrowser.Reader;

import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;

public class FilesReader {
    public FilesReader() {
    }
    
    public  void img(String element, OutputStream clientOutput) throws IOException {
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

    public  void html(String element, OutputStream outputStream) throws IOException {
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
