// =========================================================
// Do NOT modify this file 
// =========================================================
class Node {
    private Item info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Item x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (Item x) {
        this(x,null);
    }
    
    public Item getInfo() {
        return this.info;
    }
    
    public void setInfo(Item inItem) {
        this.info = inItem;
    }
}
// =========================================================
// Do NOT modify this file 
// =========================================================
