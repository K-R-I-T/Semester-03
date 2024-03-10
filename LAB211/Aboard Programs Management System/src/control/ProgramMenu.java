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
public class ProgramMenu {

    private final Menu menu;
    private boolean flag;

    /**
     * Constructs a ProgramMenu object. The program menu options are initialized
     * and added to the menu.
     */
    public ProgramMenu() {
        menu = new Menu("Manage aboard programs.");
        menu.addOption("Display all aboard programs");
        menu.addOption("Add a new aboard programs");
        menu.addOption("Edit information of a program by id");
        menu.addOption("Search and display a program by id");
        menu.addOption("Back to main menu");
    }

    /**
     * Starts the program menu loop.
     *
     * @param apm The AboardProgramsManagement object.
     */
    public void main(AboardProgramsManagement apm) {
        do {
            flag = true;
            menu.print();
            switch (menu.getChoice()) {
                case 1:
                    apm.displayProgram();
                    break;
                case 2:
                    apm.addProgram();
                    break;
                case 3:
                    apm.editProgram();
                    break;
                case 4:
                    apm.searchProgram();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        } while (flag);

    }
}
