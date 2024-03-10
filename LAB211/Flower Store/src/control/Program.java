/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import businesses.FlowerStoreManager;
import tools.Menu;

/**
 *
 * @author Admin
 */
public class Program {

    /**
     * This is the main method of the FlowerStoreManager class.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        FlowerStoreManager fsm = new FlowerStoreManager();
        Menu mMenu = new Menu("FLOWER STORE MANAGER");
        mMenu.addOption("MANAGE FLOWER");
        mMenu.addOption("MANAGE ORDER");
        mMenu.addOption("SAVE");
        mMenu.addOption("LOAD");
        mMenu.addOption("QUIT");
        mMenu.addOption("DisplayFl");
        Menu fMenu = new Menu("MANAGE FLOWER");
        fMenu.addOption("ADD");
        fMenu.addOption("FIND");
        fMenu.addOption("UPDATE");
        fMenu.addOption("DELETE");
        fMenu.addOption("BACK");
        Menu oMenu = new Menu("MANAGE ORDER");
        oMenu.addOption("ADD");
        oMenu.addOption("DISPLAY");
        oMenu.addOption("SORT");
        oMenu.addOption("DELETE");
        oMenu.addOption("BACK");
        Menu sMenu = new Menu("SAVE DATA");
        sMenu.addOption("TXT");
        sMenu.addOption("DAT");
        Menu lMenu = new Menu("LOAD DATA");
        lMenu.addOption("TXT");
        lMenu.addOption("DAT");
        boolean saved = true, flag = true;
        while (flag) {
            mMenu.print();
            switch (mMenu.getChoice()) {
                case 1:
                    fMenu.print();
                    switch (fMenu.getChoice()) {
                        case 1:
                            fsm.addFlower();
                            saved = false;
                            break;
                        case 2:
                            fsm.findFlower();
                            break;
                        case 3:
                            fsm.updateFlower();
                            saved = false;
                            break;
                        case 4:
                            fsm.deleteFlower();
                            saved = false;
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 2:
                    oMenu.print();
                    switch (oMenu.getChoice()) {
                        case 1:
                            fsm.addOrder();
                            saved = false;
                            break;
                        case 2:
                            fsm.displayOrder();
                            break;
                        case 3:
                            fsm.sortOrder();
                            saved = false;
                            break;
                        case 4:
                            fsm.deleteOrder();
                            saved = false;
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 3:
                    sMenu.print();
                    switch (sMenu.getChoice()) {
                        case 1:
                            fsm.saveTxt();
                            break;
                        case 2:
                            fsm.saveDat();
                            break;
                    }
                    break;
                case 4:
                    lMenu.print();
                    switch (lMenu.getChoice()) {
                        case 1:
                            fsm.loadTxt();
                            break;
                        case 2:
                            fsm.loadDat();
                            break;
                    }
                    break;
                case 5:
                    fsm.quit(saved);
                    break;
                case 6:
                    fsm.displayFl();
            }
        }
    }
}
