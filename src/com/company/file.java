package com.company;

import java.io.*;

/**
 * Created by ivan on 01.03.2016.
 */
public class file {

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

        File fileBool = new File(fileName);
        if (fileBool.exists()) {
            idents = openFileBoo(fileName);
        } else {
            idents = new boolean[Main.MAX];
        }
        return idents;
    }

    public static String[] initArrStringFromFile(String fileName) throws IOException, ClassNotFoundException {
        String[] names;

        File fileString = new File(fileName);
        if (fileString.exists()) {
            names = openFile(fileName);
        } else {
            names = new String[Main.MAX];
        }

        return names;
    }

    public static int[] initArrIntFromFile(String fileName) throws IOException, ClassNotFoundException {
        int[] day;

        File fileD = new File(fileName);
        if (fileD.exists()) {
            day = openFileInt(fileName);
        } else {
            day = new int[Main.MAX];
        }
        return day;


    }



}
