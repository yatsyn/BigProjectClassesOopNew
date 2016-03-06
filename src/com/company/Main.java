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
                    printSearchMenu(idents, names, numbers, day, month, year);
                    break;
                case 3:
                    printAllRecords(idents, names, numbers, day, month, year);
                    break;
                case 4:
                    printAllRecordsSorted(idents, names, numbers, day, month, year);
                    break;
                case 5:
                    removeRecord(idents,names, numbers, day, month, year);
                    break;
                case 6:
                    editRecord(idents, names, numbers, day, month, year);
                    break;
                case 7:
                    printDateSorted(idents, names, numbers, day, month, year);
                    break;
                case 8:
                    FileUtils.writeStringToFile(new File(FILE_CSV), bigStringForCsv(idents, names, numbers, day, month, year));
                    break;
                case 9:
                    addingTest(idents, names, numbers, day, month, year);
                default:
                    System.out.println("wrong point in menu");
                    break;
            }
        }
    }

    public static int findFreeId(boolean[] idents) {
        for (int i = 0; i < idents.length; i++) {
            if (!idents[i])
                return i;
        }
        System.out.println("error");
        return -1;
    }

    public static void addNewRecord(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        System.out.println("Adding new contact");
        System.out.println("Name?");
        Scanner scanner = new Scanner(System.in);
        int id = findFreeId(idents);
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

    public static void printSearchMenu(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 for search by ID");
            System.out.println("2 for search by name");
            System.out.println("3 for search by number");
            System.out.println("4 for search by date");
            System.out.println("0 exit");
            System.out.println();
            int menu = Integer.valueOf(returnValidIntFromScanner());
            switch (menu) {
                case 0:
                    break;
                case 1:
                    findCustomerId(idents, names, numbers, day, month, year);
                    break;
                case 2:
                    findName(idents, names, numbers, day, month, year);
                    break;
                case 3:
                    findNumber(idents, names, numbers, day, month, year);
                    break;
                case 4:
                    findDate(idents, names, numbers, day, month, year);
                    break;
                default:
                    System.out.println("wrong point in menu");
                    break;
            }
        }
    }

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

    public static void findCustomerId(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter ID please");
        id = Integer.valueOf(returnValidIntFromScanner());
        printHeader();
        int checker = -1;
        int editId = 0;

        for (int i = 0; i < idents.length; i++) {
            if (idents[i] && id == i) {
                printString(i, names, numbers, day, month, year);
                checker++;
                editId = i;
            }

        }
    }

    public static void findName(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name?");
        String name = scanner.nextLine();
        printHeader();
        for (int i = 0; i < idents.length; i++) {
            if (idents[i] && name.equals(names[i])) {
                printString(i, names, numbers, day, month, year);
            }
        }
    }

    public static void findNumber(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number?");
        String Number = scanner.nextLine();
        printHeader();
        for (int i = 0; i < idents.length; i++) {
            if (idents[i] && Number.equals(numbers[i]))
                printString(i, names, numbers, day, month, year);
        }
        return;
    }

    public static void findDate(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        printHeader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Date of birthday:");
        System.out.println("day?");
        int dayz = Integer.valueOf(scanner.nextLine());
        System.out.println("month?");
        int monthz = Integer.valueOf(scanner.nextLine());
        System.out.println("year?");
        int yearz = Integer.valueOf(returnValidIntFromScanner());
        for (int i = 0; i < idents.length; i++) {
            if (idents[i] && dayz == day[i] && monthz == month[i] && yearz == year[i])
                printString(i, names, numbers, day, month, year);

        }
        System.out.println("error");
    }

    public static void printHeader() {

        System.out.printf("%50s\n|-ID--|---NAME---|-------NUM-----|------DATE------\n","__________________________________________________");
    }

    public static void printString(int i, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        System.out.printf("|%5d|%10s|%15s|%15s\n%50s\n",i,names[i],numbers[i],dateToString(year[i], month[i], day[i]),
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

    public static void addingTest(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {
        int count = 0;
        Random random = new Random();
        int id = findFreeId(idents);
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
            printString(r, names, numbers, day, month, year);
            idents[r] = false;
            System.out.println("done");
        }
    }

    public static void editRecord(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {

        System.out.println("enter ID for edit it");

        Scanner scanner = new Scanner(System.in);
        int id = Integer.valueOf(returnValidIntFromScanner());
        if (idents[id] && id > 0 && id < MAX) {
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

    public static String bigStringForCsv(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {

        String s = "sep=,\n"+"ID" + SEP + "NAMES" + SEP + "NUMBERS" + SEP + "YEAR" + SEP + "MONTH" + SEP + "DAY" + NEW_LINE;

        for (int i = 0; i < MAX; i++) {
            if (idents[i]) {
                s += i + SEP + names[i] + SEP + numbers[i] + SEP + year[i] + SEP + month[i] + SEP + day[i] + NEW_LINE;
            }
        }
        return s;
    }

    public static String dateToString(int y, int m, int d) {
        String s = y + "-";
        if (String.valueOf(m).length() == 1) {
            s += "0";
        }
        s += m + "-";
        if (d < 10) {
            s += "0";
        }
        s += d;
        return s;
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
