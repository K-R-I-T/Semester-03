/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

/**
 *
 * @author Admin
 */
public class Queue {
    class Node {
        Object dta;
        Node next;
        
        Node(Object dta) {
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
    
    void enqueue(Object x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    
    Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        } else {
            Object info = head.dta;
            head = head.next;
            return info;
        }
    }
    
    Object first() throws Exception {
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
    
    void toBinary(String x) throws Exception {
        byte arr[] = x.getBytes();
        for (byte b : arr) {
            enqueue(Integer.toBinaryString(b & 0xFF));
            traverse();
            clear();
        }
    }
    
    public static void main(String[] args) throws Exception {
        Queue s = new Queue();
        s.enqueue("MYCOMPUTER123"); s.enqueue(12323); s.enqueue('D'); s.enqueue('A'); s.enqueue('T'); s.enqueue("HAHA");
        System.out.println(s.dequeue());
        System.out.println(s.first());
        s.traverse();
        s.clear();
        System.out.println("");
        s.toBinary("K 17");
        System.out.println("");
    }
}
