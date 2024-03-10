/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ChainingHashTable {

    private final int size;
    private final LinkedList[] list;

    public ChainingHashTable() {
        size = 26;
        list = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            list[i] = new LinkedList();
        }
    }

    public void clear() {
        for (LinkedList linkedList : list) {
            linkedList.head = linkedList.tail = null;
        }
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (LinkedList linkedList : list) {
            if (!linkedList.isEmpty()) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    private int hashFunction(String key) {
        char firstChar = Character.toLowerCase(key.charAt(0));
        return firstChar - 'a';
    }

    public void insert(Student student) {
        String key = student.getName();
        int index = hashFunction(key);
        list[index].add(student);
    }
    
    public void delete(String key) {
        int index = hashFunction(key);
        list[index].delete(key);
    }
    
    public void traverse() {
        if (isEmpty()) {
            System.out.println("The Hash table is empty");
        } else {
            for (LinkedList linkedList : list) {
                linkedList.traverse();
            }
            System.out.println("");
        }
    }
    
    public Student search(String key) {
        int index = hashFunction(key);
        return list[index].search(key).dta;
    }
}
