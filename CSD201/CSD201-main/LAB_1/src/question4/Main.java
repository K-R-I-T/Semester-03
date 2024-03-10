/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question4;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.addToHead(5);
        list.addToHead(3);
        list.addToTail(8);
        list.addAfter(list.search(5), 7);
        list.traverse();
        System.out.println("Count: " + list.count());
        System.out.println("Deleted: " + list.deleteFromHead());
        System.out.println("Deleted: " + list.deleteFromTail());
        list.deleteAfter(list.search(5));
        list.traverse();
        list.deleteNode(3);
        list.traverse();
        System.out.println("Max: " + list.max());
        System.out.println("Min: " + list.min());
        System.out.println("Sum: " + list.sum());
        System.out.println("Avg: " + list.avg());
        System.out.println("Sorted: " + list.sorted());
        list.insert(6);
        list.insert(2);
        list.insert(9);
        list.traverse();

        CircularLinkedList list1 = new CircularLinkedList();
        list1.addToHead(1);
        list1.addToHead(3);
        list1.addToHead(5);
        list1.addToHead(7);

        CircularLinkedList list2 = new CircularLinkedList();
        list2.addToHead(2);
        list2.addToHead(4);
        list2.addToHead(6);
        list2.addToHead(8);

        CircularLinkedList mergedList = CircularLinkedList.mergeLists(list1, list2);
        System.out.print("Merged list: ");
        mergedList.traverse();

        CircularLinkedList attachedList = CircularLinkedList.attachLists(list1, list2);
        System.out.print("Attached list: ");
        attachedList.traverse();
        System.out.println("Same contents: " + list.hasSameContents(list1));
    }
}
