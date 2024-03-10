/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {
   Node root;
   BSTree() {root=null;}
   boolean isEmpty() {
       return(root==null);
      }
   void clear() {
       root=null;
      }
   void visit(Node p) {
      System.out.print("p.info: ");
      if(p != null) System.out.println(p.info + " ");
     }
   void fvisit(Node p, RandomAccessFile f) throws Exception {
      if(p != null) f.writeBytes(p.info + " ");
     }
   void breadth(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void preOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }

   void loadData(int k) { //do not edit this function
      String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xSea, int xSail, int xPaddle) {
    //You should insert here statements to complete this function

      if (xSea.charAt(0) != 'B') {
        Boat x = new Boat(xSea, xSail, xPaddle);
        root = insert(root, x);
      }
  
   }
  
  Node insert(Node p, Boat x) {
      if (p == null) {
          return new Node(x);
      }
      if (x.sail < p.info.sail) {
          p.left = insert(p.left, x);
      } else if (x.sail > p.info.sail) {
          p.right = insert(p.right, x);
      }
      return p;
  }

//Do not edit this function. Your task is to complete insert function above only.
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
  
//=============================================================
 void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

     breadth2(root,f);

    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }  

 void breadth2(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
         if (r.info.paddle > 5) {
             fvisit(r,f);
         }
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
//=============================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

      ArrayList<Boat> l = new ArrayList<>();
      inOrder2(l, root);
      Boat x = l.get(2);
      deleteByCopy(x);

    //------------------------------------------------------------------------------------
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  
  void inOrder2(ArrayList l ,Node p) {
      if(p==null) return;
      inOrder2(l, p.left);
      l.add(p.info);
      inOrder2(l, p.right);
     }
  
  void deleteByCopy(Boat x) {
      Node temp, p;
      temp = null;
      p = root;
      while (p!= null) {
          if (p.info == x) {
              break;
          }
          temp=p;
          if (x.sail < p.info.sail) {
              p = p.left;
          } else {
              p = p.right;
          }
      }
      if (p == null) {
          return;
      }
      if (p.left == null && p.right == null) {
            if (temp == null) {
                root = null;
                return;
            }
            if (p == temp.left) {
                temp.left = null;
            } else {
                temp.right = null;
            }
        }
      if (p.left != null && p.right == null) {
            if (temp == null) {
                root = p.left;
                return;
            }
            if (p == temp.left) {
                temp.left = p.left;
            } else {
                temp.right = p.left;
            }
        }
        if (p.left == null && p.right != null) {
            if (temp == null) {
                root = p.right;
                return;
            }
            if (p == temp.left) {
                temp.left = p.right;
            } else {
                temp.right = p.right;
            }
        }
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (frp == null) {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
  }

//=============================================================
 void f4() throws Exception {
    clear();
    loadData(13);;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
 
    ArrayList<Boat> l = new ArrayList<>();
      inOrder2(l, root);
      Boat x = l.get(2);
     
    //------------------------------------------------------------------------------------
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
   }
 
 void rotate() {
     
 }
 
 }
