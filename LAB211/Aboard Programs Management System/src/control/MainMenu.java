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
public class MainMenu {

    private final Menu menu;

    /**
     * Constructs a MainMenu object. The main menu options are initialized and
     * added to the menu.
     */
    public MainMenu() {
        menu = new Menu("Aboard program management system.");
        menu.addOption("Manage aboard programs");
        menu.addOption("Manage Student");
        menu.addOption("Register a program for a student");
        menu.addOption("Report");
        menu.addOption("Quit");
    }

    /**
     * Starts the main menu loop.
     *
     * @param apm The AboardProgramsManagement object.
     */
    public void main(AboardProgramsManagement apm) {
        boolean flag = true;
        while (flag) {
            menu.print();
            switch (menu.getChoice()) {
                case 1:
                    ProgramMenu pm = new ProgramMenu();
                    pm.main(apm);
                    break;
                case 2:
                    StudentMenu sm = new StudentMenu();
                    sm.main(apm);
                    break;
                case 3:
                    apm.register();
                    break;
                case 4:
                    ReportMenu rm = new ReportMenu();
                    rm.main(apm);
                    break;
                case 5:
                    apm.save();
                    apm.quit();
                    break;
            }
        }
    }
}
