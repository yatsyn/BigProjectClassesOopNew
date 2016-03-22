package com.company;

import java.util.Arrays;

/**
 * Created by ivan on 19.03.2016.
 */
public class SortContactBook {


    public static void sortByValueMenu() {

        while (true) {
            System.out.println("Choose search option:");
            System.out.println("1 for Sort by name");
            System.out.println("2 for Sort by number");
            System.out.println("3 for Sort by date");
            System.out.println("0 exit");
            System.out.println();
            int searchOption = Integer.valueOf((InputChecker.returnValidIntFromScanner()));
            switch (searchOption) {
                case 0:
                    return;
                case 1:
                    sortByName();
                    break;
                case 2:
                    sortContactNumber();
                    break;
                case 3:
                    sortContactDateOfBirth();
                    break;
                default:
                    System.out.println("wrong point in menu");
                    break;
            }
        }
    }

    public static void sortByName() {

        String[] sortByName = new String[calcContactsInBook()];


        for (int i = 0; i < sortByName.length; i++) {
            sortByName[i] = createArrayForSorting(ContactBook.arrayOfContacts)[i].getName();
        }

        Arrays.sort(sortByName);

        for (int k = 0; k < sortByName.length; k++) {
            for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
                if (ContactBook.arrayOfContacts[i] != null && sortByName[k].equals(ContactBook.arrayOfContacts[i].getName())) {
                   PrintServicesForContactBook.printString(ContactBook.arrayOfContacts[i], i);
                }
            }
        }

    }

    public static void sortContactDateOfBirth() {

        String[] sortByDateOfBirth = new String[calcContactsInBook()];


        for (int i = 0; i < sortByDateOfBirth.length; i++) {

            sortByDateOfBirth[i] = createArrayForSorting(ContactBook.arrayOfContacts)[i].getDateFormatted();
        }

        Arrays.sort(sortByDateOfBirth);

        for (int k = 0; k < sortByDateOfBirth.length; k++) {
            for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
                if (ContactBook.arrayOfContacts[i] != null && sortByDateOfBirth[k].equals(ContactBook.arrayOfContacts[i].getDateFormatted())) {
                    PrintServicesForContactBook.printString(ContactBook.arrayOfContacts[i], i);
                }
            }
        }

    }

    public static void sortContactNumber() {

        String[] sortByNumber = new String[calcContactsInBook()];


        for (int i = 0; i < sortByNumber.length; i++) {
            sortByNumber[i] = createArrayForSorting(ContactBook.arrayOfContacts)[i].getNumber();
        }

        Arrays.sort(sortByNumber);

        for (int k = 0; k < sortByNumber.length; k++) {
            for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
                if (ContactBook.arrayOfContacts[i] != null && sortByNumber[k].equals(ContactBook.arrayOfContacts[i].getNumber())) {
                    PrintServicesForContactBook.printString(ContactBook.arrayOfContacts[i], i);
                }
            }
        }

    }

    public static Contact[] createArrayForSorting(Contact[] arrayForSorting) {

        int n = 0;
        for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {

            if (ContactBook.arrayOfContacts[i] != null) {
                arrayForSorting[n] = new Contact(ContactBook.arrayOfContacts[i].getName(), ContactBook.arrayOfContacts[i].getNumber(),
                        ContactBook.arrayOfContacts[i].getDay(), ContactBook.arrayOfContacts[i].getMonth(), ContactBook.arrayOfContacts[i].getYear());
                n++;
            }
        }
        return arrayForSorting;

    }

    public static int calcContactsInBook() {
        int j = 0;
        for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
            if (ContactBook.arrayOfContacts[i] != null) {
                j++;
            }
        }
        return j;
    }
}

