package info.avanish.tools.apputils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;

import info.avanish.tools.operation.CheckPermission;
import info.avanish.tools.operation.MyStringUtils;

public class DeviceUtils {

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return MyStringUtils.capitalize(model);
        } else {
            return MyStringUtils.capitalize(manufacturer) + " " + model;
        }
    }

    public static String getDeviceId(Context ctx){
        String deviceId = Settings.Secure.getString(ctx.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return deviceId;
    }

    /**
     * Add READ PHONE STATE PERMISSION WHERE IT'LL CAL;L
     * @param ctx current class
     * @return return imei of device of api request uses.
     */

    @SuppressLint("MissingPermission")
    private void getPhoneDetails(Context ctx) {
        String IMEI;
        boolean permissionStatus = CheckPermission.checkReadPhoneStatePermission(ctx);
        if (permissionStatus) {
            TelephonyManager telephonyManager = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    IMEI = telephonyManager.getImei();
                } else {
                    IMEI = telephonyManager.getDeviceId();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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