package project.habitacion.backend;

/**
 *
 * @author fabricio
 */
public class Habitacion {
    
    private int numero;
    private String tipo;
    private int nivel;
    private double precio;

    public Habitacion(int numero, String tipo, int nivel, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.nivel = nivel;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
