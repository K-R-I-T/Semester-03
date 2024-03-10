public class Node {
    int data; //data of Node
    Node next;
    Node prev;
    
    //create a new Node
    public Node() {
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    Node(int data) {
        this(data, null);
    }
}
