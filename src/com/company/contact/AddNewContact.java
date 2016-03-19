package com.company.contact;

/**
 * Created by ivan on 19.03.2016.
 */
public  class AddNewContact {
    public static Contact addNewContact() {

        System.out.println("Adding new contact");
        System.out.println("Name?");
        String name = InputChecker.returnValidStringFromScanner();

        System.out.println("Number?");
        String number = InputChecker.returnValidStringFromScanner();

        System.out.println("Date of birthday?");

        System.out.println("day?");

        int d = 0;

        while (d == 0) {
            int uncheckedDay = InputChecker.returnValidIntFromScanner();
            if (uncheckedDay > 0 && uncheckedDay < 32) {
                d = uncheckedDay;
            } else {
                System.out.println("not valid day");
            }
        }

        System.out.println("month?");

        int m = 0;

        while (m == 0) {
            int uncheckedMonth = InputChecker.returnValidIntFromScanner();

            if (uncheckedMonth > 0 && uncheckedMonth < 13) {
                m = uncheckedMonth;
            } else {
                System.out.println("not valid month");
            }
        }

        System.out.println("year?");

        int y = 3000;

        while (y == 3000) {
            int uncheckedYear = InputChecker.returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                y = uncheckedYear;
            } else {
                System.out.println("not valid month");
            }
        }

        Contact contact = new Contact(name, number, d, m, y);

        return contact;

    }


}
