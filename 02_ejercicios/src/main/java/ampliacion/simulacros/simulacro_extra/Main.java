package ampliacion.simulacros.simulacro_extra;

import recursos.MyScanner;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;

        do {

            System.out.println("\n--- GESTIÓN BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Guardar en fichero");
            System.out.println("4. Cargar desde fichero");
            System.out.println("5. Salir");

            opcion = sc.pedirNumero("Opcion: ");
            switch (opcion) {

                case 1:
                    biblioteca.agregarLibro(pideLibro());
                    break;
                case 2:
                    biblioteca.mostrarLibros();
                    break;
                case 3:
                    biblioteca.guardarEnFichero("libros.txt");
                    break;
                case 4:
                    biblioteca.cargarDesdeFichero("libros.txt");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 5);

        sc.cerrar();
    }

    private static Libro pideLibro() {
        String codigo = sc.pideTexto("Codigo: ");

        String titulo = sc.pideTexto("Título: ");

        String autor = sc.pideTexto("Autor: ");
        return new Libro(codigo, titulo, autor);
    }
}
