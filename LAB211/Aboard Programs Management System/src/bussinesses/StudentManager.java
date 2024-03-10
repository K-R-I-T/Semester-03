/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesses;

import java.util.ArrayList;
import java.util.HashMap;
import models.Students;
import tools.InputHandler;
import tools.Menu;

/**
 *
 * @author Admin
 */
public class StudentManager extends HashMap<String, Students> {

    private boolean flag;

    /**
     * Displays the student information.
     */
    public void display() {
        System.out.println("ID    NAME                 MAJOR EMAIL                    PHONE      PASSPORT ADDRESS");
        entrySet().stream().map((entry) -> entry.getValue()).forEachOrdered((s) -> {
            System.out.println(String.format("%5s %-20s %-5s %-24s %10s %-8s %-15s", s.getId(), s.getName(), s.getMajor(), s.getEmail(), s.getPhone(), s.getPassport(), s.getAddress()));
        });
    }

    /**
     * Adds a new student to the database.
     *
     */
    public void add() {
        try {
            String nId = null;
            int count = 5;
            do {
                flag = true;
                nId = InputHandler.getString("Enter student's ID: ", "Invalid ID format! Try again. ((SE, SB, GD, MC)000)", "^\\w*([SE]|[SB]|[GD]|[MC])\\d{3}$");
                if (nId == null) {
                    throw new Exception();
                }
                if (find(nId) != null) {
                    System.out.println("Student's ID already exists!");
                    count--;
                } else {
                    flag = false;
                }
                if (count == 0) {
                    throw new Exception();
                }
            } while (flag);

            String nName = InputHandler.getString("Enter student's name: ", "Not empty! Try again.");
            if (nName == null) {
                throw new Exception();
            }

            String nMajor = InputHandler.getString("Enter student's major: ", "Invalid major format! Try again. (SE, SB, GD, MC)", "^(SE)|(SB)|(GD)|(MC)$");
            if (nMajor == null) {
                throw new Exception();
            }

            String nEmail = InputHandler.getString("Enter student's email: ", "Invalid email! Try again. (contains \"@fpt.edu.vn\" )", "^\\w\\S*(@fpt\\.edu\\.vn)$");
            if (nEmail == null) {
                throw new Exception();
            }

            String nPhone = InputHandler.getString("Enter student's phone number: ", "Invalid phone number! Try again.", "^(84|0[3|5|7|8|9])+([0-9]{8})\\b");
            if (nPhone == null) {
                throw new Exception();
            }

            String nPassport = InputHandler.getString("Enter student's passport: ", "Not empty! Try again.");
            if (nPassport == null) {
                throw new Exception();
            }

            String nAddress = InputHandler.getString("Enter student's address: ", "Not empty! Try again.");
            if (nAddress == null) {
                throw new Exception();
            }
            put(nId, new Students(nId, nName, nMajor, nEmail, nPhone, nPassport, nAddress));
        } catch (Exception e) {
            System.out.println("Add failure!");
        }
    }

    /**
     * This method edits student's information.
     */
    public void edit() {
        try {
            String nId = null;
            int count = 5;
            do {
                flag = true;
                nId = InputHandler.getString("Enter student's ID: ", "Invalid ID format! Try again. ((SE, SB, GD, MC)000)", "^\\w*([SE]|[SB]|[GD]|[MC])\\d{3}$");
                if (nId == null) {
                    throw new Exception();
                }
                if (find(nId) == null) {
                    System.out.println("Student's ID does not exists!");
                    count--;
                } else {
                    flag = false;
                }
                if (count == 0) {
                    throw new Exception();
                }
            } while (flag);

            do {
                flag = true;
                switch (editOption()) {
                    case 1:
                        String nName = InputHandler.getString("Enter student's name: ", "Not empty! Try again.");
                        if (nName == null) {
                            throw new Exception();
                        }
                        find(nId).setName(nName);
                        break;
                    case 2:
                        String nMajor = InputHandler.getString("Enter student's major: ", "Invalid major format! Try again. (SE, SB, GD, MC)", "^(SE)|(SB)|(GD)|(MC)$");
                        if (nMajor == null) {
                            throw new Exception();
                        }
                        find(nId).setMajor(nMajor);
                        break;
                    case 3:
                        String nEmail = InputHandler.getString("Enter student's email: ", "Invalid email! Try again. (contains \"@fpt.edu.vn\" )", "^\\w\\S*(@fpt\\.edu\\.vn)$");
                        if (nEmail == null) {
                            throw new Exception();
                        }
                        find(nId).setEmail(nEmail);
                        break;
                    case 4:
                        String nPhone = InputHandler.getString("Enter student's phone number: ", "Invalid phone number! Try again.", "^(84|0[3|5|7|8|9])+([0-9]{8})\\b");
                        if (nPhone == null) {
                            throw new Exception();
                        }
                        find(nId).setPhone(nPhone);
                        break;
                    case 5:
                        String nPassport = InputHandler.getString("Enter student's passport: ", "Not empty! Try again.");
                        if (nPassport == null) {
                            throw new Exception();
                        }
                        find(nId).setPassport(nPassport);
                        break;
                    case 6:
                        String nAddress = InputHandler.getString("Enter student's address: ", "Not empty! Try again.");
                        if (nAddress == null) {
                            throw new Exception();
                        }
                        find(nId).setAddress(nAddress);
                        break;
                    case 7:
                        flag = false;
                        break;
                }
            } while (flag);

        } catch (Exception e) {
            System.out.println("Edit failure!");
        }
    }

    /**
     * This method returns an ArrayList of strings.
     *
     * @return An ArrayList of strings.
     */
    public ArrayList<String> toStringArray() {
        ArrayList<String> ret = new ArrayList<>();
        entrySet().forEach((entry) -> {
            ret.add(entry.getValue().toString());
        });
        return ret;
    }

    /**
     * This method finds a student by their ID.
     *
     * @param id The ID of the student.
     * @return The student with the given ID.
     */
    private Students find(String id) {
        return get(id);
    }

    /**
     * This method displays a menu of options for editing a student's
     * information.
     *
     * @return an integer representing the user's choice of which field to edit.
     */
    private int editOption() {
        Menu menu = new Menu("Which fields of this student would you like to edit?");
        menu.addOption("Name");
        menu.addOption("Major");
        menu.addOption("Email");
        menu.addOption("Phone");
        menu.addOption("Passport");
        menu.addOption("Address");
        menu.addOption("End edit");
        menu.print();
        return menu.getChoice();
    }
}
