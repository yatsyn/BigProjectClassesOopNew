package com.company;

import java.io.*;

/**
 * Created by ivan on 01.03.2016.
 */
public class File {

    public static String[] openFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        return (String[]) objectInputStream.readObject();
    }

    public static int[] openFileInt(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        return (int[]) objectInputStream.readObject();
    }

    public static boolean[] openFileBoo(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        return (boolean[]) objectInputStream.readObject();
    }

    public static void saveToFile(String[] a, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
    }

    public static void saveToFile(int[] a, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
    }

    public static void saveToFile(boolean[] a, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(a);
        objectOutputStream.close();
    }

    public static boolean[] initArrBoolFromFile(String fileName) throws IOException, ClassNotFoundException {
        boolean[] idents;

        java.io.File fileBool = new java.io.File(fileName);
        if (fileBool.exists()) {
            idents = openFileBoo(fileName);
        } else {
            idents = new boolean[Main.MAX];
        }
        return idents;
    }

    public static String[] initArrStringFromFile(String fileName) throws IOException, ClassNotFoundException {
        String[] names;

        java.io.File fileString = new java.io.File(fileName);
        if (fileString.exists()) {
            names = openFile(fileName);
        } else {
            names = new String[Main.MAX];
        }

        return names;
    }

    public static int[] initArrIntFromFile(String fileName) throws IOException, ClassNotFoundException {
        int[] day;

        java.io.File fileD = new java.io.File(fileName);
        if (fileD.exists()) {
            day = openFileInt(fileName);
        } else {
            day = new int[Main.MAX];
        }
        return day;
    }

    public static String bigStringForCsv(boolean[] idents, String[] names, String[] numbers, int[] day, int[] month, int[] year) {

        String s = "sep=,\n"+"ID" + Main.SEP + "NAMES" + Main.SEP + "NUMBERS" + Main.SEP + "YEAR" + Main.SEP + "MONTH" + Main.SEP + "DAY" + Main.NEW_LINE;

        for (int i = 0; i < Main.MAX; i++) {
            if (idents[i]) {
                s += i + Main.SEP + names[i] + Main.SEP + numbers[i] + Main.SEP + year[i] + Main.SEP + month[i] + Main.SEP + day[i] + Main.NEW_LINE;
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

}
