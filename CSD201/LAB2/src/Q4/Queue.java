/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

/**
 *
 * @author Admin
 */
public class Queue {
    class Node {
        char dta;
        Node next;
        
        Node(char dta) {
            this.dta = dta;
        }
    }
    
    Node head = null, tail = null;
    
    boolean isEmpty() {
        return head == null;
    }
    
    void clear() {
        head = tail = null;
    }
    
    void enqueue(char x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    
    char dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        } else {
            char info = head.dta;
            head = head.next;
            return info;
        }
    }
    
    char first() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        } else {
            return head.dta;
        }
    }
    
    void traverse() {
        while (head != null) {
            System.out.print(head.dta + " ");
            head = head.next;
        }
    }
    
    void toBinary(char x) throws Exception {
        System.out.println(Integer.toBinaryString(x));
    }
    
    public static void main(String[] args) throws Exception {
        Queue s = new Queue();
        s.enqueue('D'); s.enqueue('H'); s.enqueue('P'); s.enqueue('T'); s.enqueue('P'); s.enqueue('D');
        System.out.println(s.dequeue());
        System.out.println(s.first());
        s.traverse();
        s.clear();
        System.out.println("");
        s.toBinary('K');
        System.out.println("");
    }
}
