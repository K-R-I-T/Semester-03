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
public class Nurse extends Person {

    protected String department;
    protected String shift;
    protected double salary;
    protected int count = 0;

    public Nurse() {
    }

    /**
     * This is a constructor for the Nurse class that creates a new nurse object
     * with the specified id, name, age, gender, address, phone, department,
     * shift, salary and count.
     *
     * @param id the id of the nurse
     * @param name the name of the nurse
     * @param age the age of the nurse
     * @param gender the gender of the nurse
     * @param address the address of the nurse
     * @param phone the phone number of the nurse
     * @param department the department of the nurse
     * @param shift the shift of the nurse
     * @param salary the salary of the nurse
     * @param count the count of how many times the nurse has been assigned
     */
    public Nurse(String id, String name, int age, String gender,
            String address, String phone, String department, String shift, double salary, int count) {
        super(id, name, age, gender, address, phone);
        this.department = department;
        this.shift = shift;
        this.salary = salary;
        this.count = count;
    }

    /**
     * This method returns the department of the nurse.
     *
     * @return the department of the nurse
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method sets the department of the nurse.
     *
     * @param department the department of the nurse
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * This method returns the shift of the nurse.
     *
     * @return the shift of the nurse
     */
    public String getShift() {
        return shift;
    }

    /**
     * This method sets the shift of the nurse.
     *
     * @param shift the shift of the nurse
     */
    public void setShift(String shift) {
        this.shift = shift;
    }

    /**
     * This method returns the salary of the nurse.
     *
     * @return the salary of the nurse
     */
    public double getSalary() {
        return salary;
    }

    /**
     * This method sets the salary of the nurse .
     *
     * @param salary the salary of the nurse
     *
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * This method returns the count of how many times the nurse has been
     * assigned.
     *
     * @return the count of how many times the nurse has been assigned
     */
    public int getCount() {
        return count;
    }

    /**
     * This method sets the count of how many times the nurse has been assigned.
     *
     * @param count the count of how many times the nurse has been assigned
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * This method increases the count of how many times the nurse has been
     * assigned by 1.
     */
    public void incNumOfCount() {
        count++;
        setCount(count);
    }

    /**
     * This method returns a string representation of the nurse object.
     *
     * @return a string representation of the nurse object
     */
    @Override
    public String toString() {
        String str = String.format("%s|%s|%d|%s|%s|%s|%s|%s|%f|%d", this.id, this.name,
                this.age, this.gender, this.address, this.phone, this.department, this.shift, this.salary, this.count);
        return str;
    }
}
