// =========================================================
// Do NOT modify this file 
// =========================================================
class Node{
    private Car info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Car x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (Car x) {
        this(x,null);
    }
    
    public Car getInfo() {
        return this.info;
    }
    
    public void setInfo(Car inCar) {
        this.info = inCar;
    }
 }
// =========================================================
// Do NOT modify this file 
// =========================================================
