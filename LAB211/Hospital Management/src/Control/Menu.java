/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {

    private final String title;
    private final ArrayList<String> options = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    /**
     * This constructor creates a new Menu object with the specified title.
     *
     * @param title The title of the menu.
     */
    public Menu(String title) {
        this.title = title;
    }

    /**
     * Adds a new option to the list of options.
     *
     * @param newOption the new option to be added
     */
    public void addOption(String newOption) {
        options.add(newOption);
    }

    /**
     * Prints the menu title and options to the console.
     */
    public void printMenu() {
        System.out.println(title);
        options.forEach((s) -> {
            if (options.indexOf(s) < 9) {
                System.out.println(" " + (options.indexOf(s) + 1) + "." + s);
            } else {
                System.out.println("10." + s);
            }
        });
    }

    /**
     * Prompts the user to choose an option from the menu.
     *
     * @return the integer value of the chosen option
     */
    public int getChoice() {
        while (true) {
            try {
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > options.size()) {
                    throw new Exception();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Option must be an integer number!");
            } catch (Exception e) {
                System.out.println("Optioin must be in [1, " + options.size() + "]");
            }
        }
    }

    /**
     * Prompts the user to choose between "Yes" and "No" options.
     *
     * @param title the title of the prompt
     * @return true if the user chooses "Yes", false otherwise
     */
    public static boolean getYesNo(String title) {
        Menu sub = new Menu(title);
        sub.addOption("Yes");
        sub.addOption("No");
        sub.printMenu();
        return sub.getChoice() == 1;
    }

    /**
     * Prompts the user to choose between two options.
     *
     * @param op1 the first option
     * @param op2 the second option
     * @return true if the user chooses the first option, false otherwise
     */
    public static boolean getSort(String op1, String op2) {
        Menu title = new Menu("What function do you want to perform?");
        title.addOption(op1);
        title.addOption(op2);
        title.printMenu();
        return title.getChoice() == 1;
    }
}
