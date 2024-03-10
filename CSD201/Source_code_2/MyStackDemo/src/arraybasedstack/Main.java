/*
 *  Array-based Stack
 */

package arraybasedstack;

import java.util.EmptyStackException;

class ArrayStack {
    Object[] a; int top, size;
    
    public ArrayStack() {}
    
    public ArrayStack(int s) { 
        size = s;
        a =  new Object[size];
        top = -1;
    }
    
    public boolean isEmpty() {return(top==-1);}
    public boolean isFull() {return(top==size-1);}
    public void clear() {top=-1;}
    
    public void push(Object x) { 
        if(isFull()) return;
        a[++top] = x; 
    }
    
    public Object top() throws EmptyStackException { 
        if(isEmpty()) throw new EmptyStackException();
        return(a[top]);
    }
    
    public void pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        a[top]=null; top--;
    }
    
    public void printAll() {
        for(int i=0; i<size; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(8);
        for(int i=0; i<6; i++) {as.push(i);}
        System.out.print("Stak created: "); as.printAll();  
        System.out.print("Add 6 to Stack: "); as.push(6); as.printAll();  
        System.out.print("Add 7 to Stack: "); as.push(7); as.printAll(); 
        System.out.print("Add 8 to Stack: "); as.push(8); as.printAll(); 
        System.out.print("Get (remove) " + as.top() + " from Stack: ");
        as.pop(); as.printAll(); 
        System.out.print("Get (remove) " + as.top() + " from Stack: ");
        as.pop(); as.printAll(); 
        System.out.print("Get (remove) " + as.top() + " from Stack: ");
        as.pop(); as.printAll(); 
        System.out.print("Add 8 to Stack: "); as.push(8); as.printAll(); 
        System.out.print("Add 9 to Stack: "); as.push(9); as.printAll(); 
    }
}
