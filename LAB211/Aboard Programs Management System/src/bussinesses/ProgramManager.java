/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinesses;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import models.Programs;
import tools.InputHandler;
import tools.Menu;

/**
 *
 * @author Admin
 */
public class ProgramManager extends HashMap<String, Programs> {

    private boolean flag;
    private final String dateFormat = "dd/MM/yyyy";

    /**
     * This method displays the contents of a ProgramManager object.
     */
    public void display() {
        entrySet().stream().map((entry) -> entry.getValue()).forEachOrdered((p) -> {
            display(p);
        });
    }

    /**
     * This method adds a new program to the ProgramManager object.
     */
    public void add() {
        try {
            String nId = null;
            int count = 5;
            do {
                flag = true;
                nId = InputHandler.getString("Enter program's ID: ", "Not empty! Try again.");
                if (nId == null) {
                    throw new Exception();
                }
                if (find(nId) != null) {
                    System.out.println("Program's ID already exists!");
                    count--;
                } else {
                    flag = false;
                }
                if (count == 0) {
                    throw new Exception();
                }
            } while (flag);

            String nName = InputHandler.getString("Enter program's name: ", "Not empty! Try again.");
            if (nName == null) {
                throw new Exception();
            }

            String nTime = InputHandler.getString("Enter program's time: ", "Invalid format time! Try again. (January, March, May, July, September, November)",
                    "^(January)|(March)|(May)|(July)|(September)|(November)$");
            if (nTime == null) {
                throw new Exception();
            }

            Date nBegin = InputHandler.getDate("Enter begin date to register: ", "Invalid date format! Try again. (" + dateFormat + ")", dateFormat);
            if (nBegin == null) {
                throw new Exception();
            }

            Date nEnd = InputHandler.getDate("Enter end date to register: ", "Invalid date format! Try again. (" + dateFormat + ")", dateFormat);
            if (nEnd == null) {
                throw new Exception();
            }

            String nDay = InputHandler.getString("Enter the number of days of the program: ", "Invalid number of days! Try again. (30-40 days)", "^\\d*([3][0-9]|40)$");
            if (nDay == null) {
                throw new Exception();
            }

            String nLocation = InputHandler.getString("Enter program's location: ", "Not empty! Try again.");
            if (nLocation == null) {
                throw new Exception();
            }

            String nCost = InputHandler.getString("Enter program's cost: ", "Not empty! Try again.", "(\\d*\\.\\d*)|\\d+$");
            if (nCost == null) {
                throw new Exception();
            }

            String nContent = InputHandler.getString("Enter program's content: ", "Invalid file content!", "^\\w.*(\\.doc|\\.pdf)$");
            if (nContent == null) {
                throw new Exception();
            }

            put(nId, new Programs(nId, nName, nTime, nBegin, nEnd, Integer.parseInt(nDay), nLocation, Double.parseDouble(nCost), nContent));
        } catch (Exception e) {
            System.out.println("Add failure!");
        }
    }

    /**
     * This method edits an existing program in the ProgramManager object.
     */
    public void edit() {
        try {
            String nId = null;
            int count = 5;
            do {
                flag = true;
                nId = InputHandler.getString("Enter program's ID: ", "Not empty! Try again.");
                if (nId == null) {
                    throw new Exception();
                }
                if (find(nId) == null) {
                    System.out.println("Program's ID does not exists!");
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
                        String nName = InputHandler.getString("Enter program's name: ", "Not empty! Try again.");
                        if (nName == null) {
                            throw new Exception();
                        }
                        find(nId).setName(nName);
                        break;
                    case 2:
                        String nTime = InputHandler.getString("Enter program's time: ", "Invalid format time! Try again. (January, March, May, July, September, November)",
                                "^(January)|(March)|(May)|(July)|(September)|(November)$");
                        if (nTime == null) {
                            throw new Exception();
                        }
                        find(nId).setTime(nTime);
                        break;
                    case 3:
                        Date nBegin = InputHandler.getDate("Enter begin date to register: ", "Invalid date format! Try again. (" + dateFormat + ")", dateFormat);
                        if (nBegin == null) {
                            throw new Exception();
                        }
                        find(nId).setBeginDate(nBegin);
                        break;
                    case 4:
                        Date nEnd = InputHandler.getDate("Enter end date to register: ", "Invalid date format! Try again. (" + dateFormat + ")", dateFormat);
                        if (nEnd == null) {
                            throw new Exception();
                        }
                        find(nId).setEndDate(nEnd);
                        break;
                    case 5:
                        String nDay = InputHandler.getString("Enter the number of days of the program: ", "Invalid number of days! Try again. (30-40 days)", "^\\d*([3][0-9]|40)$");
                        if (nDay == null) {
                            throw new Exception();
                        }
                        find(nId).setDays(Integer.parseInt(nDay));
                        break;
                    case 6:
                        String nLocation = InputHandler.getString("Enter program's location: ", "Not empty! Try again.");
                        if (nLocation == null) {
                            throw new Exception();
                        }
                        find(nId).setLocation(nLocation);
                        break;
                    case 7:
                        String nCost = InputHandler.getString("Enter program's cost: ", "Not empty! Try again.", "(\\d*\\.\\d*)|\\d+$");
                        if (nCost == null) {
                            throw new Exception();
                        }
                        find(nId).setCost(Integer.parseInt(nCost));
                        break;
                    case 8:
                        String nContent = InputHandler.getString("Enter program's content: ", "Not empty! Try again.", "^\\w.*(\\.doc|\\.pdf)$");
                        if (nContent == null) {
                            throw new Exception();
                        }
                        find(nId).setContent(nContent);
                        break;
                    case 9:
                        flag = false;
                        break;
                }
            } while (flag);
        } catch (Exception e) {
            System.out.println("Edit failure!");
        }
    }

    /**
     * This method searches for a program in the ProgramManager object.
     */
    public void search() {
        try {
            String nId = null;
            int count = 5;
            do {
                flag = true;
                nId = InputHandler.getString("Enter program's ID: ", "Not empty! Try again.");
                if (nId == null) {
                    throw new Exception();
                }
                Programs p = find(nId);
                if (p == null) {
                    System.out.println("Program's ID does not exists!");
                    count--;
                } else {
                    display(p);
                    flag = false;
                }
                if (count == 0) {
                    throw new Exception();
                }
            } while (flag);
        } catch (Exception e) {
            System.out.println("Search failure!");
        }
    }

    /**
     * This method returns an ArrayList of Strings containing the contents of a
     * ProgramManager object.
     *
     * @return an ArrayList of Strings containing the contents of a
     * ProgramManager object.
     */
    public ArrayList<String> toStringArray() {
        ArrayList<String> ret = new ArrayList<>();
        entrySet().forEach((entry) -> {
            ret.add(entry.getValue().toString());
        });
        return ret;
    }

    /**
     * This method searches for a program in the ProgramManager object.
     *
     * @param id a String containing the ID of the program to search for.
     * @return a Programs object containing the program's information.
     */
    private Programs find(String id) {
        return get(id);
    }

    /**
     * This method displays the contents of a Programs object.
     *
     * @param p a Programs object containing the program's information.
     */
    private void display(Programs p) {
        ArrayList d = new ArrayList();
        d.add("ID and Name");
        d.add("Time");
        d.add("Day");
        d.add("Location");
        d.add("Cost");
        d.add("Content");
        for (int i = 0; i < d.size(); i++) {
            switch (i) {
                case 0:
                    System.out.format("%d. %s: %s-%s", i, d.get(i), p.getId(), p.getName());
                    System.out.println("\n");
                    break;
                case 1:
                    System.out.format("%d. %s: ", i, d.get(i));
                    System.out.println("");
                    break;
                case 2:
                    System.out.format("%d. %s: %d days", i, d.get(i), p.getDays());
                    System.out.println("");
                    break;
                case 3:
                    System.out.format("%d. %s: %s", i, d.get(i), p.getLocation());
                    System.out.println("");
                    break;
                case 4:
                    System.out.format("%d. %s: %f", i, d.get(i), p.getCost());
                    System.out.println("");
                    break;
                case 5:
                    System.out.format("%d. %s: %s", i, d.get(i), p.getContent());
                    System.out.println("");
                    break;
            }
        }
        System.out.println("");
    }

    /**
     * This method displays a menu of options for editing a program in the
     * ProgramManager object.
     *
     * @return an integer representing the user's choice.
     */
    private int editOption() {
        Menu menu = new Menu("Which fields of this program would you like to edit?");
        menu.addOption("Name");
        menu.addOption("Time");
        menu.addOption("From Registration Date");
        menu.addOption("End Registration Date");
        menu.addOption("Days");
        menu.addOption("Location");
        menu.addOption("Cost");
        menu.addOption("Content");
        menu.addOption("End edit");
        menu.print();
        return menu.getChoice();
    }
}
