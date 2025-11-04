package programacion_clase.herencia;

import programacion_clase.herencia.clases.Coche;
import programacion_clase.herencia.enums.Marca;

public class MainHerencia {

    public static void main(String[] args) {

        Coche coche = new Coche( "Stonic", 4 );
        Coche coche2 = new Coche( "Niro", 4, 150 );
        Coche coche3 = new Coche( Marca.KIA,"Niro", 4, 150 );

        System.out.println(coche.mostrar());
        System.out.println(coche2.mostrar());
        System.out.println(coche3.mostrar());

    }
}
