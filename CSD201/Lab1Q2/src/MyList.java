public class MyList {
    Node head, tail;

    public MyList() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    void addToHead(String x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }
    
    void addToTail(String x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    
    Node search(String x) {
        Node p = head;
        while (p != null && p.data != x) {
            p = p.next;
        }
        return p;
    }
    
    void addToAfter(Node p, String x) {
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
    
    String deleteFromHead() {
        Node p = head;
        if (p.next == null) {
            head = tail = null;
        } else {
            head = p.next;
        }
        return p.data;
    }
    
    String deleteFromTail() {
        Node p = head;
        String flag = null;
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
    
    String deleteAfter(Node p) {
        if (p == null) {
            System.out.println("The given node cannot be null");
        }
        if (p.next == tail) {
            tail = p;
        } else {
            Node prev = p, temp = p.next;
            prev.next = temp.next;
        }
        return p.next.data;
    }
    
    void deleteNode(String x) {
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
}
