
public class Car extends Item implements Comparable<Car> {  
    private String owner;
    private double price;
    private String color;
    
    public Car() {
         super();
    }
    
    public Car(String code, String make, String owner, 
            double price, String color) {
        super(code, make);
        this.owner = owner;
        this.price = price;
        this.color = color;
    }
    
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public void input() {    
        super.input();
        String newOwner = Inputter.inputNonBlankStr("   - Enter owner ");   
        double newPrice = Inputter.inputDouble("   - Enter price ");
        String newColor = Inputter.inputNonBlankStr("   - Enter color ");
        this.setOwner(newOwner);
        this.setPrice(newPrice);
        this.setColor(newColor);
    }
    
    @Override
    public String toString(){
        return getCode() + ", " + getMake() + ", " 
                + getOwner() + ", " + getPrice() + ", " + getColor();
    } 
    
    @Override
    public int compareTo(Car obj) {          
        return 0;
    }  
}
