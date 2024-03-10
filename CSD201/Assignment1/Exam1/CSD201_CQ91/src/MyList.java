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
     *      line k (for name), 
     *      line k+1 (for isbn), and
     *      line k+2 (for price)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void loadData1(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for(int i = 0; i < n; i++) 
            addFirst(a[i],b[i],c[i]);
    }
    
    void addLast(String xName, int xISBN, int xPrice) {
        Node p = new Node(new Book (xName,xISBN,xPrice)); 
        if(isEmpty()) { head = tail = p; }
        else { tail.next = p; tail = p; } 
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
     * Question 1: implement the 'addFirst' method that inserts a new Node 
     * into the list's head if the attribute 'name' of a Book does NOT 
     * start with 'D'.
     * The output of this method will be written into the file 'f1.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: with the content given in the file 'data.txt', the content of 
     * 'f1.txt' after insertion should be: 
     *      (G,-3,2) (F,4,-7) (E,7,9) (C,6,5) (B,5,3) (A,9,8) 
     * @param xName the name of the input Book
     * @param xISBN the isbn of the input Book
     * @param xPrice the price of the input Book
     */
    
    void addFirst(String xName, int xISBN, int xPrice) {
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
        loadData1(1);
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
        loadData2(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
        
        // Declare two Book Objects which will be used for the Question 2
        Book x, y;
        x = new Book("X",1,2);
        y = new Book("Y",3,4);
        
    /**
     * Question 2: use Book x and Book y declared above, write your code to:
     *      (1) insert the node with info = x into the list's tail of 
     *          the list, and
     *      (2) insert the node with info = y into the third position 
     *          of the list
     * The output of this method will be written into the file 'f2.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: if the linked list before insertion is 
     *      (A,9,8) (B,6,3) (E,8,5) (F,5,4) (I,4,9) 
     * then the content of 'f2.txt' after insertion is 
     *      (A,9,8) (B,6,3) (Y,3,4) (E,8,5) (F,5,4) (I,4,9) (X,1,2) 
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
        loadData2(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
    /**
    * Question 3: Find the first node in the linked list that has Book's name 
    * start with 'F', if such a node is found, then set the price of Book in 
    * this node to 125. 
    * The output of this method will be written into the file 'f3.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: if the linked list before change is 
    *       (A,8,6) (B,3,5) (E,9,2) (F,5,8) (G,9,7) (H,6,8) (I,7,3) 
    * then the content of 'f3.txt' after change is  
    *       (A,8,6) (B,3,5) (E,9,2) (F,5,125) (G,9,7) (H,6,8) (I,7,3) 
    */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void sortByISBN() {
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
    }
    
    // This method is used for Question 1.4
    void f4() throws Exception {
        clear();
        loadData2(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        ftraverse(f);
    /**
    * Question 4: Sort the linked list in an ascending order according to 
    * Book's isbn. Hint: Create a new method to sort the linked list, then 
    * call the created method in f4().
    * The output of this method will be written into the file 'f4.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: if the linked list before sorting is           
    *       (A,1,2) (B,10,3) (E,2,15) (F,11,6) (I,6,14) (J,11,15) (K,7,9)  
    * then the content of 'f4.txt' after sorting is  
    *       (A,1,2) (E,2,15) (I,6,14) (K,7,9) (B,10,3) (J,11,15) (F,11,6)
    */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        // Hint: create a new method to sort the linked list, then call the 
        // created method here
//        sortByISBN();
        
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}

