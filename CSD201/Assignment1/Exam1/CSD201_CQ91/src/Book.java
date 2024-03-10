// =========================================================
// Do NOT modify this file 
// =========================================================
public class Book {
    String name;
    int isbn,price;
    
    // Default constructure
    Book () {}
    
    // Constructor with full parameter
    Book (String xName, int xISBN, int xPrice) {
        this.name = xName;       
        this.isbn = xISBN;
        this.price = xPrice; 
    }
    
    @Override
    public String toString(){
        return "("+name+","+isbn+ ","+price+")";
    }
    
    public String getName() {
        return this.name;
    }  
    
    public int getISBN() {
        return this.isbn;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public void setOwner(String inName) {
        this.name = inName;
    }
    
    public void setISBN(int inISBN) {
        this.isbn = inISBN;
    }
    
    public void setPrice(int inPrice) {
        this.price = inPrice;
    }
}
// =========================================================
// Do NOT modify this file 
// =========================================================