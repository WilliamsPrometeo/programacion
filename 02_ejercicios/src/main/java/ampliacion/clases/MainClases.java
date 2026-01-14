package ampliacion.clases;

import ampliacion.clases.enums.Color;
import recursos.MyScanner;

public class MainClases {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

//        Vehiculo vehiculo = new Vehiculo("Mercedes", 200, Color.AMARILLO);
//
//        if (vehiculo.getColor() == Color.AMARILLO) {
//            System.out.println("Tu vehiculo tiene una multa por amarillo");
//        }
//
//        vehiculo.setColor(Color.BLANCO);
//
//        System.out.println(vehiculo.getColor());

        Direccion direccion = new Direccion("Calle 1", 28054);
        Persona persona = new Persona("Pepe", "Perez", 26, direccion);
        Persona persona1 = new Persona("Paco", "Delucia", 50, new Direccion("Calle 2", 28040));

        System.out.println(persona);

        Direccion aux = persona.getDireccion();

        System.out.println(aux.getCalle());
        System.out.println(aux.getCod_postal());

    }
}
