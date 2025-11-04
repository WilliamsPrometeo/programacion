package herencia.clases;

import herencia.enums.Marca;

abstract class Vehiculo {
    private Marca marca;
    private String modelo;
    private int num_ruedas;

    public Vehiculo(Marca marca, String modelo, int num_ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.num_ruedas = num_ruedas;
    }

    public Vehiculo(String modelo, int num_ruedas) {
        this.modelo = modelo;
        this.num_ruedas = num_ruedas;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNum_ruedas() {
        return num_ruedas;
    }

    public void setNum_ruedas(int num_ruedas) {
        this.num_ruedas = num_ruedas;
    }

    public abstract String mostrar();
}
