package clases;

public class GestionBiblioteca {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        funcBiblio mostrarBiblioteca = new funcBiblio();

        String nombreBiblioteca = sc.pedirSoloTexto("Introduzca el nombre de su biblioteca...");
        System.out.println("Biblioteca Inicializada...\n\n");

        System.out.println("Bienvenido/a a: " + nombreBiblioteca+"\n\n");

        mostrarBiblioteca.sistemaBiblio();



    }

}
