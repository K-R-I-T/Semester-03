package Q1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */

public class Node implements Comparable<Node> {
    char character;
    int frequency;
    Node left, right;

    public Node(char character) {
        this.character = character;
        left = right = null;
    }
    
    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        left = right = null;
    }

    @Override
    public int compareTo(Node node) {
        return frequency - node.frequency;
    }
}

