public class Node {
    String data;
    Node next;

    public Node() {
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    public Node(String data) {
        this(data, null);
    }
}
