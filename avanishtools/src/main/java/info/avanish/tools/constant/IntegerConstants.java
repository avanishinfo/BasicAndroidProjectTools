package info.avanish.tools.constant;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by avanish.
 */

public interface IntegerConstants {

    int REQUEST_CAMERA = 1001;
    int REQUEST_Gallery = 1002;
    int REQUEST_LOCATION = 1003;
    int REQUEST_CATEGORY_RESULT = 1004;

    int CONNECT_PRINTER = 1005;
    int PRINT_CONTENT = 1006;

    //app cast for request permission
    int LOCATION_REQUEST = 1007;
    int GPS_REQUEST = 1008;

    int LOG_MANAGEMENT = 1009;
    int BACKUP_RESTORE = 10010;
    int LATEST_APPLICATION = 10011;
    int CHANGE_LOG = 10012;
    int DEVICE_DIAGNOSIS = 10023;
    int ON_SCREEN_SIGNATURE = 10015;
    int ON_CHANGE_PASSWORD = 10016;

    int BY_CASH_RADIO_BUTTON_ID = 1017;
    int BY_CARD_RADIO_BUTTON_ID = 1018;
    int BY_PAYTM_RADIO_BUTTON_ID = 1019;

    int VEHICLE = 10000;
    int OWNER_IMAGE = 10001;
    int VEHICLE_IMAGE = 14001;
    int DRIVER = 10002;
    int CONDUCTOR = 10003;
    int OTHER = 10004;
    int VEHICLE_IMP = 10005;
    int DOC_IMP_1 = 10006;
    int DOC_IMP_2 = 10007;
    int DOC_IMP_3 = 10008;
    int DOC_IMP_4 = 10009;
    int DOC_IMP_5 = 10010;
    int REMARKS = 10011;

    // Activity ID
    int ACTIVITY_DASHBOARD = 10105;
    int ACTIVITY_ON_SCREEN_SIGNATURE = 10106;
    int ACTIVITY_CREATE_CHALLAN_ACCUSED_SIGN_OWNER = 10107;
    int ACTIVITY_CREATE_CHALLAN_ACCUSED_SIGN_DRIVER = 10108;

    int NOT_IMPOUNDED = 0;
    int IMPOUNDED = 1;
    int REMARK_NOT_AVAILABLE = 0;
    int REMARK_AVAILABLE = 1;
    int WITNESS_NOT_AVAILABLE = 0;
    int WITNESS_AVAILABLE = 1;
    int COURT_NOT_ELIGIBLE = 0;
    int COURT_ELIGIBLE = 1;

    int CURRENT_DAY_CHALLAN = 0;
    int CURRENT_DAY_CHALLAN_SYNCED = 10;
    int MISCELLANEOUS_CHALLAN = 1;
    int ARCHIVE_CHALLAN = 2;
    int OFFLINE_CHALLAN = 3;
    int DRAFT_CHALLAN = 44;
    int NOT_SPECIFIED = -1;

    int NOT_SUBMITTED = 0;
    int SUBMITTED = 1;

    int FILTER_BY_CURRENT_MONTH = 0;
    int FILTER_BY_RANGE = 1;
    int FILTER_BY_NO_DATE = 2;

    int MODE_RECENT = 0;
    int MODE_ALL = 1;
    int PENALTY_1 = 1;
    int PENALTY_2 = 2;

    int INIT_STATE = 0;
    int WORKING_STATE = 1;
    int _STATE = 2;
    int _SUCCESS_STATE = 20;
    int _FAILED_STATE = 21;
    int CHECKED = 1;
    int UN_CHECKED = 0;
    int IS_ACTIVE = 1;
    int IS_IN_ACTIVE = 0;

    public static int AEM_DEVICE = 0;
    public static int LEOPARD_DEVICE = 1;
    public static int EPSON_DEVICE = 2;
    int SOFTLAND_DEVICE = 3;
    int WEIPASS_DEVICE = 4;

    int TPS900 = 5;

    int ZEBRA_DEVICE = 6;
    int NEXGO_DEVICE = 7;

    int MOSAMBEE_DEVICE = 8;
    //for chennai
    int PAX_DEVICE = 9;
    int VISIONTEK_PRINTER_DEVICE = 10;

    int QR_CODE = 10;
    int RC_CARD = 11;
    int DL_CARD = 12;

    int ROAD_MASTER_SOURCE = 0;
    int ROAD_MASTER_DESTINATION = 1;
    int FROM_SERVER = 0;
    int FROM_MPARIVAHAN = 1;
    int DETAILS_FAILED = -1;

    //Admin
    int TRANSPORT_DEPARTMENT = 0;
    int TRAFFIC_DEPARTMENT = 1;
    // User Code
    int STATE_ADMIN = 0;
    int TP_RTO = 1;
    int CIRCLE_ARTO = 2;
    int CPU_DEPT = 30;
    int CASHIER = 31;
    int CLERK = 32;
    int CHALLAN_PENDING = 0;
    int CHALLAN_DRAFT = 0;
    int CHALLAN_SUBMITTED = 1;
    int CHALLAN_ALL_USER_DEPENDENT = 2;
    int CHALLAN_ALL_USER_DEPENDENT_PENDING = 3;
    int SUBMITTED_CHALLAN_ALL_USER_DEPENDENT_PENDING = 33;
    int CHALLAN_ALL_USER_DEPENDENT_DONE = 4;
    int CHALLAN_ALL_USER_INDEPENDENT = 5;
    int CHALLAN_ALL_USER_INDEPENDENT_PENDING = 6;
    int SUBMITTED_CHALLAN_ALL_USER_INDEPENDENT_PENDING = 66;
    int CHALLAN_ALL_USER_INDEPENDENT_DONE = 7;
    int TODAY_CHALLAN_USER_DEPENDENT = 80;
    int TODAY_CHALLAN_SUBMITTED_USER_DEPENDENT = 81;
    int TODAY_CHALLAN_PENDING_USER_DEPENDENT = 82;
    int CURRENT_DAY_CHALLAN_FINE_ALL = 20;
    int CURRENT_DAY_CHALLAN_FINE_PENDING = 21;
    int CURRENT_DAY_CHALLAN_FINE_COLLECTED = 22;
    int TOTAL_CHALLAN_FINE_COLLECTED = 23;

    /////////////////////////// TPS900 /////////////////////////////
    int NOPAPER = 3;
    int LOWBATTERY = 4;
    int PRINTVERSION = 5;
    int PRINTBARCODE = 6;
    int PRINTQRCODE = 7;
    int PRINTPAPERWALK = 8;
    int PRINTCONTENT = 9;
    int CANCELPROMPT = 10;
    int PRINTERR = 11;
    int OVERHEAT = 12;
    int MAKER = 13;
    int PRINTPICTURE = 14;
    int NOBLACKBLOCK = 15;

    int MEDIA_TYPE_IMAGE = 1;
    int MEDIA_TYPE_VIDEO = 2;

    int ENG = 0;
    int HI = 1;


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
