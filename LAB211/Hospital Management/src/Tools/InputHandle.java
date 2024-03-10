/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class InputHandle {

    public static Scanner sc = new Scanner(System.in);

    /**
     * This method prompts the user for a string input and validates it against
     * a regular expression.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @param errorMsg the error message to display if the input is invalid
     * @param regex the regular expression to validate the input against
     * @return the validated string input
     */
    public static String getString(String inputMsg, String errorMsg, String regex) {
        boolean flag = true;
        String str = null;
        while (flag) {
            try {
                System.out.print(inputMsg);
                str = sc.nextLine();
                if (!str.matches(regex)) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
        return str;
    }

    /**
     * This method prompts the user for a non-empty string input.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @param errorMsg the error message to display if the input is empty
     * @return the non-empty string input
     */
    public static String getString(String inputMsg, String errorMsg) {
        boolean flag = true;
        String str = null;
        while (flag) {
            try {
                System.out.print(inputMsg);
                str = sc.nextLine();
                if (str.trim().isEmpty()) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
        return str;
    }

    /**
     * This method prompts the user for a positive integer input.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @param errorMsg the error message to display if the input is not a
     * positive integer
     * @return the positive integer input
     */
    public static int getPositiveInt(String inputMsg, String errorMsg) {
        boolean flag = true;
        int num = 0;
        while (flag) {
            try {
                System.out.print(inputMsg);
                num = Integer.parseInt(sc.nextLine());
                if (num <= 0) {
                    throw new NumberFormatException();
                } else {
                    flag = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            } catch (Exception e) {
                System.out.println("Must be greater than 0!");
            }
        }
        return num;
    }

    /**
     * This method prompts the user for a string input and validates its length.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @param errorMsg the error message to display if the input is not within
     * the specified length range
     * @param min the minimum length of the input string
     * @param max the maximum length of the input string
     * @return the validated string input
     */
    public static String getString(String inputMsg, String errorMsg, int min, int max) {
        boolean flag = true;
        String str = null;
        while (flag) {
            try {
                System.out.print(inputMsg);
                str = sc.nextLine();
                if (str.length() < min || str.length() > max) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
        return str;
    }

    /**
     * This method prompts the user for a non-negative double input.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @param errorMsg the error message to display if the input is negative
     * @return the non-negative double input
     */
    public static double getDouble(String inputMsg, String errorMsg) {
        boolean flag = true;
        double num = 0;
        while (flag) {
            try {
                System.out.print(inputMsg);
                num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    throw new NumberFormatException();
                }
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            } catch (Exception e) {
                System.out.println("Not less than 0!");
            }
        }
        return num;
    }

    /**
     * This method prompts the user for a string input.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @return the string input
     */
    public static String getString(String inputMsg) {
        System.out.print(inputMsg);
        return sc.nextLine();
    }

    /**
     * This method prompts the user for an integer input.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @return the integer input
     */
    public static int getInt(String inputMsg) {
        System.out.print(inputMsg);
        int num = Integer.parseInt(sc.nextLine());
        return num;
    }

    /**
     * This method prompts the user for a double input.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @return the double input
     */
    public static double getDouble(String inputMsg) {
        System.out.print(inputMsg);
        double num = Double.parseDouble(sc.nextLine());
        return num;
    }

    /**
     * This method prompts the user for a date input and validates its format.
     *
     * @param inputMsg the message to display when prompting the user for input
     * @param errorMsg the error message to display if the input is not in the
     * specified date format
     * @param dateFormat the expected date format of the input string
     * @return the validated date input
     */
    public static String getDate(String inputMsg, String errorMsg, String dateFormat) {
        boolean flag = true;
        String str = null;
        while (flag) {
            try {
                System.out.print(inputMsg);
                str = sc.nextLine();
                if (!checkValidDate(str, dateFormat)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println(errorMsg);
                System.out.println(dateFormat);
            }
        }
        return str;
    }

    /**
     * This method checks if a date string is valid and matches the specified
     * date format.
     *
     * @param date the date string to validate
     * @param dateFormat the expected date format of the input string
     * @return true if the date string is valid and matches the specified date
     * format, false otherwise
     */
    private static boolean checkValidDate(String date, String dateFormat) {
        boolean check = true;
        try {
            if (!isValidDateFormat(date, dateFormat)) {
                throw new IllegalArgumentException("Invalid date format!");
            }
            int day, month, year;
            String[] dateParts = date.split("[- / .]");
            if (dateFormat.equals("dd/mm/yyyy")) {
                day = Integer.parseInt(dateParts[0]);
                month = Integer.parseInt(dateParts[1]);
            } else {
                day = Integer.parseInt(dateParts[1]);
                month = Integer.parseInt(dateParts[0]);
            }
            year = Integer.parseInt(dateParts[2]);
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Invalid month value!");
            }
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30) {
                        throw new IllegalArgumentException("Invalid date value!");
                    } else {
                        check = true;
                    }
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
                        if (day > 29) {
                            throw new IllegalArgumentException("Invalid date value!");
                        } else {
                            check = true;
                        }
                    } else {
                        if (day > 28) {
                            throw new IllegalArgumentException("Invalid date value!");
                        } else {
                            check = true;
                        }
                    }
                default:
                    if (day > 31) {
                        throw new IllegalArgumentException("Invalid date value!");
                    } else {
                        check = true;
                    }
            }
        } catch (IllegalArgumentException e) {
            check = false;
        }
        return check;
    }

    private static final String DDMMYYYY_REGEX = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    private static final String MMDDYYYY_REGEX = "^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$";

    /**
     * This method checks if a date string matches the specified date format.
     *
     * @param date the date string to validate
     * @param dateFormat the expected date format of the input string
     * @return true if the date string matches the specified date format, false
     * otherwise
     */
    private static boolean isValidDateFormat(String date, String dateFormat) {
        String regex = (dateFormat.equals("dd/mm/yyyy")) ? DDMMYYYY_REGEX : MMDDYYYY_REGEX;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    /**
     * This method converts a date string to a Date object.
     *
     * @param date the date string to convert
     * @param format the expected date format of the input string
     * @return the Date object representing the input date string
     */
    public static Date toDate(String date, String format) {
        Date ret = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format); // Set format
            ret = sdf.parse(date); // Chuyển về theo format
        } catch (ParseException e) {
        }
        return ret;
    }
}
