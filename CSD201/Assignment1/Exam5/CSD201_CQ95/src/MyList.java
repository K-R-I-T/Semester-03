import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    // default constructor
    public MyList() {head = tail = null;}
    
    // return true if Mylist is empty otherwise return false
    public boolean isEmpty() {return head == null;} 
    
    public void clear() {head = tail = null;}

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        // write data in the node p to the file f
        while(p != null) {
            f.writeBytes(p.getInfo() + " "); 
            p = p.next;
        }
        
        f.writeBytes("\r\n");
    }
    
    /**
     * Do NOT modify this method
     * Load 3 lines of data from file: 
     *      line k (for owner), 
     *      line k+1 (for price), and
     *      line k+2 (for color)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void addFirst(String xOwner, int xPrice, int xColor) {
        Node p = new Node(new Car(xOwner,xPrice,xColor));      
        if(isEmpty()) { head = tail = p; }
        else { p.next = head; head = p; }  
    }
    void loadData1(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for(int i = 0; i < n; i++) 
            addFirst(a[i],b[i],c[i]);
    }
    void loadData2(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for(int i = 0; i < n; i++) 
            addLast(a[i],b[i],c[i]);
    }
   
    /**
     * Question 1: implement the 'addLast' method that inserts a new Node 
     * into the list's tail if the attribute 'owner'of a Car does NOT 
     * start with 'D'.
     * The output of this method will be written into the file 'f1.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: with the content given in the file 'data.txt', the content of 
     * 'f1.txt' after insertion should be: 
     *      (A,9,8) (B,5,3) (C,6,5) (E,7,9) (F,4,-7) (G,-3,2) 
     * @param xOwner the owner of the input Car
     * @param xPrice the price of the input Car
     * @param xColor the color of the input Car
     */
    void addLast(String xOwner, int xPrice, int xColor) {
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------  
    }
    
    /**
     * Do NOT modify this method
     * This is a helper method for writing data (node's info) stored in 
     * the linked list to file 
     * @throws Exception 
     */
    void f1() throws Exception {
        clear();
        loadData2(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        f.close();
    }
    
    // This method is used for Question 2
    void f2() throws Exception {
        clear();
        loadData1(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        
        // Declare two Car Objects which will be used for the Question 2
        Car x, y;
        x = new Car("X",5,7);
        y = new Car("Y",4,6);
        
    /**
     * Question 2: use Car x and Car y declared above, write your code to:
     *      (1) insert the node with info = x into the second position 
     *          of the list, and
     *      (2) insert the node with info = y into the fourth position 
     *          of the list
     * The output of this method will be written into the file 'f2.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: if the linked list before insertion is 
     *      (I,4,9) (F,5,4) (E,8,5) (B,6,3) (A,9,8) 
     * then the content of 'f2.txt' after insertion is
     *      (I,4,9) (X,5,7) (F,5,4) (Y,4,6) (E,8,5) (B,6,3) (A,9,8) 
     */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------     
        ftraverse(f); // write list's data to file
        f.close();
    } 
    
    // This method is used for Question 3
    void f3() throws Exception {
        clear();
        loadData1(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
    /**
    * Question 3: Find the first node in the linked list that has Car's price 
    * less than 6, if such a node is found, then set the color of Car in this 
    * node to 55. 
    * The output of this method will be written into the file 'f3.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: if the linked list before change is  
    *       (I,7,3) (H,6,8) (G,9,7) (F,5,8) (E,9,2) (B,3,5) (A,8,6) 
    * then the content of 'f3.txt' after change is  
    *       (I,7,3) (H,6,8) (G,9,7) (F,5,55) (E,9,2) (B,3,5) (A,8,6) 
    */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void sortByPrice() {
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
    }
    
    // This method is used for Question 4
    void f4() throws Exception {
        clear();
        loadData1(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
    /**
    * Question 4: Sort the linked list in an descending order according to 
    * Car's price. Hint: Create a new method to sort the linked list, then call 
    * the created method in f4().
    * The output of this method will be written into the file 'f4.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: if the linked list before sorting is 
    *       (K,7,9) (J,11,15) (I,6,14) (F,11,6) (E,2,15) (B,10,3) (A,1,2)  
    * then the content of 'f4.txt' after sorting is  
    *       (J,11,15) (F,11,6) (B,10,3) (K,7,9) (I,6,14) (E,2,15) (A,1,2) 
    */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        // Hint: create a new method to sort the linked list, then call the 
        // created method here
//        sortByPrice();
        
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}

