package services;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import utilities.ConstantsApp;
import utilities.ConstantsMessage;
import utilities.Message;

/**
 * **************************************************************************
 * NAME: RestRequests.java
 * DESCRIPTION:  Clase que contiene el llamado a un servicios.
 */
@SuppressWarnings("SpellCheckingInspection")
class RestRequests {
    //CONSTRUCTOR
    RestRequests() {
    }

    /**
     * @param mainRequestURL Donde se envia la consulta
     * @param methodName     Metodo ocupado
     * @param params         Cuerpo de la consulta
     * @return JSON respuesta del servicio
     */
    JSONObject makeServiceCallApiKeyPOST(final String mainRequestURL, final String methodName, final JSONObject params) {
        return callServiceApiKeyPOST(mainRequestURL, methodName, params.toString());
    }

    /**
     * @param mainRequestURL Donde se envia la consulta
     * @param methodName     Metodo ocupado
     * @return JSON respuesta del servicio
     */
    JSONObject makeServiceCallApiKeyGET(final String mainRequestURL, final String methodName) {
        return callServiceApiKeyGET(mainRequestURL, methodName);
    }

    //call service POST
    private JSONObject callServiceApiKeyPOST(String mainRequestURL, String methodName, String params) {
        try {
            HttpURLConnection connection;
            JSONObject request;
            URL url = new URL(String.format(ConstantsMessage.FORMAT_CONCAT_URL, mainRequestURL, methodName));
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", ConstantsMessage.FORMAT_CONTENT_TYPE);
            connection.setRequestProperty("Accept", ConstantsMessage.FORMAT_CONTENT_TYPE);
            connection.setConnectTimeout(ConstantsApp.TMS_SERVICES);
            connection.setReadTimeout(ConstantsApp.TMS_SERVICES);
            connection.connect();
            if (tryConnectionPOST(params, connection)) {
                disconnectConnection(connection);
                return new JSONObject().put(ConstantsApp.RESPONSE_ERROR_SERVICE, ConstantsApp.RESPONSE_NO_SERVICE);
            }
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = bufferedReader.readLine()) != null)
                    response.append(inputLine);
                bufferedReader.close();
                request = new JSONObject(response.toString());
                disconnectConnection(connection);
                return request;
            } else if (connection.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT) {
                disconnectConnection(connection);
                return new JSONObject().put(ConstantsApp.RESPONSE_SUCCESSFUL, ConstantsApp.RESPONSE_NO_DATA);
            } else {
                disconnectConnection(connection);
                return new JSONObject().put(ConstantsApp.RESPONSE_ERROR_SERVICE, ConstantsApp.RESPONSE_NO_SERVICE);
            }
        } catch (SocketTimeoutException e) {
            Message.logMessageException(getClass(), e);
            try {
                return new JSONObject().put(ConstantsApp.RESPONSE_ERROR_SERVICE, ConstantsApp.RESPONSE_NO_SERVICE);
            } catch (JSONException e1) {
                Message.logMessageException(getClass(), e1);
                return null;
            }
        } catch (IOException | JSONException e) {
            Message.logMessageException(getClass(), e);
            return null;
        }
    }

    //call service GET
    private JSONObject callServiceApiKeyGET(String mainRequestURL, String methodName) {
        try {
            HttpURLConnection connection;
            JSONObject request;
            URL url = new URL(String.format(ConstantsMessage.FORMAT_CONCAT_URL, mainRequestURL, methodName));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(ConstantsApp.TMS_SERVICES);
            connection.setReadTimeout(ConstantsApp.TMS_SERVICES);
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = bufferedReader.readLine()) != null)
                    response.append(inputLine);
                bufferedReader.close();
                request = new JSONObject(response.toString());
                disconnectConnection(connection);
                return request;
            } else if (connection.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT) {
                disconnectConnection(connection);
                return new JSONObject().put(ConstantsApp.RESPONSE_SUCCESSFUL, ConstantsApp.RESPONSE_NO_DATA);
            } else {
                disconnectConnection(connection);
                return new JSONObject().put(ConstantsApp.RESPONSE_ERROR_SERVICE, ConstantsApp.RESPONSE_NO_SERVICE);
            }
        } catch (SocketTimeoutException e) {
            Message.logMessageException(getClass(), e);
            try {
                return new JSONObject().put(ConstantsApp.RESPONSE_ERROR_SERVICE, ConstantsApp.RESPONSE_NO_SERVICE);
            } catch (JSONException e1) {
                Message.logMessageException(getClass(), e1);
                return null;
            }
        } catch (IOException | JSONException e) {
            Message.logMessageException(getClass(), e);
            return null;
        }
    }

    //load parameters request
    private boolean tryConnectionPOST(String params, HttpURLConnection connection) {
        try {
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(params);
            writer.close();
            outputStream.close();
        } catch (IOException e) {
            Message.logMessageException(getClass(), e);
            return true;
        }
        return false;
    }

    //Disconnect connection
    private void disconnectConnection(HttpURLConnection connection) {
        try {
            if (connection != null)
                connection.disconnect();
        } catch (Exception e) {
            Message.logMessageException(getClass(), e);
        }
    }
}