package ampliacion.clases;

import ampliacion.clases.enums.Color;
import recursos.MyScanner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainClases {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        Direccion direccion = new Direccion("Calle 1", 28054);

        Persona persona1 = new Persona("Pepe", "Guzman", 26, direccion);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");

        System.out.println(persona1.getFecha_creacion().format(formatter));

//        LocalDate fecha = LocalDate.now();
//
//        LocalTime hora = LocalTime.now();
//
//        LocalDateTime fecha_hora = LocalDateTime.now();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
//        String fecha_formateada = fecha_hora.format(formatter);
//
//        System.out.println(fecha);
//        System.out.println(hora);
//        System.out.println(fecha_formateada);

    }
}
