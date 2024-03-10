/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import tools.Formatter;

/**
 *
 * @author Admin
 */
public class Flower implements Comparable<Flower> {

    private final String flowerId;
    private String flowerName;
    private Date importDate;
    private double unitPrice;
    private String category;
    private final String format = "dd/MM/yyyy";

    /**
     * Constructs a new flower with the specified unit price, category, flower
     * ID, flower name, and import date.
     *
     * @param unitPrice The unit price.
     * @param category The category.
     * @param flowerId The flower ID.
     * @param flowerName The flower name.
     * @param importDate The import date.
     */
    public Flower(double unitPrice, String category, String flowerId, String flowerName, Date importDate) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.importDate = importDate;
        this.unitPrice = unitPrice;
        this.category = category;
    }

    /**
     * Returns the unit price.
     *
     * @return The unit price.
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the unit price.
     *
     * @param unitPrice The unit price.
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Sets the flower name.
     *
     * @param flowerName The flower name.
     */
    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    /**
     * Sets the import date.
     *
     * @param importDate The import date.
     */
    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    /**
     * Returns the flower ID.
     *
     * @return The flower ID.
     */
    public String getFlowerId() {
        return flowerId;
    }

    /**
     * Returns the flower name.
     *
     * @return The flower name.
     */
    public String getFlowerName() {
        return flowerName;
    }

    /**
     * Returns the import date.
     *
     * @return The import date.
     */
    public Date getImportDate() {
        return importDate;
    }

    /**
     * Returns the category.
     *
     * @return The category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     *
     * @param category The category.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns a string representation of the flower.
     *
     * @return A string representation of the flower.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%s|%.0f|%s", flowerId, flowerName, Formatter.toDateString(importDate, format), unitPrice, category);
    }

    /**
     * Compares this flower to another flower based on their IDs.
     *
     * @param o The other flower.
     * @return An integer representing the comparison result.
     */
    @Override
    public int compareTo(Flower o) {
        return flowerId.compareTo(o.getFlowerId());
    }
}
