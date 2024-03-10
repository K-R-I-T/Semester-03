
public class Clock extends Item implements Comparable<Clock> {    
    private int size;
    private int price;
    
    public Clock() {
         super();
    }
    
    public Clock(String code, String make, int size, int price) {
        super(code, make);
        this.size = size;
        this.price = price;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public void input() {    
        super.input();
        int newSize = Inputter.inputInt("   - Enter size ");
        int newPrice = Inputter.inputInt("   - Enter price ");
        this.setSize(newSize);
        this.setPrice(newPrice);
    }
    
    @Override
    public void output() {
        super.output();
        System.out.print(this.getSize() + " - ");
        System.out.println(this.getPrice());
    }
    
    @Override
        public int compareTo(Clock clock) {       
        return this.getPrice()-(clock.getPrice());      
    }  
}
