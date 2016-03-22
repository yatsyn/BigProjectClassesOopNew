package com.company;

/**
 * Created by ivan on 19.03.2016.
 */
public class RemoeAccount {
    public static void removeContact() {
        System.out.printf("%s:\n", "Enter contact number for delete: ");
        int delNum = Integer.valueOf(InputChecker.returnValidIntFromScanner());
        int delId = delNum - 1;

        if (ContactBook.arrayOfContacts[delId] != null) {
            ContactBook.arrayOfContacts[delId] = null;
        } else {
            System.out.println("Invalid number");
        }

    }
}
