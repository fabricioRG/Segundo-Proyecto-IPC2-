package project.baseDatos;

import hotelelbuendescanso.BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;
import project.cliente.backend.Cliente;
import project.consumo.backend.Consumo;
import project.habitacion.backend.Habitacion;
import project.menu.backend.Menu;
import project.reservacion.backend.Reservacion;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorBaseDatos {

    private Connection connection = null;
    private PreparedStatement sentencia = null;
    private SimpleDateFormat fechaFormat = null;

    public ManejadorBaseDatos(BaseDatos DB) {
        connection = DB.getConection();
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public List getUsuario(String datoUsuario, String consulta, int opcion) {
        List<Usuario> usuarios = new LinkedList<>();
        Usuario usr = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, datoUsuario);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int DPI = resultado.getInt("DPI");
                String nombre = resultado.getString("Nombre");
                String apellido = resultado.getString("Apellido");
                int tipo = resultado.getInt("Tipo");
                String usuario = resultado.getString("Nombre_Usuario");
                String password = resultado.getString("Password");
                int estado = resultado.getInt("Estado");
                usr = new Usuario(DPI, nombre, apellido, usuario, password, tipo, estado);
                usuarios.add(usr);
            }
            sentencia.close();
            if (usuarios.isEmpty()) {
                usuarios = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return usuarios;
    }

    public void setUsuario(String accion, Usuario usr) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, usr.getDPI());
            sentencia.setString(2, usr.getNombre());
            sentencia.setString(3, usr.getApellido());
            sentencia.setInt(4, usr.getTipo());
            sentencia.setString(5, usr.getUsuario());
            sentencia.setString(6, usr.getPassword());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void updateUsuario(String accion, Usuario usr) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, usr.getNombre());
            sentencia.setString(2, usr.getApellido());
            sentencia.setInt(3, usr.getDPI());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void desactivarActivarUsuario(String accion, Usuario usuario) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, usuario.getEstado());
            sentencia.setInt(2, usuario.getDPI());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getReservacion(String consulta, int opcion, String dato) {
        List<Reservacion> reservaciones = new LinkedList<>();
        Reservacion reservacion = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int dpiCliente = resultado.getInt("DPI_Cliente");
                int noHabitacion = resultado.getInt("NO_Habitacion");
                Date fechaInicio = resultado.getDate("Fecha_Inicio");
                Date fechaSalida = resultado.getDate("Fecha_Salida");
                double precioHabitacion = resultado.getDouble("Precio_Habitacion");
                double monto = resultado.getDouble("Monto");
                int estado = resultado.getInt("Estado");
                reservacion = new Reservacion(id, dpiCliente, noHabitacion, fechaInicio, fechaSalida, precioHabitacion, monto, estado);
                reservaciones.add(reservacion);
            }
            sentencia.close();
            if (reservaciones.isEmpty()) {
                reservaciones = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservaciones;
    }

    public int getCantidadDias(String consulta, String inicio, String salida) {
        int cantidadDias = 0;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setString(1, salida);
            sentencia.setString(2, inicio);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                cantidadDias = resultado.getInt(1);
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cantidadDias;
    }

    public void setReservacion(String accion, Reservacion reservacion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, reservacion.getDpiCliente());
            sentencia.setInt(2, reservacion.getNoHabitacion());
            sentencia.setString(3, fechaFormat.format(reservacion.getFechaInicio()));
            sentencia.setString(4, fechaFormat.format(reservacion.getFechaSalida()));
            sentencia.setDouble(5, reservacion.getPrecioHabitacion());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void deleteReservacion(String accion, int id) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void updateReservacion(String accion, Reservacion reserv) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, reserv.getEstado());
            sentencia.setDouble(2, reserv.getMonto());
            sentencia.setInt(3, reserv.getId());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getHabitacion(String consulta) {
        List<Habitacion> habitaciones = new LinkedList<>();
        Habitacion habitacion = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int numero = resultado.getInt("Numero");
                String tipo = resultado.getString("Tipo");
                int nivel = resultado.getInt("Nivel");
                double precio = resultado.getDouble("Precio");
                habitacion = new Habitacion(numero, tipo, nivel, precio);
                habitaciones.add(habitacion);
            }
            sentencia.close();
            if (habitaciones.isEmpty()) {
                habitaciones = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return habitaciones;
    }

    public void updateHabitacion(String accion, String dato1, String dato2) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, dato1);
            sentencia.setString(2, dato2);
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public Cliente getCliente(String consulta, String dato) {
        Cliente cliente = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setString(1, dato);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int dpi = resultado.getInt("DPI");
                String nombre = resultado.getString("Nombre");
                String apellido = resultado.getString("Apellido");
                int telefono = resultado.getInt("Telefono");
                cliente = new Cliente(dpi, nombre, apellido, telefono);
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cliente;
    }

    public List getCliente(String consulta, String dato, int opcion) {
        List<Cliente> clientes = new LinkedList<>();
        Cliente cliente = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int dpi = resultado.getInt("DPI");
                String nombre = resultado.getString("Nombre");
                String apellido = resultado.getString("Apellido");
                int telefono = resultado.getInt("Telefono");
                cliente = new Cliente(dpi, nombre, apellido, telefono);
                clientes.add(cliente);
            }
            sentencia.close();
            if (clientes.isEmpty()) {
                clientes = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return clientes;
    }

    public void setCliente(String accion, Cliente cliente) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, cliente.getDpi());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getApellido());
            sentencia.setInt(4, cliente.getTelefono());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void updateCliente(String accion, Cliente cliente) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getApellido());
            sentencia.setInt(3, cliente.getTelefono());
            sentencia.setInt(4, cliente.getDpi());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void setMenu(String accion, Menu menu) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, menu.getNombre());
            sentencia.setString(2, menu.getDescripcion());
            sentencia.setString(3, menu.getTipo());
            sentencia.setDouble(4, menu.getPrecio());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getMenu(String consulta, int opcion, String dato) {
        List<Menu> elementosMenu = new LinkedList<>();
        Menu elemento = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("Nombre");
                String descripcion = resultado.getString("Descripcion");
                String tipo = resultado.getString("Tipo");
                double precio = resultado.getDouble("Precio");
                int estado = resultado.getInt("Estado");
                elemento = new Menu(id, nombre, descripcion, tipo, precio, estado);
                elementosMenu.add(elemento);
            }
            sentencia.close();
            if (elementosMenu.isEmpty()) {
                elementosMenu = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return elementosMenu;
    }

    public Menu getMenu(String consulta, int idMenu) {
        Menu elemento = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setInt(1, idMenu);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("Nombre");
                String descripcion = resultado.getString("Descripcion");
                String tipo = resultado.getString("Tipo");
                double precio = resultado.getDouble("Precio");
                int estado = resultado.getInt("Estado");
                elemento = new Menu(id, nombre, descripcion, tipo, precio, estado);
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return elemento;
    }

    public void updateMenu(String accion, Menu menu, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            if (opcion == 1) {
                sentencia.setString(1, menu.getNombre());
                sentencia.setDouble(2, menu.getPrecio());
                sentencia.setInt(3, menu.getId());
            } else if (opcion == 2) {
                sentencia.setInt(1, menu.getEstado());
                sentencia.setInt(2, menu.getId());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void setConsumo(String accion, Consumo consumo) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, consumo.getIdMenu());
            sentencia.setInt(2, consumo.getIdReservacion());
            sentencia.setDouble(3, consumo.getMonto());
            sentencia.setString(4, fechaFormat.format(consumo.getFecha()));
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getConsumo(String consulta, String dato, int opcion) {
        List<Consumo> listaConsumo = new LinkedList<>();
        Consumo consumo = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idMenu = resultado.getInt("ID_Menu");
                int idReservacion = resultado.getInt("ID_Reservacion");
                double monto = resultado.getDouble("Monto");
                String fecha = resultado.getString("Fecha");
                Date date = fechaFormat.parse(fecha);
                consumo = new Consumo(id, idMenu, idReservacion, monto, date);
                listaConsumo.add(consumo);
            }
            sentencia.close();
            if (listaConsumo.isEmpty()) {
                listaConsumo = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listaConsumo;
    }
}
