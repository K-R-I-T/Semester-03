/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        ChainingHashTable ht = new ChainingHashTable();
        // Inserting students
        ht.insert(new Student("Alice", 20, 85.5));
        ht.insert(new Student("Andree", 23, 83.2));
        ht.insert(new Student("Bob", 21, 90.0));
        ht.insert(new Student("Bill", 18, 80.0));
        ht.insert(new Student("Charlie", 19, 80.3));
        ht.insert(new Student("Camile", 15, 72.6));
        ht.insert(new Student("David", 22, 95.2));
        ht.insert(new Student("Emily", 20, 88.9));
        // Display the hash table
        ht.traverse();
        // Searching for a student
        String searchKey = "Charlie";
        Student foundStudent = ht.search(searchKey);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found with key: " + searchKey);
        }
        // Deleting a student
        String deleteKey = "Bob";
        ht.delete(deleteKey);
        // Display the updated hash table
        System.out.println("After deleting student with key: " + deleteKey);
        ht.traverse();
    }
}
