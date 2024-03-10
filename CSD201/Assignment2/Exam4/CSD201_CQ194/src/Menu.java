// =========================================================
// Do NOT modify this file 
// =========================================================
import java.util.*;
import java.util.Scanner;

public class Menu extends ArrayList<String> implements I_Menu{
    public Menu(){
        super();
    }
    
    @Override
    public void addItem(String s){
        this.add(s);
        return;
    }
    
    @Override
    public int getChoice(){
        int result=0;
        for (int i=0; i<this.size(); i++)
            System.out.println((i+1) + ". " + this.get(i));
        System.out.println("____________________________");
        System.out.println();
        System.out.print("Select 1 ... 6: ");
        Scanner sc = new Scanner(System.in);
        result = Integer.parseInt(sc.nextLine()); // get user choice

        return result;
    }
}
// =========================================================
// Do NOT modify this file 
// =========================================================