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
public class Students {

    private final String id;
    private String name;
    private String major;
    private String email;
    private String phone;
    private String passport;
    private String address;

    /**
     *
     * Constructs a Students object with the provided details.
     *
     * @param id The student ID.
     * @param name The student's name.
     * @param major The student's major.
     * @param email The student's email address.
     * @param phone The student's phone number.
     * @param passport The student's passport number.
     * @param address The student's address.
     */
    public Students(String id, String name, String major, String email, String phone, String passport, String address) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.passport = passport;
        this.address = address;
    }

    /**
     *
     * Retrieves the student ID.
     *
     * @return The student ID.
     */
    public String getId() {
        return id;
    }

    /**
     *
     * Retrieves the student's name.
     *
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * Sets the student's name.
     *
     * @param name The new name to set for the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * Retrieves the student's major.
     *
     * @return The student's major.
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the student's major.
     *
     * @param major The new major to set for the student.
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Retrieves the student's email address.
     *
     * @return The student's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email address.
     *
     * @param email The new email address to set for the student.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the student's phone number.
     *
     * @return The student's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the student's phone number.
     *
     * @param phone The new phone number to set for the student.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the student's passport number.
     *
     * @return The student's passport number.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Sets the student's passport number.
     *
     * @param passport The new passport number to set for the student.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Retrieves the student's address.
     *
     * @return The student's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the student's address.
     *
     * @param address The new address to set for the student.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * Returns a string representation of the Students object.
     *
     * @return A formatted string containing the student's details.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%s|%s", id, name, major, email, phone, passport, address);
    }
}
