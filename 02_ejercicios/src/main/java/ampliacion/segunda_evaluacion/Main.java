package ampliacion.segunda_evaluacion;

import ampliacion.segunda_evaluacion.enums.Genero;
import recursos.MyScanner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

//        System.out.println(fecha.getYear());
//        System.out.println(fecha.getMonthValue());
//        System.out.println(fecha.getMonth());
//        System.out.println(fecha.getDayOfMonth());
//        System.out.println(fecha.getDayOfWeek());
//        System.out.println(fecha.getDayOfYear());

//        LocalTime hora = LocalTime.now();
//        LocalDateTime fecha_hora = LocalDateTime.now();
//
//        DateTimeFormatter formatter_fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        DateTimeFormatter formatter_hora = DateTimeFormatter.ofPattern("HH:mm:ss");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
//
//        String fecha_formateada = fecha.format(formatter_fecha);
//        String hora_formateada = hora.format(formatter_hora);
//
//        String saludo = "Hola hoy es: " + fecha_formateada + " y son las: " + hora_formateada;
//
//        System.out.println(saludo);
//        System.out.println(fecha_hora.format(formatter));

        LocalDate fecha = LocalDate.now();
        LocalDate insertada = LocalDate.of(2020, 2, 1);
        LocalDate fecha2 = LocalDate.now();

//        Period periodo = Period.between(insertada, LocalDate.now());
//        System.out.println("Años: " + periodo.getYears());
//        System.out.println("Meses: " + periodo.getMonths());
//        System.out.println("Dias: " + periodo.getDays());
//
//        long dias = ChronoUnit.DAYS.between(insertada, fecha);
//        System.out.println("Dias: " + dias);

        if (fecha.getYear() < insertada.getYear()) {
            System.out.println("Fecha es mayor");
        } else {
            System.out.println("Insertada es mayor");
        }

        if (fecha.isAfter(insertada)) {
            System.out.println("cosas que hacer");
        }

        LocalDate fecha_vencimiento = LocalDate.of(2026, 1, 30);
        if (fecha_vencimiento.minusDays(14).isBefore(fecha)) {
            System.out.println("Producto a menos de dos semanas de caducar, poner en oferta");
        }

        System.out.println("Fecha: " + fecha.plusDays(5));

        System.out.println(fecha.isAfter(insertada));
        System.out.println(fecha.isBefore(insertada));
        System.out.println(fecha.isEqual(fecha2));

//        boolean correcto;
//        do {
//            correcto = true;
//            try {
//                String fecha_nacimiento = sc.pideTexto("Ingrese su fecha de nacimiento (YYYY-MM-DD): ");
//                LocalDate fecha_date = LocalDate.parse(fecha_nacimiento);
////                System.out.println(fecha_date.format(formatter_fecha));
//                Persona persona = new Persona("123", "Paco", "Perez", Genero.MASCULINO, Genero.OTRO.ordinal(), fecha_date);
//                System.out.println(persona.getGenero2());
//            } catch (DateTimeParseException e){
//                System.out.println("Formato de fecha incorrecto");
//                System.out.println(e.getMessage());
//                correcto = false;
//            }
//        } while (!correcto);

//        System.out.println(fecha_date.format(formatter_fecha));
//
//        int edad = fecha.getYear() - fecha_date.getYear();
//        System.out.println(edad);

//        Persona persona2 = new Persona("123", "Maria", "Perez", Genero.FEMENINO);
//
//        System.out.println(persona.getGenero());

//        System.out.println(persona.equals(persona2));
//        persona2.setDni("345");
//        System.out.println(persona.equals(persona2));

//        Map<Persona, String> mapa = new HashMap<Persona, String>();
//
//        mapa.put(persona, "Este es Paco, tiene un saludo");
//        mapa.put(persona2, "Este es Maria, tiene un saludo");
    }
}
