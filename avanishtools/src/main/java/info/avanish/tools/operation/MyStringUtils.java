package info.avanish.tools.operation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by Avanish Singh on 30/04/18.
 */

public class MyStringUtils {

    public static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    public static String parseDate(String timestamp, String sourceFormat, String targetFormat) {
        try {
            return new SimpleDateFormat(targetFormat).format(new SimpleDateFormat(sourceFormat).parse(timestamp));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    public static String getStateCode(String regNo) {
        try {
            return regNo.substring(0, Math.min(regNo.length(), 2));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getEncodedString(String path) {
        Log.v("Path", path);
        if (path != null && path.length() > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 3;
            Bitmap bitmap = BitmapFactory.decodeFile(path,
                    options);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Bitmap result = Bitmap.createScaledBitmap(bitmap, 300, 350, false);
            result.compress(Bitmap.CompressFormat.JPEG, 95, stream);
            byte[] byteArray = stream.toByteArray();
            return Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
        return "";
    }

    public static String getEncodedString(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Bitmap result = Bitmap.createScaledBitmap(bitmap, 300, 350, false);
            result.compress(Bitmap.CompressFormat.PNG, 95, stream);
            byte[] byteArray = stream.toByteArray();
            return Base64.encodeToString(byteArray, Base64.DEFAULT);
        }
        return null;
    }

    public static Bitmap decodeBase64Bitmap(String encodedImage) {
        try {
            byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String removeLastChar(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, s.length() - 1);
    }

    public static String formatSleepTimeInHourMinute(long totalSleepInMilli) {
        return formatSleepTimeInHourMinute(totalSleepInMilli, "hrs", "min");

    }

    public static String formatSleepTimeInHourMinute(long totalSleepInMilli,
                                                     String hourUnit, String minuteUnit) {

        long hours = TimeUnit.MILLISECONDS.toHours(totalSleepInMilli);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(totalSleepInMilli) % TimeUnit.HOURS.toMinutes(1);

        if ((hours == 0 && minutes == 0) || (hours != 0 && minutes == 0)) {
            if (hourUnit != null) {
                return String.format("%d %s", hours, hourUnit);
            }
            return String.format("%d hrs", hours);

        } else if (hours == 0 && minutes != 0) {
            if (minuteUnit != null) {
                return String.format("%d %s", minuteUnit);
            }
            return String.format("%d min", minutes);
        } else {
            if (hourUnit != null && minuteUnit != null) {
                return String.format("%d %s %d %s", hours, hourUnit, minutes, minuteUnit);

            }
            return String.format("%d hrs %d min", hours, minutes);

        }


    }

    public static SpannableString formatSleepTimeInSpannableHourMinute(long totalSleepInMilli) {
        String inputStr = formatSleepTimeInHourMinute(totalSleepInMilli);
        SpannableString spannableString = new SpannableString(inputStr);

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#727272")),
                inputStr.indexOf("hrs"), inputStr.indexOf("hrs") + 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

    public static String sinceDateString(Date date,String SINCE_DATE_FORMAT) {
        return String.format("Since %s", MyDateUtils.formatDate(date, SINCE_DATE_FORMAT));
    }

    public static String capitalizeFirstChar(String word) {

        if (word == null || word.length() == 0) {
            return "";
        }

        return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);

    }

    public static String capitalizeSentence(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" +");

        for (int i = 0; i < words.length; i++) {
            if (i > 0){
               sb.append(" ");
            }
            sb.append(capitalizeFirstChar(words[i]));
        }


        return sb.toString();
    }

    public static boolean isStringEmpty(String str) {

        if (str == null)
            return true;

        return str == null
                || str.equals("null") || str.equals("") || (str.trim().length() == 0);
    }
}
