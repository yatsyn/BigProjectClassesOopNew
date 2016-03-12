package com.company;

import com.company.contact.Contact;
import com.company.contactbook.ContactBook;

import java.io.*;

public class Main {

    public static int MAX = 1000;
    public static final String FILE_ID = "File.i";
    public static final String FILE_NAMES = "File.name";
    public static final String FILE_NUMBERS = "File.numbers";
    public static final String FILE_YEAR = "File.y";
    public static final String FILE_MONTH = "File.m";
    public static final String FILE_DAY = "File.d";
    public static final String NEW_LINE = "\r\n";
    public static final String SEP = ",";
    public static final String FILE_CSV = "File.csv";


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while (true) {
            System.out.println("1 for adding");
            System.out.println("2 for Search");
            System.out.println("3 Print all");
            System.out.println("4 Print sorted menu");
            System.out.println("5 for delete");
            System.out.println("6 Edit menu");
            System.out.println("7 sort by date of birthday");
            System.out.println("8 export to exel File");
            System.out.println("9 for test account");
            System.out.println("0 exit");
            System.out.println();

            int menu = Contact.returnValidIntFromScanner();

            switch (menu) {
                case 0:
                    //com.company.files.File.saveToFile(idents, FILE_ID);
                    return;
                case 1:
                    ContactBook.addNewContact();
                    break;
                case 2:
                    //search
                    break;
                case 3:
                    ContactBook.printAllContacts();
                    break;
                case 4:
                    //print sorted by name
                    break;
                case 5:
                    //  remove contact
                    break;
                case 6:
                    //edit contact
                    break;
                case 7:
                    //print sorted by date
                    break;
                case 8:
                    //save to file
                    //FileUtils.writeStringToFile(new java.io.File(FILE_CSV), com.company.files.File.bigStringForCsv(idents, names, numbers, day, month, year));
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
