package project.reservacion.backend;

import hotelelbuendescanso.BaseDatos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import project.alojamiento.frontend.RegistradorAlojamiento;
import project.baseDatos.ManejadorBaseDatos;
import project.cliente.backend.ManejadorCliente;
import project.cliente.frontend.CreadorCliente;
import project.cliente.frontend.RegistradorCliente;

/**
 *
 * @author fabricio
 */
public class ManejadorReservacion {

    private BaseDatos DB = null;
    private ManejadorBaseDatos DBMS = null;
    private SimpleDateFormat fechaFormat = null;

    public ManejadorReservacion(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(this.DB);
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public List getReservaciones() {
        String consulta = "SELECT * FROM RESERVACION";
        return DBMS.getReservacion(consulta, 0, null);
    }
    
    public List getAlojamientos() {
        String consulta = "SELECT * FROM RESERVACION WHERE ESTADO = '1'";
        return DBMS.getReservacion(consulta, 0, null);
    }

    public List getReservacionesByEstado(int estado) {
        String consulta = "SELECT * FROM RESERVACION WHERE ESTADO = '" + estado + "'";
        return DBMS.getReservacion(consulta, 0, null);
    }

    public List getReservacionesByDateEntradaSalida(Date inicio, Date salida) {
        String consulta = "SELECT * FROM RESERVACION WHERE FECHA_INICIO >= '" + fechaFormat.format(inicio) 
                + "' AND FECHA_SALIDA <= '" + fechaFormat.format(salida) + "'";
        return DBMS.getReservacion(consulta, 0, null);
    }

    public List getReservacionesByDateEntradaSalidaAloj(Date inicio, Date salida) {
        String consulta = "SELECT * FROM RESERVACION WHERE FECHA_INICIO >= '" + fechaFormat.format(inicio) 
                + "' AND FECHA_SALIDA <= '" + fechaFormat.format(salida) + "' AND ESTADO = '1'";
        return DBMS.getReservacion(consulta, 0, null);
    }
    
    public void setReservacion(String dpiCliente, int noHabitacion, Date fechaInicio, Date fechaSalida,
            double precioHabitacion) throws Exception {
        if (dpiCliente.isEmpty()) {
            throw new Exception("DPI no valido, intentelo de nuevo");
        } else {
            Reservacion reservacion = new Reservacion(0, Integer.parseInt(dpiCliente), noHabitacion, fechaInicio, fechaSalida, precioHabitacion, 0, 0);
            String accion = "INSERT INTO RESERVACION(DPI_CLIENTE,NO_HABITACION,FECHA_INICIO,FECHA_SALIDA,"
                    + "PRECIO_HABITACION) VALUES (?,?,?,?,?)";
            this.DBMS.setReservacion(accion, reservacion);
        }
    }

    public List getReservacionesByDateEntrada(Date limite, int estado) {
        String consulta = "SELECT * FROM RESERVACION WHERE FECHA_INICIO < '" + fechaFormat.format(limite) + "' AND ESTADO = '" + estado + "'";
        return this.DBMS.getReservacion(consulta, 0, null);
    }

    public List getReservacionesByDateEntradaMayor(Date inicio, int estado) {
        String consulta = "SELECT * FROM RESERVACION WHERE FECHA_INICIO >= '" + fechaFormat.format(inicio) + "' AND ESTADO = '" + estado + "'";
        return this.DBMS.getReservacion(consulta, 0, null);
    }

    public List getReservacionesByDPICliente(String dpi, int estado) {
        String consulta = "SELECT * FROM RESERVACION WHERE DPI_CLIENTE = ? AND ESTADO = '" + estado + "'";
        return this.DBMS.getReservacion(consulta, 1, dpi);
    }

    public int getCantidadDias(Date inicio, Date salida) {
        String consulta = "SELECT DATEDIFF(?,?)";
        return this.DBMS.getCantidadDias(consulta, fechaFormat.format(inicio), fechaFormat.format(salida));
    }

    public void deleteReservacionByID(int id) {
        String accion = "DELETE FROM RESERVACION WHERE ID = ?";
        this.DBMS.deleteReservacion(accion, id);
    }

    public void setAlojamiento(Reservacion reservacion, double monto, RegistradorAlojamiento ra) {
        ManejadorCliente mc = new ManejadorCliente(DB);
        reservacion.setEstado(1);
        reservacion.setMonto(monto);
        String accion = "UPDATE RESERVACION SET Estado = ?, Monto = ? WHERE ID = ?";
        if (mc.getClienteByDPI(Integer.toString(reservacion.getDpiCliente())) == null) {
            CreadorCliente cc = new CreadorCliente(null, true, DB, reservacion.getDpiCliente());
            cc.setVisible(true);
            if (cc.isEstado()) {
                this.DBMS.updateReservacion(accion, reservacion);
                JOptionPane.showMessageDialog(ra, "Se ha registrado exitosamente el alojamiento \""
                        + reservacion.getId() + "\"", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            this.DBMS.updateReservacion(accion, reservacion);
            JOptionPane.showMessageDialog(ra, "Se ha registrado exitosamente el alojamiento \""
                    + reservacion.getId() + "\"", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
