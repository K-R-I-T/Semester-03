// =========================================================
// Do NOT modify this file 
// =========================================================
class Car {
    String owner;
    int price,color;
    
    // Default constructure
    Car () {}
    
    // Constructor with full parameter
    Car (String xOwner, int xPrice, int xColor) {
        this.owner = xOwner;
        this.price = xPrice; 
        this.color = xColor;
    }
    
    @Override
    public String toString(){
        return "("+owner+","+price+","+color+")";
    }

    public String getOwner() {
        return this.owner;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public void setOwner(String inOwner) {
        this.owner = inOwner;
    }
    
    public void setPrice(int inPrice) {
        this.price = inPrice;
    }
    
    public void setColor(int inColor) {
        this.color = inColor;
    }
}
// =========================================================
// Do NOT modify this file 
// =========================================================