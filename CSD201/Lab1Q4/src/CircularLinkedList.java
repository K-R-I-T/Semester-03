/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class CircularLinkedList {
    
    class Node {
        int data;
        Node next;
        Node prev;
        
        Node() {
            
        }
        
        Node (int data) {
            this.data = data;
        }
    }
    
    Node head = null, tail = null;
    
    boolean isEmpty() {
        return head == null;
    }
    
    void addToHead(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
            head.prev = null;
            tail.next = null;
        } else {
            n.next = head;
            head = n;
            head.prev = null;
            head.next.prev = n;
        }
    }
    
    public void addToTail(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = tail = n;
            n.next = head;
        } else {
            tail.next = tail = n;
            tail.next = head;
        }
    }
    
    public void addToAfter(Node p, int x) {
        if (p == null) {
            System.out.println("The given previous cannot be null!");
            return;
        }
        Node n = new Node(x);
        
    }
    
    Node getNode(int i) {
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        return p;
    }
    
    public static void main(String[] args) {
        CircularLinkedList l = new CircularLinkedList();
        l.addToHead(123); l.addToHead(125);
        System.out.println(l.getNode(0).data);
    }
}
