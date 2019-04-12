package info.avanish.tools.others;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String PASSWORD_PATTERN_ALPHA_NUMERIC
            = "^" //start-of-string
            + "(?=.*[0-9])"     //a digit must occur at least once
            + "(?=.*[a-z])"     //a lower case letter must occur at least once
            + "(?=.*[A-Z])"     //an upper case letter must occur at least once
            + ".{8,}"           //anything, at least eight places though
            + "$";              //end-of-string


    public static boolean isValidEmail(CharSequence email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

    }

    public static boolean isValidWebSite(CharSequence website) {
        if (TextUtils.isEmpty(website)) {
            return false;
        } else {
            return Patterns.WEB_URL.matcher(website.toString().toLowerCase()).matches();
        }

    }

    public static boolean isValidPhoneNumber(CharSequence phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            if (phoneNumber.toString().contains(" ")
                    || (phoneNumber.charAt(0) == '0')
                    || (!phoneNumber.toString().matches("[0-9]+"))
                    || (phoneNumber.length() <= 5)) {
                return false;
            } else {
                return Patterns.PHONE.matcher(phoneNumber).matches();
            }

        }
        return false;
    }

    public static boolean isValidPhoneNumberOfUAE(CharSequence phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            if (phoneNumber.toString().contains(" ")
                    || (!phoneNumber.toString().matches("[0-9]+"))
                    || (phoneNumber.length() <= 8)) {
                return false;
            } else {
                return Patterns.PHONE.matcher(phoneNumber).matches();
            }

        }
        return false;
    }

    public static boolean isValidPassword(CharSequence password) {

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN_ALPHA_NUMERIC);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();

    }

    public static boolean isValidPassword(CharSequence password, final String PASSWORD_PATTERN) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isMatched(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    /**
     * This is used to check the given URL is valid or not.
     *
     * @param url
     * @return true if url is valid, false otherwise.
     */
    public static boolean isValidUrl(String url) {
        Pattern p = Patterns.WEB_URL;
        Matcher m = p.matcher(url.toLowerCase());
        return m.matches();
    }

    public static boolean isBothPasswordsMatched(String pass1, String pass2) {
        return pass1.equals(pass2);
    }

    public static boolean isValidEmailOrPhoneNumber(String emailOrPhone) {
        if (isValidEmail(emailOrPhone)) {
            return true;
        }
        return isValidPhoneNumber(emailOrPhone);
    }

    public static boolean isValidOtp(String otp) {
        if (TextUtils.isEmpty(otp)) {
            return false;
        }
        if (otp.length() != 4) {
            return false;
        }
        return hasDigitsOnly(otp);

    }

    public static boolean hasDigitsOnly(String str) {
        if (str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();

    }

    public static boolean isNonZeroPositiveFloat(String valStr) {
        if (TextUtils.isEmpty(valStr)) {
            return false;
        }
        try {
            float fVal = Float.parseFloat(valStr);
            if (fVal > 0) {
                return true;
            } else {
                return false;
            }

        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return false;
        }
    }

    public static boolean isNonZeroPositiveInt(String valStr) {
        if (TextUtils.isEmpty(valStr)) {
            return false;
        }
        try {
            float intVal = Integer.parseInt(valStr);
            if (intVal > 0) {
                return true;
            } else {
                return false;
            }

        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return false;
        }
    }


    public static boolean isStringEmpty(String str) {

        if (str == null)
            return true;

        return str == null
                || str.equals("null") || str.equals("") || (str.trim().length() == 0);
    }

    public static boolean isEditTextEmpty(EditText editText) {
        String str = editText.getText().toString();

        if (str == null)
            return true;

        return str == null
                || str.equals("null") || str.equals("") || (str.trim().length() == 0);
    }


}