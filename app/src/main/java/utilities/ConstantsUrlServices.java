package utilities;

import android.app.Activity;

import com.valid.prueba.R;

/**
 * **************************************************************************
 * NAME: ConstantsUrlServices.java
 * DESCRIPTION:  Clase de Las URL utilizadas en los servicios de la app.
 * ***************************************************************************
 */
public class ConstantsUrlServices {

    public static final String METHOD_PARAMS = "Parametros";
    public static final String CLASS_PARAMS = "Parametros";
    public static final String CLASS_ADMIN = "Administracion";


    public static final String METHOD_AUTH_USER = "autenticarUsuario";
    public static final String METHOD_REGISTER_ORDER_CART_SERVICE = "IngresarProductoCarrito";
    public static final String METHOD_LIST_HISTORY_ORDER_CART_SERVICE = "ObtenerHistoricoPedido";
    public static final String METHOD_UPDATE_ORDER_CART_SERVICE = "ModificarProductoCarrito";
    public static final String METHOD_DELETE_ORDER_CART_SERVICE = "EliminarProductoCarrito";
    public static final String METHOD_LIST_ORDER_CART_SERVICE = "ConsultarCarrito";
    public static final String METHOD_PARAMS_RETURN_VALIDATE_TIME_ORDER_CART = "Modulo?modulo=HR_VALIDA";
    public static final String METHOD_RETURN_SYSTEM_TIME = "ObtenerFechaSistema";
    public static final String METHOD_SEND_ORDER_CART_SERVICE = "EnviarPedido";
    public static final String METHOD_PARAMS_RETURN_ENVIRONMENT = "Modulo?modulo=TIPO_BOD";

    public static final String CLASS_AUTHORIZATION = "autorizacion";

    public static final String METHOD_LIST_ARTIST_SERVICE = "?method=geo.gettopartists&country=spain&api_key=829751643419a7128b7ada50de590067&format=json";
    public static final String CLASS_SERVICE = "";
    public static final String METHOD_ADMIN_ORDER_HEADER = "?method=geo.gettopartists";
    public static final String METHOD_LIST_CATALOG_SERVICE = "/?method=geo.gettopartists";


    //Constructor
    private ConstantsUrlServices() {
        throw new IllegalAccessError("ConstantsUrlServices class");
    }

    //Arma la URL de cada servicio
    public static String getWS(Activity activity, String clase) {
        return String.format(ConstantsApp.FORMAT_REST, activity.getString(R.string.app_server), clase);
    }


}
