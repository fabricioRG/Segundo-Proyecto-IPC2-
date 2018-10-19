package project.consumo.backend;

/**
 *
 * @author fabricio
 */
public class Consumo {

    private int id;
    private int idMenu;
    private int idReservacion;
    private double monto;

    public Consumo(int id, int idMenu, int idReservacion, double monto) {
        this.id = id;
        this.idMenu = idMenu;
        this.idReservacion = idReservacion;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
