package com.company;

import java.util.Scanner;

/**
 * Created by ivan on 19.03.2016.
 */
public class InputChecker {
    public static boolean isStringEmpty(String s) {
        return s == "null" || "".equals(s);
    }

    public static int returnValidIntFromScanner() {
        Scanner scanner = new Scanner(System.in);

        String tempInt;
        while (isStringEmpty(tempInt = scanner.nextLine())) {
            System.out.println("empty value");
        }

        return Integer.valueOf(tempInt);
    }

    public static String returnValidStringFromScanner() {
        Scanner scanner = new Scanner(System.in);

        String tempString;
        while (isStringEmpty(tempString = scanner.nextLine())) {
            System.out.println("empty value");
        }

        return tempString;
    }
}
