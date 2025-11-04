package ejemplos_clase.herencia.clases;

import ejemplos_clase.herencia.enums.Marca;

public class Coche extends Vehiculo {

    private int cv;

    public Coche(Marca marca, String modelo, int num_ruedas, int cv) {
        super(marca, modelo, num_ruedas);
        this.cv = cv;
    }

    public Coche(String modelo, int num_ruedas, int cv) {
        super(modelo, num_ruedas);
        this.cv = cv;
    }

    public Coche(String modelo, int num_ruedas) {
        super(modelo, num_ruedas);
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String mostrar() {
        return "Esto es un coche: " + super.getMarca() + super.getModelo() + this.getCv();
    }

}
