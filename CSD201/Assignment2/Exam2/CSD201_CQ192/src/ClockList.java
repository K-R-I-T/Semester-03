
import java.io.*;
import java.util.*;

public class ClockList extends Clock implements I_List {  
    Map<String,Clock> myclock; 
    
    public ClockList() {this.myclock = new HashMap<>();}
    
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
