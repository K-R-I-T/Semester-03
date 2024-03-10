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
public class DateModifier {

    private static final String format = "dd/MM/yyyy";

    /**
     *
     * Converts a Date object to a formatted String representation.
     *
     * @param date The Date object to be converted.
     * @return A formatted String representation of the Date.
     */
    public static String toDateString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     *
     * Converts a String representation of a date to a Date object.
     *
     * @param date The String representation of the date.
     * @return The converted Date object.
     */
    public static Date toDate(String date) {
        Date ret = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            ret = sdf.parse(date);
        } catch (ParseException e) {
        }
        return ret;
    }

    /**
     *
     * Checks if a given date is within a specified date range.
     *
     * @param sD The start date of the range.
     * @param eD The end date of the range.
     * @param cur The date to check.
     * @return True if the date is within the range, false otherwise.
     */
    public static boolean isInRangeDate(Date sD, Date eD, Date cur) {
        boolean isAfter = sD.compareTo(cur) <= 0;
        boolean isBefore = eD.compareTo(cur) >= 0;
        return isAfter && isBefore;
    }
}
