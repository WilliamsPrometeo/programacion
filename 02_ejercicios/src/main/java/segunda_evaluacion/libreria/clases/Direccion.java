package segunda_evaluacion.libreria.clases;

import segunda_evaluacion.libreria.clases.enums.Provincia;

public class Direccion {
    private String calle;
    private int num_portal;
    private int num_piso;
    private char letra_piso;
    private int cod_postal;
    private Provincia provincia;

    public Direccion(String calle, int num_portal, int num_piso, char letra_piso, int cod_postal, Provincia provincia) {
        this.calle = calle;
        this.num_portal = num_portal;
        this.num_piso = num_piso;
        this.letra_piso = letra_piso;
        this.cod_postal = cod_postal;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNum_portal() {
        return num_portal;
    }

    public void setNum_portal(int num_portal) {
        this.num_portal = num_portal;
    }

    public int getNum_piso() {
        return num_piso;
    }

    public void setNum_piso(int num_piso) {
        this.num_piso = num_piso;
    }

    public char getLetra_piso() {
        return letra_piso;
    }

    public void setLetra_piso(char letra_piso) {
        this.letra_piso = letra_piso;
    }

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return String.format("Direccion: %s %d, %d %c, %d, %s %n", calle,  num_portal, num_piso, letra_piso, cod_postal, provincia);
    }
}
