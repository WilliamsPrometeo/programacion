import exceptions.MyExcetion;

public class MainException {

    private static MyScanner sc =  new MyScanner();

    public static void main(String[] args) throws MyExcetion {

        try {
            int base = 500;

            int sacar = sc.pedirNumero("Ingrese la cantidad a retirar: ");

            if (sacar > base) {
                throw new MyExcetion("❌ No tiene tanto dinero!");
            }

            System.out.println("Ha sacado " + sacar + " correctamente!");
        } catch (MyExcetion e) {

            System.out.println(e.getMessage());

        } finally {
            System.out.println("Fin del programa.");
            sc.cerrar();
        }

    }
}
