package com.company;

/**
 * Created by ivan on 19.03.2016.
 */
public class SearchContact {
    public static void searchByValueMenu() {

        while (true) {
            System.out.println("Choose search option:");
            System.out.println("1 for Search by ID");
            System.out.println("2 for Search by name");
            System.out.println("3 for Search by number");
            System.out.println("4 for Search by date");
            System.out.println("0 exit");
            System.out.println();
            int searchOption = Integer.valueOf((InputChecker.returnValidIntFromScanner()));
            switch (searchOption) {
                case 0:
                    return;
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
            number = Integer.valueOf(InputChecker.returnValidStringFromScanner());

            for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
                if (ContactBook.arrayOfContacts[number] != null && (number == i)) {
                    PrintServicesForContactBook.printString(ContactBook.arrayOfContacts[i], i);
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
            System.out.println("Enter Name please (enter -1 for exit):");
            number = InputChecker.returnValidStringFromScanner();

            int r = 0;

            for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
                if (ContactBook.arrayOfContacts[i] != null && number.equals(ContactBook.arrayOfContacts[i].getName())) {
                    PrintServicesForContactBook.printString(ContactBook.arrayOfContacts[i], i);
                    r++;
                } else if (number.equals("-1")) {
                    return;
                } else if (r == 0) {
                    System.out.println("Not found, sorry");
                    return;
                }
            }
        }
    }

    public static void findContactNumber() {

        String number;

        while (true) {
            System.out.println("Enter Number please (enter -1 for exit):");
            number = InputChecker.returnValidStringFromScanner();

            int r = 0;

            for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
                if (ContactBook.arrayOfContacts[i] != null && number.equals(ContactBook.arrayOfContacts[i].getNumber())) {
                    PrintServicesForContactBook.printString(ContactBook.arrayOfContacts[i], i);
                    r++;
                } else if (number.equals("-1")) {
                    return;
                } else if (r == 0) {
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
            int uncheckedDay = InputChecker.returnValidIntFromScanner();
            if (uncheckedDay > 0 && uncheckedDay < 32) {
                findThisDay = uncheckedDay;
            } else {
                System.out.println("not valid day");
            }
        }

        System.out.println("month?");

        int findThisMonth = 0;

        while (findThisMonth == 0) {
            int uncheckedMonth = InputChecker.returnValidIntFromScanner();

            if (uncheckedMonth > 0 && uncheckedMonth < 13) {
                findThisMonth = uncheckedMonth;
            } else {
                System.out.println("not valid month");
            }
        }

        System.out.println("year?");

        int findThisYear = 3000;

        while (findThisYear == 3000) {
            int uncheckedYear = InputChecker.returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                findThisYear = uncheckedYear;
            } else {
                System.out.println("not valid month");
            }
        }

        while (true) {
            String findThisDate;
            String dateStringForEquals;


            findThisDate = Contact.dateToString(findThisYear, findThisMonth, findThisDay);

            int r = 0;

            for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
                if (ContactBook.arrayOfContacts[i] != null) {
                    dateStringForEquals = Contact.dateToString(ContactBook.arrayOfContacts[i].getYear(), ContactBook.arrayOfContacts[i].getMonth(), ContactBook.arrayOfContacts[i].getDay());
                    r++;
                    if (findThisDate.equals(dateStringForEquals)) {
                        PrintServicesForContactBook.printString(ContactBook.arrayOfContacts[i], i);
                    } else if (r == 0) {
                        System.out.println("Not found, sorry");
                        return;
                    }
                }
                if (i == ContactBook.arrayOfContacts.length - 1) {
                    return;
                }
            }
        }
    }
}
