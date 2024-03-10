/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

/**
 *
 * @author dell
 */


import models.ChainingHashTable;
import models.Student;

public class Main {
    public static void main(String[] args) {
        ChainingHashTable hashTable = new ChainingHashTable(26);

        // Inserting students
        hashTable.insert(new Student("Alice", 20, 85.5));
        hashTable.insert(new Student("Bob", 21, 90.0));
        hashTable.insert(new Student("Charlie", 19, 80.3));
        hashTable.insert(new Student("David", 22, 95.2));
        hashTable.insert(new Student("Emily", 20, 88.9));

        // Display the hash table
        hashTable.display();

        // Searching for a student
        String searchKey = "Charlie";
        Student foundStudent = hashTable.search(searchKey);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found with key: " + searchKey);
        }

        // Deleting a student
        String deleteKey = "Bob";
        hashTable.delete(deleteKey);

        // Display the updated hash table
        System.out.println("After deleting student with key: " + deleteKey);
        hashTable.display();
    }
}
