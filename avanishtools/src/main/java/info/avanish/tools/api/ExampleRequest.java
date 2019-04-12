package info.avanish.tools.api;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

import info.avanish.tools.constant.ApiConstants;
import info.avanish.tools.constant.PrefernceConstants;
import info.avanish.tools.data.MySingleton;


/**
 * Created by Avanish Singh on 11/15/18.
 */

public class ExampleRequest extends BaseStringRequest{
    private Map<String, String> params = new HashMap<>();
    private String userKey;
    private String userType;

    public ExampleRequest(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, ApiConstants.URL_POST_FAQS, listener, errorListener);
        userKey = MySingleton.getInstance(context).getData(PrefernceConstants.USER_ID);
        userType = MySingleton.getInstance(context).getData(PrefernceConstants.IS_USER_OR_SERVICE_PROVIDER);
        buildParams();
    }

    private void buildParams() {
        params.put("user_id", userKey);
        params.put("user_type", userType);

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
