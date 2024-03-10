package Q1;


import Q1.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class HuffmanCodeFile {

    public static Node buildHuffmanTree(Map<Character, Integer> frequencies) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
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

    public static Map<Character, Integer> calculateFrequencies(String filename) {
        Map<Character, Integer> frequencies = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char c = (char) currentChar;
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return frequencies;
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
        String filename = "input.txt";

        Map<Character, Integer> frequencies = calculateFrequencies(filename);
        Node root = buildHuffmanTree(frequencies);

        System.out.println("Huffman Codes: ");
        printCodes(root, "");
    }
}
