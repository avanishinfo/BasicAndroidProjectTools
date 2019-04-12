package info.avanish.tools.api;

import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Avanish Singh on 21/02/18.
 */

public class BaseStringRequest extends StringRequest {


    public BaseStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Override
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        RetryPolicy myRetryPolycy = new DefaultRetryPolicy(VolleyNetworkRequest.TIMEOUT_MS,
                VolleyNetworkRequest.MAX_RETRY,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        return super.setRetryPolicy(myRetryPolycy);
    }



    protected String toParam(Integer param){
        return String.valueOf(param);
    }
    protected String toParam(Float param){
        return String.valueOf(param);
    }

    protected String toParam(Long param){
        return String.valueOf(param);
    }
    protected String toParam(Double param){
        return String.valueOf(param);
    }

    protected String toParam(String param){
        return TextUtils.isEmpty(param) ? "" : param;
    }
}
