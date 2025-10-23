package clases;

public class Direccion {
    private String calle;
    private int portal;
    private int piso;
    private char letra;

    public Direccion() {
    }

    public Direccion(String calle, int portal, int piso, char letra) {
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
        this.letra = letra;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getPortal() {
        return portal;
    }

    public void setPortal(int portal) {
        this.portal = portal;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    @Override
    public String toString() {
        return "Direccion:\n" +
                "\tCalle: '" + calle + "'\n" +
                "\tPortal: " + portal + '\n'+
                "\tPiso: " + piso + '\n' +
                "\tLetra: " + letra + '\n';
    }
}
