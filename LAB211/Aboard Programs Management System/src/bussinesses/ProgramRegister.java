/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesses;

import java.util.ArrayList;
import java.util.Date;
import models.Programs;
import models.Students;
import tools.DateModifier;
import tools.FileHandler;
import tools.InputHandler;

/**
 *
 * @author Admin
 */
public class ProgramRegister {

    private boolean flag;

    /**
     * This method registers a student for a program.
     *
     * @param pm a ProgramManager object containing the program's information.
     * @param sm a StudentManager object containing the student's information.
     * @return a String containing the path of the registration form.
     */
    public String register(ProgramManager pm, StudentManager sm) {
        String path = null;
        try {
            String pId;
            Programs p;
            int count = 5;
            do {
                flag = true;
                pId = InputHandler.getString("Enter program's ID: ", "Not empty! Try again.");
                if (pId == null) {
                    throw new Exception();
                }
                if ((p = pm.get(pId)) != null) {
                    flag = false;
                } else {
                    System.out.println("Program's ID does not exists!");
                    count--;
                }
                if (count == 0) {
                    throw new Exception();
                }
            } while (flag);

            String sId;
            Students s;
            count = 5;
            do {
                flag = true;
                sId = InputHandler.getString("Enter student's ID: ", "Invalid ID format! Try again. ((SE, SB, GD, MC)000)", "^\\w*([SE]|[SB]|[GD]|[MC])\\d{3}$");
                if (sId == null) {
                    throw new Exception();
                }
                if ((s = sm.get(sId)) != null) {
                    flag = false;
                } else {
                    System.out.println("Student's ID does not exists!");
                    count--;
                }
                if (count == 0) {
                    throw new Exception();
                }
            } while (flag);

            Date rDate = InputHandler.getDate("Enter registration date: ", "Invalid date format! Try again. (dd/MM/yyyy)", "dd/MM/yyyy");
            if (rDate == null) {
                throw new Exception();
            }
            if (!DateModifier.isInRangeDate(pm.get(pId).getBeginDate(), pm.get(pId).getEndDate(), rDate)) {
                System.out.println("Registration date is invalid!");
                throw new Exception();
            }

            String pEmail = InputHandler.getString("Enter parent's email: ", "Invalid email! Try again. (contains \"@fpt.edu.vn\" )", "^\\w\\S*(@gmail\\.com)$");
            if (pEmail == null) {
                throw new Exception();
            }

            String pPhone = InputHandler.getString("Enter parent's phone number: ", "Invalid phone number! Try again.", "^(84|0[3|5|7|8|9])+([0-9]{8})\\b");
            if (pPhone == null) {
                throw new Exception();
            }
            path = initFilename(p, s);
            createForm(path, p, s, rDate, pEmail, pPhone);
        } catch (Exception e) {
            System.out.println("Register failure!");
        }
        return path;
    }

    /**
     * This method creates a registration form for a student who has registered
     * for a program.
     *
     * @param path a String containing the path of the registration form.
     * @param p a Programs object containing the program's information.
     * @param s a Students object containing the student's information.
     * @param rDate a Date object containing the registration date.
     * @param pEmail a String containing the email of the parent.
     * @param pPhone a String containing the phone number of the parent.
     */
    private void createForm(String path, Programs p, Students s, Date rDate, String pEmail, String pPhone) {
        path = "\\src\\files\\RegistrationForm\\" + path;
        ArrayList<String> dta = new ArrayList<>();
        dta.add("				 Aboard Program Registration Form");
        dta.add("Information Student:");
        dta.add(String.format("Student id: %-7s Student name: %s", s.getId(), s.getName()));
        dta.add(String.format("Major: %-12s Email: %s    Phone: %s    Passport: %s", s.getMajor(), s.getEmail(), s.getPhone(), s.getPassport()));
        dta.add(String.format("Address: %-10s Email of the parents: %s   Phone of the parents: %s", s.getAddress(), pEmail, pPhone));
        dta.add("Information of the aboard program:");
        dta.add(String.format("Program’s id: %-5s Program’s name: %s", p.getId(), p.getName()));
        dta.add(String.format("Time: %-13s Days: %d    Location: %s   Cost: %f$", p.getTime(), p.getDays(), p.getLocation(), p.getCost()));
        dta.add("Information of the registration:");
        dta.add(String.format("Registration date: %s", DateModifier.toDateString(rDate)));
        FileHandler.writeToFileTxt(path, dta);
    }

    /**
     * This method initializes the filename for a registration form.
     *
     * @param p a Programs object containing the program's information.
     * @param s a Students object containing the student's information.
     * @return a String containing the filename of the registration form.
     */
    private String initFilename(Programs p, Students s) {
        String filename = ".txt";
        filename = s.getId() + "_" + p.getId() + filename;
        return filename;
    }
}
