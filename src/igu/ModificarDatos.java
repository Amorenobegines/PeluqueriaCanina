package igu;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Controladora;
import logica.FormUtils;
import logica.InputKey;
import logica.Mascotas;
import logica.Servicios;

/**
 * Ventana de edición de datos de una mascota en el sistema de gestión de
 * peluquería canina.
 *
 * Esta clase extiende {@link javax.swing.JFrame} y permite al usuario modificar
 * los datos de una mascota previamente registrada, incluyendo información del
 * dueño.
 *
 * Al instanciarse, se inicializan los componentes gráficos, se establece el
 * ícono de la aplicación y se cargan los datos correspondientes al número de
 * cliente proporcionado.
 *
 * Utiliza una instancia de {@link Controladora} para acceder a la lógica de
 * negocio y persistencia.
 *
 */
public class ModificarDatos extends javax.swing.JFrame {

    /**
     * Controladora de lógica de negocio para acceder y modificar datos.
     */
    Controladora control = null;

    /**
     * Mascota que se está editando.
     */
    Mascotas masco;

    /**
     * Número de cliente que identifica a la mascota.
     */
    int num_cliente;

    /**
     * Bandera de validación que indica si los campos están vacíos. Inicialmente
     * se establece en false.
     */
    boolean vacio = false;

    /**
     * Constructor que inicializa la ventana de modificación de datos.
     *
     * @param num_cliente Número de cliente que identifica a la mascota a
     * modificar.
     */
    public ModificarDatos(int num_cliente) {
        control = new Controladora();
        initComponents();
        Image icon = new ImageIcon("./icon/logo2.png").getImage();
        this.setIconImage(icon);
        cargarDatos(num_cliente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNomDuenio = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        cmbAlergico = new javax.swing.JComboBox<>();
        cmbAEspecial = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jBoxBanio = new javax.swing.JCheckBox();
        jBoxCorte = new javax.swing.JCheckBox();
        jBoxUnias = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alican Administrador");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("SimSun-ExtG", 1, 48)); // NOI18N
        jLabel1.setText("Editar Datos");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\logo2.png")); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\guardar.png")); // NOI18N
        btnGuardar.setText("  Editar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\salir.png")); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setText("Nombre del perro:");

        jLabel28.setText("Raza:");

        jLabel29.setText("Color:");

        jLabel30.setText("Alérgico:");

        jLabel31.setText("Atención Especial:");

        jLabel32.setText("Teléfono:");

        jLabel33.setText("Observaciones:");

        jLabel34.setText("Nombre del Dueño:");

        txtRaza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazaKeyTyped(evt);
            }
        });

        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtNomDuenio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomDuenioKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        txtObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservacionesKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtObservaciones);

        cmbAlergico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Si", "No" }));
        cmbAlergico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbAlergicoKeyTyped(evt);
            }
        });

        cmbAEspecial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Si", "No" }));

        jLabel11.setText("Servicios:");

        jBoxBanio.setText("Baño");

        jBoxCorte.setText("Corte");

        jBoxUnias.setText("Uñas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBoxBanio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBoxCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBoxUnias, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomDuenio)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtRaza, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                        .addComponent(txtColor)
                                        .addComponent(txtNombre))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmbAEspecial, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbAlergico, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(15, 15, 15))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbAlergico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(cmbAEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jBoxBanio)
                    .addComponent(jBoxCorte)
                    .addComponent(jBoxUnias))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtNomDuenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja la acción del botón "Salir" dentro del formulario.
     * <p>
     * Este método muestra un cuadro de diálogo de confirmación preguntando al
     * usuario si realmente desea cerrar la ventana, advirtiendo que los datos
     * introducidos se perderán.
     * </p>
     * <p>
     * Si el usuario confirma (opción "Sí"), se abre la ventana
     * {@code VerDatos}, se centra en pantalla y la ventana actual se cierra
     * mediante {@code dispose()}.
     * </p>
     *
     * @param evt el evento de acción generado al hacer clic en el botón "Salir"
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int resultado = JOptionPane.showConfirmDialog(this, "¿Está seguro de cerrar la ventana?"
                + "\n Se perderán los datos introducidos", "Atención", JOptionPane.YES_OPTION);
        //en caso que sea afirmativo, cerramos la ventana.
        if (JOptionPane.YES_OPTION == resultado) {
            FormUtils.cambiarVentana(this, new VerDatos());
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * Bloquea números y solo 15 caracteres
     *
     * @param evt
     */
    private void txtRazaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaKeyTyped
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtRaza, 20);
        this.vacio = true;
    }//GEN-LAST:event_txtRazaKeyTyped

    /**
     * Bloquea números y solo 15 caracteres
     *
     * @param evt
     */
    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtRaza, 20);
        this.vacio = true;
    }//GEN-LAST:event_txtColorKeyTyped

    /**
     * Bloquea números y solo 20 caracteres
     *
     * @param evt
     */
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtNombre, 20);
        this.vacio = true;  // En cada campo (jTextField) cambiado el boolean a true.
    }//GEN-LAST:event_txtNombreKeyTyped

    /**
     * Bloquea números y solo 20 caracteres
     *
     * @param evt
     */
    private void txtNomDuenioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomDuenioKeyTyped
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtNomDuenio, 20);
        this.vacio = true;
    }//GEN-LAST:event_txtNomDuenioKeyTyped

    /**
     * Bloquea letras y solo 9 caracteres numéricos
     *
     * @param evt
     */
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        //jtextField teléfono restrinción para que solo me deje introducir 9 carateres numéricos.
        InputKey.soloNumeros(evt);
        InputKey.limitar(evt, txtTelefono, 9);
        this.vacio = true;
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionesKeyTyped
        //jtextField para el campo de observacion con solo 50 caracteres
        InputKey.limitar(evt, txtRaza, 50);
        this.vacio = true;
    }//GEN-LAST:event_txtObservacionesKeyTyped

    private void cmbAlergicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbAlergicoKeyTyped
        int index = cmbAlergico.getSelectedIndex();

        // Si el usuario selecciona una opción válida (índice distinto de 0)
        if (index != 0) {
            vacio = true;
        } else {
            vacio = false;
        }
    }//GEN-LAST:event_cmbAlergicoKeyTyped

    /**
     * Acción ejecutada al hacer clic en el botón "Guardar".
     *
     * Este método recopila los datos modificados de una mascota y su dueño
     * desde los campos del formulario. Realiza una validación para asegurarse
     * de que todos los campos estén completos y que las selecciones de los
     * combos no sean nulas.
     *
     * Si la validación falla, muestra un mensaje de error informando al usuario
     * que debe completar todos los campos. Si la validación es exitosa, llama
     * al método {@code modificarMascota()} de la clase {@code Controladora}
     * para actualizar los datos en la base de datos.
     *
     * Luego muestra un mensaje de confirmación y redirige al usuario a la
     * pantalla {@code VerDatos}, cerrando la ventana actual.
     */
    private void guardarDatos() {
        String nombreMasco = txtNombre.getText().trim();
        String raza = txtRaza.getText().trim();
        String color = txtColor.getText().trim();
        String observaciones = txtObservaciones.getText().trim();
        String alergia = (String) cmbAlergico.getSelectedItem();
        String atenEsp = (String) cmbAEspecial.getSelectedItem();
        String nombreDuenio = txtNomDuenio.getText().trim();
        String telefono = txtTelefono.getText().trim();

        // Validar campos vacíos
        if (nombreMasco.isEmpty() || raza.isEmpty() || color.isEmpty() || observaciones.isEmpty()
                || alergia == null || atenEsp == null || nombreDuenio.isEmpty() || telefono.isEmpty()) {
            FormUtils.mostrarMensaje("Por favor, completa todos los campos antes de guardar.", "Error", "Campos incompletos");

            //   mostarMensaje("Por favor, completa todos los campos antes de guardar.", "Error", "Campos incompletos");
            return; // Salir del método sin guardar
        }

        //  Recoger servicios seleccionados de los JCheckBox
        List<Servicios> serviciosSeleccionados = new ArrayList<>();
        if (jBoxBanio.isSelected()) {
            serviciosSeleccionados.add(new Servicios("Baño", 15.00));
        }
        if (jBoxCorte.isSelected()) {
            serviciosSeleccionados.add(new Servicios("Corte de pelo", 20.00));
        }
        if (jBoxUnias.isSelected()) {
            serviciosSeleccionados.add(new Servicios("Corte de uñas", 10.00));
        }

        // Guardar si todo está completo
        control.modificarMascota(masco, nombreMasco, raza, color, observaciones, alergia, atenEsp, nombreDuenio, telefono, serviciosSeleccionados);
        FormUtils.mostrarMensaje("Modificación realizada correctamente", "Info", "Modificación correctamente");
        FormUtils.cambiarVentana(this, new VerDatos());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbAEspecial;
    private javax.swing.JComboBox<String> cmbAlergico;
    private javax.swing.JCheckBox jBoxBanio;
    private javax.swing.JCheckBox jBoxCorte;
    private javax.swing.JCheckBox jBoxUnias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtNomDuenio;
    protected javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtRaza;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga los datos de una mascota específica en los campos del formulario.
     *
     * Este método obtiene la información de una mascota desde la base de datos
     * utilizando su número de cliente. Luego, asigna los valores a los campos
     * de texto y combos correspondientes en la interfaz gráfica.
     *
     * También ajusta las selecciones de los combos de alergia y atención
     * especial según los valores "Si" o "No" almacenados en la mascota.
     *
     * @param num_cliente Número de cliente que identifica a la mascota.
     */
    private void cargarDatos(int num_cliente) {
        this.masco = control.traerMascota(num_cliente);

        txtNombre.setText(masco.getNombreMas());
        txtColor.setText(masco.getColor());
        txtNomDuenio.setText(masco.getUnDuenio().getNombre());
        txtRaza.setText(masco.getRaza());
        txtTelefono.setText(masco.getUnDuenio().getTelefono());
        txtObservaciones.setText(masco.getObservaciones());

        if (masco.getAlergico().equals("Si")) {
            cmbAlergico.setSelectedIndex(1);
        } else {
            if (masco.getAlergico().equals("No")) {
                cmbAlergico.setSelectedIndex(2);
            }
        }

        if (masco.getAtencion_especial().equals("Si")) {
            cmbAEspecial.setSelectedIndex(1);
        } else {
            if (masco.getAtencion_especial().equals("No")) {
                cmbAEspecial.setSelectedIndex(2);
            }
        }

    }
}
