/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Businesses;

import Control.Menu;
import Models.Patient;
import Tools.InputHandle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PatientList extends HashMap<String, Patient> {

    public PatientList() {
    }

    /**
     * This method adds a new patient to the system.
     *
     * @param nurseList The list of available nurses to be assigned to the new
     * patient.
     */
    public void addPatient(NurseList nurseList) {
        if (nurseList.isEmpty()) {
            System.out.println("Do not have any nurse to take care of new patient!");
        } else {
            boolean flag = true;
            while (flag) {
                String nId = InputHandle.getString("Enter patient ID: ", "Invalid ID!", "^P\\d*$");
                if (findByID(nId) != null) {
                    System.out.println("Patient ID already exists!");
                } else {
                    String nName = InputHandle.getString("Enter patient's name: ", "Invalid name!");
                    int nAge = InputHandle.getPositiveInt("Enter patient's age: ", "Invalid age!");
                    String nGender = InputHandle.getString("Enter patient's gender: ", "Invalid gender!", "^[Mm][Aa][Ll][Ee]$|^[Ff][Ee][Mm][Aa][Ll][Ee]$");
                    String nAddress = InputHandle.getString("Enter patient's address: ", "Invalid address!");
                    String nPhone = InputHandle.getString("Enter patient's phone number: ", "Invalid phone number!", "^0[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$");
                    String nDiagnosis = InputHandle.getString("Enter patient's diagnosis: ", "Invalid diagnosis!");
                    String nAdmissionDate = InputHandle.getDate("Enter patient admission date: ", "Invalid date!", "dd/mm/yyyy");
                    String nDischargeDate = InputHandle.getDate("Enter patient discharge date: ", "Invalid date!", "dd/mm/yyyy");
                    int count = 2;
                    NurseList nNurseAssigned = new NurseList();
                    while (count > 0) {
                        System.out.print((3 - count) + ". ");
                        String nNurseID = InputHandle.getString("Enter assigned nurse ID: ", "Invalid ID!", "^N\\d*$");
                        if (nurseList.containsKey(nNurseID) && !nNurseAssigned.containsKey(nNurseID)) {
                            if (nurseList.get(nNurseID).getCount() < 2) {
                                nNurseAssigned.put(nNurseID, nurseList.get(nNurseID));
                                count--;
                                nurseList.get(nNurseID).incNumOfCount();
                            } else {
                                System.out.println("Nurses have been assigned maximum!");
                                count = 0;
                            }
                        } else {
                            System.out.println("Nurse does not exist or is assigned!");
                            count = 0;
                        }
                    }
                    this.put(nId, new Patient(nId, nName, nAge, nGender, nAddress, nPhone, nDiagnosis, nAdmissionDate, nDischargeDate, nNurseAssigned));
                }
                if (!Menu.getYesNo("Keep adding new patients?")) {
                    flag = false;
                }
            }
        }
    }

    /**
     * This method displays a list of patients within a specified date range.
     */
    public void displayPatient() {
        String startDate = InputHandle.getDate("Enter start date: ", "Invalid date!", "dd/mm/yyyy");
        String endDate = InputHandle.getDate("Enter end date: ", "Invalid date!", "dd/mm/yyyy");
        System.out.println("LIST OF PATIENTS");
        System.out.println("Start date: " + startDate);
        System.out.println("End date: " + endDate);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("| No. | Patient Id | Admission Date | Full name        | Phone     | Diagnosis |");
        System.out.println("--------------------------------------------------------------------------------");
        int count = 1;
        for (Entry<String, Patient> entry : this.entrySet()) {
            if (InputHandle.toDate(entry.getValue().getAdmissionDate(), "dd/MM/yyyy").compareTo(InputHandle.toDate(startDate, "dd/MM/yyyy")) >= 0
                    && InputHandle.toDate(entry.getValue().getAdmissionDate(), "dd/MM/yyyy").compareTo(InputHandle.toDate(endDate, "dd/MM/yyyy")) <= 0) {
                String str = String.format("|%5d", count);
                System.out.print(str);
                String info = String.format("|%12s|%16s|%18s|%11s|%11s|", entry.getValue().getId(),
                        entry.getValue().getAdmissionDate(), entry.getValue().getName(),
                        entry.getValue().getPhone(), entry.getValue().getDiagnosis());
                System.out.println(info);
                count++;
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    /**
     * This method displays a sorted list of patients based on user selection.
     */
    public void sortPatient() {
        System.out.println("LIST OF PATIENTS");
        Comparator<Patient> comparator;
        boolean sel1 = Menu.getSort("Name", "ID");
        boolean sel2 = Menu.getSort("ASC", "DESC");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("| No. | Patient Id | Admission Date | Full name        | Phone     | Diagnosis |");
        if (sel1) {
            if (sel2) {
                comparator = Comparator.comparing(Patient::getName);
            } else {
                comparator = Comparator.comparing(Patient::getName);
                comparator = comparator.reversed();
            }
        } else {
            if (sel2) {
                comparator = Comparator.comparing(Patient::getId);
            } else {
                comparator = Comparator.comparing(Patient::getId);
                comparator = comparator.reversed();
            }
        }
        List<Patient> sortPatients = new ArrayList<>(this.values());
        sortPatients.sort(comparator);
        int count = 1;
        for (Patient patient : sortPatients) {
            String str = String.format("|%5d", count);
            System.out.print(str);
            String info = String.format("|%12s|%16s|%18s|%11s|%11s|", patient.getId(),
                    patient.getAdmissionDate(), patient.getName(), patient.getPhone(),
                    patient.getDiagnosis());
            System.out.println(info);
            count++;
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    /**
     * This method finds and returns a patient based on their ID.
     *
     * @param patientId The ID of the patient to find.
     * @return The patient with the specified ID, or null if not found.
     */
    private Patient findByID(String patientId) {
        return this.get(patientId);
    }
}
