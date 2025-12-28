package persistencia.exceptions;

/**
 * Excepción personalizada utilizada para indicar que una entidad solicitada
 * no existe en la base de datos.
 * 
 * Esta excepción suele lanzarse durante operaciones de edición o eliminación
 * cuando no se encuentra la entidad correspondiente al identificador proporcionado.
 */
public class NonexistentEntityException extends Exception {
    
    /**
     * Crea una nueva instancia de NonexistentEntityException con un mensaje
     * descriptivo y una causa encadenada.
     *
     * @param message Mensaje que describe el error.
     * @param cause   Causa original de la excepción.
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
     /**
     * Crea una nueva instancia de NonexistentEntityException con un mensaje descriptivo.
     *
     * @param message Mensaje que describe el error.
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
