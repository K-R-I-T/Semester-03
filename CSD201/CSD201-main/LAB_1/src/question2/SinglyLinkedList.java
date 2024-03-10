/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question2;

/**
 *
 * @author Administrator
 */
class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;
    private Node tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void addToHead(String x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addToTail(String x) {
        Node newNode = new Node(x);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addAfter(Node p, String x) {
        if (p == null) {
            System.out.println("Invalid node reference.");
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
        if (p == tail) {
            tail = newNode;
        }
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public String deleteFromHead() {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        String deletedData = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return deletedData;
    }

    public String deleteFromTail() {
        if (tail == null) {
            System.out.println("List is empty.");
            return null;
        }
        String deletedData = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        return deletedData;
    }

    public String deleteAfter(Node p) {
        if (p == null || p.next == null) {
            System.out.println("Invalid node reference.");
            return null;
        }
        String deletedData = p.next.data;
        if (p.next == tail) {
            tail = p;
        }
        p.next = p.next.next;
        return deletedData;
    }

    public void deleteNode(String x) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data.equals(x)) {
            deleteFromHead();
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(x)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Node not found.");
    }

    public Node search(String x) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(x)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
