/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class FileHandle {

    private final static String SYSPATH = new File("").getAbsolutePath();

    /**
     * This method initializes a path by concatenating the system path with the
     * specified path.
     *
     * @param path the path to be initialized
     * @return the initialized path
     */
    private static String initPath(String path) {
        return SYSPATH + path;
    }

    /**
     * This method writes the contents of an ArrayList to a file.
     *
     * @param filePath the path of the file to write to
     * @param dta the ArrayList containing the data to be written
     * @return true if the write operation was successful, false otherwise
     */
    public static boolean writeToFile(String filePath, ArrayList<String> dta) {
        String _path = initPath(filePath);
        File file = new File(_path);
        try {
            file.createNewFile();
            try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
                for (String line : dta) {
                    output.write(line);
                    output.newLine();
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * This method reads the contents of a file into an ArrayList.
     *
     * @param path the path of the file to read from
     * @return an ArrayList containing the contents of the file
     */
    public static ArrayList<String> readFromFile(String path) {
        String _path = initPath(path);
        File file = new File(_path);
        ArrayList<String> dta = new ArrayList<>();
        try {
            try (BufferedReader input = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = input.readLine()) != null) {
                    dta.add(line.trim());
                }
            }
        } catch (IOException e) {
        }
        return dta;
    }
}
