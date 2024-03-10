/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class InputHandler {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user for input and returns the input as a string.
     *
     * @param iMsg The input message.
     * @param oMsg The output message.
     * @param format The format string to use.
     * @return A string representing the user's input.
     */
    public static String getString(String iMsg, String oMsg, String format) {
        boolean flag = true;
        String str = null;
        while (flag) {
            try {
                System.out.print(iMsg);
                str = sc.nextLine();
                if (!str.matches(format)) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println(oMsg);
            }
        }
        return str;
    }

    /**
     * Prompts the user for input and returns the input as a string.
     *
     * @param iMsg The input message.
     * @param oMsg The output message.
     * @return A string representing the user's input.
     */
    public static String getString(String iMsg, String oMsg) {
        boolean flag = true;
        String str = null;
        while (flag) {
            try {
                System.out.print(iMsg);
                str = sc.nextLine();
                if (str.trim().isEmpty()) {
                    throw new IllegalArgumentException();
                } else {
                    flag = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(oMsg);
            }
        }
        return str;
    }

    /**
     * Prompts the user for input and returns the input as a date.
     *
     * @param iMsg The input message.
     * @param oMsg The output message.
     * @param format The format string to use.
     * @return A date representing the user's input.
     */
    public static Date getDate(String iMsg, String oMsg, String format) {
        while (true) {
            try {
                System.out.print(iMsg);
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                return sdf.parse(sc.nextLine());
            } catch (ParseException e) {
                System.out.println(oMsg + " (" + format + ")");
            }
        }
    }

    /**
     * Prompts the user for input and returns the input as a positive double.
     *
     * @param iMsg The input message.
     * @param oMsg The output message.
     * @return A double representing the user's input.
     */
    public static double getPositiveDouble(String iMsg, String oMsg) {
        boolean flag = true;
        double num = 0;
        while (flag) {
            try {
                System.out.print(iMsg);
                num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    throw new NumberFormatException();
                } else {
                    flag = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(oMsg);
            }
        }
        return num;
    }

    /**
     * Prompts the user for input and returns the input as a positive integer.
     *
     * @param iMsg The input message.
     * @param oMsg The output message.
     * @return An integer representing the user's input.
     */
    public static int getPositiveInt(String iMsg, String oMsg) {
        boolean flag = true;
        int num = 0;
        while (flag) {
            try {
                System.out.print(iMsg);
                num = Integer.parseInt(sc.nextLine());
                if (num < 0) {
                    throw new NumberFormatException();
                } else {
                    flag = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(oMsg);
            }
        }
        return num;
    }

    /**
     * Prompts the user for input and returns the input as a string.
     *
     * @param iMsg The input message.
     * @return A string representing the user's input.
     */
    public static String getString(String iMsg) {
        System.out.print(iMsg);
        String str = sc.nextLine();
        return str;
    }
}
