/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import bussinesses.AboardProgramsManagement;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * The entry point of the program.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        AboardProgramsManagement apm = new AboardProgramsManagement();
        apm.load();
        MainMenu mMenu = new MainMenu();
        mMenu.main(apm);
    }
}
