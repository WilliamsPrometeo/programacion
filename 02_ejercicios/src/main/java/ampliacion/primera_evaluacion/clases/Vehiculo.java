package ampliacion.primera_evaluacion.clases;

import ampliacion.primera_evaluacion.clases.enums.Color;

public class Vehiculo {
    private String marca;
    private int velocidad;
    private Color color;

    public Vehiculo() {
    }

    public Vehiculo(String marca, int velocidad, Color color) {
        this.marca = marca;
        this.velocidad = velocidad;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", velocidad=" + velocidad +
                ", color=" + color +
                '}';
    }

    //Metodo
    public void acelerar(int velocidad) {
        this.velocidad += velocidad;
    }

    public void frenar(int velocidad) {
        this.velocidad -= velocidad;
    }

    public void parar() {
        this.velocidad = 0;
    }
}
