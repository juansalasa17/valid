package utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Utilities {

    private Utilities() {
        throw new IllegalStateException("Utility class");
    }


    public static SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat(ConstantsApp.DATE_FORMAT, getCulture());
    }

    @NotNull
    @Contract(" -> new")
    public static Locale getCulture() {
        return new Locale("es", "CO");
    }

    //return validation generic JSON service
    public static boolean validateResponseJSONService(@NotNull JSONObject response) {
        try {
            return (response.has(ConstantsServices.RESPONSE_GENERIC_CODE) && (response.getString(ConstantsServices.RESPONSE_GENERIC_CODE).equals(ConstantsApp.STRING_SERVICE_OK)));
        } catch (JSONException e) {
            Message.logMessageException(null, e);
            return false;
        }
    }

    //return validation generic JSON service
    public static String getMessageJSONService(@NotNull JSONObject response) {
        try {
            if (response.has(ConstantsServices.RESPONSE_GENERIC_MESSAGE))
                return response.getString(ConstantsServices.RESPONSE_GENERIC_MESSAGE);
            else
                return ConstantsMessage.ERROR_SERVICE;
        } catch (JSONException e) {
            Message.logMessageException(null, e);
            return null;
        }
    }

    //return is network available is connected
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = Objects.requireNonNull(cm).getActiveNetworkInfo();
            return activeNetwork == null || !activeNetwork.isConnected();
        } catch (Exception e) {
            Message.logMessageException(null, e);
            return true;
        }
    }

    //Validate if device is zebra
    public static boolean validateZebra() {
        return android.os.Build.MANUFACTURER.contains("Zebra Technologies") || android.os.Build.MANUFACTURER.contains("Motorola Solutions");
    }


    public static boolean validateTimeOrderCart(String currentTime, String timeOrderCart) {
        boolean response = false;
        try {
            SimpleDateFormat hourFormat = new SimpleDateFormat(ConstantsApp.DATE_FORMAT_HH_MM, getCulture());
            Date currentTimeDate = hourFormat.parse(hourFormat.format(Objects.requireNonNull(getDateFormat().parse(currentTime))));
            Date orderCartTimeDate = hourFormat.parse(timeOrderCart);
            if (Objects.requireNonNull(currentTimeDate).compareTo(orderCartTimeDate) <= 0) {
                response = true;
            }
        } catch (Exception e) {
            Message.logMessageException(null, e);
        }
        return response;
    }

    public static boolean validateHandheld() {
        return android.os.Build.MANUFACTURER.contains("CipherLab");
    }

}
