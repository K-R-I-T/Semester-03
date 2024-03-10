/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import bussinesses.AboardProgramsManagement;
import tools.Menu;

/**
 *
 * @author Admin
 */
public class StudentMenu {

    private final Menu menu;
    private boolean flag;

    /**
     * Constructor for StudentMenu class. Initializes the menu with options to
     * manage students.
     */
    public StudentMenu() {
        menu = new Menu("Manage Student.");
        menu.addOption("Display all students");
        menu.addOption("Add a new student");
        menu.addOption("Edit information of a student by id");
        menu.addOption("Back to main menu");
    }

    /**
     * Main method for the StudentMenu class. Displays the menu and allows the
     * user to manage students.
     *
     * @param apm An instance of AboardProgramsManagement.
     */
    public void main(AboardProgramsManagement apm) {
        do {
            flag = true;
            menu.print();
            switch (menu.getChoice()) {
                case 1:
                    apm.displayStudent();
                    break;
                case 2:
                    apm.addStudent();
                    break;
                case 3:
                    apm.editStudent();
                    break;
                case 4:
                    flag = false;
                    break;
            }
        } while (flag);

    }
}
