package segunda_evaluacion.libreria.persistencia;

import recursos.MyLogger;
import segunda_evaluacion.libreria.GestionLibreria;
import segunda_evaluacion.libreria.clases.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FicheroLibro {

    private static final String NOMBRE_FICHERO = "libros.dat";
    private static final String STOCK = "stock.dat";

    public static void guardarLibros(ArrayList<Libro> libros) {

        MyLogger.logInfo(FicheroLibro.class.getSimpleName(),"Iniciando guardado de libros");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO))) {
            oos.writeObject(libros);
            MyLogger.logInfo(FicheroLibro.class.getSimpleName(),"Libros guardados correctamente en el fichero");
        } catch (IOException e) {
            MyLogger.logError(
                    FicheroLibro.class.getSimpleName(),
                    "Error al guardar los libros",
                    e
            );
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Libro> recuperarLibros() {
        ArrayList<Libro> libros = new ArrayList<>();

        File file = new File(NOMBRE_FICHERO);

        if (file.exists()) {
            MyLogger.logInfo(FicheroLibro.class.getSimpleName(),"Accediendo a fichero de libros");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                libros = (ArrayList<Libro>) ois.readObject();
                MyLogger.logInfo(FicheroLibro.class.getSimpleName(),"Libros recuperados correctamente");
            } catch (IOException | ClassNotFoundException e){
                MyLogger.logError(
                        FicheroLibro.class.getSimpleName(),
                        "Error al recuperar los libros",
                        e
                );
                System.out.println(e.getMessage());
            }
        }
        return libros;
    }

    public static void guardarStock(Map<Libro, Integer> stock) {
        MyLogger.logInfo(FicheroLibro.class.getSimpleName(),"Iniciando guardado de stock");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STOCK))){
            oos.writeObject(stock);
            MyLogger.logInfo(FicheroLibro.class.getSimpleName(),"Stock guardado correctamente");
        } catch (IOException e) {
            MyLogger.logError(
                    FicheroLibro.class.getSimpleName(),
                    "Error al guardar el stock",
                    e
            );
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<Libro, Integer> recuperarStock() {
        Map<Libro, Integer> stock = new LinkedHashMap<>();
        File file = new File(STOCK);
        if (file.exists()) {
            MyLogger.logInfo(FicheroLibro.class.getSimpleName(),"Accediendo a fichero de stock");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                stock = (Map<Libro, Integer>) ois.readObject();
                MyLogger.logInfo(FicheroLibro.class.getSimpleName(),"Stock recuperado correctamente");
            } catch (IOException | ClassNotFoundException e){
                MyLogger.logError(
                        FicheroLibro.class.getSimpleName(),
                        "Error al recuperar el stock",
                        e
                );
                System.out.println(e.getMessage());
            }
        }
        return stock;
    }
}
