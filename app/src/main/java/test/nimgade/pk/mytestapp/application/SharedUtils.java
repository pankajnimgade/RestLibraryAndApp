package test.nimgade.pk.mytestapp.application;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Pankaj Nimgade on 7/6/2017.
 */

public class SharedUtils {

    public static final String TID_KEY = "TID_KEY";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String SHARED_PREFERENCES_FILE_NAME = StartUp
            .getSharedPreferencesFileName();

    public SharedUtils() {
        sharedPreferences = StartUp.getContext().
                getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String readString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public boolean saveString(String stringKey, String value) {
        editor.putString(stringKey, value);
        return editor.commit();
    }
}
