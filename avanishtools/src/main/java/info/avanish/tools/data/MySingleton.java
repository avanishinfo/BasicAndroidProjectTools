package info.avanish.tools.data;

import android.content.Context;
import android.content.SharedPreferences;

import info.avanish.tools.constant.PrefernceConstants;


/**
 * Created by avanish.
 */
public class MySingleton {
    private static MySingleton MySingleton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor prefsEditor;

    public static MySingleton getInstance(Context context) {
        if (MySingleton == null) {
            MySingleton = new MySingleton(context);
        }
        return MySingleton;
    }

    private MySingleton(Context context) {
        sharedPreferences = context.getSharedPreferences(PrefernceConstants.PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value)
    {
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public void saveData(String key, Long value)
    {
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putLong(key, value);
        prefsEditor.apply();
    }

    public String getData(String key)
    {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }

    public Long getDataLong(String key)
    {
        if (sharedPreferences!= null) {
            return sharedPreferences.getLong(key, 0);
        }
        return 0l;
    }

  /*  public void saveDataObject(String key, List<LoginResponse> lists)
    {
        Gson gson = new Gson();
        String json = gson.toJson(lists);
        prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, json);
        prefsEditor.apply();
    }

    public List<LoginResponse> getDataOrder(String key){
        if (sharedPreferences!= null) {
            Gson gson = new Gson();
            String json = sharedPreferences.getString(key, "");
            Type type = new TypeToken<List<LoginResponse>>(){}.getType();
            List<LoginResponse> items = gson.fromJson(json, type);
            if (items==null){
                items = new ArrayList<>();
            }
            return items;
        }

        return null;
    }*/


    public void clearData()
    {
        sharedPreferences.edit().clear().apply();

    }
}