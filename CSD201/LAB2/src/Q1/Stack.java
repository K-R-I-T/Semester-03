/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

import java.util.EmptyStackException;

/**
 *
 * @author Admin
 */
public class Stack {
    class Node {
        int dta;
        Node next;
        
        Node(int dta) {
            this.dta = dta;
        }
    }
    
    Node head = null;
    
    boolean isEmpty() {
        return head == null;
    }
    
    void clear() {
        head = null;
    }
    
    void push(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }
    
    int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            int dta = head.dta;
            head = head.next;
            return dta;
        }
    }
    
    int top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
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
    
    void decToBin(int x) {
        while (x > 0) {
            push(x % 2);
            x /= 2;
        }
        while (!isEmpty()) {
            System.out.print(pop());
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0); s.push(1); s.push(2); s.push(3); s.push(4); s.push(5);
        System.out.println(s.pop());
        System.out.println(s.top());
        s.traverse();
        s.clear();
        System.out.println("");
        s.decToBin(100);
        System.out.println("");
    }
}
