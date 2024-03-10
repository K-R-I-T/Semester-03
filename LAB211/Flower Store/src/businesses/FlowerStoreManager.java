/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesses;

import java.io.Serializable;
import java.util.ArrayList;
import models.Flower;
import models.Order;
import models.OrderDetail;
import tools.FileHandler;
import tools.Formatter;
import tools.Menu;

/**
 *
 * @author Admin
 */
public class FlowerStoreManager implements Serializable {

    private final FlowerManager fm = new FlowerManager();
    private final OrderManager om = new OrderManager();
    private final String format = "dd/MM/yyyy";
    private final String FLOWERPATH = "\\src\\files\\flowers.dat";
    private final String ORDERPATH = "\\src\\files\\orders.dat";
    private final String FLOWERTXTPATH = "\\src\\files\\flowers.txt";
    private final String ORDERTXTPATH = "\\src\\files\\orders.txt";

    /**
     * Adds a flower.
     */
    public void addFlower() {
        fm.add();
    }

    /**
     * Finds a flower.
     */
    public void findFlower() {
        fm.find();
    }

    /**
     * Updates a flower.
     */
    public void updateFlower() {
        fm.update();
    }

    /**
     * Deletes a flower.
     */
    public void deleteFlower() {
        fm.delete(om);
    }

    /**
     * Adds an order.
     */
    public void addOrder() {
        om.add(fm);
    }

    /**
     * Displays the order.
     */
    public void displayOrder() {
        om.display();
    }

    /**
     * Sorts the order.
     */
    public void sortOrder() {
        om.sort();
    }

    /**
     * Deletes the order.
     */
    public void deleteOrder() {
        om.delete();
    }

    /**
     * Displays the flowers.
     */
    public void displayFl() {
        fm.display();
    }

    /**
     * Saves the data to a text file.
     */
    public void saveTxt() {
        ArrayList<String> f = fm.toStringArray();
        ArrayList<String> o = om.toStringArray();
        FileHandler.writeToFileTxT(FLOWERTXTPATH, f);
        FileHandler.writeToFileTxT(ORDERTXTPATH, o);
        System.out.println("Saved data!");
    }

    /**
     * Loads the data from a text file.
     */
    public void loadTxt() {
        fm.clear();
        om.clear();
        ArrayList<String> dta = new ArrayList<>();
        dta.addAll(FileHandler.readFromFileTxt(FLOWERTXTPATH));
        dta.addAll(FileHandler.readFromFileTxt(ORDERTXTPATH));
        dta.stream().map((line) -> line.split("\\|")).forEachOrdered((lineSplit) -> { // for (line : dta) String lineSplit = line.split{" "};
            if (lineSplit[0].matches("F\\d{4}")) {
                fm.add(new Flower(Double.parseDouble(lineSplit[3]), lineSplit[4], lineSplit[0], lineSplit[1], Formatter.toDate(lineSplit[2], format)));
            } else if (lineSplit[0].matches("O\\d{4}")) {
                Order o = new Order(lineSplit[0], lineSplit[1], Formatter.toDate(lineSplit[2], format));
                int count = 0;
                for (String detial : lineSplit) {
                    if (count > 2) {
                        String od[] = detial.split(":");
                        o.setOrderDetail(new OrderDetail(Integer.parseInt(od[0]), fm.findById(od[1]), Integer.parseInt(od[2])));
                    }
                    count++;
                }
                om.add(o);
            }
        });
        System.out.println("Data loaded!");
    }

    /**
     * Saves the data to a binary file.
     */
    public void saveDat() {
        ArrayList<String> f = fm.toStringArray();
        ArrayList<String> o = om.toStringArray();
        FileHandler.writeToFileDat(FLOWERPATH, f);
        FileHandler.writeToFileDat(ORDERPATH, o);
    }

    /**
     * Loads the data from a binary file.
     */
    public void loadDat() {
        fm.clear();
        om.clear();
        ArrayList<String> dta = new ArrayList<>();
        dta.addAll(FileHandler.readFromFileDat(FLOWERPATH));
        dta.addAll(FileHandler.readFromFileDat(ORDERPATH));
        dta.stream().map((line) -> line.split("\\|")).forEachOrdered((lineSplit) -> {
            if (lineSplit[0].matches("F\\d{4}")) {
                fm.add(new Flower(Double.parseDouble(lineSplit[3]), lineSplit[4], lineSplit[0], lineSplit[1], Formatter.toDate(lineSplit[2], format)));
            } else if (lineSplit[0].matches("O\\d{4}")) {
                Order o = new Order(lineSplit[0], lineSplit[1], Formatter.toDate(lineSplit[2], format));
                int count = 0;
                for (String detial : lineSplit) {
                    if (count > 2) {
                        String od[] = detial.split(":");
                        o.setOrderDetail(new OrderDetail(Integer.parseInt(od[0]), fm.findById(od[1]), Integer.parseInt(od[2])));
                    }
                    count++;
                }
                om.add(o);
            }
        });
        System.out.println("Data loaded!");
    }

    /**
     * Quits the program.
     *
     * @param saved Indicates whether the data has been saved.
     */

    public void quit(boolean saved) {
        if (Menu.getOption("QUIT PROGRAM?", "YES", "NO")) {
            if (!saved && Menu.getOption("DO YOU WANT TO SAVE BEFORE QUIT?", "YES", "NO")) {
                if (Menu.getOption("SAVE DATA", "TXT", "DAT")) {
                    saveTxt();
                } else {
                    saveDat();
                }
            }
            System.exit(0);
        }
    }
}
