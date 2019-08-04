package info.avanish.tools.constant;

/**
 * Created by avanish.
 */

public interface StringConstants {

    String DEVICE_TYPE = "android";

    //app const for date and time
    String SINCE_DATE_FORMAT = "dd MMM yyyy";
    String DATE_INPUT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    String DATE_OUTPUT_FORMAT = "EEEE, h:mm a";

    //app canst for broadcast
    String BROADCAST_REQUEST_ = "info.avanish.REQUEST_PROCESSED";
    String BROADCAST_MESSAGE_ = "info.avanish.MSG";

    String _SUCCESS = "success";
    String _FAIL = "fail";

    String SECRET_KEY = "E@CHALLAN*#2015!";

    String VEHICLE_DETAILS_SECRET_KEY = "eECHALLAN@JSON$#";
    String ARCHIVE_KEY = "_2017@ZIP$#";

    String ACTIVITY_FROM = "ACTIVITY_FROM";
    String DRAFT = "DRAFT";
    String CREATE_CHALLAN_ACTIVITY = "CREATE_CHALLAN_ACTIVITY";

    String ACCUSED_OWNER = "OWNER";
    String ACCUSED_DRIVER = "DRIVER";
    String ACCUSED_BOTH = "OWNER AND DRIVER";
    String ACCUSED_BOTH_DL = "DRIVER AND OWNER";
    String ACCUSED_CONDUCTOR = "CONDUCTOR";
    String ACCUSED_OTHER = "OTHER";

    String MONTHLY = "M";
    String QUARTERLY = "Q";
    String YEARLY = "Y";

    String RECEIPT_SECRET_KEY = "E@CHALLAN*#2017$";
    String KEY_ECHALLAN_MPARIVAHAN = "E@CHALLAN*#2017!";

    String INVESTIGATION_ADAPTER = "INVESTIGATION_ADAPTER";
    String CHALLAN_ID = "CHALLAN_ID";
    String CHALLAN_INVESTIGATION_DETAILS = "CHALLAN_INVESTIGATION_DETAILS";
    String CHALLAN_DETAILS = "CHALLAN_DETAILS";
    String CHALLAN_DRAFT_DETAILS = "CHALLAN_DRAFT_DETAILS";

    String NAVIGATION = "NAVIGATION";
    String NAVIGATION_ACTION = "NAVIGATION_ACTION";
    String ACTION = "ACTION";
    String STATE_ADMIN_MODEL = "STATE_ADMIN_MODEL";
    String CIRCLE_ARTO_LIST = "CIRCLE_ARTO_LIST";
    String TRAFFIC_DETAILS_MODEL = "TRAFFIC_DETAILS_MODEL";
    String CIRCLE_ARTO_DETAILS_MODEL = "CIRCLE_ARTO_DETAILS_MODEL";
    String IS_FROM_ADAPTER = "IS_FROM_ADAPTER";
    String IS_FROM = "IS_FROM";
    String ID = "ID";

    String STATE_ADMIN_TRAFFIC = "STATE_ADMIN_TRAFFIC";
    String TRAFFIC_POLICE = "TRAFFIC_POLICE";
    String CIRCLE = "CIRCLE";
    String CPU_DEPARTMENT = "CPU_DEPARTMENT";
    String TRAFFIC_CASHIER = "TRAFFIC_CASHIER";
    String TRAFFIC_CLERK = "TRAFFIC_CLERK";
    String STATE_ADMIN_TRANSPORT = "STATE_ADMIN";
    String RTO_ADMIN = "RTO_ADMIN";
    String ARTO = "ARTO";
    String DEPARTMENT = "DEPARTMENT";
    String CASHIER_TRANSPORT = "CASHIER";
    String CLERK_TRANSPORT = "CLERK";

    String FILTER_MODE = "FILTER_MODE";

    String TO_DATE = "TO_DATE";
    String FROM_DATE = "FROM_DATE";
    String CURRENT_DATE = "CURRENT_DATE";
    String FILTER_DATE = "FILTER_DATE";

    String CHALLAN_NO = "CHALLAN_NO";
    String CHALLAN_NO_TWO = "CHALLAN_NO_TWO";
    String TWO_CHALLAN_CASE = "TWO_CHALLAN_CASE";

    String CHALLAN_FINE = "CHALLAN_FINE";
    String TOTAL_FINE = "TOTAL_FINE";
    String FROM_ACTIVITY_SUBMIT = "FROM_ACTIVITY_SUBMIT";
    String RECEIPT_STATUS = "RECEIPT_STATUS";
    String PENDING_CHALLAN_OFFLINE_SERVICE = "PENDING_CHALLAN_OFFLINE_SERVICE";
    String IS_PENDING_CHALLAN_AVAILABLE = "IS_PENDING_CHALLAN_AVAILABLE";

    String PRINTER_DATA = "PRINTER_DATA";
    String PRINTER_IMAGE = "PRINTER_IMAGE";
    String _DRAFT = "_DRAFT";
    String JSONDATA = "JSONData";
    String TXT = ".txt";
    String _ECHALLAN = ".echallan";
    String _ECHALLAN_ARCHIVE = ".echallanENC";
    String ARCHIVE_PATH = "ARCHIVE_PATH";
    String ARCHIVE_NAME = "ARCHIVE_NAME";
    String NO_OF_CHALLANS = "NO_OF_CHALLANS";
    String _ZIP = ".zip";
    String CHALLAN_BACKUP_PATH = "BACKUP";
    String CHALLAN_ROOT_PATH = "/EChallan/";
    String CHALLAN_ROOT_PATH_1 = "EChallan";
    String CHALLAN_ARCHIVES_PATH = "ARCHIVES";
    String APK_PATH = "APK";
    String IMAGES = "IMAGES";
    String PNG = ".png";

    String APK_NAME = "EChallan.apk";

    // State Code
    String UP = "UP";
    String DL = "DL";
    String PB = "PB";
    String CH = "CH";
    String TN = "TN";
    String ML = "ML";
    String RJ = "RJ";
    String GJ = "GJ";
    String GA = "GA";
    String OR = "OR";

    String PDF = "PDF";
    String RULES = "RULES";
    String FONTS = "FONTS";

    String VIDEO_URL = "VIDEO_URL";
    String SERVICE_SYNC_STATUS = "SERVICE_SYNC_STATUS";

    String CASH = "Cash";

    String CHALLAN_UPLOAD_SERVICE_RECEIVED = "CHALLAN_UPLOAD_SERVICE_RECEIVED";
    String LATITUDE = "LATITUDE";
    String LONGITUDE = "LONGITUDE";
    String LOCATION = "LOCATION";

    String MOSAMBEE_PRINTER_SERVICE_ID = "com.mosambee.printService";
    String MOSAMBEE_PRINTER_SERVICE_CLASS = "com.mosambee.printService.PrinterService";
    String FILE_TYPE_PDF = "application/pdf";
    String RULES_PDF = "Vehcile_Act_1988.pdf";
    String QR_CONTENT = "QR_CONTENT";

    // Payment Mode
    String PAYMENT_PENDING = "Payment Pending";
    String PAYMENT_CASH = "Cash";
    String PAYMENT_CARD = "Card";
    String PAYMENT_PAYTM = "Paytm";

    String PAYMENT_UPI = "upi";
    String PAYMENT_WALLET = "wallet";
    String PAYMENT_CHEQUE = "Cheque";
    String PAYMENT_REMOTE_PAY = "Remote Pay";
    String PAYMENT_QR_CODE = "QR Pay";


    String TRANSACTION_TYPE = "sale";
    String RECEIPT_NO = "RECEIPT_NO";

    String WEIPASS_MODEL = "WEIPASS";

    String TPS900_MODEL = "TPS900";

    String NEXGO_MODEL = "N5";
    String PAX_MODLE = "PAX";

    String AES_ECHALLAN_MPARIVAHAN = "E@CHALLAN*#2016!";
    String USER_NAME = "USER_NAME";
    String EMAIL = "EMAIL";
    String USER_TYPE = "USER_TYPE";
    String ROLE = "ROLE";
    String STATE = "STATE";
    String RTO = "RTO";

    String PRINTER_NAME = "PRINTER_NAME";
    String TARGET = "TARGET";
    String MAC_ADDRESS = "MAC_ADDRESS";
    String DEFAULT_MAC_ADDRESS = "00:00:00:00:00:00";

    String UTF_ENCODING = "UTF-8";
    String NEW_CHALLAN = "new_challan";
    String ACTIVE_USER_INPUT = "ACTIVE_USER_INPUT";
    String USER_TRACKER_DETAILS = "USER_TRACKER_DETAILS";

    String MEDIA_TYPE = "MEDIA_TYPE";
    String ENCODED_IMAGE = "ENCODED_IMAGE";
    String VIDEO_PATH = "VIDEO_PATH";
    String RECEIPT_NUMBER = "receiptNo";

    String DN = "DN";
    String ENGLISH = "eng";
    String HINDI = "hi";

    String STATUS = "STATUS";
    String STATUS_TITLE = "STATUS_TITLE";
    String STATUS_MSG = "STATUS_MSG";
    String REQUEST_FROM = "REQUEST_FROM";
    String SERVER_REQUEST = "SERVER_REQUEST";
    String OFFLINE_REQUEST = "OFFLINE_REQUEST";
    String TIMESTAMP_FORMAT = "yyyyMMddHHmmss";
    String TIMESTAMP_FORMAT_1 = "yyMMddhhmmss";
    String TIMESTAMP_FORMAT_2 = "yyMMddHHmmss";
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    String DATE_TIME_FORMAT_FULL = "E, dd MMM yyyy hh:mm:ss zzz";
    String DATE_TIME_FORMAT_1 = "dd-MM-yyyy HH:mm:ss";
    String DATE_TIME_FORMAT_2 = "yyyy-MM-dd hh:mm:ss";
    String DATE_FORMAT = "MMM dd, yyyy";
    String DATE_FORMAT_1 = "dd-MM-yyyy";
    String DATE_FORMAT_11 = "dd-MMM-yyyy";
    String DATE_FORMAT_12 = "MMM dd, yyyy hh:mm a";
    /////////////////////////// TPS900 /////////////////////////////
    String DATE_FORMAT_2 = "yyyy-MM-dd";
    String TIME_LONG_FORMAT = "hh:mm:ss a";
    String TIME_SHORT_FORMAT = "hh:mm a";
    String DATE_SHORT_FORMAT_1 = "MM-yyyy";
    String DATE_SHORT_FORMAT_2 = "MMM yyyy";
    String DATE_SHORT_FORMAT_3 = "MMMM yyyy";
    String DATE_SHORT_FORMAT_4 = "yyyyMMdd";
    String DATE_SHORT_FORMAT_5 = "yyyy_MM_dd";
    String DATE_SHORT_FORMAT_6 = "yyyy_MM";

    ///Tax payment
    String DATE_SHORT_FORMAT_7 = "dd";
    String DATE_SHORT_FORMAT_8 = "MM";
    String STATUS_CHECK = "STATUS_CHECK";

    //added new constant by avanish
    String SEAT = "SEAT";
    String OVERLOADING = "OVERLOADING";
    String TIME = "TIME";
    String DRINK_AND_DRIVE = "DRINK AND DRIVE";
    String OVERSPEED = "OVERSPEED";
    String SEIZE = "SEIZE";
    String CUSTOM_OFFENCE = "CUSTOM_OFFENCE";
    String ENTRY_TAX = "ENTRY_TAX";
    String GMVCC_TAX = "GMVCC_TAX";
    String OMVT = "OMVT";

}
