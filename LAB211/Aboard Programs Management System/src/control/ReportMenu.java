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
public class ReportMenu {

    private final Menu menu;
    private boolean flag;

    /**
     * Constructs a ReportMenu object. The report menu options are initialized
     * and added to the menu.
     */
    public ReportMenu() {
        menu = new Menu("Report.");
        menu.addOption("Print out the registration by student’s id");
        menu.addOption("Print out the students that registered more than 2 programs");
        menu.addOption("Count students that registered the program");
        menu.addOption("Back to main menu");
    }

    /**
     * Starts the report menu loop.
     *
     * @param apm The AboardProgramsManagement object.
     */
    public void main(AboardProgramsManagement apm) {
        apm.report();
        do {
            flag = true;
            menu.print();
            switch (menu.getChoice()) {
                case 1:
                    apm.showRegisterStudent();
                    break;
                case 2:
                    apm.showStudentHaveManyRegistration();
                    break;
                case 3:
                    apm.countStudentRegisteredProgram();
                    break;
                case 4:
                    flag = false;
                    break;
            }
        } while (flag);

    }
}
