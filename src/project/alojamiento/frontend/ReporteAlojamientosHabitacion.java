package project.alojamiento.frontend;

import hotelelbuendescanso.BaseDatos;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.menu.backend.ManejadorMenu;
import project.menu.backend.Menu;
import project.reservacion.backend.ManejadorReservacion;
import project.reservacion.backend.Reservacion;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ReporteAlojamientosHabitacion extends javax.swing.JInternalFrame {

    private BaseDatos DB = null;
    private Usuario usuario = null;
    private List<Reservacion> listaReser = null;
    private List<Menu> listaMenu = null;
    private ObservableList<Reservacion> listaReserObser = null;
    private ObservableList<Menu> listaMenuObser = null;
    private Reservacion reservSelec = null;

    public ReporteAlojamientosHabitacion(BaseDatos DB, Usuario usr) {
        this.DB = DB;
        this.usuario = usr;
        this.listaReser = new LinkedList<>();
        this.listaMenu = new LinkedList<>();
        this.listaReserObser = ObservableCollections.observableList(listaReser);
        this.listaMenuObser = ObservableCollections.observableList(listaMenu);
        initComponents();
        actualizarListaAlojamientos();
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
        buttonActualizar = new javax.swing.JButton();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserSalida = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonFiltrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelAlojamientos = new javax.swing.JLabel();
        jLabelConsumos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 99, 71));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Reporte Alojamientos");

        jPanel1.setBackground(new java.awt.Color(255, 99, 71));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Reporte Alojamientos");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Fecha de Inicio:");

        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Fecha de Salida:");

        buttonActualizar.setBackground(new java.awt.Color(70, 130, 180));
        buttonActualizar.setFont(new java.awt.Font("Caviar Dreams", 0, 18)); // NOI18N
        buttonActualizar.setForeground(new java.awt.Color(254, 254, 254));
        buttonActualizar.setText("Actualizar");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaReserObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dpiCliente}"));
        columnBinding.setColumnName("DPI Cliente");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaInicio}"));
        columnBinding.setColumnName("Fecha Inicio");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaSalida}"));
        columnBinding.setColumnName("Fecha Salida");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${monto}"));
        columnBinding.setColumnName("Monto");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noHabitacion}"));
        columnBinding.setColumnName("No Habitacion");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${reservSelec}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buttonFiltrar.setBackground(new java.awt.Color(70, 130, 180));
        buttonFiltrar.setFont(new java.awt.Font("Caviar Dreams", 0, 14)); // NOI18N
        buttonFiltrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonFiltrar.setText("Filtrar");
        buttonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltrarActionPerformed(evt);
            }
        });

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaMenuObser}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Precio");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Alojamientos:");

        jLabel7.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Consumos:");

        jLabelAlojamientos.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabelAlojamientos.setForeground(new java.awt.Color(254, 254, 254));
        jLabelAlojamientos.setText(" ");

        jLabelConsumos.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabelConsumos.setForeground(new java.awt.Color(254, 254, 254));
        jLabelConsumos.setText(" ");

        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Habitacion:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "101", "102", "103", "104", "201", "202", "203", "204", "301", "302", "303", "304", "401", "402", "403", "404" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(187, 187, 187))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelConsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelAlojamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(buttonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooserSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel8)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelAlojamientos)
                    .addComponent(buttonFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelConsumos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonActualizar)
                .addContainerGap(29, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        actualizarListaAlojamientos();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltrarActionPerformed
        ManejadorReservacion mr = new ManejadorReservacion(DB);
        if (jDateChooserInicio.getDate() == null || jDateChooserSalida.getDate() == null) {
            listaReserObser.clear();
            if (mr.getReservacionesByDateEntradaSalidaAlojHabitacion(jComboBox1.getSelectedItem().toString()) != null) {
                listaReserObser.addAll(mr.getReservacionesByDateEntradaSalidaAlojHabitacion(jComboBox1.getSelectedItem().toString()));
            }
        } else if (jDateChooserInicio.getDate().compareTo(jDateChooserSalida.getDate()) >= 0) {
            JOptionPane.showMessageDialog(rootPane, "Fechas incorrectas, intentelo de nuevo", "error", JOptionPane.ERROR_MESSAGE);
        } else {
            listaReserObser.clear();
            if (mr.getReservacionesByDateEntradaSalidaAlojHabitacion(jDateChooserInicio.getDate(), jDateChooserSalida.getDate(),
                    jComboBox1.getSelectedItem().toString()) != null) {
                listaReserObser.addAll(mr.getReservacionesByDateEntradaSalidaAlojHabitacion(jDateChooserInicio.getDate(),
                        jDateChooserSalida.getDate(), jComboBox1.getSelectedItem().toString()));
                jLabelAlojamientos.setText(Integer.toString(listaReserObser.size()));
            } else {
                jLabelAlojamientos.setText("");
                jLabelConsumos.setText("");
            }
        }
    }//GEN-LAST:event_buttonFiltrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        actualizarListaConsumos();
    }//GEN-LAST:event_jTable1MouseClicked

    private void actualizarListaAlojamientos() {
        ManejadorReservacion mr = new ManejadorReservacion(DB);
        listaReserObser.clear();
        if (mr.getAlojamientos() != null) {
            listaReserObser.addAll(mr.getAlojamientos());
            jLabelAlojamientos.setText(Integer.toString(listaReserObser.size()));
        } else {
            jLabelAlojamientos.setText("");
        }
    }

    private void actualizarListaConsumos() {
        ManejadorMenu mm = new ManejadorMenu(DB);
        listaMenuObser.clear();
        if (mm.getMenuByIdReservacion(Integer.toString(reservSelec.getId())) != null) {
            listaMenuObser.addAll(mm.getMenuByIdReservacion(Integer.toString(reservSelec.getId())));
            jLabelConsumos.setText(Integer.toString(listaMenuObser.size()));
        } else {
            jLabelConsumos.setText("");
        }
    }

    public ObservableList<Reservacion> getListaReserObser() {
        return listaReserObser;
    }

    public void setListaReserObser(ObservableList<Reservacion> listaReserObser) {
        this.listaReserObser = listaReserObser;
    }

    public ObservableList<Menu> getListaMenuObser() {
        return listaMenuObser;
    }

    public void setListaMenuObser(ObservableList<Menu> listaMenuObser) {
        this.listaMenuObser = listaMenuObser;
    }

    public Reservacion getReservSelec() {
        return reservSelec;
    }

    public void setReservSelec(Reservacion reservSelec) {
        this.reservSelec = reservSelec;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonFiltrar;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private com.toedter.calendar.JDateChooser jDateChooserSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAlojamientos;
    private javax.swing.JLabel jLabelConsumos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
