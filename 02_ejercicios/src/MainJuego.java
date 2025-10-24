import clases.Personaje;

import java.util.Scanner;

public class MainJuego {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner( );

        Personaje pj1 = new Personaje(1000, 100, 200);
        Personaje pj2 = new Personaje(1000, 100, 200);

        System.out.println("Que va a hacer el pj1: ");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        int opcion1 = sc.pedirNumero("Opcion: ");
        System.out.println("Que va a hacer el pj2: ");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        int opcion2 = sc.pedirNumero("Opcion: ");


        if (opcion1 == 1 && opcion2 == 2) {
            int ataque = pj1.getAtaque();
            int defensa = pj2.getDefensa();
            pj2.setDefensa(defensa - ataque);
        } else if (opcion1 == 2 && opcion2 == 1) {
            int ataque = pj2.getAtaque();
            int defensa = pj1.getDefensa();
            pj1.setDefensa(defensa - ataque);
        } else if (opcion1 == 1 && opcion2 == 1) {
            int vida1 =  pj2.getVida();
            int ataque1 = pj1.getAtaque();
            pj2.setVida(vida1 - ataque1);
            int vida2 =  pj1.getVida();
            int ataque2 = pj2.getAtaque();
            pj1.setVida(vida2 - ataque2);
        }

    }

}
