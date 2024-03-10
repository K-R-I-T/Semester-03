/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Menu {

    private final String title;
    private final ArrayList<String> options;
    private int size;

    /**
     *
     * Creates a new menu with the given title.
     *
     * @param title The title of the menu.
     */
    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
        this.size = 0;
    }

    /**
     *
     * Adds an option to the menu.
     *
     * @param option The option to be added to the menu.
     */
    public void addOption(String option) {
        options.add(option);
        size++;
    }

    /**
     *
     * Retrieves the user's choice from the menu.
     *
     * @return The selected menu option as an integer.
     */
    public int getChoice() {
        boolean flag = true;
        int choice = 0;
        while (flag) {
            try {
                choice = Integer.parseInt(InputHandler.getString("Enter your choice: ", "Must be a positive number!", "\\d"));
                if (choice < 1 || choice > size) {
                    throw new Exception();
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Choice 1 - " + size + ".");
            }
        }
        return choice;
    }

    /**
     *
     * Prints the menu title and options to the console.
     */
    public void print() {
        System.out.println(title);
        for (int i = 0; i < size; i++) {
            System.out.format("%d. %s.", i + 1, options.get(i));
            System.out.println("");
        }
    }

    /**
     *
     * Retrieves user input for a 2-option menu and returns the selected option.
     *
     * @param iMsg The message displayed to the user before the menu options.
     * @param op1 The first option in the menu.
     * @param op2 The second option in the menu.
     * @return True if the user selects the first option, false if the user
     * selects the second option.
     */
    public static boolean get2Option(String iMsg, String op1, String op2) {
        Menu menu = new Menu(iMsg);
        menu.addOption(op1);
        menu.addOption(op2);
        menu.print();
        return menu.getChoice() == 1;
    }
}
