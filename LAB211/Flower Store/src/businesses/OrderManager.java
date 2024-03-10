/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import models.Flower;
import models.Order;
import models.OrderDetail;
import tools.FileHandler;
import tools.Formatter;
import tools.InputHandler;
import tools.Menu;

/**
 *
 * @author Admin
 */
public class OrderManager extends TreeSet<Order> {

    private final String DELETEORDERPATH = "\\src\\files\\deleteOrders.dat";
    private final String DELETEORDERTXTPATH = "\\src\\files\\deleteOrders.txt";
    private final String format = "dd/MM/yyyy";
    private boolean flag;

    /**
     * This method adds a new order to the list of orders, along with its order
     * details. It prompts the user to enter the order ID, customer name, order
     * date, flower ID and quantity. It validates the input and checks for
     * existing IDs and flowers. It creates an Order object and an OrderDetail
     * object for each flower ordered. It loops until the user chooses to stop
     * adding orders or order details.
     *
     * @param fm The FlowerManager object that contains the list of flowers
     * available
     */
    public void add(FlowerManager fm) {
        flag = true;
        if (fm.isEmpty()) {
            System.out.println("No flower items exist! Let's add flowers.");
        } else {
            while (flag) {
                String nId = InputHandler.getString("Enter order ID: ", "Invalid ID format! Try again. (O0000)", "^O\\d{4}$");
                if (findById(nId) != null) {
                    System.out.println("Order ID already exist!");
                } else {
                    String nName = InputHandler.getString("Enter customer's name: ", "Customer's name cannot be left blank! Try again.");
                    Date nDate = InputHandler.getDate("Enter order date: ", "Invalid date format! Try again.", format);
                    Order o = new Order(nId, nName, nDate);
                    System.out.println("Add order details:");
                    int nOdId = 1;
                    while (flag) {
                        String nFId = null;
                        while (flag) {
                            nFId = InputHandler.getString("Enter flower ID: ", "Invalid ID format! Try again. (F0000)", "^F\\d{4}$");
                            if (fm.findById(nFId) != null) {
                                flag = false;
                            } else {
                                System.out.println("Flower does not exist!");
                                flag = true;
                            }
                        }
                        Flower f = fm.findById(nFId);
                        int nQuantity = InputHandler.getPositiveInt("Enter quantity: ", "Quantity is a positive number! Try again.");
                        o.setOrderDetail(new OrderDetail(nOdId, f, nQuantity));
                        this.add(o);
                        flag = false;
                        if (Menu.getOption("Do you want to continue adding order detail?", "Yes", "No")) {
                            flag = true;
                            nOdId++;
                        }
                    }
                }
                flag = true;
                if (!Menu.getOption("Do you want to continue adding order?", "Yes", "No")) {
                    flag = false;
                }
            }
        }
    }

    /**
     * Display orders from start date to end date.
     *
     */
    public void display() {
        Date sD = InputHandler.getDate("Start date: ", "Invalid date format! Try again.", format);
        Date eD = InputHandler.getDate("End date: ", "Invalid date format! Try again.", format);
        Set<Order> display = new TreeSet<>();
        this.stream().filter((o) -> (isInRangeDate(sD, eD, o))).forEachOrdered((o) -> {
            display.add(o);
        });
        System.out.println("LIST ORDER FROM " + Formatter.toDateString(sD, format) + " TO " + Formatter.toDateString(eD, format));
        displayScr(display);
    }

    /**
     * Sorts the orders by ID, date, name or total.
     */
    public void sort() {
        Set<Order> display = new TreeSet<>();
        Menu menu = new Menu("ORDER BY:");
        menu.addOption("ID");
        menu.addOption("Date");
        menu.addOption("Name");
        menu.addOption("Total");
        menu.print();
        switch (menu.getChoice()) {
            case 1:
                if (Menu.getOption("SORT ORDER:", "ASC", "DESC")) {
                    display = new TreeSet<>(new CmpId());
                } else {
                    display = new TreeSet<>(new CmpId().reversed());
                }
                break;
            case 2:
                if (Menu.getOption("SORT ORDER:", "ASC", "DESC")) {
                    display = new TreeSet<>(new CmpDate());
                } else {
                    display = new TreeSet<>(new CmpDate().reversed());
                }
                break;
            case 3:
                if (Menu.getOption("SORT ORDER:", "ASC", "DESC")) {
                    display = new TreeSet<>(new CmpName());
                } else {
                    display = new TreeSet<>(new CmpName().reversed());
                }
                break;
            case 4:
                if (Menu.getOption("SORT ORDER:", "ASC", "DESC")) {
                    display = new TreeSet<>(new CmpTotal().reversed());
                } else {
                    display = new TreeSet<>(new CmpTotal());
                }
                break;
        }
        for (Order o : this) {
            display.add(o);
        }
        displayScr(display);
    }

    /**
     * Deletes an order by ID.
     */
    public void delete() {
        String id = InputHandler.getString("Enter order ID: ", "Invalid ID format! Try again. (O0000)", "^O\\d{4}$");
        Order o = findById(id);
        if (o == null) {
            System.out.println("The order does not exist");
        } else {
            if (Menu.getOption("Continue deleting this order?", "YES", "NO")) {
                String dta = o.toString();
                FileHandler.writeToFileTxt(DELETEORDERTXTPATH, dta);
                FileHandler.writeToFileDat(DELETEORDERPATH, o);
                this.remove(o);
                System.out.println("Delete success!");
            } else {
                System.out.println("Delete failure!");
            }
        }
    }

    /**
     * Displays the screen.
     */
    private void displayScr(Set<Order> display) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| No. | Order ID | Order Date | Customer         | Flower Count | Order Total |");
        System.out.println("-------------------------------------------------------------------------------");
        int no = 1, count = 0;
        double total = 0;
        for (Order o : display) {
            System.out.println(Formatter.toInfoLine(no, o.getOrderId(), o.getOrderDate(), o.getCusName(), o.getCount(), o.getTotal()));
            no++;
            count += o.getCount();
            total += o.getTotal();
        }
        System.out.println(Formatter.toTotalLine("Total", count, total));
        System.out.println("-------------------------------------------------------------------------------");
    }

    /**
     * Checks if the order date is within the specified range.
     *
     * @param sD
     * @param eD
     * @param o
     * @return
     */
    private boolean isInRangeDate(Date sD, Date eD, Order o) {
        Date current = o.getOrderDate();
        boolean isAfter = sD.compareTo(current) <= 0;
        boolean isBefore = eD.compareTo(current) >= 0;
        return isAfter && isBefore;
    }

    /**
     * Checks if the flower is in the order.
     *
     * @param f
     * @return
     */
    public boolean isFlowerInOder(Flower f) {
        return this.stream().map((o) -> o.getOrderDetail()).anyMatch((ods) -> (ods.stream().anyMatch((od) -> (od.getFlower().getFlowerId().equals(f.getFlowerId())))));
    }

    /**
     * Finds the order by ID.
     *
     * @param id
     * @return
     */
    private Order findById(String id) {
        for (Order o : this) {
            if (o.getOrderId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    /**
     * Converts the object to an array of strings.
     *
     * @return
     */
    public ArrayList<String> toStringArray() {
        ArrayList<String> ret = new ArrayList<>();
        this.forEach((o) -> {
            ret.add(o.toString());
        });
        return ret;
    }
}

/**
 * Compares the order IDs.
 *
 * @author Admin
 */
class CmpId implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getOrderId().compareTo(o2.getOrderId());
    }
}

/**
 * Compares the order dates.
 *
 * @author Admin
 */
class CmpDate implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        if (o1.getOrderDate().compareTo(o2.getOrderDate()) == 0) {
            return o1.getOrderId().compareTo(o2.getOrderId());
        } else {
            return o1.getOrderDate().compareTo(o2.getOrderDate());
        }
    }
}

/**
 * Compares the customer names.
 *
 * @author Admin
 */
class CmpName implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getCusName().compareTo(o2.getCusName());
    }
}

/**
 * Compares the order totals.
 *
 * @author Admin
 */
class CmpTotal implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        if (o1.getTotal() == o1.getTotal()) {
            return o1.getOrderId().compareTo(o2.getOrderId());
        } else {
            return Double.compare(o1.getTotal(), o2.getTotal());
        }
    }
}
