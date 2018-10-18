package project.habitacion.backend;

import hotelelbuendescanso.BaseDatos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    
    public List getHabitacionesByDate(Date inicio, Date salida){
        String consulta = "SELECT * FROM HABITACION WHERE NUMERO NOT IN  (SELECT NO_HABITACION FROM "
                + "RESERVACION WHERE  FECHA_INICIO < '" + fechaFormat.format(salida) + "' && FECHA_SALIDA > '"
                + fechaFormat.format(inicio) +"')";
        return DBMS.getHabitacion(consulta);
    }
    
}
