import clases.Biblioteca;
import clases.Libro;

import java.util.ArrayList;

public class GestionBiblioteca {

    private static final MyScanner sc = new MyScanner();

    static void main(String[] args) {
        menuBiblioteca(obtenerBiblioteca());
    }

    public static void menuBiblioteca(Biblioteca biblioteca) {

        ArrayList<Libro> listaLibros = biblioteca.getLibros();
        boolean continuar = true;
        while (continuar) {
            System.out.println("********* Menu Biblioteca 📚 **********");
            System.out.println("\t1. Mostrar Libros");
            System.out.println("\t2. Añadir Libro");
            System.out.println("\t3. Prestar Libro");
            System.out.println("\t4. Devolver Libro");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero("Opcion: ");
            switch (opcion) {
                case 1:
                    mostrarLibros(listaLibros);
                break;
                case 2:
                    biblioteca.addLibro(crearLibro(listaLibros));
                break;
                case 3:
                    ArrayList<Libro> disponibles = librosDisponibles(listaLibros);
                    Libro prestar = pedirLibro(disponibles);
                    if (prestar != null) {
                        biblioteca.prestarLibro(prestar);
                    }
                break;
                case 4:
                    ArrayList<Libro> prestados = librosPrestados(listaLibros);
                    Libro devolver = pedirLibro(prestados);
                    if (devolver != null) {
                        biblioteca.devolverLibro(devolver);
                    }
                break;
                case 0:
                    System.out.println("****** Saliendo 🏃🏽‍♂️‍➡️ ******");
                    System.out.println("--------------------------");
                    System.out.println("**** Hasta luego! 👋🏽 ****");
                    continuar = false;
                break;
                default:
                    System.out.println("❌::ERROR:: -> Opcion incorrecta");
                break;
            }
        }
    }

    public static Biblioteca obtenerBiblioteca(){
        Biblioteca biblioteca = new Biblioteca();
        String nombreBiblioteca = sc.pideTexto("Introduce el nombre de biblioteca: ");
        biblioteca.setId(1);
        biblioteca.setNombre(nombreBiblioteca);

        return biblioteca;
    }

    public static boolean mostrarLibros(ArrayList<Libro> libros){
        boolean notEmpty = true;
        if (libros.isEmpty()){
            System.out.println("Libros no encontrados");
            notEmpty = false;
        } else {
            System.out.println("*********** Libros **********");
            for(Libro libro : libros){
                System.out.println(libro);
            }
        }
        return notEmpty;
    }

    public static ArrayList<Libro> librosDisponibles(ArrayList<Libro> libros){
        ArrayList<Libro> disponibles = new ArrayList<>();
        if (!libros.isEmpty()){
            for(Libro libro : libros){
                if (libro.isDisponible()){
                    disponibles.add(libro);
                }
            }
        }
        return disponibles;
    }

    public static ArrayList<Libro> librosPrestados(ArrayList<Libro> libros){
        ArrayList<Libro> prestados = new ArrayList<>();
        if (!libros.isEmpty()){
            for(Libro libro : libros){
                if (!libro.isDisponible()){
                    prestados.add(libro);
                }
            }
        }
        return prestados;
    }

    public static Libro pedirLibro(ArrayList<Libro> libros){
        boolean existe = false;
        Libro libroPrestado = null;
        if (mostrarLibros(libros)){
            do {
                int idLibro = sc.pedirNumero("Introduce el id del libro: ");
                for (Libro libro : libros){
                    if (libro.getId() == idLibro){
                        existe = true;
                        libroPrestado = libro;
                        break;
                    }
                }
            }while (!existe);
        }

        return libroPrestado;
    }

    public static Libro crearLibro(ArrayList<Libro> libros){
        Libro libro = new Libro();
        libro.setId(idUnicoLibro(libros));
        libro.setTitulo(sc.pideTexto("Introduce el titulo del libro: "));
        libro.setAutor(sc.pedirSoloTexto("Introduce el autor del libro: "));
        libro.setNumeroPaginas(sc.pedirNumero("Introduce el numero de paginas del libro: "));
        libro.setISBN(sc.pideTexto("Introduce el ISBN del libro: "));
        System.out.println("Libro creado: \n\t" + libro);
        return libro;
    }

    public static int idUnicoLibro(ArrayList<Libro> libros){
        boolean unico = true;
        int idLibro = 0;
        do {
            idLibro = sc.pedirNumero("Introduce el id del libro: ");
            for (Libro libro : libros) {
                if (libro.getId() == idLibro) {
                    System.out.println("El id introducido del libro ya está asignado a otro libro");
                    unico = false;
                }
            }
        } while (!unico);
        return idLibro;
    }


}
