package clases;
import java.util.Scanner;
import java.util.ArrayList;

public class funcBiblio {
    Biblioteca biblioteca = new Biblioteca();
    MyScanner sc = new MyScanner();
    Scanner scan = new Scanner(System.in);

    public funcBiblio() {
    }

    public int eleccion1() {

        return sc.pedirNumero("---Que acción desea realizar?---\n"+
                "---1. Añadir un libro.---\n"+
                "---2. Mostrar un libro.---\n"+
                "---3. Pedir prestado un libro.---\n"+
                "---4. Devolver un libro.---\n"+
                "---5. Salir del menú.---\n");

    }
    public void sistemaBiblio() {
        boolean salir=true;
        while (salir) {
        int opcion=eleccion1();

            switch (opcion) {
                case 1:
                    anadirLibro();
                    break;
                case 2:
                    mostrarLibro();
                    break;
                case 3:
                    pedirLibro();
                    break;
                case 4:
                    devolverLibro();
                    break;
                case 5:
                    System.out.println("Biblioteca finalizada, gracias por su visita!!");
                    salir=false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
       }
    }
    public void mostrarLibro() {
        ArrayList<Libro> libros = biblioteca.getLibros();
       boolean seguir = true;

       while (seguir) {
           int otraEleccion = -1;
           if (libros.isEmpty()) {
               System.out.println("No hay libros disponibles.\n");
               otraEleccion = sc.pedirNumero("Pulse 1 si desea añadir un libro.\n" +
                       "Pulse 2 si desea salir al menú.");
           }
           if (otraEleccion==1) {
               anadirLibro();
              seguir=false;
           } else if (otraEleccion==2) {
               seguir=false;
           }else {
               for (int i = 0; i < libros.size(); i++) {
                   System.out.println("\n"+libros.get(i)+"\n");
               }
               seguir=false;
           }
       }
}
    public void anadirLibro() {
        ArrayList<Libro> libros = biblioteca.getLibros();
        int numLibros =sc.pedirNumero("Cuántos libros desea añadir?: ");
        for(int i=0;i<numLibros;i++) {
            Libro libro=new Libro();
            libro.setId(libros.size()+1);
            libro.setAutor (sc.pedirSoloTexto("Cuál es el nombre del autor?: "));
            libro.setDisponible(true);
            libro.setTitulo(sc.pedirSoloTexto("Cuál es el nombre del libro?: "));
            libro.setNumeroPaginas(sc.pedirNumero("Cuantas páginas tiene el libro?: "));
            libro.setISBN(sc.pideTexto("Cuál es el ISBN?: "));
            biblioteca.addLibro(libro);
        }

    }
    public void pedirLibro() {
        ArrayList<Libro> libros = biblioteca.getLibros();
        if(libros.isEmpty()){
            mostrarLibro();
        }else{
        for(int i=0;i<libros.size();i++) {
            if (libros.get(i).isDisponible()) {
                System.out.println(libros.get(i));
            }
        }

            int eleccion = sc.pedirNumero("Cuál es el ID del libro que quieres?: ");
            Libro libroElegido = null;
            for (Libro libro : libros) {
                if (libro.getId() == eleccion) {
                    libroElegido = libro;
                    break;
                }
            }

            if (libroElegido != null) {
                System.out.println("Elección: " + libroElegido.getTitulo());
                biblioteca.prestarLibro(libroElegido);
            } else {
                System.out.println("No existe un libro con ese ID.");
            }

            }
        }



    public void devolverLibro() {
        ArrayList<Libro> libros = biblioteca.getLibros();
        if(libros.isEmpty()){
            mostrarLibro();
        }else {
            for (int i = 0; i < libros.size(); i++) {
                if (!libros.get(i).isDisponible()) {
                    System.out.println(libros.get(i));
                }
            }
        }

        int eleccion = sc.pedirNumero("Cuál es el ID del libro que quieres devolver?: ");
        Libro libroElegido = null;

        for (Libro libro : libros) {
            if (libro.getId() == eleccion) {
                libroElegido = libro;
                break;
            }
        }

        if (libroElegido != null) {
            biblioteca.devolverLibro(libroElegido);
            System.out.println("Has devuelto: " + libroElegido.getTitulo());
        } else {
            System.out.println("No existe un libro con ese ID o no está prestado.");
        }
    }
}


