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
import Q1.Node;
import java.io.*;
import java.util.*;

public class HuffmanCodeBinaryTree {

    public static Node buildHuffmanTree(char[] characters, int[] frequencies) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < characters.length; i++) {
            pq.add(new Node(characters[i], frequencies[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('$', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        return pq.poll();
    }

    public static void printCodes(Node root, String code) {
        if (root == null)
            return;

        if (root.character != '$') {
            System.out.println(root.character + ": " + code);
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] characters = {'a', 'b', 'c', 'd', 'e'};
        int[] frequencies = {5, 3, 8, 2, 6};

        Node root = buildHuffmanTree(characters, frequencies);

        System.out.println("Huffman Codes: ");
        printCodes(root, "");
    }
}



