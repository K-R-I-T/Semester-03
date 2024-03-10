/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question4;

/**
 *
 * @author Administrator
 */
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addToHead(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (tail == null) {
            tail = newNode;
            head = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    public void addAfter(Node p, int x) {
        if (p == null) {
            System.out.println("Invalid node");
            return;
        }

        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
        if (p == tail) {
            tail = newNode;
        }
        size++;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public int count() {
        return size;
    }

    public int deleteFromHead() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }

        int data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return data;
    }

    public int deleteFromTail() {
        if (tail == null) {
            System.out.println("List is empty");
            return -1;
        }

        int data = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head;
            tail = current;
        }
        size--;
        return data;
    }

    public int deleteAfter(Node p) {
        if (p == null || p == tail) {
            System.out.println("Invalid node");
            return -1;
        }

        Node deletedNode = p.next;
        int data = deletedNode.data;
        if (deletedNode == tail) {
            tail = p;
        }
        p.next = deletedNode.next;
        size--;
        return data;
    }

    public void deleteNode(int x) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == x) {
            deleteFromHead();
            return;
        }

        Node current = head;
        while (current.next != head) {
            if (current.next.data == x) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }

        System.out.println("Node with value " + x + " not found");
    }

    public Node search(int x) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        Node current = head;
        do {
            if (current.data == x) {
                return current;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Node with value " + x + " not found");
        return null;
    }

    public void delete(Node p) {
        if (p == null) {
            System.out.println("Invalid node");
            return;
        }

        if (p == head) {
            deleteFromHead();
            return;
        }

        Node current = head;
        while (current.next != p && current.next != head) {
            current = current.next;
        }

        if (current.next != p) {
            System.out.println("Node not found");
            return;
        }

        current.next = p.next;
        if (p == tail) {
            tail = current;
        }
        size--;
    }

    public void deleteNode2(int i) {
        if (i <= 0 || i > size) {
            System.out.println("Invalid index");
            return;
        }

        if (i == 1) {
            deleteFromHead();
            return;
        }

        Node current = head;
        for (int count = 1; count < i - 1; count++) {
            current = current.next;
        }
        current.next = current.next.next;
        if (current.next == head) {
            tail = current;
        }
        size--;
    }

    public void addBefore(Node p, int x) {
        if (p == null) {
            System.out.println("Invalid node");
            return;
        }

        if (p == head) {
            addToHead(x);
            return;
        }

        Node newNode = new Node(x);
        Node current = head;
        while (current.next != p && current.next != head) {
            current = current.next;
        }

        if (current.next != p) {
            System.out.println("Node not found");
            return;
        }

        newNode.next = p;
        current.next = newNode;
        size++;
    }

    public void sort() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            Node index = current.next;
            while (index != head) {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        } while (current != head);
    }

    public void reverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node previous = null;
        Node current = head;
        Node next;

        do {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        } while (current != head);

        head = previous;
        tail.next = head;
    }

    public int[] toArray() {
        if (head == null) {
            System.out.println("List is empty");
            return new int[0];
        }

        int[] arr = new int[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    public static CircularLinkedList mergeLists(CircularLinkedList list1, CircularLinkedList list2) {
        CircularLinkedList mergedList = new CircularLinkedList();

        Node current1 = list1.head;
        do {
            mergedList.addToTail(current1.data);
            current1 = current1.next;
        } while (current1 != list1.head);

        Node current2 = list2.head;
        do {
            mergedList.addToTail(current2.data);
            current2 = current2.next;
        } while (current2 != list2.head);

        mergedList.sort();
        return mergedList;
    }

    public static CircularLinkedList attachLists(CircularLinkedList list1, CircularLinkedList list2) {
        CircularLinkedList attachedList = new CircularLinkedList();

        Node current1 = list1.head;
        do {
            attachedList.addToTail(current1.data);
            current1 = current1.next;
        } while (current1 != list1.head);

        Node current2 = list2.head;
        do {
            attachedList.addToTail(current2.data);
            current2 = current2.next;
        } while (current2 != list2.head);

        return attachedList;
    }

    public int max() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }

        int maxVal = head.data;
        Node current = head.next;
        while (current != head) {
            if (current.data > maxVal) {
                maxVal = current.data;
            }
            current = current.next;
        }
        return maxVal;
    }

    public int min() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MAX_VALUE;
        }

        int minVal = head.data;
        Node current = head.next;
        while (current != head) {
            if (current.data < minVal) {
                minVal = current.data;
            }
            current = current.next;
        }
        return minVal;
    }

    public int sum() {
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        }

        int sum = head.data;
        Node current = head.next;
        while (current != head) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public int avg() {
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        }
        return sum() / size;
    }

    public boolean sorted() {
        if (head == null || head == tail) {
            return true;
        }

        Node current = head;
        do {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        } while (current != head);

        return true;
    }

    public void insert(int x) {
        if (head == null) {
            addToHead(x);
            return;
        }

        if (x <= head.data) {
            addToHead(x);
            return;
        }

        if (x >= tail.data) {
            addToTail(x);
            return;
        }

        Node newNode = new Node(x);
        Node current = head;
        while (current.next != head && current.next.data < x) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public boolean hasSameContents(CircularLinkedList list) {
        if (size != list.size) {
            return false;
        }

        if (head == null && list.head == null) {
            return true;
        }

        Node current1 = head;
        Node current2 = list.head;
        do {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        } while (current1 != head && current2 != list.head);

        return true;
    }
}
