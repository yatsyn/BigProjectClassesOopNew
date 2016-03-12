package com.company.print;

import com.company.Main;
import com.company.search.Search;
import com.company.files.File;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ivan on 06.03.2016.
 */
public class Print {

    public static void printAllRecords(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        printHeader();
        for (int i = 0; i < idents.length; i++) {
            if (idents[i]) {
                printString(i, names, numbers, day, month, year);
            }
        }
        System.out.println();
        System.out.println();
    }



    public static void printHeader() {

        System.out.printf("%50s\n|-ID--|---NAME---|-------NUM-----|------DATE------\n","__________________________________________________");
    }

    public static void printString(int i, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        System.out.printf("|%5d|%10s|%15s|%15s\n%50s\n",i,names[i],numbers[i], File.dateToString(year[i], month[i], day[i]),
                "--------------------------------------------------");
    }

    public static void printAllRecordsSorted(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        printHeader();

        int j = 0;
        for (int i = 0; i < names.length; i++) {
            if (idents[i]) {
                j++;
            }
        }

        String[] sortedNames = new String[j];
        int n = 0;
        for (int i = 0; i < names.length; i++) {
            if (idents[i]) {
                sortedNames[n] = names[i];
                n++;
            }
        }

        Arrays.sort(sortedNames);

        for (int k = 0; k < sortedNames.length; k++) {
            for (int i = 0; i < idents.length; i++) {
                if (sortedNames[k].equals(names[i])) {
                    printString(i, names, numbers, day, month, year);
                }
            }
        }

        System.out.println();
        System.out.println();
    }

    public static void printDateSorted(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        printHeader();


        int j = 0;

        for (int i = 0; i < day.length; i++) {
            if (idents[i]) {
                j++;
            }
        }

        int[] sortedDates = new int[j];
        int n = 0;
        for (int i = 0; i < names.length; i++) {
            if (idents[i]) {
                sortedDates[n] = day[i] + month[i] * 100 + year[i] * 10000;
                n++;
            }
        }

        for (int i = 0; i < sortedDates.length; i++) {
            for (int l = 0; l < sortedDates.length - i - 1; l++) {
                if (sortedDates[l] > sortedDates[l + 1]) {
                    int temp = sortedDates[l];
                    sortedDates[l] = sortedDates[l + 1];
                    sortedDates[l + 1] = temp;
                }
            }
        }

        for (int k = 0; k < sortedDates.length; k++) {
            for (int i = 0; i < idents.length; i++) {
                if ((sortedDates[k] % 100) == day[i] && ((sortedDates[k] % 10000) / 100) == month[i]) {
                    printString(i, names, numbers, day, month, year);
                }
            }
        }

        System.out.println();
        System.out.println();
    }

    public static void printSearchMenu(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 for Search by ID");
            System.out.println("2 for Search by name");
            System.out.println("3 for Search by number");
            System.out.println("4 for Search by date");
            System.out.println("0 exit");
            System.out.println();
            int menu = Integer.valueOf(Main.returnValidIntFromScanner());
            switch (menu) {
                case 0:
                    break;
                case 1:
                    Search.findCustomerId(idents, names, numbers, day, month, year);
                    break;
                case 2:
                    Search.findName(idents, names, numbers, day, month, year);
                    break;
                case 3:
                    Search.findNumber(idents, names, numbers, day, month, year);
                    break;
                case 4:
                    Search.findDate(idents, names, numbers, day, month, year);
                    break;
                default:
                    System.out.println("wrong point in menu");
                    break;
            }
        }
    }

}
