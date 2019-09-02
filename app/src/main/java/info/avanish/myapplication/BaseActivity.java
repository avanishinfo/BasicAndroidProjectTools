package info.avanish.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import info.avanish.tools.MyApplication;
import info.avanish.tools.apputils.AppLogger;
import info.avanish.tools.apputils.LocaleUtils;


public abstract class BaseActivity extends AppCompatActivity implements LocationListener{

    private static final String FOLDER = "NIC_CHALLAN";
    private Context context;
    private KProgressHUD progressDialog;
    protected Toolbar mToolbar;
   // public MySingleton session;
    private LocationManager locationManager;


    public BaseActivity() {
        LocaleUtils.updateConfig(this);
    }
    //**************************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
       // session = MySingleton.getInstance(getApplicationContext());
        createProgressBar("");

    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.activityVisible = true;

        //for location setup
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        try {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyApplication.activityVisible = false;
    }

    protected Animation animateView() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), info.avanish.tools.R.anim.alpha);
        return animation;
    }

    protected void requestError(int code) {
      /*  switch (code) {
            case ApiConstants.STATUS_REQUEST_NOT_AVAILABLE:
                Toast.makeText(getApplicationContext(), info.avanish.tools.R.string.err_server_error404, Toast.LENGTH_SHORT).show();
                break;
            case ApiConstants.STATUS_REQUEST_BROKEN:
                Toast.makeText(getApplicationContext(), info.avanish.tools.R.string.err_server_error500, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), info.avanish.tools.R.string.err_server_errorUnknow, Toast.LENGTH_SHORT).show();
        }*/
    }

    protected void initToolbar(Toolbar toolbar) {
        mToolbar = toolbar;
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

    }

    protected void enableBack(boolean goBack) {
        if (mToolbar == null) {
            return;
        }
        if (goBack) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
            }
        }
    }

    protected void showToolbarLogo(int resId) {
        if (mToolbar == null) {
            return;
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            if (findViewById(resId) == null) {
                actionBar.setIcon(info.avanish.tools.R.drawable.arrow);
            } else {
                actionBar.setIcon(resId);

            }

        }
    }

    protected void enableClose(boolean close) {
        enableBack(close);

        if (close) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(info.avanish.tools.R.drawable.arrow);
            }

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    protected void setTitle(String title) {
        if (mToolbar != null && title != null) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle(title);
            }
        }

    }

    protected void setSubTitle(String subTitle) {
        if (mToolbar != null && subTitle != null) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setSubtitle(subTitle);
            }
        }
    }

    public void createProgressBar(String detailsLabel) {
        progressDialog = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("Please wait")
                .setDetailsLabel(detailsLabel).setWindowColor(getResources().getColor(info.avanish.tools.R.color.colorBlack))
                .setDimAmount(0.5f);
    }

    public void showProgressBar(final String label) {
        if (context != null) {
            if (!isFinishing()) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        createProgressBar(""+label);
                        progressDialog.show();
                    }
                });
            }
        } else {
            createProgressBar(""+label);
            progressDialog.show();
        }
    }

    public void hideProgressBar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

   /* public void startActivityWithAnimation(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.en, R.anim.exit);
    }

    public void finishWithAnimation() {
        finish();
        overridePendingTransition(R.anim.reverse_enter, R.anim.reverse_exit);
    }*/

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void alertMessage(View mRoot, String message) {
        Snackbar snack = Snackbar.make(mRoot, message, Snackbar.LENGTH_LONG);
        View view = snack.getView();
        TextView tv = view.findViewById(info.avanish.tools.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snack.show();
    }

    public void showSnakebar(String message, View view) {
        if (view == null) {
            return;
        } else {
            final Snackbar snackbar = Snackbar.make(view, message, 6000);
            snackbar.setAction("Close", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, info.avanish.tools.R.color.colorAccent));
            snackbar.setActionTextColor(Color.WHITE);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(info.avanish.tools.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(context, info.avanish.tools.R.color.colorWhite));

               /* textView.setTypeface(Typeface.SANS_SERIF);
                textView.setTypeface(Typeface.DEFAULT_BOLD);*/
            snackbar.show();
        }
    }

    public void showSnakebarQuick(String message, View view) {
        if (view == null) {
            return;
        } else {
            final Snackbar snackbar = Snackbar
                    .make(view, message, 3000);
            snackbar.setAction("", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, info.avanish.tools.R.color.colorAccent));
            snackbar.setActionTextColor(Color.WHITE);
            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(info.avanish.tools.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(context, info.avanish.tools.R.color.colorWhite));

               /* textView.setTypeface(Typeface.SANS_SERIF);
                textView.setTypeface(Typeface.DEFAULT_BOLD);*/
            snackbar.show();
        }
    }
    public String getImageDir(Context context) {
        return context.getFilesDir().getAbsolutePath() + "/" + FOLDER + "/";
    }

    public String convertUnixTimeToDate(long unixSeconds) {

        unixSeconds = unixSeconds * 1000L;
     /*   int gmtOffset = TimeZone.getDefault().getRawOffset();
        unixSeconds = unixSeconds + gmtOffset;*/

        Date date = new Date(unixSeconds); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a"); // the format of your date
        String formattedDate = sdf.format(date);
        AppLogger.e("BAseActivity: ", "unixSeconds: " + unixSeconds);
        AppLogger.e("BAseActivity: ", "formattedDate: " + formattedDate);
        System.out.println(formattedDate);

        return formattedDate;
    }

    public String convertUnixTimeToDate2(long unixSeconds) {

        unixSeconds = unixSeconds * 1000L;
       /* int gmtOffset = TimeZone.getDefault().getRawOffset();
        unixSeconds = unixSeconds + gmtOffset;
*/

        Date date = new Date(unixSeconds); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a"); // the format of your date
        // sdf.setTimeZone(TimeZone.getDefault().getRawOffset());
        String formattedDate = sdf.format(date);


        System.out.println(formattedDate);
        AppLogger.e("BAseActivity: ", "unixSeconds: " + unixSeconds);
        AppLogger.e("BAseActivity: ", "formattedDate: " + formattedDate);

        return formattedDate;
    }

    @Override
    public void onLocationChanged(Location location) {


    }



    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public String getCurentAddress(double latitude, double longitude) {
        try {
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(this, Locale.getDefault());

            // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String address = addresses.get(0).getAddressLine(0);

            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
            return address + ", " + city + ", " + postalCode + ", " + country;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    //keytool -exportcert -alias androiddebugkey -keystore ~/.android/debug.keystore | openssl sha1 -binary | openssl base64

}
