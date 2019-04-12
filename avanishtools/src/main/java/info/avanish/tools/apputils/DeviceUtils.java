package info.avanish.tools.apputils;

import android.content.Context;
import android.graphics.Point;
import android.location.LocationManager;
import android.provider.Settings;
import android.view.Display;
import android.view.WindowManager;

public class DeviceUtils {
    public static String getDeviceId(Context ctx){
        String deviceId = Settings.Secure.getString(ctx.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return deviceId;
    }
    public static boolean isDeviceLocationEnabled(Context ctx){
        try{
            LocationManager lm = (LocationManager)ctx.getSystemService(Context.LOCATION_SERVICE);
            return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }catch (Exception e){
            return false;
        }
    }
    public static Point getScreenSize(Context ctx){
            WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            return  size;
    }
}