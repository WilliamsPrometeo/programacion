package segunda_evaluacion;

public class Caja <T extends Number>{
    private T atributo_generico;

    // Setter del atributo
    public void guardar(T atributo){
        this.atributo_generico = atributo;
    }

    //Getter del atributo
    public T obtener() {
        return atributo_generico;
    }
}
