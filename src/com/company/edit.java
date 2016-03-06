package com.company;

import java.util.Scanner;

/**
 * Created by ivan on 06.03.2016.
 */
public class edit {

    public static void editRecord(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {

        System.out.println("enter ID for edit it");

        Scanner scanner = new Scanner(System.in);
        int id = Integer.valueOf(Main.returnValidIntFromScanner());
        if (idents[id] && id > 0 && id < Main.MAX) {
            System.out.println("Name?");
            names[id] = scanner.nextLine();
            System.out.println("Number?");
            numbers[id] = scanner.nextLine();
            System.out.println("Date of birthday:");

            System.out.println("day?");
            int d = Integer.valueOf(scanner.nextLine());
            if (d > 0 && d < 32) {
                day[id] = d;
            } else {
                System.out.println("not valid day");
            }

            System.out.println("month?");
            int m = Integer.valueOf(scanner.nextLine());
            if (m > 0 && m < 13) {
                month[id] = m;
            } else {
                System.out.println("not valid month");
            }

            System.out.println("year?");
            int y = Integer.valueOf(scanner.nextLine());
            if (y < 2016) {
                year[id] = y;
            } else {
                System.out.println("not valid year");
            }

            System.out.println("done");
            System.out.println();
        } else {
            System.out.println("ID not aailable for edit, check it please");
        }
    }

}
