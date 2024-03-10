/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import tools.Formatter;

/**
 *
 * @author Admin
 */
public class Order implements Comparable<Order> {

    private final Set<OrderDetail> orderDetail = new TreeSet<>();
    private final String orderId;
    private final String cusName;
    private final Date orderDate;
    private final String format = "dd/MM/yyyy";
    private int count;
    private double total;

    /**
     * Constructs a new order with the specified order ID, customer name, and
     * order date.
     *
     * @param orderId The order ID.
     * @param cusName The customer name.
     * @param orderDate The order date.
     */
    public Order(String orderId, String cusName, Date orderDate) {
        this.orderId = orderId;
        this.cusName = cusName;
        this.orderDate = orderDate;
        count = 0;
        total = 0;
    }

    /**
     * Returns the order ID.
     *
     * @return The order ID.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Returns the customer name.
     *
     * @return The customer name.
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * Returns the order date.
     *
     * @return The order date.
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Returns the set of order details.
     *
     * @return The set of order details.
     */
    public Set<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    /**
     * Adds an order detail to the set of order details and updates the count
     * and total cost.
     *
     * @param od The order detail to add.
     */
    public void setOrderDetail(OrderDetail od) {
        this.orderDetail.add(od);
        count += od.getQuantity();
        total += od.getCost();
    }

    /**
     * Returns the count of flowers in the order.
     *
     * @return The count of flowers in the order.
     */
    public int getCount() {
        return count;
    }

    /**
     * Returns the total cost of the flowers in the order.
     *
     * @return The total cost of the flowers in the order.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Returns a string representation of the details of the order.
     *
     * @return A string representation of the details of the order.
     */
    private String toStringDetail() {
        String ret = "";
        ret = orderDetail.stream().map((od) -> String.format("%s|", od.toString())).reduce(ret, String::concat);
        return ret.substring(0, ret.length() - 1);
    }

    /**
     * Returns a string representation of the order.
     *
     * @return A string representation of the order.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s", orderId, cusName, Formatter.toDateString(orderDate, format), toStringDetail());
    }

    /**
     * Compares this order to another order based on their IDs.
     *
     * @param o The other order.
     * @return An integer representing the comparison result.
     */
    @Override
    public int compareTo(Order o) {
        return orderId.compareTo(o.getOrderId());
    }
}
