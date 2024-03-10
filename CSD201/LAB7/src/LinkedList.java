/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class LinkedList {

    public Node head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public void clear() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Student x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void delete(String x) {
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else {
            if (head.dta.getName() == null ? x == null : head.dta.getName().equals(x)) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            } else {
                Node tmp = null, p = head;
                while (p != null && (x == null ? p.dta.getName() != null : !x.equals(p.dta.getName()))) {
                    tmp = p;
                    p = p.next;
                }
                if (p != null) {
                    tmp.next = p.next;
                } else {
                    System.out.println(x + " is not found in the list, no deletion");
                }
            }
        }
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node p = head;
            while (p != null) {
                System.out.print(" " + p.dta.toString());
                p = p.next;
            }
            System.out.println();
        }
    }

    public Node search(String x) {
        Node p = head;
        while (p != null) {
            if (p.dta.getName() == null ? x == null : p.dta.getName().equals(x)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
