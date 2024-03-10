/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.EmptyStackException;

/**
 *
 * @author Admin
 */
public class Stack {
    class Node {
        String dta;
        Node next;
        
        Node(String dta) {
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
    
    void push(String x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }
    
    String pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            String dta = head.dta;
            head = head.next;
            return dta;
        }
    }
    
    String top() throws EmptyStackException {
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
            String temp = pi.dta;
            pi.dta = pj.dta;
            pj.dta = temp;
        }
    }
    
    void toBinary(String x) {
        byte arr[] = x.getBytes();
        for (byte b : arr) {
            push(String.format("%8s", Integer.toBinaryString(b & 0xFF).replace(' ', '0')));
            reverse();
            traverse();
            clear();
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("Dat"); s.push("Hieu"); s.push("Phuong"); s.push("Tho"); s.push("Phu"); s.push("Dung");
        System.out.println(s.pop());
        System.out.println(s.top());
        s.traverse();
        s.clear();
        System.out.println("");
        s.toBinary("Khoi");
        System.out.println("");
    }
}
