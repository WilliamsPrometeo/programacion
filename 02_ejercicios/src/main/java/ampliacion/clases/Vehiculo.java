package ampliacion.clases;

public class Vehiculo {
    private String marca;
    private int velocidad;

    public Vehiculo() {
    }

    public Vehiculo(String marca, int velocidad) {
        this.marca = marca;
        this.velocidad = velocidad;
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

    @Override
    public String toString() {
        return "Vehiculo: " +
                "marca='" + marca + '\'' +
                ", velocidad=" + velocidad;
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
