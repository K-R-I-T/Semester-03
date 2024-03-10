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
     * Constructs a new menu with the specified title.
     *
     * @param title The title of the menu.
     */
    public Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
        this.size = 0;
    }

    /**
     * Adds an option to the menu.
     *
     * @param option The option to add.
     */
    public void addOption(String option) {
        options.add(option);
        size++;
    }

    /**
     * Prompts the user for input and returns the user's choice.
     *
     * @return The user's choice.
     */
    public int getChoice() {
        boolean flag = true;
        int choice = 0;
        while (flag) {
            try {
                choice = InputHandler.getPositiveInt("Enter your choice: ", "Must be a positive number!");
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
     * Prints the menu to the console.
     */
    public void print() {
        System.out.println(title);
        for (int i = 0; i < size; i++) {
            System.out.format("%d. %s.", i + 1, options.get(i));
            System.out.println("");
        }
    }

    /**
     * Prompts the user to choose between two options and returns the user's
     * choice.
     *
     * @param iMsg The input message.
     * @param op1 The first option.
     * @param op2 The second option.
     * @return True if the user chooses the first option, false otherwise.
     */
    public static boolean getOption(String iMsg, String op1, String op2) {
        Menu menu = new Menu(iMsg);
        menu.addOption(op1);
        menu.addOption(op2);
        menu.print();
        return menu.getChoice() == 1;
    }
}
