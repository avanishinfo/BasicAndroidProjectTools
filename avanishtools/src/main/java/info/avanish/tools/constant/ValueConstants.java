package info.avanish.tools.constant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

/**
 * Created by avanish.
 */

public interface ValueConstants {

    String DEVICE_TYPE = "android";

    //app const for date and time
    String SINCE_DATE_FORMAT = "dd MMM yyyy";
    String DATE_INPUT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    String DATE_OUTPUT_FORMAT = "EEEE, h:mm a";

    //app canst for broadcast
    String BROADCAST_REQUEST_ = "info.avanish.REQUEST_PROCESSED";
    String BROADCAST_MESSAGE_ = "info.avanish.MSG";

    //app cast for request permission
    int REQUEST_CAMERA = 1001;
    int REQUEST_Gallery = 1002;
    int REQUEST_LOCATION = 1003;
    int REQUEST_CATEGORY_RESULT = 1004;

    //const value
    String _TRUE = "true";
    String _FALSE = "false";

    String _OKAY = "okay";
    String _CANCEL = "cancel";


    String _SOCIAL_TYPE_FB = "F";
    String _SOCIAL_TYPE_GP = "G";
    String _SOCIAL_TYPE_INS = "I";

    String _SUCCESS = "success";
    String _FAIL = "fail";


    String _NEW = "new";
    String _ACTIVE = "active";
    String _COMPLETE = "complete";

    String _CANCLLED = "cancelled";


    int FEEDBACK_FRAGMENT = 5;
    int RATE_US_FRAGMENT = 6;
    int ABOUT_FRAGMENT = 7;
    int SINGOUT_DAILOG = 8;
    int SING_UP_ACTIVITY = 10;
    int SING_IN_ACTIVITY = 11;

    // type check for error during login
    @IntDef({ValidationType.VALID, ValidationType.USER_NAME_INVALID, ValidationType.PASSWORD_INVALID})
    @Retention(RetentionPolicy.SOURCE)
    @interface ValidationType {
        int VALID = 0, USER_NAME_INVALID = 1, PASSWORD_INVALID = 2;
    }

    // type of dialog opened in
    @IntDef({DialogType.DIALOG_DENY, DialogType.DIALOG_NEVER_ASK})
    @Retention(RetentionPolicy.SOURCE)
    @interface DialogType {
        int DIALOG_DENY = 0, DIALOG_NEVER_ASK = 1;
    }


}
