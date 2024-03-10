/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question1;

/**
 *
 * @author Administrator
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addToHead(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAfter(Node p, int x) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
        if (tail == p) {
            tail = newNode;
        }
        size++;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int count() {
        return size;
    }

    public int deleteFromHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return data;
    }

    public int deleteFromTail() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
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
            current.next = null;
            tail = current;
        }
        size--;
        return data;
    }

    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            throw new IllegalArgumentException("Invalid node");
        }
        Node nodeToDelete = p.next;
        int data = nodeToDelete.data;
        p.next = nodeToDelete.next;
        if (tail == nodeToDelete) {
            tail = p;
        }
        size--;
        return data;
    }

    public void deleteNode(int x) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head.data == x) {
            deleteFromHead();
        } else {
            Node current = head;
            while (current.next != null && current.next.data != x) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
                if (tail.data == x) {
                    tail = current;
                }
                size--;
            }
        }
    }

    public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(Node p) {
        if (head == null || p == null) {
            return;
        }
        if (head == p) {
            deleteFromHead();
        } else {
            Node current = head;
            while (current.next != p) {
                current = current.next;
            }
            if (current.next == p) {
                current.next = current.next.next;
                if (tail == p) {
                    tail = current;
                }
                size--;
            }
        }
    }

    public void deleteNode2(int i) {
        if (head == null || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (i == 0) {
            deleteFromHead();
        } else if (i == size - 1) {
            deleteFromTail();
        } else {
            Node current = head;
            int count = 0;
            while (count < i - 1) {
                current = current.next;
                count++;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public void addBefore(Node p, int x) {
        if (p == null) {
            return;
        }
        if (head == p) {
            addToHead(x);
        } else {
            Node current = head;
            while (current != null && current.next != p) {
                current = current.next;
            }
            if (current != null) {
                Node newNode = new Node(x);
                newNode.next = current.next;
                current.next = newNode;
                size++;
            }
        }
    }

    public void sort() {
        if (head == null || head == tail) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            while (nextNode != null) {
                if (current.data > nextNode.data) {
                    int temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            current = current.next;
        }
    }

    public void reverse() {
        if (head == null || head == tail) {
            return;
        }
        Node prevNode = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        tail = head;
        head = prevNode;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    public static SinglyLinkedList merge(SinglyLinkedList list1,SinglyLinkedList list2) {
        if (!list1.sorted() || !list2.sorted()) return null;
        SinglyLinkedList mergeList = new SinglyLinkedList();
        Node current = list1.head ;
        while(current != null){
            mergeList.addToTail(current.data);
            current = current.next;
        }
        current = list2.head ;
        while(current != null){
            mergeList.addToTail(current.data);
            current = current.next;
        }
        mergeList.sort();
        return mergeList ;
    }

    public static SinglyLinkedList attach(SinglyLinkedList list1,SinglyLinkedList list2) {
        SinglyLinkedList attachedList = new SinglyLinkedList() ;
        Node current = list1.head ;
        while(current != null){
            attachedList.addToTail(current.data);
            current = current.next;
        }
        current = list2.head ;
        while(current != null){
            attachedList.addToTail(current.data);
            current = current.next;
        }
        return attachedList ;
    }

    public int max() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int maxValue = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > maxValue) {
                maxValue = current.data;
            }
            current = current.next;
        }
        return maxValue;
    }

    public int min() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int minValue = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < minValue) {
                minValue = current.data;
            }
            current = current.next;
        }
        return minValue;
    }

    public int sum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public int avg() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return sum() / size;
    }

    public boolean sorted() {
        if (head == null || head == tail) {
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public void insert(int x) {
        if (head == null || x < head.data) {
            addToHead(x);
            return;
        }
        if (x > tail.data) {
            addToTail(x);
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }
        Node newNode = new Node(x);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public boolean sameContents(SinglyLinkedList list) {
        if (size != list.size) {
            return false;
        }
        Node current1 = head;
        Node current2 = list.head;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }
}
