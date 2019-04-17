package info.avanish.myapplication.api;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

import info.avanish.tools.api.BaseStringRequest;
import info.avanish.tools.constant.ApiConstants;

/**
 * Created by avanish on 3/4/18.
 */

public class LoginRequest extends BaseStringRequest {
    private Map<String, String> params = new HashMap<>();
    private String userKey;
    private String accessToken;

    public LoginRequest(String userName, String password, String device_type, String device_id, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Request.Method.POST, ApiConstants.URL_POST_LOGIN, listener, errorListener);
        //userKey = MySingleton.getInstance(context).getUserKey(context);
        //accessToken = AppPrefs.getAccessToken(context);
        buildParams(userName, password,device_type, device_id);
    }

    private void buildParams(String userName, String password,String device_type, String device_id) {
        //params.put(RequestKey.ACCESS_TOKEN, accessToken);
        params.put("username", userName);
        params.put("password", password);

        params.put("device_type", device_type);
        params.put("device_id", device_id);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headerParams = new HashMap<>();
        //headerParams.put(RequestKey.USER_KEY, userKey);
        return headerParams;
    }
}
