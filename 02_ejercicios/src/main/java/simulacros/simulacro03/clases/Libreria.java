package simulacros.simulacro03.clases;

import recursos.MyScanner;
import simulacros.simulacro03.enums.Genero;
import simulacros.simulacro03.exception.UserNotFound;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Libreria {

    private static final MyScanner sc = new MyScanner();

    private ArrayList<Libro> disponibles;
    private Map<Usuario, Libro> prestamos;
    private ArrayList<Usuario> usuarios;

    public Libreria() {
        disponibles = new ArrayList<>();
        prestamos = new LinkedHashMap<>();
        usuarios = new ArrayList<>();
    }

    public ArrayList<Libro> getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(ArrayList<Libro> disponibles) {
        this.disponibles = disponibles;
    }

    public Map<Usuario, Libro> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Map<Usuario, Libro> prestamos) {
        this.prestamos = prestamos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void registrarUsuario() {
        Persona usuario = new Usuario();
        usuario.setNombre(sc.pedirSoloTexto("Introduce el nombre del usuario: "));
        String dni;
        do {
            dni = sc.pideTexto("Introduce la DNI del usuario: ");
            String mensaje = dni.length() == 9 ? "DNI correcto" : "El DNI tiene que tener exactamente 9 caracteres";
            System.out.println(mensaje);
        } while (dni.length() != 9);
        usuario.setDni(dni);

        usuarios.add((Usuario) usuario);
    }

    public void registrarLibro() {
        String titulo = sc.pideTexto("Introduce la titulo del libro: ");
        String autor = sc.pideTexto("Introduce la autor: ");
        Genero genero = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Ficcion" +
                    "\n2. No ficcion" +
                    "\n3. Misterio" +
                    "\n4. Tecnico" +
                    "\n5. Romance" +
                    "\n6. Drama" +
                    "\nIntroduce la opcion del genero: ");
            switch (opcion_genero) {
                case 1:
                    genero = Genero.FICCION;
                    break;
                case 2:
                    genero = Genero.NO_FICCION;
                    break;
                case 3:
                    genero = Genero.MISTERIO;
                    break;
                case 4:
                    genero = Genero.TECNICO;
                    break;
                case 5:
                    genero = Genero.ROMANCE;
                    break;
                case 6:
                    genero = Genero.DRAMA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        disponibles.add(new Libro(titulo, autor, genero));
    }

    public String prestarLibro() {
        String dni = sc.pideTexto("Introduce el DNI del usuario: ");
        Usuario usuario;
        Libro libro = null;
        try {
            usuario = buscarUsuario(dni);

        } catch (UserNotFound e) {
            System.out.println(e.getMessage());
            usuario = null;
        }
        if (usuario != null) {
            if (mostarLibros()) {
                String titulo = sc.pideTexto("Introduce el titulo del libro: ");
                libro = buscarLibro(titulo);
                if (libro != null) {
                    disponibles.remove(libro);
                    prestamos.put(usuario, libro);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    String fecha_formateada = LocalDateTime.now().format(formatter);
                    System.out.printf("Fecha de prestamo: %s del libro: %s", fecha_formateada, libro.getTitulo());
                } else {
                    System.out.println("No hay ningun libro con ese titulo disponible!");
                }
            }
        } else {
            System.out.println("No existe el usuario con ese DNI!");
        }
        return (usuario != null && libro != null) ? "Libro prestado correctamente" : "Error en el proceso.";
    }

    public boolean mostarLibros() {
        if (!disponibles.isEmpty()) {
            for (Libro libro : disponibles) {
                System.out.println(libro);
            }
            boolean correcto;
            do {
                char opcion = sc.pedirLetra("¿Quiere filtrar por Género? (S/N)");
                switch (opcion) {
                    case 'S':
                    case 's':
                        filtroGenero();
                        correcto = true;
                        break;
                    case 'N':
                    case 'n':
                        correcto = true;
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
            return true;
        } else {
            System.out.println("No hay libros disponibles");
            return false;
        }
    }

    public void filtroGenero() {
        Genero genero = null;
        boolean correcto;
        do {
            correcto = true;
            int opcion_genero = sc.pedirNumero("1. Ficcion" +
                    "\n2. No ficcion" +
                    "\n3. Misterio" +
                    "\n4. Tecnico" +
                    "\n5. Romance" +
                    "\n6. Drama" +
                    "\nIntroduce la opcion del genero: ");
            switch (opcion_genero) {
                case 1:
                    genero = Genero.FICCION;
                    break;
                case 2:
                    genero = Genero.NO_FICCION;
                    break;
                case 3:
                    genero = Genero.MISTERIO;
                    break;
                case 4:
                    genero = Genero.TECNICO;
                    break;
                case 5:
                    genero = Genero.ROMANCE;
                    break;
                case 6:
                    genero = Genero.DRAMA;
                    break;
                default:
                    correcto = false;
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
        for (Libro libro : disponibles) {
            if (genero == libro.getGenero()) {
                System.out.println(libro);
            }
        }
    }

    public void mostarPrestamos() {
        for (Usuario user: prestamos.keySet()) {
            System.out.printf("Prestamo: Usuario: %s, Libro: %s", user.getNombre(), prestamos.get(user));
        }
    }

    public Usuario buscarUsuario(String dni) throws UserNotFound {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        throw new UserNotFound("Usuario no encontrado");
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : disponibles) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }
}
