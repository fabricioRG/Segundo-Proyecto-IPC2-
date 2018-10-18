package project.cliente.backend;

/**
 *
 * @author fabricio
 */
public class Cliente {
 
    private int dpi;
    private String nombre;
    private String apellido;
    private int telefono;

    public Cliente(int dpi, String nombre, String apellido, int telefono) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
