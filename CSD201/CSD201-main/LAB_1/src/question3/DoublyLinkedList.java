/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question3;

/**
 *
 * @author Administrator
 */
class Node {

    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

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
            head.prev = newNode;
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
            newNode.prev = tail;
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
        newNode.prev = p;
        if (p.next != null) {
            p.next.prev = newNode;
        }
        p.next = newNode;
        if (p == tail) {
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
            return -1;
        }
        int deletedData = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return deletedData;
    }

    public int deleteFromTail() {
        if (tail == null) {
            return -1;
        }
        int deletedData = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return deletedData;
    }

    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            return -1;
        }
        Node deletedNode = p.next;
        p.next = deletedNode.next;
        if (deletedNode.next != null) {
            deletedNode.next.prev = p;
        }
        if (deletedNode == tail) {
            tail = p;
        }
        size--;
        return deletedNode.data;
    }

    public void deleteNode(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                if (current == head) {
                    deleteFromHead();
                } else if (current == tail) {
                    deleteFromTail();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
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
        if (p == null) {
            return;
        }
        if (p == head) {
            deleteFromHead();
        } else if (p == tail) {
            deleteFromTail();
        } else {
            p.prev.next = p.next;
            p.next.prev = p.prev;
            size--;
        }
    }

    public void deleteNode2(int i) {
        if (i < 1 || i > size) {
            return;
        }
        Node current = head;
        int count = 1;
        while (count < i) {
            current = current.next;
            count++;
        }
        delete(current);
    }

    public void addBefore(Node p, int x) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(x);
        newNode.prev = p.prev;
        newNode.next = p;
        if (p.prev != null) {
            p.prev.next = newNode;
        } else {
            head = newNode;
        }
        p.prev = newNode;
        size++;
    }

    public void sort() {
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
        Node current = head;
        Node prevNode = null;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prevNode;
            current.prev = nextNode;
            prevNode = current;
            current = nextNode;
        }
        tail = head;
        head = prevNode;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            arr[index] = current.data;
            current = current.next;
            index++;
        }
        return arr;
    }

    public static DoublyLinkedList merge(DoublyLinkedList list1,DoublyLinkedList list2) {
        if (!list1.sorted() || !list2.sorted()) return null;
        DoublyLinkedList mergeList = attach(list1, list2);
        mergeList.sort();
        return mergeList ;
    }

    public static DoublyLinkedList attach(DoublyLinkedList list1,DoublyLinkedList list2) {
        DoublyLinkedList attachedList = new DoublyLinkedList() ;
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
        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    public int min() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int min = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
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
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public void insert(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (x <= head.data) {
            addToHead(x);
        } else if (x >= tail.data) {
            addToTail(x);
        } else {
            Node current = head.next;
            while (current != null) {
                if (x <= current.data) {
                    newNode.next = current;
                    newNode.prev = current.prev;
                    current.prev.next = newNode;
                    current.prev = newNode;
                    size++;
                    return;
                }
                current = current.next;
            }
        }
    }

    public boolean sameContents(DoublyLinkedList list) {
        if (size != list.size) {
            return false;
        }
        Node currentA = head;
        Node currentB = list.head;
        while (currentA != null && currentB != null) {
            if (currentA.data != currentB.data) {
                return false;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return true;
    }
}
