package info.avanish.tools.api;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import info.avanish.tools.others.JsonUtil;


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
            apiResponse.setSuccess(JsonUtil.getBoolean(jsonObject,"Status"));
            apiResponse.setCode(JsonUtil.getInt(jsonObject,"Code"));
            String message = JsonUtil.getString(jsonObject,"Message").replaceAll("\\[", "").replaceAll("\\]","");
            apiResponse.setMessage(message);
            if (JsonUtil.getBoolean(jsonObject,"Status"))
                apiResponse.setDetails(JsonUtil.getString(jsonObject,"Payload"));

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

    public <T> T getPayload(Class<T> payloadClass) {

        if (apiResponse == null) {
            throw new NullPointerException("call parse(String response) method before getting payload");
        }

        return gson.fromJson(apiResponse.getDetails(), payloadClass);
    }


}
