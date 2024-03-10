/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Businesses;

import Control.Menu;
import Models.Nurse;
import Tools.InputHandle;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class NurseList extends HashMap<String, Nurse> {

    public NurseList() {
    }

    /**
     * This method creates a new nurse.
     */
    public void createNurse() {
        boolean flag = true;
        while (flag) {
            String nId = InputHandle.getString("Enter nurse ID: ", "Invalid ID!", "^N\\d*$");
            if (findByID(nId) != null) {
                System.out.println("Nurse ID already exists!");
            } else {
                String nName = InputHandle.getString("Enter nurse's name: ", "Invalid name!");
                int nAge = InputHandle.getPositiveInt("Enter nurse's age: ", "Invalid age!");
                String nGender = InputHandle.getString("Enter nurse's gender: ", "Invalid gender!", "^[Mm][Aa][Ll][Ee]$|^[Ff][Ee][Mm][Aa][Ll][Ee]$");
                String nAddress = InputHandle.getString("Enter nurse's address: ", "Invalid address!");
                String nPhone = InputHandle.getString("Enter nurse's phone number: ", "Invalid phone number!", "^0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$");
                String nDepartment = InputHandle.getString("Enter nurse's department: ", "Invalid department!", 3, 50);
                String nShift = InputHandle.getString("Enter nurse's shift: ", "Invalid shift!", "^[Dd][Aa][Yy]$|^[Nn][Ii][Gg][Hh][Tt]$");
                double nSalary = InputHandle.getDouble("Enter nurse's salary: ", "Invalid salary!");
                this.put(nId, new Nurse(nId, nName, nAge, nGender, nAddress, nPhone, nDepartment, nShift, nSalary, 0));
            }
            if (!Menu.getYesNo("Keep adding new nurses?")) {
                flag = false;
            }
        }
    }

    /**
     * This method finds a nurse.
     */
    public void findNurse() {
        String nName = InputHandle.getString("Enter nurse's name: ", "Invalid name!");
        boolean check = true;
        for (Entry<String, Nurse> entry : this.entrySet()) {
            String name = entry.getValue().getName();
            if (name.equals(nName) || name.contains(nName)) {
                System.out.println(entry.getValue().toString());
                check = false;
            }
        }
        if (check) {
            System.out.println("Nurse does not exist!");
        }
    }

    /**
     * Update nurse information by ID.
     */
    public void updateNurse() {
        String nId = InputHandle.getString("Enter nurse ID: ", "Invalid ID!", "^N\\d*$");
        if (findByID(nId) == null) {
            System.out.println("The nurse does not exist!");
        } else {
            System.out.println("Nurse's info: " + findByID(nId).toString());
            System.out.println("Update the nurse: ");
            String nName = InputHandle.getString("Enter nurse's name: ");
            int nAge = InputHandle.getInt("Enter nurse's age: ");
            String nGender = InputHandle.getString("Enter nurse's gender: ");
            String nAddress = InputHandle.getString("Enter nurse's address: ");
            String nPhone = InputHandle.getString("Enter nurse's phone number: ");
            String nDepartment = InputHandle.getString("Enter nurse's department: ");
            String nShift = InputHandle.getString("Enter nurse's shift: ");
            double nSalary = InputHandle.getDouble("Enter nurse's salary: ");
            try {
                if (nName.trim().isEmpty() || nAge <= 0 || !nGender.matches("^[Mm][Aa][Ll][Ee]$|^[Ff][Ee][Mm][Aa][Ll][Ee]$")
                        || nAddress.trim().isEmpty() || !nPhone.matches("^0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$")
                        || !nDepartment.matches("^\\w.{2,47}$") || !nShift.matches("^[Dd][Aa][Yy]$|^[Nn][Ii][Gg][Hh][Tt]$") || nSalary < 0) {
                    throw new Exception();
                }
                findByID(nId).setName(nName);
                findByID(nId).setAge(nAge);
                findByID(nId).setGender(nGender);
                findByID(nId).setAddress(nAddress);
                findByID(nId).setPhone(nPhone);
                findByID(nId).setDepartment(nDepartment);
                findByID(nId).setShift(nShift);
                findByID(nId).setSalary(nSalary);
                System.out.println("Update success!");
            } catch (Exception e) {
                System.out.println("Update failure!");
            }
        }
    }

    /**
     * Delete nurse information by ID.
     */
    public void deleteNurse() {
        String nId = InputHandle.getString("Enter nurse ID: ", "Invalid ID!", "^N\\d*$");
        if (findByID(nId) == null) {
            System.out.println("The nurse does not exist!");
        } else {
            for (Entry<String, Nurse> entry : this.entrySet()) {
                if (entry.getValue().getId().equals(nId)) {
                    if (entry.getValue().getCount() != 0) {
                        System.out.println("Delete failure!");
                    } else {
                        if (Menu.getYesNo("Continue to delete this nurse?")) {
                            this.remove(nId);
                            System.out.println("Delete success!");
                            break;
                        } else {
                            System.out.println("Delete failure!");
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Displays a list of nurses.
     */
    public void display() {
        System.out.println("LIST OF NURSE");
        this.entrySet().stream().map((entry) -> String.format("%s|%s|%d|%s|%s|%s|%s|%s|%f|%d", entry.getValue().getId(), entry.getValue().getName(), entry.getValue().getAge(), entry.getValue().getGender(), entry.getValue().getAddress(),
                entry.getValue().getPhone(), entry.getValue().getDepartment(), entry.getValue().getShift(), entry.getValue().getSalary(), entry.getValue().getCount())).forEachOrdered((str) -> {
            System.out.println(str);
        });
    }

    /**
     * Returns a nurse object by ID.
     *
     * @param nurseId The ID of the nurse.
     * @return The nurse object.
     */
    public Nurse findByID(String nurseId) {
        return this.get(nurseId);
    }
}
