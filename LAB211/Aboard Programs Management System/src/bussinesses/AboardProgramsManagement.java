/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesses;

import java.util.ArrayList;
import models.Programs;
import models.Students;
import tools.DateModifier;
import tools.FileHandler;
import tools.Menu;

/**
 *
 * @author Admin
 */
public class AboardProgramsManagement {

    private final ProgramManager pm = new ProgramManager();
    private final StudentManager sm = new StudentManager();
    private final String PROGRAMPATH = "\\src\\files\\program.dat";
    private final String STUDENTPATH = "\\src\\files\\student.dat";
    private final ProgramRegister pr = new ProgramRegister();
    private final Report r = new Report();

    /**
     * This method displays the contents of a ProgramManager object.
     */
    public void displayProgram() {
        pm.display();
    }

    /**
     * This method adds a program to the ProgramManager object.
     */
    public void addProgram() {
        pm.add();
    }

    /**
     * This method edits a program in the ProgramManager object.
     */
    public void editProgram() {
        pm.edit();
    }

    /**
     * This method searches for a program in the ProgramManager object.
     */
    public void searchProgram() {
        pm.search();
    }

    /**
     * This method displays the contents of a StudentManager object.
     */
    public void displayStudent() {
        sm.display();
    }

    /**
     * This method adds a student to the StudentManager object.
     */
    public void addStudent() {
        sm.add();
    }

    /**
     * This method edits a student in the StudentManager object.
     */
    public void editStudent() {
        sm.edit();
    }

    /**
     * This method registers a student for a program in the ProgramManager and
     * StudentManager objects.
     */
    public void register() {
        pr.register(pm, sm);
    }

    /**
     * This method displays the students who have registered for a program in
     * the RegisterManager object.
     */
    public void showRegisterStudent() {
        r.showRegisterStudent(sm);
    }

    /**
     * This method displays students who have multiple registrations.
     */
    public void showStudentHaveManyRegistration() {
        r.showStudentHaveManyRegistration(sm);
    }

    /**
     * This method counts the number of students registered in a program.
     */
    public void countStudentRegisteredProgram() {
        r.countStudentRegisteredProgram(pm);
    }

    /**
     * This method generates a report.
     */
    public void report() {
        r.Report();
    }

    /**
     * This method saves program and student data to files. It converts the
     * program and student objects into string arrays, and then writes those
     * arrays to corresponding files.
     */
    public void save() {
        ArrayList<String> p = pm.toStringArray();
        ArrayList<String> s = sm.toStringArray();
        FileHandler.writeToFile(PROGRAMPATH, p);
        FileHandler.writeToFile(STUDENTPATH, s);
    }

    /**
     * Loads data from files and populates the student and program maps.
     */
    public void load() {
        ArrayList<String> dta = new ArrayList<>();
        dta.addAll(FileHandler.readFromFile(STUDENTPATH));
        dta.stream().map((line) -> line.split("\\|")).forEachOrdered((lineSplit) -> {
            if (lineSplit[0].matches("^\\w*([SE]|[SB]|[GD]|[MC])\\d{3}$")) {
                sm.put(lineSplit[0], new Students(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6]));
            }
        });
        dta.clear();
        dta.addAll(FileHandler.readFromFile(PROGRAMPATH));
        dta.stream().map((line) -> line.split("\\|")).forEachOrdered((lineSplit) -> {
            pm.put(lineSplit[0], new Programs(lineSplit[0], lineSplit[1], lineSplit[2], DateModifier.toDate(lineSplit[3]),
                    DateModifier.toDate(lineSplit[4]), Integer.parseInt(lineSplit[5]), lineSplit[6], Double.parseDouble(lineSplit[7]), lineSplit[8]));
        });
    }

    /**
     * Quits the program if the user confirms their intention to quit.
     */
    public void quit() {
        if (Menu.get2Option("Quit program?", "Yes", "No")) {
            System.exit(0);
        }
    }
}
