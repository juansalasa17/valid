package services;

import android.content.Context;

/**
 * **************************************************************************
 * NAME: CallServiceRest.java
 * DESCRIPTION:  Clase que contiene el llamado a los servicios (hilos) de la aplicacion REST.
 */
public class CallServiceRest {

    // region get getArtis
    public void getArtis(ICallBackServiceRest iCallBackServiceRest, Context context) {
        new MainCallService.GetListArtis(iCallBackServiceRest, context).execute();
    }

    //endregion
}