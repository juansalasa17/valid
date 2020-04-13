package utilities;

/**
 * **************************************************************************
 * NAME: ConstantsMessage.java
 * DESCRIPTION:  Clase de Constantes de los mensajes.
 * ***************************************************************************
 */
public class ConstantsMessage {
    public static final String FORMAT_CONTENT_TYPE = "application/json";
    public static final String FORMAT_CONCAT_URL = "%s/%s";
    public static final String ERROR_SERVICE = "Error Servicio";
    public static final int IMAGE_OK = 1;
    public static final int IMAGE_ERROR = 2;

    //Constructor
    private ConstantsMessage() {
        throw new IllegalAccessError("ConstantsMessage class");
    }

}
