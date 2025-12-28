package logica;

import igu.FrmLogin;
import igu.InicioRecepc;
import igu.Principal;
import java.awt.Component;
import java.awt.Container;
import javax.help.*;
import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase utilitaria para habilitar la ayuda de la aplicación en cualquier
 * JFrame.
 */
public class FormUtils {

    /**
     * Configura la ayuda para un JFrame dado, vinculando un botón de ayuda y la
     * tecla F1.
     *
     * @param menuAyuda El botón o JMenuItem que mostrará la ayuda al pulsarlo.
     * @param rootPane El JRootPane del JFrame para activar F1.
     * @param topic El tema de ayuda (id) que se mostrará.
     */
    public static void habilitarAyuda(AbstractButton menuAyuda, JRootPane rootPane, String topic) {
        try {
            // Carga del fichero de ayuda
            File f = new File("help" + File.separator + "help_set.hs");
            URL hsURL = f.toURI().toURL();

            // Crea HelpSet y HelpBroker
            HelpSet helpSet = new HelpSet(FormUtils.class.getClassLoader(), hsURL);
            HelpBroker hb = helpSet.createHelpBroker();

            // Asigna ayuda al botón/menu y a la tecla F1
            hb.enableHelpOnButton(menuAyuda, topic, helpSet);
            hb.enableHelpKey(rootPane, topic, helpSet);

        } catch (MalformedURLException | HelpSetException ex) {
            Logger.getLogger(FormUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

     /**
     * Limpia los campos de un contenedor (JFrame, JPanel, JDialog, etc.).
     * <br><br>Soporta automáticamente:
     * <ul>
     *   <li>JTextField → setText("")</li>
     *   <li>JTextArea → setText("")</li>
     *   <li>JComboBox → setSelectedIndex(0), si existe</li>
     *   <li>JCheckBox → setSelected(false)</li>
     *   <li>JRadioButton → setSelected(false)</li>
     *   <li>JSpinner con fecha → reiniciado a new Date()</li>
     *   <li>Contenedores internos → limpieza recursiva</li>
     * </ul>
     *
     * @param contenedor Componente raíz desde donde se buscarán los elementos.
     */
    public static void limpiarFormulario(Container contenedor) {
        for (Component comp : contenedor.getComponents()) {

            if (comp instanceof JTextField txt) {
                txt.setText("");

            } else if (comp instanceof JTextArea area) {
                area.setText("");

            } else if (comp instanceof JComboBox<?> combo) {
                if (combo.getItemCount() > 0) {
                    combo.setSelectedIndex(0);
                }

            } else if (comp instanceof JCheckBox cb) {
                cb.setSelected(false);

            } else if (comp instanceof JRadioButton radio) {
                radio.setSelected(false);

            } else if (comp instanceof JSpinner spinner) {
                if (spinner.getValue() instanceof Date) {
                    spinner.setValue(new Date());
                }

            } else if (comp instanceof Container inner) {
                // Limpieza recursiva para paneles internos
                limpiarFormulario(inner);
            }
        }
    }

     /**
     * Cierra la ventana actual y abre otra ventana tipo JFrame.
     *
     * @param actual JFrame actualmente visible, será cerrado.
     * @param siguiente Nueva ventana a mostrar.
     */
    public static void cambiarVentana(JFrame actual, JFrame siguiente) {
        actual.dispose();
        siguiente.setLocationRelativeTo(null);
        siguiente.setVisible(true);
    }

    /**
     * Cierra la ventana actual y abre la ventana correspondiente según el rol
     * del usuario.
     * <p>
     * Dependiendo del rol proporcionado:
     * <ul>
     * <li>Trabajador: Pregunta confirmación antes de cerrar sesión y vuelve al
     * login.</li>
     * <li>Recepcionista: Abre directamente la ventana de inicio de
     * recepcionista.</li>
     * <li>Administrador: Abre la ventana principal del sistema.</li>
     * <li>Otros roles: Muestra un mensaje de error y vuelve al login.</li>
     * </ul>
     *
     * @param rol Rol del usuario. Ejemplos: "Trabajador", "Recepcionista",
     * "Administrador".
     * @param ventanaActual Ventana JFrame actualmente abierta que será cerrada
     * o reemplazada.
     */
    public static void salirSegunRol(String rol, JFrame ventanaActual) {
        if (rol.equalsIgnoreCase("Trabajador")) {
            int resultado = JOptionPane.showConfirmDialog(ventanaActual,
                    "¿Está seguro de cerrar sesión?",
                    "Atención", JOptionPane.YES_NO_OPTION);

            if (resultado == JOptionPane.YES_OPTION) {
                new FrmLogin().setVisible(true);
                ventanaActual.dispose();
            }
        } else if (rol.equalsIgnoreCase("Recepcionista")) {
            new InicioRecepc().setVisible(true);
            ventanaActual.dispose();
        } else if (rol.equalsIgnoreCase("Administrador")) {
            Principal princ = new Principal();
            princ.setVisible(true);
            princ.setLocationRelativeTo(null);
            ventanaActual.dispose();
        } else {
            JOptionPane.showMessageDialog(ventanaActual,
                    "Rol no reconocido. Cerrando sesión.");
            new FrmLogin().setVisible(true);
            ventanaActual.dispose();
        }

    }

    /**
     * Muestra un cuadro de diálogo personalizado con un mensaje informativo o
     * de error.
     *
     * Este método permite mostrar mensajes emergentes en la interfaz con
     * formato visual mejorado. El tipo de mensaje puede ser informativo
     * ("Info") o de error ("Error"), y se presenta con el título especificado.
     *
     * @param mensaje Texto del mensaje a mostrar.
     * @param tipo Tipo de mensaje: "Info" para información, "Error" para
     * errores.
     * @param titulo titulo del mensaje
     */
    public static void mostrarMensaje(String mensaje, String tipo, String titulo) {

        // Mensaje Borrado 
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);

        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

}
