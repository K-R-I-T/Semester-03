
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort s = new Sort();
        Employees[] empArr = {
            new Employees("A05", "Tran Quang", 7),
            new Employees("A03", "Nguyen An", 7),
            new Employees("A01", "Truong Phung", 5),
            new Employees("A04", "Pham Thi Lam", 2),
            new Employees("A02", "Do Trung Ton", 5)
        };
        boolean asc = true;
        while (true) {
            System.out.println("\n Choose your option:");
            System.out.println("  1. Display data");
            System.out.println("  2. Insertion sort");
            System.out.println("  3. Select sort");
            System.out.println("  4. Bubble sort");
            System.out.println("  5. Heap sort");
            System.out.println("  6. Quick sort");
            System.out.println("  7. Merge sort");
            System.out.println("  8. ASC");
            System.out.println("  9. DESC");
            System.out.print("  Your selection (0 -> 6): ");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println(" Good bye, have a nice day!");
                break;
            }
            switch (choice) {
                case 1:
                    s.display(empArr);
                    break;
                case 2:
                    s.insertionSort(empArr, asc);
                    s.display(empArr);
                    break;
                case 3:
                    s.selectSort(empArr, asc);
                    s.display(empArr);
                    break;
                case 4:
                    s.bubbleSort(empArr, asc);
                    s.display(empArr);
                    break;
                case 5:
                    s.heapSort(empArr, asc);
                    s.display(empArr);
                    break;
                case 6:
                    s.quickSort(empArr, asc);
                    s.display(empArr);
                    break;
                case 7:
                    s.mergeSort(empArr, asc);
                    s.display(empArr);
                    break;
                case 8:
                    asc = true;
                    break;
                case 9:
                    asc = false;
                    break;
            }
        }
    }
}
