package Q1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Node {
    private char character;
    private int frequency;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.character = '\0';
        this.left = left;
        this.right = right;
    }

    public char getCharacter() {
        return character;
    }

    public int getFrequency() {
        return frequency;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
    
    public boolean isLeaf() {
        return left == null && right == null && character != '\0';
    }
}
