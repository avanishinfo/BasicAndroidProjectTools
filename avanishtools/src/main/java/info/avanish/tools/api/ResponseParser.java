package info.avanish.tools.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import info.avanish.tools.apputils.JsonUtil;


/**
 * Created by Avanish Singh on 25/02/18.
 */

public class ResponseParser {

    private String response;
    private ApiResponse apiResponse;
    private Gson gson;

    public ApiResponse parse(String response) {
        this.response = response;
        this.apiResponse = new ApiResponse();
        this.gson = new Gson();
        setApiResponse();
        return apiResponse;

    }

    private void setApiResponse() {

        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.has("status")){
                apiResponse.setStatus(JsonUtil.getInt(jsonObject,"status"));
            }else {
                apiResponse.setSuccess(JsonUtil.getBoolean(jsonObject,"status"));
            }

            if (jsonObject.has("otp")){
                apiResponse.setOtp(JsonUtil.getInt(jsonObject,"otp"));
            }
            if (jsonObject.has("message")){
                String message = JsonUtil.getString(jsonObject,"message").replaceAll("\\[", "").replaceAll("\\]","");
                apiResponse.setMessage(message);
            }
            if (jsonObject.has("date_token")){
                apiResponse.setOther(JsonUtil.getString(jsonObject,"date_token"));
            }
            if (JsonUtil.getInt(jsonObject,"status") == 200)
                apiResponse.setDetails(JsonUtil.getString(jsonObject,"result"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public <T> List<T> getPayloadAsList(Type listType) {
        if (apiResponse == null) {
            throw new NullPointerException("call parse(String response) method before getting payload");
        }
        List<T> list = new Gson().fromJson(apiResponse.getDetails(), listType);
        return list;

    }

    public <T> List<T> getPayloadAsList(Type listType,String response) {
        Gson gson = new Gson();
        listType = new TypeToken<List<T>>() {
        }.getType();
        return gson.fromJson(response, listType);
    }

    public <T> T getPayload(Class<T> payloadClass,String response) {
        return gson.fromJson(response, payloadClass);
    }

    public <T> T getPayload(Class<T> payloadClass) {
        if (apiResponse == null) {
            throw new NullPointerException("call parse(String response) method before getting payload");
        }

        return gson.fromJson(apiResponse.getDetails(), payloadClass);
    }


}
