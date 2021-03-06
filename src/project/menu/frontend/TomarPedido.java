package project.menu.frontend;

import hotelelbuendescanso.BaseDatos;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.menu.backend.ManejadorMenu;
import project.menu.backend.Menu;

/**
 *
 * @author fabricio
 */
public class TomarPedido extends javax.swing.JInternalFrame {

    private BaseDatos DB = null;
    private List<Menu> listaMenu = null;
    private ObservableList<Menu> listaMenuObser = null;
    private Menu elementoSelec = null;
    public String path;
    private final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH = "src/project/frontend/images/blur3.jpg";

    /**
     * Creates new form CreadorUsuario
     */
    public TomarPedido(BaseDatos DB) {
        this.listaMenu = new LinkedList<>();
        this.listaMenuObser = ObservableCollections.observableList(listaMenu);
        this.DB = DB;
        this.path = BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH;
        initComponents();
        actualizarLista();
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

        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                ImageIcon im = new ImageIcon(path);
                Image i = im.getImage();
                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
            }

        };
        comboBoxTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonFiltrar = new javax.swing.JButton();
        buttonActualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelMontoPagar = new javax.swing.JLabel();
        buttonRegistrar = new javax.swing.JButton();

        jTextField7.setBackground(new java.awt.Color(254, 254, 254));
        jTextField7.setForeground(new java.awt.Color(1, 1, 1));
        jTextField7.setCaretColor(new java.awt.Color(1, 1, 1));
        jTextField7.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jTextField8.setBackground(new java.awt.Color(254, 254, 254));
        jTextField8.setForeground(new java.awt.Color(1, 1, 1));
        jTextField8.setCaretColor(new java.awt.Color(1, 1, 1));
        jTextField8.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel10.setForeground(new java.awt.Color(54, 209, 238));
        jLabel10.setText("Max: 20");

        setBackground(new java.awt.Color(254, 254, 254));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Tomar pedido");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(2, 161, 192));

        comboBoxTipo.setBackground(new java.awt.Color(254, 254, 254));
        comboBoxTipo.setForeground(new java.awt.Color(20, 17, 107));
        comboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comida", "Bebida" }));
        comboBoxTipo.setToolTipText("Seleccione una opcion");

        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Tipo:");

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Menu Disponible");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaMenuObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precio}"));
        columnBinding.setColumnName("Precio");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${elementoSelec}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buttonFiltrar.setBackground(new java.awt.Color(246, 145, 1));
        buttonFiltrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonFiltrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonFiltrar.setText("Filtrar");
        buttonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltrarActionPerformed(evt);
            }
        });

        buttonActualizar.setBackground(new java.awt.Color(246, 145, 1));
        buttonActualizar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonActualizar.setForeground(new java.awt.Color(254, 254, 254));
        buttonActualizar.setText("Actualizar");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Monto:");

        jLabelMontoPagar.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabelMontoPagar.setForeground(new java.awt.Color(254, 254, 254));
        jLabelMontoPagar.setText(" ");

        buttonRegistrar.setBackground(new java.awt.Color(246, 145, 1));
        buttonRegistrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonRegistrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonRegistrar.setText("TOMAR PEDIDO");
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelMontoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(buttonFiltrar)
                    .addComponent(buttonActualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabelMontoPagar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(buttonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
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

    private void buttonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltrarActionPerformed
        filtrarLista();
    }//GEN-LAST:event_buttonFiltrarActionPerformed

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        actualizarLista();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        ManejadorMenu mm = new ManejadorMenu(DB);
        Alojamiento a = new Alojamiento(null, closable, DB);
        a.setVisible(true);
        if (a.getReservSelec() != null) {
            mm.setConsumo(elementoSelec.getId(), a.getReservSelec().getId(), elementoSelec.getPrecio(), a.getFechaPedido());
            actualizarLista();
        }
        buttonRegistrar.setEnabled(false);
    }//GEN-LAST:event_buttonRegistrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jLabelMontoPagar.setText("Q. " + elementoSelec.getPrecio());
        buttonRegistrar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void actualizarLista() {
        ManejadorMenu mm = new ManejadorMenu(DB);
        listaMenuObser.clear();
        if (mm.getMenus() != null) {
            listaMenuObser.addAll(mm.getMenus());
        }
        buttonRegistrar.setEnabled(false);
    }

    private void filtrarLista() {
        ManejadorMenu mm = new ManejadorMenu(DB);
        listaMenuObser.clear();
        String tipo = comboBoxTipo.getSelectedItem().toString();
        if (mm.getMenuByTipo(tipo) != null) {
            listaMenuObser.addAll(mm.getMenuByTipo(tipo));
        }
        buttonRegistrar.setEnabled(false);
    }

    public ObservableList<Menu> getListaMenuObser() {
        return listaMenuObser;
    }

    public void setListaMenuObser(ObservableList<Menu> listaUsuarioObser) {
        this.listaMenuObser = listaUsuarioObser;
    }

    public Menu getElementoSelec() {
        return elementoSelec;
    }

    public void setElementoSelec(Menu elementoSelec) {
        this.elementoSelec = elementoSelec;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonFiltrar;
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelMontoPagar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
