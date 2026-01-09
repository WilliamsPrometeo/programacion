package segunda_evaluacion;

import recursos.MyScanner;

import java.io.*;

public class Main {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

//        try (FileReader fr = new FileReader("texto.txt")){
//            int caracter;
//            while ((caracter = fr.read()) != -1) {
//                System.out.print((char)caracter);
//            }
//        } catch (IOException e) {
//            System.out.println("Error al abrir archivo");
//        }
//
//        try(FileWriter fw = new FileWriter("otro.txt")) {
//            String texto = "Estoy escribiendo en un archivo de texto";
//            fw.write(texto);
//        } catch (IOException e) {
//            System.out.println("Error al escribir en el archivo");
//        }

//        try (
//            FileReader fr = new FileReader("texto.txt");
//            FileWriter fw = new FileWriter("otro.txt");
//            ){
//            StringBuilder texto = new StringBuilder();
//            int caracter;
//            while ((caracter = fr.read()) != -1) {
//                texto.append((char) caracter);
//            }
//            fw.write(texto.toString());
//        } catch (IOException e) {
//            System.out.println("ERROR");
//        }

        try (
            FileInputStream fis = new FileInputStream("images.jpg");
            FileOutputStream fos = new FileOutputStream("otraimagen.jpg");
        ) {
            int bytes;
            while ((bytes = fis.read()) != -1) {
                fos.write(bytes);
            }
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
