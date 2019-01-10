package project.usuario.frontend;

import hotelelbuendescanso.BaseDatos;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import project.usuario.backend.ManejadorFrontEndUsuario;

/**
 *
 * @author fabricio
 */
public class SolicitadorUsuario extends javax.swing.JDialog {

    private boolean estado;
    private int areaTrabajo = 0;
    private BaseDatos DB = null;
    public String path;
    public final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH = "src/project/frontend/images/is1.jpg";
    public final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH_FIELD1 = "src/project/frontend/images/buttons1.jpg";
    public final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH_FIELD2 = "src/project/frontend/images/buttons2.jpg";

    /**
     * Creates new form SolicitadorUsuario
     */
    public SolicitadorUsuario(java.awt.Frame parent, boolean modal, BaseDatos DB) {
        super(parent, modal);
        this.path = BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH;
        initComponents();
        this.setTitle("Datos de usuario");
        this.setLocationRelativeTo(this);
        this.DB = DB;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                ImageIcon im = new ImageIcon(path);
                Image i = im.getImage();
                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
            }
        };
        ingresarUsuario = new javax.swing.JButton();
        salirButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        fieldNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(25, 47, 68));

        ingresarUsuario.setBackground(new java.awt.Color(254, 254, 254));
        ingresarUsuario.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        ingresarUsuario.setForeground(new java.awt.Color(56, 2, 127));
        ingresarUsuario.setText("Ingresar");
        ingresarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarUsuarioActionPerformed(evt);
            }
        });

        salirButton.setBackground(new java.awt.Color(181, 1, 37));
        salirButton.setForeground(new java.awt.Color(254, 254, 254));
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Nombre de usuario*:");

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Contraseña de usuario*:");

        fieldPassword.setBackground(new java.awt.Color(254, 254, 254));
        fieldPassword.setForeground(new java.awt.Color(181, 1, 37));
        fieldPassword.setCaretColor(new java.awt.Color(181, 1, 37));
        fieldPassword.setMargin(new java.awt.Insets(5, 5, 5, 5));
        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });

        fieldNombre.setBackground(new java.awt.Color(254, 254, 254));
        fieldNombre.setForeground(new java.awt.Color(181, 1, 37));
        fieldNombre.setCaretColor(new java.awt.Color(181, 1, 37));
        fieldNombre.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Iniciar Sesion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPassword))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(ingresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(ingresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salirButton)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
    }//GEN-LAST:event_fieldPasswordActionPerformed

    /**
     * Metodo que permite verificar si el usuario existe, asi como verificar si la contraseña coincide
     * @param evt 
     */
    private void ingresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarUsuarioActionPerformed
            ManejadorFrontEndUsuario msu = new ManejadorFrontEndUsuario(this.DB);
        try {
            msu.showHotelDesktop(fieldNombre.getText().trim(), fieldPassword.getPassword(), this.DB);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de validacion1", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ingresarUsuarioActionPerformed

    /**
     * Boton que tiene como funcion cancelar todo proceso y salir
     * @param evt 
     */
    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        int accion = JOptionPane.showConfirmDialog(rootPane, "Deseas salir de \"Code 'n Bugs\"", "Salir", JOptionPane.YES_NO_OPTION);
        if (accion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_salirButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    public boolean isEstado() {
        return estado;
    }

    public int getAreaTrabajo() {
        return areaTrabajo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JButton ingresarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
