/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question1;

import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Testing addToHead 
        list.addToHead(5);
        list.addToHead(3);
        list.addToHead(1);
        System.out.println("List after adding nodes to the head:");
        list.traverse();

        // Testing addToTail 
        list.addToTail(7);
        list.addToTail(9);
        list.addToTail(11);
        System.out.println("List after adding nodes to the tail:");
        list.traverse();

        // Testing addAfter 
        Node node = list.search(7);
        list.addAfter(node, 8);
        System.out.println("List after adding node after 7:");
        list.traverse();

        // Testing count 
        System.out.println("Number of nodes in the list: " + list.count());

        // Testing deleteFromHead 
        int deletedFromHead = list.deleteFromHead();
        System.out.println("Deleted node from head: " + deletedFromHead);
        System.out.println("List after deleting node from head:");
        list.traverse();

        // Testing deleteFromTail 
        int deletedFromTail = list.deleteFromTail();
        System.out.println("Deleted node from tail: " + deletedFromTail);
        System.out.println("List after deleting node from tail:");
        list.traverse();

        // Testing deleteAfter
        Node nodeToDeleteAfter = list.search(3);
        int deletedAfter = list.deleteAfter(nodeToDeleteAfter);
        System.out.println("Deleted node after 3: " + deletedAfter);
        System.out.println("List after deleting node after 3:");
        list.traverse();

        // Testing deleteNode 
        list.deleteNode(5);
        System.out.println("List after deleting node with value 5:");
        list.traverse();

        // Testing search 
        Node searchNode = list.search(8);
        if (searchNode != null) {
            System.out.println("Found node with value 8");
        } else {
            System.out.println("Node with value 8 not found");
        }

        // Testing delete 
        Node nodeToDelete = list.search(1);
        list.delete(nodeToDelete);
        System.out.println("List after deleting node with value 1:");
        list.traverse();

        // Testing deleteNode2 
        list.deleteNode2(1);
        System.out.println("List after deleting node at index 1:");
        list.traverse();

        // Testing addBefore 
        Node nodeToAddBefore = list.search(7);
        list.addBefore(nodeToAddBefore, 6);
        System.out.println("List after adding node before 7:");
        list.traverse();

        // Testing sort 
        list.addToTail(1);
        list.addToTail(4);
        list.addToTail(2);
        System.out.println("List befor sorting: ");
        list.traverse();
        list.sort();
        System.out.println("List after sorting:");
        list.traverse();

        // Testing reverse 
        list.reverse();
        System.out.println("List after reversing:");
        list.traverse();

        // Testing toArray 
        int[] array = list.toArray();
        System.out.println("Array representation of the list:");
        System.out.println(Arrays.toString(array));

        // Testing merge 
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addToTail(10);
        list2.addToTail(12);
        list.sort() ;
        list2.sort() ;
        SinglyLinkedList mergeList = SinglyLinkedList.merge(list, list2) ;
        System.out.println("List1 after merging with list2:");
        mergeList.traverse();

        // Testing attach 
        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.addToTail(14);
        list3.addToTail(16);
        SinglyLinkedList attachList = SinglyLinkedList.attach(list, list3) ;
        System.out.println("List after attaching another list:");
        attachList.traverse();

        // Testing max 
        int maxValue = list.max();
        System.out.println("Maximum value in the list: " + maxValue);

        // Testing min 
        int minValue = list.min();
        System.out.println("Minimum value in the list: " + minValue);

        // Testing sum 
        int sum = list.sum();
        System.out.println("Sum of values in the list: " + sum);

        // Testing avg 
        int average = list.avg();
        System.out.println("Average of values in the list: " + average);

        // Testing sorted 
        boolean isSorted = list.sorted();
        if (isSorted) {
            System.out.println("List is sorted");
        } else {
            System.out.println("List is not sorted");
        }

        // Testing insert 
        list.insert(4);
        System.out.println("List after inserting value 4 into the sorted list:");
        list.traverse();

        // Testing sameContents 
        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.addToTail(6);
        list4.addToTail(8);
        boolean hasSameContents = list.sameContents(list4);
        if (hasSameContents) {
            System.out.println("Lists have the same contents");
        } else {
            System.out.println("Lists do not have the same contents");
        }
    }
}

