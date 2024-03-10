package Q1;


import Q1.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class HuffmanCodeTree {

    public static void printLeafCodes(Node root, String code) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.character + ": " + code);
        }

        printLeafCodes(root.left, code + "0");
        printLeafCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Node root = new Node('$');
        root.left = new Node('a');
        root.right = new Node('$');
        root.right.left = new Node('b');
        root.right.right = new Node('c');

        System.out.println("Huffman Codes: ");
        printLeafCodes(root, "");
    }
}