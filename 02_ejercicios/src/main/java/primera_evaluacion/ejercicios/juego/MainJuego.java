package primera_evaluacion.ejercicios.juego;

import recursos.MyScanner;
import primera_evaluacion.ejercicios.juego.clases.Personaje;

public class MainJuego {
    private static final MyScanner sc = new MyScanner( );

    public static void main(String[] args) {

        Personaje pj1 = new Personaje("Pikachu",1000, 100, 200);
        Personaje pj2 = new Personaje("Ratata",1000, 100, 200);

        System.out.println("******* PROMETEO GAME *******");
        System.out.printf("Personajes: %n%s%n%s%n", pj1,pj2);
        System.out.println("******* START *******");
        partida(pj1,pj2);

    }

    public static int menuPersonaje(Personaje pj) {
        boolean correcta;
        int opcion;
        do {
            System.out.printf("Personaje: %s%n", pj);
            System.out.printf("Que va a hacer %s: %n", pj.getNombre());
            System.out.println("\t1. Atacar");
            System.out.println("\t2. Defender");
            opcion = sc.pedirNumero("Opcion: ");
            if (opcion<1 || opcion>2) {
                System.out.println("Opcion incorrecta");
                correcta = false;
            } else if (opcion==2 && pj.getDefensa() <= 0) {
                System.out.println("No puedes defenderte! Atacaran a tu vida");
                correcta = true;
                opcion = 3;
            } else {
                correcta = true;
            }
        } while (!correcta);

        return opcion;
    }

    public static void partida(Personaje pj1, Personaje pj2) {
        int turnos = 5;

        for (int i = 0; i < turnos; i++) {
            int accionpj1 = menuPersonaje(pj1);
            int accionpj2 = menuPersonaje(pj2);
            if (accionpj1 == 1 && accionpj2 == 2) {
                int ataque = pj1.getAtaque();
                int defensa = pj2.getDefensa();
                pj2.setDefensa(defensa - ataque);
            } else if (accionpj1 == 2 && accionpj2 == 1) {
                int ataque = pj2.getAtaque();
                int defensa = pj1.getDefensa();
                pj1.setDefensa(defensa - ataque);
            } else if (accionpj1 == 1 && accionpj2 == 1) {
                int vida1 =  pj2.getVida();
                int ataque1 = pj1.getAtaque();
                pj2.setVida(vida1 - ataque1);
                int vida2 =  pj1.getVida();
                int ataque2 = pj2.getAtaque();
                pj1.setVida(vida2 - ataque2);
            } else if (accionpj1 == 1 && accionpj2 == 3) {
                int vida3 =  pj2.getVida();
                int ataque3 = pj1.getAtaque();
                pj2.setVida(vida3 - ataque3);
            } else if (accionpj1 == 3 && accionpj2 == 1) {
                int vida4 =  pj1.getVida();
                int ataque4 = pj2.getAtaque();
                pj1.setVida(vida4 - ataque4);
            }
            if (pj1.getVida() == 0) {
                System.out.printf("GANADOR : %10s👑", pj2.getNombre());
                return;
            } else if (pj2.getVida() == 0) {
                System.out.printf("GANADOR : %10s👑", pj1.getNombre());
                return;
            }
        }

        if (pj1.getVida() > pj2.getVida()) {
            System.out.printf("GANADOR : %10s👑", pj1.getNombre());
        }  else if (pj1.getVida() < pj2.getVida()){
            System.out.printf("GANADOR : %10s👑", pj2.getNombre());
        } else if (pj1.getVida() == pj2.getVida()) {
            System.out.println("EMPATE 👑");
        }

    }

}
