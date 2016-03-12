package com.company.search;

import com.company.Main;
import com.company.print.Print;

import java.util.Scanner;

/**
 * Created by ivan on 06.03.2016.
 */
public class Search {

    public static int findFreeId(boolean[] idents) {
        for (int i = 0; i < idents.length; i++) {
            if (!idents[i])
                return i;
        }
        System.out.println("error");
        return -1;
    }

    public static void findCustomerId(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter ID please");
        id = Integer.valueOf(Main.returnValidIntFromScanner());
        Print.printHeader();
        int checker = -1;
        int editId = 0;

        for (int i = 0; i < idents.length; i++) {
            if (idents[i] && id == i) {
                Print.printString(i, names, numbers, day, month, year);
                checker++;
                editId = i;
            }

        }
    }

    public static void findName(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name?");
        String name = scanner.nextLine();
        Print.printHeader();
        for (int i = 0; i < idents.length; i++) {
            if (idents[i] && name.equals(names[i])) {
                Print.printString(i, names, numbers, day, month, year);
            }
        }
    }

    public static void findNumber(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number?");
        String Number = scanner.nextLine();
        Print.printHeader();
        for (int i = 0; i < idents.length; i++) {
            if (idents[i] && Number.equals(numbers[i]))
                Print.printString(i, names, numbers, day, month, year);
        }
        return;
    }

    public static void findDate(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        Print.printHeader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Date of birthday:");
        System.out.println("day?");
        int dayz = Integer.valueOf(scanner.nextLine());
        System.out.println("month?");
        int monthz = Integer.valueOf(scanner.nextLine());
        System.out.println("year?");
        int yearz = Integer.valueOf(Main.returnValidIntFromScanner());
        for (int i = 0; i < idents.length; i++) {
            if (idents[i] && dayz == day[i] && monthz == month[i] && yearz == year[i])
                Print.printString(i, names, numbers, day, month, year);

        }
        System.out.println("error");
    }
}
