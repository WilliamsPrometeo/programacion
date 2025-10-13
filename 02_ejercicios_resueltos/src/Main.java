import clases.Direccion;
import clases.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Williams", "Infanzon", 27);
        Direccion direccion = new Direccion("Ejemplo", 36, 7, 'B');
        persona.setDireccion(direccion);
        System.out.printf(persona.toString());
    }
}
