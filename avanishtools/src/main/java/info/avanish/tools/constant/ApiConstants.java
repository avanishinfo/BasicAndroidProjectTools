package info.avanish.tools.constant;

/**
 * Created by avanish .
 */

public interface ApiConstants {

    boolean STATUS_SUCCESS = false;

    String PHONE_TYPE = "a";

    String _USER = "U";
    String _SERVICE_PROVIDER = "M";

    int STATUS_REQUEST_SESSION_EXPIRE = 203;
    int STATUS_REQUEST_NOT_AVAILABLE = 404;
    int STATUS_REQUEST_BROKEN = 500;
    int PICK_IMAGE_REQUEST = 1010;

    //String HOST_NAME ="https://echallan.parivahan.gov.in";  //Live server url
    //String HOST_NAME ="http://164.100.78.54/echallan";  //staging server url
    String HOST_NAME ="http://164.100.78.54/echallan-all-india";  //staging server url
    //String HOST_NAME ="http://10.173.51.191/echallanstaging";  //local lab server url
    String BASE_URL = HOST_NAME+ "/api/";

    String IMAGE_BASE_URL = HOST_NAME + "/uploads/app/public/";

    String API_ADDRESS  = "https://maps.googleapis.com/maps/api/geocode/json?latlng=";
    String API_KEY_MAP = "AIzaSyCJuyc0lXfhwWuvZx39glGifDql63aTaSI";

    //This is my personal api
    String AVANISH_API_KEY_MAP = "AIzaSyAAa-R3D95rN6vG8Brk5ysnT22tiXjlhEw";

    String CLIENT_KEY = "Mp5SkVtvFH0m7J62rUBsjaXzIXFUOIGW";

    /*---------------------------------Request url--------------------------*/
    String URL_POST_LOGIN=BASE_URL+"login";
    String URL_POST_VALIDATE_OFFICER=BASE_URL+"validate-officer";
    String URL_POST_SOCIAL_LOGIN=BASE_URL+"social_login";
    String URL_POST_GENERATE_OTP=BASE_URL+"otp";
    String URL_POST_REGISTRATION=BASE_URL+"register";
    String URL_POST_FORGOT_PASSWORD= BASE_URL+"forget-password";
    String URL_POST_UPDATE_PASSWORD= BASE_URL+"update-password";
    String URL_POST_UPDATE_PROFILE= BASE_URL+"update_profile";
    String URL_POST_USER_FEEDBACK= BASE_URL+"user-feedback";
    String URL_POST_SEARCH_CHALLAN= BASE_URL+"search-challan";
    String URL_POST_OFFENCE_HISTORY= BASE_URL+"get-rc-offence-info-test";
    String URL_POST_NOTIFICATION= BASE_URL+"get-notifications";
    String URL_POST_DEVICE_DIGNOSIS= BASE_URL+"submit-diagnosis-report";
    String URL_POST_SUBMIT_LOG= BASE_URL+"submit-log";
    String URL_POST_CHALLAN_INVESTIGATION_PATH= BASE_URL+"get-challan-details";
    String URL_POST_SUBMIT_INVESTIGATION_PATH= BASE_URL+"approve-offences";

    String URL_POST_PROFILE = BASE_URL + "profile";
    String URL_POST_LOGOUT = BASE_URL + "logout";
    String URL_POST_BOOKINGS = BASE_URL + "bookings";
    String URL_POST_CHANGE_LOG = BASE_URL+"get-app-change-log";

    String URL_POST_CHECK_DEVICE_STATUS = BASE_URL+"check-device-status";

    String URL_POST_OFFENCE_DETAILS_LIST = BASE_URL+"get-offences-list";
    String URL_POST_VEHICLE_CLASS_CLASS = BASE_URL+"get-vehicle-class";
    String URL_POST_DOC_TYPE = BASE_URL+"get-document-type";
    String URL_POST_MY_ASSIGNMENT = BASE_URL+"my-assignments";
    String URL_POST_ROAD_MASTER_DATA = BASE_URL+"get-road-data";

    // FIXME: 04-07-2019 need to add live
    String URL_POST_RC_OFFENCE_INFO_TEST = BASE_URL+"get-rc-offence-info-test";
    String URL_POST_DL_OFFENCE_INFO = BASE_URL+"get-dl-offence-info";

    String URL_POST_FAQS = BASE_URL + "faqs";

    String URL_GOOGLE_GET_FOR_TIME = "https://google.com/";

    String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

}