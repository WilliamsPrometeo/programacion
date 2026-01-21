package recursos;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * <p><strong>Nota:</strong> Todos los métodos son estáticos, por lo que
 * no es necesario crear objetos de esta clase.</p>
 *
 * @author Profesor - Williams
 * @version 4.0
 */
public class Utilidades {

    /** Scanner personalizado para la entrada de datos por consola */
    private static final MyScanner sc = new MyScanner();

    /** Ruta base donde se almacenan los archivos de trabajo */
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

    /**
     * Copia un archivo binario desde un origen a un destino.
     * <p>
     * Utiliza {@link FileInputStream} y {@link FileOutputStream},
     * por lo que es adecuado para copiar cualquier tipo de archivo
     * (imágenes, ejecutables, etc.).
     * </p>
     *
     * @param origen  nombre del archivo de origen (relativo a {@code RUTA})
     * @param destino nombre del archivo de destino (relativo a {@code RUTA})
     */
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

    /**
     * Copia el contenido de un archivo de texto carácter a carácter.
     * <p>
     * Utiliza {@link FileReader} y {@link FileWriter}, por lo que
     * debe usarse únicamente con archivos de texto plano.
     * </p>
     *
     * @param origen  archivo de texto de origen
     * @param destino archivo de texto de destino
     */
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

    /**
     * Crea un archivo de texto y escribe el contenido indicado.
     * <p>
     * Si el archivo ya existe, su contenido será sobrescrito.
     * </p>
     *
     * @param ruta      ruta y nombre del archivo
     * @param contenido texto que se escribirá en el archivo
     */
    public static void crearArchivoTexto(String ruta, String contenido) {

        File archivo = new File(RUTA + ruta);

        try(FileWriter fw = new FileWriter(archivo);) {
            fw.write(contenido);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo");
        }
    }

    /**
     * Comprueba si un archivo existe.
     *
     * @param ruta ruta del archivo a comprobar
     * @return {@code true} si el archivo existe, {@code false} en caso contrario
     */
    public static boolean existeArchivo(String ruta) {
        File archivo = new File(RUTA + ruta);
        return archivo.exists();
    }

    /**
     * Lista los archivos de un directorio (sin entrar en subdirectorios).
     * <p>
     * Para cada archivo se muestra:
     * nombre, tamaño en bytes y fecha de última modificación.
     * </p>
     *
     * @param ruta ruta del directorio a listar
     */
    public static void listarArchivos(String ruta) {
        File directorio = new File(ruta);

        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File file : archivos) {
                    if (file.isFile()) {
                        System.out.printf(
                                "- %20s | %5d bytes | Fecha de modificación: %7s%n",
                                file.getName(),
                                file.length(),
                                obtenerFechaModificacion(ruta + file.getName())
                        );
                    }
                }
            } else {
                System.out.println("Directorio vacio");
            }
        } else {
            System.out.println("Esto no es un directorio");
        }
    }

    /**
     * Lista de forma recursiva los archivos de un directorio y sus subdirectorios.
     * <p>
     * Primero muestra los archivos del directorio actual y después
     * entra en cada subdirectorio.
     * </p>
     *
     * @param ruta ruta del directorio inicial
     */
    public static void listarDirectorios(String ruta) {
        File directorio = new File(ruta);
        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            System.out.println(directorio.getPath() + ": ");
            if (archivos != null && archivos.length > 0) {
                for (File file : archivos) {
                    if (file.isFile()) {
                        System.out.printf(
                                "- %20s | %5d bytes | Fecha de modificación: %7s%n",
                                file.getName(),
                                file.length(),
                                obtenerFechaModificacion(ruta + file.getName())
                        );
                    }
                }
                for (File file : archivos) {
                    if (file.isDirectory()) {
                        listarDirectorios(directorio + "/" + file.getName() + "/");
                    }
                }
            } else {
                System.out.println("Directorio vacio");
            }
        } else {
            System.out.println("Esto no es un directorio");
        }
    }

    /**
     * Obtiene la fecha de última modificación de un archivo.
     *
     * @param ruta ruta del archivo
     * @return fecha formateada en {@code dd/MM/yyyy HH:mm} o {@code null}
     * si el archivo no existe
     */
    public static String obtenerFechaModificacion(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists() && archivo.isFile()) {
            long milis = archivo.lastModified();
            Date fecha = new Date(milis);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return sdf.format(fecha);
        }
        return null;
    }

    /**
     * Crea un directorio y todos los subdirectorios necesarios.
     *
     * @param ruta ruta del directorio a crear
     * @return {@code true} si se creó correctamente o ya existía,
     * {@code false} en caso de error
     */
    public static boolean crearDirectorio(String ruta) {
        return new File(ruta).mkdirs();
    }

    public static boolean existDirectory(String ruta) {
        File directorio = new File(ruta);
        return directorio.exists();
    }
}
