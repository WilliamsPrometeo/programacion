package ampliacion.clases;

import recursos.MyScanner;

public class MainClases {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
//        Persona persona1 = new Persona();
//
//        System.out.println(persona1.getNombre());
//        persona1.setNombre("Luis");
//        System.out.println(persona1.getNombre());
//        System.out.println(persona1.getApellido());
//        System.out.println(persona1.getEdad());
//
//        System.out.println(persona1);
//
//        Persona persona2 = new Persona("David", "Gutierrez", 25);
//        System.out.println(persona2.getNombre());
//        System.out.println(persona2.getApellido());
//        System.out.println(persona2.getEdad());

        Vehiculo vehiculo = new Vehiculo("Mercedes", 200);
        System.out.println(vehiculo);

        vehiculo.acelerar(50);

        System.out.println(vehiculo);

        vehiculo.frenar(25);

        System.out.println(vehiculo);

        vehiculo.parar();

        System.out.println(vehiculo);

    }
}
