import bibliotecas.clases.Biblioteca;
import bibliotecas.clases.Libro;
import clases.MyScanner;

import java.util.ArrayList;

public class Main {

    private static MyScanner scanner = new MyScanner();

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(1, "Ejemplo");

        Libro libro1 = new Libro(1,"El Quijote", "Cervantes", 500, "FACAAF15122");
        Libro libro2 = new Libro(2,"Ejemplo", "Yo", 50, "AESSAF15122");
        Libro libro3 = new Libro();
        libro3.setId(scanner.pedirNumero("Inserte el id del libro: "));
        libro3.setTitulo(scanner.pideTexto("Introduce el titulo del libro: "));
        libro3.setAutor(scanner.pedirSoloTexto("Introduce el autor del libro: "));
        libro3.setNumeroPaginas(scanner.pedirNumero("Introduce el numero de paginas del libro: "));
        libro3.setISBN(scanner.pideTexto("Introduce el ISBN del libro: "));

        biblioteca.addLibro(libro1);
        biblioteca.addLibro(libro2);
        biblioteca.addLibro(libro3);

        ArrayList<Libro> libros = biblioteca.getLibros();

        int size = libros.size();

        for(int i = 0; i < size; i++) {
            System.out.println(libros.get(i));
        }
    }

}
