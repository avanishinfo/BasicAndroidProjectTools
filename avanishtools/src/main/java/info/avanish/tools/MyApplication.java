package info.avanish.tools;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    // Gloabl declaration of variable to use in whole app
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
