package info.avanish.tools.api;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import info.avanish.tools.R;


public class VolleyErrorMessage {
    public static String getMessage(Context context, VolleyError error){
        if (error instanceof NoConnectionError) {
            return context.getString(R.string.msg_no_internet);
        } else if (error instanceof TimeoutError){
            return context.getString(R.string.msg_request_timed_out);
        }else if (error instanceof AuthFailureError) {
            return context.getString(R.string.msg_authentication_failed);
        } else if (error instanceof ServerError) {
            return context.getString(R.string.msg_server_error);
        } else if (error instanceof NetworkError) {
            return context.getString(R.string.msg_network_error);
        } else if (error instanceof ParseError) {
            return context.getString(R.string.msg_parse_error);
        }
        return context.getString(R.string.msg_unknown_error);
    }
}