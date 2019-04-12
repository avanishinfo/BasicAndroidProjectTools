package info.avanish.tools.constant;

/**
 * Created by avanish on 19/6/18.
 */

public interface DBConsts {

    //for db constants
    String DB_PATH = "";
    String TAG = "DBHelper";

    // columns of the user details table
    String TABLE_USER= "user";

    String COLUMN_USER_ID = "user_id";
    String COLUMN_USER_MOBILE = "user_mobile";
    String COLUMN_USER_EMAIL= "user_email";
    String COLUMN_USER_NAME = "user_name";
    String COLUMN_USER_DEVICE = "user_device";
    String COLUMN_USER_ADDRESS = "user_address";
    String COLUMN_USER_OS_VERSION = "user_os_version";
    String COLUMN_USER_DEVICE_TOKEN = "user_device_token";
    String COLUMN_USER_APP_VERSION = "user_app_version";
    String COLUMN_USER_ENCYT_KEY = "user_encyt_key";
    String COLUMN_USER_DEVICE_ID = "user_device_id";
    String COLUMN_USER_ADMIN = "user_admin";
    String COLUMN_USER_SUPER_ADMIN = "user_super_admin";
    String COLUMN_USER_USER_LAST_LOGIN = "user_last_login";

    String DATABASE_NAME = "/mnt/sdcard/jeem_customer.db";
    int DATABASE_VERSION = 1;
// end db constants
}
