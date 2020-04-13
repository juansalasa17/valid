package utilities;

/**
 * **************************************************************************
 * NAME: ConstantsServices.java
 * DESCRIPTION:  Clase de Constantes de los Servicios entradas y salidas.
 * ***************************************************************************
 */
public class ConstantsServices {

    //region Params expect by service
    public static final String PARAM_SERVICE_ID_USER = "NumeroIdentificacion";
    public static final String PARAM_SERVICE_TYPE_ID_USER = "TipoIdentificacion";
    public static final String PARAM_SERVICE_ID_DEVICE = "IdDispositivo";
    public static final String PARAM_SERVICE_TOKEN_PUSH = "TokenPush";
    public static final String PARAM_SERVICE_ID_ORDER = "Consecutivo";
    public static final String PARAM_SERVICE_PLU = "Plu";
    public static final String PARAM_SERVICE_NAME_PARAMETER = "NombreParametro";
    public static final String PARAM_SERVICE_VALUE = "Ambiente";

    public static final String PARAM_SERVICE_PASS = "Contrasena";
    public static final String PARAM_SERVICE_ORDER_CART_USER = "Usuario";
    public static final String PARAM_SERVICE_ORDER_CART_CODE_STORE = "CodigoTienda";
    public static final String PARAM_SERVICE_ORDER_CART_QUANTITY_UMP = "CantidadUMP";
    public static final String PARAM_SERVICE_ORDER_CART_TOTAL_QUANTITY = "CantidadTotal";
    public static final String PARAM_SERVICE_ORDER_CART_URL_IMAGE = "UrlImagen";
    public static final String PARAM_SERVICE_ORDER_CART_UNIT_PACKING = "UnidadEmpaque";
    public static final String PARAM_SERVICE_ORDER_CART_FACTOR_UNIT_MINIMUM = "FactorUnidadOrden";
    public static final String PARAM_SERVICE_ORDER_CART_FACTOR_UNIT_PACKING = "FactorUnidadEmpaque";
    public static final String PARAM_SERVICE_ORDER_CART_ITEM_DESCRIPTION = "ItemDescripcion";


    public static final String PARAM_SERVICE_VALUE_APIKEY = "829751643419a7128b7ada50de590067";
    public static final String PARAM_SERVICE_VALUE_COUNTRY = "spain";


    //endregion

    //region Responses
    public static final String RESPONSE_SERVICE_EMPTY = "{}";
    public static final String RESPONSE_SERVICE_DATA_RESULT = "artist";
    public static final String RESPONSE_SERVICE_DATA_RESULT1 = "image";

    public static final String RESPONSE_SERVICE_DESCRIPTION = "topartists";
    public static final String RESPONSE_SERVICE_VALOR = "Valor";

    public static final String RESPONSE_SERVICE_PRODUCT_PLU = "Plu";

    public static final String RESPONSE_SERVICE_URL_IMAGE = "UrlImagen";
    public static final String RESPONSE_SERVICE_ITEM_EAN = "ItemEan";


    public static final String RESPONSE_SERVICE_LIST_ORDER_CART = "ProductosCarrito";
    public static final String RESPONSE_SERVICE_ORDER_CART_PLU = "Plu";
    public static final String RESPONSE_SERVICE_ORDER_CART_ITEM_DESCRIPTION = "ItemDescripcion";
    public static final String RESPONSE_SERVICE_ORDER_CART_QUANTITY_UMP = "CantidadUMP";
    public static final String RESPONSE_SERVICE_ORDER_CART_URL_IMAGE = "UrlImagen";
    public static final String RESPONSE_SERVICE_ORDER_CART_UNIT_FACTOR_PACKING = "FactorUnidadEmpaque";
    public static final String RESPONSE_SERVICE_ORDER_CART_UNIT_MINIMUM = "FactorUnidadOrden";


    public static final String RESPONSE_SERVICE_VALID_TIME_ORDER_CART = "Valor";

    public static final String RESPONSE_SERVICE_ORDER_ENVIRONMENT = "Ambiente";
    public static final String RESPONSE_SERVICE_ORDER_CATEGORY = "Categoria";
    public static final String RESPONSE_SERVICE_ORDER_FACTORY = "FactorUnidadOrden";
    public static final String RESPONSE_SERVICE_ORDER_UND = "UnidadEmpaque";


    public static final String RESPONSE_SERVICE_NAME = "name";
    public static final String RESPONSE_SERVICE_LISTINER = "listeners";
    public static final String RESPONSE_SERVICE_URL = "url";

    //endregion

    //region Generic Response
    static final String RESPONSE_GENERIC_CODE = "cod_result";
    static final String RESPONSE_GENERIC_MESSAGE = "cod_message";
    //endregion

    //Constructor
    private ConstantsServices() {
        throw new IllegalAccessError("ConstantsServices class");
    }
}
