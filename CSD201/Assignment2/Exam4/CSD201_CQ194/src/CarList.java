
import java.io.*;
import java.util.*;

public class CarList extends Car implements I_List {   
    Map<String,Car> mycar; 
    List<Car> list;
    
    public CarList() {this.mycar = new HashMap<>();}
     
    @Override
    public void AddFromFile(String fName) {}
    
    @Override
    public void saveToFile(String fName) {} 

    @Override
    public void add() {}

    @Override
    public void remove() {}

    @Override
    public void update() {}
    
    @Override
    public void print() {}   
}
