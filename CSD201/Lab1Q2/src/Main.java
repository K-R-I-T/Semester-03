public class Main {
    public static void main(String[] args) {
        Node p = new Node();
        MyList list = new MyList();
        
        list.addToHead("Dat"); list.addToHead("Hieu"); list.addToHead("Phuong");
        list.addToTail("Tho"); list.addToTail("Phu"); list.addToTail("Dung");
        System.out.print("Create list: "); list.traverse();
        System.out.println("");
        
        System.out.println("Number of nodes in the list: " + list.count());
        System.out.println("");
        
        System.out.println("Node has been deleted: " + list.deleteFromHead());
        System.out.print("List after delete head: "); list.traverse();
        System.out.println("");
        
        System.out.println("Node has been deleted: " + list.deleteFromTail());
        System.out.print("List after delete tail: "); list.traverse();
        System.out.println("");
        
        p = list.search("Dat"); list.addToAfter(p, "Khoi");
        System.out.print("List after insert Khoi after Dat: "); list.traverse();
        System.out.println("");
        
        System.out.println("Node has been deleted after Khoi: " + list.deleteAfter(list.search("Khoi")));
        System.out.print("List after deletet node after Khoi: "); list.traverse();
        System.out.println("");
        
        list.deleteNode("Hieu");
        System.out.print("List after delete Hieu: "); list.traverse();
        System.out.println("");
    }
}
