package persistencia.exceptions;


/**
 * Excepción personalizada utilizada para indicar que una entidad que se intenta crear
 * ya existe en la base de datos.
 * 
 * Esta excepción suele lanzarse durante operaciones de persistencia cuando se detecta
 * una violación de unicidad o duplicación de claves primarias.
 */
public class PreexistingEntityException extends Exception {
    
    /**
     * Crea una nueva instancia de PreexistingEntityException con un mensaje descriptivo
     * y una causa encadenada.
     *
     * @param message Mensaje que describe el error.
     * @param cause   Causa original de la excepción.
     */
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
     /**
     * Crea una nueva instancia de PreexistingEntityException con un mensaje descriptivo.
     *
     * @param message Mensaje que describe el error.
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}
