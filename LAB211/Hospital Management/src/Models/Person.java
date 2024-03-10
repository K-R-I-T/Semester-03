/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Admin
 */
public class Person {

    protected String id;
    protected String name;
    protected int age;
    protected String gender;
    protected String address;
    protected String phone;

    public Person() {
    }

    /**
     * This is a constructor for the Person class that creates a new person
     * object with the specified id, name, age, gender, address and phone.
     *
     * @param id the id of the person
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     * @param address the address of the person
     * @param phone the phone number of the person
     */
    public Person(String id, String name, int age, String gender, String address, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    /**
     * This method returns the id of the person.
     *
     * @return the id of the person.
     */
    public String getId() {
        return id;
    }

    /**
     * This method sets the id of the person.
     *
     * @param id the id of the person.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method returns the name of the person.
     *
     * @return the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the name of the person.
     *
     * @param name the name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the age of the person.
     *
     * @return the age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * This method sets the age of the person.
     *
     * @param age the age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This method returns the gender of the person.
     *
     * @return the gender of the person.
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method sets the gender of the person.
     *
     * @param gender the gender of the person.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * This method returns the address of this Person object.
     *
     * @return The address of this Person object.
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method sets this Person object's address to a new value.
     *
     * @param address The new address for this Person object.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method returns this Person object's phone number.
     *
     * @return The phone number for this Person object.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method sets this Person object's phone number to a new value.
     *
     * @param phone The new phone number for this Person object.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method returns a string representation of this Person object.
     *
     * @return A string representation of this Person object.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%d|%s|%s|%s", id, name, age, gender, address, phone);
    }
}
