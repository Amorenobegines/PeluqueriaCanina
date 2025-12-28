package igu;

import java.awt.Image;
import javax.swing.ImageIcon;
import logica.Controladora;
import logica.FormUtils;
import logica.InputKey;
import logica.Usuarios;

/**
 * Ventana de diálogo para el registro de nuevos usuarios en el sistema de
 * peluquería canina.
 *
 * Esta clase extiende {@link javax.swing.JDialog} y proporciona una interfaz
 * gráfica para capturar los datos de un nuevo usuario. Establece conexión con
 * la base de datos al inicializarse y configura la apariencia de la ventana.
 *
 * @author Alicia
 */
public class FrmRegistro extends javax.swing.JFrame {

    /**
     * Instancia de la clase Controladora para acceder a la lógica de negocio.
     */
    Controladora control = null;

    /**
     * Constructor que inicializa el formulario de registro.
     *
     * @param parent Ventana principal que invoca este diálogo.
     * @param modal Indica si el diálogo debe bloquear la ventana principal
     * mientras está activo.
     */
    public FrmRegistro(java.awt.Frame parent, boolean modal) {
        control = new Controladora();
        initComponents();
        setLocationRelativeTo(null);
        Image icon = new ImageIcon("./icon/logo2.png").getImage();
        this.setIconImage(icon);
    }

    /**
     * Constructor sin parámetros
     */
    public FrmRegistro() {
        this(null, true); // Llama al constructor ya existente
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        comboTipo = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Usuario"));

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Name:"));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email:"));

        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Surname:"));
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
        });

        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("Password:"));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Administrador", "Recepcionista", "Trabajador" }));
        comboTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Usuario:"));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnInicio.setFont(new java.awt.Font("Yu Gothic Light", 0, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(102, 102, 255));
        btnInicio.setText("Iniciar Sesión");
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboTipo, 0, 190, Short.MAX_VALUE)
                    .addComponent(txtEmail)
                    .addComponent(txtNombre))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellidos)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnInicio)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Registar Usuarios
     *
     * @param evt
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registrarUsuario();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * Evento MouseClicked para el JLabel {@code jLabel1}.
     * <p>
     * Este método se ejecuta cuando el usuario hace clic sobre el JLabel,
     * cerrando la ventana actual y abriendo la ventana de login
     * ({@link FrmLogin}).
     * <p>
     * Es útil para implementar botones o íconos de "cerrar sesión" o "volver al
     * login" en la interfaz gráfica.
     *
     * @param evt Evento de ratón {@link java.awt.event.MouseEvent} generado al
     * hacer clic sobre el JLabel.
     */
    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        FormUtils.cambiarVentana(this, new FrmLogin());
    }//GEN-LAST:event_btnInicioMouseClicked

    /**
     * Evento que se ejecuta al presionar una tecla dentro del campo de texto
     * destinado al nombre.
     *
     * <p>
     * Este método aplica dos validaciones mediante la clase
     * {@link InputKey}:</p>
     * <ul>
     * <li><strong>soloLetras(evt):</strong> Restringe la entrada para permitir
     * únicamente caracteres alfabéticos.</li>
     * <li><strong>limitar(evt, txtNombre, 20):</strong> Limita la longitud
     * máxima del texto a 20 caracteres.</li>
     * </ul>
     *
     * @param evt Evento de teclado generado al presionar una tecla.
     */
    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtNombre, 20);
    }//GEN-LAST:event_txtNombreKeyPressed

    /**
     * Evento que se ejecuta al presionar una tecla dentro del campo de texto
     * destinado a los apellidos.
     *
     * <p>
     * Este método aplica dos validaciones mediante la clase
     * {@link InputKey}:</p>
     * <ul>
     * <li><strong>soloLetras(evt):</strong> Restringe la entrada para permitir
     * únicamente caracteres alfabéticos.</li>
     * <li><strong>limitar(evt, txtApellidos, 30):</strong> Limita la longitud
     * máxima del texto a 30 caracteres.</li>
     * </ul>
     *
     * @param evt Evento de teclado generado al presionar una tecla.
     */
    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        InputKey.soloLetras(evt);
        InputKey.limitar(evt, txtApellidos, 30);
    }//GEN-LAST:event_txtApellidosKeyPressed

    /**
     * Acción ejecutada al hacer clic en el botón "Registrar".
     *
     * Este método valida que todos los campos del formulario estén completos y
     * que se haya seleccionado un tipo de usuario válido. Si la validación es
     * exitosa, intenta insertar los datos del nuevo usuario en la base de
     * datos.
     *
     * En caso de éxito, limpia el formulario y muestra un mensaje de
     * confirmación. Si ocurre un error, muestra un mensaje de advertencia,
     * incluyendo una verificación específica para evitar duplicados por correo
     * electrónico.
     *
     */
    private void registrarUsuario() {

        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String email = txtEmail.getText().trim();
        String pass = txtPassword.getText().trim();
        String rolSeleccionado = comboTipo.getSelectedItem().toString();

        // Validar campos vacíos
        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            FormUtils.mostrarMensaje("Debe completar todos los campos.", "Error", "Error al guardar");

            return;
        }

        // Validar formato de email
        String patronEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!email.matches(patronEmail)) {
            FormUtils.mostrarMensaje("El correo electrónico no tiene un formato válido.", "Error", "Error al guardar");

            return;
        }

        //  Validar selección de rol
        if (rolSeleccionado.equalsIgnoreCase("Seleccionar")) {
            FormUtils.mostrarMensaje("Debe seleccionar un rol válido.", "Error", "Error al guardar");
            return;
        }

        // Validar email duplicado
        boolean existeEmail = false;
        for (Usuarios u : control.traerUsuarios()) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                existeEmail = true;
                break;
            }
        }

        if (existeEmail) {
            FormUtils.mostrarMensaje("El correo " + email + " ya está registrado. Use otro diferente.", "Error", "Error al guardar");
            return;
        }

        // Guardar usuario si todo está correcto
        try {
            control.guardarUsuario(nombre, apellidos, email, pass, rolSeleccionado);
            FormUtils.mostrarMensaje("Usuario guardado correctamente.", "Info", "Usuario guardado ");
            FormUtils.limpiarFormulario(rootPane);
        } catch (Exception ex) {
            FormUtils.mostrarMensaje("Error al guardar el usuario: " + ex.getMessage(), "Error", "Usuario no guardado ");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnInicio;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
