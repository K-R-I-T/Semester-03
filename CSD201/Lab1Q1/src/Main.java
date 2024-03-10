
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyList l = new MyList();
        l.addToHead(57);
        l.addToHead(12);
        l.addToTail(55);
        for (int i : l.toArray()) {
            System.out.println(i);
        }
        
        System.out.println(l.head.next.prev.data);
    }
}
