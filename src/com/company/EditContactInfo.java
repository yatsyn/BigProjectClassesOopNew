package com.company;

import java.util.Scanner;

/**
 * Created by ivan on 19.03.2016.
 */
public class EditContactInfo {
    public static void editContactInfo(Contact contact) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose what data do you need to edit:");

        while (true) {
            System.out.println("1 for edit name");
            System.out.println("2 for edit number");
            System.out.println("3 for edit date of birthday");
            System.out.println("0 for exit");

            int editMenuOption = InputChecker.returnValidIntFromScanner();

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
        contact.setName(InputChecker.returnValidStringFromScanner());
        System.out.println("done");
    }

    private static void editNumber(Contact contact) {
        System.out.println("New number?");
        contact.setNumber(InputChecker.returnValidStringFromScanner());
        System.out.println("done");
    }

    private static void editDateOfBirthday (Contact contact)    {

        System.out.println("Date of birthday?");

        System.out.println("day?");

        while (true) {
            int uncheckedDay = InputChecker.returnValidIntFromScanner();
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
            int uncheckedMonth = InputChecker.returnValidIntFromScanner();

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
            int uncheckedYear = InputChecker.returnValidIntFromScanner();

            if (uncheckedYear < 3000) {
                int checkedyear = uncheckedYear;
                contact.setYear(checkedyear);
            } else {
                System.out.println("not valid month");
            }
        }

    }

}
