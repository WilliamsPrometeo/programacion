package segunda_evaluacion.libreria.persistencia;

import segunda_evaluacion.libreria.clases.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FicheroLibro {

    private static final String NOMBRE_FICHERO = "libros.dat";
    private static final String STOCK = "stock.dat";

    public static void guardarLibros(ArrayList<Libro> libros) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO))) {
            oos.writeObject(libros);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Libro> recuperarLibros() {
        ArrayList<Libro> libros = new ArrayList<>();

        File file = new File(NOMBRE_FICHERO);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                libros = (ArrayList<Libro>) ois.readObject();
            } catch (IOException | ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        return libros;
    }

    public static void guardarStock(Map<Libro, Integer> stock) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STOCK))){
            oos.writeObject(stock);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<Libro, Integer> recuperarStock() {
        Map<Libro, Integer> stock = new LinkedHashMap<>();
        File file = new File(STOCK);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                stock = (Map<Libro, Integer>) ois.readObject();
            } catch (IOException | ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        return stock;
    }
}
