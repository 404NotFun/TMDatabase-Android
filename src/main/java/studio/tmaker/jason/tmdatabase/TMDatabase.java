package studio.tmaker.jason.tmdatabase;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jasontsai on 2017/6/14.
 */

public class TMDatabase {
    private static String APP_SETTINGS = "APP_SETTINGS";
    private static TMDatabase mInstance;
    private static Context mCtx;

    private TMDatabase(Context context) {
        mCtx = context;
    }

    public static synchronized TMDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new TMDatabase(context);
        }
        return mInstance;
    }

    private static SharedPreferences getSharedPreferences() {
        return mCtx.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
    }

    public static String getSharedPreferencesString(String k) {
        return getSharedPreferences().getString(k , null);
    }

    public static void setSharedPreferencesValue(String k, String v) {
        final SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(k , v);
        editor.commit();
    }
}
