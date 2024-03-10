import java.io.*;

public class BSTree {
    Node root;
    
    // Default constructor
    BSTree() {
        this.root = null;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public void clear() {
        this.root = null;
    }
    
    public void visit(Node p) {
        System.out.print("p.info: ");
        if(p != null) System.out.println(p.getInfo() + " ");
    }
    
    public void fvisit(Node p, RandomAccessFile f) throws Exception {
        if(p != null) 
            f.writeBytes(p.getInfo() + " ");
    }
    
    public void breadth(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while(!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r,f);
            
            if(r.left != null) 
                q.enqueue(r.left);
            
            if(r.right != null) 
                q.enqueue(r.right);
        }
    }
    
    public void breadth2(Node p, RandomAccessFile f) throws Exception {
        if(p != null) {
            Queue q = new Queue();
            q.enqueue(p);
            Node r;
            boolean flag = q.isEmpty();
            while (!flag) {
                r = q.dequeue();
                if (r.getInfo().getColor() > 6) {
                    fvisit(r, f);
                }
                if(r.left != null) 
                    q.enqueue(r.left);
                if(r.right != null) 
                    q.enqueue(r.right);
            }
        }
    }
    
    public void preOrder(Node p, RandomAccessFile f) throws Exception {    
        if(p == null) 
            return;       
        fvisit(p,f);
        preOrder(p.left,f);
        preOrder(p.right,f);
    }
    
    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;      
        inOrder(p.left,f);
        fvisit(p,f);
        inOrder(p.right,f);
    }
    
    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if(p == null) 
            return;      
        postOrder(p.left,f);
        postOrder(p.right,f);
        fvisit(p,f);
     }

    /**
     * Do NOT modify this method
     * Load 3 lines of data from file: 
     *      line k (for style), and
     *      line k+1 (for size), and
     *      line k+2 (for color)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String [] a = Lib.readLineToStrArray("data.txt", k);
        int [] b = Lib.readLineToIntArray("data.txt", k+1);
        int [] c = Lib.readLineToIntArray("data.txt", k+2);       
        int n = a.length;
        // insert the new Node(a[i], b[i], c[i]) into the BST
        for(int i=0;i<n;i++)           
            insert(a[i],b[i],c[i]); 
    }
    
    Node insertRec(Node p, Item x) {
         if (p==null){
            return new Node(x);
        } else if (p.getInfo().getSize()>x.getSize()){
            p.left = insertRec(p.left, x);
        } else {
            p.right = insertRec(p.right, x);
        }
        return p;
    }

    /**
    * Question 1: use Item’s size as the key attribute when building a BST.
    * Implement the 'insert' method that inserts a new Node into the BST if 
    * the attribute style of Item does NOT start with 'B'.
    * The output of this method will be written into the file 'f1.txt'. 
    * Therefore you should open this file to see/test your code output.
    * Example: with the content given in the file 'data.txt', the content of 
    * 'f1.txt' after insertion should be:
    *           (A,7,9) (C,4,3) (D,8,6) (E,2,5) (Y,6,-7) (F,-6,7) 
    *           (F,-6,7) (E,2,5) (C,4,3) (Y,6,-7) (A,7,9) (D,8,6)
    * @param xStyle the style of the input Item
    * @param xSize the size of the input Item
    * @param xColor the color of the input Item
    */
    void insert(String xStyle, int xSize, int xColor) {
        //Hint: create a recursive method to insert called insertRec then call 
        //it here. For example:
                if (!xStyle.startsWith("B"))
                    this.root = insertRec(this.root, 
                            new Item(xStyle,xSize,xColor));      
    }
    
    /* computes number of nodes in tree */
    int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }
    
    void searchLeaves(Node p) {
        if (p != null) {
            if (p.left != null || p.right != null) {
                p.getInfo().setColor(p.getInfo().getColor() - 1);
            }
            searchLeaves(p.left);
            searchLeaves(p.right);
        }
    }
    
    /**
     * Do NOT modify this method
     * This is a helper method for writing data (node's info) stored in the 
     * BST to file 
     * @throws Exception 
     */
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        breadth(root,f);
        f.writeBytes("\r\n");
        inOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
  
    // This method is used for Question 2
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
        breadth(root,f);
        f.writeBytes("\r\n");
        
    /**
     * Question 2: Perform breadth-first-search on the BST, but ONLY visit 
     * nodes that has Item's color lager than 6.
     * Hint: This method is similar to the method 'breadth' (provided in this 
     * class already). You should create a new method which body is similar 
     * to 'breadth' for doing BFS but considering only color lager than 6.
     * The output f2() will be written into the file 'f2.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: With the data provided in 'data.txt', the content of 'f2.txt' 
     * after running this method is 
     * (C,8,2) (D,6,1) (E,9,4) (F,2,3) (G,7,8) (H,1,7) (I,3,9) (J,5,5) (K,4,6) 
     * (G,7,8) (H,1,7) (I,3,9)
     */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        breadth2(root,f);
        
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        
        f.writeBytes("\r\n");
        f.close();
    }  

    // This method is used for Question 3
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
    /**
     * Question 3: Insert into the current tree a new Item which style = 'Z'
     * , Size = 15, color = k, where k is size of the current tree before 
     * insertion. Hint:  
     *      (1) Implement a method to calculate the size or number 
     *          of nodes in tree
     *      (2) Insert the new Item('Z', 15, Tree Size) into the 
     *          current tree
     * The output f3() will be written into the file 'f3.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: With the data provided in 'data.txt', the content of 'f3.txt' 
     * after running this method is:
     * (H,1,7) (K,4,6) (J,5,5) (I,3,9) (F,2,3) (G,7,8) (D,6,1) (E,9,4) (C,8,2)
     * (H,1,7) (K,4,6) (J,5,5) (I,3,9) (F,2,3) (G,7,8) (D,6,1) (Z,15,9) (E,9,4) (C,8,2)
     */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        insert("Z",15,size(root)); 

        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }  
    
    // This method is used for Question 4
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        postOrder(root,f);
        f.writeBytes("\r\n");
    /**
     * Question 4: Decrease the Item's color of all Nodes that are not 
     * leaves by 1. Hint: Leaf nodes have neither left child nor right child
     * The output f4() will be written into the file 'f4.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: With the data provided in 'data.txt', the content of 'f4.txt' 
     * after running this method is: 
     * (H,1,7) (K,4,6) (J,5,5) (I,3,9) (F,2,3) (G,7,8) (D,6,1) (E,9,4) (C,8,2)
     * (H,1,7) (K,4,6) (J,5,4) (I,3,8) (F,2,2) (G,7,8) (D,6,0) (E,9,4) (C,8,1) 
     */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        searchLeaves(root);
        
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        postOrder(root,f);
        f.writeBytes("\r\n");
        f.close();
    }
}
