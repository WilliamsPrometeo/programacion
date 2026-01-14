package recursos;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Clase de utilidades con métodos estáticos reutilizables.
 * <p>
 * Esta clase agrupa operaciones comunes que se repiten en muchos programas:
 * impresión de colecciones, gestión de menús y selección de valores enum.
 * </p>
 * <p>
 * El objetivo es reducir código duplicado y simplificar los métodos main.
 * </p>
 *
 * @author Profesor - Williams
 * @version 2.0
 */
public class Utilidades {

    private static final MyScanner sc = new MyScanner();
    private static final String RUTA = "02_ejercicios/datos/";

    /**
     * Imprime por consola todos los elementos de una lista, uno por línea.
     * <p>
     * Este metodo evita repetir bucles {@code for} cada vez que se
     * quiere mostrar una colección por pantalla.
     * </p>
     *
     * @param <T>       tipo de los elementos de la lista
     * @param coleccion lista con los elementos a imprimir
     */
    public static <T> void imprimirLista(ArrayList<T> coleccion) {
        if (!coleccion.isEmpty()) {
            for (T elemento : coleccion) {
                System.out.println(elemento);
            }
        } else {
            System.out.println("Lista vacia");
        }
    }

    /**
     * Imprime por consola el contenido de un {@link Map}.
     * <p>
     * Cada entrada se muestra en formato:
     * <pre>
     * clave -> valor
     * </pre>
     * </p>
     * <p>
     * Se utiliza {@code entrySet()} para acceder directamente a la clave
     * y al valor sin realizar búsquedas adicionales.
     * </p>
     *
     * @param <K>  tipo de la clave
     * @param <V>  tipo del valor
     * @param mapa mapa que se desea imprimir
     */
    public static <K, V> void imprimirMap(Map<K, V> mapa) {
        for (Map.Entry<K, V> entrada : mapa.entrySet()) {
            System.out.printf("%s -> %s%n",
                    entrada.getKey(),
                    entrada.getValue());
        }
    }

    /**
     * Muestra un menú basado en un {@code enum} y devuelve el valor seleccionado.
     * <p>
     * El metodo muestra todas las constantes del enum numeradas
     * y solicita al usuario una opción válida.
     * </p>
     * <p>
     * De esta forma se evita el uso de {@code switch} largos y repetitivos
     * cada vez que se quiere elegir un valor de un enum.
     * </p>
     *
     * @param <E>      tipo del enum
     * @param tipoEnum clase del enum que se quiere mostrar
     * @param mensaje  texto que se mostrará antes del menú
     * @return valor del enum seleccionado por el usuario
     */
    public static <E extends Enum<E>> E pedirEnum(
            Class<E> tipoEnum,
            String mensaje) {

        E[] valores = tipoEnum.getEnumConstants();
        int opcion;

        do {
            System.out.println(mensaje);
            for (int i = 0; i < valores.length; i++) {
                System.out.println((i + 1) + ". " + valores[i]);
            }
            opcion = sc.pedirNumero("Elige una opción: ");

        } while (opcion < 1 || opcion > valores.length);

        return valores[opcion - 1];
    }

    public static void copiarArchivo(String origen, String destino) {
        File ruta_origen = new File(RUTA + origen);
        File ruta_destino = new File(RUTA + destino);

        if (!ruta_origen.exists()) {
            System.out.println("El archivo de origen no existe");
        } else {
            try (
                    FileInputStream fis = new FileInputStream(ruta_origen);
                    FileOutputStream fos = new FileOutputStream(ruta_destino);
            ) {
                int bytes;
                while ((bytes = fis.read()) != -1) {
                    fos.write(bytes);
                }

                System.out.println("Archivo copiado correctamente");
            } catch (IOException e) {
                System.out.println("ERROR " + e.getMessage());
            }
        }

    }


    public static void copiarTexto(String origen, String destino) {

        File ruta_origen = new File(RUTA + origen);
        File ruta_destino = new File(RUTA + destino);

        if (!ruta_origen.exists()) {
            System.out.println("El archivo de origen no existe");
        } else {
            try (
                    FileReader fr = new FileReader(ruta_origen);
                    FileWriter fw = new FileWriter(ruta_destino)
            ) {
                int caracter;
                while ((caracter = fr.read()) != -1) {
                    fw.write(caracter);
                }

                System.out.println("Texto copiado correctamente.");

            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

    }

    public static void crearArchivoTexto(String ruta, String contenido) {

        File archivo = new File(RUTA + ruta);

        try(FileWriter fw = new FileWriter(archivo);) {
            fw.write(contenido);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }
    }

    public static boolean existeArchivo(String ruta) {
        File archivo = new File(RUTA + ruta);
        return archivo.exists();
    }

}
