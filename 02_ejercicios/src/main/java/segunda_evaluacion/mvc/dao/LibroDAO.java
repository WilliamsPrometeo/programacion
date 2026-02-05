package segunda_evaluacion.mvc.dao;

import recursos.MyLogger;
import segunda_evaluacion.mvc.models.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LibroDAO {

    private static final String NOMBRE_FICHERO = "libros.dat";
    private static final String STOCK = "stock.dat";

    public void guardarLibros(ArrayList<Libro> libros) {

        MyLogger.logInfo(this.getClass().getSimpleName(),"Iniciando guardado de libros");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO))) {
            oos.writeObject(libros);
            MyLogger.logInfo(this.getClass().getSimpleName(),"Libros guardados correctamente en el fichero");
        } catch (IOException e) {
            MyLogger.logError(
                    this.getClass().getSimpleName(),
                    "Error al guardar los libros",
                    e
            );
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Libro> recuperarLibros() {
        ArrayList<Libro> libros = new ArrayList<>();

        File file = new File(NOMBRE_FICHERO);

        if (file.exists()) {
            MyLogger.logInfo(this.getClass().getSimpleName(),"Accediendo a fichero de libros");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                libros = (ArrayList<Libro>) ois.readObject();
                MyLogger.logInfo(this.getClass().getSimpleName(),"Libros recuperados correctamente");
            } catch (IOException | ClassNotFoundException e){
                MyLogger.logError(
                        this.getClass().getSimpleName(),
                        "Error al recuperar los libros",
                        e
                );
                System.out.println(e.getMessage());
            }
        }
        return libros;
    }

    public void guardarStock(Map<Libro, Integer> stock) {
        MyLogger.logInfo(this.getClass().getSimpleName(),"Iniciando guardado de stock");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STOCK))){
            oos.writeObject(stock);
            MyLogger.logInfo(this.getClass().getSimpleName(),"Stock guardado correctamente");
        } catch (IOException e) {
            MyLogger.logError(
                    this.getClass().getSimpleName(),
                    "Error al guardar el stock",
                    e
            );
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Libro, Integer> recuperarStock() {
        Map<Libro, Integer> stock = new LinkedHashMap<>();
        File file = new File(STOCK);
        if (file.exists()) {
            MyLogger.logInfo(this.getClass().getSimpleName(),"Accediendo a fichero de stock");
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                stock = (Map<Libro, Integer>) ois.readObject();
                MyLogger.logInfo(this.getClass().getSimpleName(),"Stock recuperado correctamente");
            } catch (IOException | ClassNotFoundException e){
                MyLogger.logError(
                        this.getClass().getSimpleName(),
                        "Error al recuperar el stock",
                        e
                );
                System.out.println(e.getMessage());
            }
        }
        return stock;
    }
}
