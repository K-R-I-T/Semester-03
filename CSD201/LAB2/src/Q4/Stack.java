/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import java.util.EmptyStackException;

/**
 *
 * @author Admin
 */
public class Stack {
    class Node {
        char dta;
        Node next;
        
        Node(char dta) {
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
    
    void push(char x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }
    
    char pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            char dta = head.dta;
            head = head.next;
            return dta;
        }
    }
    
    char top() throws EmptyStackException {
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
    
    void toBinary(char x) {
        System.out.println(Integer.toBinaryString(x));
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push('D'); s.push('H'); s.push('P'); s.push('T'); s.push('P'); s.push('D');
        System.out.println(s.pop());
        System.out.println(s.top());
        s.traverse();
        s.clear();
        System.out.println("");
        s.toBinary('K');
        System.out.println("");
    }
}
