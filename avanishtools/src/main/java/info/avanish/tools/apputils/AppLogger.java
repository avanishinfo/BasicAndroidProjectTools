package info.avanish.tools.apputils;

import android.util.Log;

import info.avanish.tools.BuildConfig;

/**
 * Created by Avanish Singh on 1/9/17.
 */

public class AppLogger {
    private static boolean DEBUG = BuildConfig.DEBUG;
    //private static boolean DEBUG = false;

    public static void d(String tag, String msg){
        if (DEBUG){
            Log.d(tag, ""+msg);
        }
    }
    public static void e(String tag, String msg){
        if (DEBUG){
            Log.e(tag, ""+msg);
        }
    }
    public static void v(String tag, String msg){
        if (DEBUG){
            Log.v(tag, ""+msg);
        }
    }
    public static void i(String tag, String msg){
        if (DEBUG){
            Log.i(tag, ""+msg);
        }
    }
    public static void w(String tag, String msg){
        if (DEBUG){
            Log.w(tag, ""+msg);
        }
    }
}
