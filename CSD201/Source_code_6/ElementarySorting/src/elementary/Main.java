/*
 *  Elementary Sorting Algorithms.
 */

package elementary;

import java.util.*;

class SimpleSort {
    int [] a; int n;
    
    SimpleSort() {}
    
    SimpleSort(int [] b) {
        int i;
        n = b.length;
        a = new int[n];
        for(i=0; i<n; i++) a[i]= b[i];
    }
    
    void setData(int [] b) {
        int i;
        n = b.length;
        a = new int[n];
        for(i=0; i<n; i++)
            a[i]= b[i];
    }
    
    void setRandom() {
        int i;
        Scanner s = new Scanner(System.in);
        System.out.print(" Enter n = ");
        n = s.nextInt();
        a = new int[n];
        // Create a random number generator,
        // seeds with current time by default:
        Random r = new Random();
        for(i=0; i<n; i++)
            a[i]= r.nextInt(100); //Choose value from 0 to 99
    }
    
    void display() {
        int i;
        for(i=0; i<n; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }
    
    boolean sorted() { // return true if the list is sorted
        for(int i=0; i<n-1; i++)
            if(a[i]>a[i+1]) return(false);
        return(true);
    }

    //Swap element at position i with k
    void swap(int i, int k) {
        int x; x=a[i]; a[i]=a[k]; a[k]=x;
    }

    //Selection Sort
    void selectSort() {
        int i,j,k; int min;
        for(i=0; i<n-1; i++) {
            min=a[i]; k=i;
            for(j=i+1; j<n; j++)
                if(a[j]<min) {k=j; min=a[j];}
            if(k!=i) swap(i,k);
        }
    }
    
//    void selectSort() {
//        for(int i=0; i<n-1; i++)
//            for(int j=i+1; j<n; j++)
//                if(a[j]<a[i]) swap(i,j);
//    }

    //Insertion Sort
    void insertSort() {
        int i,j,x;
        //Bat dau voi day da sx chi co 1 phan tu a[0]
        for(i=1; i<n; i++) {
            x=a[i]; //Chen a[i] vao day da sx a[0],...
            j=i;
            //Keo nut lon hon x len h vi tri
            while(j>0 && x<a[j-1]) {a[j]=a[j-1]; j--;}
            //Chen x vao vi tri phu hop j, vi tri dau tien ma x>=a[j-1]
            a[j]=x;
        }
    }
    
    //Bubble Sort
    void bubbleSort() {
        int i; boolean doicho;
        do {
            doicho=false;
            for(i=0; i<n-1; i++) {
                if(a[i]>a[i+1]) {
                    swap(i,i+1);
                    doicho=true;
                }
            }
        }
        while(doicho);
    }
    
//    void bubbleSort() {
//        for (int i=0; i<n-1; i++)
//            for (int j=0; j<n-i-1; j++)
//                if(a[j]>a[j+1]) swap(j,j+1);
//    }
}

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int choice;
        int [] b = {5,7,11,3,9,2,6};
        SimpleSort t = new SimpleSort(b);
        while(true) {
            System.out.println("\n Choose your option:");
            System.out.println("  1. Create list randomly");
            System.out.println("  2. Display data");
            System.out.println("  3. Check sorted");
            System.out.println("  4. Selection sort");
            System.out.println("  5. Insertion sort");
            System.out.println("  6. Bubble sort");
            System.out.println("  0. Exit\n");
            System.out.print("  Your selection (0 -> 6): ");
            choice = s.nextInt();
            if(choice==0) {
                System.out.println(" Good bye, have a nice day!");
                break;
            }
            switch(choice) {
                case 1:  t.setRandom();
                        break;
                case 2:  t.display();
                        break;
                case 3: if(t.sorted())
                            System.out.println(" The list is sorted");
                        else
                            System.out.println(" The list is not sorted");
                        break;
                case 4: t.selectSort();t.display();
                        break;
                case 5: t.insertSort();t.display();
                        break;
                case 6: t.bubbleSort();t.display();
                        break;
                default: System.out.println("**Invalid choice. Try again.**");
            }
        }
    }
}

