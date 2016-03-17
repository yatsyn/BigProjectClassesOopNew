package com.company.contactbook;

import com.company.Main;
import com.company.contact.Contact;

import java.util.Scanner;

/**
 * Created by ivan on 12.03.2016.
 */
public class ContactBook {

    private static Contact[] contactBook = new Contact[Main.MAX];

    public static void addNewContact() {

        int id = findFreeId(contactBook);
        contactBook[id] = Contact.addNewContact();

    }

    /////////////////////////////SEARCH////////////////////////////////

    public static void searchByValueMenu() {

        while (true) {
            System.out.println("Choose search option:");
            System.out.println("1 for Search by ID");
            System.out.println("2 for Search by name");
            System.out.println("3 for Search by number");
            System.out.println("4 for Search by date");
            System.out.println("0 exit");
            System.out.println();
            int searchOption = Integer.valueOf((Contact.returnValidIntFromScanner()));
            switch (searchOption) {
                case 0:
                    break;
                case 1:
                    findContactId();
                    break;
                case 2:
                    findContactName();
                    break;
                case 3:
                    findContactNumber();
                    break;
                case 4:
                    findContactDateOfBirth();
                    break;
                default:
                    System.out.println("wrong point in menu");
                    break;
            }
        }
    }

    public static void findContactId() {

        int number;

        while (true) {
            System.out.println("Enter Number please (enter -1 for exit):");
            number = Integer.valueOf(Contact.returnValidIntFromScanner());

            for (int i = 0; i < contactBook.length; i++) {
                if (contactBook[number] != null && (number == i)) {
                    printString(contactBook[i], i);
                } else if (number == -1) {
                    return;
                } else {
                    System.out.println("Not found, sorry");
                    return;
                }
            }
        }
    }

    public static void findContactName() {

        String number;

        while (true) {
            System.out.println("Enter Number please (enter -1 for exit):");
            number = Contact.returnValidStringFromScanner();

            for (int i = 0; i < contactBook.length; i++) {
                if (contactBook[i] != null && number.equals(contactBook[i].getName())) {
                    printString(contactBook[i], i);
                } else if (number.equals("-1")) {
                    return;
                } else {
                    System.out.println("Not found, sorry");
                    return;
                }
            }
        }
    }

    public static void findContactNumber() {

        String name;

        while (true) {
            System.out.println("Enter Number please (enter -1 for exit):");
            name = Contact.returnValidStringFromScanner();

            for (int i = 0; i < contactBook.length; i++) {
                if (contactBook[i] != null && name.equals(contactBook[i].getName())) {
                    printString(contactBook[i], i);
                } else if (name.equals("-1")) {
                    return;
                } else {
                    System.out.println("Not found, sorry");
                    return;
                }
            }
        }
    }

    public static void findContactDateOfBirth() {

        System.out.println("day?");

        int findThisDay = 0;

        while (findThisDay == 0) {
            int uncheckedDay = Contact.returnValidIntFromScanner();
            if (uncheckedDay > 0 && uncheckedDay < 32) {
                findThisDay = uncheckedDay;
            } else {
                System.out.println("not valid day");
            }
        }

        System.out.println("month?");

        int findThisMonth = 0;

        while (findThisMonth == 0) {
            int uncheckedMonth = Contact.returnValidIntFromScanner();

            if (uncheckedMonth > 0 && uncheckedMonth < 13) {
                findThisMonth = uncheckedMonth;
            } else {
                System.out.println("not valid month");
            }
        }

        System.out.println("year?");

        int findThisYear = 3000;

        while (findThisYear == 3000) {
            int uncheckedYear = Contact.returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                findThisYear = uncheckedYear;
            } else {
                System.out.println("not valid month");
            }
        }

        String findThisDate;

        while (true) {
            findThisDate = Contact.dateToString(findThisYear, findThisMonth, findThisDay);

            for (int i = 0; i < contactBook.length; i++) {
                String dateStringForEquals = Contact.dateToString(contactBook[i].getYear(), contactBook[i].getMonth(), contactBook[i].getDay());
                if (contactBook[i] != null && findThisDate.equals(dateStringForEquals)) {
                    printString(contactBook[i], i);
                } else {
                    System.out.println("Not found, sorry");
                    return;
                }
            }
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////
    public static void printAllContacts() {

        for (int i = 0; i < contactBook.length; i++) {
            if (contactBook[i] != null) {
                printString(contactBook[i], i);
            }
        }

    }

    public static void removeContact() {
        System.out.printf("%s:\n", "Enter contact number for delete: ");
        int delNum = Integer.valueOf(Contact.returnValidIntFromScanner());
        int delId = delNum - 1;

        if (contactBook[delId] != null) {
            contactBook[delId] = null;
        } else {
            System.out.println("Invalid number");
        }

    }

    public static void editContactInBook() {
        System.out.printf("%s:\n", "Enter contact number for delete: ");
        int delNum = Integer.valueOf(Contact.returnValidIntFromScanner());
        int delId = delNum - 1;

        if (contactBook[delId] != null) {
            Contact.editContactInfo(contactBook[delId]);
        }

    }

    public static int findFreeId(Contact[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null)
                return i;
        }
        System.out.println("error");
        return -1;
    }

    /////////////////////////////////////Print///////////////////////

    private static void printString(Contact contact, int id) {
        System.out.printf("%d\t%s\t%s\t%s\n", id + 1, contactBook[id].getName(), contactBook[id].getNumber(),
                contactBook[id].getDateFormated());
    }


}
