package ampliacion.simulacros.simularo04;

import ampliacion.simulacros.simularo04.clases.Registro;
import ampliacion.simulacros.simularo04.enums.Tipo;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionRegistros {

    private static final MyScanner sc = new MyScanner();

    private static Registro[] registros = new Registro[20];
    private static int contador = 0;

    public static void main(String[] args) {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("-----Registros------" +
                    "\n1. Añadir Registro" +
                    "\n2. Mostrar Registros" +
                    "\n3. Filtrar por año" +
                    "\n4. Filtrar por mes" +
                    "\n5. Filtrar por rango" +
                    "\n6. Salir" +
                    "\nIngrese la opción");
            switch (opcion){
                case 1:
                    addRegistro();
                    break;
                case 2:
                    mostrarRegistros();
                    break;
                case 3:
                    filtroYear();
                    break;
                case 4:
                    filtroMonth();
                    break;
                case 5:
                    filtroRango();
                    break;
                case 6:
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }

        } while (!exit);
    }

    public static void addRegistro() {
        boolean correcto;
        LocalDate fecha_creacion = null;
        do {
            correcto = true;
            try {
                String fecha = sc.pideTexto("Ingrese la fecha de creación (YYYY-MM-DD): ");
                fecha_creacion = LocalDate.parse(fecha);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        Tipo tipo_registro = Utilidades.pedirEnum(Tipo.class, "Seleccione el tipo de registro: ");

        String contenido = sc.pideTexto("Ingrese el contenido del registro: ");

        if (contador < registros.length) {
            registros[contador] = new Registro(fecha_creacion, tipo_registro, contenido);
            contador++;
        } else {
            System.out.println("La lista de registros ya esta llena.");
        }
    }

    public static void mostrarRegistros() {
        for (int i = 0; i < registros.length; i++) {
            System.out.println(registros[i]);
        }
    }

    public static void filtroYear() {
        int year = sc.pedirNumero("Ingrese el año para filtrar: ");
        System.out.println(obtenerRegistroPorAnio(year));
    }

    public static void filtroMonth() {
        int month = sc.pedirNumero("Ingrese el mes para filtrar: ");
        System.out.println(obtenerRegistroPorMes(month));
    }

    public static void filtroRango() {
        int min_year = sc.pedirNumero("Ingrese el año mínimo: ");
        int max_year = sc.pedirNumero("Ingrese el año máximo: ");
        System.out.println(obtenerRegistroEnRango(min_year, max_year));
    }

    public static Registro obtenerRegistroPorAnio(int year) {
        for (int i = 0; i < registros.length ; i++) {
            if (registros[i].getFechaCreacion().getYear() == year) {
                return registros[i];
            }
        }
        return null;
    }

    public static Registro obtenerRegistroPorMes(int month) {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i].getFechaCreacion().getMonthValue() == month) {
                return registros[i];
            }
        }
        return null;
    }

    public static Registro obtenerRegistroEnRango (int min_year, int max_year) {
        for (int i = 0; i < registros.length; i++) {
            int year = registros[i].getFechaCreacion().getYear();
            if (min_year < year && year > max_year) {
                return registros[i];
            }
        }
        return null;
    }
}
