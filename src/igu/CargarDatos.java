package igu;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import logica.Controladora;
import logica.FormUtils;
import logica.InputKey;
import logica.Mascotas;
import logica.Servicios;

/**
 * Ventana principal para cargar datos de mascotas y sus dueños en el sistema de
 * gestión de la peluquería canina.
 *
 * Esta clase extiende {@link javax.swing.JFrame} y proporciona una interfaz
 * gráfica para que el usuario ingrese información relevante. Utiliza una
 * instancia de la clase {@link Controladora} para gestionar la lógica de
 * negocio y persistencia.
 *
 * También configura el ícono de la ventana y define una bandera booleana para
 * validar si los campos han sido completados.
 *
 * @author Alicia
 */
public class CargarDatos extends javax.swing.JFrame {

    /**
     * Instancia de la clase Controladora para gestionar operaciones de negocio.
     */
    Controladora control = new Controladora();

    /**
     * Almacena el rol actual del usuario logueado en el sistema.
     * <p>
     * Este valor se utiliza para determinar el comportamiento de la interfaz,
     * control de accesos y navegación condicional según el tipo de usuario (por
     * ejemplo, "Administrador", "Recepcionista", "Trabajador").
     */
    private String rolActual;

    /**
     * Constructor de la clase {@code CargarDatos}.
     * <p>
     * Inicializa los componentes gráficos de la ventana, establece el icono de
     * la aplicación y guarda el rol del usuario actualmente logueado.
     *
     * @param rol Rol del usuario que ha iniciado sesión. Se almacena en
     * {@link #rolActual} para determinar permisos y comportamiento de la
     * interfaz.
     */
    public CargarDatos(String rol) {
        initComponents();
        Image icon = new ImageIcon("./icon/logo2.png").getImage();
        this.setIconImage(icon);
        this.rolActual = rol;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRaza = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNomDuenio = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        cmbAlergico = new javax.swing.JComboBox<>();
        cmbAEspecial = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jBoxBanio = new javax.swing.JCheckBox();
        jBoxCorte = new javax.swing.JCheckBox();
        jBoxUnias = new javax.swing.JCheckBox();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AliCan - Administrador - Recepcionista");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SimSun-ExtG", 1, 36)); // NOI18N
        jLabel1.setText("Introducir Datos");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\logo2.png")); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Nombre del perro:");

        jLabel4.setText("Raza:");

        jLabel5.setText("Color:");

        jLabel6.setText("Alérgico:");

        jLabel7.setText("Atención Especial:");

        jLabel8.setText("Teléfono:");

        jLabel9.setText("Observaciones:");

        jLabel10.setText("Nombre del Dueño:");

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
        jScrollPane1.setViewportView(txtObservaciones);

        cmbAlergico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Si", "No" }));
        cmbAlergico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbAlergicoKeyTyped(evt);
            }
        });

        cmbAEspecial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Si", "No" }));

        jLabel11.setText("Servicios:");
        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBoxBanio.setBackground(new java.awt.Color(204, 204, 255));
        jBoxBanio.setText("Baño");
        jBoxBanio.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBoxCorte.setBackground(new java.awt.Color(204, 204, 255));
        jBoxCorte.setText("Corte");
        jBoxCorte.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBoxUnias.setBackground(new java.awt.Color(204, 204, 255));
        jBoxUnias.setText("Uñas");
        jBoxUnias.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbAlergico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAEspecial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRaza, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtColor, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jBoxBanio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBoxCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBoxUnias, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomDuenio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAlergico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbAEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jBoxBanio)
                    .addComponent(jBoxCorte)
                    .addComponent(jBoxUnias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNomDuenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(14, 14, 14))
        );

        btnLimpiar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\limpiar.png")); // NOI18N
        btnLimpiar.setText("  Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\guardar.png")); // NOI18N
        btnGuardar.setText("  Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\salir.png")); // NOI18N
        btnSalir.setText("Atras");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        FormUtils.limpiarFormulario(this.getContentPane());  // limpiar los campos
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * Acción ejecutada al hacer clic en el botón "Salir".
     *
     * Este método verifica si hay datos introducidos en el formulario mediante
     * la variable {@code vacio}. Si es true, muestra una ventana de
     * confirmación antes de cerrar. Si es false, cierra directamente.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        FormUtils.salirSegunRol(rolActual, this);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * Evento KeyTyped para el campo de texto {@code txtNombre}.
     * <p>
     * Este método controla la entrada de caracteres en el JTextField del
     * nombre:
     * <ul>
     * <li>No permite introducir números.</li>
     * <li>Limita la longitud del texto a un máximo de 20 caracteres.</li>
     * </ul>
     * <p>
     * Además, establece el boolean {@code vacio} en {@code true} cada vez que
     * se modifica el contenido del campo, lo que puede ser utilizado para
     * validaciones posteriores en el formulario.
     *
     * @param evt Evento de teclado {@link java.awt.event.KeyEvent} generado al
     * tipear en el campo.
     */
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtNombre, 20);
    }//GEN-LAST:event_txtNombreKeyTyped

    /**
     * Evento KeyTyped para el campo de texto {@code txtTelefono}.
     * <p>
     * Este método controla la entrada de caracteres en el JTextField del
     * teléfono:
     * <ul>
     * <li>Permite únicamente la introducción de números (0-9).</li>
     * <li>Limita la longitud del texto a un máximo de 9 caracteres.</li>
     * </ul>
     * <p>
     * Además, establece el boolean {@code vacio} en {@code true} cada vez que
     * se modifica el contenido del campo, lo que puede ser utilizado para
     * validaciones posteriores en el formulario.
     *
     * @param evt Evento de teclado {@link java.awt.event.KeyEvent} generado al
     * tipear en el campo.
     */
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        InputKey.soloNumeros(evt);
        InputKey.limitar(evt, txtTelefono, 9);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    /**
     * Evento KeyTyped para el campo de texto {@code txtNomDuenio}.
     * <p>
     * Este método controla la entrada de caracteres en el JTextField del nombre
     * del dueño:
     * <ul>
     * <li>No permite introducir números.</li>
     * <li>Limita la longitud del texto a un máximo de 15 caracteres.</li>
     * </ul>
     * <p>
     * Además, establece el boolean {@code vacio} en {@code true} cada vez que
     * se modifica el contenido del campo, lo que puede ser utilizado para
     * validaciones posteriores en el formulario.
     *
     * @param evt Evento de teclado {@link java.awt.event.KeyEvent} generado al
     * tipear en el campo.
     */
    private void txtNomDuenioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomDuenioKeyTyped
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtNomDuenio, 20);
    }//GEN-LAST:event_txtNomDuenioKeyTyped

    /**
     * Evento KeyTyped para el campo de texto {@code txtRaza}.
     * <p>
     * Este método controla la entrada de caracteres en el JTextField de la raza
     * de la mascota:
     * <ul>
     * <li>No permite introducir números.</li>
     * <li>Limita la longitud del texto a un máximo de 15 caracteres.</li>
     * </ul>
     * <p>
     * Además, establece el boolean {@code vacio} en {@code true} cada vez que
     * se modifica el contenido del campo, lo que puede ser utilizado para
     * validaciones posteriores en el formulario.
     *
     * @param evt Evento de teclado {@link java.awt.event.KeyEvent} generado al
     * tipear en el campo.
     */
    private void txtRazaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaKeyTyped
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtRaza, 20);
    }//GEN-LAST:event_txtRazaKeyTyped

    /**
     * Evento KeyTyped para el campo de texto {@code txtObservaciones}.
     * <p>
     * Este método controla la entrada de caracteres en el JTextField de
     * observaciones de la mascota, limitando la longitud del texto a un máximo
     * de 50 caracteres.
     * <p>
     * Además, establece el boolean {@code vacio} en {@code true} cada vez que
     * se modifica el contenido del campo, lo que puede ser utilizado para
     * validaciones posteriores en el formulario.
     *
     * @param evt Evento de teclado {@link java.awt.event.KeyEvent} generado al
     * tipear en el campo.
     */
    private void txtObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionesKeyTyped
        //jtextField para el campo de observacion con solo 50 caracteres 
        InputKey.limitar(evt, txtRaza, 50);
    }//GEN-LAST:event_txtObservacionesKeyTyped

    /**
     * Evento KeyTyped para el campo de texto {@code txtColor}.
     * <p>
     * Este método controla la entrada de caracteres en el JTextField del color
     * de la mascota:
     * <ul>
     * <li>No permite introducir números.</li>
     * <li>Limita la longitud del texto a un máximo de 15 caracteres.</li>
     * </ul>
     * <p>
     * Además, establece el boolean {@code vacio} en {@code true} cada vez que
     * se modifica el contenido del campo, lo que puede ser utilizado para
     * validaciones posteriores en el formulario.
     *
     * @param evt Evento de teclado {@link java.awt.event.KeyEvent} generado al
     * tipear en el campo.
     */
    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtColor, 20);
    }//GEN-LAST:event_txtColorKeyTyped

    private void cmbAlergicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbAlergicoKeyTyped
      
    }//GEN-LAST:event_cmbAlergicoKeyTyped

    /**
     * Guarda los datos de una mascota junto con sus servicios seleccionados.
     * <p>
     * Este método realiza las siguientes operaciones:
     * <ol>
     * <li>Recoge los valores ingresados en los campos del formulario (nombre,
     * raza, color, observaciones, alergias, atención especial, nombre y
     * teléfono del dueño).</li>
     * <li>Valida que todos los campos obligatorios estén completos. Si alguno
     * está vacío, muestra un mensaje de advertencia y detiene el guardado.</li>
     * <li>Recoge los servicios seleccionados mediante los JCheckBox
     * correspondientes (Baño, Corte de pelo, Corte de uñas) y los agrega a una
     * lista de {@link Servicios}.</li>
     * <li>Llama al método {@code control.guardar(...)} para persistir los datos
     * de la mascota junto con los servicios seleccionados.</li>
     * <li>Muestra un mensaje de confirmación de guardado exitoso.</li>
     * <li>Limpia el formulario llamando al método {@code limpiarDatos()}.</li>
     * </ol>
     *
     * <p>
     * Este método asegura que no se guarden registros incompletos y ofrece
     * retroalimentación visual al usuario mediante {@link JOptionPane}.
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

            JLabel label = new JLabel("Por favor, completa todos los campos antes de guardar.");
            label.setFont(new Font("Arial", Font.BOLD, 14));

            JOptionPane optionPane = new JOptionPane(label, JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION);
            JDialog dialog = optionPane.createDialog("Campos incompletos");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
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
        control.guardar(nombreMasco, raza, color, observaciones, alergia, atenEsp, nombreDuenio, telefono, serviciosSeleccionados);

        JLabel label = new JLabel("Se guardó correctamente");
        label.setFont(new Font("Arial", Font.BOLD, 14));

        JOptionPane optionPane = new JOptionPane(label, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog("Guardado");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        FormUtils.limpiarFormulario(rootPane);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbAEspecial;
    private javax.swing.JComboBox<String> cmbAlergico;
    private javax.swing.JCheckBox jBoxBanio;
    private javax.swing.JCheckBox jBoxCorte;
    private javax.swing.JCheckBox jBoxUnias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtNomDuenio;
    protected javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtRaza;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
