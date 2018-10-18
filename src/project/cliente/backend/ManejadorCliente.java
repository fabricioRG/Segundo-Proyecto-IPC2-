package project.cliente.backend;

import hotelelbuendescanso.BaseDatos;
import java.util.List;
import javax.swing.JOptionPane;
import project.baseDatos.ManejadorBaseDatos;

/**
 *
 * @author fabricio
 */
public class ManejadorCliente {

    private BaseDatos DB = null;
    private ManejadorBaseDatos DBMS = null;

    public ManejadorCliente(BaseDatos DB) {
        this.DB = DB;
        this.DBMS = new ManejadorBaseDatos(this.DB);
    }
    
    public List getClientes(){
        String consulta = "SELECT * FROM CLIENTE";
        return this.DBMS.getCliente(consulta, null, 0);
    }
    
    public List getClientesByName(String nombre){
        String consulta = "SELECT * FROM CLIENTE WHERE NOMBRE = ?";
        return this.DBMS.getCliente(consulta, nombre, 1);
    }
    
    public Cliente getClienteByDPI(String dpi){
        String consulta = "SELECT * FROM CLIENTE WHERE DPI = ?";
        return this.DBMS.getCliente(consulta, dpi);
    }
    
    public void crearCliente(String dpi, String nombre, String apellido, String telefono) throws Exception{
        if(dpi.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty()){
            throw new Exception("Hay datos sin llenar, intentelo de nuevo");
        } else if(nombre.length() > 20 || apellido.length() > 20){
            throw new Exception("Ha superado el maximo de caracteres validos (20)");
        } else if(getClienteByDPI(dpi) != null){
            throw new Exception("Ingrese de nuevo el DPI, pues ya existe");
        } else {
            String accion = "INSERT INTO CLIENTE (DPI,NOMBRE,APELLIDO,TELEFONO) VALUES (?,?,?,?)";
            Cliente cliente = new Cliente(Integer.parseInt(dpi), nombre, apellido, Integer.parseInt(telefono));
            this.DBMS.setCliente(accion, cliente);
            JOptionPane.showMessageDialog(null, "Se ha creado exitosamente el cliente '" + nombre + "'", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
