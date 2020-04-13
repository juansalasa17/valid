package utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * **************************************************************************
 * NAME: DataBase.java
 * DESCRIPTION: Persistence of internal data.
 * ***************************************************************************
 */
@SuppressWarnings("FieldCanBeLocal")
public class DataBase {

    //region Variables

    //Version data base
    private static final int VERSION_BD = 1;
    //Name data base
    private static final String NAME_BD = "BDMOVIL";
    //Sentence Create Table
    private static final String CREATE_TABLE_IF_EXISTS = "CREATE TABLE IF NOT EXISTS";
    //Sentence Delete Data
    private static final String DELETE_FROM = "DELETE FROM 'main'.'%s'";
    //region Name tables
    private static final String TABLE_CURRENT_ORDER = "CurrentOrder";
    // endregion
    //region Columns Tables
    //Table SESSION
    private static final String CONSECUTIVE_ORDER = "Consecutive";
    //endregion

    //region Sentence Create Tables
    private static final String BD_ORDER = String.format("%s %s(%s TEXT)", CREATE_TABLE_IF_EXISTS, TABLE_CURRENT_ORDER, CONSECUTIVE_ORDER);
    //endregion
    //Context
    private final Context mCtx;
    //Helper
    private final DatabaseHelper mBdHelper;
    //Name instance BD
    private SQLiteDatabase sqLiteDatabase;

    //endregion

    //region Internal
    public DataBase(Context ctx) {
        this.mCtx = ctx;
        mBdHelper = new DatabaseHelper(mCtx);
    }

    private void open() {
        sqLiteDatabase = mBdHelper.getWritableDatabase();
    }

    private void close() {
        mBdHelper.close();
    }
    //endregion

    //region Table Session

    //insert a new session in the table session
    public void insertSession(String consecutive) {
        try {
            open();
            ContentValues values = new ContentValues();
            values.put(CONSECUTIVE_ORDER, consecutive);
            sqLiteDatabase.insert(TABLE_CURRENT_ORDER, null, values);
        } catch (Exception e) {
            Message.logMessageException(getClass(), e);
        } finally {
            close();
        }
    }

    //Read if exist a Session in the table Session and return idUser
    public String readConsecutive() {
        try {
            open();
            String[] campos = new String[]{CONSECUTIVE_ORDER};
            Cursor cursorSession = sqLiteDatabase.query(TABLE_CURRENT_ORDER, campos, null, null, null, null, null);
            String sessionBD = ConstantsApp.EMPTY_STRING;
            if (cursorSession != null) {
                cursorSession.moveToFirst();
                if (cursorSession.getCount() > 0)
                    sessionBD = cursorSession.getString(0);
                cursorSession.close();
            }
            return sessionBD;
        } catch (Exception e) {
            Message.logMessageException(getClass(), e);
            return ConstantsApp.EMPTY_STRING;
        } finally {
            close();
        }
    }

    //endregion

    //region Private Class DatabaseHelper

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, NAME_BD, null, VERSION_BD);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //Create Tables
            try {
                db.execSQL(BD_ORDER);
            } catch (Exception e) {
                Message.logMessageException(getClass(), e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int previousVersion, int newVersion) {
            //Not used in version 1
        }
    }

    //endregion
}