/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author Admin
 */
public class Queue {
    class Node {
        int dta;
        Node next;
        
        Node(int dta) {
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
    
    void enqueue(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    
    int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        } else {
            int info = head.dta;
            head = head.next;
            return info;
        }
    }
    
    int first() throws Exception {
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
    
    void toBinary(double x) throws Exception {
        while (x > 0) {
            int i = (int) (x * 2);
            enqueue(i);
            if ((x * 2) >= 1) {
                x = x * 2 - 1;
            } else {
                x = x * 2;
            }
        }
        System.out.print("0.");
        traverse();
    }
    
    public static void main(String[] args) throws Exception {
        Queue s = new Queue();
        s.enqueue(0); s.enqueue(1); s.enqueue(2); s.enqueue(3); s.enqueue(4); s.enqueue(5);
        System.out.println(s.dequeue());
        System.out.println(s.first());
        s.traverse();
        s.clear();
        System.out.println("");
        s.toBinary(0.625);
        System.out.println("");
    }
}
