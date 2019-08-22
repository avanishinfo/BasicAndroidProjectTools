package info.avanish.tools.operation;

import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


/**
 * Created by Avanish Singh on 19/4/17.
 */

public class MyDateUtils {
    /**
     * Return a date as string in the provided date format.
     * if date format is null defult date format will be dd/MM/yyyy
     *
     * @param year
     * @param month
     * @param day
     * @param dateFormat
     * @return Return a date as string in the provided date format
     */
    public static String formatDate(int year, int month, int day, String dateFormat) {
        SimpleDateFormat simpleDateFormat = null;

        if (dateFormat != null) {
            simpleDateFormat = new SimpleDateFormat(dateFormat);
        } else {
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }

        // create a calendar
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);

        return simpleDateFormat.format(cal.getTime());
    }

    public static String getMonthName(String mPrimaryDate) {
        String month="";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(mPrimaryDate);
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
            month = dateFormat.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return month;
    }

    public static String formatDate(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    public static String formatDate(long timeInMilli, String dateFormat) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMilli);

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(calendar.getTime());
    }

    public static String changeDateFormat(String dateStr, String inputFormat, String outputFormat) {
        Date date = toDate(dateStr, inputFormat);
        return formatDate(date, outputFormat);
    }

    public static String changeTimeFormat(String timeStr, String inputFormat, String outputFormat) {
        Date date = toDate(timeStr, inputFormat);
        return formatDate(date, outputFormat);
    }


    /**
     * Takes day, month, and year and create and return a Date object
     *
     * @param year
     * @param month started from 0
     * @param day
     * @return Date Object
     */
    public static Date toDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return cal.getTime();

    }

    public static Date toDate(String dateStr, String format) {
        if (dateStr == null || format == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Date timeStampToDate(long timeStampInMiltis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStampInMiltis);
        return calendar.getTime();
    }

    public static long toDateInMilliSeconds(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return (cal.getTimeInMillis() / 1000);

    }

    /**
     * Compare two dates without considering time and return true if both dates are same
     *
     * @param date1
     * @param date2
     * @return true if both dates are same
     */

    public static boolean isSameDates(Date date1, Date date2) {

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.setTime(date1);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        calendar2.setTime(date2);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);

        return calendar1.equals(calendar2);

    }

    public static boolean isFutureDates(Date date1, Date date2, String date2Time) {
        Date formattedDate, todayDate;
        String date = new SimpleDateFormat("dd-MM-yyyy").format(date2);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            formattedDate = sdf.parse(date + " " + date2Time);
            todayDate = sdf.parse(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return formattedDate.getTime() >= todayDate.getTime();
    }

    /**
     * @return current date
     */
    public static Date today() {
        return Calendar.getInstance().getTime();
    }

    public static String timeStamp(String TIMESTAMP_FORMAT){
        return new SimpleDateFormat(TIMESTAMP_FORMAT).format(new Date()).trim();
    }
    public static long currentTimeInMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public static long currentDateto30DaysTimeInMillis(){
        Calendar c=new GregorianCalendar();
        c.add(Calendar.DATE, 30);
        //Date d=c.getTime();
        return c.getTimeInMillis();
    }

    public static String getDate(long timeStamp,String DATE_FORMAT_2) {
        try {
            DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_2);
            Date netDate = (new Date(timeStamp * 1000L));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }


    public static String getDateWithMilli(long timeStamp) {
        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }

    public static String getTime(long timeStamp) {

        try {
            DateFormat sdf = new SimpleDateFormat("hh:mm a");
            Date netDate = (new Date(timeStamp * 1000L));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }

    public static String formatTime(String formatStr, int hourOfDay, int minute) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(calendar.getTime());

    }

    public static String formatTimeTo24Hour(int hourOfDay, int minute) {

        return formatTime("HH:mm", hourOfDay, minute);

    }

    public static String formatTimeTo12Hour(int hourOfDay, int minute) {

        return formatTime("hh:mm a", hourOfDay, minute);

    }


    public static List<Date> dateInterval(Date initial, Date finalDate) {
        //initial=new Date(2017,05,28);
        //finalDate=new Date(2017,06,4);
        Calendar finnalcal = Calendar.getInstance();
        finnalcal.setTime(finalDate);
        finnalcal.add(Calendar.DATE, 1);
        finalDate = finnalcal.getTime();

        List<Date> dates = new ArrayList<Date>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initial);

        while (calendar.getTime().before(finalDate)) {
            Date result = calendar.getTime();
            dates.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        Log.e("Dates", dates.toString());
        return dates;
    }

    public static ArrayList<String> stringDateIntervals(Date initial, Date finalDate) {
        //initial=new Date(2017,05,28);
        //finalDate=new Date(2017,06,4);
        Calendar finnalcal = Calendar.getInstance();
        finnalcal.setTime(finalDate);
        finnalcal.add(Calendar.DATE, 1);
        finalDate = finnalcal.getTime();

        ArrayList<String> dates = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initial);

        while (calendar.getTime().before(finalDate)) {
            Date result = calendar.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");
            String newFormat = formatter.format(result);
            dates.add(newFormat);
            calendar.add(Calendar.DATE, 1);
        }
        Log.e("Dates", dates.toString());
        return dates;
    }

    public static String getToDayMM() {
        Date result = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");
        return formatter.format(result);
    }


    public static int compareTime(String time1, String time2, String timeFormat) {
        Date date1 = toDate(time1, timeFormat);
        Date date2 = toDate(time2, timeFormat);
        return date1.compareTo(date2);
    }

    public static Date previousDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }


    public static boolean isTodaysTimeGreater(String date, String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        try {
            Date d = sdf.parse(date + " " + time);
            if (System.currentTimeMillis() > d.getTime()) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static String uniqueName(Context context) {
        if (context == null) {
            return null;
        }

        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());

        return ts;
    }

    public static Date[] lastSevenDaysDates() {
        Calendar calTodayEnd = Calendar.getInstance();
        calTodayEnd.setTime(new Date());
        calTodayEnd.set(Calendar.HOUR_OF_DAY, 24);
        calTodayEnd.set(Calendar.MINUTE, 0);
        calTodayEnd.set(Calendar.SECOND, 0);
        calTodayEnd.set(Calendar.MILLISECOND, 0);

        Date[] dates = new Date[7];

        for (int i = 0; i < 7; i++) {
            calTodayEnd.add(Calendar.DAY_OF_YEAR, -1);
            dates[i] = calTodayEnd.getTime();
        }

        return dates;
    }

    public static String checkRangeAndFindFormattedDate(String mRange, String mIndate_time) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date startDate = null;
        try {
            startDate = df.parse(mIndate_time);
        } catch (ParseException mE) {
            mE.printStackTrace();
        }

        if (mRange.equalsIgnoreCase("week")) {
            DateFormat format2 = new SimpleDateFormat("dd EEE", Locale.ENGLISH);
            String finalDateNDay = format2.format(startDate);
            return String.valueOf(finalDateNDay);

        } else if (mRange.equalsIgnoreCase("month")) {
            DateFormat format2 = new SimpleDateFormat("dd MMM", Locale.ENGLISH);
            String finalDateNDay = format2.format(startDate);
            return String.valueOf(finalDateNDay);
        } else {
            DateFormat format2 = new SimpleDateFormat("dd MMM yy", Locale.ENGLISH);
            String finalDateNDay = format2.format(startDate);
            return String.valueOf(finalDateNDay);
        }
    }

    public static boolean isYesterday(Date date) {
        Calendar c1 = Calendar.getInstance(); // today
        c1.add(Calendar.DAY_OF_YEAR, -1); // yesterday

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date); // your date

        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
    }

    public static boolean isDateInCurrentYear(Date date) {
        if (date == null) return false;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Calendar calCurrentYear = Calendar.getInstance();
        calCurrentYear.setTime(today());
        return calCurrentYear.get(Calendar.YEAR) == cal.get(Calendar.YEAR);
    }

    public static String getDaySuffix(int day) {
        if (!((day > 10) && (day < 19))) {
            switch (day % 10) {
                case 1:
                    return "st";
                case 2:
                    return "nd";
                case 3:
                    return "rd";
                default:
                    return "th";
            }
        }
        return "th";
    }

    public static String getDaySuffix(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //2nd of march 2015
        int day = cal.get(Calendar.DATE);
        return getDaySuffix(day);
    }



    private static String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11) {
            month = months[num];
        }
        return month;
    }
}
