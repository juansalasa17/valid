package utilities;

/**
 * **************************************************************************
 * NAME: ConstantsApp.java
 * DESCRIPTION:  Clase de Constantes de la app.
 * ***************************************************************************
 */
public class ConstantsApp {

    //Times App
    public static final int TMS_SERVICES = 10000; //Time Max response generic Services

    //Constants
    public static final String RESPONSE_ERROR_SERVICE = "error";
    public static final String RESPONSE_SUCCESSFUL = "exitoso";
    public static final String RESPONSE_NO_SERVICE = "No Service";
    public static final String RESPONSE_NO_DATA = "No Data";
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";
    public static final String DATE_SINGLE_FORMAT = "yyyy-MM-dd";
    //Status

    public static final String SEND_ORDER_CART = "sendOrderCart";
    public static final String EDT_ORDER_CART = "updateOrderCart";
    public static final String DELETE_ORDER_CART = "deleteOrderCart";

    static final String LOG_APP = "LOG_APP";
    static final String STRING_SERVICE_OK = "0";
    static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    static final String DATE_FORMAT_HH_MM = "HH:mm";

    //Formats
    static final String FORMAT_REST = "%s/%s";
    public static final String CHANNEL_ID = "NOTIFICATION";
    public static final String DIFFERENT_CHANNEL_ID = "NOTIFY";


    //Constructor
    private ConstantsApp() {
        throw new IllegalAccessError("Constants App Class");
    }
}
