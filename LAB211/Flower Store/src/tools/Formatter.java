/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Formatter {

    /**
     * Converts a date object to a string representation using the specified
     * format.
     *
     * @param date The date object to convert.
     * @param format The format string to use.
     * @return A string representation of the date object.
     */
    public static String toDateString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Converts a string representation of a date to a date object using the
     * specified format.
     *
     * @param date The string representation of the date.
     * @param format The format string to use.
     * @return A date object representing the input string.
     */
    public static Date toDate(String date, String format) {
        Date ret = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            ret = sdf.parse(date);
        } catch (ParseException e) {
        }
        return ret;
    }

    /**
     * Checks if a string representation of a date is valid using the specified
     * format.
     *
     * @param date The string representation of the date.
     * @param format The format string to use.
     * @return True if the input string is a valid date, false otherwise.
     */
    public static boolean isValidDateFormat(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date ret = sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Formats a line of information for a table.
     *
     * @param no The line number.
     * @param id The ID.
     * @param date The date.
     * @param name The name.
     * @param count The count.
     * @param total The total.
     * @return A formatted string representing the input data.
     */
    public static String toInfoLine(int no, String id, Date date, String name, int count, double total) {
        return String.format("|%4d | %-8s | %-10s | %-16s | %12d | %11.0f |", no, id, toDateString(date, "dd/MM/yyyy"), name, count, total);
    }

    /**
     * Formats a line of information for a table.
     *
     * @param title The title.
     * @param count The count.
     * @param total The total.
     * @return A formatted string representing the input data.
     */
    public static String toTotalLine(String title, int count, double total) {
        return String.format("|     | %-8s |            |                  | %12d | %11.0f |", title, count, total);
    }
}
