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

    public static void printAllContacts() {

        for (int i = 0; i < contactBook.length; i++) {
            if (contactBook[i] != null) {
                System.out.printf("%d\t%s\t%s\t%s\n", i+1, contactBook[i].getName(), contactBook[i].getNumber(),
                        contactBook[i].getDateFormated());
            }
        }

    }

    public static void removeContact() {
        System.out.printf("%s:\n", "Enter contact number for delete: ");
        int delNum = Integer.valueOf(Contact.returnValidIntFromScanner());
        int delId = delNum - 1;

        if (contactBook[delId] != null) {
            contactBook[delId] = null;
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


}
