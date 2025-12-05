package ampliacion.simulacros;

import ampliacion.simulacros.exceptions.InvalidPasswordException;
import ampliacion.simulacros.exceptions.InvalidUsernameException;
import ampliacion.simulacros.exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GestionUsuarios {
    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, String> usuarios = new HashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion = 0;
        do {
            try {
                System.out.println("==== GESTIÓN DE USUARIOS ====");
                System.out.println("1. Registrar usuario" +
                        "\n2. Buscar usuario" +
                        "\n3. Iniciar con usuario" +
                        "\n4. Salir" +
                        "\nOpcion: ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        registrarUsuario();
                        break;
                    case 2:
                        buscarUsuario();
                        break;
                    case 3:
                        try {
                            iniciarUsuario();
                        }  catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("... Saliendo ...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("La opcion tiene que ser numerica!");
                sc.nextLine();
            }
        } while (opcion != 4);
    }


    public static void iniciarUsuario() throws UserNotFoundException {
        System.out.println("Introduzca el nombre del usuario: ");
        String username = sc.nextLine();
        if (!usuarios.containsKey(username)) {
            throw new UserNotFoundException("Usuario no encontrado!");
        }
        String passUser = usuarios.get(username);

        System.out.println("Introduzca la contraseña del usuario: ");
        String password = sc.nextLine();

        boolean validPass = password.equals(passUser);

        System.out.println(validPass ? "Acceso permitido!" : "Contraseña incorrecta");
    }

    public static void buscarUsuario() {
        System.out.println("Introduce el nombre del usuario: ");
        String nombre = sc.nextLine();
        try {
            if (usuarios.containsKey(nombre)) {
                System.out.println("Usuario encontrado: " + nombre);
            } else {
                throw new UserNotFoundException("Usuario no encontrado!");
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void registrarUsuario() {
        String username = "";
        String password = "";
        boolean correcto;

        do {
            try {
                username = validarUsuario();
                correcto = true;
            } catch (InvalidUsernameException e) {
                correcto = false;
            }
        } while (!correcto);

        do {
            try {
                password = validarPassword();
                correcto = true;
            } catch (InvalidPasswordException e) {
                correcto = false;
            }
        } while (!correcto);

        usuarios.put(username, password);
        System.out.println("Usuario registrado correctamente!");
    }

    public static String validarUsuario() throws InvalidUsernameException {
        String usuario = sc.nextLine();
        if (usuario.length() >= 3 && usuario.matches("[A-Za-z0-9]+")) {
            return usuario;
        }
        throw new InvalidUsernameException("Nombre de usuario no valido");
    }

    public static String validarPassword() throws InvalidPasswordException {
        String password = sc.nextLine();
        if (password.length() >= 6 && password.matches(".*[0-9].*") && password.matches(".*[A-Z].*")) {
            return password;
        }
        throw new InvalidPasswordException("Contraseña no valida");
    }
}
