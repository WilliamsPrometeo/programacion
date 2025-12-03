package ampliacion.gestion_usuarios;

import ampliacion.gestion_usuarios.exceptions.InvalidPasswordException;
import ampliacion.gestion_usuarios.exceptions.InvalidUsernameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionUsuario {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("==== GESTIÓN DE USUARIOS ====");
                System.out.println("1. Registrar usuario" +
                        "\n2. Buscar usuario" +
                        "\n3. Iniciar con usuario" +
                        "\n4. Salir");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("La opcion tiene que ser numerica.");
            }
        } while (opcion != 4);
    }

    public static void registroUsuario() {
        String nombre;
        String password;
        boolean nombre_correcto;
        do {
            try {
                nombre = pideNombre();
                nombre_correcto = true;
            } catch (InvalidUsernameException e) {
                System.out.println(e.getMessage());
                nombre_correcto = false;
            }
        } while (!nombre_correcto);

        boolean password_corecto;
        do {
            try {
                password = pidePassword();
                password_corecto = true;
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
                password_corecto = false;
            }
        } while (!password_corecto);
    }

    public static String pideNombre() throws InvalidUsernameException {
        String nombre = sc.nextLine();
        if (nombre.length() >= 3 && nombre.matches("[A-Za-z0-9]+")) {
            return nombre;
        }
        throw new InvalidUsernameException("Nombre incorrecto.");
    }

    public static String pidePassword() throws InvalidPasswordException {
        String password = sc.nextLine();
        if (password.length() >=6 && password.matches(".*[0-9].*") && password.matches(".*[A-Z].*")) {
            return password;
        }
        throw new InvalidPasswordException("La contraseña debe tener al menos un número y una mayuscula.");
    }
}
