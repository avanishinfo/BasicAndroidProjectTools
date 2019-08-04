package info.avanish.tools;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

import info.avanish.tools.apputils.LocaleUtils;

public class MyApplication extends Application {


    private Locale locale = null;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleUtils.updateConfig(this, newConfig);
    }

    public static boolean activityVisible; // Variable that will check the
    // current activity state
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static boolean isActivityVisible() {
        return activityVisible; // return true or false
    }

    public static void activityResumed() {
        activityVisible = true;// this will set true when activity resumed
    }
    public static void activityPaused() {
        activityVisible = false;// this will set false when activity paused
    }

}
