package com.company;

/**
 * Created by ivan on 19.03.2016.
 */
public class PrintServicesForContactBook {
    public static void printAllContacts() {

        for (int i = 0; i < ContactBook.arrayOfContacts.length; i++) {
            if (ContactBook.arrayOfContacts[i] != null) {
                printString(ContactBook.arrayOfContacts[i], i);
            }
        }

    }

    static void printString(Contact contact, int id) {
        System.out.printf("%d\t%s\t%s\t%s\n", id + 1, contact.getName(), ContactBook.arrayOfContacts[id].getNumber(),
                ContactBook.arrayOfContacts[id].getDateFormatted());
    }
}
