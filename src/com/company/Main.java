package com.company;


import org.apache.commons.io.FileUtils;

import java.io.*;

public class Main implements Serializable{

    public static int MAX = 1000;
    public static final String FILE_CONTACTS = "File.contactBook";
    public static final String NEW_LINE = "\r\n";
    public static final String SEP = ",";
    public static final String FILE_CSV = "File.csv";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ContactBook.createContactBook();

        while (true) {
            System.out.println("1 for adding");
            System.out.println("2 for Search");
            System.out.println("3 Print all");
            System.out.println("4 Print sorted menu");
            System.out.println("5 for delete");
            System.out.println("6 Edit menu");
            System.out.println("7 export to exel File");
            System.out.println("0 exit");
            System.out.println();

            int menu = InputChecker.returnValidIntFromScanner();

            switch (menu) {
                case 0:
                    File.saveToFile(ContactBook.arrayOfContacts, FILE_CONTACTS);
                    return;
                case 1:
                    AddNewContact.addNewContact();
                    break;
                case 2:
                    SearchContact.searchByValueMenu();
                    //search
                    break;
                case 3:
                    PrintServicesForContactBook.printAllContacts();
                    break;
                case 4:
                    SortContactBook.sortByValueMenu();
                    break;
                case 5:
                    RemoeAccount.removeContact();
                    //  remove contact
                    break;
                case 6:
                    //edit contact
                    EditContactsInBook.editContactInBook();
                    break;
                case 7:
                    //save to file
                    FileUtils.writeStringToFile(new java.io.File(FILE_CSV), File.bigStringForCsv());
                    break;
                case 9:
                    //add test accounts
                default:
                    //error message for unavailable point in menu
                    //System.out.println("wrong point in menu");
                    break;
            }
        }
    }

}
