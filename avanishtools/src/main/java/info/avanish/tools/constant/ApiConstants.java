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

    String HOST_NAME ="http://www.jeem.ae";  //lab server url
    String BASE_URL = HOST_NAME+ "/api/";

    String IMAGE_BASE_URL = "http://www.jeem.ae/uploads/app/public/";

    /*---------------------------------Request url--------------------------*/
    String URL_POST_LOGIN=BASE_URL+"login";
    String URL_POST_SOCIAL_LOGIN=BASE_URL+"social_login";
    String URL_POST_GENERATE_OTP=BASE_URL+"otp";
    String URL_POST_REGISTRATION=BASE_URL+"register";
    String URL_POST_UPDATE_PROFILE= BASE_URL+"update_profile";
    String URL_POST_PROFILE = BASE_URL + "profile";
    String URL_POST_LOGOUT = BASE_URL + "logout";
    String URL_POST_BOOKINGS = BASE_URL + "bookings";

    String URL_POST_CCAVENUE_ = BASE_URL + "get-rsa-key";
    String URL_POST_CCAVENUE_RESPONSE_HANDLER = BASE_URL + "ccav-response-handler";
    String URL_POST_ADD_WORK_TIMES_ = BASE_URL + "add-work-times";
    String URL_POST_GET_WORK_TIMES = BASE_URL + "get-work-times";
    String URL_POST_ARTISTS_SEARCH = BASE_URL + "artists_search";
    String URL_POST_GET_ARTIST_SLOT = BASE_URL + "get-artist-slot";
    String URL_POST_WORK_TIMES = BASE_URL + "work_times";
    String URL_POST_AVAILABILITY_WORK_TIMES = BASE_URL + "availability_work_times";
    String URL_POST_UNAVAILABLITITY_WORK_TIMES = BASE_URL + "unavailability_work_times";
    String URL_POST_MANAGE_SEARVICES = BASE_URL + "manage_services";
    String URL_POST_ADD_BOOKING = BASE_URL + "add_booking";
    String URL_POST_ADDRESS = BASE_URL + "address";
    String URL_POST_PRIMARY_ADDRESS = BASE_URL + "primary_address";
    String URL_POST_VERIFY_OTP = BASE_URL + "verify_otp";
    String URL_POST_ADDRESS_LIST = BASE_URL + "address_list";
    String URL_POST_SERVICE_AREA_LIST = BASE_URL + "service_area_list";
    String URL_POST_SEARVICE_AREA_DELETE = BASE_URL + "service_area_delete";
    String URL_POST_SEARVICE_LIST = BASE_URL + "services_list";
    String URL_POST_SERVICES_TEMPLATE = BASE_URL + "services_template";
    String URL_POST_ARTIST_SERVICES = BASE_URL + "artist_services";
    String URL_POST_BOOKING_DETIALS = BASE_URL + "booking_details";
    String URL_POST_MANAGE_BOOKINGS = BASE_URL + "manage_bookings";
    String URL_POST_BOOKING_CANCEL = BASE_URL + "booking_cancel";
    String URL_POST_MANAGE_GALLERY = BASE_URL + "manage_gallery";
    String URL_POST_CART = BASE_URL + "cart";
    String URL_POST_GALLERY_LIST = BASE_URL + "gallery_list";
    String URL_POST_ADD_GALLERY_IMAGE = BASE_URL + "add_gallery_image";
    String URL_POST_GALLERY_IMAGE_LIST = BASE_URL + "gallery_image_list";
    String URL_POST_GALLRY_IMAGE_DELETE = BASE_URL + "gallery_image_delete";
    String URL_POST_REPORT_A_PROBLEM = BASE_URL + "report-a-problem";
    String URL_POST_SERVICE_AREA = BASE_URL + "service_area";
    String URL_POST_MANAGE_AVAILABILITY = BASE_URL + "manage_availability";
    String URL_POST_CHANGE_PASSWORD = BASE_URL + "change_password";
    String URL_POST_MANAGE_ACCOUNT = BASE_URL + "manage_account";
    String URL_POST_RATING_ADN_SERVICE_COMPLETE = BASE_URL + "rating_and_service_complete";
    String URL_POST_GET_RATING = BASE_URL + "get_rating";
    String URL_POST_USER_ORDER = BASE_URL + "user_order";
    String URL_POST_MANAGE_CART = BASE_URL + "manage_cart";
    String URL_POST_SERVICE_CATEGORY = BASE_URL + "service_category";
    String URL_POST_ARTISTS = BASE_URL + "artists";
    String URL_POST_UPDATE_DEVICE_ID = BASE_URL + "update_device_id";
    String URL_POST_TEST_NOTIFICATION = BASE_URL + "test_notification";
    String URL_POST_NOTIFICATION = BASE_URL + "notifications";
    String URL_POST_NOTIFICATION_COUNT = BASE_URL + "notification-count";
    String URL_POST_FAQS = BASE_URL + "faqs";
    String URL_POST_INVOICE_DETIALS = BASE_URL + "invoice-details";
    String URL_POST_ADD_FAV = BASE_URL + "add-favorite";
    String URL_POST_FAV = BASE_URL + "favorites";
    String URL_POST_MY_EARNINGS = BASE_URL + "my-earnings";
    String URL_POST_FORGOT_PASSWORD = BASE_URL + "forgot-password";
    String URL_POST_CHAT_LIST = BASE_URL + "chat-list";
    String URL_POST_START_CHAT = BASE_URL + "start-chat";
    String URL_POST_SAVE_CHAT = BASE_URL + "save-chat";


    String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
    public static class Config {
        public static final boolean DEVELOPER_MODE = false;
    }

}