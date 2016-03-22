package com.company;

import java.io.IOException;
import java.io.Serializable;

import static com.company.File.initArrFromFile;

/**
 * Created by ivan on 20.03.2016.
 */
public class ContactBook implements Serializable {

        public static Contact[] arrayOfContacts;

    public static void createContactBook() throws IOException, ClassNotFoundException {
        arrayOfContacts = initArrFromFile(Main.FILE_CONTACTS);


    }


}
