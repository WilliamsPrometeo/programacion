package ejemplos_clase;

public class DebugEjemplo {
    public static void main(String[] args) {
        int resultado = sumarNumeros(5);
        System.out.println("El resultado final es: " + resultado);
    }

    public static int sumarNumeros(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }
}
