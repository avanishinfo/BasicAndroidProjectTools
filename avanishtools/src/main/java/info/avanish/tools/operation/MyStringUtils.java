package info.avanish.tools.operation;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import info.avanish.tools.constant.ValueConstants;


/**
 * Created by Avanish Singh on 30/04/18.
 */

public class MyStringUtils {
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

    public static String sinceDateString(Date date) {
        return String.format("Since %s", MyDateUtils.formatDate(date, ValueConstants.SINCE_DATE_FORMAT));
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
