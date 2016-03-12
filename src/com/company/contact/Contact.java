package com.company.contact;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by ivan on 12.03.2016.
 */
public class Contact {
    private static int id = 0;
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

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Contact.id = id;
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

    public static Contact addNewContact () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adding new contact");
        System.out.println("Name?");
        String name = returnValidStringFromScanner();

        System.out.println("Number?");
        String number = returnValidStringFromScanner();

        System.out.println("Date of birthday?");

        System.out.println("day?");

        int d = 0;

        while (d == 0) {
            int uncheckedDay = returnValidIntFromScanner();
            if (uncheckedDay > 0 && uncheckedDay < 32) {
                d = uncheckedDay;
            } else {
                System.out.println("not valid day");
            }
        }

        System.out.println("month?");

        int m = 0;

        while (m == 0) {
            int uncheckedMonth = returnValidIntFromScanner();

            if (uncheckedMonth > 0 && uncheckedMonth < 13) {
                m = uncheckedMonth;
            } else {
                System.out.println("not valid month");
            }
        }

        System.out.println("year?");

        int y = 3000;

        while (y == 3000)   {
            int uncheckedYear = returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                y = uncheckedYear;
            } else {
                System.out.println("not valid month");
            }
        }

        int id = Contact.getId()+1;
        Contact.setId(id);

        Contact contact = new Contact(name, number, d, m, y);

        return contact;

    }

    public static boolean isStringEmpty (String s)  {
        return s=="null" || "".equals(s);
    }

    public static int returnValidIntFromScanner ()  {
        Scanner scanner = new Scanner(System.in);

        String tempInt;
        while (isStringEmpty(tempInt = scanner.nextLine()))   {
            System.out.println("empty value");
        }

        return Integer.valueOf(tempInt);
    }

    public static String returnValidStringFromScanner ()  {
        Scanner scanner = new Scanner(System.in);

        String tempString;
        while (isStringEmpty(tempString = scanner.nextLine()))   {
            System.out.println("empty value");
        }

        return tempString;
    }
}
