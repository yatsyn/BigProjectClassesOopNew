package com.company;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int MAX = 1000;
    public static final String FILE_ID = "file.i";
    public static final String FILE_NAMES = "file.name";
    public static final String FILE_NUMBERS = "file.numbers";
    public static final String FILE_YEAR = "file.y";
    public static final String FILE_MONTH = "file.m";
    public static final String FILE_DAY = "file.d";
    public static final String NEW_LINE = "\r\n";
    public static final String SEP = ",";
    public static final String FILE_CSV = "file.csv";


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        boolean[] idents = file.initArrBoolFromFile(FILE_ID);
        String[] names = file.initArrStringFromFile(FILE_NAMES);
        String[] numbers = file.initArrStringFromFile(FILE_NUMBERS);
        int[] day = file.initArrIntFromFile(FILE_DAY);
        int[] month = file.initArrIntFromFile(FILE_MONTH);
        int[] year = file.initArrIntFromFile(FILE_YEAR);

        while (true) {
            System.out.println("1 for adding");
            System.out.println("2 for search");
            System.out.println("3 print all");
            System.out.println("4 print sorted menu");
            System.out.println("5 for delete");
            System.out.println("6 edit menu");
            System.out.println("7 sort by date of birthday");
            System.out.println("8 export to exel file");
            System.out.println("9 for test account");
            System.out.println("0 exit");
            System.out.println();

//            String tempMenu;
//            while (isStringEmpty(tempMenu = scanner.nextLine()))   {
//                System.out.println("enter correct alue");
//            }

           //int menu = Integer.valueOf(tempMenu);
            int menu = returnValidIntFromScanner();

            switch (menu) {
                case 0:
                    file.saveToFile(year, FILE_YEAR);
                    file.saveToFile(month, FILE_MONTH);
                    file.saveToFile(day, FILE_DAY);
                    file.saveToFile(names, FILE_NAMES);
                    file.saveToFile(numbers, FILE_NUMBERS);
                    file.saveToFile(idents, FILE_ID);
                    return;
                case 1:
                    addNewRecord(idents, names, numbers, day, month, year);
                    break;
                case 2:
                    print.printSearchMenu(idents, names, numbers, day, month, year);
                    break;
                case 3:
                    print.printAllRecords(idents, names, numbers, day, month, year);
                    break;
                case 4:
                    print.printAllRecordsSorted(idents, names, numbers, day, month, year);
                    break;
                case 5:
                    removeRecord(idents,names, numbers, day, month, year);
                    break;
                case 6:
                    edit.editRecord(idents, names, numbers, day, month, year);
                    break;
                case 7:
                    print.printDateSorted(idents, names, numbers, day, month, year);
                    break;
                case 8:
                    FileUtils.writeStringToFile(new File(FILE_CSV), file.bigStringForCsv(idents, names, numbers, day, month, year));
                    break;
                case 9:
                    addingTest(idents, names, numbers, day, month, year);
                default:
                    System.out.println("wrong point in menu");
                    break;
            }
        }
    }

    public static void addNewRecord(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        System.out.println("Adding new contact");
        System.out.println("Name?");
        Scanner scanner = new Scanner(System.in);
        int id = search.findFreeId(idents);
        idents[id] = true;
        String name = scanner.nextLine();
        names[id] = name;
        System.out.println("Number?");
        numbers[id] = scanner.nextLine();
        System.out.println("Date of birthday:");
        while (day[id] == 0) {
            System.out.println("day?");
            int d = Integer.valueOf(returnValidIntFromScanner());
            if (d > 0 && d < 32) {
                day[id] = d;
            } else {
                System.out.println("not valid day");
            }
        }

        while (month[id] == 0) {
            System.out.println("month?");
            int m = Integer.valueOf(returnValidIntFromScanner());
            if (m > 0 && m < 13) {
                month[id] = m;
            } else {
                System.out.println("not valid month");
            }
        }

        System.out.println("year?");
        int y = Integer.valueOf(returnValidIntFromScanner());
        if (y < 2016) {
            year[id] = y;
        } else {
            System.out.println("not valid month");
        }

        System.out.println("done");
        System.out.println();
    }

    public static void addingTest(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        int count = 0;
        Random random = new Random();
        int id = search.findFreeId(idents);
        for (; id < idents.length; id = random.nextInt(1000)) {
            idents[id] = true;
            if (count == 0) {
                names[id] = "vasyau";
            } else if (count == 1) {
                names[id] = "anna";
            } else if (count == 2) {
                names[id] = "ylia";
            } else if (count == 3) {
                names[id] = "ashash";
            } else if (count == 4) {
                names[id] = "ivan";
            }
            numbers[id] = Integer.toString(random.nextInt(1000000));
            day[id] = random.nextInt(31);
            month[id] = random.nextInt(12);
            year[id] = random.nextInt(2015);

            count++;
            if (count > 4) {
                break;
            }
        }

        System.out.println("done");
        System.out.println();
    }

    public static void removeRecord(boolean[] idents,String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter ID to remove it");
        int r = Integer.valueOf(returnValidIntFromScanner());

        if (r < MAX && r >= 0) {
            System.out.println("this string will be removed");
            print.printString(r, names, numbers, day, month, year);
            idents[r] = false;
            System.out.println("done");
        }
    }


    public static boolean isStringEmpty (String s)  {
        return s=="null" || "".equals(s);
    }

    public static int returnValidIntFromScanner ()  {
        Scanner scanner = new Scanner(System.in);

        String tempMenu;
        while (isStringEmpty(tempMenu = scanner.nextLine()))   {
            System.out.println("enter correct alue");
        }

        return Integer.valueOf(tempMenu);
    }

}
