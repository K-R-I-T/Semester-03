/*
 *  Linked implementation of a stack.
 */

package linkedlistbasedstack;

class Person {
    String name; int age;
    Person(String xName, int xAge) {name=xName;age=xAge;}
    @Override
    public String toString() {return(name + " " + age);}
}

class Node {
    Person info;
    Node next;
    Node(Person x, Node p) {info=x;next=p;}
}

class MyStack {
    Node head;
    
    MyStack() {head=null;}
    
    boolean isEmpty() {return(head==null);}
    
    void push(Person x) {
        Node q = new Node(x,head);
        if(isEmpty()) {head=q;return;}
        head=q;
    }
    
    void pushMany(String [] a, int [] b) {
        for(int i=0; i<a.length; i++) push(new Person(a[i],b[i]));
    }
    
    void popAll() {
        while(!isEmpty()) System.out.println(pop());
    }
    
    Person pop() {
        if(isEmpty()) return(null);
        Person x = head.info;
        head=head.next;
        return(x);
    }
}

public class Main {
    public static void main(String[] args) {
        String [] a = {"HOA","LA","CANH","CAY","DAO"};
        int [] b = {25,17,26,19,23};
        MyStack t = new MyStack();
        t.pushMany(a,b);
        t.popAll();
//        System.out.println(); 
    }
}
