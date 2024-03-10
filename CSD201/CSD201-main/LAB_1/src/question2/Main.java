/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question2;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addToHead("Node 1");
        list.addToTail("Node 3");
        list.addAfter(list.getHead(), "Node 2");

        list.traverse();
        System.out.println("Count: " + list.count());

        System.out.println("Deleted: " + list.deleteFromHead());
        System.out.println("Deleted: " + list.deleteFromTail());

        Node searchResult = list.search("Node 2");
        if (searchResult != null) {
            list.addAfter(searchResult, "Node 4");
        }

        list.traverse();
        System.out.println("Count: " + list.count());
    }
}







