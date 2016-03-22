package com.company;

import com.company.Main;
import com.company.Contact;

import java.io.*;

/**
 * Created by ivan on 01.03.2016.
 */
public class File implements Serializable {

    public static Contact [] openFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        System.out.println("openFile");
        return (Contact[]) objectInputStream.readObject();
    }

    public static void saveToFile(Contact [] arrayOfContacts, String fileName) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(arrayOfContacts);
        objectOutputStream.close();
        System.out.println("saveToFile");

    }

    public static Contact[] initArrFromFile(String fileName) throws IOException, ClassNotFoundException {
        Contact[] contacts;

        java.io.File fileArray = new java.io.File(fileName);
        if (fileArray.exists()) {
            contacts = openFile(fileName);
            System.out.println("openFile(fileName)");

        } else {
            contacts = new Contact[Main.MAX];
            System.out.println(contacts.length);
            System.out.println("new Contact");
        }
        return contacts;
    }

    public static String bigStringForCsv() {

        String s = "sep=,\n" + "ID" + Main.SEP + "NAMES" + Main.SEP + "NUMBERS" + Main.SEP + "YEAR" + Main.SEP + "MONTH" + Main.SEP + "DAY" + Main.NEW_LINE;

        for (int i = 0; i < Main.MAX; i++) {
            if (ContactBook.arrayOfContacts[i] != null) {
                s += i + Main.SEP + ContactBook.arrayOfContacts[i].getName() + Main.SEP + ContactBook.arrayOfContacts[i].getNumber() + Main.SEP + ContactBook.arrayOfContacts[i].getYear() + Main.SEP + ContactBook.arrayOfContacts[i].getMonth() + Main.SEP + ContactBook.arrayOfContacts[i].getDay() + Main.NEW_LINE;
            }
        }
        return s;
    }
}
