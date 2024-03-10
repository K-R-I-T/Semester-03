/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Q1 {
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    private Node head = null, tail = null;
    
    public boolean isEmpty() {
        return head == null;
    }
    
    void addToHead(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }
    
    void addToTail(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    
    Node search(int x) {
        Node p = head;
        while (p != null && p.data != x) {
            p = p.next;
        }
        return p;
    }
    
    void addToAfter(Node p, int x) {
        if (p == null) {
            System.out.println("The given previous cannot be null");
            return;
        }
        Node n = new Node(x);
        if (p == tail) {
            addToTail(x);
        } else {
            n.next = p.next;
            p.next = n;
        }
    }
    
    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println("");
    }
    
    int count() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    int deleteFromHead() {
        Node p = head;
        if (p.next == null) {
            head = tail = null;
        } else {
            head = p.next;
        }
        return p.data;
    }
    
    int deleteFromTail() {
        Node p = head;
        int flag = 0;
        if (p.next == null) {
            head = tail = null;
        } else {
            while (p.next.next != null) {
                p = p.next;
            }
            tail = p;
            flag = p.next.data;
            p.next = null;
        }
        return flag;
    }
    
    int deleteAfter(Node p) {
        if (p == null) {
            System.out.println("The given node cannot be null");
            return 0;
        }
        if (p.next == tail) {
            deleteFromTail();
        } else {
            Node prev = p, temp = p.next;
            prev.next = temp.next;
        }
        return p.next.data;
    }
    
    void deleteNode(int x) {
        Node p = head, prev = null;
        if (p.data == x) {
            head = p.next;
            return;
        }
        while (p != null && p.data != x) {
            prev = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (p == tail) {
            deleteFromTail();
        } else {
            prev.next = p.next;
        }
    }
    
    void delete(Node p) {
        if (p == null) {
            return;
        }
        if (p == head) {
            deleteFromHead();
            return;
        }
        if (p == tail) {
            deleteFromTail();
            return;
        }
        Node temp = head;
        while (temp.next != p) {
            temp = temp.next;
        }
        temp.next = p.next;
    }
    
    void deleteNode2(int i) {
        Node p = head;
        int count = 0;
        if (i==0) {
            deleteFromHead();
            return;
        }
        while (p != null && count < i) {
            count++;
            p = p.next;
        }
        delete(p);
    }
    
    void addBefore(Node p, int x) {
        if (p == null) {
            return;
        } 
        Node n = new Node(x);
        if (p == head) {
            addToHead(x);
        } else {
            Node prev = null, temp = head;
            while (temp != p) {
                prev = temp;
                temp = temp.next;
            }
            n.next = prev.next;
            prev.next = n;
        }
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
    
    void sort() {
        int n = count();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = getNode(i), pj = getNode(j);
                if (pi.data > pj.data) {
                    pi.data = pj.data + pi.data - (pj.data = pi. data);
                }
            }
        }
    }
    
    void reverse() {
        int n = count();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i), pj = getNode(j);
            pi.data = pj.data + pi.data - (pj.data = pi.data);
        }
    }
    
    int[] toArray() {
        int[] arrNode = new int[count()];
        int i = 0;
        for (Node p = head; p != null; p = p.next) {
            arrNode[i++] = p.data;
        }
        return arrNode;
    }
    
    void merge(Q1 l1, Q1 l2) {
        for (int i : l1.toArray()) {
            this.addToTail(i);
        }
        for (int i : l2.toArray()) {
            this.addToTail(i);
        }
    }
    
    void attach(int[] x) {
        for (int i : x) {
            addToTail(i);
        }
    }
    
    int max() {
        int flag = 0;
        Node p = head;
        while (p != null) {
            if (flag <= p.data) {
                flag = p.data;
            }
            p = p.next;
        }
        return flag;
    }
    
    int min() {
        int flag = 0;
        Node p = head;
        while (p != null) {
            if (flag >= p.data) {
                flag = p.data;
            }
            p = p.next;
        }
        return flag;
    }
    
    int sum() {
        int sum = 0;
        Node p = head;
        while (p != null) {
            sum += p.data;
            p = p.next;
        }
        return sum;
    }
    
    int avg() {
        return this.sum() / this.count();
    }
    
    boolean sorted() {
        Node p = head;
        while (p.next != null) {
            if (p.data > p.next.data) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
    
    void insert(int x) {
        Node p = head;
        while (p != null) {
            if (x < p.data) {
                addBefore(p, x);
                return;
            }
            p = p.next;
        }
    }
    
    boolean identical(Q1 l2) {
        Node a = this.head;
        Node b = l2.head;
        while (a != null && b != null) {
            if (a.data != b.data) {
                return false;
            }
            a= a.next;
            b = b.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Q1 l = new Q1();
        
        l.addToHead(1); l.addToHead(2); l.addToHead(3);
        l.addToTail(4); l.addToTail(5); l.addToTail(6);
        l.addToAfter(l.search(2), 0); l.addToAfter(l.search(6), 7);
        l.traverse();
        System.out.println(l.count());
        l.deleteFromHead(); l.deleteFromTail();
        l.traverse();
        l.deleteAfter(l.search(0)); l.deleteNode(5); l.delete(l.search(2)); l.deleteNode2(3); l.addBefore(l.search(1), 8);
        l.sort();
        l.reverse();
        for (int i : l.toArray()) {
            System.out.print(i + " ");
        }
        System.out.println("");
        
        Q1 l2 = new Q1();
        l2.addToHead(23);
        l2.addToHead(44);
        Q1 l3 = new Q1();
        l3.merge(l, l2);
        l3.traverse();
        l.attach(l2.toArray());
        l.traverse();
        
        System.out.println(l.max());
        System.out.println(l.min());
        System.out.println(l.sum());
        System.out.println(l.avg());
        
        l.sort();
        System.out.println(l.sorted());
        
        l.insert(9);
        l.traverse();
        
        Q1 l4 = new Q1();
        l4.addToHead(5); l4.addToTail(2);
        Q1 l5 = new Q1();
        l5.addToHead(5); l5.addToTail(2);
        System.out.println(l4.identical(l5));
    }
}
