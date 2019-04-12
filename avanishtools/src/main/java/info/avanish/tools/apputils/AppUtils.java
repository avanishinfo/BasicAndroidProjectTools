package info.avanish.tools.apputils;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import androidx.appcompat.app.AlertDialog;
import info.avanish.tools.BuildConfig;
import info.avanish.tools.operation.MyDateUtils;


/**
 * Created by Avanish Singh.
 */
public class AppUtils {

    public static final boolean isDebug = true;
    private static final String TAG = "AppUtils";
    public static AlertDialog d;

    public static String createProfileImageName(Context context){
        if (context == null){
            return null;
        }

        String preFix = "profile_img_";
        long currentTimeInMilli = MyDateUtils.currentTimeInMillis();
        int uid = 0;
        return preFix + uid + "_" + currentTimeInMilli + ".jpg";
    }

    public static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public static void shareApp(Context context, String appUrl, String title) {


        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, appUrl);
        sendIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(sendIntent, title));


    }

    public static void shareApp(Context context) {
        String appUrl = "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
        shareApp(context, appUrl, "Share with");
    }


    public static void rateUs(Context context) {
        final String appPackageName = BuildConfig.APPLICATION_ID;
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    // display a message dialog with custom message
    public static void openUtilityDialog(final Context ctx,
                                         final String messageID) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
        dialog.setMessage(messageID);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        // dialog.show();
        d = dialog.create();
        d.show();
    }


    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


    public static boolean downloadFile(String url, File outputFile) {
        try {
            URL u = new URL(url);
            URLConnection conn = u.openConnection();
            int contentLength = conn.getContentLength();

            DataInputStream stream = new DataInputStream(u.openStream());

            byte[] buffer = new byte[contentLength];
            stream.readFully(buffer);
            stream.close();

            DataOutputStream fos = new DataOutputStream(new FileOutputStream(outputFile));
            fos.write(buffer);
            fos.flush();
            fos.close();

            return true;
        } catch (IOException e) {
            return false; // swallow a 404
        }
    }


 /*   //for permission request
    String[] permissions = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };


    public boolean checkPermissions(Activity context) {
        final int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            int result;
            List<String> listPermissionsNeeded = new ArrayList<>();
            for (String p : permissions) {
                result = ContextCompat.checkSelfPermission(context, p);
                if (result != PackageManager.PERMISSION_GRANTED) {
                    listPermissionsNeeded.add(p);
                }
            }
            if (!listPermissionsNeeded.isEmpty()) {
                ActivityCompat.requestPermissions(context, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 100);
                return false;
            }
        }

        return true;
    }*/
}
