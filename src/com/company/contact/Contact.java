package com.company.contact;

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
    public String dateForated;

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

    public String getDateForated() {
        return dateForated;
    }

    public void setDateForated(String dateForated) {
        this.dateForated = dateToString(getYear(),getMonth(), getDay());
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

    ////////////////////////////////ADD/////////////////////////////////////////////

    public static Contact addNewContact() {
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

        while (y == 3000) {
            int uncheckedYear = returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                y = uncheckedYear;
            } else {
                System.out.println("not valid month");
            }
        }

        int id = Contact.getId() + 1;
        Contact.setId(id);

        Contact contact = new Contact(name, number, d, m, y);

        return contact;

    }

    /////////////////////////EDIT METHODS/////////////////////////////////////////////

    public static void editContactInfo(Contact contact) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose what data do you need to edit:");

        while (true) {
            System.out.println("1 for edit name");
            System.out.println("2 for edit number");
            System.out.println("3 for edit date of birthday");
            System.out.println("0 for exit");

            int editMenuOption = returnValidIntFromScanner();

            switch (editMenuOption) {
                case 0:
                    return;

                case 1:
                    editName(contact);
                    break;
                case 2:
                    editNumber(contact);
                    break;
                case 3:
                    editDateOfBirthday(contact);
                    break;
            }

        }
    }

    private static void editName(Contact contact) {
        System.out.println("New name?");
        contact.setName(returnValidStringFromScanner());
        System.out.println("done");
    }

    private static void editNumber(Contact contact) {
        System.out.println("New number?");
        contact.setNumber(returnValidStringFromScanner());
        System.out.println("done");
    }

    private static void editDateOfBirthday (Contact contact)    {

        System.out.println("Date of birthday?");

        System.out.println("day?");

        while (true) {
            int uncheckedDay = returnValidIntFromScanner();
            if (uncheckedDay > 0 && uncheckedDay < 32) {
                int checkedDay = uncheckedDay;
                contact.setDay(checkedDay);
                System.out.println("done");
                break;
            } else {
                System.out.println("not valid day");
            }
        }

        System.out.println("month?");

        while (true) {
            int uncheckedMonth = returnValidIntFromScanner();

            if (uncheckedMonth > 0 && uncheckedMonth < 13) {
                int checkedMonth = uncheckedMonth;
                contact.setMonth(checkedMonth);
                System.out.println("done");
                break;
            } else {
                System.out.println("not valid month");
            }
        }

        System.out.println("year?");

        while (true) {
            int uncheckedYear = returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                int checkedyear = uncheckedYear;
                contact.setYear(checkedyear);
            } else {
                System.out.println("not valid month");
            }
        }

    }

    /////////////////////REMOVE METHOD//////////////////////////////////////////////////

    public static void removeAccount (Contact contact)  {
        contact = null;
    }

    /////////////CHECKERS FOR EMPTY INPUT INFO //////////////////////////////////////////

    public static boolean isStringEmpty(String s) {
        return s == "null" || "".equals(s);
    }

    public static int returnValidIntFromScanner() {
        Scanner scanner = new Scanner(System.in);

        String tempInt;
        while (isStringEmpty(tempInt = scanner.nextLine())) {
            System.out.println("empty value");
        }

        return Integer.valueOf(tempInt);
    }

    public static String returnValidStringFromScanner() {
        Scanner scanner = new Scanner(System.in);

        String tempString;
        while (isStringEmpty(tempString = scanner.nextLine())) {
            System.out.println("empty value");
        }

        return tempString;
    }
}
