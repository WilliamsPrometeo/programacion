package ejemplos_clase.herencia;

import ejemplos_clase.herencia.clases.*;
import ejemplos_clase.herencia.enums.Marca;

public class GestionConcesionario {

    public static void main(String[] args) {

        Coche kia = new Coche(Marca.KIA, 14999.99, 5, true);
        System.out.println(kia.getFecha_matriculacion());
        System.out.println(kia.mostrar());
        Moto ducati = new Moto(Marca.DUCATI, 9999.99, 250, false);
        System.out.println(ducati.getFecha_matriculacion());
        System.out.println(ducati.mostrar());

        Persona empleado = new Empleado("Carlos", "Carlos", 35, 15025);
        Persona cliente = new Cliente("Williams", "Williams", 27, 555);
        System.out.println(empleado);
        System.out.println(cliente);

    }
}
