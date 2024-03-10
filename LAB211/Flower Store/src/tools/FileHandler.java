/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import models.Order;

/**
 *
 * @author Admin
 */
public class FileHandler {

    private final static String SYSPATH = new File("").getAbsolutePath();

    /**
     * Initializes the path by concatenating the system path with the given
     * path.
     *
     * @param path the path to concatenate with the system path
     * @return the concatenated path
     */
    private static String initPath(String path) {
        return SYSPATH + path;
    }

    /**
     * Writes the given data to a file at the specified file path.
     *
     * @param filePath the path of the file to write to
     * @param dta the data to write to the file
     */
    public static void writeToFileTxT(String filePath, ArrayList<String> dta) {
        String path = initPath(filePath);
        File file = new File(path);
        try {
            file.createNewFile();
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
                for (String line : dta) {
                    String output = strToBin(line);
                    bf.write(output);
                    bf.newLine();
                }
            }
        } catch (IOException e) {
        }
    }

    /**
     * Reads data from a file at the specified file path and returns it as an
     * ArrayList of strings.
     *
     * @param filePath the path of the file to read from
     * @return an ArrayList of strings containing the data read from the file
     */
    public static ArrayList<String> readFromFileTxt(String filePath) {
        String path = initPath(filePath);
        File file = new File(path);
        ArrayList<String> dta = new ArrayList<>();
        try {
            try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bf.readLine()) != null) {
                    String input = binToStr(line.trim());
                    dta.add(input);
                }
            }
        } catch (IOException e) {
        }
        return dta;
    }

    /**
     * Converts the given string to a binary string.
     *
     * @param str the string to convert
     * @return a binary string representation of the input string
     */
    private static String strToBin(String str) {
        byte[] bstr = str.getBytes();
        StringBuilder ret = new StringBuilder();
        for (byte b : bstr) {
            ret.append(String.format("%8s", Integer.toBinaryString(b)));
        }
        return ret.toString();
    }

    /**
     * Converts the given binary string to a string.
     *
     * @param line the binary string to convert
     * @return a string representation of the input binary string
     */
    private static String binToStr(String line) {
        String lineSplit[] = line.split(" ");
        String ret = "";
        for (String item : lineSplit) {
            if (!item.trim().isEmpty()) {
                ret += (char) Integer.parseInt(item, 2);
            }
        }
        return ret;
    }

    /**
     * Writes the given data to a file at the specified file path in binary
     * format.
     *
     * @param filePath the path of the file to write to
     * @param dta the data to write to the file
     */
    public static void writeToFileDat(String filePath, ArrayList<String> dta) {
        String path = initPath(filePath);
        File file = new File(path);
        try {
            try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(dta);
            }
        } catch (IOException e) {
        }
    }

    /**
     * Reads data from a file at the specified file path in binary format and
     * returns it as an ArrayList of strings.
     *
     * @param filePath the path of the file to read from
     * @return an ArrayList of strings containing the data read from the file
     */
    public static ArrayList<String> readFromFileDat(String filePath) {
        String path = initPath(filePath);
        File file = new File(path);
        ArrayList<String> dta = new ArrayList<>();
        try {
            try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
                dta = (ArrayList<String>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
        }
        return dta;
    }

    /**
     * Writes the given data to a file at the specified file path in text
     * format.
     *
     * @param filePath the path of the file to write to
     * @param dta the data to write to the file
     */
    public static void writeToFileTxt(String filePath, String dta) {
        String path = initPath(filePath);
        File file = new File(path);
        try {
            file.createNewFile();
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
                String output = strToBin(dta);
                bf.write(output);
                bf.newLine();
            }
        } catch (IOException e) {
        }
    }

    /**
     * Writes the given order data to a file at the specified file path in
     * binary format.
     *
     * @param filePath the path of the file to write to
     * @param dta the order data to write to the file
     */
    public static void writeToFileDat(String filePath, Order dta) {
        String path = initPath(filePath);
        File file = new File(path);
        try {
            try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(dta);
            }
        } catch (IOException e) {
        }
    }
}
