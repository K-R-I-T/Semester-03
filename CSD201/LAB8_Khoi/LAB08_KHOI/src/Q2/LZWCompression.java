/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author ACER
 */
import java.util.*;

public class LZWCompression {

    public static List<Integer> compress(String input, Map<String, Integer> dictionary) {
        List<Integer> compressedOutput = new ArrayList<>();
        int nextCode = dictionary.size();
        String current = "";

        for (char c : input.toCharArray()) {
            String currentChar = String.valueOf(c);
            String currentSequence = current + currentChar;

            if (dictionary.containsKey(currentSequence)) {
                current = currentSequence;
            } else {
                compressedOutput.add(dictionary.get(current));
                dictionary.put(currentSequence, nextCode);
                nextCode++;
                current = currentChar;
            }
        }

        compressedOutput.add(dictionary.get(current)); // Add the last code

        return compressedOutput;
    }

    public static void main(String[] args) {
        String input = "ABABABA";

        Map<String, Integer> dictionary = LZWDictionary.createDictionary(input);
        List<Integer> compressedOutput = compress(input, dictionary);

        System.out.println("Compressed Output:");
        System.out.println(compressedOutput);
    }
}

