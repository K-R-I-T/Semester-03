// =========================================================
// Do NOT modify this file 
// =========================================================
import java.io.*;
import java.util.*;

class Main {
    private static void printMenu() {
        System.out.println("=============MENU=============");
        System.out.println("1. Test f1 (1 mark)");
        System.out.println("2. Test f2 (1 mark)");
        System.out.println("3. Test f3 (1 mark)");
        System.out.println("4. Test f4 (1 mark)");
        System.out.println("0. Exit");
        System.out.println("==============================");
        System.out.print("Enter your choice [0 --> 4]: ");
    }
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        MyList t = new MyList();
        while(true) {
            //Display the menu contains a list of possibble choices
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 0:
                    return;
                case 1: 
                    t.f1();
                    System.out.println("Your output:");
                    Lib.viewFile("f1.txt");
                    break;
                case 2: 
                    t.f2();
                    System.out.println("Your output:");
                    Lib.viewFile("f2.txt");
                    break;
                case 3: 
                    t.f3();
                    System.out.println("Your output:");
                    Lib.viewFile("f3.txt");
                    break;
                case 4: 
                    t.f4();
                    System.out.println("Your output:");
                    Lib.viewFile("f4.txt");
                    break;
                default: 
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }     
}
// =========================================================
// Do NOT modify this file 
// =========================================================