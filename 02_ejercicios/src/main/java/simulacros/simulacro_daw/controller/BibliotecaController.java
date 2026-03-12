package simulacros.simulacro_daw.controller;

import recursos.MyScanner;
import simulacros.simulacro_daw.models.Libro;
import simulacros.simulacro_daw.service.BibliotecaService;

public class BibliotecaController {

    private static final MyScanner sc = new MyScanner();
    private static final BibliotecaService service = new BibliotecaService();

    public void addLibro() {
        boolean correcto;
        do {
            correcto = true;
            String codigo = getCodigo();
            Libro libro = service.getLibro(codigo);
            if (libro != null) {
                System.out.println("El codigo ya está asociado a un libro.");
                correcto = false;
            } else {
                String titulo = sc.pideTexto("Introudce el titulo: ");
                String autor = sc.pideTexto("Introudce el autor: ");
                service.addLibro(new Libro(codigo, titulo, autor));
                System.out.println("Libro registrado correctamente.");
            }
        } while (!correcto);
    }

    public void mostrarLibros() {
        for (Libro libro : service.getLibros()) {
            System.out.println(libro);
        }
    }

    public void cargar() {
        service.cargar();
    }

    public void guardar() {
        service.guardar();
    }

    private String getCodigo() {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código, 2 letras y 2 números: ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}
