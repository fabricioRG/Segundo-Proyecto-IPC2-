package project.cliente.frontend;

import project.reservacion.frontend.*;
import hotelelbuendescanso.BaseDatos;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.cliente.backend.Cliente;
import project.cliente.backend.ManejadorCliente;
import project.reservacion.backend.ManejadorReservacion;
import project.reservacion.backend.Reservacion;
import project.usuario.Usuario;

/**
 *
 * @author fabricio
 */
public class ReporteClientes extends javax.swing.JInternalFrame {

    private BaseDatos DB = null;
    private Usuario usuario = null;
    private List<Cliente> listaClientes = null;
    private ObservableList<Cliente> listaClienteObser = null;
    private Cliente clienteSelec = null;

    public ReporteClientes(BaseDatos DB, Usuario usr) {
        this.DB = DB;
        this.usuario = usr;
        this.listaClientes = new LinkedList<>();
        this.listaClienteObser = ObservableCollections.observableList(listaClientes);
        initComponents();
        actualizarLista(1);
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
        buttonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonFiltrar = new javax.swing.JButton();
        formattedTextFieldDPI = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonBuscar = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 99, 71));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Reporte Clientes");

        jPanel1.setBackground(new java.awt.Color(255, 99, 71));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Reporte Clientes");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        buttonActualizar.setBackground(new java.awt.Color(70, 130, 180));
        buttonActualizar.setFont(new java.awt.Font("Caviar Dreams", 0, 18)); // NOI18N
        buttonActualizar.setForeground(new java.awt.Color(254, 254, 254));
        buttonActualizar.setText("Actualizar");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaClienteObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${apellido}"));
        columnBinding.setColumnName("Apellido");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dpi}"));
        columnBinding.setColumnName("DPI");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefono}"));
        columnBinding.setColumnName("Telefono");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${clienteSelec}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

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
        jLabel6.setText("DPI:");

        buttonBuscar.setBackground(new java.awt.Color(70, 130, 180));
        buttonBuscar.setFont(new java.awt.Font("Caviar Dreams", 0, 14)); // NOI18N
        buttonBuscar.setForeground(new java.awt.Color(254, 254, 254));
        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        jTextFieldNombre.setBackground(new java.awt.Color(254, 254, 254));
        jTextFieldNombre.setForeground(new java.awt.Color(237, 71, 71));
        jTextFieldNombre.setText(" ");
        jTextFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        jTextFieldNombre.setCaretColor(new java.awt.Color(237, 71, 71));

        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Nombre:");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(183, 183, 183))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBuscar)
                    .addComponent(jLabel6)
                    .addComponent(buttonFiltrar)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonActualizar)
                .addContainerGap(13, Short.MAX_VALUE))
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

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        actualizarLista(1);
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltrarActionPerformed
        actualizarLista(3);
    }//GEN-LAST:event_buttonFiltrarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        actualizarLista(2);
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void actualizarLista(int opcion) {
        ManejadorCliente mc = new ManejadorCliente(DB);
        listaClienteObser.clear();
        if (opcion == 1) {
            if (mc.getClientes() != null) {
                listaClienteObser.addAll(mc.getClientes());
            }
        } else if (opcion == 2) {
            if (mc.getClienteByDPI(formattedTextFieldDPI.getText()) != null) {
                listaClienteObser.add(mc.getClienteByDPI(formattedTextFieldDPI.getText()));
            }
        } else if (opcion == 3) {
            if(mc.getClientesByName(jTextFieldNombre.getText().trim()) != null) {
                listaClienteObser.addAll(mc.getClientesByName(jTextFieldNombre.getText().trim()));
            }
        }

    }

    public ObservableList<Cliente> getListaClienteObser() {
        return listaClienteObser;
    }

    public void setListaClienteObser(ObservableList<Cliente> listaReserObser) {
        this.listaClienteObser = listaReserObser;
    }

    public Cliente getClienteSelec() {
        return clienteSelec;
    }

    public void setClienteSelec(Cliente clienteSelec) {
        this.clienteSelec = clienteSelec;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonFiltrar;
    private javax.swing.JFormattedTextField formattedTextFieldDPI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNombre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
