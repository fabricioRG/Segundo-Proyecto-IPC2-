package project.usuario.backend;

import hotelelbuendescanso.BaseDatos;
import project.frontend.HotelDescktop;
import project.baseDatos.ManejadorBaseDatos;
import project.usuario.ManejadorUsuario;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ManejadorFrontEndUsuario {

    HotelDescktop hd = null;
    ManejadorUsuario mu = null;
    private BaseDatos DB = null;

    public ManejadorFrontEndUsuario(BaseDatos DB) {
        this.DB = DB;
        this.mu = new ManejadorUsuario(this.DB);
    }

    public void showHotelDesktop(String nombre, char[] password, BaseDatos DB) throws Exception {
        String passwordUsuario = new String(password);
        Usuario usr = null;
        if (nombre.isEmpty()) {
            throw new Exception("No se ha ingresado un \"nombre de usuario\" valido");
        } else if (passwordUsuario.replaceAll(" ", "").isEmpty()) {
            throw new Exception("No se ha ingresado una \"contraseña\" valida");
        }
        if (mu.getUsuarioByNombreUsuario(nombre) != null) {
            usr = (Usuario) mu.getUsuarioByNombreUsuario(nombre).get(0);
            if (!(usr.getPassword().equals(passwordUsuario))) {
                throw new Exception("La contraseña es incorrecta");
            } else if (usr.getEstado() != 1) {
                throw new Exception("Usuario sin acceso al sistema");
            } else {
                hd = new HotelDescktop(usr, DB);
                hd.setVisible(true);
            }
        } else {
            throw new Exception("El usuario no existe");
        }
    }
}
