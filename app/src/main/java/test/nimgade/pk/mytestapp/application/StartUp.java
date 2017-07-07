package test.nimgade.pk.mytestapp.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import test.nimgade.pk.mytestapp.R;

/**
 * Created by Pankaj Nimgade on 7/6/2017.
 */

public class StartUp extends Application {

    private static final String TAG = StartUp.class.getSimpleName();
    private static String consumerKey;
    private static String consumerSecret;
    private static String domainName;
    private static String SHARED_PREFERENCES_FILE_XML;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Called");
        consumerKey = getResources().getString(R.string.consumer_key);
        consumerSecret = getResources().getString(R.string.consumer_secret);
        domainName = getResources().getString(R.string.domain_name);
        SHARED_PREFERENCES_FILE_XML = getResources().getString(R.string.shared_preferences_file_xml);
        context = getApplicationContext();

        Log.d(TAG, "onCreate: consumerKey: "+consumerKey);
        Log.d(TAG, "onCreate: consumerSecret: "+consumerSecret);
        Log.d(TAG, "onCreate: domainName: "+domainName);
    }

    public static String getConsumerKey() {
        return consumerKey;
    }

    public static String getConsumerSecret() {
        return consumerSecret;
    }

    public static String getDomainName() {
        return domainName;
    }

    protected static String getSharedPreferencesFileName() {
        return SHARED_PREFERENCES_FILE_XML;
    }

    public static Context getContext() {
        return context;
    }
}
