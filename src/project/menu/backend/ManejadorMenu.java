package project.menu.backend;

import hotelelbuendescanso.BaseDatos;
import java.util.List;
import javax.swing.JOptionPane;
import project.baseDatos.ManejadorBaseDatos;

/**
 *
 * @author fabricio
 */
public class ManejadorMenu {

    private BaseDatos DB = null;
    private ManejadorBaseDatos DBMS = null;

    public ManejadorMenu(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(DB);
    }

    public void setMenu(String nombre, String descripcion, String tipo, String precio) throws Exception {
        if (nombre.isEmpty() || descripcion.isEmpty() || precio.isEmpty()) {
            throw new Exception("Ingrese todo los datos necesarios");
        } else if (nombre.length() > 20 || descripcion.length() > 100) {
            throw new Exception("El tamaño de las cadenas de 'Nombre' o 'Descripcion' superan el limite maximo");
        } else {
            String accion = "INSERT INTO MENU ( NOMBRE, DESCRIPCION, TIPO, PRECIO ) VALUES ( ?, ?, ?, ? )";
            Menu menu = new Menu(0, nombre, descripcion, tipo, Double.parseDouble(precio), 0);
            this.DBMS.setMenu(accion, menu);
            JOptionPane.showMessageDialog(null, "Se ha creado exitosamente un nuevo elemento en el menu",
                    "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List getMenu() {
        String consulta = "SELECT * FROM MENU";
        return this.DBMS.getMenu(consulta, 0, null);
    }

    public List getMenuByTipo(String tipo) {
        String consulta = "SELECT * FROM MENU WHERE TIPO = ?";
        return this.DBMS.getMenu(consulta, 1, tipo);
    }

    public void updateMenu(Menu menu, String nombre, String precio) throws Exception {
        if (nombre.isEmpty() || precio.isEmpty()) {
            throw new Exception("Ingrese los campos necesarios");
        } else if (nombre.length() > 20 || precio.contains("-")) {
            throw new Exception("Datos invalidos, intentelo de nuevo");
        } else {
            menu.setNombre(nombre);
            menu.setPrecio(Double.parseDouble(precio));
            String accion = "UPDATE MENU SET NOMBRE = ?, PRECIO = ? WHERE ID = ?";
            this.DBMS.updateMenu(accion, menu, 1);
            JOptionPane.showMessageDialog(null, "Se ha modificado correctamente el elemento con ID '" + 
                    menu.getId() + "'", "Accion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void deshabilitarHabilitarMenu(Menu menu, int estado){
        menu.setEstado(estado);
        String accion = "UPDATE MENU SET ESTADO = ? WHERE ID = ?";
        this.DBMS.updateMenu(accion, menu, 2);
        JOptionPane.showMessageDialog(null, "Se ha modificado correctamente el elemento con ID '" + 
                    menu.getId() + "'", "Accion Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

}
