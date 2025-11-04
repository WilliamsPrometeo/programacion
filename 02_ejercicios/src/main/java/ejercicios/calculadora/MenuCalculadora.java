package ejercicios.calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuCalculadora {

    public static void main (String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("---------Menu Calculadora----------");
            System.out.println("\t1. Sumar");
            System.out.println("\t2. Restar");
            System.out.println("\t3. Multiplicar");
            System.out.println("\t0. Salir");
            int opcion = comprobar(" Opcion:  ");
            int num1 = -1;
            int num2 = -1;
            if (opcion != 0) {
                if (opcion > 0 && opcion < 4){
                    num1 = comprobar("\nIntroduce el primer número: ");
                    num2 = comprobar("\nIntroduce el segundo numero: ");
                }
                switch (opcion) {
                    case 1:
                        System.out.println("El resultado de la suma es: " + suma(num1, num2) + "\n");
                    break;
                    case 2:
                        System.out.println("El resultado de la resta es: " + resta(num1, num2) + "\n");
                    break;
                    case 3:
                        System.out.println("El resultado de la multiplicación es: " + multiplicacion(num1, num2) + "\n");
                    break;
                    default:
                        System.out.println("*****Opcion no valida*****");
                    break;
                }
            } else {
                System.out.println("\n*****Hasta Luego*****");
                exit = true;
            }
        }
        sc.close();
    }

    private static int suma(int a, int b) {
        return a + b;
    }
    private static int resta(int a, int b) {
        return a - b;
    }
    private static int multiplicacion(int a, int b) {
        return a * b;
    }

    private static int comprobar(String mns) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.print(mns);
                n = sc.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es número!");
                sc.nextLine();
            }
        }
        return n;
    }
}
