/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Q4 {
    class Node {
        int data;
        Node next;
        
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
            head = n;
            tail = n;
            n.next = head;
        } else {
            n.next = head;
            head = n;
            tail.next = head;
        }
    }
    
    void addToTail(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
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
        }
    }
    
    Node search(int x) {
        Node p = head;
        if (head.data == x) {
            return p;
        }
        do {
            p = p.next;
        } while (p != head && p.data != x);
        if (p == head) {
            return null;
        }
        return p;
    }
    
    void traverse() {
        Node p = head;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != head);
        System.out.println("");
    }
    
    int count() {
        int count = 0;
        Node p = head;
        do {
            count++;
            p = p.next;
        } while (p != head);
        
        return count;
    }
    
    int deleteFromHead() {
        Node p = head;
        if (p.next == head) {
            head = tail = null;
        } else {
            head = p.next;
            tail.next = head;
        }
        return p.data;
    }
    
    int deleteFromTail() {
        Node p = head;
        int flag = 0;
        if (p.next == head) {
            head = tail = null;
        } else {
            while (p.next.next != head) {
                p = p.next;
            }
            tail = p;
            flag = p.next.data;
            p.next = head;
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
        } else if (p.next == head) {
            deleteFromHead();
        } else {
            Node prev = p;
            prev.next = p.next.next;
        }
        return p.next.data;
    }
    
    void deleteNode(int x) {
        Node p = head, prev = null;
        if (p.data == x) {
            deleteFromHead();
            return;
        }
        do {
            prev = p;
            p = p.next;
        } while (p != head && p.data != x);
        
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
        do {
            count++;
            p = p.next;
        } while (p != head && count < i);
        if (p == head) {
            return;
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
    
    Node getNode(int i) {
        Node p = head;
        int count = 0;
        if (i == 0) {
            return p;
        }
        do {
            count++;
            p = p.next;
        } while (p != head && count < i);
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
        for (int i = 0, j = n -1; i < j; i++, j--) {
            Node pi = getNode(i), pj = getNode(j);
            pi.data = pj.data + pi.data - (pj.data = pi. data);
        }
    }
    
    int[] toArray() {
        int[] arrNode = new int[count()];
        int i = 0;
        Node p = head;
        do {
            arrNode[i] = p.data;
            i++;
            p = p.next;
        } while (p != head);
        
        return arrNode;
    }
    
    void merge(Q4 l1, Q4 l2) {
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
        do {
            if (flag <= p.data) {
                flag = p.data;
            }
            p = p.next;
        } while (p != head);
        
        return flag;
    }
    
    int min() {
        int flag = 0;
        Node p = head;
        do {
            if (flag >= p.data) {
                flag = p.data;
            }
            p = p.next;
        } while (p != head);
        
        return flag;
    }
    
    int sum() {
        int sum = 0;
        Node p = head;
        do {
            sum += p.data;
            p = p.next;
        } while (p != head);
        
        return sum;
    }
    
    int avg() {
        return this.sum() / this.count();
    }
    
    boolean sorted() {
        Node p = head;
        do {
            if (p.data > p.next.data) {
                return false;
            }
            p = p.next;
        } while (p.next != head);
        
        return true;
    }
    
    void insert(int x) {
        Node p = head;
        do {
            if (x < p.data) {
                addBefore(p, x);
                return;
            }
            p = p.next;
        } while (p != head);
        
    }
    
    boolean identical(Q4 l2) {
        Node a = this.head;
        Node b = l2.head;
        do {
            if (a.data != b.data) {
                return false;
            }
            a= a.next;
            b = b.next;
        } while (a != head && b != head);
        
        return true;
    }
    
    public static void main(String[] args) {
        Q4 l = new Q4();
        
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
        
        Q4 l2 = new Q4();
        l2.addToHead(23);
        l2.addToHead(44);
        Q4 l3 = new Q4();
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
        
        Q4 l4 = new Q4();
        l4.addToHead(5); l4.addToTail(2);
        Q4 l5 = new Q4();
        l5.addToHead(5); l5.addToTail(2);
        System.out.println(l4.identical(l5));
    }
}
