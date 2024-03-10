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
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class FileHandler {

    private final static String SYSPATH = new File("").getAbsolutePath();

    /**
     *
     * Prepends the system path to the given path.
     *
     * @param path The path to be initialized.
     * @return The initialized path with the system path prepended.
     */
    private static String initPath(String path) {
        return SYSPATH + path;
    }

    /**
     *
     * Writes the contents of an ArrayList of Strings to a file.
     *
     * @param filePath The file path where the data will be written.
     * @param dta The ArrayList of Strings containing the data to be written.
     */
    public static void writeToFile(String filePath, ArrayList<String> dta) {
        String path = initPath(filePath);
        File file = new File(path);
        try {
            file.createNewFile();
            try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(dta);
            }
        } catch (IOException e) {
        }
    }

    /**
     *
     * Writes the contents of an ArrayList of Strings to a text file.
     *
     * @param filePath The file path where the data will be written.
     * @param dta The ArrayList of Strings containing the data to be written.
     */
    public static void writeToFileTxt(String filePath, ArrayList<String> dta) {
        String path = initPath(filePath);
        File file = new File(path);
        try {
            file.createNewFile();
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
                for (String line : dta) {
                    bf.write(line);
                    bf.newLine();
                }
            }
        } catch (IOException e) {
        }
    }

    /**
     *
     * @param filePath
     * @return
     */
    public static ArrayList<String> readFromFileTxt(String filePath) {
        String path = initPath(filePath);
        File file = new File(path);
        ArrayList<String> dta = new ArrayList<>();
        try {
            try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bf.readLine()) != null) {
                    dta.add(line);
                }
            }
        } catch (IOException e) {
        }
        return dta;
    }

    /**
     *
     * Reads the contents of a text file and returns them as an ArrayList of
     * Strings.
     *
     * @param filePath The file path of the text file to be read.
     * @return An ArrayList of Strings containing the lines read from the file.
     */
    public static ArrayList<String> readFromFile(String filePath) {
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
     *
     * Retrieves the filenames within a specified directory.
     *
     * @param filepath The path of the directory.
     * @return An ArrayList of Strings containing the filenames within the
     * directory.
     */
    public static ArrayList<String> getFilename(String filepath) {
        String path = initPath(filepath);
        File file = new File(path);
        ArrayList<String> filenames = new ArrayList<>();
        try {
            filenames.addAll(Arrays.asList(file.list()));
        } catch (Exception e) {
        }
        return filenames;
    }
}
