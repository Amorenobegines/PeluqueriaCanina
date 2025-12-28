package igu;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane; 
import logica.FormUtils;
/**
 * Ventana principal del perfil "Administrador" en el sistema de gestión de
 * peluquería canina.
 *
 * Esta clase extiende {@link javax.swing.JFrame} y proporciona acceso a las
 * funcionalidades administrativas del sistema, como la gestión de usuarios,
 * mascotas, reportes y configuraciones.
 *
 * Al inicializarse, configura los componentes gráficos, centra la ventana en
 * pantalla y establece el ícono personalizado de la aplicación.
 *
 * Esta clase actúa como punto de entrada para las tareas administrativas.
 *
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Constructor que inicializa la interfaz gráfica del administrador.
     *
     * Configura los componentes visuales, establece el ícono de la ventana y
     * posiciona la interfaz en el centro de la pantalla.
     */
    public Principal() {
        initComponents();
        Image icon = new ImageIcon("./icon/logo2.png").getImage();
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        FormUtils.habilitarAyuda(jmAyuda, getRootPane(), "aplicacion");
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVer = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        btnUseer = new javax.swing.JButton();
        btnCita = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMCargarDatos = new javax.swing.JMenuItem();
        jMVerDatos = new javax.swing.JMenuItem();
        jmCitas = new javax.swing.JMenuItem();
        jmUsuarios = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();
        jmAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AliCan  Administrador");
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 48)); // NOI18N
        jLabel1.setText("Peluquería Canina");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnVer.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnVer.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\canino.png")); // NOI18N
        btnVer.setText("Ver Datos");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
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

        btnCargar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnCargar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\guardar.png")); // NOI18N
        btnCargar.setText("Guardar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnUseer.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnUseer.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\usuario.png")); // NOI18N
        btnUseer.setText("Usuarios");
        btnUseer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseerActionPerformed(evt);
            }
        });

        btnCita.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnCita.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\cita.png")); // NOI18N
        btnCita.setText("Citas");
        btnCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCita, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUseer, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(btnUseer, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\logo2.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu.setBackground(new java.awt.Color(204, 204, 255));
        jMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\menu-removebg-preview.png")); // NOI18N
        jMenu.setText("Menú");

        jMCargarDatos.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\guardar.png")); // NOI18N
        jMCargarDatos.setText("Cargar Datos");
        jMCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCargarDatosActionPerformed(evt);
            }
        });
        jMenu.add(jMCargarDatos);

        jMVerDatos.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\canino.png")); // NOI18N
        jMVerDatos.setText("Ver Datos");
        jMVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerDatosActionPerformed(evt);
            }
        });
        jMenu.add(jMVerDatos);

        jmCitas.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\cita.png")); // NOI18N
        jmCitas.setText("Citas");
        jmCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCitasActionPerformed(evt);
            }
        });
        jMenu.add(jmCitas);

        jmUsuarios.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\PeluqueriaCanina\\icon\\usuario.png")); // NOI18N
        jmUsuarios.setText("Usuarios");
        jmUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmUsuariosActionPerformed(evt);
            }
        });
        jMenu.add(jmUsuarios);

        jMenuBar1.add(jMenu);

        Ayuda.setText("Ayuda");

        jmAyuda.setText("Mostrar Ayuda");
        Ayuda.add(jmAyuda);

        jMenuBar1.add(Ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Botón Salir
        int resultado = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de cerrar sesión?",
                "Atención", JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
            this.dispose();
            FrmLogin frLogin = new FrmLogin();
            frLogin.setVisible(true);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // al presionar el botón se cargará la pantalla de Cargar Datos.
        CargarDatos pantalla = new CargarDatos("Administrador");
        pantalla.setVisible(true);   // visible a true
        pantalla.setLocationRelativeTo(null); // aparezca la pantalla en el centro 
        this.dispose();
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // al presionar el botón se cargará la pantalla de ver Datos.
        VerDatos pantalla = new VerDatos();
        pantalla.setVisible(true);   // visible a true
        pantalla.setLocationRelativeTo(null); // aparezca la pantalla en el centro 
        this.dispose();
    }//GEN-LAST:event_btnVerActionPerformed

    private void jMCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCargarDatosActionPerformed
        // al presionar el botón se cargará la pantalla de Cargar Datos.
        this.dispose();
        CargarDatos pantalla = new CargarDatos("Administrador");
        pantalla.setVisible(true);   // visible a true
        pantalla.setLocationRelativeTo(null); // aparezca la pantalla en el centro 
    }//GEN-LAST:event_jMCargarDatosActionPerformed

    private void jMVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerDatosActionPerformed
        // al presionar el botón se cargará la pantalla de ver Datos.
        this.dispose();
        VerDatos pantalla = new VerDatos();
        pantalla.setVisible(true);   // visible a true
        pantalla.setLocationRelativeTo(null); // aparezca la pantalla en el centro 
    }//GEN-LAST:event_jMVerDatosActionPerformed

    private void btnUseerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseerActionPerformed
        this.dispose();
        VerUsuarios pantalla = new VerUsuarios();
        pantalla.setVisible(true);   // visible a true
        pantalla.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnUseerActionPerformed

    private void jmUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmUsuariosActionPerformed
        this.dispose();
        VerUsuarios pantalla = new VerUsuarios();
        pantalla.setVisible(true);   // visible a true
        pantalla.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmUsuariosActionPerformed

    private void btnCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitaActionPerformed
        this.dispose();
        FrmCitas frm = new FrmCitas("Administrador");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCitaActionPerformed

    private void jmCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCitasActionPerformed
        this.dispose();
        FrmCitas frm = new FrmCitas("Administrador");
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
    }//GEN-LAST:event_jmCitasActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ayuda;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnCita;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUseer;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMCargarDatos;
    private javax.swing.JMenuItem jMVerDatos;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem jmAyuda;
    private javax.swing.JMenuItem jmCitas;
    private javax.swing.JMenuItem jmUsuarios;
    // End of variables declaration//GEN-END:variables
}
