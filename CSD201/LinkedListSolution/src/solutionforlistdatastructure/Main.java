/*
 *  Lab1 - List Data Structures
 */

package solutionforlistdatastructure;

class Main {
    
    public static void main(String[] args) {     
        Node p = new Node();
        MyList list = new MyList();      
        
        list.addLast(6); list.addLast(4); list.addLast(5); 
        list.addFirst(7); list.addFirst(3); list.addFirst(1); 
        list.addFirst(3); list.addFirst(5); 
        System.out.print("Created list: "); list.printList();
        
        int count = list.size();
        System.out.println("Number of nodes in the list: " + count);       
        
        list.deleteNode(3); // delete node with data 3
//        list.deleFirst();
//        list.deleLast();
        System.out.print("List after delete 3: "); list.printList();  
        
        p = list.search(3); list.addAfter(p, 2);
        System.out.print("List after insert 2 after 3: "); list.printList(); 
        p = list.search(6); list.addBefore(p, 9);
        System.out.print("List after insert 9 before 6: "); list.printList();
        
//        list.deleFirst();
//        list.deleLast();
        p = list.search(1); list.deleteAter(p);
        System.out.print("List after delete node after 1: "); list.printList(); 
        p = list.search(1); list.deleteBefore(p);
        System.out.print("List after delete node before 1: "); list.printList();
        
//        list.deleteNode2(3);
//        System.out.print("List after delete the 3rd node: "); list.printList();
        
        list.sort();
        System.out.print("List after sort: "); list.printList();
        list.reverse();
        System.out.print("List after reverse: "); list.printList();
    }
    
}
