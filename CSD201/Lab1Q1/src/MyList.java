
import java.util.LinkedList;

public class MyList {
    Node head, tail;
    
    public MyList() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
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
    
    public void addToTail(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    
    public Node search(int x) {
        Node p = head;
        while (p != null && p.data != x) {
            p = p.next;
        }
        return p;
    }
    
    public void addToAfter(Node p, int x) {
        if (p == null) {
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
    
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println("");
    }
    
    public int count() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    public int deleteFromHead() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node p = head;
        int flag = head.data;
        if (p.next == null) {
            head = null;
        } else {
            head = p.next;
        }
        return flag;
    }
    
    public int deleteFromTail() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node p = head;
        int flag = tail.data;
        if (p.next == null) {
            head = null;
        } else {
            Node temp = p;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            tail = temp;
        }
        return flag;
    }
    
    public int deleteAfter(Node p) {
        if (p == null || p == tail) {
            throw new IllegalStateException();
        }
        int flag;
        if (p.next == tail) {
            flag = tail.data;
            tail = p;
        } else {
            Node prev = p, temp = p.next;
            flag = p.next.data;
            prev.next = temp.next;
        }
        return flag;
    }
    
    public void deleteNode(int x) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == x) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != x) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        if (temp == tail) {
            tail = prev;
        } else {
            prev.next = temp.next;
        }
    }
    
    public void delete(Node p) {
        if (p == null) {
            return;
        }
        Node temp = head;
        while (temp.next != p) {
            temp = temp.next;
        }
        if (p == tail) {
            tail = temp;
        } else {
            temp.next = p.next;
        }
    }
    
    public void deleteNode2(int i) {
        Node p = head;
        int count = 0;
        if (i==0) {
            head = p.next;
            return;
        }
        while (p != null && count < i) {
            count++;
            p = p.next;
        }
        delete(p);
    }
    
    public void addBefore(Node p, int x) {
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
    
    public Node getNode(int k) {
        Node p = head;
        int c = 0;
        while (p != null && c < k) {
            c++;
            p = p.next;
        }
        return p;
    }
    
    public void sort() {
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
    
    public void reverse() {
        int n = count();
        for (int i = 0, j = n -1; i < j; i++, j--) {
            Node pi = getNode(i), pj = getNode(j);
            pi.data = pj.data + pi.data - (pj.data = pi. data);
        }
    }
    
    public int[] toArray() {
        int[] arrNode = new int[count()];
        int i = 0;
        for (Node p = head; p != null; p = p.next) {
            arrNode[i++] = p.data;
        }
        return arrNode;
    }
    
    
}