package utilities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.valid.prueba.R;

import java.util.Objects;


/**
 * **************************************************************************
 * NAME: Message.java
 * DESCRIPTION:  Class Messages app.
 */
public class Message {

    //Constructor
    private Message() {
        throw new IllegalAccessError("Message class");
    }


    //Show Message
    public static void showMessage(String message, Context context, int image) {
        try {
            getDialog(message, context, image).show();
        } catch (Exception e) {
            logMessageException(context.getClass(), e);
        }
    }

    //region Exceptions
    //Capture exception and sample log
    public static void logMessageException(Class method, Exception exception) {
        try {
            if (method != null && method.getEnclosingMethod() != null)
                Log.d(ConstantsApp.LOG_APP, method.getEnclosingMethod().getName() + ConstantsApp.SPACE + exception.getMessage());
            else
                Log.d(ConstantsApp.LOG_APP, Objects.requireNonNull(exception.getMessage()));
        } catch (Exception e) {
            Log.d(ConstantsApp.LOG_APP, e.getMessage(), e);
        }
    }

    //endregion

    //region Private Methods

    //Get custom dialog generic
    public static Dialog getDialog(String message, Context context, int image) {
        final Dialog dialog = new Dialog(context);
        try {
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.custom_message);
            ((TextView) dialog.findViewById(R.id.txtMessage)).setText(Html.fromHtml(message));
            ImageView imageView = dialog.findViewById(R.id.imgMessage);
            switch (image) {
                case 0:
                    imageView.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.img_ok_message);
                    break;
                case 2:
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.img_error_message);
                    break;
                case 3:
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(R.drawable.img_important);
                    break;
                default:
                    break;
            }

            dialog.findViewById(R.id.btnCloseMessage).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.findViewById(R.id.btnOkMessage).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            if (dialog.getWindow() != null)
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        } catch (Exception e) {
            logMessageException(context.getClass(), e);
        }
        return dialog;
    }


    //Get custom dialog generic
    public static ProgressDialog getLoadDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        try {
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage(context.getString(R.string.txt_Loading));
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception e) {
            logMessageException(context.getClass(), e);
        }
        return dialog;
    }
    //endregion


    //Get product enlisted dialog
    public static Dialog getDialogDetail(Context context) {
        final Dialog dialog = new Dialog(context);
        try {
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.custom_detail);

            if (dialog.getWindow() != null)
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        } catch (Exception e) {
            logMessageException(context.getClass(), e);
        }
        return dialog;
    }

}