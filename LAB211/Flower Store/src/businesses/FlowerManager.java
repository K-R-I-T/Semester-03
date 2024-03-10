/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;
import models.Flower;
import tools.Formatter;
import tools.InputHandler;
import tools.Menu;

/**
 *
 * @author Admin
 */
public class FlowerManager extends TreeSet<Flower> {

    private final String format = "dd/MM/yyyy";

    /**
     * Adds a flower.
     */
    public void add() {
        boolean flag = true;
        while (flag) {
            String nId = InputHandler.getString("Enter flower ID: ", "Invalid ID format! Try again. (F0000)", "^F\\d{4}$");
            if (findById(nId) != null) {
                System.out.println("Flower ID already exists");
            } else {
                String nName = InputHandler.getString("Enter flower name: ", "Flower names cannot be left blank! Try again.");
                Date nDate = InputHandler.getDate("Enter flower import date: ", "Invalid date format! Try again.", format);
                double nUnitPrice = InputHandler.getPositiveDouble("Enter flower unit price: ", "Flower unit price is a positive number! Try again.");
                String nCategory = InputHandler.getString("Enter flower category: ", "Flower category cannot be left blank! Try again.");
                this.add(new Flower(nUnitPrice, nCategory, nId, nName, nDate));
                if (!Menu.getOption("Do you want to continue adding flower?", "Yes", "No")) {
                    flag = false;
                }
            }
        }
    }

    /**
     * Finds a flower.
     */
    public void find() {
        Flower f;
        if (Menu.getOption("Do you want to find flowers by ID or Name?", "ID", "Name")) {
            String id = InputHandler.getString("Enter flower ID: ", "Invalid ID format! Try again. (F0000)", "^F\\d{4}$");
            f = findById(id);
        } else {
            String name = InputHandler.getString("Enter flower name: ", "Flower names cannot be left blank! Try again.");
            f = findByName(name);
        }
        if (f == null) {
            System.out.println("The flower does not exist");
        } else {
            System.out.println(f.toString());
        }
    }

    /**
     * Updates a flower.
     */
    public void update() {
        String name = InputHandler.getString("Enter flower name: ", "Flower names cannot be left blank! Try again.");
        Flower f = findByName(name);
        if (f == null) {
            System.out.println("The flower does not exist");
        } else {
            String nName = InputHandler.getString("Enter flower name (enter if ignore it): ");
            String nDate = InputHandler.getString("Enter flower import date (enter if ignore it): ");
            String nUnitPrice = InputHandler.getString("Enter flower unit price (enter if ignore it): ");
            String nCategory = InputHandler.getString("Enter flower category (enter if ignore it): ");
            try {
                if (!nDate.isEmpty() && !Formatter.isValidDateFormat(nDate, format)) {
                    throw new Exception("Invalid date format!");
                }
                if (!nUnitPrice.isEmpty() && Double.parseDouble(nUnitPrice) < 0) {
                    throw new Exception("Flower unit price is a positive number!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Update failure!");
                return;
            }
            if (!nName.trim().isEmpty()) {
                f.setFlowerName(nName);
            }
            if (!nDate.isEmpty()) {
                f.setImportDate(Formatter.toDate(nDate, format));
            }
            if (!nUnitPrice.isEmpty()) {
                f.setUnitPrice(Double.parseDouble(nUnitPrice));
            }
            if (!nCategory.isEmpty()) {
                f.setCategory(nCategory);
            }
            System.out.println("Update success!");
        }
    }

    /**
     * Deletes a flower.
     *
     * @param om The order manager.
     */
    public void delete(OrderManager om) {
        String id = InputHandler.getString("Enter flower ID: ", "Invalid ID format! Try again. (F0000)", "^F\\d{4}$");
        Flower f = findById(id);
        if (f == null) {
            System.out.println("The flower does not exist");
        } else {
            if (Menu.getOption("Continue deleting this flower?", "YES", "NO")) {
                if (om.isFlowerInOder(f)) {
                    System.out.println("Delete failure!");
                } else {
                    this.remove(f);
                    System.out.println("Delete success!");
                }
            } else {
                System.out.println("Delete failure!");
            }
        }
    }

    /**
     * Finds a flower by ID.
     *
     * @param id The ID of the flower.
     * @return The flower with the specified ID or null if not found.
     */
    public Flower findById(String id) {
        for (Flower f : this) {
            if (f.getFlowerId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Finds a flower by name.
     *
     * @param name The name of the flower.
     * @return The flower with the specified name or null if not found.
     */
    public Flower findByName(String name) {
        for (Flower f : this) {
            if (f.getFlowerName().contains(name)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Converts the list of flowers to an array of strings.
     *
     * @return An array of strings representing the flowers.
     */
    public ArrayList<String> toStringArray() {
        ArrayList<String> ret = new ArrayList<>();
        this.forEach((f) -> {
            ret.add(f.toString());
        });
        return ret;
    }

    /**
     * Displays the list of flowers.
     */
    public void display() {
        TreeSet<Flower> fl = new TreeSet<>();
        Menu menu = new Menu("ORDER BY:");
        menu.addOption("ASC");
        menu.addOption("DESC");
        menu.print();
        if (menu.getChoice() == 1) {
            fl = new TreeSet<>(new CmpId1());
        } else {
            fl = new TreeSet<>(new CmpId1().reversed());
        }
        for (Flower thi : this) {
            fl.add(thi);
        }
        for (Flower flower : fl) {
            System.out.println(flower.toString());
        }
    }
}

/**
 * A comparator that compares flowers by name.
 *
 * @param o1 The first flower.
 * @param o2 The second flower.
 * @return A negative integer, zero, or a positive integer as the first argument
 * is less than, equal to, or greater than the second.
 */
class CmpId1 implements Comparator<Flower> {

    @Override
    public int compare(Flower o1, Flower o2) {
        return o1.getFlowerName().compareTo(o2.getFlowerName());
    }
}
