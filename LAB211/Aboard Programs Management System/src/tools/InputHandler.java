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
    private static boolean flag;
    private static int count;

    /**
     *
     * Retrieves a String input from the user based on the provided message and
     * format.
     *
     * @param iMsg The message displayed to the user before requesting the
     * input.
     * @param oMsg The message displayed to the user when the input does not
     * match the specified format.
     * @param format The regular expression format that the input should match.
     * @return The String input provided by the user, or null if the input does
     * not match the format after multiple attempts.
     */
    public static String getString(String iMsg, String oMsg, String format) {
        count = 5;
        flag = true;
        String str = null;
        while (flag) {
            try {
                if (count == 0) {
                    flag = false;
                    continue;
                }
                System.out.print(iMsg);
                str = sc.nextLine();
                if (str.matches(format)) {
                    flag = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(oMsg);
                count--;
            }
        }
        return str;
    }

    /**
     *
     * Retrieves a non-empty String input from the user based on the provided
     * message.
     *
     * @param iMsg The message displayed to the user before requesting the
     * input.
     * @param oMsg The message displayed to the user when the input is empty.
     * @return The non-empty String input provided by the user, or null if no
     * input is provided after multiple attempts.
     */
    public static String getString(String iMsg, String oMsg) {
        count = 5;
        flag = true;
        String str = null;
        while (flag) {
            try {
                if (count == 0) {
                    flag = false;
                    continue;
                }
                System.out.print(iMsg);
                str = sc.nextLine();
                if (!str.trim().isEmpty()) {
                    flag = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(oMsg);
                count--;
            }
        }
        return str;
    }

    /**
     *
     * Retrieves a Date input from the user based on the provided message and
     * format.
     *
     * @param iMsg The message displayed to the user before requesting the
     * input.
     * @param oMsg The message displayed to the user when the input is invalid.
     * @param format The format of the expected Date input.
     * @return The Date object representing the user's input, or null if the
     * input is invalid after multiple attempts.
     */
    public static Date getDate(String iMsg, String oMsg, String format) {
        count = 5;
        flag = true;
        String str = null;
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        while (flag) {
            try {
                if (count == 0) {
                    flag = false;
                    continue;
                }
                System.out.print(iMsg);
                str = sc.nextLine();
                d = sdf.parse(str);
                flag = false;
            } catch (ParseException e) {
                System.out.println(oMsg);
                count--;
            }
        }
        return d;
    }
}
