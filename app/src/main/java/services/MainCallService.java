package services;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

import utilities.ConstantsUrlServices;
import utilities.EnumThreads;
import utilities.Message;

/**
 * **************************************************************************
 * NAME: MainCallService.java
 */
class MainCallService {

    //Constructor
    private MainCallService() {
        //not used
    }

    // region GetListEnvironmentRest
    static class GetListArtis extends AsyncTask<String, Void, JSONObject> {

        private final ICallBackServiceRest iCallBackServiceRest;
        @SuppressLint("StaticFieldLeak")
        private final Context context;
        private ProgressDialog dialog;

        GetListArtis(ICallBackServiceRest iCallBackServiceRest, Context context) {
            this.iCallBackServiceRest = iCallBackServiceRest;
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            if (context != null) {
                dialog = Message.getLoadDialog(context);
                dialog.show();
            }
        }

        @Override
        protected JSONObject doInBackground(String... params) {
            try {
                JSONObject paramService = new JSONObject();
                return new RestRequests().makeServiceCallApiKeyGET(ConstantsUrlServices.getWS((Activity) iCallBackServiceRest,
                        ""), ConstantsUrlServices.METHOD_LIST_ARTIST_SERVICE);

            } catch (Exception e) {
                Message.logMessageException(getClass(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            if (dialog != null) dialog.dismiss();
            iCallBackServiceRest.serviceResultRest(result, EnumThreads.GET_LIST_ARTIST);
        }
    }
}
