import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    int size;

    // Default constructor
    MyList() {
        this.head = null;
        this.tail=null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
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
     *      line k (for style), 
     *      line k+1 (for size), and
     *      line k+2 (for color)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void addLast(String xStyle, int xSize, int xColor) {
        Node p = new Node(new Item(xStyle,xSize,xColor)); 
        if(p.getInfo().style.startsWith("B")) { return; }
        else {
            if(isEmpty()) { head = tail = p; size++; }
            else { tail.next = p; tail = p; size++; }       
        }
    }
    
    void loadData1(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for(int i = 0; i < n; i++) 
            addLast(a[i],b[i],c[i]);
    }
    
    void loadData2(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the list
        for(int i = 0; i < n; i++) 
            addFirst(a[i],b[i],c[i]);
    }
   
    /**
     * Question 1: implement the 'addFirst' method that inserts a new Node 
     * into the list's head.
     * The output of this method will be written into the file 'f1.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: with the content given in the file 'data.txt', the content of 
     * 'f1.txt' after insertion should be:
     *      (G,-3,2) (F,4,-7) (E,7,9) (D,2,4) (C,6,5) (B,5,3) (A,9,8) 
     * @param xStyle the style of the input Item
     * @param xSize the size of the input Item
     * @param xColor the color of the input Item
     */
    void addFirst(String xStyle, int xSize, int xColor) {
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------    
    }
    
    /**
     * Do NOT modify this method
     * This is a helper method for writing data (node's info) stored in the 
     * linked list to file 
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
        
        // Declare an Item Objects which will be used for the Question 2
        Item z;
        z = new Item("Z",9,12);
        
    /**
     * Question 2: use Item z declared above, write your code to insert the 
     * node with info = z into the position that is after the first node that 
     * has Item's style start with 'E'.
     * The output of this method will be written into the file 'f2.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: if the linked list before insertion is 
     *      (C,9,8) (D,6,3) (E,8,5) (F,5,4) (I,4,9) 
     * then the content of 'f2.txt' after insertion is 
     *      (C,9,8) (D,6,3) (E,8,5) (Z,9,12) (F,5,4) (I,4,9)
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
    * Question 3: Find the first node in the linked list that has Item's size 
    * lager than 8, if such a node is found, then set the color of Item in 
    * this node to 99. 
    * The output of this method will be written into the file 'f3.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: if the linked list before change is  
    *   (C,8,6) (D,3,5) (E,9,2) (F,5,8) (G,9,7) (H,6,8) (I,7,3) 
    * then the content of 'f3.txt' after change is  
    *   (C,8,6) (D,3,5) (E,9,99) (F,5,8) (G,9,7) (H,6,8) (I,7,3) 
    */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        ftraverse(f);
        f.close();
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
    * Question 4: delete the first node in the linked list with Item' size = 6. 
    * The output of this method will be written into the file 'f4.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: if the linked list before sorting is     
    *       (C,1,2) (D,10,3) (E,2,15) (F,11,6) (I,6,14) (J,11,15) (K,7,9)  
    * then the content of 'f4.txt' after sorting is  
    *       (C,1,2) (D,10,3) (E,2,15) (F,11,6) (J,11,15) (K,7,9) 
    */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}

