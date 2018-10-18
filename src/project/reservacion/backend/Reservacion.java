package project.reservacion.backend;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Reservacion {

    private int id;
    private int dpiCliente;
    private int noHabitacion;
    private Date fechaInicio;
    private Date fechaSalida;
    private double precioHabitacion;
    private int estado;
    private double monto;

    public Reservacion(int id, int dpiCliente, int noHabitacion, Date fechaInicio, Date fechaSalida, double precioHabitacion, double monto, int estado) {
        this.id = id;
        this.dpiCliente = dpiCliente;
        this.noHabitacion = noHabitacion;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
        this.precioHabitacion = precioHabitacion;
        this.estado = estado;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(int dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public int getNoHabitacion() {
        return noHabitacion;
    }

    public void setNoHabitacion(int noHabitacion) {
        this.noHabitacion = noHabitacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
   
}
