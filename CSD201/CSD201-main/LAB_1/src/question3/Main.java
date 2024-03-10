/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question3;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addToHead(3);
        list.addToHead(2);
        list.addToTail(4);
        list.addAfter(list.search(2), 5);
        list.addBefore(list.search(4), 1);
        
        System.out.print("List: ");
        list.traverse();
        System.out.println("Count: " + list.count());
        System.out.println("Deleted from head: " + list.deleteFromHead());
        System.out.println("Deleted from tail: " + list.deleteFromTail());
        list.deleteAfter(list.search(2));
        list.deleteNode(2);
        list.deleteNode2(1);
        list.addBefore(list.search(3), 0);
        
        System.out.print("List: ");
        list.traverse();
        System.out.println("Count: " + list.count());
        System.out.println("Search 4: " + list.search(4));
        
        list.sort();
        System.out.print("Sorted list: ");
        list.traverse();
        
        list.reverse();
        System.out.print("Reversed list: ");
        list.traverse();
        
        int[] arr = list.toArray();
        System.out.print("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.addToHead(7);
        list2.addToHead(6);
        list2.addToTail(8);
        
        System.out.print("List 2: ");
        list2.traverse();
        
        System.out.print("Merged list: ");
        list.sort();
        list2.sort();
        DoublyLinkedList merged = DoublyLinkedList.merge(list, list2);
        merged.traverse();
        
        list.addToTail(10);
        System.out.print("Attached list: ");
        DoublyLinkedList attached = DoublyLinkedList.attach(list, list2);
        attached.traverse();
        
        System.out.println("Max value: " + list.max());
        System.out.println("Min value: " + list.min());
        System.out.println("Sum: " + list.sum());
        System.out.println("Avg: " + list.avg());
        
        System.out.println("Sorted: " + list.sorted());
        
        list.insert(9);
        System.out.print("List after insertion: ");
        list.traverse();
        
        DoublyLinkedList list3 = new DoublyLinkedList();
        list3.addToHead(3);
        list3.addToHead(2);
        list3.addToTail(4);
        System.out.println("Same contents as list: " + list.sameContents(list));
        System.out.println("Same contents as list 2: " + list.sameContents(list2));
        System.out.println("Same contents as list 3: " + list.sameContents(list3));
    }
}
