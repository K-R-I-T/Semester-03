/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mystackandqueue;

public class MyQueue {
    Node head, tail;
    public MyQueue() {head = tail = null;}
    public void clear() {head = tail = null;}
    public boolean isEmpty() {return head == null;}
    
    //addLast
    public void enqueue(Object info) {
        Node p = new Node(info);
        if(isEmpty()) head = tail = p;
        else {tail.next = p; tail = p;}
    }
    
    public Object dequeue() {
        if(isEmpty()) return null;
        Object info = head.info;
        head = head.next;
        return info;
    }
    
    public Object front()
    {if(isEmpty()) return null;
     Object info = head.info;
     return info;
    }
}
