package project.reservacion.frontend;

import hotelelbuendescanso.BaseDatos;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import project.usuario.Usuario;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.cliente.backend.ManejadorCliente;
import project.habitacion.backend.Habitacion;
import project.habitacion.backend.ManejadorHabitacion;
import project.reservacion.backend.ManejadorReservacion;

/**
 *
 * @author fabricio
 */
public class RegistradorReservacion extends javax.swing.JInternalFrame {

    private BaseDatos DB = null;
    private Usuario usuario = null;
    private List<Habitacion> listaHabit = null;
    private ObservableList<Habitacion> listaHabtObser = null;
    private Habitacion habitacionSelec = null;

    public RegistradorReservacion(BaseDatos DB, Usuario usr) {
        this.DB = DB;
        this.usuario = usr;
        this.listaHabit = new LinkedList<>();
        this.listaHabtObser = ObservableCollections.observableList(listaHabit);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserSalida = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonVerificar = new javax.swing.JButton();
        jPanelRegistro = new javax.swing.JPanel();
        formattedTextFieldDPI = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonRegistrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabelMontoPagar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 99, 71));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 99, 71));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Reservar Habitacion");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Fecha de Inicio*:");

        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Fecha de Salida*:");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaHabtObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numero}"));
        columnBinding.setColumnName("Numero");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Precio");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nivel}"));
        columnBinding.setColumnName("Nivel 1");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${habitacionSelec}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buttonVerificar.setBackground(new java.awt.Color(70, 130, 180));
        buttonVerificar.setFont(new java.awt.Font("Caviar Dreams", 0, 14)); // NOI18N
        buttonVerificar.setForeground(new java.awt.Color(254, 254, 254));
        buttonVerificar.setText("Verificar");
        buttonVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerificarActionPerformed(evt);
            }
        });

        jPanelRegistro.setBackground(new java.awt.Color(255, 99, 71));

        formattedTextFieldDPI.setBackground(new java.awt.Color(254, 254, 254));
        formattedTextFieldDPI.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldDPI.setForeground(new java.awt.Color(237, 71, 71));
        try {
            formattedTextFieldDPI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldDPI.setCaretColor(new java.awt.Color(237, 71, 71));

        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("DPI*:");

        buttonRegistrar.setBackground(new java.awt.Color(70, 130, 180));
        buttonRegistrar.setFont(new java.awt.Font("Caviar Dreams", 0, 18)); // NOI18N
        buttonRegistrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonRegistrar.setText("Reservar");
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Monto:");

        jLabelMontoPagar.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabelMontoPagar.setForeground(new java.awt.Color(254, 254, 254));
        jLabelMontoPagar.setText(" ");

        javax.swing.GroupLayout jPanelRegistroLayout = new javax.swing.GroupLayout(jPanelRegistro);
        jPanelRegistro.setLayout(jPanelRegistroLayout);
        jPanelRegistroLayout.setHorizontalGroup(
            jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMontoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanelRegistroLayout.setVerticalGroup(
            jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(buttonRegistrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelMontoPagar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(buttonVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooserSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVerificar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        ManejadorReservacion mr = new ManejadorReservacion(DB);
        try {
//            mc.verificarCliente(formattedTextFieldDPI.getText().trim(), this);
            mr.setReservacion(formattedTextFieldDPI.getText().trim(), habitacionSelec.getNumero(), 
                    jDateChooserInicio.getDate(), jDateChooserSalida.getDate(), habitacionSelec.getPrecio());
            JOptionPane.showMessageDialog(rootPane, "Se ha registrado exitosamente la reservacion", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            listaHabtObser.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        buttonRegistrar.setEnabled(false);
    }//GEN-LAST:event_buttonRegistrarActionPerformed

    private void buttonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerificarActionPerformed
        if (jDateChooserInicio.getDate() == null || jDateChooserSalida.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "No es posible filtrar las reservaciones, intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jDateChooserInicio.getDate().compareTo(jDateChooserSalida.getDate()) >= 0) {
            JOptionPane.showMessageDialog(rootPane, "Fechas incorrectas, intentelo de nuevo", "error", JOptionPane.ERROR_MESSAGE);
        } else {
            actualizarListas();
        }
    }//GEN-LAST:event_buttonVerificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        ManejadorReservacion mr = new ManejadorReservacion(DB);
        buttonRegistrar.setEnabled(true);
        double monto = mr.getCantidadDias(jDateChooserInicio.getDate(), jDateChooserSalida.getDate()) * habitacionSelec.getPrecio();
        jLabelMontoPagar.setText("Q. " + monto);
    }//GEN-LAST:event_jTable1MouseClicked

    private void actualizarListas() {
        ManejadorHabitacion mh = new ManejadorHabitacion(DB);
        listaHabtObser.clear();
        if(mh.getHabitacionesByDate(jDateChooserInicio.getDate(), jDateChooserSalida.getDate()) != null){
            listaHabtObser.addAll(mh.getHabitacionesByDate(jDateChooserInicio.getDate(), jDateChooserSalida.getDate()));
        }
        buttonRegistrar.setEnabled(false);
    }

    public ObservableList<Habitacion> getListaHabtObser() {
        return listaHabtObser;
    }

    public void setListaHabtObser(ObservableList<Habitacion> listaHabtObser) {
        this.listaHabtObser = listaHabtObser;
    }

    public Habitacion getHabitacionSelec() {
        return habitacionSelec;
    }

    public void setHabitacionSelec(Habitacion habitacionSelec) {
        this.habitacionSelec = habitacionSelec;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JButton buttonVerificar;
    private javax.swing.JFormattedTextField formattedTextFieldDPI;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private com.toedter.calendar.JDateChooser jDateChooserSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelMontoPagar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelRegistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
