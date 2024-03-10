/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

import java.util.EmptyStackException;

/**
 *
 * @author Admin
 */
public class Stack {
    class Node {
        Object dta;
        Node next;
        
        Node(Object dta) {
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
    
    void push(Object x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }
    
    Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Object dta = head.dta;
            head = head.next;
            return dta;
        }
    }
    
    Object top() throws EmptyStackException {
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
    
    int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    Node getNode(int k) {
        Node p = head;
        int c = 0;
        while (p != null && c < k) {
            c++;
            p = p.next;
        }
        return p;
    }
    
    void reverse() {
        for (int i = 0, j = size() - 1; i < j; i++, j--) {
            Node pi = getNode(i) , pj = getNode(j);
            Object temp = pi.dta;
            pi.dta = pj.dta;
            pj.dta = temp;
        }
    }
    
    void toBinary(Object x) {
        String str = x.toString();
        byte arr[] = str.getBytes();
        for (byte b : arr) {
            push(Integer.toBinaryString(b));
            reverse();
            traverse();
            clear();
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("MYCOMPUTER123"); s.push(12323); s.push('D'); s.push('A'); s.push('T'); s.push("HAHA");
        System.out.println(s.pop());
        System.out.println(s.top());
        s.traverse();
        s.clear();
        System.out.println("");
        s.toBinary("K 17");
        System.out.println("");
    }
}
