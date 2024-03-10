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

public class LZWDictionary {

    public static Map<String, Integer> createDictionary(String input) {
        Map<String, Integer> dictionary = new HashMap<>();
        int nextCode = 0;

        for (char c : input.toCharArray()) {
            String current = String.valueOf(c);
            if (!dictionary.containsKey(current)) {
                dictionary.put(current, nextCode);
                nextCode++;
            }
        }

        return dictionary;
    }

    public static void main(String[] args) {
        String input = "ABABABABA";

        Map<String, Integer> dictionary = createDictionary(input);

        System.out.println("Dictionary:");
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

