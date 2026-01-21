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

//        Direccion direccion = new Direccion("Calle 1", 28054);
//
//        Persona persona1 = new Persona("Pepe", "Guzman", 26, direccion);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        System.out.println(persona1.getFecha_creacion().format(formatter));
//
//        String fecha = sc.pideTexto("Ingrese una fecha (YYYY-MM-DD): ");
//        LocalDate date = LocalDate.parse(fecha);
//
//        Persona persona2 = new Persona("Paco", "Lucia", 45, direccion, date);
//
//        System.out.println(persona2.getFecha_creacion().format(formatter));
//
//        LocalDate fecha1 = persona1.getFecha_creacion();
//        LocalDate fecha2 = persona2.getFecha_creacion();
//
//        System.out.println(fecha2.getYear() - fecha1.getYear());

//        String nacimiento = sc.pideTexto("Introduce tu fecha de nacimiento (YYYY-MM-DD): ");
//        LocalDate fecha_nacimiento = LocalDate.parse(nacimiento);
//
//        System.out.println(fecha_nacimiento.getDayOfMonth());
//        System.out.println(fecha_nacimiento.getDayOfWeek());
//        System.out.println(fecha_nacimiento.getDayOfYear());

        System.out.println(LocalDate.now().getDayOfMonth());
        System.out.println(LocalDate.now().getDayOfWeek());
        System.out.println(LocalDate.now().getDayOfYear());

        System.out.println(LocalDate.now().getMonth());
        System.out.println(LocalDate.now().getMonthValue());

//        int edad = LocalDate.now().getYear() - fecha_nacimiento.getYear();
//
//        System.out.println(edad);

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
