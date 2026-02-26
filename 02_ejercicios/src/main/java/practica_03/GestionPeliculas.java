package practica_03;

import practica_03.clases.Pelicula;
import practica_03.clases.enums.Genero;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionPeliculas {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Pelicula> peliculas = new ArrayList<>();
    private static Map<Pelicula, Integer> visualizaciones = new LinkedHashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("====== GESTIÓN DE PELÍCULAS =====" +
                    "\n1. Registrar Pelicula" +
                    "\n2. Mostrar Películas" +
                    "\n3. Ver Película" +
                    "\n4. Mostrar estadísticas de visualización" +
                    "\n5. Salir" +
                    "\nIngrese una opción: ");
            switch (opcion) {
                case 1:
                    registrarPelicula();
                    break;
                case 2:
                    Utilidades.imprimirLista(peliculas);
                    break;
                case 3:
                    visualizarPelicula();
                    break;
                case 4:
//                    Utilidades.imprimirMap(visualizaciones);
                    mostrarEstadisticasVisualizacion();
                    break;
                case 5:
                    System.out.println("Saliendo .....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
        } while (!exit);
    }

    public static void registrarPelicula() {
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código de la pelicula (3 letras y 3 números): ").toUpperCase();
        } while (!validarCodigo(codigo));
        String titulo = sc.pideTexto("Introduce el título de la pelicula: ");
        String director = sc.pideTexto("Introduce el director de la pelicula: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero de la pelicula: ");
        String fecha = sc.pideTexto("Introduce el fecha de estreno de la pelicula (YYYY-MM-DD): ");
        LocalDate fecha_estreno = LocalDate.parse(fecha);
        Pelicula pelicula = new Pelicula(codigo, titulo, director, genero, fecha_estreno);
        peliculas.add(pelicula);
        visualizaciones.put(pelicula, 0);
        System.out.println("Película registrada correctamente.");
    }

    public static boolean validarCodigo(String codigo) {
        String validadores = "^[A-Z]{3}[0-9]{3}$";
        if (!codigo.matches(validadores)) {
            System.out.println("El codigo de la pelicula no es valido.");
            return false;
        }
        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)){
                System.out.println("El codigo de la pelicula ya existe.");
                return false;
            }
        }
        return true;
    }

    public static void visualizarPelicula() {
        String codigo = sc.pideTexto("Introduce el codigo de la pelicula: ").toUpperCase();
        Pelicula pelicula = getPelicula(codigo);
        if (pelicula != null) {
            visualizaciones.put(pelicula, visualizaciones.get(pelicula) + 1);
            registrarVisualizacion(pelicula);
            System.out.println("Visualización correcta.");
        } else {
            System.out.println("No existe ninguna pelicula con el codigo: " + codigo);
        }
    }

    public static void registrarVisualizacion(Pelicula pelicula) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/Proyectos/Peliculas/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "historial_peliculas.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- VISUALIZACIÓN -----\n");
                fw.write("Fecha visualización: " + LocalDate.now() + "\n");
                fw.write("Película:\n");
                fw.write("\tCódigo: " + pelicula.getCodigo() + "\n");
                fw.write("\tTitulo: " + pelicula.getTitulo() + "\n");
                fw.write("\tDirector: " + pelicula.getDirector() + "\n");
                fw.write("-----------------------\n");

            } catch (IOException e) {
                System.out.println("Error al registrar la visualización. " + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
        }
    }

    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }

    public static Pelicula getPelicula(String codigo) {
        for (Pelicula p : peliculas) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }

    public static void mostrarEstadisticasVisualizacion() {
        for (Pelicula p : visualizaciones.keySet()) {
            System.out.println(p);
            System.out.println("Visualizaciones: " + visualizaciones.get(p));
        }
    }
}
