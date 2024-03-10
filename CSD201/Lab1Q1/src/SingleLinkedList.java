
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class SingleLinkedList {
    public class Node {
        int data;
        Node next;
        
        public void Node() {
            
        }
        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        
        public Node(int data) {
            this(data, null);
        }
    }
    
    public Node head = null, tail = null;
    
    LinkedList<String> MyList = new LinkedList<>();
    
    public void addToHead(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }
    }
}
