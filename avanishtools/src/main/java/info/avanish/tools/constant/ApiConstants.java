package info.avanish.tools.constant;

/**
 * Created by avanish .
 */

public interface ApiConstants {

    boolean STATUS_SUCCESS = false;

    // Tokbox api key
    String API_KEY = "46213072";

    String PHONE_TYPE = "a";

    String _USER = "U";
    String _SERVICE_PROVIDER = "M";

    int STATUS_REQUEST_SESSION_EXPIRE = 203;
    int STATUS_REQUEST_NOT_AVAILABLE = 404;
    int STATUS_REQUEST_BROKEN = 500;
    int PICK_IMAGE_REQUEST = 1010;

    String HOST_NAME ="http://www.nic.in";  //lab server url
    String BASE_URL = HOST_NAME+ "/api/";

    String IMAGE_BASE_URL = "http://www.nic.in/uploads/app/public/";

    /*---------------------------------Request url--------------------------*/
    String URL_POST_LOGIN=BASE_URL+"login";
    String URL_POST_SOCIAL_LOGIN=BASE_URL+"social_login";
    String URL_POST_GENERATE_OTP=BASE_URL+"otp";
    String URL_POST_REGISTRATION=BASE_URL+"register";
    String URL_POST_UPDATE_PROFILE= BASE_URL+"update_profile";
    String URL_POST_PROFILE = BASE_URL + "profile";
    String URL_POST_LOGOUT = BASE_URL + "logout";
    String URL_POST_BOOKINGS = BASE_URL + "bookings";

    String URL_POST_FAQS = BASE_URL + "faqs";


    String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

}