// =========================================================
// Do NOT modify this file 
// =========================================================
import java.util.Scanner;

public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    
    public static int inputInt(String msg) {
        int data;
        do {
            System.out.print(msg + ": ");
            data = Integer.parseInt(sc.nextLine());
        }
        while(data<=0);
        return data;
    }
    
    public static int inputInt(String msg, int min, int max) {
        if(min>max) {
            int t=min; min=max; max=t;
        }
        int data;
        do {
            System.out.print(msg + ": ");
            data = Integer.parseInt(sc.nextLine());
        }
        while(data<min || data>max);
        return data;
    }
    
    public static float inputFloat(String msg) {
        float data;
        do {
            System.out.print(msg + ": ");
            data = Float.parseFloat(sc.nextLine());
        }
        while(data<=0);
        return data;
    }
    
    public static double inputDouble(String msg) {
        double data;
        do {
            System.out.print(msg + ": ");
            data = Double.parseDouble(sc.nextLine());
        }
        while(data<=0);
        return data;
    }
    
    public static String inputStr(String msg) {
        System.out.print(msg + ": ");
        String data = sc.nextLine().toUpperCase().trim();
        return data;
    }
 
    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg + ": ");
            data = sc.nextLine().toUpperCase().trim();
        } while(data.length()==0);
        return data;
    } 
 
    public static String inputPattern(String msg, String pattern) {
        String data;
        do {
            System.out.print(msg + ": ");
            data = sc.nextLine().trim();
        }
        while(!data.matches(pattern));
        return data;
    }     
}
// =========================================================
// Do NOT modify this file 
// =========================================================