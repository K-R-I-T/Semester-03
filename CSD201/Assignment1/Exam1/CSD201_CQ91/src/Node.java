// =========================================================
// Do NOT modify this file 
// =========================================================
class Node{
    private Book info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Book x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (Book x) {
        this(x,null);
    }
    
    public Book getInfo() {
        return this.info;
    }
    
    public void setInfo(Book inBook) {
        this.info = inBook;
    }
 }
// =========================================================
// Do NOT modify this file 
// =========================================================

