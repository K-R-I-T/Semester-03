/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import tools.DateModifier;

/**
 *
 * @author Admin
 */
public class Programs {

    private final String id;
    private String name;
    private String time;
    private Date beginDate;
    private Date endDate;
    private int days;
    private String location;
    private double cost;
    private String content;

    /**
     * Constructs a Programs object with the provided details.
     *
     * @param id The program ID.
     * @param name The program name.
     * @param time The program time.
     * @param beginDate The program begin date.
     * @param endDate The program end date.
     * @param days The program duration in days.
     * @param location The program location.
     * @param cost The program cost.
     * @param content The program content.
     */
    public Programs(String id, String name, String time, Date beginDate, Date endDate, int days, String location, double cost, String content) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.days = days;
        this.location = location;
        this.cost = cost;
        this.content = content;
    }

    /**
     * Retrieves the ID of the Students object.
     *
     * @return The ID of the Students object.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the name of the Students object.
     *
     * @return The name of the Students object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Students object.
     *
     * @param name The new name to set for the Students object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the begin date for the Students object.
     *
     * @return The begin date for the Students object.
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the begin date for the Students object.
     *
     * @param beginDate The new begin date to set for the Students object.
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * Retrieves the end date for the Students object.
     *
     * @return The end date for the Students object.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date for the Students object.
     *
     * @param endDate The new end date to set for the Students object.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Retrieves the number of days for the Students object.
     *
     * @return The number of days for the Students object.
     */
    public int getDays() {
        return days;
    }

    /**
     * Sets the number of days for the Students object.
     *
     * @param days The new number of days to set for the Students object.
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Retrieves the cost of the Students object.
     *
     * @return The cost of the Students object.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the Students object.
     *
     * @param cost The new cost to set for the Students object.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Retrieves the content of the Students object.
     *
     * @return The content of the Students object.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the Students object.
     *
     * @param content The new content to set for the Students object.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Retrieves the time of the Students object.
     *
     * @return The time of the Students object.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the Students object.
     *
     * @param time The new time to set for the Students object.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Retrieves the location of the Students object.
     *
     * @return The location of the Students object.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the Students object.
     *
     * @param location The new location to set for the Students object.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns a string representation of the Students object.
     *
     * @return A formatted string containing the student's details.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%d|%s|%f|%s", id, name, time, DateModifier.toDateString(beginDate),
                DateModifier.toDateString(endDate), days, location, cost, content);
    }
}
