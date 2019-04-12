package info.avanish.tools.api;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import info.avanish.tools.constant.ApiConstants;
import info.avanish.tools.constant.PrefernceConstants;
import info.avanish.tools.data.MySingleton;
import info.avanish.tools.network.MultipartUtility;

/**
 * Created by Avanish Singh on 9/23/18.
 */

public class UpdateProfileMultipartAsync extends AsyncTask<Void, Void, String> {
    private Context context;
    private UpdateListener listener;
    private String responseString;
    String full_name, user_id, profile_image, user_type, introduction, about, experience, hourly_rate;

    private String TAG = "UpdateProfileMultipartAsync";

    public UpdateProfileMultipartAsync(Context context, UpdateListener listener, String full_name, String profile_image, String introduction, String about, String experience, String hourly_rate) {
        this.context = context;
        this.listener = listener;

        this.full_name = full_name;
        this.user_id = MySingleton.getInstance(context).getData(PrefernceConstants.USER_ID);

        this.profile_image = profile_image;
        this.user_type = MySingleton.getInstance(context).getData(PrefernceConstants.IS_USER_OR_SERVICE_PROVIDER);
        this.introduction = introduction;
        this.about = about;
        this.experience = experience;
        this.hourly_rate = hourly_rate;

    }

    @Override
    protected String doInBackground(Void... params) {

        try {
            MultipartUtility multipart = new MultipartUtility(ApiConstants.URL_POST_UPDATE_PROFILE, "UTF-8");
            multipart.addFormField("full_name", full_name);
            multipart.addFormField("user_id", user_id);

            if (!profile_image.equalsIgnoreCase(""))
                multipart.addFilePart("profile_image", new File(profile_image));


            multipart.addFormField("user_type", user_type);
            multipart.addFormField("introduction", introduction);
            multipart.addFormField("about", about);
            multipart.addFormField("experience", experience);
            multipart.addFormField("hourly_rate", hourly_rate);

            String response = multipart.finish();

            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result != null && !isStringEmpty(result)) {
            try {
                JSONObject data = new JSONObject(result);
                if (data.has("Code")) {
                    if (data.getInt("Code") == 200) {
                        listener.updateListenerFinished(200, result);
                    } else {
                        listener.updateListenerFinished(400, data.getString("message"));
                    }
                } else {
                    listener.updateListenerFinished(400, data.getString("message"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


    public interface UpdateListener {
        void updateListenerFinished(int code, String response);

    }

    public static boolean isStringEmpty(String str) {

        if (str == null)
            return true;

        return str == null
                || str.equals("null") || str.equals("") || (str.trim().length() == 0);
    }
}
