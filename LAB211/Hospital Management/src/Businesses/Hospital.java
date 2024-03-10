/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Businesses;

import Control.Menu;
import Models.Nurse;
import Models.Patient;
import Tools.FileHandle;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Hospital {

    private final String nursePath = "\\src\\files\\nurses.dat";
    private final String patientPath = "\\src\\files\\patients.dat";

    NurseList nurseList = new NurseList();
    PatientList patientList = new PatientList();

    public Hospital() {
    }

    /**
     * Creates a new nurse.
     */
    public void createNurse() {
        nurseList.createNurse();
    }

    /**
     * Finds a nurse by name.
     */
    public void findNurse() {
        nurseList.findNurse();
    }

    /**
     * Updates a nurse.
     */
    public void updateNurse() {
        nurseList.updateNurse();
    }

    /**
     * Deletes a nurse.
     */
    public void deleteNurse() {
        nurseList.deleteNurse();
    }

    /**
     * Adds a new patient.
     */
    public void addPatient() {
        patientList.addPatient(nurseList);
    }

    /**
     * Displays the list of patients.
     */
    public void displayPatient() {
        patientList.displayPatient();
    }

    /**
     * Sorts the list of patients.
     */
    public void sortPatient() {
        patientList.sortPatient();
    }

    /**
     * This method saves the data to a file.
     */
    public void saveData() {
        ArrayList<String> dta = new ArrayList<>();
        nurseList.entrySet().forEach((entry) -> {
            dta.add(entry.getValue().toString());
        });
        FileHandle.writeToFile(nursePath, dta);
        dta.clear();
        patientList.entrySet().forEach((entry) -> {
            dta.add(entry.getValue().toString());
        });
        FileHandle.writeToFile(patientPath, dta);
        System.out.println("Data saved successfully!");
    }

    /**
     * This method loads the data from a file.
     */
    public void loadData() {
        nurseList.clear();
        patientList.clear();
        ArrayList<String> dta = new ArrayList<>();
        dta.addAll(FileHandle.readFromFile(nursePath));
        dta.addAll(FileHandle.readFromFile(patientPath));
        dta.stream().map((item) -> item.trim().split("\\|")).forEachOrdered((lineSplit) -> {
            if (lineSplit[0].matches("^N\\d*$")) {
                nurseList.put(lineSplit[0],
                        new Nurse(lineSplit[0], lineSplit[1],
                                Integer.parseInt(lineSplit[2]),
                                lineSplit[3], lineSplit[4],
                                lineSplit[5], lineSplit[6],
                                lineSplit[7], Double.parseDouble(lineSplit[8]), Integer.parseInt(lineSplit[9])));
            } else if (lineSplit[0].matches("^P\\d*$")) {
                String[] nal = lineSplit[9].split(":");
                NurseList nl = new NurseList();
                for (String n : nal) {
                    nl.put(n, nurseList.findByID(n));
                }
                patientList.put(lineSplit[0],
                        new Patient(lineSplit[0], lineSplit[1],
                                Integer.parseInt(lineSplit[2]),
                                lineSplit[3], lineSplit[4],
                                lineSplit[5], lineSplit[6],
                                lineSplit[7], lineSplit[8], nl));
            }
        });
        System.out.println("Load data success!");
    }

    /**
     * This method quits the program.
     */
    public void quitProgram() {
        if (Menu.getYesNo("DO YOU WANT TO EXIT PROGRAM?")) {
            saveData();
            System.exit(0);
        }
    }

    /**
     * This method displays the nurse list.
     */
    public void display() {
        nurseList.display();
    }
}
