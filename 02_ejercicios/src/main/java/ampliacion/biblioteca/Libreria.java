package ampliacion.biblioteca;

import ampliacion.biblioteca.clases.Biblioteca;
import ampliacion.biblioteca.clases.Libro;

public class Libreria {

    private static Biblioteca biblioteca;

    public static void main(String[] args) {
        Libro libro1 = new Libro("El Quijote", "Cervantes");
        Libro libro2 = new Libro("Fundación", "Isaac Asimov");

        biblioteca = new Biblioteca();

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        System.out.println("=== TODOS LOS LIBROS ===");
        biblioteca.mostrarLibros();
        String autor = "Cervantes";
        System.out.printf("%n=== BÚSQUEDA POR AUTRO: %s ===%n", autor);
        biblioteca.buscarPorAutor(autor);

    }
}
