package ampliacion.gestion_usuarios;

import ampliacion.gestion_usuarios.exceptions.InvalidPasswordException;
import ampliacion.gestion_usuarios.exceptions.InvalidUsernameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionUsuario {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("==== GESTIÓN DE USUARIOS ====");
                System.out.println("1. Validar nombre de usuario" +
                        "\n2. Validar contraseña" +
                        "\n3. Salir");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        String validacion_nombre = validarNombre() != null ? "Validación correcta" : "Validación incorrecta";
                        System.out.println(validacion_nombre);
                        break;
                    case 2:
                        String validacion_password = validarPassword() != null ? "Validación correcta" : "Validación incorrecta";
                        System.out.println(validacion_password);
                        break;
                    case 3:
                        System.out.println("... Saliendo ...");
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("La opcion tiene que ser numerica.");
                sc.nextLine();
            }
        } while (opcion != 3);
    }

    public static String validarNombre() {
        try {
            String nombre = pideNombre();
            return nombre;
        } catch (InvalidUsernameException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String validarPassword() {
        try {
            String password = pidePassword();
            return password;
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String pideNombre() throws InvalidUsernameException {
        System.out.println("Introuce el nombre: ");
        String nombre = sc.nextLine();
        if (nombre.length() >= 3 && nombre.matches("[A-Za-z0-9]+")) {
            return nombre;
        }
        throw new InvalidUsernameException("Nombre incorrecto.");
    }

    public static String pidePassword() throws InvalidPasswordException {
        System.out.println("Introduce la contraseña: ");
        String password = sc.nextLine();
        if (password.length() >= 6 && password.matches(".*[0-9].*") && password.matches(".*[A-Z].*")) {
            return password;
        }
        throw new InvalidPasswordException("La contraseña debe tener al menos un número y una mayuscula.");
    }
}
