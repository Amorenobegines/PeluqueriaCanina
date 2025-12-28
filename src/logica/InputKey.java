package logica;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Alicia
 */
public class InputKey {

    public static void soloLetras(KeyEvent evt) {
        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void soloNumeros(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void limitar(KeyEvent evt, JTextField txt, int max) {
        if (txt.getText().length() >= max) {
            evt.consume();
        }
    }
}
