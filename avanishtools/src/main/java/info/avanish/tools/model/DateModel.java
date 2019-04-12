package info.avanish.tools.model;


/**
 * Created by avanish on 12.12.2018.
 *
 */
public class DateModel {

    private int year;
    private int month;
    private int day;
    private long bookingTime;

    public DateModel() {

    }

    public DateModel(String year, String month, String day,long bookingTime) {
        this.year = Integer.parseInt(year);
        this.month = Integer.parseInt(month);
        this.day = Integer.parseInt(day);
        this.bookingTime = bookingTime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(long bookingTime) {
        this.bookingTime = bookingTime;
    }
}
