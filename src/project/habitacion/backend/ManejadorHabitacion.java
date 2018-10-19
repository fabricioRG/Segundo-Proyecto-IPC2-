package project.habitacion.backend;

import hotelelbuendescanso.BaseDatos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import project.baseDatos.ManejadorBaseDatos;

/**
 *
 * @author fabricio
 */
public class ManejadorHabitacion {

    private BaseDatos DB = null;
    private ManejadorBaseDatos DBMS = null;
    private SimpleDateFormat fechaFormat = null;

    public ManejadorHabitacion(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(this.DB);
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public List getHabitacionesByDate(Date inicio, Date salida) {
        String consulta = "SELECT * FROM HABITACION WHERE NUMERO NOT IN  (SELECT NO_HABITACION FROM "
                + "RESERVACION WHERE  FECHA_INICIO < '" + fechaFormat.format(salida) + "' && FECHA_SALIDA > '"
                + fechaFormat.format(inicio) + "')";
        return DBMS.getHabitacion(consulta);
    }

    public void updateHabitacionPrecio(String precio, String tipo) throws Exception {
        if (precio.isEmpty()) {
            throw new Exception("No se han completado todas las casillas");
        } else if (precio.contains("-")) {
            throw new Exception("No se pueden ingresar numero negativos");
        } else {
            String accion = "UPDATE HABITACION SET PRECIO = ? WHERE TIPO = ?";
            this.DBMS.updateHabitacion(accion, precio, tipo);
            JOptionPane.showMessageDialog(null, "Se ha modificado exitosamente el precio", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List getHabitaciones() {
        String consulta = "SELECT * FROM HABITACION";
        return this.DBMS.getHabitacion(consulta);
    }

    public List getHabitacionByTipo(String tipo) {
        String consulta = "SELECT * FROM HABITACION WHERE TIPO = '" + tipo + "'";
        return this.DBMS.getHabitacion(consulta);
    }

}
