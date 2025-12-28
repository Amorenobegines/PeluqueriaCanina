
package peluqueriacanina;

import igu.FrmLogin;

/**
 * Clase principal del sistema de gestión de la peluquería canina.
 * 
 * Esta clase contiene el método `main` que inicia la ejecución de la aplicación
 * mostrando la interfaz de inicio de sesión.
 * 
 * @author Alicia
 */
public class PeluqueriaCanina {

    /**
     * Método principal que lanza la aplicación.
     * 
     * Crea una instancia del formulario de inicio de sesión (`FrmLogin`)
     * y la hace visible para que el usuario pueda autenticarse.
     *
     * @param args Argumentos de línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        FrmLogin frLogin = new FrmLogin();
        frLogin.setVisible(true);
    }
}
