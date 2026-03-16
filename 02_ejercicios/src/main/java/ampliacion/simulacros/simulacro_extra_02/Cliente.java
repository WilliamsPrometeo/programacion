package ampliacion.simulacros.simulacro_extra_02;

/**
 * Clase cliente
 * @author Alumno -
 * @version 1.0
 */
public class Cliente {
    private String id;
    private String nombre;
    private String email;

    /**
     *
     * @param id
     * @param nombre
     * @param email
     */
    public Cliente(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Getter del atributo id
     * @return el id del cliente
     */
    public String getId() {
        return id;
    }

    /**
     * Setter del atributo id
     * @param id estable el id del cliente
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Cliente: %s - Nombre: %s - Email: %s",
                getId(),
                getNombre(),
                getEmail());
    }
}
