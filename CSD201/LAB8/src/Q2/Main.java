/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        String input = "ABABABA";
        LZWEncoding lzwEncoding = new LZWEncoding();
        lzwEncoding.createDictionary(input);
        lzwEncoding.compressInput(input);
        System.out.println("");
    }
}
