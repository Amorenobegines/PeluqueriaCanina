package persistencia.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Excepción personalizada utilizada para indicar que una operación de persistencia
 * violaría restricciones de integridad referencial, dejando entidades huérfanas.
 * 
 * Esta excepción suele lanzarse cuando se intenta eliminar o modificar una entidad
 * que tiene relaciones dependientes no gestionadas adecuadamente.
 */
public class IllegalOrphanException extends Exception {
    private List<String> messages;
    
     /**
     * Crea una nueva instancia de IllegalOrphanException con una lista de mensajes
     * de error detallados.
     *
     * @param messages Lista de mensajes que describen las causas de la excepción.
     *                 El primer mensaje se utiliza como mensaje principal de la excepción.
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        else {
            this.messages = messages;
        }
    }
    
    /**
     * Devuelve la lista completa de mensajes asociados a esta excepción.
     *
     * @return Lista de cadenas con los mensajes de error.
     */
    public List<String> getMessages() {
        return messages;
    }
}
