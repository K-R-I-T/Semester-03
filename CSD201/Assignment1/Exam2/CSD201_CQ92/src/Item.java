// =========================================================
// Do NOT modify this file 
// =========================================================
public class Item {
    String style;
    int size,color;
    
    // Default constructure
    Item () {}
    
    // Constructor with full parameter
    Item (String xStyle, int xSize, int xColor) {
        this.style = xStyle;
        this.size = xSize; 
        this.color = xColor;
    }
    
    @Override
    public String toString(){
        return "(" +style+","+size + "," + color + ")";
    }

    public int getSize() {
        return this.size;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public String getStyle() {
        return this.style;
    }
    
    public void setColor(int inColor) {
        this.color = inColor;
    }
    
    public void setSize(int inSize) {
        this.size = inSize;
    }
    
    public void setStyle(String inStyle) {
        this.style = inStyle;
    }
}
// =========================================================
// Do NOT modify this file 
// =========================================================
