/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.LinkedList;

/**
 *
 * @author dell
 */
public class ChainingHashTable {

    private LinkedList<Student>[] table;
    private int size;

    public ChainingHashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String key) {
        char firstChar = Character.toLowerCase(key.charAt(0));
        return firstChar - 'a';
    }

    public void insert(Student student) {
        String key = student.getName();
        int index = hashFunction(key);
        table[index].add(student);
    }

    public void delete(String key) {
        int index = hashFunction(key);
        LinkedList<Student> chain = table[index];
        for (Student student : chain) {
            if (student.getName().equals(key)) {
                chain.remove(student);
                return;
            }
        }
    }

    public Student search(String key) {
        int index = hashFunction(key);
        LinkedList<Student> chain = table[index];
        for (Student student : chain) {
            if (student.getName().equals(key)) {
                return student;
            }
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            LinkedList<Student> chain = table[i];
            if (chain.isEmpty()) {
                continue;
            }
            System.out.print("Index " + i + ": ");
            for (Student student : chain) {
                System.out.print(student + " -> ");
            }
            System.out.println("null");
        }
    }
}
