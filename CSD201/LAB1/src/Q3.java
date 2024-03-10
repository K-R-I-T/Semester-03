/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Q3 {
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
    
    void addToTail(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
            tail.next = null;
        }
    }
    
    Node search(int x) {
        Node p = head;
        while (p != null && p.data != x) {
            p = p.next;
        }
        return p;
    }
    
    void addAfter(Node p, int x) {
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
            n.prev = p;
            p.next.prev = n;
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
            p.next.prev = null;
        }
        return p.data;
    }
    
    int deleteFromTail() {
        Node p = tail;
        if (p.prev == null) {
            head = tail = null;
        } else {
            tail = p.prev;
            p.prev.next = null;
        }
        return p.data;
    }
    
    int deleteAfter(Node p) {
        if (p == null) {
            System.out.println("The given node cannot be null");
            return 0;
        }
        if (p.next == tail) {
            deleteFromTail();
        } else {
            p.next = p.next.next;
            p.next.next.prev = p;
        }
        return p.next.data;
    }
    
    void deleteNode(int x) {
        Node p = head, prev = null;
        while (p != null && p.data != x) {
            prev = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (p == head) {
            deleteFromHead();
            return;
        }
        if (p == tail) {
            deleteFromTail();
        } else {
            prev.next = p.next;
            p.next.prev = prev;
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
        p.next.prev = temp;
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
            p.prev.next = n;
            n.next = p;
            n.prev = p.prev;
            p.prev = n;
        }
    }
    
    Node getNode(int i) {
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        return p;
    }
    
    void sort() {
        int n = count();
        for (int i = 0; i < n - 1; i++) {
            Node pi = getNode(i);
            for (int j = i + 1; j < n; j++) {
                Node pj = getNode(j);
                if (pi.data > pj.data) {
                    pi.data = pj.data + pi.data - (pj.data = pi.data);
                }
            }
        }
    }
    
    void reverse() {
        for (int i = 0, j = count() - 1; i < j; i++, j--) {
            Node pi = getNode(i);
            Node pj = getNode(j);
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
    
    void merge(Q3 l1, Q3 l2) {
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
    
    boolean identical(Q3 l2) {
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
        Q3 l = new Q3();
        
        l.addToHead(1); l.addToHead(2); l.addToHead(3);
        l.addToTail(4); l.addToTail(5); l.addToTail(6);
        l.addAfter(l.search(2), 0); l.addAfter(l.search(6), 7);
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
        
        Q3 l2 = new Q3();
        l2.addToHead(23);
        l2.addToHead(44);
        Q3 l3 = new Q3();
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
        
        Q3 l4 = new Q3();
        l4.addToHead(5); l4.addToTail(2);
        Q3 l5 = new Q3();
        l5.addToHead(5); l5.addToTail(2);
        System.out.println(l4.identical(l5));
    }
}
