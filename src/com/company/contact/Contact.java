package com.company.contact;

import java.util.Scanner;

/**
 * Created by ivan on 12.03.2016.
 */
public class Contact {
    private String name;
    private String number;
    private int day;
    private int month;
    private int year;
    public String dateFormated;

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
        return dateFormated;
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

//    public static Contact addNewContact() {
//
//        System.out.println("Adding new contact");
//        System.out.println("Name?");
//        String name = InputChecker.returnValidStringFromScanner();
//
//        System.out.println("Number?");
//        String number = InputChecker.returnValidStringFromScanner();
//
//        System.out.println("Date of birthday?");
//
//        System.out.println("day?");
//
//        int d = 0;
//
//        while (d == 0) {
//            int uncheckedDay = InputChecker.returnValidIntFromScanner();
//            if (uncheckedDay > 0 && uncheckedDay < 32) {
//                d = uncheckedDay;
//            } else {
//                System.out.println("not valid day");
//            }
//        }
//
//        System.out.println("month?");
//
//        int m = 0;
//
//        while (m == 0) {
//            int uncheckedMonth = returnValidIntFromScanner();
//
//            if (uncheckedMonth > 0 && uncheckedMonth < 13) {
//                m = uncheckedMonth;
//            } else {
//                System.out.println("not valid month");
//            }
//        }
//
//        System.out.println("year?");
//
//        int y = 3000;
//
//        while (y == 3000) {
//            int uncheckedYear = returnValidIntFromScanner();
//
//            if (uncheckedYear < 3000) {
//                y = uncheckedYear;
//            } else {
//                System.out.println("not valid month");
//            }
//        }
//
//        Contact contact = new Contact(name, number, d, m, y);
//
//        return contact;
//
//    }

    /////////////////////////EDIT METHODS/////////////////////////////////////////////





/////////////CHECKERS FOR EMPTY INPUT INFO //////////////////////////////////////////


}
