package services;

import org.json.JSONObject;

import utilities.EnumThreads;

/**
 * **************************************************************************
 * NAME: ICallBackServiceRest.java
 * DESCRIPTION:  Interfaz que representa respuesta de los llamados a los servicios REST .
 */
@SuppressWarnings("ALL")
public interface ICallBackServiceRest {
    void serviceResultRest(JSONObject data, EnumThreads method);
}
