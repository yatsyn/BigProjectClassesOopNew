package com.company;

/**
 * Created by ivan on 19.03.2016.
 */
public class EditContactsInBook {
    public static void editContactInBook() {
        System.out.printf("%s:\n", "Enter contact number for delete: ");
        int editNum = Integer.valueOf(InputChecker.returnValidIntFromScanner());
        int editId = editNum - 1;

        if (ContactBook.arrayOfContacts[editId] != null) {
            EditContactInfo.editContactInfo(ContactBook.arrayOfContacts[editId]);
        }

    }
}
