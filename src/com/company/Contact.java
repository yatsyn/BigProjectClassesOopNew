package com.company;

import java.io.Serializable;

/**
 * Created by ivan on 12.03.2016.
 */
public class Contact implements Serializable {
    private String name;
    private String number;
    private int day;
    private int month;
    private int year;

    public Contact(String name, String number, int day, int month, int year) {
        this.name = name;
        this.number = number;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDateFormatted() {
        return dateToString(this.getYear(), this.getMonth(), this.getDay());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    /////////////////////////DATE TO STRING/////////////////////////////////////////

    public static String dateToString(int y, int m, int d) {
        String s = y + "-";
        if (String.valueOf(m).length() == 1) {
            s += "0";
        }
        s += m + "-";
        if (d < 10) {
            s += "0";
        }
        s += d;
        return s;
    }
}
