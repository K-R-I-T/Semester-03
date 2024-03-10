/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesses;

import java.util.ArrayList;
import java.util.HashMap;
import tools.FileHandler;
import tools.InputHandler;

/**
 *
 * @author Admin
 */
public class Report {

    private ArrayList<String> formFilenames;
    private final String path = "\\src\\files\\RegistrationForm";
    private boolean flag;

    /**
     * This constructor initializes a new Report object with a list of
     * filenames.
     */
    public Report() {
        formFilenames = FileHandler.getFilename(path);
    }

    /**
     * This method initializes a new Report object with a list of filenames.
     */
    public void Report() {
        formFilenames = FileHandler.getFilename(path);
    }

    /**
     * This method displays the registration information of a student.
     *
     * @param sm a StudentManager object containing the student's information.
     */
    public void showRegisterStudent(StudentManager sm) {
        try {
            String id = null;
            int count = 5;
            do {
                flag = true;
                id = InputHandler.getString("Enter student's ID: ", "Invalid ID format! Try again. ((SE, SB, GD, MC)000)", "^\\w*([SE]|[SB]|[GD]|[MC])\\d{3}$");
                if (id == null) {
                    throw new Exception();
                }
                if (!sm.containsKey(id)) {
                    System.out.println("Student's ID does not exists!");
                    count--;
                } else {
                    flag = false;
                }
                if (count == 0) {
                    throw new Exception();
                }
            } while (flag);

            count = 0;
            for (String filename : formFilenames) {
                if (filename.contains(id)) {
                    ArrayList<String> form = FileHandler.readFromFileTxt(path + "\\" + filename);
                    printForm(form);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("The student has no registration!");
            }
        } catch (Exception e) {
            System.out.println("Show registration failure!");
        }
    }

    /**
     * This method displays the registration information of students who have
     * registered for more than one program.
     *
     * @param sm a StudentManager object containing the student's information.
     */
    public void showStudentHaveManyRegistration(StudentManager sm) {
        HashMap<String, Integer> sId = new HashMap<>();
        formFilenames.stream().map((filename) -> filename.split("_")[0]).forEachOrdered((id) -> {
            if (sId.containsKey(id)) {
                sId.replace(id, sId.get(id) + 1);
            } else {
                sId.put(id, 1);
            }
        });

        int count = 0;
        count = sId.entrySet().stream().filter((entry) -> (entry.getValue() > 1)).map((entry) -> sm.get(entry.getKey())).map((s) -> {
            System.out.println(String.format("%5s %20s %5s %24s %10s %8s %15s", s.getId(), s.getName(), s.getMajor(), s.getEmail(), s.getPhone(), s.getPassport(), s.getAddress()));
            return s;
        }).map((_item) -> 1).reduce(count, Integer::sum);
        if (count == 0) {
            System.out.println("There is no student registered more than 2 programs!");
        }
    }

    /**
     * This method counts the number of students who have registered for a given
     * program.
     *
     * @param pm a ProgramManager object containing the program's information.
     */
    public void countStudentRegisteredProgram(ProgramManager pm) {
        try {
            String pId = null;
            int count = 5;
            do {
                flag = true;
                pId = InputHandler.getString("Enter program's ID: ", "Not empty! Try again.");
                if (pId == null) {
                    throw new Exception();
                }
                if (!pm.containsKey(pId)) {
                    System.out.println("Program's ID does not exists!");
                    count--;
                } else {
                    flag = false;
                }
                if (count == 0) {
                    throw new Exception();
                }
            } while (flag);

            count = 0;
            for (String filename : formFilenames) {
                String id = filename.split("_")[1];
                id = id.substring(0, id.length() - 4);
                if (id.equals(pId)) {
                    count++;
                }
            }
            System.out.println("Number of student registered program " + pId + " is " + count);
        } catch (Exception e) {
            System.out.println("Count number of student registered program failure!");
        }
    }

    /**
     * This method prints the contents of a form.
     *
     * @param form an ArrayList of Strings containing the form's contents.
     */
    private void printForm(ArrayList<String> form) {
        form.forEach((line) -> {
            System.out.println(line);
        });
    }
}
