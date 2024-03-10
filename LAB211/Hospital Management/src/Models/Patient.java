/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Businesses.NurseList;
import java.util.Map.Entry;

/**
 *
 * @author Admin
 */
public class Patient extends Person {

    protected String diagnosis;
    protected String admissionDate;
    protected String dischargeDate;
    protected NurseList nurseAssigned;

    public Patient() {
    }

    /**
     * This is a constructor for the Patient class that creates a new patient
     * object with the specified id, name, age, gender, address, phone,
     * diagnosis, admissionDate, dischargeDate and nurseAssigned.
     *
     * @param id the id of the patient
     * @param name the name of the patient
     * @param age the age of the patient
     * @param gender the gender of the patient
     * @param address the address of the patient
     * @param phone the phone number of the patient
     * @param diagnosis the diagnosis of the patient
     * @param admissionDate the admission date of the patient
     * @param dischargeDate the discharge date of the patient
     * @param nurseAssigned a NurseList object containing all nurses assigned to
     * this patient
     */
    public Patient(String id, String name, int age, String gender,
            String address, String phone,
            String diagnosis, String admissionDate, String dischargeDate, NurseList nurseAssigned) {
        super(id, name, age, gender, address, phone);
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.nurseAssigned = nurseAssigned;
    }

    /**
     * This method returns the diagnosis of the patient.
     *
     * @return the diagnosis of the patient
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * This method sets the diagnosis of the patient.
     *
     * @param diagnosis the diagnosis of the patient
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * This method returns the admission date of the patient.
     *
     * @return the admission date of the patient
     */
    public String getAdmissionDate() {
        return admissionDate;
    }

    /**
     * This method sets the admission date of the patient.
     *
     * @param admissionDate the admission date of the patient
     */
    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * This method returns the discharge date of the patient.
     *
     * @return the discharge date of the patient
     */
    public String getDischargeDate() {
        return dischargeDate;
    }

    /**
     * This method sets the discharge date of the patient.
     *
     * @param dischargeDate the discharge date of the patient
     */
    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    /**
     * This method returns a NurseList object containing all nurses assigned to
     * this patient.
     *
     * @return a NurseList object containing all nurses assigned to this
     * patient.
     */
    public NurseList getNurseAssigned() {
        return nurseAssigned;
    }

    /**
     * This method sets a NurseList object containing all nurses assigned to
     * this patient.
     *
     * @param nurseAssigned a NurseList object containing all nurses assigned to
     * this patient.
     */
    public void setNurseAssigned(NurseList nurseAssigned) {
        this.nurseAssigned = nurseAssigned;
    }

    /**
     * This method returns a string representation of all nurses assigned to
     * this patient.
     *
     * @return a string representation of all nurses assigned to this patient.
     */
    private String toStringNurseAssigned() {
        String ret = "";
        ret = nurseAssigned.entrySet().stream().map((entry) -> String.format("%s:", entry.getKey())).reduce(ret, String::concat);
        return ret.substring(0, ret.length() - 1);
    }

    /**
     * This method returns a string representation of this Patient object.
     *
     * @return a string representation of this Patient object.
     */
    @Override
    public String toString() {
        return String.format("%s|%s|%d|%s|%s|%s|%s|%s|%s|%s", id, name, age,
                gender, address, phone, diagnosis, admissionDate, dischargeDate, toStringNurseAssigned());
    }
}
