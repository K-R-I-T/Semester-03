/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admin
 */
public class OrderDetail implements Comparable<OrderDetail> {

    private final int orderDetailId;
    private final Flower flower;
    private final int quantity;

    /**
     * Constructs a new order detail with the specified order detail ID, flower,
     * and quantity.
     *
     * @param orderDetailId The order detail ID.
     * @param flower The flower.
     * @param quantity The quantity.
     */
    public OrderDetail(int orderDetailId, Flower flower, int quantity) {
        this.orderDetailId = orderDetailId;
        this.flower = flower;
        this.quantity = quantity;
    }

    /**
     * Returns the order detail ID.
     *
     * @return The order detail ID.
     */
    public int getDetailId() {
        return orderDetailId;
    }

    /**
     * Returns the flower.
     *
     * @return The flower.
     */
    public Flower getFlower() {
        return flower;
    }

    /**
     * Returns the quantity.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the cost.
     *
     * @return The cost.
     */
    public double getCost() {
        return flower.getUnitPrice() * quantity;
    }

    /**
     * Returns a string representation of the order detail.
     *
     * @return A string representation of the order detail.
     */
    @Override
    public String toString() {
        return String.format("%d:%s:%d", orderDetailId, flower.getFlowerId(), quantity);
    }

    /**
     * Compares this order detail to another order detail.
     *
     * @param o The other order detail.
     * @return An integer representing the comparison result.
     */
    @Override
    public int compareTo(OrderDetail o) {
        return Integer.compare(orderDetailId, o.getDetailId());
    }
}
